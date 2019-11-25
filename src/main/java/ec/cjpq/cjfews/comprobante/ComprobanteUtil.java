package ec.cjpq.cjfews.comprobante;

public class ComprobanteUtil {

	public String getNombreDocumentoModificado(String codigo){
		String valor = "";
		
		Parametro parametro = new Parametro();
		
		if ( codigo.equals(parametro.getFacturaCodigo()) )
			valor = parametro.getFacturaDescripcion();
		else if ( codigo.equals(parametro.getNotaCreditoCodigo()) )
			valor = parametro.getNotaCreditoDescripcion();
		else if ( codigo.equals(parametro.getNotaDebitoCodigo()) )
			valor = parametro.getNotaDebitoDescripcion();
		else if ( codigo.equals(parametro.getGuiaRemisionCodigo()) )
			valor = parametro.getGuiaRemisionDescripcion();
		else if ( codigo.equals(parametro.getComprobanteRetencionCodigo()) )
			valor = parametro.getComprobanteRetencionDescripcion();
		
		return valor;
	}
	
	public String getNombreImpuestoRetener(String codigo){
		String valor = "";
		
		Parametro parametro = new Parametro();
		
		if ( codigo.equals(parametro.getImpuestoRetenerRentaCodigo()) )
			valor = parametro.getImpuestoRetenerRentaDescripcion();
		else if ( codigo.equals(parametro.getImpuestoRetenerIvaCodigo()) )
			valor = parametro.getImpuestoRetenerIvaDescripcion();
		else if ( codigo.equals(parametro.getImpuestoRetenerIsdCodigo()) )
			valor = parametro.getImpuestoRetenerIsdDescripcion();
		
		return valor;
	}

}
