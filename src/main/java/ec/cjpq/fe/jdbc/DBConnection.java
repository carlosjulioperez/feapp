package ec.cjpq.fe.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
	 
    public static Connection getConnection() {
        Properties props = new Properties();
        Connection con = null;

        //TODO Actualizar
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
