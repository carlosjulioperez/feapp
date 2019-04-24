package ec.cjpq.cjfews.comprobante.notacredito;

import java.util.List;

import lombok.Data;
import ec.cjpq.cjfews.comprobante.CampoAdicional;
import ec.cjpq.cjfews.comprobante.InfoTributaria;
import ec.cjpq.cjfews.comprobante.TotalComprobante;

@Data
public class NotaCredito {

	private String id;
	private String version;
	private InfoTributaria infoTributaria;
	private InfoNotaCredito infoNotaCredito;
	private List<DetalleNotaCredito> detalles;
	private List<CampoAdicional> infoAdicional;
	private TotalComprobante totalComprobante;
	
}
