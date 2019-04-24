package ec.cjpq.fe.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionBurned {
	
	private final static String DB_DRIVER_CLASS	= "org.postgresql.Driver"; 
	private final static String DB_URL 			= "jdbc:postgresql://localhost:5432/oymar";
	//private final static String DB_URL 			= "jdbc:postgresql://192.168.56.101:5432/oymar";
	private final static String DB_USERNAME 	= "sql-ledger"; 
	private final static String DB_PASSWORD		= ""; 
	 
    public static Connection getConnection() {
        Connection con = null;
        try {
            // load the Driver Class
            Class.forName(DB_DRIVER_CLASS);
            // create the connection now
            con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
