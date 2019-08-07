package ec.cjpq.fe.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Test;

import ec.cjpq.cjfews.comprobante.Configuracion;
import ec.cjpq.cjfews.comprobante.factura.Factura;
import ec.cjpq.fe.bean.ConfiguracionBean;
import ec.cjpq.fe.bean.DocumentoBean;

public class ProcesoTest {
	
    private static Logger log = LogManager.getLogger(ProcesoTest.class);
	
    @Test
	public void runTest(){
		Configuracion configuracion = new ConfiguracionBean().getConfiguracion();
		Factura factura = new DocumentoBean(configuracion).getFactura(4104);
        log.warn(factura.getInfoFactura());
	}
}
