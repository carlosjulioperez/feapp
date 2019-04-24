package ec.cjpq.cjfews.comprobante.notadebito;

import lombok.Data;

/**
 * Pojo para el XML nodo Impuestos/Impuesto
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2016-07-27, 28
 */
@Data
public class NotaDebitoImpuesto {
	private String codigo;
	private String codigoPorcentaje;
	private String tarifa;
	private String baseImponible;
	private String valor;

}
