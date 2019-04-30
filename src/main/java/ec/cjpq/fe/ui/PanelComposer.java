package ec.cjpq.fe.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.MimetypesFileTypeMap;

import ec.cjpq.cjfews.comprobante.Configuracion;
import ec.cjpq.cjfews.webservice.impl.CjfewsImpl;
import ec.cjpq.fe.bean.ConfiguracionBean;
import ec.cjpq.fe.dao.EntidadDao;
import ec.cjpq.fe.model.EmployeeId;
import ec.cjpq.fe.model.FeColaAut;
import ec.cjpq.fe.util.Proceso;
import ec.cjpq.fe.util.Util;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.zkoss.zhtml.Filedownload;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Paging;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.event.PagingEvent;

public class PanelComposer extends GenericForwardComposer {
	
	private static final Logger log = LogManager.getLogger(PanelComposer.class);
	private AnnotateDataBinder binder;

	@Getter @Setter
	private List<FeColaAut> beans;
	
	@Getter @Setter
	private FeColaAut bean;

	private Paging pag;
	private Listbox lbx;
	private Listbox lbxComp;
	private Textbox txtFilCliente;
	private Textbox txtFilMensaje;
	
	private Toolbarbutton btnAutorizar;
	private Toolbarbutton btnRide;
	private Checkbox chkNoAutorizados;
	
	private EmployeeId employee = null;
	private Configuracion configuracion = null;
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		binder = new AnnotateDataBinder(comp);
		binder.bindBean("ctr", this);
		
		configuracion = new ConfiguracionBean().getConfiguracion();

		String login = SecurityUtils.getSubject().getPrincipal().toString();
		//Util.mostrarMensaje(login);
		// Verificar si el usuario tiene asignado su archivo P12
		employee = new EntidadDao().getEmployeeByLogin(login);
		if (employee!=null){
//			log.warn("Login: "+employee.getLogin());
//			log.warn("Antes  : "+configuracion.getArchivoP12Ruta());
			new ConfiguracionBean().setConfiguracionEmpleado(configuracion, employee);
//			log.warn("Después: "+configuracion.getArchivoP12Ruta());
		}else{
			Util.mostrarMensaje("No se ha asignado un archivo P12 al usuario: "+login);
			btnAutorizar.setDisabled(true);
			btnRide.setDisabled(true);
		}
		
		//filtrar();

		lbx.addEventListener("onDoubleClick", new EventListener() {
			public void onEvent(Event event) {
				
			}
		});
		
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
		//filtrar();
	}

	private void filtrar(){
		pag.setActivePage(0);
		String tipo = lbxComp.getSelectedItem().getValue().toString();
		pag.setTotalSize( new EntidadDao().getListadoFeColaAut(tipo, txtFilCliente.getValue(), txtFilMensaje.getValue(), chkNoAutorizados.isChecked(), 0, 0).size() );
		redraw ( 0 );
	}
	
	/**
	 * Dibuja los elementos del listbox contemplando el filtro especificado
	 * @param registros
	 */
	private void redraw( int pagina ) {
		lbx.getItems().clear();
		int maximo = pag.getPageSize();

		String tipo = lbxComp.getSelectedItem().getValue().toString();
		List <FeColaAut> lista = new EntidadDao().getListadoFeColaAut(tipo, txtFilCliente.getValue(), txtFilMensaje.getValue(), chkNoAutorizados.isChecked(), pagina*maximo, maximo);
		setBeans(lista);
		binder.loadAll();
	}
	
	private void descargarRide(){

		//lbx.getItems().size()>0 && lbx.getSelectedItem()!=null
		Set seleccionados = lbx.getSelectedItems();
		if ( seleccionados.size() == 1){

			String documento = bean.getArchivo();
			if (documento !=null ){
				FileInputStream fis;
				String ruta = "/tmp/salida.pdf";
				try{
					//Descarga del archivo y copia en disco local /tmp

					//TODOs Comentar Firmar con token
					//byte[] bytes = new CjfewsImpl().descargaRide(configuracion, documento);
                    DataHandler dataHandler = new CjfewsImpl().descargaRide(configuracion, documento);
                    final InputStream in = dataHandler.getInputStream();
                    byte[] bytes = org.apache.commons.io.IOUtils.toByteArray(in);

					FileOutputStream fos = new FileOutputStream(ruta);
					fos.write(bytes);
					fos.flush();
					fos.close();
		
					// Descarga del archivo vía ZK
					File archivo = new File(ruta);
					if (archivo.exists()){
						fis = new FileInputStream(archivo);
						Filedownload.save(fis, new MimetypesFileTypeMap().getContentType(archivo), archivo.getName() );
					}else{
						Util.mostrarMensaje("No se pudo descargar el RIDE...");
						
					}
				}catch(Exception e){
					String mensaje = Util.stack2String(e);
					log.warn(mensaje);
				}
			}else
				Util.mostrarMensaje("Por favor envíe los archivos manualmente desde la página del SRI. Gracias.");
		}else
			Util.mostrarMensaje("Seleccione solamente un elemento...");
	}
	
	private void autorizarComprobantes(){
		//Extraer los objetos y crear la lista
		Set listItems = lbx.getSelectedItems();
		Iterator iterator = listItems.iterator();

		List <FeColaAut> seleccionados = new ArrayList<FeColaAut>();
		while ( iterator.hasNext() ) {
	    	Listitem li = (Listitem) iterator.next();
	    	FeColaAut bean = (FeColaAut) li.getValue();
	    	seleccionados.add(bean);
		}
		new Proceso().autorizarComprobante(configuracion, seleccionados, employee);
		
	    binder.loadAll();
	}

	private void quitarComprobantes(){
		//Extraer los objetos y crear la lista
		List <FeColaAut> seleccionados = new ArrayList<FeColaAut>();	
		for(Listitem li: lbx.getSelectedItems()){
	    	FeColaAut bean = (FeColaAut) li.getValue();
	    	seleccionados.add(bean);
		}
		new Proceso().quitarComprobante(seleccionados);
	    binder.loadAll();
	    refrescar();
	    
	}

	private void refrescar(){
		filtrar();
	}

	/**
	 * Evento para refrescar la página de registros
	 */
	public void onClick$btnRefrescar(){
		refrescar();
	}

	public void onClick$btnAutorizar(){
		autorizarComprobantes();
	}

	public void onClick$btnRide(){
		descargarRide();
	}
	
	public void onClick$btnQuitar(){
		quitarComprobantes();
	}

	public void onClick$btnMenu(){
		execution.sendRedirect("/home.zul");
	}

	public void onClick$btnSalir(){
		execution.sendRedirect("/home.zul");
		SecurityUtils.getSubject().logout();
	}
	
}
