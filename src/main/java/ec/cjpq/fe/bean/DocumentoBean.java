package ec.cjpq.fe.bean;

import java.io.PrintWriter;
import java.math.BigDecimal;

import java.io.StringWriter;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import ec.cjpq.cjfews.comprobante.CampoAdicional;
import ec.cjpq.cjfews.comprobante.Configuracion;
import ec.cjpq.cjfews.comprobante.Impuesto;
import ec.cjpq.cjfews.comprobante.InfoTributaria;
import ec.cjpq.cjfews.comprobante.Pago;
import ec.cjpq.cjfews.comprobante.Parametro;
import ec.cjpq.cjfews.comprobante.TotalImpuesto;
import ec.cjpq.cjfews.comprobante.factura.Detalle;
import ec.cjpq.cjfews.comprobante.factura.Factura;
import ec.cjpq.cjfews.comprobante.factura.InfoFactura;
import ec.cjpq.cjfews.comprobante.guia.Destinatario;
import ec.cjpq.cjfews.comprobante.guia.GuiaRemision;
import ec.cjpq.cjfews.comprobante.guia.GuiaRemisionDetalle;
import ec.cjpq.cjfews.comprobante.guia.InfoGuiaRemision;
import ec.cjpq.cjfews.comprobante.notacredito.DetalleNotaCredito;
import ec.cjpq.cjfews.comprobante.notacredito.InfoNotaCredito;
import ec.cjpq.cjfews.comprobante.notacredito.NotaCredito;
import ec.cjpq.cjfews.comprobante.notadebito.InfoNotaDebito;
import ec.cjpq.cjfews.comprobante.notadebito.Motivo;
import ec.cjpq.cjfews.comprobante.notadebito.NotaDebito;
import ec.cjpq.cjfews.comprobante.notadebito.NotaDebitoImpuesto;
import ec.cjpq.cjfews.comprobante.retencion.ComprobanteRetencion;
import ec.cjpq.cjfews.comprobante.retencion.InfoCompRetencion;
import ec.cjpq.fe.dao.EntidadDao;
import ec.cjpq.fe.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({ "unchecked" })
public class DocumentoBean {
	
	private static final Logger log = LogManager.getLogger("DocumentoBean.class");
	private Configuracion configuracion;

	private Parametro parametro;

	private String codigoPorcentajeIva = null;
	
	public DocumentoBean(Configuracion configuracion) {
		this.configuracion = configuracion;
		parametro = new Parametro();
	}
	
	private InfoTributaria getInfoTributaria(){
		InfoTributaria infoT = new InfoTributaria();
		infoT.setAmbiente			( ""+ configuracion.getCfgTipoAmbiente() );
		infoT.setTipoEmision		( ""+ configuracion.getCfgTipoEmision() );
		infoT.setRazonSocial		( configuracion.getEmisorRazonSocial());
		infoT.setNombreComercial	( configuracion.getEmisorNombreComercial());
		infoT.setRuc				( configuracion.getEmisorRuc() );
		infoT.setEstab				( configuracion.getEmisorCodigoEstablecimiento() );
		infoT.setPtoEmi				( configuracion.getEmisorCodigoPuntoEmision() );
		infoT.setDirMatriz			( configuracion.getEmisorDireccionMatriz() );
		return infoT;
	}

	private List<CampoAdicional> getInfoAdicional(String... args){
		List<CampoAdicional> campoAdicional = new ArrayList();
		
		String tipo = args[0];
		
		//Definir el número (código interno) de la factura como campo adicional 
		campoAdicional.add(getCampoAdicional("Cod-Interno", args[1])); //numero
	
		//Concatenar e-mail con el teléfono
		String email = Util.transformarNuevaLineaEnEspacioEnBlanco(args[2]); 
		if ( email.length() > 0 )
			campoAdicional.add(getCampoAdicional("E-mail", email)); 
		
		String telefono = Util.transformarNuevaLineaEnEspacioEnBlanco(args[3]); 
		if ( telefono.length() > 0 ) 
			campoAdicional.add(getCampoAdicional("Teléfono", telefono)); 
		
		String ordenCompra 	= Util.transformarNuevaLineaEnEspacioEnBlanco(args[4]);
		if ( ordenCompra.length() > 0 ) 
			campoAdicional.add(getCampoAdicional("Orden de compra", ordenCompra)); 
		
		if (tipo.equals("FA")){
			String guiaRemision = Util.transformarNuevaLineaEnEspacioEnBlanco(args[5]);
			if ( guiaRemision.length() > 0 ) 
				campoAdicional.add(getCampoAdicional("Guía de Remisión", guiaRemision));
	
			//Comentado en 2015-12-02
			//	String noMigo		= Util.transformarNuevaLineaEnEspacioEnBlanco(Util.getColumna(cabecera[11]));
			//	if ( noMigo.length() > 0 ) 
			//		campoAdicional().add(getCampoAdoicional("No. de MIGO", noMigo));
		}
		
        //2017-11-23
        if (tipo.equals("NC")){
			String nota = Util.transformarNuevaLineaEnEspacioEnBlanco(args[5]);
			if ( nota.length() > 0 ) 
				campoAdicional.add(getCampoAdicional("Nota", nota));
        }

		return campoAdicional;
	}

