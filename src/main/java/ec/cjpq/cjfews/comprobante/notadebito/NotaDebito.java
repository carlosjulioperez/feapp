package ec.cjpq.cjfews.comprobante.notadebito;

import java.util.List;

import lombok.Data;
import ec.cjpq.cjfews.comprobante.CampoAdicional;
import ec.cjpq.cjfews.comprobante.InfoTributaria;
import ec.cjpq.cjfews.comprobante.TotalComprobante;

@Data
public class NotaDebito {
	private String id;
	private String version;
	private InfoTributaria infoTributaria;
	private InfoNotaDebito infoNotaDebito;
	private List<Motivo> motivos;
	private List<CampoAdicional> infoAdicional;
	private TotalComprobante totalComprobante;
}
