package ec.cjpq.fe.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import ec.cjpq.fe.jdbc.DBConnection;

public class DBConnectionTest extends TestCase{
	
	private static final Logger log = Logger.getLogger("DBConnectionTest.class");
     
    private static final String QUERY = "SELECT * FROM fe_cola_aut WHERE tipo_comp='NC'";
 
    public void test(){
                 
        //using try-with-resources to avoid closing resources (boiler plate code)
    	Connection con = null;
    	Statement stmt = null;
    	ResultSet rs = null;
        try{
        	con = DBConnection.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(QUERY);  
             
            while(rs.next()){
                int id 				= rs.getInt("cola_id");
                String tipoComp 	= rs.getString("tipo_comp");
                String numeroSl 	= rs.getString("numero_sl");
                System.out.println(id + "," +tipoComp+ "," +numeroSl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         
    }
 
}
