package ec.cjpq.fe.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * Poner en cola los comprobantes desde Sql-Ledger
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * http://www.mkyong.com/jdbc/jdbc-preparestatement-example-insert-a-record/
 *
 * 2015-05-26
 * 2015-06-01
 * 2016-03-17 cambiar ponerCola de private a public
 * 2016-06-12 Agregar RE al proceso ponerColaRetencion() y reorganización de código
 * 2016-07-17 Agregar NC al proceso
 * 2016-07-27 Agregar ND al proceso
 * 2016-08-05 Cambio de funcionalidad para NC y ND
 */
public class ColaAut {

	private static final Logger log = Logger.getLogger(ColaAut.class);
	private static String fecha="";
	private static String nombreProveedor="";
	
	public static void main(String[] args) {
		
		if (args.length==0){
			StringBuilder sb = new StringBuilder();
			sb.append("\n");
			sb.append("BC - COLA DE AUTORIZACION PARA SISTEMA DE FACTURACION ELECTRONICA \n");
			sb.append("\n");
			sb.append("AYUDA:\n");
			sb.append("======\n");
			sb.append("Enviar el comprobante a la cola:\n");
			sb.append("   java -jar fecola.jar <tipo_comprobante> <numero_transaccion_SQL-Ledger>\n\n");
			sb.append("\n");
			System.out.println(sb.toString());
			return;
		}else{
			String tipo 	= args[0];
			String numero 	= args[1];
			try {
				ponerCola(tipo, numero);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static String ponerColaRetencion(String... args) throws SQLException {
		fecha	= args[1];
		nombreProveedor	= args[2];
		return ponerCola("RE", args[0]); //numero
	}
	
	public static String ponerCola(String tipo, String numero) throws SQLException {
		String mensaje = "";
		
		Connection dbConnection = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;

		String sqlInsertCola = "INSERT INTO fe_cola_aut (tipo_comp, numero_sl, fecha, total, cliente, autorizado) VALUES (?, ?, ?, ?, ?, false) "; 
		String sqlQueryCola 	= "select count(*) total from fe_cola_aut where tipo_comp = ? and numero_sl = ?";
		String sqlQueryFactura 	= "select c.email, ar.customer_id, c.name, to_char(ar.transdate, 'YYYY/MM/dd') fecha, ar.amount from ar, customer c where ar.customer_id = c.id and ar.id= ?";
	
		try {
			String mensaje1 = "Comprobante %s # %s enviado a la cola de autorizaciones...";
			dbConnection =  DBConnectionBurned.getConnection();

			ps1 = dbConnection.prepareStatement(sqlQueryCola);
			ps1.setString(1, tipo);
			ps1.setString(2, numero);
			ResultSet rs1 = ps1.executeQuery();
			if (rs1.next()){ 
				long total = rs1.getLong("total");
				if (total > 0){
					mensaje = String.format("El comprobante %s # %s YA ha sido enviado a la cola de autorizaciones...", tipo, numero);
					log.warn(mensaje);
				}else{
					
					if (tipo.equals("FA") || tipo.equals("GR") || tipo.equals("NC") || tipo.equals("ND")){
						//Validación de correo electrónico
						ps2 = dbConnection.prepareStatement(sqlQueryFactura);
						ps2.setInt(1, Integer.parseInt(numero));
						ResultSet rs2 = ps2.executeQuery();
						if (rs2.next()) {
							String correo 		= rs2.getString("email");
							String codigo 		= rs2.getString("customer_id");
							String nombre 		= rs2.getString("name");
							String fecha		= rs2.getString("fecha");
							BigDecimal amount 	= rs2.getBigDecimal("amount"); 
							
							System.out.println("Correo ["+correo+"]");
							
							if (correo==null || correo.trim().length()==0 ){
								mensaje = String.format("El cliente [%s / %s] no tiene definido un e-mail. No se envía la factura a la cola...", codigo, nombre);
								log.warn(mensaje);
							}else{
								//Inserción en la cola
								ps3 = dbConnection.prepareStatement(sqlInsertCola);
								ps3.setString 		(1, tipo);
								ps3.setString 		(2, numero);
								ps3.setString 		(3, fecha);
								ps3.setBigDecimal	(4, amount);
								ps3.setString 		(5, nombre);
								
								ps3.executeUpdate();
								mensaje = String.format(mensaje1, tipo, numero);
								log.warn(mensaje);
							}
						}else{
							mensaje = String.format("El comprobante ingresado %s # %s NO existe...", tipo, numero);
							log.warn(mensaje);
						}
					} else if (tipo.equals("RE")){
						//La validación del correo del proveedor ya se realizó desde la pantalla de consulta de retenciones
						ps2 = dbConnection.prepareStatement(sqlInsertCola);
						ps2.setString 		(1, tipo);
						ps2.setString 		(2, numero);
						ps2.setString 		(3, fecha);
						ps2.setBigDecimal	(4, new BigDecimal(0));
						ps2.setString 		(5, nombreProveedor);
						ps2.executeUpdate();
						mensaje = String.format(mensaje1, tipo, numero);
						log.warn(mensaje);
					}
				}
			}else{
				mensaje = "No se ha procesado el registro...";
				log.warn(mensaje);
			}
		} catch (Exception e) {
			log.warn(e.getMessage());
		} finally {
			if (ps1 != null) 
				ps1.close();
			if (ps2 != null) 
				ps2.close();
			if (ps3 != null) 
				ps3.close();
			
			if (dbConnection != null)
				dbConnection.close();
		}
		return mensaje;
	}
}
