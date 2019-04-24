package ec.cjpq.fe.util;

import java.math.BigDecimal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;

import ec.cjpq.cjfews.comprobante.Configuracion;
import ec.cjpq.cjfews.comprobante.InfoTributaria;
import ec.cjpq.cjfews.comprobante.factura.Factura;
import ec.cjpq.fe.util.Comprobante;
import ec.cjpq.fe.util.Util;

public class CodigoTest extends TestCase{
	
	private String getMensaje(){
		
		StringBuilder sb = new StringBuilder();
		sb.append("AUTORIZADO\n");
		sb.append("El comprobante ha sido AUTORIZADO...\n");
		sb.append("Número de autorización: 2406201516210213600021700010280897932\n");
		sb.append("Fecha de autorización : 2015-06-24T16:21:02.046-05:00\n");
		sb.append("Número de secuencia   : 004-001-000000025\n");
		
		return sb.toString();
	}
	
	private void getVarArgs(String... args){
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
	}
	

	public void _testGetVarArgs(){
		getVarArgs("uno", "dos", "tres");
	}
	
	public void _testFecha(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		System.out.println(dateFormat.format(new Date()));
	}
	
	public void _testPeridoFiscal(){
		String fecha = "05-12-2014";
		System.out.println( fecha.substring(3).replaceAll("-", "/") );
		System.out.println( fecha.substring(0,2) );
		
		System.out.println( "Formato para fecha transdate en transacciones:" );
		System.out.println( fecha.replaceAll("-", "/") );
	}
	
	public void _test(){
		System.out.println(Comprobante.FACTURA.toString());
		System.out.println("FA-123".substring(0,2));
		
		BigDecimal porcIva 	= Util.parseToBigDecimal("0.12");
		assertTrue( porcIva.compareTo(BigDecimal.valueOf(0.12)) == 0 );
		
		String msg = getMensaje();
		
		String[] cadena = msg.split("\n");
		if (cadena[0].equals("AUTORIZADO")){
			System.out.println( cadena[2].substring(24) );
			System.out.println( cadena[3].substring(24) );
			System.out.println( cadena[4].substring(24) );
		}
		
		metodo1();
		
		Object o = new String("ESPACIO   ");
		System.out.println(o.toString().trim()+"vacio");
	}
	
	private void metodo1(){
		Configuracion c = new Configuracion();
		c.setEmailCc("VACIO");
		cambiarCC(c);
		
		System.out.println(c.getEmailCc());
	}
	
	private void cambiarCC(Configuracion c){
		c.setEmailCc("CAMBIADO");
	}

	public void _testGetFechaSQLLedger(){
		String fecha = "2015-06-24T16:21:02.046-05:00";
		System.out.println(fecha.substring(0, 10));
	}
	
	public void _testSecuenciaFactura(){
		String secuencia = "004-002-000003557";
		String[] cadena = secuencia.split("-");

		Factura factura = new Factura();

		InfoTributaria it = new InfoTributaria();
		it.setEstab			(cadena[0]);
		it.setPtoEmi		(cadena[1]);
		it.setSecuencial	(cadena[2]);
		factura.setInfoTributaria(it);
		
		System.out.println(factura.getInfoTributaria().getEstab());
		System.out.println(factura.getInfoTributaria().getPtoEmi());
		System.out.println(factura.getInfoTributaria().getSecuencial());
	}
	
	public void _testConversionFecha(){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse("2016-06-13");
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void _testDoubles(){
		Double valor = new Double(0);
		Double v1 = new Double(10);
		Double v2 = new Double(20);
		Double v3 = new Double(30);
		
		valor += v1 + v2 + v3;
		System.out.println(valor);
	}
	
	public void _testFormaPago(){

		String notasInternas = "FP,19,900,30,dias\nFP,16,260.20,5,dias"; 

		String arreglo[] = new String[5]; //Es hasta 4 pero considero 5 porque el usuario puede poner comas en vez de punto decimal
		for (String linea: notasInternas.split("\n") ){
			if ( linea.substring(0, 2).equals("FP") ){
				String[] cadena = linea.split(",");
				
				int i = 0; //0=FP, 1=19, 2=900, ...
				for (String valor: cadena){
					if (i>0)
						arreglo[i-1] = valor;
					i++;
				}
			}
		}
		System.out.println(arreglo[0]);
		System.out.println(arreglo[1]);
		System.out.println(arreglo[2]);
		System.out.println(arreglo[3]);

	}
    
    //2017-11-23
    public void _testNota(){

		String notasInternas = "NOTA,Producto defectuoso"; 
		if ( notasInternas.substring(0, 4).equals("NOTA") ) {
		    String[] cadena = notasInternas.split(",");
		    System.out.println(cadena[1]);
        }
    }
    
    /**
     * 2017-11-30
     */
    public void testNumeroLote(){
        String numeroLote = "Lot017277V-0817";
        numeroLote = numeroLote.split("-")[0];
	    System.out.println(numeroLote);
    }
}
