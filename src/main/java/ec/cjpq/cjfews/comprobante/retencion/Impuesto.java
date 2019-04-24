package ec.cjpq.cjfews.comprobante.retencion;

import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@Data
@XmlType(name="comprobanteRetencionImpuesto")
public class Impuesto {

	private String codigo;
	private String codigoRetencion;
	private String baseImponible;
	private String porcentajeRetener;
	private String valorRetenido;
	private String codDocSustento;
	private String numDocSustento;
	private String fechaEmisionDocSustento;

}
