package ec.cjpq.cjfews.comprobante;

import lombok.Data;

@Data
public class TotalImpuesto {
	
	private String codigo;
	private String codigoPorcentaje;
	private String baseImponible;
	private String valor;
	
}
