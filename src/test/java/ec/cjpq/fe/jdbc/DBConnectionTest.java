package ec.cjpq.fe.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Test;

import ec.cjpq.fe.jdbc.DBConnection;

public class DBConnectionTest{
	
	private static final Logger log = LogManager.getLogger(DBConnectionTest.class);
     
    private static final String QUERY1 = "SELECT * FROM fe_cola_aut limit 10";
    private static final String QUERY2 = "SELECT * FROM defaults";
 
    @Test
    public void test(){
                 
        //using try-with-resources to avoid closing resources (boiler plate code)
    	Connection con = null;
    	Statement stmt = null;
    	ResultSet rs = null;
        try{
        	//con = DBConnection.getConnection();
        	con = DBConnection.getConnection("/tmp/db.properties");
            stmt = con.createStatement();
            rs = stmt.executeQuery(QUERY2);  

            while(rs.next()){

                // QUERY1
                // int id 				= rs.getInt("cola_id");
                // String tipoComp 	= rs.getString("tipo_comp");
                // String numeroSl 	= rs.getString("numero_sl");
                // System.out.println(id + "," +tipoComp+ "," +numeroSl);
                
                // QUERY2
                System.out.println(rs.getString("fldvalue"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         
    }
 
}
