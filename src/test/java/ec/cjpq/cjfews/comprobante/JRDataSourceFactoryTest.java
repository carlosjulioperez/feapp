package ec.cjpq.cjfews.comprobante;

import junit.framework.TestCase;
import ec.cjpq.cjfews.comprobante.JRDataSourceFactory;
import ec.cjpq.cjfews.comprobante.factura.Factura;

public class JRDataSourceFactoryTest extends TestCase{

	public void test(){
		Factura[] facturas = JRDataSourceFactory.getFacturaArray();
		Factura factura = facturas[0];
		System.out.println(factura.getVersion());
	}
}

