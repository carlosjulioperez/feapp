package ec.cjpq.cjfews.comprobante.guia;

import java.util.List;

import lombok.Data;
import ec.cjpq.cjfews.comprobante.CampoAdicional;
import ec.cjpq.cjfews.comprobante.InfoTributaria;

/**
 * Pojo para el XML de la Guía de Remisión
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2015-12-21, 22
 */
@Data
public class GuiaRemision {

	private String id;
	private String version;
	private InfoTributaria infoTributaria;
	private InfoGuiaRemision infoGuiaRemision;
	private List<Destinatario> destinatarios;
	private List<CampoAdicional> infoAdicional;
	
}
