package ec.cjpq.cjfews.comprobante.notadebito;

import lombok.Data;

@Data
public class NotaDebitoImpuesto {
	private String codigo;
	private String codigoPorcentaje;
	private String tarifa;
	private String baseImponible;
	private String valor;

}
