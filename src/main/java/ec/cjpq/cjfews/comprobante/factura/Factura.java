package ec.cjpq.cjfews.comprobante.factura;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import ec.cjpq.cjfews.comprobante.CampoAdicional;
import ec.cjpq.cjfews.comprobante.InfoTributaria;
import ec.cjpq.cjfews.comprobante.TotalComprobante;

@Data
public class Factura{

	private String id;
	private String version;
	private InfoTributaria infoTributaria;
	private InfoFactura infoFactura;
	private List<Detalle> detalles = new ArrayList<Detalle>();
	private List<CampoAdicional> infoAdicional = new ArrayList<CampoAdicional>();
	private TotalComprobante totalComprobante;
	
}
