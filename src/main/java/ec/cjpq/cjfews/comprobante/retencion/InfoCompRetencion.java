package ec.cjpq.cjfews.comprobante.retencion;

import lombok.Data;

/**
 * Pojo para el XML de la Informacion del Comprobante de Retención
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2016-06-08
 */
@Data
public class InfoCompRetencion {

	private String fechaEmision;
	private String dirEstablecimiento;
	private String contribuyenteEspecial;
	private String obligadoContabilidad;
	private String tipoIdentificacionSujetoRetenido;
	private String razonSocialSujetoRetenido;
	private String identificacionSujetoRetenido;
	private String periodoFiscal;
}
