package ec.cjpq.cjfews.comprobante.notadebito;

import java.util.ArrayList;
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
	private List<Motivo> motivos = new ArrayList<Motivo>();
	private List<CampoAdicional> infoAdicional = new ArrayList<CampoAdicional>();
	private TotalComprobante totalComprobante;
}
