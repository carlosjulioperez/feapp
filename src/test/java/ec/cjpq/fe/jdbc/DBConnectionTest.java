package ec.cjpq.fe.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ec.cjpq.fe.jdbc.DBConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class DBConnectionTest{
	
	private static final Logger log = LogManager.getLogger(DBConnectionTest.class);
     
    private static final String QUERY = "SELECT * FROM fe_cola_aut WHERE tipo_comp='NC'";
 
    @Test
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
