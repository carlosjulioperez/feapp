package ec.cjpq.cjfews.comprobante;

import junit.framework.TestCase;
import ec.cjpq.cjfews.comprobante.JRDataSourceFactory;
import ec.cjpq.cjfews.comprobante.factura.Factura;

/**
 * Prueba unitara
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2016-09-02
 */
public class JRDataSourceFactoryTest extends TestCase{

	public void test(){
		Factura[] facturas = JRDataSourceFactory.getFacturaArray();
		Factura factura = facturas[0];
		System.out.println(factura.getVersion());
	}
}

