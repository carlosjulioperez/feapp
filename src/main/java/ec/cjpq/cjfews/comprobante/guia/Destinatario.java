package ec.cjpq.cjfews.comprobante.guia;

import java.util.List;

import lombok.Data;

/**
 * Pojo para el XML de los Destinatarios de la Guía de Remisión
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2015-12-21
 */
@Data
public class Destinatario {

	private String identificacionDestinatario;
	private String razonSocialDestinatario;
	private String dirDestinatario;
	private String motivoTraslado;
	private String docAduaneroUnico;
	private String codEstabDestino;
	private String ruta;
	private String codDocSustento;
	private String numDocSustento;
	private String numAutDocSustento;
	private String fechaEmisionDocSustento;
	private List<GuiaRemisionDetalle> detalles;
	
}
