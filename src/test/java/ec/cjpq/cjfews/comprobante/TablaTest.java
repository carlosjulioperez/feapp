package ec.cjpq.cjfews.comprobante;

import ec.cjpq.cjfews.comprobante.Tabla;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

// https://www.mkyong.com/unittest/junit-4-tutorial-1-basic-usage/
public class TablaTest{
	private static Logger log = LogManager.getLogger(TablaTest.class);

    @Test
	public void testGetValor(){
        log.warn(Tabla.getValor("FP_19"));
		// System.out.println(Tabla.getValor("FP_19"));
	}
}

