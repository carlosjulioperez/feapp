package ec.cjpq.cjfews.comprobante;

import lombok.Data;

/**
 * Pojo para el XML del nodo Impuestos/Impuesto
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2015-03-18
 */
@Data
public class Impuesto {

	private String codigo;
	private String codigoPorcentaje;
	private String tarifa;
	private String baseImponible;
	private String valor;

}
