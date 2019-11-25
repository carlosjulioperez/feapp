package ec.cjpq.fe.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {

    private static Properties props = new Properties();
    private static Connection con;
    
    public static Connection getConnection(String... args) {

        if (args.length > 0){
            try (InputStream input = new FileInputStream( args[0] )) {
                props.load(input);
            } catch (IOException e) { e.printStackTrace(); }
        }else{
            try(InputStream resourceStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties")) {
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
