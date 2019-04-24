package ec.cjpq.cjfews.comprobante;

import ec.cjpq.util.Utileria;

import java.math.BigDecimal;
import java.math.RoundingMode;

import ec.cjpq.cjfews.comprobante.factura.Detalle;
import ec.cjpq.cjfews.comprobante.factura.Factura;
import ec.cjpq.cjfews.comprobante.notacredito.DetalleNotaCredito;
import ec.cjpq.cjfews.comprobante.notacredito.NotaCredito;
import ec.cjpq.cjfews.comprobante.notadebito.NotaDebito;
import ec.cjpq.cjfews.comprobante.notadebito.NotaDebitoImpuesto;

public class CalculoUtil {
	
	private BigDecimal totalIva;
	private BigDecimal subtotalIva;
	
	private BigDecimal subtotal0;
	private BigDecimal totalNoObjetoImpuesto;
	private BigDecimal totalExentoIva;
	private BigDecimal totalIce;
	private BigDecimal totalIrbpnr;
	private BigDecimal totalDescuento;

	private String leyendaIVA = "12%";
	
	public CalculoUtil() {
		totalIva 				= new BigDecimal(0);
		subtotalIva 			= new BigDecimal(0);
		subtotal0 				= new BigDecimal(0);
		totalNoObjetoImpuesto	= new BigDecimal(0);
		totalExentoIva 			= new BigDecimal(0);
		totalIce 				= new BigDecimal(0);
		totalIrbpnr 			= new BigDecimal(0);
		totalDescuento 			= new BigDecimal(0);
	}

	private String obtenerDecimales(String valor){
		return valor.equals("0") ? "0.00": valor;
	}
	
	private TotalComprobante obtenerTotales(){
		TotalComprobante tc = new TotalComprobante();
		tc.setSubtotalIva				(obtenerDecimales(subtotalIva.toString()));
		tc.setSubtotal0					(obtenerDecimales(subtotal0.toString()));
		tc.setSubtotalNoObjetoImpuesto	(obtenerDecimales(totalNoObjetoImpuesto.toString()));
		tc.setSubtotalExentoIva			(obtenerDecimales(totalExentoIva.toString()));
		tc.setTotalIce					(obtenerDecimales(totalIce.toString()));
		tc.setTotalIva					(obtenerDecimales(totalIva.toString()));
		tc.setIrbpnr					(obtenerDecimales(totalIrbpnr.toString()));
		tc.setTotalDescuento			(obtenerDecimales(totalDescuento.toString()));
		tc.setLeyendaIVA 				(leyendaIVA); 
			
		return tc;
	}

	private void calcularTotales(Impuesto impuesto){
		
		Parametro p = new Parametro();
		
		BigDecimal baseImponible = Utileria.parseToBigDecimal(impuesto.getBaseImponible());
		BigDecimal valor = Utileria.parseToBigDecimal(impuesto.getValor());

		if (impuesto.getCodigo().equals(p.getIvaCodigo())){
			if (impuesto.getCodigoPorcentaje().equals(p.getIva0Codigo()))
				subtotal0 = subtotal0.add( baseImponible ).setScale(2, RoundingMode.HALF_UP);
			else if (impuesto.getCodigoPorcentaje().equals(p.getNoObjetoImpuestoCodigo()))
				totalNoObjetoImpuesto = totalNoObjetoImpuesto.add(baseImponible).setScale(2, RoundingMode.HALF_UP);
			else if (impuesto.getCodigoPorcentaje().equals(p.getExentoIvaCodigo()))
	            totalExentoIva = totalExentoIva.add(baseImponible).setScale(2, RoundingMode.HALF_UP);
			else{
				//Determinar aquí si el código es iva12 ( p.getIva12Codigo() ) o iva14 que es cuando no se cumplen las condiciones anteriores
			
				//2016-06-07 Según TABLA 18 de la Ficha Técnica de Comprobantes Electrónicos del SRI
				if (impuesto.getCodigoPorcentaje().equals("2"))
					leyendaIVA = "12%";
				if (impuesto.getCodigoPorcentaje().equals("3"))
					leyendaIVA = "14%";
				
				subtotalIva = subtotalIva.add( baseImponible ).setScale(2, RoundingMode.HALF_UP);
				totalIva = totalIva.add( valor ).setScale(2, RoundingMode.HALF_UP);
			}
		}
		else if (impuesto.getCodigo().equals(p.getIceCodigo()))
			totalIce = totalIce.add(valor).setScale(2, RoundingMode.HALF_UP);
		else if (impuesto.getCodigo().equals(p.getIrbpnrCodigo()))
			totalIrbpnr = totalIrbpnr.add(valor).setScale(2, RoundingMode.HALF_UP);
	}
	
