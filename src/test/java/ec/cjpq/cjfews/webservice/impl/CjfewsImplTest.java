package ec.cjpq.cjfews.webservice.impl;

import java.io.FileOutputStream;
import java.io.InputStream;
import javax.activation.DataHandler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Before;
import org.junit.Test;

import ec.cjpq.cjfews.comprobante.Configuracion;
import ec.cjpq.cjfews.comprobante.factura.Factura;
import ec.cjpq.cjfews.comprobante.guia.GuiaRemision;
import ec.cjpq.cjfews.comprobante.notacredito.NotaCredito;
import ec.cjpq.cjfews.comprobante.notadebito.NotaDebito;
import ec.cjpq.cjfews.comprobante.retencion.ComprobanteRetencion;
import ec.cjpq.fe.bean.ConfiguracionBean;
import ec.cjpq.fe.bean.DocumentoBean;

public class CjfewsImplTest{
	
	private static final Logger log = LogManager.getLogger(CjfewsImplTest.class);
	private Configuracion configuracion;
	
    @Before
    public void setUp() {
    	configuracion = new ConfiguracionBean().getConfiguracion();
    }
    
	public void descargarRIDE(){
		try {
			String docs[] = {
                "FA-0501689608001-08012019-005002000004929", //2019-01-08
                "FA-0917824435001-29012019-001001000000008", //2018-10-30
				"1803201901099217915500120050020000054031234567810"
			};

			//TODOs: CAMBIAR LAS RUTAS DE FE en MAC
			//Probar Retenciones 2017-08-21
			//byte[] bytes = new CjfewsImpl().descargaRide(configuracion, docs[2]);
                    
            DataHandler dataHandler = new CjfewsImpl().descargaRide(configuracion, docs[1]);
            final InputStream in = dataHandler.getInputStream();
            byte[] bytes = org.apache.commons.io.IOUtils.toByteArray(in);

			FileOutputStream fos = new FileOutputStream("/tmp/salida.pdf");
			fos.write(bytes);
			fos.flush();
			fos.close();
			System.out.println("Download Completed");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void autorizarFactura(){
		int numero = 500;
		Factura factura = new DocumentoBean(configuracion).getFactura( numero );
        log.warn(factura.getId());
        log.warn(factura.getVersion());
		String resultado = new CjfewsImpl().autorizarFactura(factura, configuracion);
		log.warn(resultado);
	}

	public void autorizarGuiaRemision(){
		int numero = 176684;
		GuiaRemision guiaRemision = new DocumentoBean(configuracion).getGuiaRemision( numero );
		String resultado = new CjfewsImpl().autorizarGuiaRemision(guiaRemision, configuracion);
		log.warn(resultado);
	}

	public void autorizarComprobanteRetencion(){
		int numero = 176637;
		ComprobanteRetencion comprobanteRetencion = new DocumentoBean(configuracion).getComprobanteRetencion(numero );
		String resultado = new CjfewsImpl().autorizarComprobanteRetencion(comprobanteRetencion, configuracion);
		log.warn(resultado);
	}
	
	public void autorizarNotaCredito(){
		int numero = 176127;
		NotaCredito notaCredito = new DocumentoBean(configuracion).getNotaCredito(numero);
		String resultado = new CjfewsImpl().autorizarNotaCredito(notaCredito, configuracion);
		log.warn(resultado);
	}

	public void autorizarNotaDebito(){
		int numero = 176636;
		NotaDebito notaDebito = new DocumentoBean(configuracion).getNotaDebito(numero);
		String resultado = new CjfewsImpl().autorizarNotaDebito(notaDebito, configuracion);
		log.warn(resultado);
	}

    @Test
	public void runTestest(){
		descargarRIDE(); //OK
        
		//autorizarFactura(); //
        //autorizarGuiaRemision(); //OK 2018-06-06 GR-0930893714-04062018-004001000000003.xml
		//autorizarComprobanteRetencion(); //OK 2018-06-06 RE-0990021007001-01062018-001001000000001.xml
		//autorizarNotaCredito(); //OK 2018-06-06 NC-0990497214001-22052018-001001000000001.xml
		//autorizarNotaDebito();
	}
}
