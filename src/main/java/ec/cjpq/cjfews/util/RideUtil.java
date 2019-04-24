package ec.cjpq.cjfews.util;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.log4j.Logger;

import ec.cjpq.cjfews.comprobante.CalculoUtil;
import ec.cjpq.cjfews.comprobante.Configuracion;
import ec.cjpq.cjfews.comprobante.Parametro;
import ec.cjpq.cjfews.comprobante.factura.Factura;
import ec.cjpq.cjfews.comprobante.guia.GuiaRemision;
import ec.cjpq.cjfews.comprobante.notacredito.NotaCredito;
import ec.cjpq.cjfews.comprobante.notadebito.NotaDebito;
import ec.cjpq.cjfews.comprobante.retencion.ComprobanteRetencion;
import ec.cjpq.util.Utileria;

/**
 * Utileria para imprimir los RIDE
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2015-03-26, 27
 * 2015-06-10 Generación de RIDE FA
 * 2015-12-16 Crear bandera para envío de RIDE
 * 2015-12-17, 18 reenviarRIDE()
 * 2016-02-17 Generar la Guía de Remisión
 * 2016-02-25 Renombrar parámetros para el envío correcto al reporte
 * 2016-06-12 Generar el Comprobante de Retención
 * 2016-07-20 Agregar Notas de crédito
 * 2016-07-28 Agregar Notas de Débito
 * 2018-02-07 Corregir para incluir las formas de pago
 * 2019-01-10 Enviar el logo de acuerdo a la configuración de la empresa
 */
public class RideUtil {

	private static final Logger log = Logger.getLogger(RideUtil.class);
	private Parametro parametro;
	private Configuracion configuracion;
	private String documento;
	private String nombreFisicoPDF;
	
	public RideUtil(Configuracion configuracion, String documento) {
		parametro = new Parametro();
		this.configuracion = configuracion;
		this.documento = documento;
		
		nombreFisicoPDF = configuracion.getDirectorioAutorizados() + File.separator + documento + ".pdf";
	}

	private Map<String, Object> getParametrosReporte(Map<String, String> parametros){
		Map<String, Object> parametrosReporte = new HashMap<String, Object>();
		parametrosReporte.put("NUM_AUT",   parametros.get("numeroAutorizacion"));
		parametrosReporte.put("FECHA_AUT", parametros.get("fechaAutorizacion"));
		parametrosReporte.put("LOGO",      configuracion.getEmisorRutaLogo() );
		
        //parametrosReporte.put("LOGO", 			getClass().getResourceAsStream("/img/logo.jpg"));
		return parametrosReporte;
	}

