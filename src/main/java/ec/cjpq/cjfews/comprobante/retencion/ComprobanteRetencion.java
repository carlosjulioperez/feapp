package ec.cjpq.cjfews.comprobante.retencion;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import ec.cjpq.cjfews.comprobante.CampoAdicional;
import ec.cjpq.cjfews.comprobante.InfoTributaria;

@Data
public class ComprobanteRetencion {
	private String id;
	private String version;
	private InfoTributaria infoTributaria;
	private InfoCompRetencion infoCompRetencion;
	private List<Impuesto> impuestos = new ArrayList<Impuesto>();
	private List<CampoAdicional> infoAdicional = new ArrayList<CampoAdicional>();
}
