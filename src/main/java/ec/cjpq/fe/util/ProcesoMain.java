package ec.cjpq.fe.util;

import java.util.List;

import ec.cjpq.cjfews.comprobante.Configuracion;
import ec.cjpq.fe.bean.ConfiguracionBean;
import ec.cjpq.fe.dao.EntidadDao;
import ec.cjpq.fe.model.EmployeeId;
import ec.cjpq.fe.model.FeColaAut;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProcesoMain {

	private static final Logger log = LogManager.getLogger("ProcesoMain.class");
	
	private static EmployeeId employee = null;
	private static Configuracion configuracion = null;
	private static String login = "ap_amvalladares";
	
	private static String condicion = null;
	
	//TODO: PARAMETRO el nombre del usuario
	
	private static void autorizarComprobante(){
		
		// EJECUCION
		// java -cp "lib/*" ec.cjpq.fe.util.ProcesoMain
		
		// EJECUCION con condición
		// java -cp "lib/*" ec.cjpq.fe.util.ProcesoMain "WHERE colaId=210"

		configuracion = new ConfiguracionBean().getConfiguracion();
		employee = new EntidadDao().getEmployeeByLogin(login); 
		if (employee!=null){
			if (employee.getP12Archivo()!=null){
				new ConfiguracionBean().setConfiguracionEmpleado(configuracion, employee);
				
				List <FeColaAut> seleccionados; // = new EntidadDao().getListadoFeColaAut();
				if (condicion !=null)
					seleccionados = new EntidadDao().getListadoFeColaAut(condicion);
				else
					seleccionados = new EntidadDao().getListadoFeColaAut();
				
				new Proceso().autorizarComprobante(configuracion, seleccionados, employee);
				
				log.warn("Proceso terminado...");
			}else
				log.warn("No se ha asignado un archivo P12 al usuario: "+login);
		}else
			log.warn("No existe el usuario con el login: "+login);
	}

	public static void main(String[] args) throws Exception {
		
		if (args.length > 0)
			condicion = args[0];

		autorizarComprobante();
	}

}
