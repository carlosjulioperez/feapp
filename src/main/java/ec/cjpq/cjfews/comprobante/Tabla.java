package ec.cjpq.cjfews.comprobante;

import java.io.InputStream;
import java.util.Properties;

/**
 * Clase de utilidad para obtener el valor de la tabla según el archivo tabla.properties
 *
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro
 * 2016-08-31
 */
public class Tabla {

	public static String getValor(String codigo){

        Properties props = new Properties();
        
        String resourceName = "tabla.properties"; // could also be a constant
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		String valor = null;
		try(InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
			props.load(resourceStream);
			valor = props.getProperty(codigo);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return valor;
		
	}
}
