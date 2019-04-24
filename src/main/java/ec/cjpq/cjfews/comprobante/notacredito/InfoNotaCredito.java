package ec.cjpq.cjfews.comprobante.notacredito;

import java.util.List;

import lombok.Data;

import ec.cjpq.cjfews.comprobante.Parametro;
import ec.cjpq.cjfews.comprobante.TotalImpuesto;

/**
 * Pojo para el XML de la Informacion de la Nota de Credito
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2015-03-18, 24
 */
@Data
public class InfoNotaCredito {
	
	private String fechaEmision;
	private String dirEstablecimiento;
	private String tipoIdentificacionComprador;
	private String razonSocialComprador;
	private String identificacionComprador;
	private String contribuyenteEspecial;
	private String obligadoContabilidad;
	private String rise;
	private String codDocModificado;
	private String numDocModificado;
	private String fechaEmisionDocSustento;
	private String totalSinImpuestos;
	private String valorModificacion;
	private String moneda;
	private List<TotalImpuesto> totalConImpuestos;
	private String motivo;

	public String getNombreDocumentoModificado(){
		String valor = "";
		String codigo = getCodDocModificado();
		
		Parametro p = new Parametro();
		
		if ( codigo.equals(p.getFacturaCodigo()) )
			valor = p.getFacturaDescripcion();
		else if ( codigo.equals(p.getNotaCreditoCodigo()) )
			valor = p.getNotaCreditoDescripcion();
		else if ( codigo.equals(p.getNotaDebitoCodigo()) )
			valor = p.getNotaDebitoDescripcion();
		else if ( codigo.equals(p.getGuiaRemisionCodigo()) )
			valor = p.getGuiaRemisionDescripcion();
		else if ( codigo.equals(p.getComprobanteRetencionCodigo()) )
			valor = p.getComprobanteRetencionDescripcion();
		
		return valor;
	}
}
