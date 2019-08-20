package ec.cjpq.cjfews.webservice.impl;

import java.io.File;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import com.thoughtworks.xstream.XStream;
import ec.cjpq.cjfews.comprobante.Configuracion;
import ec.cjpq.cjfews.comprobante.Parametro;
import ec.cjpq.cjfews.comprobante.XmlUtil;
import ec.cjpq.cjfews.comprobante.factura.Factura;
import ec.cjpq.cjfews.comprobante.guia.GuiaRemision;
import ec.cjpq.cjfews.comprobante.notacredito.NotaCredito;
import ec.cjpq.cjfews.comprobante.notadebito.NotaDebito;
import ec.cjpq.cjfews.comprobante.retencion.ComprobanteRetencion;
import ec.cjpq.cjfews.util.ProcesoUtil;
import ec.cjpq.cjfews.util.RideUtil;

import ec.cjpq.fe.util.Util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CjfewsImpl {
	
	private static final Logger log = LogManager.getLogger(CjfewsImpl.class);

	public String autorizarFactura(Factura factura, Configuracion configuracion) {
		return new ProcesoUtil().procesarFactura(factura, configuracion);
	}		

	public String autorizarGuiaRemision(GuiaRemision guiaRemision, Configuracion configuracion) {
		return new ProcesoUtil().procesarGuiaRemision(guiaRemision, configuracion);
	}		

	public String autorizarComprobanteRetencion(ComprobanteRetencion comprobanteRetencion, Configuracion configuracion) {
		return new ProcesoUtil().procesarComprobanteRetencion (comprobanteRetencion, configuracion);
	}		

	public String autorizarNotaCredito(NotaCredito notaCredito, Configuracion configuracion) {
		return new ProcesoUtil().procesarNotaCredito(notaCredito, configuracion);
	}		

	public String autorizarNotaDebito(NotaDebito notaDebito, Configuracion configuracion) {
		return new ProcesoUtil().procesarNotaDebito(notaDebito, configuracion);
	}		

	public Parametro getParametro() {
		return new Parametro();
	}

	public DataHandler descargaRide(Configuracion configuracion, String documento) {
		//FileDataSource dataSource = new FileDataSource("D:/DownloadTest/"+ fileName);
		
		DataHandler fileDataHandler = null;
		try {
			String tipo = documento.substring(0,2);
			
			String xmlGen = configuracion.getDirectorioGenerados()+ File.separator + documento +".xml";
			String xmlAut = configuracion.getDirectorioAutorizados()+ File.separator + documento +".xml";
			RideUtil rideUtil = new RideUtil(configuracion, documento);
			XStream xs;
			
			File archivoAutorizado 	= new File(xmlAut);
			String numeroAutorizacion	= Util.getValorXML(archivoAutorizado, "/*/numeroAutorizacion");
			String fechaAutorizacion	= Util.getValorXML(archivoAutorizado, "/*/fechaAutorizacion");
			
			String archivo = "";
			if ( tipo.equals("FA") ){
				xs = XmlUtil.getFacturaXStream();
				Factura factura = (Factura)xs.fromXML(new File(xmlGen));
				archivo = rideUtil.generar(factura, numeroAutorizacion, fechaAutorizacion, xmlAut, true);
				//archivo = rideUtil.generar(factura, numeroAutorizacion, fechaAutorizacion, xmlAut, false);
			}
			else if ( tipo.equals("GR") ){
				xs = XmlUtil.getGuiaRemisionXStream();
				GuiaRemision guiaRemision = (GuiaRemision)xs.fromXML(new File(xmlGen));
				archivo = rideUtil.generar(guiaRemision, numeroAutorizacion, fechaAutorizacion, xmlAut, true);
			}
			else if ( tipo.equals("RE") ){
				xs = XmlUtil.getComprobanteRetencionXStream();
				ComprobanteRetencion comprobanteRetencion = (ComprobanteRetencion)xs.fromXML(new File(xmlGen));
				archivo = rideUtil.generar(comprobanteRetencion, numeroAutorizacion, fechaAutorizacion, xmlAut, true);
			}
			else if ( tipo.equals("NC") ){
				xs = XmlUtil.getNotaCreditoXStream();
				NotaCredito notaCredito = (NotaCredito)xs.fromXML(new File(xmlGen));
				archivo = rideUtil.generar(notaCredito, numeroAutorizacion, fechaAutorizacion, xmlAut, true);
			}
			else if ( tipo.equals("ND") ){
				xs = XmlUtil.getNotaDebitoXStream();
				NotaDebito notaDebito = (NotaDebito)xs.fromXML(new File(xmlGen));
				archivo = rideUtil.generar(notaDebito, numeroAutorizacion, fechaAutorizacion, xmlAut, true);
			}
			
			//FileDataSource dataSource = new FileDataSource(new RideUtil(configuracion, documento).reenviarRIDE());
			FileDataSource dataSource = new FileDataSource(archivo);
			fileDataHandler = new DataHandler(dataSource);
		} catch (Exception e) {
			log.warn(Util.stack2String(e));
		}
		return fileDataHandler;
	}
}
