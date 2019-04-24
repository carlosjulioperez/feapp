package ec.cjpq.cjfews.test;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Test;

import ec.cjpq.cjfews.util.Util;

/**
 * Prueba para las Utilerías del sistema
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2015-03-24, 31
 * 2015-12-17 Buscar el por el texto E-mail
 * 2015-12-18 Leer datos del xml firmado y autorizado
 */
@SuppressWarnings({"unused"})
public class UtileriaTest {

	private static Logger log = Logger.getLogger(UtileriaTest.class);

	private String documento 		= "FA-0990549591001-10062016-004001000000035.xml";

	private String directorio 		= "/usr/local/fe/dir";
	private String xmlFirmado 		= directorio + "/cf/" + documento; 
	private String xmlAutorizado 	= directorio + "/ca/" + documento;
	
	private void generales(){
		File archivoFirmado 	= new File(xmlFirmado);
		File archivoAutorizado 	= new File(xmlAutorizado);

		String claveAcceso 			= Util.getValorXML(archivoFirmado, "/*/infoTributaria/claveAcceso");

		//  /Employees/Employee[@emplid='3333']/email
		String email 				= Util.getValorXML(archivoFirmado, "/*/infoAdicional/campoAdicional[@nombre='E-mail']");
		String codInterno			= Util.getValorXML(archivoFirmado, "/*/infoAdicional/campoAdicional[@nombre='Cod-Interno']");
		String fechaEmision 		= Util.getValorXML(archivoFirmado, "/*/infoFactura/fechaEmision");
		String razonSocialComprador = Util.getValorXML(archivoFirmado, "/*/infoFactura/razonSocialComprador");
		String estab 				= Util.getValorXML(archivoFirmado, "/*/infoTributaria/estab");
		String ptoEmi 				= Util.getValorXML(archivoFirmado, "/*/infoTributaria/ptoEmi");
		String secuencial 			= Util.getValorXML(archivoFirmado, "/*/infoTributaria/secuencial");
		String razonSocial 			= Util.getValorXML(archivoFirmado, "/*/infoTributaria/razonSocial");

		String numeroAutorizacion	= Util.getValorXML(archivoAutorizado, "/*/numeroAutorizacion");
		String fechaAutorizacion	= Util.getValorXML(archivoAutorizado, "/*/fechaAutorizacion");

		log.warn(claveAcceso);
		log.warn(email);
		log.warn(razonSocialComprador);
		log.warn(estab);
		log.warn(ptoEmi);
		log.warn(secuencial);
		log.warn(codInterno);
		log.warn(fechaEmision);
		log.warn(razonSocial);

		log.warn(numeroAutorizacion);
		log.warn(fechaAutorizacion);

	}

	private void archivoToByte(){
		try {
			log.warn (Util.getArchivoToByte(new File(xmlFirmado)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void mensajeAutorizacion(){
		StringBuilder mensajeRespuesta = new StringBuilder();
		String men1 = "El comprobante ha sido AUTORIZADO...\n";
		mensajeRespuesta.append(men1);
		men1 = "Número de autorización: " + "NUMERO" + "\n";
		mensajeRespuesta.append(men1);
		men1 = "Fecha de autorización : " + "FECHA" + "\n";
		mensajeRespuesta.append(men1);
		log.warn(mensajeRespuesta.toString());
		
		log.warn(mensajeRespuesta.toString().substring(0, 36));
	}
	
	@Test
	public void run(){
		//generales();
		//archivoToByte();
		//mensajeAutorizacion();
	}
}
