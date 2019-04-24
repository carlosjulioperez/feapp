package ec.cjpq.cjfews.comprobante.notadebito;

import java.util.List;

import lombok.Data;

import ec.cjpq.cjfews.comprobante.Parametro;

/**
 * Pojo para el XML de la Informacion de la Nota de Débito
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2016-07-27
 */
@Data
public class InfoNotaDebito {

	private String fechaEmision;
	private String dirEstablecimiento;
	private String tipoIdentificacionComprador;
	private String razonSocialComprador;
	private String identificacionComprador;
	private String contribuyenteEspecial;
	private String obligadoContabilidad;
	private String codDocModificado;
	private String numDocModificado;
	private String fechaEmisionDocSustento;
	private String totalSinImpuestos;
	private List<NotaDebitoImpuesto> impuestos; 
	private String valorTotal;

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
