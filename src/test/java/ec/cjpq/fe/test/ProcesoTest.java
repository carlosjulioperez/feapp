package ec.cjpq.fe.util;

import junit.framework.TestCase;

import ec.cjpq.cjfews.comprobante.Configuracion;
import ec.cjpq.cjfews.comprobante.factura.Factura;
import ec.cjpq.fe.bean.ConfiguracionBean;
import ec.cjpq.fe.bean.DocumentoBean;

public class ProcesoTest extends TestCase{
	
	public void test(){
		Configuracion configuracion = new ConfiguracionBean().getConfiguracion();
		//Factura factura = new DocumentoBean(configuracion).getFactura( 114982 ); //114982, 114048
		Factura factura = new DocumentoBean(configuracion).getFactura( 115620 );
		//System.out.println(factura.getInfoFactura().getTotalConImpuestos().;
	}
}
