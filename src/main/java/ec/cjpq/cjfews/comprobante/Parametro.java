package ec.cjpq.cjfews.comprobante;

import lombok.Getter;

/**
 * Parámetros del sistema para realizar validaciones en el lado del cliente WS
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2015-03-24
 * 2016-05-20
 */
@Getter
public class Parametro {

	private String facturaCodigo;
	private String facturaDescripcion;

	private String notaCreditoCodigo;
	private String notaCreditoDescripcion;

	private String notaDebitoCodigo;
	private String notaDebitoDescripcion;

	private String guiaRemisionCodigo;
	private String guiaRemisionDescripcion;

	private String comprobanteRetencionCodigo;
	private String comprobanteRetencionDescripcion;

	private String dolarCodigo;
	private String dolarDescripcion;
	
	private String rucCodigo;
	private String rucDescripcion;

	private String cedulaCodigo;
	private String cedulaDescripcion;
	
	private String pasaporteCodigo;
	private String pasaporteDescripcion;

	private String consumidorFinalCodigo;
	private String consumidorFinalDescripcion;

	private String idExteriorCodigo;
	private String idExteriorDescripcion;

	private String placaCodigo;
	private String placaDescripcion;

	private String rentaCodigo;
	private String rentaDescripcion;

	private String ivaCodigo;
	private String ivaDescripcion;

	private String iceCodigo;
	private String iceDescripcion;

	private String irbpnrCodigo;
	private String irbpnrDescripcion;

	private String iva0Codigo;
	private String iva0Descripcion;

	private String iva12Codigo;
	private String iva12Descripcion;

	private String iva14Codigo;
	private String iva14Descripcion;

	private String noObjetoImpuestoCodigo;
	private String noObjetoImpuestoDescripcion;

	private String exentoIvaCodigo;
	private String exentoIvaDescripcion;

	//2016-06-12
	private String impuestoRetenerRentaCodigo;
	private String impuestoRetenerRentaDescripcion;

	private String impuestoRetenerIvaCodigo;
	private String impuestoRetenerIvaDescripcion;

	private String impuestoRetenerIsdCodigo;
	private String impuestoRetenerIsdDescripcion;

	public Parametro() {

		this.facturaCodigo="01";
		this.facturaDescripcion="FACTURA";
		
		this.notaCreditoCodigo="04";
		this.notaCreditoDescripcion="NOTA DE CREDITO";
		
		this.notaDebitoCodigo="05";
		this.notaDebitoDescripcion="NOTA DE DEBITO";

		this.guiaRemisionCodigo="06";
		this.guiaRemisionDescripcion="GUIA DE REMISION";

		this.comprobanteRetencionCodigo="07";
		this.comprobanteRetencionDescripcion="COMPROBANTE DE RETENCION";

		this.dolarCodigo="USD";
		this.dolarDescripcion="DOLAR";

		this.rucCodigo="04";
		this.rucDescripcion="RUC";

		this.cedulaCodigo="05";
		this.cedulaDescripcion="CEDULA";

		this.pasaporteCodigo="06";
		this.pasaporteDescripcion="PASAPORTE";

		this.consumidorFinalCodigo="07";
		this.consumidorFinalDescripcion="VENTA A CONSUMIDOR FINAL";

		this.idExteriorCodigo="08";
		this.idExteriorDescripcion="IDENTIFICACION DEL EXTERIOR";

		this.placaCodigo="09";
		this.placaDescripcion="PLACA";

		this.rentaCodigo="1";
		this.rentaDescripcion="IMPUESTO A LA RENTA";

		this.ivaCodigo="2";
		this.ivaDescripcion="I.V.A.";

		this.iceCodigo="3";
		this.iceDescripcion="I.C.E.";

		this.irbpnrCodigo="5";
		this.irbpnrDescripcion="IRBPNR";

		this.iva0Codigo="0";
		this.iva0Descripcion="0";

		this.iva12Codigo="2";
		this.iva12Descripcion="12";

		this.iva14Codigo="3";
		this.iva14Descripcion="14";

		this.noObjetoImpuestoCodigo="6";
		this.noObjetoImpuestoDescripcion="NO OBJETO DE IMPUESTO";

		this.exentoIvaCodigo="7";
		this.exentoIvaDescripcion="EXENTO DE IVA";
		
		this.impuestoRetenerRentaCodigo="1";
		this.impuestoRetenerRentaDescripcion="RENTA";  
        
		this.impuestoRetenerIvaCodigo="2";
		this.impuestoRetenerIvaDescripcion="IVA";    
        
		this.impuestoRetenerIsdCodigo="6";
		this.impuestoRetenerIsdDescripcion="ISD";
		
	}
}
