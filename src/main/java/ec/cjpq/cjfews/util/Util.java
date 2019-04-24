package ec.cjpq.cjfews.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.xpath.XPathConstants;

import org.apache.log4j.Logger;

import ec.cjpq.cjfews.comprobante.CampoAdicional;
import ec.cjpq.util.Utileria;

public class Util {

	private static final Logger log = Logger.getLogger(Util.class);
	
	public static boolean firmar(String archivoAFirmar, String archivoFirmado,
			String directorioDestino, String p12, String clave){
	
		return 	new Firma(archivoAFirmar, archivoFirmado, directorioDestino, p12, clave).firmar();
	}

	public static byte[] getArchivoToByte(File file) throws IOException {
		byte[] buffer = new byte[(int) file.length()];
		InputStream ios = null;
		try {
			ios = new FileInputStream(file);
			if (ios.read(buffer) == -1) {
				throw new IOException("EOF reached while trying to read the whole file");
			}
			return buffer;
		} finally {
			try {
				if (ios != null) {
					ios.close();
				}
			} catch (Exception e) {
				log.warn(Utileria.stack2String(e));			
			}
		}
	}

	/**
	 * Obtiene el valor de un campo adicional especificado en la factura
	 * @param infoAdicional
	 * @param nombre Nombre del campo adicional
	 * @return
	 */
	public static String getValorCampoAdicional(List<CampoAdicional> infoAdicional, String nombre){
		String valor = null;
		for (CampoAdicional ca: infoAdicional){
			if (ca.getNombre().equals(nombre)){
				valor = ca.getValor();
				break;
			}
		}
		return valor;
	}

	/**
	 * Devuelve la clave de acceso dependiendo de los datos del cliente (empresa)
	 * @param fecha
	 * @param tipoComprobante
	 * @param ruc
	 * @param tipoAmbiente
	 * @param serie
	 * @param secuencial
	 * @param aleatorio
	 * @return
	 */
	public static String getClaveAcceso(String fecha, String tipoComprobante, String ruc, String tipoAmbiente,
			String serie, String secuencial, String aleatorio){

		String fechaEmision = fecha.replaceAll("/", "");
		String tipoEmision = "1";

		StringBuilder sb = new StringBuilder();
		sb.append(fechaEmision);
		sb.append(tipoComprobante);
		sb.append(ruc);
		sb.append(tipoAmbiente);
		sb.append(serie);
		sb.append(secuencial);
		sb.append(aleatorio);
		sb.append(tipoEmision); //Tipo de emisión (Tabla 2, 1: Emisión normal = 1 )

		String digitoVerficador = ""+Util.getDigitoVerificadorModulo11(sb.toString()); 
		String claveAccesoGenerada = sb.toString() + digitoVerficador; 
		
		return claveAccesoGenerada;
	}

	public static int getDigitoVerificadorModulo11(String cadena) {
		cadena = invertirCadena(cadena);
        int pivote = 2;
        int longitudCadena = cadena.length();
        int cantidadTotal = 0;
        int b = 1;
        for (int i = 0; i < longitudCadena; i++) {
            if (pivote == 8) {
                pivote = 2;
            }
            int temporal = Integer.parseInt("" + cadena.substring(i, b));
            b++;
            temporal *= pivote;
            pivote++;
            cantidadTotal += temporal;
        }
        cantidadTotal = 11 - cantidadTotal % 11;
        
        if (cantidadTotal == 11)
        	cantidadTotal = 0;
        if (cantidadTotal == 10)
        	cantidadTotal = 1;
        
        return cantidadTotal;
    }

	private static String invertirCadena(String cadena) {
        String cadenaInvertida = "";
        for (int x = cadena.length() - 1; x >= 0; x--) {
            cadenaInvertida = cadenaInvertida + cadena.charAt(x);
        }
        return cadenaInvertida;
    }

	public static String getValorXML(File xmlDocument, String expression) {
		String valor = null;
		try {
			LectorXPath reader = new LectorXPath(xmlDocument.getPath());
			valor = (String) reader.leerArchivo(expression, XPathConstants.STRING);
		} catch (Exception e) {
			log.warn(Utileria.stack2String(e));
		}
		return valor;
	}
	
	public static boolean isExisteConexion(Object webService, int intentos) {
	    boolean respuesta = false;
	    for (int i=0; i<intentos; i++){
	        Object obj = webService;
	        if (obj == null)
	            return true;
	        if ( obj instanceof Exception )
	            respuesta = false;
	    }
	    return respuesta;
	}
	
}
