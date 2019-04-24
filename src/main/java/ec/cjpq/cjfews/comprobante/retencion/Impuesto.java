package ec.cjpq.cjfews.comprobante.retencion;

import javax.xml.bind.annotation.XmlType;

import lombok.Data;

/**
 * Pojo para el XML del nodo Impuestos/Impuesto
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2016-06-08
 */
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