	public TotalComprobante calcularTotales(Factura factura){
		//Calcular todos los totales de los impuestos...
		for (Detalle detalle : factura.getDetalles()){
			for (Impuesto impuesto: detalle.getImpuestos())
				calcularTotales(impuesto);
		}
		
		// Calcular los totales de los descuentos...
		for (Detalle detalle : factura.getDetalles())
			totalDescuento = totalDescuento.add ( Utileria.parseToBigDecimal(detalle.getDescuento())).setScale(2, RoundingMode.HALF_UP);
		
		return obtenerTotales();
	}

	public TotalComprobante calcularTotales(NotaCredito notaCredito){
		//Calcular todos los totales de los impuestos...
		for (DetalleNotaCredito detalle : notaCredito.getDetalles()){
			for (Impuesto impuesto: detalle.getImpuestos())
				calcularTotales(impuesto);
		}

		for (DetalleNotaCredito detalle : notaCredito.getDetalles())
			totalDescuento = totalDescuento.add ( Utileria.parseToBigDecimal(detalle.getDescuento())).setScale(2, RoundingMode.HALF_UP);

		return obtenerTotales();
	}
	
	//Cálculo particular para las N/D
	public TotalComprobante calcularTotales(NotaDebito notaDebito){
		//Calcular todos los totales de los impuestos...
		for (NotaDebitoImpuesto impuesto: notaDebito.getInfoNotaDebito().getImpuestos()){
			Parametro p = new Parametro();
			
			BigDecimal baseImponible = Utileria.parseToBigDecimal(impuesto.getBaseImponible());
			BigDecimal valor = Utileria.parseToBigDecimal(impuesto.getValor());
	
			if (impuesto.getCodigo().equals(p.getIvaCodigo())){
				if (impuesto.getCodigoPorcentaje().equals(p.getIva0Codigo()))
					subtotal0 = subtotal0.add( baseImponible ).setScale(2, RoundingMode.HALF_UP);
				else if (impuesto.getCodigoPorcentaje().equals(p.getNoObjetoImpuestoCodigo()))
					totalNoObjetoImpuesto = totalNoObjetoImpuesto.add(baseImponible).setScale(2, RoundingMode.HALF_UP);
				else if (impuesto.getCodigoPorcentaje().equals(p.getExentoIvaCodigo()))
		            totalExentoIva = totalExentoIva.add(baseImponible).setScale(2, RoundingMode.HALF_UP);
				else{
					if (impuesto.getCodigoPorcentaje().equals("2"))
						leyendaIVA = "12%";
					if (impuesto.getCodigoPorcentaje().equals("3"))
						leyendaIVA = "14%";
					
					subtotalIva = subtotalIva.add( baseImponible ).setScale(2, RoundingMode.HALF_UP);
					totalIva = totalIva.add( valor ).setScale(2, RoundingMode.HALF_UP);
				}
			}
			else if (impuesto.getCodigo().equals(p.getIceCodigo()))
				totalIce = totalIce.add(valor).setScale(2, RoundingMode.HALF_UP);
			else if (impuesto.getCodigo().equals(p.getIrbpnrCodigo()))
				totalIrbpnr = totalIrbpnr.add(valor).setScale(2, RoundingMode.HALF_UP);
		}
		return obtenerTotales();
	}
	
}
