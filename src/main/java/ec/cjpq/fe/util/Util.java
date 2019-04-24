package ec.cjpq.fe.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.Clients;

/**
 * Clase de utilidades generales para preparar los objetos Bean previos para
 * enviar al WS
 * 
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro
 *         099 3208265 2015-03-24 2015-04-02 2015-06-11 
 * 2015-10-14 Ajustes en BigDecimal
 * 2015-10-19 transformarNuevaLineaEnEspacioEnBlanco
 * 2015-12-29 isNoVacia()
 */
public class Util {

	/**
	 * Obtiene la representación String de la columa indicada considerando que
	 * puede ser nula.
	 * 
	 * @param columna
	 *            (Object: Columna del ResultSet a devolver)
	 * @return
	 */
	public static String getColumna(Object columna) {
		return columna == null ? new String() : columna.toString().trim();
	}

	/**
	 * Obtiene la cadena de la fecha del sistema en el formato <b>dd/MM/yyyy</b>
	 * @return
	 */
	public static String getFechaSistema(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(new Date());
	}

	/**
	 * Devuelve el número secuencia de acuerdo al esquema del SRI
	 * 
	 * @param dato
	 * @return
	 */
	public static String getSecuencial(String dato) {
		int numero = Util.parseToInt(dato);
		return StringUtils.leftPad("" + numero, 9, "0");
	}

	/**
	 * Comprueba que la cadena no sea nula o vacia
	 * @param cadena
	 * @return
	 */
	public static boolean isCadenaVacia(String cadena){
		return cadena.isEmpty() || cadena==null;
	}
	
	/**
	 * Muestra una ventana de alerta de <i>JavaScript</i> con el mensaje
	 * especificado.
	 * 
	 * @param mensaje
	 *            (String: Mensaje a presentar)
	 */
	public static void mostrarMensaje(String mensaje) {
		Clients.evalJavaScript("alert('" + mensaje + "')");
	}

	/**
	 * Convierte un String a BigDecimal
	 * 
	 * @param valor
	 *            (String: Cadena que representa el valor a convetir)
	 * @return BigDecimal equivalente de la cadena
	 */
	public static BigDecimal parseToBigDecimal(String valor) {
		return new BigDecimal(valor);
	}

	/**
	 * Convierte un String a Double
	 * 
	 * @param valor
	 *            (String: Cadena que representa el valor a convetir)
	 * @return Double equivalente de la cadena
	 */
	public static Double parseToDouble(String valor) {
		return new Double(valor);
	}

	/**
	 * Convierte un String a tipo primitivo int
	 * 
	 * @param valor
	 *            (String: Cadena que representa el valor a convetir)
	 * @return int equivalente de la cadena
	 */
	public static int parseToInt(String valor) {
		int numero = 0;
		try {
			numero = Integer.parseInt(valor);
		} catch (Exception e) {
			numero = 0;
		}
		return numero;
	}

	/**
	 * Devuelve el mensaje completo de una Excepcion como String
	 * 
	 * @param e
	 *            (Exception: Excepción ocurrida)
	 * @return (String, String del mensaje de error)
	 */
	public static String stack2String(Exception e) {
		try {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);

			Calendar cal = new GregorianCalendar();
			StringBuilder sb = new StringBuilder();
			sb.append("\r\n====== EXCEPCION DEL SISTEMA [");
			sb.append(Sessions.getCurrent().getRemoteAddr() + " ");
			sb.append(new Timestamp(cal.getTimeInMillis()).toString());
			sb.append("] \r\n" + sw.toString() + "======\r\n");

			return sb.toString();
		} catch (Exception e2) {
			return "Stack2string erróneo: " + e2.getMessage();
		}
	}

	/**
	 * Transformar el caracter nueva línea (\n) en un espacio en blanco
	 * @param cadena
	 * @return
	 */
	public static String transformarNuevaLineaEnEspacioEnBlanco(String cadena){
		return cadena.replace("\n", " ").replace("\r", " "); 
	}

	/**
	 * Quitar el caracter nueva línea (\n) de un String
	 * @param cadena
	 * @return
	 * 2016-08-04
	 */
	public static String quitarNuevaLinea(String cadena){
		return cadena.replace("\n", "").replace("\r", ""); 
	}
}
