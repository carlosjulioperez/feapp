package ec.cjpq.cjfews.comprobante.retencion;

import java.util.List;

import lombok.Data;
import ec.cjpq.cjfews.comprobante.CampoAdicional;
import ec.cjpq.cjfews.comprobante.InfoTributaria;

/**
 * Pojo para el XML del Comprobante de Retención
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2016-06-08
 */
@Data
public class ComprobanteRetencion {
	private String id;
	private String version;
	private InfoTributaria infoTributaria;
	private InfoCompRetencion infoCompRetencion;
	private List<Impuesto> impuestos;
	private List<CampoAdicional> infoAdicional;
}
