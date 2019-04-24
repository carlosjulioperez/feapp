package ec.cjpq.fe.ui;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import ec.cjpq.fe.bean.DatosGuiaRemision;
import ec.cjpq.fe.dao.EntidadDao;
import ec.cjpq.fe.util.Util;
import ec.cjpq.fe.jdbc.ColaAut;

/**
 * Controlador para actualizar los datos para la Guía de Remisión
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2016-03-11, 13, 14, 15, 16, 17
 */
public class DatosGuiaComposer extends GenericForwardComposer {
	
	private static final Logger log = Logger.getLogger("DatosGuiaComposer.class");

	private AnnotateDataBinder binder;

	@Getter @Setter
	private DatosGuiaRemision dato;

	private Toolbarbutton btnActualizar;
	private Button btnCancelar;
	private Textbox txtNumero;
	private Textbox txtTransportistaId;
	private Textbox txtTransportistaRazonSocial;
	private Textbox txtPlaca;
	private Textbox txtMotivo;
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		binder = new AnnotateDataBinder(comp);
		binder.bindBean("ctr", this);
	}
	
	private void regresarMenu(){
		execution.sendRedirect("/home.zul");
	}

	private void buscarRegistro(){
		String numero = txtNumero.getValue(); //111435  004-002-000003270
		dato = new EntidadDao().getConsultaGuiaRemision(numero);
		btnActualizar.setDisabled( dato==null );
		
		if (dato == null){
			Util.mostrarMensaje("No existe la Factura Sql-Ledger # " + numero + " para consultar la Guía de Remisión.");
			cancelar();
		}else{
			//System.out.println(dato.getId());
			btnCancelar.setVisible(true);
			binder.loadAll();
		}
	}

	private void cancelar(){
		btnCancelar.setVisible(false);
		btnActualizar.setDisabled( true );
		dato = new DatosGuiaRemision();
		binder.loadAll();
	}
	
	@SuppressWarnings("unchecked")
	private void actualizar(){
		
		String id 			= txtTransportistaId.getValue();
		String razonSocial 	= txtTransportistaRazonSocial.getValue();
		String placa		= txtPlaca.getValue();
		String motivo 		= txtMotivo.getValue();
		
		if (id.length()==0 || razonSocial.length()==0 || placa.length()==0 || motivo.length()==0 )
			Util.mostrarMensaje("Todos los campos son obligatorios...");
		else{
			Map parametro = new HashMap();
			parametro.put("id", id);
			parametro.put("razonSocial", razonSocial);
			parametro.put("placa", placa);
			parametro.put("motivo", motivo);
			parametro.put("numeroFactura", txtNumero.getValue());
			
			new EntidadDao().actualizarDatosGuiaRemision(parametro);
			Util.mostrarMensaje("Datos actualizados correctamente...");
			
			try {
				String mensaje = ColaAut.ponerCola("GR", dato.getId().toString());
				Util.mostrarMensaje(mensaje);
			} catch (SQLException e) {
	        	String men = Util.stack2String(e);
	        	log.warn(men);
	        	Util.mostrarMensaje("No se pudo enviar la GR a la cola, motivo:\n\n" + men);
			}
			
			//2376641 empresa electrica
			cancelar();
		}
	}
	
	public void onClick$btnBuscar(){
		buscarRegistro();
	}

	public void onClick$btnCancelar(){
		cancelar();
	}

	public void onClick$btnActualizar(){
		actualizar();
	}

	public void onClick$btnMenu(){
		regresarMenu();
	}

}
