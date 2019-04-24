package ec.cjpq.cjfews.test;

import org.apache.log4j.Logger;
import org.junit.Test;

import ec.cjpq.cjfews.util.Util;

/**
 * Clase de prueba para el dígito verificador
 * @author carper
 * 2015-03-24
 */
public class DigitoVerficadorTest {

	private static Logger log = Logger.getLogger(DigitoVerficadorTest.class);

	//@Test
	public void run(){
		// 04082014011792161037001100100100000400123030461111
    	//String clave = "040820140117921610370011001001000004001230304611"; //"41261533";
    	String clave = "040820140117921610370011001001000004001230304611";
		int digitoVerificador = Util.getDigitoVerificadorModulo11(clave);
		
		log.warn("Dígito verificador: " + digitoVerificador);
	}
}
