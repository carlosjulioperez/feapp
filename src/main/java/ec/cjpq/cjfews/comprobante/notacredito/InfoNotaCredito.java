package ec.cjpq.cjfews.comprobante.notacredito;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import ec.cjpq.cjfews.comprobante.Parametro;
import ec.cjpq.cjfews.comprobante.TotalImpuesto;

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
	private List<TotalImpuesto> totalConImpuestos = new ArrayList<TotalImpuesto>();
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
