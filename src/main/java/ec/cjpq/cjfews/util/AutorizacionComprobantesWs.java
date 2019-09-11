package ec.cjpq.cjfews.util;

import com.thoughtworks.xstream.XStream;

import ec.gob.sri.comprobantes.ws.Comprobante;
import ec.gob.sri.comprobantes.ws.RecepcionComprobantesOffline;
import ec.gob.sri.comprobantes.ws.RecepcionComprobantesOfflineService;
import ec.gob.sri.comprobantes.ws.RespuestaSolicitud;
import ec.gob.sri.comprobantes.ws.aut.Autorizacion;
import ec.gob.sri.comprobantes.ws.aut.AutorizacionComprobantesOffline;
import ec.gob.sri.comprobantes.ws.aut.AutorizacionComprobantesOfflineService;
import ec.gob.sri.comprobantes.ws.aut.Mensaje;
import ec.gob.sri.comprobantes.ws.aut.RespuestaComprobante;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import lombok.Setter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ec.cjpq.cjfews.comprobante.Configuracion;
import ec.cjpq.cjfews.comprobante.factura.Factura;
import ec.cjpq.cjfews.comprobante.guia.GuiaRemision;
import ec.cjpq.cjfews.comprobante.notacredito.NotaCredito;
import ec.cjpq.cjfews.comprobante.notadebito.NotaDebito;
import ec.cjpq.cjfews.comprobante.retencion.ComprobanteRetencion;
import ec.cjpq.fe.util.Util;

public class AutorizacionComprobantesWs {

	private static Logger log = LogManager.getLogger(AutorizacionComprobantesWs.class);
	
	private Configuracion configuracion;
	
    @Setter private Factura factura;
	@Setter private GuiaRemision guiaRemision;
	@Setter private ComprobanteRetencion comprobanteRetencion;
	@Setter private NotaCredito notaCredito;
	@Setter private NotaDebito notaDebito;
	
    private static String wsRecepcion;
    private static String wsAutorizacion;

    private AutorizacionComprobantesOfflineService service;

	private String documento;
    
    public AutorizacionComprobantesWs(String wsdlLocation) {
        try {
            this.service = new AutorizacionComprobantesOfflineService(new URL(wsdlLocation), new QName("http://ec.gob.sri.ws.autorizacion", "AutorizacionComprobantesOfflineService"));
        }
        catch (Exception ex) {
            log.warn(Util.stack2String(ex));
        } 
    }
	
	public AutorizacionComprobantesWs(Configuracion configuracion, String documento){
		this.configuracion = configuracion;
		this.documento = documento;
		
		String servidor = configuracion.getCfgTipoAmbiente()==1 ? configuracion.getWsPrefijoPruebas(): configuracion.getWsPrefijoProduccion();

        this.wsRecepcion    = servidor + "/comprobantes-electronicos-ws/RecepcionComprobantesOffline?wsdl";
        this.wsAutorizacion = servidor + "/comprobantes-electronicos-ws/AutorizacionComprobantesOffline?wsdl";

	}
	
    public RespuestaComprobante llamadaWSAutorizacionInd(String claveDeAcceso) {
        RespuestaComprobante response = null;

        try {
            AutorizacionComprobantesOffline port = this.service.getAutorizacionComprobantesOfflinePort();
            response = port.autorizacionComprobante(claveDeAcceso);
        }
        catch (Exception e) {
            log.warn(Util.stack2String(e));
            return response;
        } 

        return response;
    }