	public void generarFacturaPdf(Factura factura, InputStream[] reportes, Map<String, String> parametros){
		Map<String, Object> p = getParametrosReporte(parametros); 
		p.put("SUB1", reportes[1]);
		p.put("SUB2", reportes[2]);
		p.put("SUB3", reportes[3]);
		p.put("SUB4", reportes[4]);
		
		String nombreFisico = parametros.get("nombreFisico");
		factura.setTotalComprobante(new CalculoUtil().calcularTotales(factura));
		Factura[] facturas = { factura };
		
		try {
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportes[0]);
			JasperPrint jasperPrint  = JasperFillManager.fillReport(jasperReport, p, new JRBeanArrayDataSource(facturas));
			JasperExportManager.exportReportToPdfFile(jasperPrint, nombreFisico);
			
			log.warn("Se ha generado el comprobante FA-RIDE: " + nombreFisico);
		} catch (JRException e) {
			log.warn(Utileria.stack2String(e));
		}
	}

	public void generarGuiaRemisionPdf(GuiaRemision guiaRemision, InputStream[] reportes, Map<String, String> parametros){
		Map<String, Object> p = getParametrosReporte(parametros); 
		p.put("SUB1", reportes[1]);
		p.put("SUB2", reportes[2]);
		p.put("SUB3", reportes[3]);
		
		String nombreFisico = parametros.get("nombreFisico");
		//log.warn(">>> nombreFisico: " + nombreFisico);
		
		GuiaRemision[] guiasRemision = { guiaRemision };
		
		try {
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportes[0]);
			JasperPrint jasperPrint  = JasperFillManager.fillReport(jasperReport, p, new JRBeanArrayDataSource(guiasRemision));
			JasperExportManager.exportReportToPdfFile(jasperPrint, nombreFisico);
			
			//log.warn("Se ha generado el comprobante GR-RIDE: " + nombreFisico);
		} catch (JRException e) {
			log.warn(Utileria.stack2String(e));
		}
	}
	
	public void generarComprobanteRetencionPdf(ComprobanteRetencion comprobanteRetencion, InputStream[] reportes, Map<String, String> parametros){
		Map<String, Object> p = getParametrosReporte(parametros); 
		p.put("SUB1", reportes[1]);
		p.put("SUB2", reportes[2]);
		
		String nombreFisico = parametros.get("nombreFisico");
		//log.warn(">>> nombreFisico: " + nombreFisico);
		
		ComprobanteRetencion[] comprobantesRetencion = { comprobanteRetencion };
		
		try {
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportes[0]);
			JasperPrint jasperPrint  = JasperFillManager.fillReport(jasperReport, p, new JRBeanArrayDataSource(comprobantesRetencion));
			JasperExportManager.exportReportToPdfFile(jasperPrint, nombreFisico);
			
			//log.warn("Se ha generado el comprobante GR-RIDE: " + nombreFisico);
		} catch (JRException e) {
			log.warn(Utileria.stack2String(e));
		}
	}
	
	public void generarNotaCreditoPdf(NotaCredito notaCredito, InputStream[] reportes, Map<String, String> parametros){
		Map<String, Object> p = getParametrosReporte(parametros); 
		p.put("SUB1", reportes[1]);
		p.put("SUB2", reportes[2]);
		
		String nombreFisico = parametros.get("nombreFisico");
		notaCredito.setTotalComprobante(new CalculoUtil().calcularTotales(notaCredito));
		
		NotaCredito[] notasCredito = { notaCredito };
		
		try {
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportes[0]);
			JasperPrint jasperPrint  = JasperFillManager.fillReport(jasperReport, p, new JRBeanArrayDataSource(notasCredito));
			JasperExportManager.exportReportToPdfFile(jasperPrint, nombreFisico);
			
			//log.warn("Se ha generado el comprobante NC-RIDE: " + nombreFisico);
		} catch (JRException e) {
			log.warn(Utileria.stack2String(e));
		}
	}

	public void generarNotaDebitoPdf(NotaDebito notaDebito, InputStream[] reportes, Map<String, String> parametros){
		Map<String, Object> p = getParametrosReporte(parametros); 
		p.put("SUB1", reportes[1]);
		p.put("SUB2", reportes[2]);
		
		String nombreFisico = parametros.get("nombreFisico");
		notaDebito.setTotalComprobante(new CalculoUtil().calcularTotales(notaDebito));
		
		NotaDebito[] notasDebito = { notaDebito };
		
		try {
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportes[0]);
			JasperPrint jasperPrint  = JasperFillManager.fillReport(jasperReport, p, new JRBeanArrayDataSource(notasDebito));
			JasperExportManager.exportReportToPdfFile(jasperPrint, nombreFisico);
			
			//log.warn("Se ha generado el comprobante NC-RIDE: " + nombreFisico);
		} catch (JRException e) {
			log.warn(Utileria.stack2String(e));
		}
	}

	private Map<String,String> getParametros(String numeroAutorizacion, String fechaAutorizacion){
		Map<String,String> p = new HashMap<String,String>();
		p.put("numeroAutorizacion",	numeroAutorizacion);
		p.put("fechaAutorizacion", 	fechaAutorizacion);
		p.put("nombreFisico", 		nombreFisicoPDF);
		return p;
	}

	/**
	 * @param factura
	 * @param numeroAutorizacion
	 * @param fechaAutorizacion
	 * @param archivoFirmado
	 * @param numeroSecuencia
	 * @param enviarCorreo
	 * @return
	 */
	public String generar(Factura factura, String numeroAutorizacion, String fechaAutorizacion, String archivoFirmado, boolean enviarCorreo){

		InputStream repo = getClass().getResourceAsStream("/reportes/factura.jasper");
		InputStream sub1 = getClass().getResourceAsStream("/reportes/factura_detalle.jasper");
		InputStream sub2 = getClass().getResourceAsStream("/reportes/factura_detalle_adicional.jasper");
		InputStream sub3 = getClass().getResourceAsStream("/reportes/factura_detalle_info_adicional.jasper");
		InputStream sub4 = getClass().getResourceAsStream("/reportes/formapago.jasper");
		
		Map<String,String> parametros = getParametros(numeroAutorizacion, fechaAutorizacion);
		generarFacturaPdf(factura, new InputStream[]{repo, sub1, sub2, sub3, sub4}, parametros);

		String email 		= Util.getValorCampoAdicional(factura.getInfoAdicional(), "E-mail");
		String codInterno 	= Util.getValorCampoAdicional(factura.getInfoAdicional(), "Cod-Interno");
		//Se enviará el correo si el cliente tiene su e-mail y existe el número de autorización
		if (email != null && numeroAutorizacion.length() > 0) {
			
			if (enviarCorreo){
				Map<String, String> p = new HashMap<String, String>();
				p.put("emailDestino",		email);
				p.put("nombreAdjunto", 		documento);
				p.put("xmlAdjunto", 		archivoFirmado);
				p.put("pdfAdjunto", 		nombreFisicoPDF);
				
				String cuerpo = configuracion.getEmailCuerpoMensaje();
				cuerpo = String.format(cuerpo, 
					factura.getInfoFactura().getRazonSocialComprador(),
					parametro.getFacturaDescripcion(),
					numeroAutorizacion,
					fechaAutorizacion,
					parametro.getFacturaDescripcion(),
					factura.getInfoTributaria().getEstab()+"-"+factura.getInfoTributaria().getPtoEmi()+"-"+factura.getInfoTributaria().getSecuencial(),
					codInterno,
					factura.getInfoFactura().getFechaEmision(),
					factura.getInfoTributaria().getRazonSocial()
					).toString();
				p.put("cuerpoMensaje", cuerpo);
				
				log.warn("Enviando correo con documentos adjuntos a :"+email);
				boolean valor = new EmailUtil().sendEmail(configuracion, p);
				if (valor)
					log.warn("Se ha enviado el correo de forma exitosa a :"+email);
			}
		}else
			log.warn("No ha especificado el correo electrónico del cliente...");
		
		return nombreFisicoPDF;
	}
	
	public String generar(GuiaRemision guiaRemision, String numeroAutorizacion, String fechaAutorizacion, String archivoFirmado, boolean enviarCorreo){
		InputStream repo = getClass().getResourceAsStream("/reportes/guiaremision.jasper");
		InputStream sub1 = getClass().getResourceAsStream("/reportes/guiaremision_destinatario.jasper");
		InputStream sub2 = getClass().getResourceAsStream("/reportes/guiaremision_detalle.jasper");
		InputStream sub3 = getClass().getResourceAsStream("/reportes/factura_detalle_info_adicional.jasper");
		
		Map<String,String> parametros = getParametros(numeroAutorizacion, fechaAutorizacion);
		generarGuiaRemisionPdf(guiaRemision, new InputStream[]{repo, sub1, sub2, sub3}, parametros);

		String email 		= Util.getValorCampoAdicional(guiaRemision.getInfoAdicional(), "E-mail");
		String codInterno 	= Util.getValorCampoAdicional(guiaRemision.getInfoAdicional(), "Cod-Interno");
		
//		log.warn(">>> email ="+email);
//		log.warn(">> codInterno ="+codInterno);

		//Se enviará el correo si el cliente tiene su e-mail y existe el número de autorización
		if (email != null && numeroAutorizacion.length() > 0) {
			
			if (enviarCorreo){
				Map<String, String> p = new HashMap<String, String>();
				p.put("emailDestino",		email);
				p.put("nombreAdjunto", 		documento);
				p.put("xmlAdjunto", 		archivoFirmado);
				p.put("pdfAdjunto", 		nombreFisicoPDF);

				//TODOs: SEGUIR DESDE AQUI... el PDF no se generó...
//				log.warn(">>> Parámetros...");
//				log.warn("nombreAdjunto = " +documento);
//				log.warn("xmlAdjunto = " +archivoFirmado);
//				log.warn("pdfAdjunto = " +nombreFisicoPDF);

				String cuerpo = configuracion.getEmailCuerpoMensaje();
				cuerpo = String.format(cuerpo, 
					"",
					parametro.getGuiaRemisionDescripcion(),
					numeroAutorizacion,
					fechaAutorizacion,
					parametro.getGuiaRemisionDescripcion(),
					guiaRemision.getInfoTributaria().getEstab()+"-"+guiaRemision.getInfoTributaria().getPtoEmi()+"-"+guiaRemision.getInfoTributaria().getSecuencial(),
					codInterno,
					guiaRemision.getInfoGuiaRemision().getFechaFinTransporte(),
					guiaRemision.getInfoTributaria().getRazonSocial()
					).toString();
				p.put("cuerpoMensaje", cuerpo);
				
				log.warn("Enviando correo con documentos adjuntos a :"+email);
				boolean valor = new EmailUtil().sendEmail(configuracion, p);
				if (valor)
					log.warn("Se ha enviado el correo de forma exitosa a :"+email);
			}
		}else
			log.warn("No ha especificado el correo electrónico del cliente...");

		return nombreFisicoPDF;
	}

	public String generar(ComprobanteRetencion comprobanteRetencion, String numeroAutorizacion, String fechaAutorizacion, String archivoFirmado, boolean enviarCorreo){
		InputStream repo = getClass().getResourceAsStream("/reportes/comprobanteretencion.jasper");
		InputStream sub1 = getClass().getResourceAsStream("/reportes/comprobanteretencion_detalle.jasper");
		InputStream sub2 = getClass().getResourceAsStream("/reportes/factura_detalle_info_adicional.jasper");
		
		Map<String,String> parametros = getParametros(numeroAutorizacion, fechaAutorizacion);
		generarComprobanteRetencionPdf(comprobanteRetencion, new InputStream[]{repo, sub1, sub2}, parametros);

		String email 		= Util.getValorCampoAdicional(comprobanteRetencion.getInfoAdicional(), "E-mail");
		String codInterno 	= Util.getValorCampoAdicional(comprobanteRetencion.getInfoAdicional(), "Cod-Interno");
		
		//Se enviará el correo si el cliente tiene su e-mail y existe el número de autorización
		if (email != null && numeroAutorizacion.length() > 0) {
			
			if (enviarCorreo){
				Map<String, String> p = new HashMap<String, String>();
				p.put("emailDestino",		email);
				p.put("nombreAdjunto", 		documento);
				p.put("xmlAdjunto", 		archivoFirmado);
				p.put("pdfAdjunto", 		nombreFisicoPDF);

				String cuerpo = configuracion.getEmailCuerpoMensaje();
				cuerpo = String.format(cuerpo, 
					"",
					parametro.getComprobanteRetencionDescripcion(),
					numeroAutorizacion,
					fechaAutorizacion,
					parametro.getComprobanteRetencionDescripcion(),
					comprobanteRetencion.getInfoTributaria().getEstab()+"-"+comprobanteRetencion.getInfoTributaria().getPtoEmi()+"-"+comprobanteRetencion.getInfoTributaria().getSecuencial(),
					codInterno,
					comprobanteRetencion.getInfoCompRetencion().getFechaEmision(),
					comprobanteRetencion.getInfoTributaria().getRazonSocial()
					).toString();
				p.put("cuerpoMensaje", cuerpo);
				
				log.warn("Enviando correo con documentos adjuntos a :"+email);
				boolean valor = new EmailUtil().sendEmail(configuracion, p);
				if (valor)
					log.warn("Se ha enviado el correo de forma exitosa a :"+email);
			}
		}else
			log.warn("No ha especificado el correo electrónico del cliente...");

		return nombreFisicoPDF;
	}
	
	public String generar(NotaCredito notaCredito, String numeroAutorizacion, String fechaAutorizacion, String archivoFirmado, boolean enviarCorreo){
		InputStream repo = getClass().getResourceAsStream("/reportes/notacredito.jasper");
		InputStream sub1 = getClass().getResourceAsStream("/reportes/notacredito_detalle.jasper");
		InputStream sub2 = getClass().getResourceAsStream("/reportes/factura_detalle_info_adicional.jasper");
		
		Map<String,String> parametros = getParametros(numeroAutorizacion, fechaAutorizacion);
		generarNotaCreditoPdf(notaCredito, new InputStream[]{repo, sub1, sub2}, parametros);

		String email 		= Util.getValorCampoAdicional(notaCredito.getInfoAdicional(), "E-mail");
		String codInterno 	= Util.getValorCampoAdicional(notaCredito.getInfoAdicional(), "Cod-Interno");
		
		//Se enviará el correo si el cliente tiene su e-mail y existe el número de autorización
		if (email != null && numeroAutorizacion.length() > 0) {
			
			if (enviarCorreo){
				Map<String, String> p = new HashMap<String, String>();
				p.put("emailDestino",		email);
				p.put("nombreAdjunto", 		documento);
				p.put("xmlAdjunto", 		archivoFirmado);
				p.put("pdfAdjunto", 		nombreFisicoPDF);

				String cuerpo = configuracion.getEmailCuerpoMensaje();
				cuerpo = String.format(cuerpo, 
					notaCredito.getInfoNotaCredito().getRazonSocialComprador(),
					parametro.getNotaCreditoDescripcion(),
					numeroAutorizacion,
					fechaAutorizacion,
					parametro.getNotaCreditoDescripcion(),
					notaCredito.getInfoTributaria().getEstab()+"-"+notaCredito.getInfoTributaria().getPtoEmi()+"-"+notaCredito.getInfoTributaria().getSecuencial(),
					codInterno,
					notaCredito.getInfoNotaCredito().getFechaEmision(),
					notaCredito.getInfoTributaria().getRazonSocial()
					).toString();
				p.put("cuerpoMensaje", cuerpo);
				
				log.warn("Enviando correo con documentos adjuntos a :"+email);
				boolean valor = new EmailUtil().sendEmail(configuracion, p);
				if (valor)
					log.warn("Se ha enviado el correo de forma exitosa a :"+email);
			}
		}else
			log.warn("No ha especificado el correo electrónico del cliente...");

		return nombreFisicoPDF;
	}

	public String generar(NotaDebito notaDebito, String numeroAutorizacion, String fechaAutorizacion, String archivoFirmado, boolean enviarCorreo){
		InputStream repo = getClass().getResourceAsStream("/reportes/notadebito.jasper");
		InputStream sub1 = getClass().getResourceAsStream("/reportes/notadebito_detalle.jasper");
		InputStream sub2 = getClass().getResourceAsStream("/reportes/factura_detalle_info_adicional.jasper");
		
		Map<String,String> parametros = getParametros(numeroAutorizacion, fechaAutorizacion);
		generarNotaDebitoPdf(notaDebito, new InputStream[]{repo, sub1, sub2}, parametros);

		String email 		= Util.getValorCampoAdicional(notaDebito.getInfoAdicional(), "E-mail");
		String codInterno 	= Util.getValorCampoAdicional(notaDebito.getInfoAdicional(), "Cod-Interno");
		
		//Se enviará el correo si el cliente tiene su e-mail y existe el número de autorización
		if (email != null && numeroAutorizacion.length() > 0) {
			
			if (enviarCorreo){
				Map<String, String> p = new HashMap<String, String>();
				p.put("emailDestino",		email);
				p.put("nombreAdjunto", 		documento);
				p.put("xmlAdjunto", 		archivoFirmado);
				p.put("pdfAdjunto", 		nombreFisicoPDF);

				String cuerpo = configuracion.getEmailCuerpoMensaje();
				cuerpo = String.format(cuerpo, 
					notaDebito.getInfoNotaDebito().getRazonSocialComprador(),
					parametro.getNotaDebitoDescripcion(),
					numeroAutorizacion,
					fechaAutorizacion,
					parametro.getNotaDebitoDescripcion(),
					notaDebito.getInfoTributaria().getEstab()+"-"+notaDebito.getInfoTributaria().getPtoEmi()+"-"+notaDebito.getInfoTributaria().getSecuencial(),
					codInterno,
					notaDebito.getInfoNotaDebito().getFechaEmision(),
					notaDebito.getInfoTributaria().getRazonSocial()
					).toString();
				p.put("cuerpoMensaje", cuerpo);
				
				log.warn("Enviando correo con documentos adjuntos a :"+email);
				boolean valor = new EmailUtil().sendEmail(configuracion, p);
				if (valor)
					log.warn("Se ha enviado el correo de forma exitosa a :"+email);
			}
		}else
			log.warn("No ha especificado el correo electrónico del proveedor...");

		return nombreFisicoPDF;
	}

	/**
	 * Reenviar el xml y el pdf por correo. Los datos se leen del xml firmado
	 * @param documento
	 * @return
	 */
	public String reenviarRIDE(){
		try{

			String sufijo 		 = File.separator + documento;
			String xmlFirmado 	 = configuracion.getDirectorioFirmados() 	+ sufijo + ".xml"; 
			String xmlAutorizado = configuracion.getDirectorioAutorizados() + sufijo + ".xml";
			String pdfAutorizado = configuracion.getDirectorioAutorizados() + sufijo + ".pdf";
			
			File archivoFirmado 	= new File(xmlFirmado);
			File archivoAutorizado 	= new File(xmlAutorizado);
			
			String email 				= Util.getValorXML(archivoFirmado, "/*/infoAdicional/campoAdicional[@nombre='E-mail']");
			String codInterno			= Util.getValorXML(archivoFirmado, "/*/infoAdicional/campoAdicional[@nombre='Cod-Interno']");
//			String fechaEmision 		= Util.getValorXML(archivoFirmado, "/*/infoFactura/fechaEmision");
//			String razonSocialComprador = Util.getValorXML(archivoFirmado, "/*/infoFactura/razonSocialComprador");
			String estab 				= Util.getValorXML(archivoFirmado, "/*/infoTributaria/estab");
			String ptoEmi 				= Util.getValorXML(archivoFirmado, "/*/infoTributaria/ptoEmi");
			String secuencial 			= Util.getValorXML(archivoFirmado, "/*/infoTributaria/secuencial");
			String razonSocial 			= Util.getValorXML(archivoFirmado, "/*/infoTributaria/razonSocial");
			
			String numeroAutorizacion	= Util.getValorXML(archivoAutorizado, "/*/numeroAutorizacion");
			String fechaAutorizacion	= Util.getValorXML(archivoAutorizado, "/*/fechaAutorizacion");

			Map<String, String> p = new HashMap<String, String>();
			p.put("emailDestino",		email);
			p.put("nombreAdjunto", 		documento);
			p.put("xmlAdjunto", 		xmlAutorizado);
			p.put("pdfAdjunto", 		pdfAutorizado);
			
			String cuerpo = configuracion.getEmailCuerpoMensaje();
			cuerpo = String.format(cuerpo, 
				"", //razonSocialComprador,
				parametro.getFacturaDescripcion(),
				numeroAutorizacion,
				fechaAutorizacion,
				parametro.getFacturaDescripcion(),
				estab+"-"+ptoEmi+"-"+secuencial,
				codInterno,
				"", //fechaEmision,
				razonSocial
				).toString();
			p.put("cuerpoMensaje", cuerpo);
			
			log.warn("Enviando correo con documentos adjuntos a :"+email);

			boolean valor = new EmailUtil().sendEmail(configuracion, p);
			if (valor)
				log.warn("Se ha enviado el correo de forma exitosa a :"+email);

			return pdfAutorizado;
		}catch (Exception e) {
			log.warn( Utileria.stack2String(e));
			return null;
		}
	}
}
