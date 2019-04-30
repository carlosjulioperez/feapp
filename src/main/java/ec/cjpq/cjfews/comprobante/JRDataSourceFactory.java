package ec.cjpq.cjfews.comprobante;

import java.io.File;

import com.thoughtworks.xstream.XStream;

import ec.cjpq.cjfews.comprobante.factura.Factura;
import ec.cjpq.cjfews.comprobante.guia.GuiaRemision;
import ec.cjpq.cjfews.comprobante.notacredito.NotaCredito;
import ec.cjpq.cjfews.comprobante.notadebito.NotaDebito;
import ec.cjpq.cjfews.comprobante.retencion.ComprobanteRetencion;

public class JRDataSourceFactory {

	public static Factura[] getFacturaArray(){
		String xml = "/usr/local/fe/dir/cg/FA-0917824435001-29012019-001001000000008.xml";
		
		Factura[] arreglo = new Factura[1];
		XStream xs = XmlUtil.getFacturaXStream();

		Factura factura = (Factura)xs.fromXML(new File(xml)); 
		factura.setTotalComprobante(new CalculoUtil().calcularTotales(factura));
		arreglo[0] = factura; 
		return arreglo;
	}

	public static NotaCredito[] getNotaCreditoArray(){
		String xml = "/usr/local/fe/dir/cg/NC-0990351260001-15072016-004001000000001.xml";

		NotaCredito[] arreglo = new NotaCredito[1];
		XStream xs = XmlUtil.getNotaCreditoXStream();
		NotaCredito notaCredito = (NotaCredito)xs.fromXML(new File(xml)); 
		notaCredito.setTotalComprobante(new CalculoUtil().calcularTotales(notaCredito));
		arreglo[0] = notaCredito; 
		return arreglo;
	}

	public static GuiaRemision[] getGuiaRemisionArray(){
		String xml = "/usr/local/fe/dir/cg/GR-0918056664001-11022016-004001000000003.xml";
		
		GuiaRemision[] arreglo = new GuiaRemision[1];
		XStream xs = XmlUtil.getGuiaRemisionXStream();
		GuiaRemision guiaRemision = (GuiaRemision)xs.fromXML(new File(xml)); 
		arreglo[0] = guiaRemision; 
		return arreglo;
	}
	
	public static ComprobanteRetencion[] getComprobanteRetencionArray(){
		String xml = "/usr/local/fe/dir/cg/RE-1790369145001-12062016-004001000000001.xml";
		
		ComprobanteRetencion[] arreglo = new ComprobanteRetencion[1];
		XStream xs = XmlUtil.getComprobanteRetencionXStream();
		ComprobanteRetencion comprobanteRetencion = (ComprobanteRetencion)xs.fromXML(new File(xml)); 
		arreglo[0] = comprobanteRetencion; 
		return arreglo;
	}
	
	public static NotaDebito[] getNotaDebitoArray(){
		String xml = "/usr/local/fe/dir/cg/ND-0915523898-30072015-004001000000001.xml";

		NotaDebito[] arreglo = new NotaDebito[1];
		XStream xs = XmlUtil.getNotaDebitoXStream();
		NotaDebito notaDebito = (NotaDebito)xs.fromXML(new File(xml)); 
		notaDebito.setTotalComprobante(new CalculoUtil().calcularTotales(notaDebito));
		arreglo[0] = notaDebito; 
		return arreglo;
	}

}
