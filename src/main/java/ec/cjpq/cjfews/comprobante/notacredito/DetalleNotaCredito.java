package ec.cjpq.cjfews.comprobante.notacredito;

import java.util.List;

import lombok.Data;
import ec.cjpq.cjfews.comprobante.DetAdicional;
import ec.cjpq.cjfews.comprobante.Impuesto;

/**
 * Pojo para el XML del nodo NotaCredito/Detalles/Detalle
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2015-03-18
 */
@Data
public class DetalleNotaCredito {
	
	private String codigoInterno;
	private String codigoAdicional;
	private String descripcion;
	private String cantidad;
	private String precioUnitario;
	private String descuento;
	private String precioTotalSinImpuesto;
	private List<DetAdicional>detallesAdicionales;
	private List<Impuesto> impuestos;
	
}
