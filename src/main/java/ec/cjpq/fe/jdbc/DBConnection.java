package ec.cjpq.fe.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Clase de utilería para realizar la conexión JDBC a través del archivo <b>jdbc.properties</b>
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * http://www.journaldev.com/2471/jdbc-example-tutorial-drivers-connection-statement-resultset
 * 
 * 2015-05-26
 * 2015-06-24 Cambio a java 1.6
 * 2016-08-29 Migración a Maven
 */
public class DBConnection {
	 
    public static Connection getConnection() {
        Properties props = new Properties();
        Connection con = null;
        
        String resourceName = "jdbc.properties"; // could also be a constant
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try(InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
			props.load(resourceStream);
 
            // load the Driver Class
            Class.forName(props.getProperty("DB_DRIVER_CLASS"));
 
            // create the connection now
            con = DriverManager.getConnection(props.getProperty("DB_URL"),
                    props.getProperty("DB_USERNAME"),
                    props.getProperty("DB_PASSWORD"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
