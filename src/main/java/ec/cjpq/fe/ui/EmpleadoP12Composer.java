package ec.cjpq.fe.ui;

import java.io.File;

import lombok.Getter;
import lombok.Setter;

import org.apache.shiro.SecurityUtils;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Fileupload;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import ec.cjpq.fe.dao.EntidadDao;
import ec.cjpq.fe.model.EmployeeId;

public class EmpleadoP12Composer extends GenericForwardComposer {
	
	private AnnotateDataBinder binder;
	
	@Getter @Setter
	private EmployeeId empleado;
	
	private Textbox txtLogin;
	private Toolbarbutton btnActualizar;
	private Button btnBuscar;
	private Button btnBuscarArchivo;

	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		binder = new AnnotateDataBinder(comp);
		binder.bindBean("ctr", this);
		
		String login = SecurityUtils.getSubject().getPrincipal().toString();
		if (login != null){
			txtLogin.setValue(login);
			txtLogin.setDisabled(true);
			btnBuscar.setDisabled(true);
			buscarEmpleado();
		}
	}

	private void actualizar(){
		new EntidadDao().actualizarEmployee(getEmpleado());
		regresarMenu();
		//setEmpleado(null);
		//binder.loadAll();
		//btnActualizar.setDisabled( true );
	}
	
	private void buscarEmpleado(){
		String login = txtLogin.getValue();
		EmployeeId employeeId = new EntidadDao().getEmployeeByLogin(login);
		setEmpleado(employeeId);
		binder.loadAll();
		
		btnActualizar.		setDisabled( ! (employeeId!=null) );
		btnBuscarArchivo.	setDisabled( ! (employeeId!=null) );
	}
	
	private void buscarArchivo(){
        // http://forum.zkoss.org/question/44755/getting-a-full-file-path-from-fileupload/ 
		try {
			Media media = Fileupload.get();
			if (media != null){
				File archivo = new File(media.getName()); 
				//log.warn("Nombre del archivo: " + archivo.getAbsolutePath());
				getEmpleado().setP12Archivo(archivo.getAbsolutePath());
				binder.loadAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void regresarMenu(){
		execution.sendRedirect("/home.zul");
	}

	public void onClick$btnBuscar(){
		buscarEmpleado();
	}

	public void onClick$btnBuscarArchivo(){
		buscarArchivo();
	}
	
	public void onClick$btnActualizar(){
		actualizar();
	}
	
	public void onClick$btnMenu(){
		regresarMenu();
	}

	public void onClick$btnSalir(){
		SecurityUtils.getSubject().logout();
		execution.sendRedirect("/home.zul");
	}

}
