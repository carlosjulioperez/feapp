package ec.cjpq.cjfews.comprobante.factura;

import java.util.List;

import lombok.Data;
import ec.cjpq.cjfews.comprobante.TotalImpuesto;
import ec.cjpq.cjfews.comprobante.Pago;

/**
 * Pojo para el XML de la Informacion de la Nota de Credito
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2015-03-18
 * 2016-08-31 Agregar Pago
 */
@Data
public class InfoFactura {

	private String fechaEmision;
	private String dirEstablecimiento;
	private String contribuyenteEspecial;
	private String obligadoContabilidad;
	private String tipoIdentificacionComprador;
	private String guiaRemision;
	private String razonSocialComprador;
	private String identificacionComprador;
	private String totalSinImpuestos;
	private String totalDescuento;
	private List<TotalImpuesto> totalConImpuestos;
	private String propina;
	private String importeTotal;
	private String moneda;
	private List<Pago> pagos;

}
