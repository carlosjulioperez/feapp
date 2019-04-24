package ec.cjpq.cjfews.comprobante.factura;

import java.util.List;

import lombok.Data;
import ec.cjpq.cjfews.comprobante.TotalImpuesto;
import ec.cjpq.cjfews.comprobante.Pago;

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
