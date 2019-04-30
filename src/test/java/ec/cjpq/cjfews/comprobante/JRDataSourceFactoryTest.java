package ec.cjpq.cjfews.comprobante;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Test;

import ec.cjpq.cjfews.comprobante.JRDataSourceFactory;
import ec.cjpq.cjfews.comprobante.factura.Factura;

public class JRDataSourceFactoryTest{
	
    private static Logger log = LogManager.getLogger(JRDataSourceFactoryTest.class);

    @Test
	public void test(){
		Factura[] facturas = JRDataSourceFactory.getFacturaArray();
		Factura factura = facturas[0];
		log.warn(factura.getVersion());
	}
}

