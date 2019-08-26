package ec.cjpq.cjfews.util;

import ec.gob.sri.comprobantes.ws.Comprobante;
import ec.gob.sri.comprobantes.ws.Mensaje;
import ec.gob.sri.comprobantes.ws.RecepcionComprobantesOffline;
import ec.gob.sri.comprobantes.ws.RecepcionComprobantesOfflineService;
import ec.gob.sri.comprobantes.ws.RespuestaSolicitud;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ec.cjpq.fe.util.Util;

public class EnvioComprobantesWs {

	private static Logger log = LogManager.getLogger(EnvioComprobantesWs.class);
    private static RecepcionComprobantesOfflineService service;

    public EnvioComprobantesWs(String wsdlLocation) throws MalformedURLException, WebServiceException {
        URL url = new URL(wsdlLocation);
        QName qname = new QName("http://ec.gob.sri.ws.recepcion", "RecepcionComprobantesOfflineService");
        service = new RecepcionComprobantesOfflineService(url, qname);
    }

    public static final Object webService(String wsdlLocation) {
        try {
            QName qname = new QName("http://ec.gob.sri.ws.recepcion", "RecepcionComprobantesOfflineService");
            URL url = new URL(wsdlLocation);
            service = new RecepcionComprobantesOfflineService(url, qname);
            return null;
        } catch (MalformedURLException ex) {
            log.warn(Util.stack2String(ex));
            return ex;
        } catch (WebServiceException ws) {
            log.warn(Util.stack2String(ws));
            return ws;
        } 
    }

    public RespuestaSolicitud enviarComprobante(String ruc, File xmlFile, String tipoComprobante, String versionXsd) {
        RespuestaSolicitud response = null;
        try {
            RecepcionComprobantesOffline port = service.getRecepcionComprobantesOfflinePort();
            response = port.validarComprobante(Util.getArchivoToByte(xmlFile));
        }
        catch (Exception e) {
            log.warn(Util.stack2String(e));
            response = new RespuestaSolicitud();
            response.setEstado(e.getMessage());
            return response;
        } 
        return response;
    }

    //TODO EnvioComprobante
    public RespuestaSolicitud enviarComprobanteLotes(String ruc, File xml, String tipoComprobante, String versionXsd) {
        RespuestaSolicitud response = null;
        try {
            RecepcionComprobantesOffline port = service.getRecepcionComprobantesOfflinePort();
            response = port.validarComprobante(Util.getArchivoToByte(xml));
        } catch (Exception e) {
            log.warn(Util.stack2String(e));
            response = new RespuestaSolicitud();
            response.setEstado(e.getMessage());
            return response;
        } 
        return response;
    }

    public static RespuestaSolicitud obtenerRespuestaEnvio(File archivo, String ruc, String tipoComprobante, String claveDeAcceso, String urlWsdl) {
        RespuestaSolicitud respuesta = new RespuestaSolicitud();
        EnvioComprobantesWs cliente = null;
        try {
            cliente = new EnvioComprobantesWs(urlWsdl);
        } catch (Exception ex) {
            log.warn(Util.stack2String(ex));
            respuesta.setEstado(ex.getMessage());
            return respuesta;
        } 
        return cliente.enviarComprobante(ruc, archivo, tipoComprobante, "1.0.0");
    }

    public static RespuestaSolicitud obtenerRespuestaEnvio1(File archivo, String ruc, String tipoComprobante, String claveDeAcceso, String urlWsdl) {
        RespuestaSolicitud respuesta = new RespuestaSolicitud();
        EnvioComprobantesWs cliente = null;
        try {
            cliente = new EnvioComprobantesWs(urlWsdl);
        } catch (Exception ex) {
            log.warn(Util.stack2String(ex));
            respuesta.setEstado(ex.getMessage());
            return respuesta;
        } 
        return cliente.enviarComprobante(ruc, archivo, tipoComprobante, "1.0.0");
    }

    public static String obtenerMensajeRespuesta(RespuestaSolicitud respuesta) {
        StringBuilder mensajeDesplegable = new StringBuilder();
        if (respuesta.getEstado().equals(Constante.DEVUELTA.toString()) == true) {

            RespuestaSolicitud.Comprobantes comprobantes = respuesta.getComprobantes();
            for (Comprobante comp : comprobantes.getComprobante()) {
                mensajeDesplegable.append(comp.getClaveAcceso());
                mensajeDesplegable.append("\n");
                for (Mensaje m : comp.getMensajes().getMensaje()) {
                    mensajeDesplegable.append(m.getMensaje()).append(" :\n");
                    mensajeDesplegable.append((m.getInformacionAdicional() != null) ? m.getInformacionAdicional() : "");
                    mensajeDesplegable.append("\n");
                } 
                mensajeDesplegable.append("\n");
            } 
        } 

        return mensajeDesplegable.toString();
    }
}
