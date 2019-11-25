package ec.cjpq.cjfews.comprobante.factura;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import ec.cjpq.cjfews.comprobante.DetAdicional;
import ec.cjpq.cjfews.comprobante.Impuesto;

@Data
public class Detalle {
	
	private String codigoPrincipal;
	private String codigoAuxiliar;
	private String descripcion;
	private String cantidad;
	private String precioUnitario;
	private String descuento;
	private String precioTotalSinImpuesto;
	private List<DetAdicional>detallesAdicionales;
	private List<Impuesto> impuestos = new ArrayList<Impuesto>();
	
}
