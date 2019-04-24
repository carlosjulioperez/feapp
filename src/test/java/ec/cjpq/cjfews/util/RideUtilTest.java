package ec.cjpq.cjfews.util;

import com.thoughtworks.xstream.XStream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.PrintWriter;

import junit.framework.TestCase;
import org.junit.Before;

import ec.cjpq.cjfews.comprobante.Configuracion;
import ec.cjpq.cjfews.comprobante.XmlUtil;
import ec.cjpq.cjfews.comprobante.factura.Factura;
import ec.cjpq.cjfews.comprobante.guia.GuiaRemision;
import ec.cjpq.cjfews.comprobante.notacredito.NotaCredito;
import ec.cjpq.cjfews.comprobante.notadebito.NotaDebito;
import ec.cjpq.cjfews.comprobante.retencion.ComprobanteRetencion;

/**
 * Prueba unitaria RideUtil
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2016-02-17
 * 2016-04-21 Prueba de GR de apracomsa
 * 2016-05-23 testGenerarFactura()
 * 2015-06-07 leyendaIVA
 * 2016-07-21 AGregar NC
 * 2016-08-02 Agregar ND
 * 2017-11-29 Pruebas con número de lote
 * 2018-02-07 Corregir para incluir las formas de pago
 */
public class RideUtilTest extends TestCase{
	
	private Configuracion configuracion;

    @Before
    public void setUp() {
    	configuracion = new Configuracion();
    	configuracion.setDirectorioAutorizados("/usr/local/fe/dir/ca");
    }

    // https://www.mkyong.com/java/how-to-write-to-file-in-java-bufferedwriter-example/
    private void writeFile(String filePath, String data) {
        try (FileWriter writer = new FileWriter(filePath);
            BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(data);
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }        
    }

    public void _testWriteToFile(){
        writeFile("/tmp/filename.txt","Hello File");
    }

    // Temp files:
    // https://www.baeldung.com/java-write-to-file

    // http://www.java2s.com/Code/Java/XML/GetcharacterdataCDATAfromxmldocument.htm
    public void _testCdata() throws Exception {
        File file = new File("/home/carper/tmp/1803201901099217915500120050020000054031234567810.xml");
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(file);

        NodeList nodes = doc.getElementsByTagName("autorizacion");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);
            NodeList title = element.getElementsByTagName("comprobante");
            Element line = (Element) title.item(0);
            //System.out.println("Title: " + getCharacterDataFromElement(line));
            writeFile("/tmp/salida.xml", getCharacterDataFromElement(line));
        }
    }
    private static String getCharacterDataFromElement(Element e) {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData) {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "";
    }
	
    public void testGenerarFactura(){
		String xmls[] = {
			"FA-0917824435001-29012019-001001000000009",
            "1803201901099217915500120050020000054031234567810"
		};
		String nombre = xmls[0];
		String xml = "/usr/local/fe/dir/cg/"+ nombre +".xml";
		XStream xs = XmlUtil.getFacturaXStream();
		Factura factura = (Factura)xs.fromXML(new File(xml));

		//Configuracion
		RideUtil rideUtil = new RideUtil(configuracion, nombre);
        //System.out.println(configuracion);
		rideUtil.generar(factura, "NUMERO_PRUEBA", "FECHA_PRUEBA", "", false);
    }
    
	public void _testGenerarGuiaRemision(){
		String xmls[] = {
			"GR-0918056664001-11022016-004001000000001", 
			"GR-0918056664001-11022016-004001000000002", 
			"GR-0918056664001-11022016-004001000000003", 
			"GR-0930893714-21032016-004002000000993"
		};
		
		String nombre = xmls[3];
		String xml = "/usr/local/fe/dir/cg/"+ nombre +".xml";
		XStream xs = XmlUtil.getGuiaRemisionXStream();
		GuiaRemision guiaRemision = (GuiaRemision)xs.fromXML(new File(xml));

		//Configuracion
		RideUtil rideUtil = new RideUtil(configuracion, nombre);
		rideUtil.generar(guiaRemision, "NUMERO_PRUEBA", "FECHA_PRUEBA", "", false);
	}

	public void _testGenerarComprobanteRetencion(){
		String xmls[] = {
			"RE-1768161550001-13062016-004001000000004"
		};
		
		String nombre = xmls[0];
		String xml = "/usr/local/fe/dir/cg/"+ nombre +".xml";
		XStream xs = XmlUtil.getComprobanteRetencionXStream();
		ComprobanteRetencion comprobanteRetencion = (ComprobanteRetencion)xs.fromXML(new File(xml));

		//Configuracion
		RideUtil rideUtil = new RideUtil(configuracion, nombre);
		rideUtil.generar(comprobanteRetencion , "NUMERO_PRUEBA", "FECHA_PRUEBA", "", false);
	}

	public void _testGenerarNotaCredito(){
		String xmls[] = {
			"NC-0990351260001-15072016-004001000000001"
		};
		
		String nombre = xmls[0];
		String xml = "/usr/local/fe/dir/cg/"+ nombre +".xml";
		XStream xs = XmlUtil.getNotaCreditoXStream();
		NotaCredito notaCredito = (NotaCredito)xs.fromXML(new File(xml));

		//Configuracion
		RideUtil rideUtil = new RideUtil(configuracion, nombre);
		rideUtil.generar(notaCredito , "NUMERO_PRUEBA", "FECHA_PRUEBA", "", false);
	}
	
	public void _testGenerarNotaDebito(){
		String xmls[] = {
			"ND-0990985936001-03082016-004001000000001"
		};
		
		String nombre = xmls[0];
		String xml = "/usr/local/fe/dir/cg/"+ nombre +".xml";
		XStream xs = XmlUtil.getNotaDebitoXStream();
		NotaDebito notaDebito = (NotaDebito)xs.fromXML(new File(xml));

		//Configuracion
		RideUtil rideUtil = new RideUtil(configuracion, nombre);
		rideUtil.generar(notaDebito , "NUMERO_0830", "FECHA_0830", "", false);
	}
    
    public void testEjecutar(){
    }
}
