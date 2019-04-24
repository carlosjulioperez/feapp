package ec.cjpq.cjfews.comprobante;

import lombok.Data;

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
