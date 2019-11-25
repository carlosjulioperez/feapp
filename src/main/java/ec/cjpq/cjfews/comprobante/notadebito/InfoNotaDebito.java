package ec.cjpq.cjfews.comprobante.notadebito;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import ec.cjpq.cjfews.comprobante.Parametro;

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
	private List<NotaDebitoImpuesto> impuestos = new ArrayList<NotaDebitoImpuesto>(); 
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
