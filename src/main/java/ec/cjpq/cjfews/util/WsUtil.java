package ec.cjpq.cjfews.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import com.thoughtworks.xstream.XStream;
import ec.cjpq.cjfews.comprobante.Configuracion;
import ec.cjpq.cjfews.comprobante.factura.Factura;
import ec.cjpq.cjfews.comprobante.guia.GuiaRemision;
import ec.cjpq.cjfews.comprobante.notacredito.NotaCredito;
import ec.cjpq.cjfews.comprobante.notadebito.NotaDebito;
import ec.cjpq.cjfews.comprobante.retencion.ComprobanteRetencion;
import ec.gob.sri.comprobantes.ws.Comprobante;
import ec.gob.sri.comprobantes.ws.RecepcionComprobantesOffline;
import ec.gob.sri.comprobantes.ws.RecepcionComprobantesOfflineService;
import ec.gob.sri.comprobantes.ws.RespuestaSolicitud;
import ec.gob.sri.comprobantes.ws.aut.Autorizacion;
import ec.gob.sri.comprobantes.ws.aut.AutorizacionComprobantesOffline;
import ec.gob.sri.comprobantes.ws.aut.AutorizacionComprobantesOfflineService;
import ec.gob.sri.comprobantes.ws.aut.RespuestaComprobante;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WsUtil {

	private static Logger log = LogManager.getLogger(WsUtil.class);
	
	private Configuracion configuracion;
	private Factura factura = null;
	private GuiaRemision guiaRemision = null;
	private ComprobanteRetencion comprobanteRetencion = null;
	private NotaCredito notaCredito = null;
	private NotaDebito notaDebito = null;
	
	private String wsRecepcion;		
	private String wsAutorizacion;
	
    //private QName qNRecepcion 		= new QName("http://ec.gob.sri.ws.recepcion", "RecepcionComprobantesService");
	//private QName qNAutorizacion 	= new QName("http://ec.gob.sri.ws.autorizacion", "AutorizacionComprobantesService");
	
    //2018-02-02
    private QName qNRecepcion 		= new QName("http://ec.gob.sri.ws.recepcion", "RecepcionComprobantesOfflineService");
	private QName qNAutorizacion 	= new QName("http://ec.gob.sri.ws.autorizacion", "AutorizacionComprobantesOfflineService");
	
	private String documento;
	
	public WsUtil(Configuracion configuracion, String documento){
		this.configuracion = configuracion;
		this.documento = documento;
		
		String servidor = configuracion.getCfgTipoAmbiente()==1 ? configuracion.getWsPrefijoPruebas(): configuracion.getWsPrefijoProduccion();
		
		//this.wsRecepcion 	= servidor + "/comprobantes-electronicos-ws/RecepcionComprobantes?wsdl";
		//this.wsAutorizacion	= servidor + "/comprobantes-electronicos-ws/AutorizacionComprobantes?wsdl";

	    //2018-02-02
        this.wsRecepcion 	= servidor + "/comprobantes-electronicos-ws/RecepcionComprobantesOffline?wsdl";
		this.wsAutorizacion	= servidor + "/comprobantes-electronicos-ws/AutorizacionComprobantesOffline?wsdl";
	}
	
	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public void setNotaCredito(NotaCredito notaCredito) {
		this.notaCredito = notaCredito;
	}
	
	public void setNotaDebito(NotaDebito notaDebito) {
		this.notaDebito = notaDebito;
	}
	
	public void setGuiaRemision(GuiaRemision guiaRemision) {
		this.guiaRemision = guiaRemision;
	}

	public void setComprobanteRetencion(ComprobanteRetencion comprobanteRetencion){
		this.comprobanteRetencion = comprobanteRetencion;
	}

	public String consumoWs(String archivoFirmado){
		String valor = "";
		log.warn("Leyendo archivo XML...");
		File f = new File(archivoFirmado);
		
		String claveAccesoComprobante = Util.getValorXML(f, "/*/infoTributaria/claveAcceso");
        if ( claveAccesoComprobante != null ){
        	
        	log.warn("Intentando conectarme con Web Service del SRI...");
//        	int intentos = 5;
//        	if ( ! Util.isExisteConexion(getWebServiceRecepcion(wsRecepcion), intentos) ){
//        		log.warn("El servicio RECEPCION DE COMPROBANTES no está disponible...");
//        		return;
//        	}
        	
        	log.warn("Invocando al WS de RECEPCION DE COMPROBANTES...");
	        try {

	        	//RecepcionComprobantes port1 = new RecepcionComprobantesService(getURL(wsRecepcion), qNRecepcion).getRecepcionComprobantesPort();
	        	RecepcionComprobantesOffline port1 = new RecepcionComprobantesOfflineService(getURL(wsRecepcion), qNRecepcion).getRecepcionComprobantesOfflinePort();

				//VALIDAR CUANDO WS DEL SRI ESTE LENTO
				((BindingProvider) port1).getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", 5000);
				((BindingProvider) port1).getRequestContext().put("com.sun.xml.internal.ws.request.timeout", 5000);

                log.warn(Util.getArchivoToByte(new File(archivoFirmado)));
	            RespuestaSolicitud respuestaSolicitud = port1.validarComprobante(Util.getArchivoToByte(new File(archivoFirmado)));
	        	
	            String estado = respuestaSolicitud.getEstado();
            	//log.warn("Estado de solicitud: " + estado);

	            if (estado.equals(Constante.RECIBIDA.toString())){
//	            	if ( ! Util.isExisteConexion(getWebServiceAutorizacion(wsAutorizacion), intentos) ){
//	            		log.warn("El servicio AUTORIZACION DE COMPROBANTES no está disponible...");
//	            		return;
//	            	}
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
	
	private String autorizacion(String claveAcceso){
		String valor = "";
        try {

        	//AutorizacionComprobantes port2 = new AutorizacionComprobantesService(getURL(wsAutorizacion), qNAutorizacion).getAutorizacionComprobantesPort();
            
            //2018-02-02
        	AutorizacionComprobantesOffline port2 = new AutorizacionComprobantesOfflineService(getURL(wsAutorizacion), qNAutorizacion).getAutorizacionComprobantesOfflinePort();
			log.warn("Realizando proceso de Autorización...");
			RespuestaComprobante respuestaAutorizacion = null;
			for (int i = 0; i < 5; i++){
				respuestaAutorizacion = port2.autorizacionComprobante(claveAcceso);
				
				log.warn(String.format("Intento %s, registros consultados %s: ", i+1, respuestaAutorizacion.getAutorizaciones().getAutorizacion().size()));
				if (!respuestaAutorizacion.getAutorizaciones().getAutorizacion().isEmpty()) {
					break;
				}
				Thread.currentThread(); Thread.sleep(300L);
			}
			//log.warn( "Clave de acceso consultada: " + respuestaAutorizacion.getClaveAccesoConsultada() );
			
			StringBuilder mensajeRespuesta = new StringBuilder(); 
			if (respuestaAutorizacion != null){
			    int i = 0;
			    for (Autorizacion item : respuestaAutorizacion.getAutorizaciones().getAutorizacion()){
			    	
			    	//Crear el XML en base a la respuesta del SRI
					item.setComprobante("<![CDATA[" + item.getComprobante()	+ "]]>");
					
					XStream xstream = XStreamUtil.getRespuestaXStream();
					Writer writer = null;
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					writer = new OutputStreamWriter(outputStream, "UTF-8");
					writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

					xstream.toXML(item, writer);
					String xmlAutorizacion = outputStream.toString("UTF-8");
			    	
			    	String estado = item.getEstado();
			    	mensajeRespuesta.append(estado+"\n");
			    	
			    	// Se asegura que sea el primer mensaje devuelto...
			    	if ( (i == 0) && estado.equals(Constante.AUTORIZADO.toString()) ){
			    		
			    		String men1 = "El comprobante ha sido AUTORIZADO...\n"; 
			    		log.warn(men1);
			    		mensajeRespuesta.append(men1);
			    		
			    		String numeroAutorizacion 	= item.getNumeroAutorizacion();
			    		String fechaAutorizacion	= item.getFechaAutorizacion().toString();
			    		
			    		men1 = "Número de autorización: " + numeroAutorizacion + "\n";
			    		log.warn(men1);
			    		mensajeRespuesta.append(men1);
			    		
			    		men1 = "Fecha de autorización : " + fechaAutorizacion + "\n";
			    		log.warn(men1);
			    		mensajeRespuesta.append(men1);
			    		
			    		//**************************************************************************************************** 
			    		//2016-02-24
			    		men1 = "Número de secuencia   : ";
			    		
			    		if ( factura!=null )
			    			men1 += factura.getInfoTributaria().getEstab()+"-"+factura.getInfoTributaria().getPtoEmi()+"-"+factura.getInfoTributaria().getSecuencial() + "\n";

			    		if ( guiaRemision!=null )
			    			men1 += guiaRemision.getInfoTributaria().getEstab()+"-"+guiaRemision.getInfoTributaria().getPtoEmi()+"-"+guiaRemision.getInfoTributaria().getSecuencial() + "\n";
			    		
			    		if ( comprobanteRetencion!=null )
			    			men1 += comprobanteRetencion.getInfoTributaria().getEstab()+"-"+comprobanteRetencion.getInfoTributaria().getPtoEmi()+"-"+comprobanteRetencion.getInfoTributaria().getSecuencial() + "\n";
			    		
			    		if ( notaCredito!=null )
			    			men1 += notaCredito.getInfoTributaria().getEstab()+"-"+notaCredito.getInfoTributaria().getPtoEmi()+"-"+notaCredito.getInfoTributaria().getSecuencial() + "\n";
			    		
			    		if ( notaDebito!=null )
			    			men1 += notaDebito.getInfoTributaria().getEstab()+"-"+notaDebito.getInfoTributaria().getPtoEmi()+"-"+notaDebito.getInfoTributaria().getSecuencial() + "\n";
			    		
			    		log.warn(men1);
			    		mensajeRespuesta.append(men1);
			    		//**************************************************************************************************** 
			    		
			    		men1 = "Archivo autorizado    : " + documento + "\n";
			    		log.warn(men1);
			    		mensajeRespuesta.append(men1);
			    		
			    		RideUtil rideUtil = new RideUtil(configuracion, documento);

			    		String archivoXmlAutorizado = configuracion.getDirectorioAutorizados() + File.separator + documento + ".xml"; 
			            ArchivoUtils.stringToArchivo(archivoXmlAutorizado, xmlAutorizacion);

		            	if ( factura!=null )
		            		rideUtil.generar(factura, numeroAutorizacion, fechaAutorizacion, archivoXmlAutorizado, true);

		            	if ( guiaRemision!=null ){
		            		log.warn(">>> Iniciando el proceso de RIDE para GR...");
		            		rideUtil.generar(guiaRemision, numeroAutorizacion, fechaAutorizacion, archivoXmlAutorizado, true);
		            	}
		            	
		            	if ( comprobanteRetencion!=null )
		            		rideUtil.generar(comprobanteRetencion, numeroAutorizacion, fechaAutorizacion, archivoXmlAutorizado, true);

		            	if ( notaCredito!=null )
		            		rideUtil.generar(notaCredito, numeroAutorizacion, fechaAutorizacion, archivoXmlAutorizado, true);

		            	if ( notaDebito!=null )
		            		rideUtil.generar(notaDebito, numeroAutorizacion, fechaAutorizacion, archivoXmlAutorizado, true);

			    		break;
			    	}
			    	
			    	if ( estado.equals("NO AUTORIZADO")){
			            ArchivoUtils.stringToArchivo(configuracion.getDirectorioNoAutorizados() + File.separator + documento, xmlAutorizacion);

			    		mensajeRespuesta.append("\n" + getMensajesAutorizacion(item));
			            break;
			    	}
			    	i++;
			    	
			    }
			    log.warn(mensajeRespuesta.toString());
			}
			if ((respuestaAutorizacion == null) || (respuestaAutorizacion.getAutorizaciones().getAutorizacion().isEmpty() )) {
				log.warn("Respuesta devuelta: ");
				for (Autorizacion item : respuestaAutorizacion.getAutorizaciones().getAutorizacion())
			    	log.warn(item.getEstado());
				String men1 = "TRANSMITIDO SIN RESPUESTA. Ha ocurrido un error en el proceso de la Autorización";
				log.warn(men1);
				mensajeRespuesta.append(men1);
			}
			valor = mensajeRespuesta.toString();

        } catch (Exception e) {
			valor = Util.stack2String(e);
			log.warn(valor);
		}
        return valor;
	}

	/**
	 * Obtiene los mensajes del WS Autorizacion
	 * @param autorizacion
	 * @return
	 */
	public static String getMensajesAutorizacion(Autorizacion autorizacion){
		StringBuilder retorno = new StringBuilder();
		for (ec.gob.sri.comprobantes.ws.aut.Mensaje mensaje : autorizacion.getMensajes().getMensaje()) {
			if (mensaje.getInformacionAdicional() != null) 
				retorno.append("\n" + mensaje.getMensaje() + ": " + mensaje.getInformacionAdicional());
			else 
				retorno.append("\n" + mensaje.getMensaje());
		}
		return retorno.toString();
	}

	public static Object getWebServiceAutorizacion(String wsdl) {
	    try {
    		//new AutorizacionComprobantesService( getURL(wsdl) );
            //2018-02-02
    		new AutorizacionComprobantesOfflineService( getURL(wsdl) );
	        return null;
	    } catch (Exception ws) {
	        return ws;
	    }
	}

	public static Object getWebServiceRecepcion(String wsdl) {
	    try {
    		//new RecepcionComprobantesService( getURL(wsdl) );
            //2018-02-02
    		new RecepcionComprobantesOfflineService( getURL(wsdl) );
	        return null;
	    } catch (Exception ws) {
	        return ws;
	    }
	}
	
	public static URL getURL(String wsdl){
		URL valor = null;
		try {
			valor = new URL(wsdl);
		} catch (MalformedURLException e) {
			log.warn(Util.stack2String(e));
		}
		return valor;
	}
	
}
