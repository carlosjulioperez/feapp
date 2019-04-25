package ec.cjpq.fe.ui;

import java.sql.SQLException;

import java.util.List;

import ec.cjpq.fe.bean.DatosRetencion;
import ec.cjpq.fe.dao.EntidadDao;
import ec.cjpq.fe.jdbc.ColaAut;
import ec.cjpq.fe.util.Util;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Paging;
import org.zkoss.zul.event.PagingEvent;

@SuppressWarnings("unchecked")
public class DatosRetencionComposer extends GenericForwardComposer {
	
	private static final Logger log = LogManager.getLogger("DatosRetencionComposer.class");

	private AnnotateDataBinder binder;

	@Getter @Setter
	private DatosRetencion pojo;
	
	@Getter @Setter
	private DatosRetencion bean;

	@Getter @Setter
	private List<DatosRetencion> beans;

	private Paging pag;
	private Listbox lbx;
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		binder = new AnnotateDataBinder(comp);
		binder.bindBean("ctr", this);
		
		setPojo( new DatosRetencion() );
		//binder.loadAll();
		
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
//		filtrar();
	}
	
	private void regresarMenu(){
		execution.sendRedirect("/home.zul");
	}
	
	private void filtrar(){
		try {
			pag.setActivePage(0);
			pag.setTotalSize( new EntidadDao().getConsultaRetencionSize(pojo) );
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
		
		List <DatosRetencion> lista = new EntidadDao().getConsultaRetencionList( pojo, pagina*maximo, maximo );
		setBeans(lista);
		binder.loadAll();
	}

	public void onClick$btnConsultar(){
		filtrar();
	}
	
	public void onClick$btnEnviarCola(){
		if (lbx.getSelectedItem()==null)
			return;
		
		//if ( lbxDetalle.getSelectedItem();
//		if (bean!=null){
//			System.out.println(bean.getValret());
//		}
		if (bean.getEmail()==null || bean.getEmail().length()==0){
			Util.mostrarMensaje("NO ha asignado un email a este proveedor...");
		
		//}else if (bean.getSecret()!=null || bean.getSecret().length()>0){
//TODO: 1 COMENTADO EN 2016-08-04 por pruebas con cvera
//		}else if (bean.getSecret().length()>0){
//			Util.mostrarMensaje("YA se ha generado un comprobante electrónico a este registro...");
		}else{
			try {
				String mensaje = ColaAut.ponerColaRetencion(bean.getId().toString(), bean.getTransdate(), bean.getName() );
				Util.mostrarMensaje(mensaje);
			} catch (SQLException e) {
	        	String men = Util.stack2String(e);
	        	log.warn(men);
	        	Util.mostrarMensaje("No se pudo enviar la RE a la cola, motivo:\n\n" + men);
			}
		}
	}

	public void onClick$btnMenu(){
		regresarMenu();
	}

}
