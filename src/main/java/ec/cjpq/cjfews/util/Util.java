package ec.cjpq.cjfews.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.xpath.XPathConstants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ec.cjpq.cjfews.comprobante.CampoAdicional;

public class Util {

	private static final Logger log = LogManager.getLogger(Util.class);
	
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
				log.warn(stack2String(e));			
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
			log.warn(stack2String(e));
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
	
    public static String getColumna(Object columna){
		return columna==null ? new String(): columna.toString();
	}

	public static BigDecimal parseToBigDecimal(String valor){
		return new BigDecimal( parseToDouble (valor) );
	}

	public static double parseToDouble(String valor){
		double numero=0;
		try{
			numero = Double.parseDouble(valor);
		}catch(Exception e){
			numero = 0;
		}
		return numero;
	}

	public static int parseToInt(String valor){
		int numero=0;
		try{
			numero = Integer.parseInt(valor);
		}catch(Exception e){
			numero = 0;
		}
		return numero;
	}
	
    public static long parseToLong(String valor){
		long numero=0;
		try{
			numero = Long.parseLong(valor);
		}catch(Exception e){
			numero = 0;
		}
		return numero;
	}

	public static short parseToShort(String valor){
		short numero=0;
		try{
			numero = Short.parseShort(valor);
		}catch(Exception e){
			numero = 0;
		}
		return numero;
	}	

    public static String stack2String(Exception e){
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);

            Calendar cal = new GregorianCalendar();
            StringBuilder sb = new StringBuilder();
            sb.append("\r\n====== MENSAJE DEL SISTEMA [");
            sb.append(new Timestamp(cal.getTimeInMillis()).toString());
            sb.append("] \r\n" + sw.toString() + "======\r\n" );

            return sb.toString();
        } catch (Exception e1) {
            String mensaje = "Stack2StringErroneo: " + e1.getMessage(); 
            log.info(mensaje);
            return mensaje;
        }
    }
}
