package ec.cjpq.cjfews.comprobante;

import lombok.Data;

/**
 * Clase general para usarla en los POJO de los XML respectivos (Factura, Nota de Credito)
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2015-03-18
 */
@Data
public class InfoTributaria {

	private String ambiente;
	private String tipoEmision;
	private String razonSocial;
	private String nombreComercial;
	private String ruc;
	private String claveAcceso;
	private String codDoc;
	private String estab;
	private String ptoEmi;
	private String secuencial;
	private String dirMatriz;
	
}
