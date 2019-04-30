package ec.cjpq.fe.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import ec.cjpq.cjfews.comprobante.Configuracion;
import ec.cjpq.cjfews.comprobante.factura.Factura;
import ec.cjpq.cjfews.comprobante.guia.GuiaRemision;
import ec.cjpq.cjfews.comprobante.notacredito.NotaCredito;
import ec.cjpq.cjfews.comprobante.notadebito.NotaDebito;
import ec.cjpq.cjfews.comprobante.retencion.ComprobanteRetencion;
import ec.cjpq.cjfews.webservice.impl.CjfewsImpl;
import ec.cjpq.fe.bean.DocumentoBean;
import ec.cjpq.fe.dao.EntidadDao;
import ec.cjpq.fe.model.EmployeeId;
import ec.cjpq.fe.model.FeColaAut;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Proceso {
	
	private static final Logger log = LogManager.getLogger(Proceso.class);
	
	public void autorizarComprobante(Configuracion configuracion, List <FeColaAut> seleccionados, EmployeeId employee){
		Iterator iterator = seleccionados.iterator();
	    while ( iterator.hasNext() ) {
	    	FeColaAut item = (FeColaAut) iterator.next();

	    	// Realizar el procedimiento si el comprobante no ha sido autorizado...
	    	if ( ! item.getAutorizado() ){
				
				String resultado = "";
				boolean numeroNoEncontrado = false;
				int numero = Util.parseToInt(item.getNumeroSl());
				String fechaTrx = "";
				
				Comprobante tipo = null;
				if ( item.getTipoComp().equals("FA") ){
					tipo = Comprobante.FACTURA;
					Factura factura = new DocumentoBean(configuracion).getFactura( numero );
					if (factura != null)
						resultado = new CjfewsImpl().autorizarFactura(factura, configuracion);
					else
						numeroNoEncontrado = true;
				}
				
				if ( item.getTipoComp().equals("GR") ){
					tipo = Comprobante.GREMISION;
					GuiaRemision guiaRemision = new DocumentoBean(configuracion).getGuiaRemision( numero );
					if (guiaRemision != null)
						resultado = new CjfewsImpl().autorizarGuiaRemision(guiaRemision, configuracion);
					else
						numeroNoEncontrado = true;
				}
				
				if ( item.getTipoComp().equals("RE") ){
					tipo = Comprobante.CRETENCION;
					ComprobanteRetencion comprobanteRetencion = new DocumentoBean(configuracion).getComprobanteRetencion(numero );

					//2017-09-18
					fechaTrx = comprobanteRetencion.getInfoCompRetencion().getFechaEmision().replaceAll("/", "-");

					if (comprobanteRetencion != null)
						resultado = new CjfewsImpl().autorizarComprobanteRetencion(comprobanteRetencion, configuracion);
					else
						numeroNoEncontrado = true;
				}

				if ( item.getTipoComp().equals("NC") ){
					tipo = Comprobante.NCREDITO;
					NotaCredito notaCredito = new DocumentoBean(configuracion).getNotaCredito(numero );
					if (notaCredito != null)
						resultado = new CjfewsImpl().autorizarNotaCredito(notaCredito, configuracion);
					else
						numeroNoEncontrado = true;
				}

				if ( item.getTipoComp().equals("ND") ){
					tipo = Comprobante.NDEBITO;
					NotaDebito notaDebito = new DocumentoBean(configuracion).getNotaDebito(numero );
					if (notaDebito != null)
						resultado = new CjfewsImpl().autorizarNotaDebito(notaDebito, configuracion);
					else
						numeroNoEncontrado = true;
				}

				if (numeroNoEncontrado)
					resultado = "No existe "+item.getTipoComp()+" SQL-Ledger # "+item.getNumeroSl();
				else{
					
					//Actualizar los datos del comprobante AUTORIZADO...
					String[] cadena = resultado.split("\n");
					if (cadena[0].equals("AUTORIZADO")){
						item.setAutorizado(true);
						item.setNumAut	(cadena[2].substring(24));
						item.setFecAut	(cadena[3].substring(24));
						item.setNumSec	(cadena[4].substring(24));
						item.setArchivo	(cadena[5].substring(24));
						
						//Esta es la forma normal de traer la secuencia...
						//secuencia = new EntidadDao().getSecuenciaFactura((short)1); //Traer el primer registro
						
						//Esta es la forma de traer la secuencia, pero por empleado...
						int secuencia = new EntidadDao().getSecuenciaComprobanteEmpleado(tipo, employee.getLogin() );
						//Actualizar la secuencia del empleado
						log.warn(String.format("Nueva secuencia de comprobante %s: %s", tipo.toString(), secuencia));
						
						//Actualizo el POJO configuracion para que otras clases lean la secuencia recién acrtualizada...
						switch (tipo) {
						case FACTURA: 
							configuracion.setCfgSecuenciaFactura(secuencia); 
							//Grabar el número de autorización y la secuencia en "ar"
							new EntidadDao().actualizarFactura(new Integer(item.getNumeroSl()), item.getNumAut(), item.getNumSec());
							break;
						
						case CRETENCION: 
							configuracion.setCfgSecuenciaComprobanteRetencion(secuencia); 
							
							//2017-09-18 Antes grababa la fecha de autorización
							//String fecha = item.getFecAut().substring(0, 10);
							//DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
							
							//2017-09-24 grabar con máscara correcta
							DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
							try {
								Date date = format.parse(fechaTrx);
								//System.out.println(date);
								new EntidadDao().actualizarDatosRetencion(new Integer(item.getNumeroSl()), item.getNumAut(), item.getNumSec(), date);
							} catch (ParseException e) {
								log.warn( Util.stack2String(e) );
							}
							break;
						
						case GREMISION: 
							configuracion.setCfgSecuenciaGuiaRemision(secuencia); break;
						
						case NCREDITO: 
							configuracion.setCfgSecuenciaNotaCredito(secuencia); 
							//2016-08-04 Agregar este código para que actualice como en la factura
							new EntidadDao().actualizarFactura(new Integer(item.getNumeroSl()), item.getNumAut(), item.getNumSec());
							break;
						
						case NDEBITO: 
							configuracion.setCfgSecuenciaNotaDebito(secuencia); 
							//2016-08-05 Agregar este código para que actualice como en la factura
							new EntidadDao().actualizarFactura(new Integer(item.getNumeroSl()), item.getNumAut(), item.getNumSec());
							break;
						}
					}
		
					//Grabar el mensaje...
					log.warn(resultado);
					
					item.setMensaje(resultado);
					new EntidadDao().actualizarColaAutorizacion(item);
				}
			}
	    }		
		Util.mostrarMensaje("Proceso terminado...");
	}
	public void quitarComprobante(List <FeColaAut> seleccionados){
		for (FeColaAut item: seleccionados){
			new EntidadDao().quitarDeColaAutorizacion(item);
		}
	}

}
