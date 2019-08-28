package ec.cjpq.cjfews.util;

import ec.gob.sri.comprobantes.ws.RecepcionComprobantesOffline;
import ec.gob.sri.comprobantes.ws.RecepcionComprobantesOfflineService;
import ec.gob.sri.comprobantes.ws.RespuestaSolicitud;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Random;
import javax.xml.ws.BindingProvider;

import org.apache.commons.lang.StringUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ec.cjpq.cjfews.comprobante.Configuracion;
import ec.cjpq.cjfews.comprobante.XmlUtil;
import ec.cjpq.cjfews.comprobante.factura.Factura;
import ec.cjpq.cjfews.comprobante.guia.GuiaRemision;
import ec.cjpq.cjfews.comprobante.notacredito.NotaCredito;
import ec.cjpq.cjfews.comprobante.notadebito.NotaDebito;
import ec.cjpq.cjfews.comprobante.retencion.ComprobanteRetencion;
import ec.cjpq.fe.util.Comprobante;
import ec.cjpq.fe.util.Util;

public class ProcesoUtil {
	
	private static Logger log = LogManager.getLogger(ProcesoUtil.class);
	// Considerar la fecha de emisión (sistema) en la clave de acceso para todos los compribantes electrónicos
	//Determinar si esto origina el error de secuencial registrado...

    private String getClaveInterna(){
        return "12345678";
    }
   
	public String firmarEnviarAutorizar(String archivoFirmado){
		String valor = "";
		//log.warn("Leyendo archivo XML...");
		File f = new File(archivoFirmado);
		
		String claveAccesoComprobante = Util.getValorXML(f, "/*/infoTributaria/claveAcceso");
        if ( claveAccesoComprobante != null ){
        	
	        try {

	        	RecepcionComprobantesOffline port1 = new RecepcionComprobantesOfflineService(getURL(wsRecepcion), qNRecepcion).getRecepcionComprobantesOfflinePort();

				//VALIDAR CUANDO WS DEL SRI ESTE LENTO
				((BindingProvider) port1).getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", 5000);
				((BindingProvider) port1).getRequestContext().put("com.sun.xml.internal.ws.request.timeout", 5000);

                //TODO
	            RespuestaSolicitud respuestaSolicitud = port1.validarComprobante(Util.getArchivoToByte(new File(archivoFirmado)));
	        	
	            String estado = respuestaSolicitud.getEstado();
            	//log.warn("Estado de solicitud: " + estado);

	            if (estado.equals(Constante.RECIBIDA.toString())){
	            	valor = autorizacion(claveAccesoComprobante);
	            }else{
	                StringBuilder mensajes = new StringBuilder();
	                RespuestaSolicitud.Comprobantes comprobantes = respuestaSolicitud.getComprobantes();
					for (Comprobante comp : comprobantes.getComprobante()) {
						mensajes.append(comp.getClaveAcceso());
						mensajes.append("\n");
						for (ec.gob.sri.comprobantes.ws.Mensaje m : comp.getMensajes().getMensaje())
							mensajes.append(m.getMensaje() + ": " + m.getInformacionAdicional() + "\n");
						mensajes.append("\n");
					}
					String men = "Error, Los comprobantes no fueron recibidos. " + mensajes.toString(); 
					log.warn(men);
					valor = men;
	            }
	        } catch (Exception e) {
	        	String men = Util.stack2String(e);
	        	log.warn(men);
	        	//log.warn("Tiempo agotado para conectarse a los servidores del SRI...");
	            valor = men;
	        }
        }else{
        	String men = "El archivo XML ingresado, no contiene los elementos de búsqueda apropiados..."; 
        	log.warn(men);
        	valor = men;
        }
        return valor;
	}

    //2019-08-22
    //https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java
    //public String getClaveInterna(int longitud) {
    //    //String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    //    String SALTCHARS = "1234567890";
    //    StringBuilder salt = new StringBuilder();
    //    Random rnd = new Random();
    //    while (salt.length() < longitud) { // length of the random string.
    //        int index = (int) (rnd.nextFloat() * SALTCHARS.length());
    //        salt.append(SALTCHARS.charAt(index));
    //    }
    //    return salt.toString();
    //} 

