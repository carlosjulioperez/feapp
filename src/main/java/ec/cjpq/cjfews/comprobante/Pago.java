package ec.cjpq.cjfews.comprobante;

import lombok.Data;

/**
 * Pojo para el XML del nodo factura/formaPago
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2016-08-31
 */
@Data
public class Pago {
	private String formaPago;
	private String total;
	private String plazo;
	private String unidadTiempo;
}
