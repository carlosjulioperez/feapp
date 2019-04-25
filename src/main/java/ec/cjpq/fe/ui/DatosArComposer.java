package ec.cjpq.fe.ui;

import java.sql.SQLException;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;

import org.zkoss.zkplus.databind.AnnotateDataBinder;

import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Paging;
import org.zkoss.zul.Window;
import org.zkoss.zul.event.PagingEvent;

import ec.cjpq.fe.bean.DatosAr;
import ec.cjpq.fe.dao.EntidadDao;
import ec.cjpq.fe.jdbc.ColaAut;
import ec.cjpq.fe.util.Util;

@SuppressWarnings("unchecked")
public class DatosArComposer extends GenericForwardComposer {
	
	private Window winAr;
	
	private static final Logger log = LogManager.getLogger("DatosArComposer.class");

	private AnnotateDataBinder binder;

	@Getter @Setter
	private DatosAr pojo;
	
	@Getter @Setter
	private DatosAr bean;

	@Getter @Setter
	private List<DatosAr> beans;

	private Paging pag;
	private Listbox lbx;
	private Label lblParametro;
	
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		binder = new AnnotateDataBinder(comp);
		binder.bindBean("ctr", this);
		
		setPojo( new DatosAr() );
		
		pag.addEventListener("onPaging", new EventListener() {
			/**
			 * Carga nuevamente los registros luego de cambiar de página
			 * @param event Evento
			 */
			public void onEvent(Event event) {
				PagingEvent pe = (PagingEvent) event;
				redraw( pe.getActivePage() );
			}
		});
		
		winAr.setTitle( winAr.getTitle() + (lblParametro.getValue().equals("NC") ? "Notas de Crédito": "Notas de Débito") );  
	}
	
	public void onCreate(Event event) {
		/*
		 * populate ui with data 
		 */
		binder.loadAll();
	}
	
	private void regresarMenu(){
		execution.sendRedirect("/home.zul");
	}
	
	private String getTipo(){
		return lblParametro.getValue().equals("NC") ? "4": "5";
	}
	
	private void filtrar(){
		try {
			pojo.setTipo(getTipo());
			pag.setActivePage(0);
			pag.setTotalSize( new EntidadDao().getConsultaArSize(pojo) );
			redraw ( 0 );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Dibuja los elementos del listbox contemplando el filtro especificado
	 * @param registros
	 */
	private void redraw( int pagina ) {
		lbx.getItems().clear();
		int maximo = pag.getPageSize();
			
		pojo.setTipo(getTipo());
		List <DatosAr> lista = new EntidadDao().getConsultaArList( pojo, pagina*maximo, maximo );
		setBeans(lista);
		binder.loadAll();
	}

	public void onClick$btnConsultar(){
		filtrar();
	}
	
	public void onClick$btnEnviarCola(){
		
		Object []datos = new EntidadDao().getDatosArInvoice(Util.quitarNuevaLinea(bean.getNotes()));
		
		boolean comprobanteGenerado = false;
		if (bean.getOrdnumber()!=null){
			if (bean.getOrdnumber().trim().length()>0)
				comprobanteGenerado = true;
		}
		
		if (bean.getEmail()==null || bean.getEmail().length()==0){
			Util.mostrarMensaje("NO ha asignado un email a este cliente...");
		}else if (datos==null || bean.getNotes().length()==0){
			Util.mostrarMensaje("El campo \"Guía de remisión (es decir la Factura referenciada)\" es inválido o no se ha especificado. Actualice el valor y reintente.");
		}else if (comprobanteGenerado){
			Util.mostrarMensaje(String.format("YA se ha generado un comprobante electrónico a este registro (ordnumber %s)", bean.getOrdnumber()));
		}else{
			try {
				String mensaje = ColaAut.ponerCola(lblParametro.getValue(), bean.getId().toString());
				Util.mostrarMensaje(mensaje);
			} catch (SQLException e) {
	        	String men = Util.stack2String(e);
	        	log.warn(men);
	        	Util.mostrarMensaje("No se pudo enviar el comprobante a la cola, motivo:\n\n" + men);
			}
		}
	}
	
	public void onClick$btnMenu(){
		regresarMenu();
	}

}