	public String procesarFactura(Factura factura, Configuracion c){
		String retorno = null;
		try{
			
			String fechaEmision = factura.getInfoFactura().getFechaEmision().replaceAll("/", "");
			
            //Generar la clave de acceso...
            /*
			Random rand = new Random();
			String claveAcceso = Util.getClaveAcceso(
					factura.getInfoFactura().getFechaEmision(), 
					factura.getInfoTributaria().getCodDoc(), 
					factura.getInfoTributaria().getRuc(),
					factura.getInfoTributaria().getAmbiente(),
					factura.getInfoTributaria().getEstab()+factura.getInfoTributaria().getPtoEmi(),
					factura.getInfoTributaria().getSecuencial(),
					StringUtils.left(""+Math.abs(rand.nextInt()),8) //Aleatorio
			);
            */

            // 2018-05-29 Cambio en la generación de clave de acceso (SRI)
            String serie = factura.getInfoTributaria().getEstab()+factura.getInfoTributaria().getPtoEmi();

            String claveAcceso = (new ClaveDeAcceso()).generaClave(
					fechaEmision, 
					factura.getInfoTributaria().getCodDoc(), 
					factura.getInfoTributaria().getRuc(),
					factura.getInfoTributaria().getAmbiente(),
					factura.getInfoTributaria().getEstab()+factura.getInfoTributaria().getPtoEmi(),
					factura.getInfoTributaria().getSecuencial(),
					getClaveInterna(),
                    "1");
			
            factura.getInfoTributaria().setClaveAcceso(claveAcceso);
			//log.warn("Clave de acceso: " + claveAcceso);

			String documento = "FA-"+factura.getInfoFactura().getIdentificacionComprador()+"-"+
			fechaEmision +"-"+
			factura.getInfoTributaria().getEstab()+factura.getInfoTributaria().getPtoEmi()+factura.getInfoTributaria().getSecuencial();
			
			String xmlGenerado 	= c.getDirectorioGenerados() + File.separator + documento + ".xml";
			String xmlFirmado	= documento + ".xml"; 

			//log.warn("Documento a firmar: " + xmlFirmado);
			
			OutputStream outputStream = new FileOutputStream(xmlGenerado);
			Writer writer = new OutputStreamWriter(outputStream, Charset.forName("UTF-8"));
			XmlUtil.getFacturaXStream().toXML(factura, writer);

			retorno = "Factura generada de " + c.getEmisorRazonSocial()+": "+ xmlGenerado;
			//log.warn("Resultado: " + retorno);
			
			//Determinar si se emplea eToken para firmar...
			boolean valor = false;
			// Se usa el token si no se ha especificado la ruta del archivo P12
			if (c.getArchivoP12Ruta() == null){
				String retornoFirma = X509Utils.firmaValidaArchivo(new File(xmlGenerado), c.getDirectorioFirmados(), c.getEmisorRuc(), Constante.BCE_IKEY2032.toString(), c.getArchivoP12Clave());
				if (retornoFirma == null)
					valor = true;
				else
					log.warn(retornoFirma);
			}else{
				// Acá se usa el proceso por archivo P12
				valor = Util.firmar(xmlGenerado, xmlFirmado, c.getDirectorioFirmados(), c.getArchivoP12Ruta(), c.getArchivoP12Clave() );
			}

			if (valor) {
				xmlFirmado = c.getDirectorioFirmados() + File.separator	+ xmlFirmado;
				//log.warn("Archivo firmado en: " + xmlFirmado);

				AutorizacionComprobantesWs ws = new AutorizacionComprobantesWs(c, documento);
				ws.setFactura(factura);
				retorno = ws.consumoWs(xmlFirmado);
			} else
				log.warn("No se pudo firmar la Factura XML");

		}catch (Exception e) {
			log.warn( Util.stack2String(e));
		}
		return retorno;
	}

