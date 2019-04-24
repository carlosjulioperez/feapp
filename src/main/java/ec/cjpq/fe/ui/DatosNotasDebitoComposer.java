package ec.cjpq.fe.ui;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Paging;
import org.zkoss.zul.event.PagingEvent;

import ec.cjpq.fe.bean.DatosAp;
import ec.cjpq.fe.dao.EntidadDao;
import ec.cjpq.fe.util.Util;

@SuppressWarnings("unchecked")
public class DatosNotasDebitoComposer extends GenericForwardComposer {
	
	private static final Logger log = Logger.getLogger("DatosNotasDebitoComposer.class");

	private AnnotateDataBinder binder;

	@Getter @Setter
	private DatosAp pojo;
	
	@Getter @Setter
	private DatosAp bean;

	@Getter @Setter
	private List<DatosAp> beans;

	private Paging pag;
	private Listbox lbx;
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		binder = new AnnotateDataBinder(comp);
		binder.bindBean("ctr", this);
		
		setPojo( new DatosAp() );
		
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
	
	private void filtrar(){
		try {
			pag.setActivePage(0);
			pag.setTotalSize( new EntidadDao().getConsultaApSize(pojo) );
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
		
		List <DatosAp> lista = new EntidadDao().getConsultaApList( pojo, pagina*maximo, maximo );
		setBeans(lista);
		binder.loadAll();
	}

	public void onClick$btnConsultar(){
		filtrar();
	}
	
	public void onClick$btnEnviarCola(){

		Object []datos = new EntidadDao().getDatosArInvoice(Util.quitarNuevaLinea(bean.getNotes()));

		boolean comprobanteGenerado = false;
		if (bean.getPonumber()!=null){
			if (bean.getPonumber().trim().length()>0)
				comprobanteGenerado = true;
		}
		
		if (bean.getEmail()==null || bean.getEmail().length()==0){
			Util.mostrarMensaje("NO ha asignado un email a este proveedor...");
		}else if (datos==null || bean.getNotes().length()==0){
			Util.mostrarMensaje("El campo \"Notas (es decir la Factura referenciada)\" es inválido o no se ha especificado. Actualice el valor y reintente.");
		}else if (comprobanteGenerado){
			Util.mostrarMensaje(String.format("YA se ha generado un comprobante electrónico a este registro (ponumber %s)", bean.getPonumber()));
		}else{
			try {
				//String mensaje = ColaAut.ponerColaNotaDebito(bean.getId().toString(), bean.getTransdate(), bean.getName(), bean.getAmount().toString() );
				String mensaje = "Nada que hacer...";
				Util.mostrarMensaje(mensaje);
			} catch (Exception e) {
	        	String men = Util.stack2String(e);
	        	log.warn(men);
	        	Util.mostrarMensaje("No se pudo enviar la ND a la cola, motivo:\n\n" + men);
			}
		}
	}
	
	public void onClick$btnMenu(){
		regresarMenu();
	}

}
