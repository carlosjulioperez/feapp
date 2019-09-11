package ec.cjpq.cjfews.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ec.cjpq.fe.util.Util;

public class ArchivoUtils {

    private static Logger log = LogManager.getLogger(ArchivoUtils.class);

    public static File stringToArchivo(String rutaArchivo, String contenidoArchivo) {
        FileOutputStream fos = null;
        File archivoCreado = null;
        try {
            fos = new FileOutputStream(rutaArchivo);
            OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8");
            for (int i = 0; i < contenidoArchivo.length(); i++) {
                out.write(contenidoArchivo.charAt(i));
            }
            out.close();

            return new File(rutaArchivo);
        } catch (Exception ex) {
            log.warn(Util.stack2String(ex));
            return null;
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception ex) {
                log.warn(Util.stack2String(ex));
            }
        }
    }
    
    // public String firmarEnviarAutorizar(String archivoFirmado){
	// 	String valor = "";
	// 	//log.warn("Leyendo archivo XML...");
	// 	File f = new File(archivoFirmado);
	// 	
	// 	String claveAccesoComprobante = Util.getValorXML(f, "/*/infoTributaria/claveAcceso");
    //     if ( claveAccesoComprobante != null ){
    //     	
	//         try {
    //             
    //             RespuestaSolicitud respuestaSolicitudEnvio = new RespuestaSolicitud();
    //             
    //             //TODO
    //             respuestaSolicitudEnvio = EnvioComprobantesWs.obtenerRespuestaEnvio(f, ruc, tipoComprobante, claveDeAcceso, urlWsdl);
    //
	//             String estado = respuestaSolicitud.getEstado();
    //         	//log.warn("Estado de solicitud: " + estado);
    //
	//             if (estado.equals(Constante.RECIBIDA.toString())){
	//             	valor = autorizacion(claveAccesoComprobante);
	//             }else{
	//                 StringBuilder mensajes = new StringBuilder();
	//                 RespuestaSolicitud.Comprobantes comprobantes = respuestaSolicitud.getComprobantes();
	// 				for (Comprobante comp : comprobantes.getComprobante()) {
	// 					mensajes.append(comp.getClaveAcceso());
	// 					mensajes.append("\n");
	// 					for (ec.gob.sri.comprobantes.ws.Mensaje m : comp.getMensajes().getMensaje())
	// 						mensajes.append(m.getMensaje() + ": " + m.getInformacionAdicional() + "\n");
	// 					mensajes.append("\n");
	// 				}
	// 				String men = "Error, Los comprobantes no fueron recibidos. " + mensajes.toString(); 
	// 				log.warn(men);
	// 				valor = men;
	//             }
	//         } catch (Exception e) {
	//         	String men = Util.stack2String(e);
	//         	log.warn(men);
	//         	//log.warn("Tiempo agotado para conectarse a los servidores del SRI...");
	//             valor = men;
	//         }
    //     }else{
    //     	String men = "El archivo XML ingresado, no contiene los elementos de búsqueda apropiados..."; 
    //     	log.warn(men);
    //     	valor = men;
    //     }
    //     return valor;
	// }

    // public static RespuestaSolicitud enviar(Emisor emisor, File archivoFirmado, String ruc, String codDoc, String claveDeAcceso) {
    //     return EnvioComprobantesWs.obtenerRespuestaEnvio(
    //             archivoFirmado, ruc, codDoc, claveDeAcceso, 
    //             FormGenerales.devuelveUrlWs(emisor.getTipoAmbiente(), "RecepcionComprobantesOffline")
    //     );
    // }

}
