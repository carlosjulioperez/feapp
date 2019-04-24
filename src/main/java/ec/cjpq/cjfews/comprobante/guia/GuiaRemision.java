package ec.cjpq.cjfews.comprobante.guia;

import java.util.List;

import lombok.Data;
import ec.cjpq.cjfews.comprobante.CampoAdicional;
import ec.cjpq.cjfews.comprobante.InfoTributaria;

@Data
public class GuiaRemision {

	private String id;
	private String version;
	private InfoTributaria infoTributaria;
	private InfoGuiaRemision infoGuiaRemision;
	private List<Destinatario> destinatarios;
	private List<CampoAdicional> infoAdicional;
	
}
