package ec.cjpq.fe.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ec.cjpq.cjfews.comprobante.notadebito.Motivo;
import ec.cjpq.fe.bean.DatosAp;
import ec.cjpq.fe.bean.DatosAr;
import ec.cjpq.fe.bean.DatosGuiaRemision;
import ec.cjpq.fe.bean.DatosRetencion;
import ec.cjpq.fe.model.Department;
import ec.cjpq.fe.model.EmployeeId;
import ec.cjpq.fe.model.FeColaAut;
import ec.cjpq.fe.model.FeConfig;
import ec.cjpq.fe.util.Comprobante;
import ec.cjpq.fe.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

public class EntidadDaoTest{
	
	private static Logger log = LogManager.getLogger(EntidadDaoTest.class);

	public void testGetDatosGuiaRemision(){
		try {
			DatosGuiaRemision o = new EntidadDao().getDatosGuiaRemision(111435);
			assertEquals(o.getTransportistaId(), "0918056664001");
		} catch (Exception e) {
			e.printStackTrace();
		} //64483
		//assertEquals(o.getTransportistaId(), "transportista ID") ;
	}

	public void testGetConsultaGuiaRemision(){
		try {
			DatosGuiaRemision o = new EntidadDao().getConsultaGuiaRemision("004-002-000003270");
			log.warn(o.getId());
			//assertEquals(o.getId(), );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void printRetencion(DatosRetencion o){
		log.warn( o.getId()+" "+o.getName()+" "+o.getIdprov()+" "+o.getEmail()+" "+o.getCc()+" "+o.getPhone()+" "+o.getTipodocId()+" "+o.getEstab()+" "+o.getPtoemi()+" "+String.format("%09d", Util.parseToInt(o.getSec()) )+" "+o.getTransdate()+" "+o.getTiporet()+" "+o.getTiporetId()+" "+o.getSecret() );
	}
	
	private void printAr(DatosAr o){
		log.warn( o.getId()+" "+o.getInvnumber()+" "+o.getTransdate()+" "+o.getDescription()+" "+o.getNetamount()+" "+o.getAmount()+" "+o.getPonumber()+" "+o.getOrdnumber()+" "+o.getNotes() );
		log.warn( o.getName()+" "+o.getTaxnumber()+" "+o.getEmail()+" "+o.getCc()+" "+o.getPhone() );
	}
	
	private void printAp(DatosAp o){
		log.warn( o.getId()+" "+o.getInvnumber()+" "+o.getTransdate()+" "+o.getDescription()+" "+o.getNetamount()+" "+o.getAmount()+" "+o.getPonumber()+" "+o.getNotes() );
		log.warn( o.getName()+" "+o.getGifiAccno()+" "+o.getEmail()+" "+o.getCc()+" "+o.getPhone() );
	}

	public void testGetConsultaRetencion(){
		try {
			//List<RetencionBean> lista = new EntidadDao().getConsultaRetencion( "%SERRANO ROMERO%", "FAC", "3941", "16-05-2016", "16-05-2016" ); 
			//List<DatosRetencion> lista = new EntidadDao().getConsultaRetencion( "%TAME%", "", "", "06-01-2016", "06-01-2016", 0, 20 );
			//log.warn("Records #:" + new EntidadDao().getConsultaRetencionSize( "%TAME%", "", "", "", "" ) );
			
			DatosRetencion dr = new DatosRetencion();
			dr.setName( "%TAME%" );
			//~ for (DatosRetencion o: new EntidadDao().getConsultaRetencionList(dr, 0, 20 ) )
				//~ printRetencion(o);
		
			//Buscar el elemento seleccionado de la cola...
			dr = new DatosRetencion();
			dr.setId(128120);
//			dr.setIdprov("1790369145001");
//			dr.setTipodocId("01");
//			dr.setEstab("001");
//			dr.setPtoemi("002");
//			dr.setSec("14416");
			for (DatosRetencion o: new EntidadDao().getConsultaRetencionList(dr, 0, 0 ) )
				printRetencion(o);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testGetConsultaAr(){
		try {
			DatosAr dar = new DatosAr();
			
			log.warn("Mostrando datos de NC...");
			dar.setTipo("4"); //NC
			for (DatosAr o: new EntidadDao().getConsultaArList(dar, 0, 20 ) )
				printAr(o);
		
			log.warn("Mostrando datos de ND...");
			dar = new DatosAr();
			dar.setTipo("5"); //ND
			for (DatosAr o: new EntidadDao().getConsultaArList(dar, 0, 20 ) )
				printAr(o);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testGetConsultaAp(){
		try {
			
			String []numero = {"123504", "122762"};
			DatosAp dap = new DatosAp();
			
			Integer id = new Integer( numero[0] );
			
//			dap.setDescription("N/D");
//			dap.setName( "APRACOM" );
			dap.setId(id);

			for (DatosAp o: new EntidadDao().getConsultaApList(dap, 0, 20 ) )
				printAp(o);
			
			List<Motivo>motivos = new EntidadDao().getMotivosAp(id);
			for (Motivo o: motivos){
				System.out.println(o.getRazon());
				System.out.println(o.getValor().trim());
			}
			
			Object []datos = new EntidadDao().getImpuestoAr(id);
			if (datos != null){
				System.out.println(datos[0]);
				System.out.println(datos[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testGetDatosArInvoice(){
		try {
			String numero[] = { "001-001-000000042" };
			Object []datos = new EntidadDao().getDatosArInvoice( numero [0]);
			System.out.println("Fecha: " + datos[0]);
			System.out.println("Id   : " + datos[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testListaDepartamentos(){
		Department o = new EntidadDao().getDepartments(11272); 
		assertEquals(o.getId().getDescription(), "Guayaquil");
	}
	
	public void testConfiguracion(){
		FeConfig config = new EntidadDao().getFeConfig((short) 1);
		//assertEquals(config.getEmiRazSocial(), "APRACOM S.A.");
        System.out.println(config.getEmiRazSocial());
	    log.warn( config.getEmiRazSocial() );
	}

	public void testGetP12Employee(){
		EmployeeId employeeId = new EntidadDao().getEmployeeByLogin("ap_cromero");
		assertEquals(employeeId.getP12Archivo(), "/usr/local/fe/p12s/ana_maria_valladares_lopez.p12");
	}

	public void testGetFactura(){
		int n[]={659};
		
		boolean imprimirPorConsola = true;
		
		int numeroSqlLedger = n[0];
		
		Object []factura 		= new EntidadDao().getFactura(numeroSqlLedger);
		Object []cabecera 		= (Object[]) factura[0];
		
		String campoId = Util.getColumna(cabecera[0]);
		assertEquals(campoId, new Integer(numeroSqlLedger).toString()) ;

		if (imprimirPorConsola){
			List <Object[]>detalles	= (List<Object[]>) factura[1];
	
	        if (cabecera!=null){
	        	String serialInterno = Util.getColumna(cabecera[1]);
	        	String serial= serialInterno.substring(serialInterno.lastIndexOf("-")+1);

				String notasInternas = Util.getColumna(cabecera[14]);

	        	System.out.println("Número     : " + serialInterno);
	        	System.out.println("Id         : " + campoId);
	        	System.out.println("Serial     : "  + Util.getSecuencial(serial));
	        	System.out.println("Fecha      : " + Util.getColumna(cabecera[2]));
	        	System.out.println("Email      : " + Util.getColumna(cabecera[5]));
	        	System.out.println("Teléfono   : " + Util.getColumna(cabecera[6]));
	        	System.out.println("Notas (GR) : " + Util.getColumna(cabecera[10]));
	        	System.out.println("Notas Int. : " + notasInternas);
	        	System.out.println("customer.cc: " + Util.getColumna(cabecera[12]));
	        	System.out.println("description: " + Util.getColumna(cabecera[13]));
				
				System.out.println("\n=== Formas de pago ===");

				//Convertir los ENTER de MS WINDOWS
				notasInternas.replaceAll("\r\n", "\n");
			
				//Leer las formas de pago
				for (String linea: notasInternas.split("\n") ){
					System.out.println(linea);
					System.out.println(linea.substring(0, 2));
				}

	        }
	
			System.out.println("=== D E T A L L E S ===");
	        for (Object[] detalle: detalles){
	        	System.out.println("Códigos    : " + detalle[0] + " " + detalle[1] );
	        	System.out.println("Producto   : " + detalle[2]);
	        	System.out.println("Precio     : " + detalle[4]);
	        	System.out.println("% IVA      : " + detalle[5]);
	        	System.out.println("% IVA R    : " + Util.parseToBigDecimal(Util.getColumna(detalle[5])));
	        	System.out.println("Desc.      : " + detalle[6]);
	        }
		}
	}

	public void _actualizarSecuenciaFactura(){
		int numero = new EntidadDao().getSecuenciaFactura((short)1);
		if (numero > 0)
			System.out.println( "Nueva secuencia de factura: "+numero );
	}
	
	public void _actualizarSecuenciaFacturaEmpleado(){
		int numero = new EntidadDao().getSecuenciaComprobanteEmpleado(Comprobante.FACTURA, "ap_cromero");
		if (numero > 0)
			System.out.println( "Nueva secuencia de factura de empleado: "+numero );
	}

	public void testActualizarFactura(){
		new EntidadDao().actualizarFactura(new Integer(31430), "1811201504381909921791550010325194521", "001-001-005243");
	}
	
	public void testListadoAutorizarComprobante(){
		List <FeColaAut> seleccionados = new EntidadDao().getListadoFeColaAut("WHERE colaId=14");
		for (FeColaAut o: seleccionados){
			log.warn(o.getNumeroSl());
		}
	}
	
	public void testActualizarDatosRetencion(){
		String fecha = "2016-06-13T00:39:59-05:00";
		fecha = fecha.substring(0, 10);
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse("2016-06-13");
			//System.out.println(date);
			new EntidadDao().actualizarDatosRetencion(new Integer(122757), "1306201600395909921791550010373144914", "004-001-000000003", date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

    @Test
    public void runTest(){
        testConfiguracion();
        //testGetDatosArInvoice();
        //testGetFactura();
    }
	
}
