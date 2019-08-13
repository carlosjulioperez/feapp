package ec.cjpq.cjfews.comprobante.notacredito;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import ec.cjpq.cjfews.comprobante.DetAdicional;
import ec.cjpq.cjfews.comprobante.Impuesto;

@Data
public class DetalleNotaCredito {
	
	private String codigoInterno;
	private String codigoAdicional;
	private String descripcion;
	private String cantidad;
	private String precioUnitario;
	private String descuento;
	private String precioTotalSinImpuesto;
	private List<DetAdicional>detallesAdicionales = new ArrayList<DetAdicional>();
	private List<Impuesto> impuestos = new ArrayList<Impuesto>();
	
}
