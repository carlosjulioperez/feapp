package ec.cjpq.cjfews.comprobante;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import ec.cjpq.cjfews.comprobante.factura.Factura;
import ec.cjpq.cjfews.comprobante.factura.InfoFactura;
import ec.cjpq.cjfews.comprobante.guia.Destinatario;
import ec.cjpq.cjfews.comprobante.guia.GuiaRemision;
import ec.cjpq.cjfews.comprobante.guia.InfoGuiaRemision;
import ec.cjpq.cjfews.comprobante.notacredito.InfoNotaCredito;
import ec.cjpq.cjfews.comprobante.notacredito.NotaCredito;
import ec.cjpq.cjfews.comprobante.notadebito.InfoNotaDebito;
import ec.cjpq.cjfews.comprobante.notadebito.Motivo;
import ec.cjpq.cjfews.comprobante.notadebito.NotaDebito;
import ec.cjpq.cjfews.comprobante.notadebito.NotaDebitoImpuesto;
import ec.cjpq.cjfews.comprobante.retencion.ComprobanteRetencion;
import ec.cjpq.cjfews.comprobante.retencion.InfoCompRetencion;

public class XmlUtil {
	
	// Aplicar código en fepe
	public static XStream getFacturaXStream(){
		XStream xs = new XStream(new StaxDriver());
	
		xs.alias("factura", Factura.class);
		xs.alias("infoFactura", InfoFactura.class);
		xs.alias("totalImpuesto", TotalImpuesto.class);
		xs.alias("detalle", ec.cjpq.cjfews.comprobante.factura.Detalle.class);
		xs.alias("detAdicional", DetAdicional.class);
		xs.alias("impuesto", Impuesto.class);
		xs.alias("campoAdicional", CampoAdicional.class);
		xs.alias("pago", Pago.class);

		xs.useAttributeFor("id", String.class);
		xs.useAttributeFor("version", String.class);
		
		xs.registerConverter(new DetAdicionalConverter());
		xs.registerConverter(new CampoAdicionalConverter());
		return xs;
	}

	public static XStream getGuiaRemisionXStream(){
		XStream xs = new XStream(new StaxDriver());
		
		xs.alias("guiaRemision", GuiaRemision.class);
		xs.alias("infoGuiaRemision", InfoGuiaRemision.class);
		xs.alias("destinatario", Destinatario.class);
		xs.alias("detalle", ec.cjpq.cjfews.comprobante.guia.GuiaRemisionDetalle.class);
		xs.alias("campoAdicional", CampoAdicional.class);
		
		xs.useAttributeFor("id", String.class);
		xs.useAttributeFor("version", String.class);
		
		xs.registerConverter(new DetAdicionalConverter());
		xs.registerConverter(new CampoAdicionalConverter());
		return xs;
	}
	
	public static XStream getComprobanteRetencionXStream(){
		XStream xs = new XStream(new StaxDriver());
		
		xs.alias("comprobanteRetencion", ComprobanteRetencion.class);
		xs.alias("infoCompRetencion", InfoCompRetencion.class);
		xs.alias("campoAdicional", CampoAdicional.class);
		xs.alias("impuesto", ec.cjpq.cjfews.comprobante.retencion.Impuesto.class);
		
		xs.useAttributeFor("id", String.class);
		xs.useAttributeFor("version", String.class);
		
		xs.registerConverter(new CampoAdicionalConverter());
		return xs;
	}

	public static XStream getNotaCreditoXStream(){
		XStream xs = new XStream(new StaxDriver());
		
		xs.alias("notaCredito", NotaCredito.class);
		xs.alias("infoNotaCredito", InfoNotaCredito.class);
		xs.alias("totalImpuesto", TotalImpuesto.class);
		xs.alias("detalle", ec.cjpq.cjfews.comprobante.notacredito.DetalleNotaCredito.class);
		xs.alias("impuesto", Impuesto.class);
		xs.alias("campoAdicional", CampoAdicional.class);

		xs.useAttributeFor("id", String.class);
		xs.useAttributeFor("version", String.class);
		
		xs.registerConverter(new DetAdicionalConverter());
		xs.registerConverter(new CampoAdicionalConverter());
		return xs;
	}

	public static XStream getNotaDebitoXStream(){
		XStream xs = new XStream(new StaxDriver());
		
		xs.alias("notaDebito", NotaDebito.class);
		xs.alias("infoNotaDebito", InfoNotaDebito.class);
		xs.alias("motivo", Motivo.class);
		xs.alias("impuesto", NotaDebitoImpuesto.class);
		xs.alias("campoAdicional", CampoAdicional.class);

		xs.useAttributeFor("id", String.class);
		xs.useAttributeFor("version", String.class);
		
		xs.registerConverter(new CampoAdicionalConverter());
		return xs;
	}
}
