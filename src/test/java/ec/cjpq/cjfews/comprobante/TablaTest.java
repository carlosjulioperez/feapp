package ec.cjpq.cjfews.comprobante;

import junit.framework.TestCase;
import ec.cjpq.cjfews.comprobante.Tabla;

/**
 * Clase de prueba para Tabla 
 * @author carper
 * 2016-08-31
 */
public class TablaTest extends TestCase{

	public void testGetValor(){
		System.out.println(Tabla.getValor("FP_19"));
	}
}

