package ec.cjpq.cjfews.comprobante.guia;

import lombok.Data;

/**
 * Pojo para el XML de la Informacion de la Guía de Remisión
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2015-12-21
 */
@Data
public class InfoGuiaRemision {

	private String dirEstablecimiento;
	private String dirPartida;
	private String razonSocialTransportista;
	private String tipoIdentificacionTransportista;
	private String rucTransportista;
	private String rise;
	private String obligadoContabilidad;
	private String contribuyenteEspecial;
	private String fechaIniTransporte;
	private String fechaFinTransporte;
	private String placa;
	
}
