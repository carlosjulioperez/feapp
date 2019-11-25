package ec.cjpq.fe.bean;

import lombok.Data;

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
