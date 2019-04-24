package ec.cjpq.cjfews.comprobante;

import lombok.Data;


/**
 * Calcula los totales para los reportes
 * 
 * Estos métodos sirven para agregar, por medio de los getters(), atributos que sean fácilmente empleados en el reporte.
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2015-03-18
 * 2015-05-20
 * 2015-06-07 leyendaIVA
 */
@Data
public class TotalComprobante {

	private String subtotalIva;
	private String subtotal0;
	private String subtotalNoObjetoImpuesto;
	private String subtotalExentoIva;
	private String totalDescuento;
	private String totalIce;
	private String totalIva;
	private String irbpnr;
	private String leyendaIVA;
	
}