	public String procesarGuiaRemision(GuiaRemision guiaRemision, Configuracion c){
		String retorno = null;
		try{

            String fechaEmision = guiaRemision.getInfoGuiaRemision().getFechaIniTransporte().replaceAll("/", "");

			//Generar la clave de acceso...
            /*
			Random rand = new Random();
			String claveAcceso = Util.getClaveAcceso(
					guiaRemision.getInfoGuiaRemision().getFechaIniTransporte(), 
					guiaRemision.getInfoTributaria().getCodDoc(), 
					guiaRemision.getInfoTributaria().getRuc(),
					guiaRemision.getInfoTributaria().getAmbiente(),
					guiaRemision.getInfoTributaria().getEstab()+guiaRemision.getInfoTributaria().getPtoEmi(),
					guiaRemision.getInfoTributaria().getSecuencial(),
					StringUtils.left(""+Math.abs(rand.nextInt()),8) //Aleatorio
			);
            */
            //2018-05-31 Cambio en la generación de clave de acceso (SRI)

            String claveAcceso = (new ClaveDeAcceso()).generaClave(
                    fechaEmision,
					guiaRemision.getInfoTributaria().getCodDoc(), 
					guiaRemision.getInfoTributaria().getRuc(),
					guiaRemision.getInfoTributaria().getAmbiente(),
					guiaRemision.getInfoTributaria().getEstab()+guiaRemision.getInfoTributaria().getPtoEmi(),
					guiaRemision.getInfoTributaria().getSecuencial(),
					getClaveInterna(),
                    "1");

			guiaRemision.getInfoTributaria().setClaveAcceso(claveAcceso);
			
			String documento = "GR-"+guiaRemision.getInfoGuiaRemision().getRucTransportista() +"-"+
					fechaEmision +"-"+
					guiaRemision.getInfoTributaria().getEstab()+guiaRemision.getInfoTributaria().getPtoEmi()+guiaRemision.getInfoTributaria().getSecuencial();
			
			String xmlGenerado 	= c.getDirectorioGenerados() + File.separator + documento + ".xml";
			String xmlFirmado	= documento + ".xml"; 
			
			OutputStream outputStream = new FileOutputStream(xmlGenerado);
			Writer writer = new OutputStreamWriter(outputStream, Charset.forName("UTF-8"));
			XmlUtil.getGuiaRemisionXStream().toXML(guiaRemision, writer);

			retorno = "Guía de remisión generada de " + c.getEmisorRazonSocial()+": "+ xmlGenerado;

			if ( Util.firmar(xmlGenerado, xmlFirmado, c.getDirectorioFirmados(), c.getArchivoP12Ruta(), c.getArchivoP12Clave() ) ){
				xmlFirmado = c.getDirectorioFirmados() + File.separator	+ xmlFirmado;
				log.warn("Archivo firmado en: " + xmlFirmado);

				AutorizacionComprobantesWs ws = new AutorizacionComprobantesWs(c, documento);
				ws.setGuiaRemision(guiaRemision);
				retorno = ws.consumoWs(xmlFirmado);
			} else
				log.warn("No se pudo firmar la GR XML");
			
		}catch (Exception e) {
			log.warn( Util.stack2String(e));
		}
		return retorno;
	}
	
