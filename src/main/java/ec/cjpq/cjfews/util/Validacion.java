package ec.cjpq.cjfews.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.security.cert.X509Certificate;

import es.mityc.firmaJava.libreria.xades.ResultadoValidacion;
import es.mityc.firmaJava.libreria.xades.ValidarFirmaXML;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ec.cjpq.fe.util.Util;

public class Validacion {

	private static final Logger log = LogManager.getLogger(Validacion.class);

	public boolean validarArchivo(String archivo, String... imp){
		boolean valor = false;

		boolean imprimirDetalle = imp.length == 1;
		
        // Se declara la estructura de datos que almacenará el resultado de la validación
        ArrayList<ResultadoValidacion> results = null;

        // Se convierte el InputStream a Document
        InputStream is;
		try {
			is = new FileInputStream(archivo);
		} catch (FileNotFoundException e1) {
			log.warn("El archivo especificado no existe...");
			log.warn(Util.stack2String(e1));
			return false;
		}
		
        Document doc = parseaDoc(is);
        if (doc == null) {
            log.warn("Error de validación. No se pudo parsear la firma.");
            return valor;
        }
		
        // Se instancia el validador y se realiza la validación
        try {
            @SuppressWarnings("unused")
			ValidarFirmaXML vXml = new ValidarFirmaXML();
            // CDODIGO ORIGINAL: results = vXml.validar(doc, "./", null, new TimeStampValidator()) ;
            results = null;
        } catch(Exception e){
            log.warn(Util.stack2String(e));
        }
		
        // Se muestra por consola el resultado de la validación
        ResultadoValidacion result = null;
		@SuppressWarnings("null")
		Iterator<ResultadoValidacion> it = results.iterator();
        while (it.hasNext()) {
            result = it.next();
            boolean isValid = result.isValidate();
            if(isValid){
            	if (imprimirDetalle){
	                // El método getNivelValido devuelve el último nivel XAdES válido
	                log.warn("La firma es valida.\n" + result.getNivelValido() 
	                        + "\nCertificado: " + ((X509Certificate) result.getDatosFirma().getCadenaFirma().getCertificates().get(0)).getSubjectDN()
	                        + "\nFirmado el: " + result.getDatosFirma().getFechaFirma()
	                        + "\nNodos firmados: " + result.getFirmados());
            	}
                valor = isValid;
            } else {
                // El método getLog devuelve el mensaje de error que invalidó la firma
                log.warn("La firma NO es valida\n" + result.getLog());
            }
        }
        
		return valor;
	}

    /**
     * <p>
     * Parsea un documento XML y lo introduce en un DOM.
     * </p>
     * 
     * @param uriFirma
     *            URI al fichero XML
     * @return Docuemnto parseado
     */
    private Document parseaDoc(InputStream archivo) {
		
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true) ;

        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            log.warn("Error interno al parsear la firma");
            log.warn(Util.stack2String(ex));
            return null;
        }

        Document doc = null;
        try {
            doc = db.parse(archivo);
            return doc;
        } catch (SAXException ex) {
            doc = null;
        } catch (IOException ex) {
            log.warn("Error interno al validar firma");
            log.warn(Util.stack2String(ex));
        } finally {
            dbf = null;
            db = null; 
        }
		
        return null;
    }
}