	public Factura getFactura(int numero){
		
		Factura factura = null;
		Object []fac = new EntidadDao().getFactura(numero);
		Object []cabecera 		= (Object[]) fac[0];
		List <Object[]>detalles	= (List<Object[]>) fac[1];
		
		if (cabecera!=null && detalles!=null){
		    
		    try {
				
				factura = new Factura();
				factura.setId("comprobante");
				factura.setVersion("1.0.0");

				//------------------------------------------------
				InfoTributaria infoT = getInfoTributaria();
				infoT.setSecuencial			( Util.getSecuencial(""+ (configuracion.getCfgSecuenciaFactura() + 1) ));
				infoT.setCodDoc				( parametro.getFacturaCodigo() );
				factura.setInfoTributaria	( infoT );
				
				InfoFactura infoF = new InfoFactura();
				infoF.setFechaEmision			( Util.getColumna(cabecera[2]) );
				infoF.setDirEstablecimiento		( configuracion.getEmisorDireccionEstablecimiento() );
				infoF.setContribuyenteEspecial	( configuracion.getEmisorNumeroResolucion() );
				infoF.setObligadoContabilidad	( configuracion.getEmisorObligadoLlevarContabilidad() );
				
				String identificacion = Util.getColumna(cabecera[4]);
				infoF.setTipoIdentificacionComprador(identificacion.length()==13 ? parametro.getRucCodigo(): parametro.getCedulaCodigo());
				infoF.setRazonSocialComprador	(Util.getColumna(cabecera[3]));
				infoF.setIdentificacionComprador(identificacion);

				infoF.setPropina		("0.00");
				infoF.setImporteTotal	( Util.parseToBigDecimal(Util.getColumna(cabecera[7])).setScale(2, RoundingMode.HALF_UP).toString() );
				infoF.setMoneda			( parametro.getDolarDescripcion() );
				factura.setInfoFactura(infoF);
				
				//Detalle

				BigDecimal totBaseImpIva0    = new BigDecimal(0);
				BigDecimal totBaseImpIva     = new BigDecimal(0);
				BigDecimal totalIva          = new BigDecimal(0);
				BigDecimal totalSinImpuestos = new BigDecimal(0);
				BigDecimal totalDescuento    = new BigDecimal(0);

				BigDecimal valorTarifa       = new BigDecimal(0);
                String tarifa                = "";
                String porcTotalIva          = "";

				for (Object[] det: detalles){
					
					Detalle detalle = new Detalle();

					BigDecimal cantidad = Util.parseToBigDecimal(Util.getColumna(det[3]));
					BigDecimal precio  	= Util.parseToBigDecimal(Util.getColumna(det[4]));
					BigDecimal porcIva 	= Util.parseToBigDecimal(Util.getColumna(det[5]));
					BigDecimal descuento= Util.parseToBigDecimal(Util.getColumna(det[6]));
					BigDecimal precDesc = Util.parseToBigDecimal(Util.getColumna(det[7]));

                    //2017-11-29
                    String numeroLote = Util.getColumna(det[8]);
                    //2017-11-30 Ignorar caracteres después de "-"
                    numeroLote = numeroLote.split("-")[0];

					BigDecimal baseImp 	= cantidad.multiply(precDesc).setScale(2, RoundingMode.HALF_UP);
					BigDecimal val 		= baseImp.multiply(porcIva).setScale(2, RoundingMode.HALF_UP);
					
					String codigoAuxiliar = Util.getColumna(det[1]);
					detalle.setCodigoPrincipal			(Util.getColumna(det[0]));
					detalle.setCodigoAuxiliar			( (codigoAuxiliar.length()==0 ? "S/N": codigoAuxiliar) + " " + numeroLote );
					detalle.setDescripcion				(Util.getColumna(det[2]));
					detalle.setCantidad					(cantidad.toString());
					detalle.setPrecioUnitario			(precio.toString());
					detalle.setDescuento				(descuento.toString());
					detalle.setPrecioTotalSinImpuesto	(baseImp.toString());
						
					//Sumar el descuento
					totalDescuento = totalDescuento.add(descuento).setScale(2, RoundingMode.HALF_UP);
					
					Impuesto impuesto = new Impuesto();
					impuesto.setCodigo(parametro.getIvaCodigo());
					
                    //Refactoring 5,10,11 feb
                    if (porcIva.compareTo(BigDecimal.ZERO) == 0) {
                        codigoPorcentajeIva = parametro.getIva0Codigo();
                        tarifa              = parametro.getIva0Descripcion();
						totBaseImpIva0      = totBaseImpIva0.add( baseImp ).setScale(2, RoundingMode.HALF_UP);
                        valorTarifa         = new BigDecimal(0);
                    }

                    else{
                        if (porcIva.compareTo(BigDecimal.valueOf(0.12)) == 0 ) {
                            codigoPorcentajeIva = parametro.getIva12Codigo();
                            tarifa              = parametro.getIva12Descripcion();
                        }
                        if (porcIva.compareTo(BigDecimal.valueOf(0.14)) == 0 ) {
                            codigoPorcentajeIva = parametro.getIva14Codigo();
                            tarifa              = parametro.getIva14Descripcion();
                        }

                        totBaseImpIva = totBaseImpIva.add( baseImp ).setScale(2, RoundingMode.HALF_UP); 
						totalIva    = totalIva.add( val ).setScale(2, RoundingMode.HALF_UP);
                        valorTarifa = totalIva ;

                        // Bandera que captura el porcentaje de iva <>0 para usarlo en totalConImpuestos
                        if (porcTotalIva.equals(""))
                            porcTotalIva = codigoPorcentajeIva;
                    }

                    impuesto.setCodigoPorcentaje(codigoPorcentajeIva); 
                    impuesto.setTarifa(tarifa);

                    totalSinImpuestos = totalSinImpuestos.add( baseImp).setScale(2, RoundingMode.HALF_UP);
						
					impuesto.setBaseImponible(baseImp.toString());
					impuesto.setValor(val.toString());
					detalle.getImpuestos().add(impuesto);
					
					factura.getDetalles().add(detalle);
				}
				infoF.setTotalSinImpuestos( totalSinImpuestos.toString() );
				infoF.setTotalDescuento	( totalDescuento.toString() );

                //11-feb
                //Agregar el nodo totalConImpuestos con los totales de iva0 e iva<>0 si los hubiere
                if (totBaseImpIva0.compareTo(BigDecimal.ZERO) != 0) {
                    //codigoPorcentaje = 0
                    //tarifa = 0
                    TotalImpuesto tImp = new TotalImpuesto();
                    tImp.setCodigo            ( parametro.getIvaCodigo  () );
                    tImp.setCodigoPorcentaje  ( parametro.getIva0Codigo () );
                    tImp.setBaseImponible     ( totBaseImpIva0.toString () );
                    tImp.setValor             ( "0.00");
                    infoF.getTotalConImpuestos().add(tImp);
                }
                
                if (totBaseImpIva.compareTo(BigDecimal.ZERO) != 0) {
                    //codigoPorcentaje = 2
                    //tarifa = 12
                    TotalImpuesto tImp = new TotalImpuesto();
                    tImp.setCodigo             ( parametro.getIvaCodigo () );
                    tImp.setCodigoPorcentaje   ( porcTotalIva );
                    tImp.setBaseImponible      ( totBaseImpIva.toString () );
                    tImp.setValor              ( totalIva.toString      () );
                    infoF.getTotalConImpuestos ().add(tImp);
                }
				
				List <CampoAdicional> campoAdicional = getInfoAdicional("FA", 
					""+numero, 
					Util.getColumna(cabecera[5]), //email
					Util.getColumna(cabecera[6]), //telefono
					Util.getColumna(cabecera[9]), //ordenCompra
					Util.getColumna(cabecera[10]) //guiaRemision
				);
				for (CampoAdicional ca: campoAdicional)
					factura.getInfoAdicional().add(ca);
				
				// 2016-01-04
				configuracion.setEmailCc( Util.getColumna(cabecera[12]) );

				// 2016-09-01 Agregar las formas de pago
				String notasInternas = Util.getColumna(cabecera[14]);
				//Convertir los ENTER de MS WINDOWS
				notasInternas.replaceAll("\r\n", "\n");
			
				//Leer las formas de pago
				String arreglo[] = new String[5];
				for (String linea: notasInternas.split("\n") ){
					if ( linea.substring(0, 2).equals("FP") ){
						String[] cadena = linea.split(",");
						
						int i = 0; //0=FP, 1=19, 2=900, ...
						for (String valor: cadena){
							if (i>0)
								arreglo[i-1] = valor;
							i++;
						}

						Pago pago = new Pago();	
						pago.setFormaPago	(arreglo[0]);
						pago.setTotal		(arreglo[1]);
						pago.setPlazo		(arreglo[2]);
						pago.setUnidadTiempo(arreglo[3]);

						infoF.getPagos().add(pago);
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				String mensaje = Util.stack2String(e);
				log.warn(mensaje);
				//TODOs: Descomentar en produccion
				//Util.mostrarMensaje(mensaje);
			} 
		}
		return factura;
	}

	public NotaCredito getNotaCredito(int numero){
		
		NotaCredito notaCredito = null;
		Object []fac = new EntidadDao().getFactura(numero);
		Object []cabecera 		= (Object[]) fac[0];
		List <Object[]>detalles	= (List<Object[]>) fac[1];

		if (cabecera!=null && detalles!=null){
		
			try {
				
				notaCredito = new NotaCredito();
				notaCredito.setId("comprobante");
				notaCredito.setVersion("1.0.0");
				
				InfoTributaria infoT = getInfoTributaria();
				infoT.setSecuencial			( Util.getSecuencial(""+ (configuracion.getCfgSecuenciaNotaCredito() + 1) ));
				infoT.setCodDoc				( parametro.getNotaCreditoCodigo() );
				notaCredito.setInfoTributaria	( infoT );
				
				InfoNotaCredito infoNC = new InfoNotaCredito();
				infoNC.setFechaEmision			( Util.getColumna(cabecera[2]) );
				infoNC.setDirEstablecimiento	( configuracion.getEmisorDireccionEstablecimiento() );
				infoNC.setContribuyenteEspecial	( configuracion.getEmisorNumeroResolucion() );
				infoNC.setObligadoContabilidad	( configuracion.getEmisorObligadoLlevarContabilidad() );
				
				String identificacion = Util.getColumna(cabecera[4]);
				infoNC.setTipoIdentificacionComprador(identificacion.length()==13 ? parametro.getRucCodigo(): parametro.getCedulaCodigo());
				infoNC.setRazonSocialComprador	(Util.getColumna(cabecera[3]));
				infoNC.setIdentificacionComprador(identificacion);
				
				infoNC.setCodDocModificado(parametro.getFacturaCodigo());
				infoNC.setNumDocModificado("");
				infoNC.setMoneda( parametro.getDolarDescripcion() );
			
				//2016-09-01 Cambio de índice 14 a 10 porque está duplicado en el DAO.
				//El índice 14 será para intnotes
				String numeroFactura = Util.getColumna(cabecera[10]); //campo "notes" o Guia Remision en NC
				//Obtengo la fecha de la factura y otros datos
				Object []datos = new EntidadDao().getDatosArInvoice(numeroFactura);
				infoNC.setMotivo(Util.getColumna(cabecera[13]));
				infoNC.setNumDocModificado(numeroFactura);
				infoNC.setFechaEmisionDocSustento(datos[0].toString());
				infoNC.setValorModificacion(Util.parseToBigDecimal(Util.getColumna(cabecera[7])).multiply(new BigDecimal(-1)).setScale(2, RoundingMode.HALF_UP).toString() );
				
				notaCredito.setInfoNotaCredito(infoNC);
				
				BigDecimal totBaseImpIva0    = new BigDecimal(0);
				BigDecimal totBaseImpIva     = new BigDecimal(0);
				BigDecimal totalIva          = new BigDecimal(0);
				BigDecimal totalSinImpuestos = new BigDecimal(0);
				BigDecimal totalDescuento    = new BigDecimal(0);

				BigDecimal valorTarifa       = new BigDecimal(0);
                String tarifa                = "";
                String porcTotalIva          = "";
				
                for (Object[] det: detalles){
					
					DetalleNotaCredito detalleNC = new DetalleNotaCredito();

					BigDecimal cantidad = Util.parseToBigDecimal(Util.getColumna(det[3]));
					cantidad = cantidad.multiply(new BigDecimal(-1));
					
					BigDecimal precio  	= Util.parseToBigDecimal(Util.getColumna(det[4]));
					BigDecimal porcIva 	= Util.parseToBigDecimal(Util.getColumna(det[5]));
					BigDecimal descuento= Util.parseToBigDecimal(Util.getColumna(det[6]));
					BigDecimal precDesc = Util.parseToBigDecimal(Util.getColumna(det[7]));

					BigDecimal baseImp 	= cantidad.multiply(precDesc).setScale(2, RoundingMode.HALF_UP);
					BigDecimal val 		= baseImp.multiply(porcIva).setScale(2, RoundingMode.HALF_UP);
					
					String codigoAdicional = Util.getColumna(det[1]);
					detalleNC.setCodigoInterno			(Util.getColumna(det[0]));
					detalleNC.setCodigoAdicional		(codigoAdicional.length()==0 ? "S/N": codigoAdicional);
					detalleNC.setDescripcion			(Util.getColumna(det[2]));
					detalleNC.setCantidad				(cantidad.toString());
					detalleNC.setPrecioUnitario			(precio.toString());
					detalleNC.setDescuento				(descuento.toString());
					detalleNC.setPrecioTotalSinImpuesto	(baseImp.toString());
						
					//Sumar el descuento
					totalDescuento = totalDescuento.add(descuento).setScale(2, RoundingMode.HALF_UP);
					
					Impuesto impuesto = new Impuesto();
					impuesto.setCodigo(parametro.getIvaCodigo());
					
                    //Refactoring 18 abril
                    if (porcIva.compareTo(BigDecimal.ZERO) == 0) {
                        codigoPorcentajeIva = parametro.getIva0Codigo();
                        tarifa              = parametro.getIva0Descripcion();
						totBaseImpIva0      = totBaseImpIva0.add( baseImp ).setScale(2, RoundingMode.HALF_UP);
                        valorTarifa         = new BigDecimal(0);
                    }

                    else{
                        if (porcIva.compareTo(BigDecimal.valueOf(0.12)) == 0 ) {
                            codigoPorcentajeIva = parametro.getIva12Codigo();
                            tarifa              = parametro.getIva12Descripcion();
                        }
                        if (porcIva.compareTo(BigDecimal.valueOf(0.14)) == 0 ) {
                            codigoPorcentajeIva = parametro.getIva14Codigo();
                            tarifa              = parametro.getIva14Descripcion();
                        }

                        totBaseImpIva = totBaseImpIva.add( baseImp ).setScale(2, RoundingMode.HALF_UP); 
						totalIva    = totalIva.add( val ).setScale(2, RoundingMode.HALF_UP);
                        valorTarifa = totalIva ;

                        // Bandera que captura el porcentaje de iva <>0 para usarlo en totalConImpuestos
                        if (porcTotalIva.equals(""))
                            porcTotalIva = codigoPorcentajeIva;
                    }
                    
                    impuesto.setCodigoPorcentaje(codigoPorcentajeIva); 
                    impuesto.setTarifa(tarifa);

                    totalSinImpuestos = totalSinImpuestos.add( baseImp).setScale(2, RoundingMode.HALF_UP);
					
					impuesto.setBaseImponible(baseImp.toString());
					impuesto.setValor(val.toString());
					detalleNC.getImpuestos().add(impuesto);
					
					notaCredito.getDetalles().add(detalleNC);
				}
				infoNC.setTotalSinImpuestos( totalSinImpuestos.toString() );
				//infoNC.setTotalDescuento ( totalDescuento.toString() );
				
                //18-Abr
                //Agregar el nodo totalConImpuestos con los totales de iva0 e iva<>0 si los hubiere
                if (totBaseImpIva0.compareTo(BigDecimal.ZERO) != 0) {
                    //codigoPorcentaje = 0
                    //tarifa = 0
                    TotalImpuesto tImp = new TotalImpuesto();
                    tImp.setCodigo            ( parametro.getIvaCodigo  () );
                    tImp.setCodigoPorcentaje  ( parametro.getIva0Codigo () );
                    tImp.setBaseImponible     ( totBaseImpIva0.toString () );
                    tImp.setValor             ( "0.00");
                    infoNC.getTotalConImpuestos().add(tImp);
                }
                
                if (totBaseImpIva.compareTo(BigDecimal.ZERO) != 0) {
                    //codigoPorcentaje = 2
                    //tarifa = 12
                    TotalImpuesto tImp = new TotalImpuesto();
                    tImp.setCodigo             ( parametro.getIvaCodigo () );
                    tImp.setCodigoPorcentaje   ( porcTotalIva );
                    tImp.setBaseImponible      ( totBaseImpIva.toString () );
                    tImp.setValor              ( totalIva.toString      () );
                    infoNC.getTotalConImpuestos ().add(tImp);
                }
				
                //2017-11-23
				String notasInternas = Util.getColumna(cabecera[14]);
				//Convertir los ENTER de MS WINDOWS
				notasInternas.replaceAll("\r\n", "\n");
                String nota = "";
	        	if ( notasInternas.substring(0, 4).equals("NOTA") ){
	        	    String[] cadena = notasInternas.split(",");
                    nota = cadena[1];
                }
				
                List <CampoAdicional> campoAdicional = getInfoAdicional("NC", 
					""+numero, 
					Util.getColumna(cabecera[5]), //email
					Util.getColumna(cabecera[6]), //telefono
					Util.getColumna(cabecera[9]), //ordenCompra
					//Util.getColumna(cabecera[10]) //guiaRemision comentado 2017-11-23
                    nota
				);
				for (CampoAdicional ca: campoAdicional)
					notaCredito.getInfoAdicional().add(ca);
				
				configuracion.setEmailCc( Util.getColumna(cabecera[12]) );
			} catch (Exception e) {
				e.printStackTrace();
				String mensaje = Util.stack2String(e);
				log.warn(mensaje);
			} 
		}
		return notaCredito;
	}
	
	public GuiaRemision getGuiaRemision(int numero){
		GuiaRemision guiaRemision = null;
		
		Object []fac = new EntidadDao().getFactura(numero);
		Object []cabecera 		= (Object[]) fac[0];
		List <Object[]>detalles	= (List<Object[]>) fac[1];
		
		if (cabecera!=null && detalles!=null){

			try {
				DatosGuiaRemision datos = new EntidadDao().getDatosGuiaRemision(numero);
				guiaRemision = new GuiaRemision();
				guiaRemision.setId("comprobante");
				guiaRemision.setVersion("1.1.0");
				
				InfoTributaria infoT = getInfoTributaria();
				infoT.setSecuencial			( Util.getSecuencial(""+ (configuracion.getCfgSecuenciaGuiaRemision() + 1) )); //Variante
				infoT.setCodDoc				( parametro.getGuiaRemisionCodigo() );
				guiaRemision.setInfoTributaria(infoT);
				
				InfoGuiaRemision igr = new InfoGuiaRemision();
				igr.setDirEstablecimiento(configuracion.getEmisorDireccionEstablecimiento());
				igr.setDirPartida(datos.getPuntoPartida());
				igr.setRazonSocialTransportista(datos.getTransportistaRazonSocial());
				
				igr.setRucTransportista(datos.getTransportistaId());
				igr.setTipoIdentificacionTransportista( datos.getTransportistaId().length()==13 ? parametro.getRucCodigo(): parametro.getCedulaCodigo());
				
				igr.setObligadoContabilidad	( configuracion.getEmisorObligadoLlevarContabilidad() );
				igr.setContribuyenteEspecial( configuracion.getEmisorNumeroResolucion() );
				igr.setFechaIniTransporte(datos.getFecha());
				igr.setFechaFinTransporte(datos.getFecha());
				igr.setPlaca(datos.getPlaca());
				guiaRemision.setInfoGuiaRemision(igr);
				
				Destinatario destinatario = new Destinatario();
				destinatario.setIdentificacionDestinatario(datos.getDestinatarioId());
				destinatario.setRazonSocialDestinatario(datos.getDestinatarioRazonSocial());
				destinatario.setDirDestinatario(datos.getPuntoLlegada());
				destinatario.setMotivoTraslado(datos.getMotivoTraslado());
				
				destinatario.setCodDocSustento(parametro.getFacturaCodigo());
				destinatario.setNumDocSustento(datos.getNumeroFactura());
				destinatario.setNumAutDocSustento(datos.getNumeroAutorizacionFactura());
				destinatario.setFechaEmisionDocSustento(datos.getFecha());
				
				for (Object[] det: detalles){
					GuiaRemisionDetalle detalle = new GuiaRemisionDetalle();
                    
                    //2017-12-05
                    String numeroLote = Util.getColumna(det[8]);
                    numeroLote = numeroLote.split("-")[0];
					
					String codigoAdicional = Util.getColumna(det[1]);
					detalle.setCodigoInterno	(Util.getColumna(det[0]));
					detalle.setCodigoAdicional	( (codigoAdicional.length()==0 ? "S/N": codigoAdicional) + " " + numeroLote );
					detalle.setDescripcion		(Util.getColumna(det[2]));
					detalle.setCantidad			(Util.getColumna(det[3]));
					destinatario.getDetalles().add(detalle);
				}
				guiaRemision.getDestinatarios().add(destinatario);
				
				List <CampoAdicional> campoAdicional = getInfoAdicional("GR", 
					""+numero, 
					Util.getColumna(cabecera[5]), //email
					Util.getColumna(cabecera[6]), //telefono
					Util.getColumna(cabecera[9])  //ordenCompra
				);
				for (CampoAdicional ca: campoAdicional)
					guiaRemision.getInfoAdicional().add(ca);
				
				configuracion.setEmailCc( Util.getColumna(cabecera[12]) );
				
			} catch (Exception e) {
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				log.warn(errors.toString());
				
//				String mensaje = Util.stack2String(e);
//				log.warn(mensaje);
			}
		}
		return guiaRemision;
	}
	
	public ComprobanteRetencion getComprobanteRetencion(int numero){
		ComprobanteRetencion comprobanteRetencion = null;
		
		boolean primerRegistro = true;
		try{
			DatosRetencion dr = new DatosRetencion();
			dr.setId(numero);
			
			for (DatosRetencion o: new EntidadDao().getConsultaRetencionList(dr, 0, 0 ) ){
				if (primerRegistro){
					primerRegistro = false;
					
					if (o.getCc() !=null || o.getCc().length() > 0)
						configuracion.setEmailCc( o.getCc() );

					comprobanteRetencion = new ComprobanteRetencion();
					comprobanteRetencion.setId("comprobante");
					comprobanteRetencion.setVersion("1.0.0");				
	
					InfoTributaria infoT = getInfoTributaria();
					infoT.setSecuencial			( Util.getSecuencial(""+ (configuracion.getCfgSecuenciaComprobanteRetencion() + 1) )); //Variante
					infoT.setCodDoc				( parametro.getComprobanteRetencionCodigo());
					comprobanteRetencion.setInfoTributaria(infoT);
					
					InfoCompRetencion icr = new InfoCompRetencion();
					//icr.setFechaEmision(Util.getFechaSistema());
					//2017-08-21
					//2017-08-27 las fechas deben tener el separador / y no -
					icr.setFechaEmision( o.getTransdate().replaceAll("-", "/") );

					icr.setDirEstablecimiento		( configuracion.getEmisorDireccionEstablecimiento() );
					icr.setContribuyenteEspecial	( configuracion.getEmisorNumeroResolucion() );
					icr.setObligadoContabilidad		( configuracion.getEmisorObligadoLlevarContabilidad() );
					
					String identificacion = o.getIdprov();
					icr.setTipoIdentificacionSujetoRetenido(identificacion.length()==13 ? parametro.getRucCodigo(): parametro.getCedulaCodigo());
					icr.setRazonSocialSujetoRetenido(o.getName());
					icr.setIdentificacionSujetoRetenido(identificacion);
					icr.setPeriodoFiscal( o.getTransdate().substring(3).replaceAll("-", "/") );
					comprobanteRetencion.setInfoCompRetencion(icr);

					List <CampoAdicional> campoAdicional = getInfoAdicional("RE", 
						""+o.getId(), 
						o.getEmail(), //email
						o.getPhone(), //telefono
						"" //ordenCompra (no aplica)
					);
					for (CampoAdicional ca: campoAdicional)
						comprobanteRetencion.getInfoAdicional().add(ca);
				}
				
				ec.cjpq.cjfews.comprobante.retencion.Impuesto impuesto = new ec.cjpq.cjfews.comprobante.retencion.Impuesto();
				String tipoImpuesto = o.getTiporet().trim().toUpperCase();
				String codigoImpuesto = "";
				if (tipoImpuesto.equals("RENTA"))
					codigoImpuesto = "1";
				if (tipoImpuesto.equals("IVA"))
					codigoImpuesto = "2";
				if (tipoImpuesto.equals("ISD"))
					codigoImpuesto = "6";
				
				impuesto.setCodigo(codigoImpuesto);
				impuesto.setCodigoRetencion(""+o.getTiporetId());
			
				//2016-08-23 Acumular los valores de la base imponible
				//Double baseImponible = o.getBase0() + o.getBased0() + o.getBaseni();   
				BigDecimal baseImponible = new BigDecimal(0);
				
				//totalIva = totalIva.add( valor ).setScale(2, RoundingMode.HALF_UP);
				
				if ( o.getBase0()!=null )
					baseImponible = baseImponible.add( new BigDecimal(o.getBase0())).setScale(2, RoundingMode.HALF_UP);
						
				if ( o.getBased0()!=null )
					baseImponible = baseImponible.add( new BigDecimal(o.getBased0())).setScale(2, RoundingMode.HALF_UP);
						
				if ( o.getBaseni()!=null )
					baseImponible = baseImponible.add( new BigDecimal(o.getBaseni())).setScale(2, RoundingMode.HALF_UP);
						
				impuesto.setBaseImponible(baseImponible.toString());
					
				impuesto.setPorcentajeRetener(""+o.getPorcret());	
				impuesto.setValorRetenido(o.getValret().toString());
				impuesto.setCodDocSustento(o.getTipodocId());
				impuesto.setNumDocSustento(o.getEstab()+o.getPtoemi()+String.format("%09d", Util.parseToInt(o.getSec())));
				impuesto.setFechaEmisionDocSustento( o.getTransdate().replaceAll("-", "/") );
				comprobanteRetencion.getImpuestos().add(impuesto);
			}
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			log.warn(errors.toString());
		}
		return comprobanteRetencion;
	}
	
	public NotaDebito getNotaDebito(int numero){
		NotaDebito notaDebito = null;
		
		DatosAr dap = new DatosAr();
		dap.setId(new Integer(numero));
		dap.setTipo("5"); //ND
	
		//Solo obtiene un registro (si lo encuentra)
		for (DatosAr o: new EntidadDao().getConsultaArList(dap, 0, 1 ) ){
			try{
				notaDebito = new NotaDebito();
				notaDebito.setId("comprobante");
				notaDebito.setVersion("1.0.0");
				
				InfoTributaria infoT = getInfoTributaria();
				infoT.setSecuencial			( Util.getSecuencial(""+ (configuracion.getCfgSecuenciaNotaDebito() + 1) ));
				infoT.setCodDoc				( parametro.getNotaDebitoCodigo() );
				notaDebito.setInfoTributaria	( infoT );
				
				InfoNotaDebito infoND = new InfoNotaDebito();
				infoND.setFechaEmision			( o.getTransdate() );
				infoND.setDirEstablecimiento	( configuracion.getEmisorDireccionEstablecimiento() );
				infoND.setContribuyenteEspecial	( configuracion.getEmisorNumeroResolucion() );
				infoND.setObligadoContabilidad	( configuracion.getEmisorObligadoLlevarContabilidad() );
				
				String identificacion = o.getTaxnumber();
				infoND.setTipoIdentificacionComprador(identificacion.length()==13 ? parametro.getRucCodigo(): parametro.getCedulaCodigo());
				infoND.setRazonSocialComprador	(o.getName());
				infoND.setIdentificacionComprador(identificacion);
				
				//Consultar los datos de la factura referenciada
				Object []datos = new EntidadDao().getDatosArInvoice(o.getNotes());
				infoND.setCodDocModificado(parametro.getFacturaCodigo());
				infoND.setNumDocModificado(o.getNotes());
				infoND.setFechaEmisionDocSustento(datos[0].toString());
				
				//TODO: 0 Agregar los impuestos y los que no pagan IVA
				Object []impuestos   = new EntidadDao().getImpuestoAr(numero);
				String valorImpuesto = "0";
				String porcIva       = "";
				
				NotaDebitoImpuesto impuesto = new NotaDebitoImpuesto();
				impuesto.setCodigo(parametro.getIvaCodigo());
				
				if (impuestos != null){
					valorImpuesto = ((Double) impuestos[0]).toString();
					porcIva       = ((Double) impuestos[1]).toString();
					
					if ( porcIva.equals("0.12") ) {
						impuesto.setCodigoPorcentaje(parametro.getIva12Codigo());
						impuesto.setTarifa(parametro.getIva12Descripcion());
					}
					if ( porcIva.equals("0.14") ) {
						impuesto.setCodigoPorcentaje(parametro.getIva14Codigo());
						impuesto.setTarifa(parametro.getIva14Descripcion());
					}
				}else{
					impuesto.setCodigoPorcentaje(parametro.getNoObjetoImpuestoCodigo());
					impuesto.setTarifa("0");
				}

				impuesto.setBaseImponible(o.getNetamount().toString());
				impuesto.setValor(valorImpuesto);
				infoND.getImpuestos().add(impuesto);

				String valor = "" + Math.abs(o.getAmount().doubleValue());
				infoND.setTotalSinImpuestos( o.getNetamount().toString() );
				infoND.setValorTotal( valor );
		
				notaDebito.setInfoNotaDebito(infoND);
			
				for (Motivo m: new EntidadDao().getMotivosAp( new Integer(numero) ))
					notaDebito.getMotivos().add(m);

                //2018-06-12 Para prueba de autorizacion
                /*
                Motivo m = new Motivo(); 
                m.setRazon("Prueba");
                m.setValor("36.55");
				notaDebito.getMotivos().add(m);
                */

				//List <CampoAdicional> campoAdicional = getInfoAdicional("ND", ""+numero, o.getEmail(), o.getPonumber(), "", "" );
				List <CampoAdicional> campoAdicional = getInfoAdicional("ND", 
					""+o.getId(), 
					o.getEmail(), //email
					o.getPhone(), //telefono
					o.getPonumber() //Orden de compra
				);
				
				for (CampoAdicional ca: campoAdicional)
					notaDebito.getInfoAdicional().add(ca);
				
				if (o.getCc() !=null || o.getCc().length() > 0)
					configuracion.setEmailCc( o.getCc() );

			} catch (Exception e) {
				e.printStackTrace();
				String mensaje = Util.stack2String(e);
				log.warn(mensaje);
			} 
		}
		return notaDebito;
	}
	
	/**
	 * Devuelve un objeto CampoAdicional
	 * @param nombre
	 * @param valor
	 * @return
	 */
	private CampoAdicional getCampoAdicional(String nombre, String valor){
		CampoAdicional campoAdicional = new CampoAdicional();
		campoAdicional.setNombre(nombre);
		campoAdicional.setValor(valor);
		return campoAdicional;
	}

}