	public String procesarComprobanteRetencion(ComprobanteRetencion comprobanteRetencion, Configuracion c){
		String retorno = null;
		try{

			//Generar la clave de acceso...
			// Modelo para Fecha de Emisión...

			String fechaEmision = comprobanteRetencion.getInfoCompRetencion().getFechaEmision().replaceAll("/", "");
            
            //2018-05-31 Cambio en la generación de clave de acceso (SRI)
		    /*	
			Random rand = new Random();
			String claveAcceso = Util.getClaveAcceso(
					fechaEmision,
					comprobanteRetencion.getInfoTributaria().getCodDoc(), 
					comprobanteRetencion.getInfoTributaria().getRuc(),
					comprobanteRetencion.getInfoTributaria().getAmbiente(),
					comprobanteRetencion.getInfoTributaria().getEstab()+comprobanteRetencion.getInfoTributaria().getPtoEmi(),
					comprobanteRetencion.getInfoTributaria().getSecuencial(),
					StringUtils.left(""+Math.abs(rand.nextInt()),8) //Aleatorio
			);
            */

            String claveAcceso = (new ClaveDeAcceso()).generaClave(
					fechaEmision,
					comprobanteRetencion.getInfoTributaria().getCodDoc(), 
					comprobanteRetencion.getInfoTributaria().getRuc(),
					comprobanteRetencion.getInfoTributaria().getAmbiente(),
					comprobanteRetencion.getInfoTributaria().getEstab()+comprobanteRetencion.getInfoTributaria().getPtoEmi(),
					comprobanteRetencion.getInfoTributaria().getSecuencial(),
					getClaveInterna(),
                    "1");

			comprobanteRetencion.getInfoTributaria().setClaveAcceso(claveAcceso);
			
			String documento = "RE-"+comprobanteRetencion.getInfoCompRetencion().getIdentificacionSujetoRetenido()+"-"+
					fechaEmision +"-"+
					comprobanteRetencion.getInfoTributaria().getEstab()+comprobanteRetencion.getInfoTributaria().getPtoEmi()+comprobanteRetencion.getInfoTributaria().getSecuencial();
			
			String xmlGenerado 	= c.getDirectorioGenerados() + File.separator + documento + ".xml";
			String xmlFirmado	= documento + ".xml"; 
			
			OutputStream outputStream = new FileOutputStream(xmlGenerado);
			Writer writer = new OutputStreamWriter(outputStream, Charset.forName("UTF-8"));
			XmlUtil.getComprobanteRetencionXStream().toXML(comprobanteRetencion, writer);

			retorno = "Comprobante de Retención generado de " + c.getEmisorRazonSocial()+": "+ xmlGenerado;

			if ( Util.firmar(xmlGenerado, xmlFirmado, c.getDirectorioFirmados(), c.getArchivoP12Ruta(), c.getArchivoP12Clave() ) ){
				xmlFirmado = c.getDirectorioFirmados() + File.separator	+ xmlFirmado;
				log.warn("Archivo firmado en: " + xmlFirmado);

				AutorizacionComprobantesWs ws = new AutorizacionComprobantesWs(c, documento);
				ws.setComprobanteRetencion(comprobanteRetencion);
				retorno = ws.consumoWs(xmlFirmado);
			} else
				log.warn("No se pudo firmar la RE XML");
			
		}catch (Exception e) {
			log.warn( Util.stack2String(e));
		}
		return retorno;
	}

	public String procesarNotaCredito(NotaCredito notaCredito, Configuracion c){
		String retorno = null;
		try{
			
			//Generar la clave de acceso...
			String fechaEmision = notaCredito.getInfoNotaCredito().getFechaEmision().replaceAll("/", "");
		    
            /*
			Random rand = new Random();
			String claveAcceso = Util.getClaveAcceso(
					fechaEmision,
					notaCredito.getInfoTributaria().getCodDoc(), 
					notaCredito.getInfoTributaria().getRuc(),
					notaCredito.getInfoTributaria().getAmbiente(),
					notaCredito.getInfoTributaria().getEstab()+notaCredito.getInfoTributaria().getPtoEmi(),
					notaCredito.getInfoTributaria().getSecuencial(),
					StringUtils.left(""+Math.abs(rand.nextInt()),8) //Aleatorio
			);
            */
            String claveAcceso = (new ClaveDeAcceso()).generaClave(
					fechaEmision,
					notaCredito.getInfoTributaria().getCodDoc(), 
					notaCredito.getInfoTributaria().getRuc(),
					notaCredito.getInfoTributaria().getAmbiente(),
					notaCredito.getInfoTributaria().getEstab()+notaCredito.getInfoTributaria().getPtoEmi(),
					notaCredito.getInfoTributaria().getSecuencial(),
					getClaveInterna(),
                    "1");

			notaCredito.getInfoTributaria().setClaveAcceso(claveAcceso);
			//log.warn("Clave de acceso: " + claveAcceso);

			String documento = "NC-"+notaCredito.getInfoNotaCredito().getIdentificacionComprador()+"-"+
			fechaEmision +"-"+
			notaCredito.getInfoTributaria().getEstab()+notaCredito.getInfoTributaria().getPtoEmi()+notaCredito.getInfoTributaria().getSecuencial();
			
			String xmlGenerado 	= c.getDirectorioGenerados() + File.separator + documento + ".xml";
			String xmlFirmado	= documento + ".xml"; 

			OutputStream outputStream = new FileOutputStream(xmlGenerado);
			Writer writer = new OutputStreamWriter(outputStream, Charset.forName("UTF-8"));
			XmlUtil.getNotaCreditoXStream().toXML(notaCredito, writer);

			retorno = "Nota de Crédito generada de " + c.getEmisorRazonSocial()+": "+ xmlGenerado;
			
			if ( Util.firmar(xmlGenerado, xmlFirmado, c.getDirectorioFirmados(), c.getArchivoP12Ruta(), c.getArchivoP12Clave() ) ){
				xmlFirmado = c.getDirectorioFirmados() + File.separator	+ xmlFirmado;
				log.warn("Archivo firmado en: " + xmlFirmado);

				AutorizacionComprobantesWs ws = new AutorizacionComprobantesWs(c, documento);
				ws.setNotaCredito(notaCredito);
				retorno = ws.consumoWs(xmlFirmado);
			} else
				log.warn("No se pudo firmar la NC XML");

		}catch (Exception e) {
			log.warn( Util.stack2String(e));
		}
		return retorno;
	}
	