	private String autorizarComprobanteIndividual(String claveDeAcceso){
		String valor = "";
        try {

			RespuestaComprobante respuesta = null;
			for (int i = 0; i < 5; i++){
                respuesta = (new AutorizacionComprobantesWs(wsAutorizacion)).llamadaWSAutorizacionInd(claveDeAcceso);
				
				if (!respuesta.getAutorizaciones().getAutorizacion().isEmpty()) {
					break;
				}
				Thread.currentThread(); Thread.sleep(300L);
			}
			
			StringBuilder mensajeRespuesta = new StringBuilder(); 
			if (respuesta != null){
			    int i = 0;
			    for (Autorizacion item : respuesta.getAutorizaciones().getAutorizacion()){
			    	
			    	//Crear el XML en base a la respuesta del SRI
					item.setComprobante("<![CDATA[" + item.getComprobante()	+ "]]>");
					
					XStream xstream = XStreamUtil.getRespuestaXStream();
					Writer writer = null;
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					writer = new OutputStreamWriter(outputStream, "UTF-8");
					writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

					xstream.toXML(item, writer);
					String xmlAutorizacion = outputStream.toString("UTF-8");
			    	
			    	mensajeRespuesta.append(item.getEstado()+"\n");
			    	
			    	if ( i == 0 && item.getEstado().equals(Constante.AUTORIZADO.toString()) ){
			    		
			    		String men1 = "El comprobante ha sido AUTORIZADO...\n"; 
			    		//log.warn(men1);
			    		mensajeRespuesta.append(men1);
			    		
			    		String numeroAutorizacion 	= item.getNumeroAutorizacion();
			    		String fechaAutorizacion	= item.getFechaAutorizacion().toString();
			    		
			    		men1 = "Número de autorización: " + numeroAutorizacion + "\n";
			    		//log.warn(men1);
			    		mensajeRespuesta.append(men1);
			    		
			    		men1 = "Fecha de autorización : " + fechaAutorizacion + "\n";
			    		//log.warn(men1);
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
			    		
			    		//log.warn(men1);
			    		mensajeRespuesta.append(men1);
			    		//**************************************************************************************************** 
			    		
			    		men1 = "Archivo autorizado    : " + documento + "\n";
			    		//log.warn(men1);
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
			    	
			    	if ( item.getEstado().equals(Constante.NO_AUTORIZADO.toString())){
			            ArchivoUtils.stringToArchivo(configuracion.getDirectorioNoAutorizados() + File.separator + documento, xmlAutorizacion);
			    		mensajeRespuesta.append("\n" + obtieneMensajesAutorizacion(item));
			            break;
			    	}

                    //2019-08-21
			    	if ( item.getEstado().equals(Constante.EN_PROCESO.toString())){
			    		mensajeRespuesta.append("\n" + obtieneMensajesAutorizacion(item));
			            break;
			    	}
			    	i++;
			    }
			    log.warn(mensajeRespuesta.toString());
			}
			valor = mensajeRespuesta.toString();

        } catch (Exception e) {
			valor = Util.stack2String(e);
			log.warn(valor);
		}
        return valor;
	}

    public static RespuestaComprobante autorizarComprobante(String claveDeAcceso, String tipoAmbiente) throws RespuestaAutorizacionException { 
        return (new AutorizacionComprobantesWs(wsAutorizacion)).llamadaWSAutorizacionInd(claveDeAcceso); 
    }


	public String consumoWs(String archivoFirmado){
		String valor = "";
		//log.warn("Leyendo archivo XML...");
		File f = new File(archivoFirmado);
		
		String claveAccesoComprobante = Util.getValorXML(f, "/*/infoTributaria/claveAcceso");
		String codDoc                 = Util.getValorXML(f, "/*/infoTributaria/codDoc");
        String tipoComprobante        = codDoc.substring(1);

        if ( claveAccesoComprobante != null ){
            RespuestaSolicitud respuestaSolicitudEnvio = new RespuestaSolicitud();
        	
	        try {

	        	//RecepcionComprobantesOffline port1 = new RecepcionComprobantesOfflineService(getURL(wsRecepcion), qNRecepcion).getRecepcionComprobantesOfflinePort();

                //TODO
	            //RespuestaSolicitud respuestaSolicitud = port1.validarComprobante(Util.getArchivoToByte(new File(archivoFirmado)));
                respuestaSolicitudEnvio = EnvioComprobantesWs.obtenerRespuestaEnvio(f, configuracion.getEmisorRuc(), tipoComprobante, claveAccesoComprobante, FormGenerales.devuelveUrlWs(this.emisor.getTipoAmbiente(), "RecepcionComprobantesOffline"));

	        	
	            String estado = respuestaSolicitudEnvio.getEstado();
            	//log.warn("Estado de solicitud: " + estado);

	            if (estado.equals(Constante.RECIBIDA.toString())){
	            	valor = autorizarComprobanteIndividual(claveAccesoComprobante);
	            }else{
	                StringBuilder mensajes = new StringBuilder();
	                RespuestaSolicitud.Comprobantes comprobantes = respuestaSolicitudEnvio.getComprobantes();
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
	

	/**
	 * Obtiene los mensajes del WS Autorizacion
	 * @param autorizacion
	 * @return
	 */
	private static String obtieneMensajesAutorizacion(Autorizacion autorizacion){
		StringBuilder mensaje = new StringBuilder();
		for (Mensaje m : autorizacion.getMensajes().getMensaje()) {
			if (m.getInformacionAdicional() != null) {
				mensaje.append("\n" + m.getMensaje() + ": " + m.getInformacionAdicional()); continue;
            }
			mensaje.append("\n" + m.getMensaje());
		}
		return mensaje.toString();
	}

	private static URL getURL(String wsdl){
		URL valor = null;
		try {
			valor = new URL(wsdl);
		} catch (MalformedURLException e) {
			log.warn(Util.stack2String(e));
		}
		return valor;
	}
	
}
