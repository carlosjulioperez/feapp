package ec.cjpq.cjfews.comprobante.factura;

import java.util.List;

import lombok.Data;
import ec.cjpq.cjfews.comprobante.CampoAdicional;
import ec.cjpq.cjfews.comprobante.InfoTributaria;
import ec.cjpq.cjfews.comprobante.TotalComprobante;

/**
 * Pojo para el XML de la Factura
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2015-03-18
 */
@Data
public class Factura{

	private String id;
	private String version;
	private InfoTributaria infoTributaria;
	private InfoFactura infoFactura;
	private List<Detalle> detalles;
	private List<CampoAdicional> infoAdicional;
	private TotalComprobante totalComprobante;
	
}
