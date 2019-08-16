package ec.cjpq.cjfews.comprobante;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Test;

import ec.cjpq.cjfews.comprobante.Parametro;

// https://www.mkyong.com/unittest/junit-4-tutorial-1-basic-usage/
public class ParametroTest{
	private static Logger log = LogManager.getLogger(ParametroTest.class);

    @Test
	public void test(){
        Parametro p = new Parametro();
        log.warn(p.getFacturaCodigo());
        log.warn(p.getFacturaDescripcion());
	}
}

