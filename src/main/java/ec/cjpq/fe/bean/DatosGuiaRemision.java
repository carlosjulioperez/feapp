package ec.cjpq.fe.bean;

import lombok.Data;

/**
 * Pojo empleado para almacenar los datos de la Guía de Remisión en la capa DAO
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2015-12-28
 * 2016-03-16
 */
@Data
public class DatosGuiaRemision {
	
	private Integer id;
	private String transportistaId;
	private String transportistaRazonSocial;
	private String placa;
	private String puntoPartida;
	private String fecha;
	private String numeroFactura;
	private String numeroAutorizacionFactura;
	private String motivoTraslado;
	
	private String puntoLlegada;
	private String destinatarioId;
	private String destinatarioRazonSocial;
	
}
