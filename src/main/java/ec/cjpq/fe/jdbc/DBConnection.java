package ec.cjpq.fe.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
	 
    public static Connection getConnection() {
        Properties props = new Properties();
        Connection con = null;

        String resourceName = "dbConnection.properties"; // could also be a constant
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try(InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
			props.load(resourceStream);
 
            // load the Driver Class
            Class.forName(props.getProperty("hibernate.connection.driver_class"));
 
            // create the connection now
            con = DriverManager.getConnection(props.getProperty("hibernate.connection.url"),
                    props.getProperty("hibernate.connection.username"),
                    props.getProperty("hibernate.connection.password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
