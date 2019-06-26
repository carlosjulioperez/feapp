package ec.cjpq.fe.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Properties props = new Properties();
    private static Connection con;
    private static String fileName = "hibernate.properties";
    
    public static Connection getConnection(String... filePath) {

        if (filePath.length > 0){
            try (InputStream input = new FileInputStream( filePath+fileName )) {
                props.load(input);
            } catch (IOException e) { e.printStackTrace(); }
        }else{
            // ClassLoader loader = Thread.currentThread().getContextClassLoader();
            // try(InputStream resourceStream = loader.getResourceAsStream("hibernate.properties")) {
            try(InputStream resourceStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName)) {
                props.load(resourceStream);
            } catch (IOException e) { e.printStackTrace(); }
        }

        try{
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