	public String procesarNotaDebito(NotaDebito notaDebito, Configuracion c){
		String retorno = null;
		try{
			
			//Generar la clave de acceso...
			String fechaEmision = notaDebito.getInfoNotaDebito().getFechaEmision().replaceAll("/", "");
			
            /*
			Random rand = new Random();
			String claveAcceso = Util.getClaveAcceso(
					fechaEmision,
					notaDebito.getInfoTributaria().getCodDoc(), 
					notaDebito.getInfoTributaria().getRuc(),
					notaDebito.getInfoTributaria().getAmbiente(),
					notaDebito.getInfoTributaria().getEstab()+notaDebito.getInfoTributaria().getPtoEmi(),
					notaDebito.getInfoTributaria().getSecuencial(),
					StringUtils.left(""+Math.abs(rand.nextInt()),8) //Aleatorio
			);
            */

            // 2018-05-31 Cambio en la generación de clave de acceso (SRI)
            String claveAcceso = (new ClaveDeAcceso()).generaClave(
					fechaEmision,
					notaDebito.getInfoTributaria().getCodDoc(), 
					notaDebito.getInfoTributaria().getRuc(),
					notaDebito.getInfoTributaria().getAmbiente(),
					notaDebito.getInfoTributaria().getEstab()+notaDebito.getInfoTributaria().getPtoEmi(),
					notaDebito.getInfoTributaria().getSecuencial(),
					getClaveInterna(),
                    "1");

			notaDebito.getInfoTributaria().setClaveAcceso(claveAcceso);
			//log.warn("Clave de acceso: " + claveAcceso);

			String documento = "ND-"+notaDebito.getInfoNotaDebito().getIdentificacionComprador()+"-"+
			fechaEmision +"-"+
			notaDebito.getInfoTributaria().getEstab()+notaDebito.getInfoTributaria().getPtoEmi()+notaDebito.getInfoTributaria().getSecuencial();
			
			String xmlGenerado 	= c.getDirectorioGenerados() + File.separator + documento + ".xml";
			String xmlFirmado	= documento + ".xml"; 

			OutputStream outputStream = new FileOutputStream(xmlGenerado);
			Writer writer = new OutputStreamWriter(outputStream, Charset.forName("UTF-8"));
			XmlUtil.getNotaDebitoXStream().toXML(notaDebito, writer);

			retorno = "Nota de Débito generada de " + c.getEmisorRazonSocial()+": "+ xmlGenerado;
			
			if ( Util.firmar(xmlGenerado, xmlFirmado, c.getDirectorioFirmados(), c.getArchivoP12Ruta(), c.getArchivoP12Clave() ) ){
				xmlFirmado = c.getDirectorioFirmados() + File.separator	+ xmlFirmado;
				log.warn("Archivo firmado en: " + xmlFirmado);

				AutorizacionComprobantesWs ws = new AutorizacionComprobantesWs(c, documento);
				ws.setNotaDebito(notaDebito);
				retorno = ws.consumoWs(xmlFirmado);
			} else
				log.warn("No se pudo firmar la NC XML");

		}catch (Exception e) {
			log.warn( Util.stack2String(e));
		}
		return retorno;
	}
}
