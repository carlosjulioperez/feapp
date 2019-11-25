package ec.cjpq.fe.bean;

import ec.cjpq.cjfews.comprobante.Configuracion;
import ec.cjpq.fe.dao.EntidadDao;
import ec.cjpq.fe.model.EmployeeId;
import ec.cjpq.fe.model.FeConfig;

public class ConfiguracionBean {

	public Configuracion getConfiguracion(){
		
		FeConfig feConfig = new EntidadDao().getFeConfig((short) 1);
		
		Configuracion configuracion = new Configuracion();
		
		configuracion.setArchivoP12Ruta						(feConfig.getP12Archivo());
		configuracion.setArchivoP12Clave					(feConfig.getP12Clave());
		
		configuracion.setCfgTipoAmbiente					(feConfig.getCfgTipAmbiente());
		configuracion.setCfgTipoEmision						(feConfig.getCfgTipEmision());
		configuracion.setCfgSecuenciaFactura				(feConfig.getCfgSecFactura());
		configuracion.setCfgSecuenciaNotaCredito			(feConfig.getCfgSecNcredito());
		configuracion.setCfgSecuenciaNotaDebito				(feConfig.getCfgSecNdebito());
		configuracion.setCfgSecuenciaGuiaRemision			(feConfig.getCfgSecGremision());
		configuracion.setCfgSecuenciaComprobanteRetencion	(feConfig.getCfgSecCretencion());
				
		configuracion.setDirectorioAutorizados				(feConfig.getDirAutorizados());
		configuracion.setDirectorioFirmados					(feConfig.getDirFirmados());
		configuracion.setDirectorioGenerados				(feConfig.getDirGenerados());
		configuracion.setDirectorioNoAutorizados			(feConfig.getDirNoautotizados());
		
		configuracion.setEmailHost							(feConfig.getEmailHost());
		configuracion.setEmailUser							(feConfig.getEmailUser());
		configuracion.setEmailPassword						(feConfig.getEmailPassword());
		configuracion.setEmailAsunto						(feConfig.getEmailAsunto());
		configuracion.setEmailCuerpoMensaje					(feConfig.getEmailCuerpoMens());
		configuracion.setEmailPuertoTsl						(feConfig.getEmailPuertoTsl());
		configuracion.setEmailStartTlsEnable				(feConfig.getEmailStarttlsEnab());
		configuracion.setEmailCc							(feConfig.getEmailCc());
		configuracion.setEmailBcc							(feConfig.getEmailBcc());

		configuracion.setEmisorCodigoEstablecimiento		(feConfig.getEmiCodEstabl());
		configuracion.setEmisorCodigoPuntoEmision			(feConfig.getEmiCodPtoEmi());
		configuracion.setEmisorDireccionEstablecimiento		(feConfig.getEmiDirEstabl());
		configuracion.setEmisorDireccionMatriz				(feConfig.getEmiDirMatriz());
		configuracion.setEmisorNombreComercial				(feConfig.getEmiNomComerc());
		configuracion.setEmisorNumeroResolucion				(feConfig.getEmiNumResoluc());
		configuracion.setEmisorObligadoLlevarContabilidad	(feConfig.getEmiOblContab());
		configuracion.setEmisorRazonSocial					(feConfig.getEmiRazSocial());
		configuracion.setEmisorRuc							(feConfig.getEmiRuc());
		configuracion.setEmisorRutaLogo						(feConfig.getEmiLogo());
		configuracion.setWsPrefijoProduccion				(feConfig.getWsPrefijoProduc());
		configuracion.setWsPrefijoPruebas					(feConfig.getWsPrefijoPruebas());
		configuracion.setWsTiempoEspera						(feConfig.getWsTiempoEspera());
		
		return configuracion;
	}
	
	/**
	 * Reemplaza los parámetros relacionados con los del empleado
	 * @param configuracion
	 * @param employee
	 */
	public void setConfiguracionEmpleado(Configuracion configuracion, EmployeeId employee){
		configuracion.setArchivoP12Ruta						(employee.getP12Archivo());
		configuracion.setArchivoP12Clave					(employee.getP12Clave());
		configuracion.setCfgTipoAmbiente					(employee.getTipAmbiente());
		
		configuracion.setEmisorCodigoEstablecimiento		(employee.getCodEstabl());
		configuracion.setEmisorCodigoPuntoEmision			(employee.getCodPtoEmi());
		configuracion.setCfgSecuenciaFactura				(employee.getSecFactura());
		configuracion.setCfgSecuenciaNotaCredito			(employee.getSecNcredito());
		configuracion.setCfgSecuenciaNotaDebito				(employee.getSecNdebito());
		configuracion.setCfgSecuenciaGuiaRemision			(employee.getSecGremision());
		configuracion.setCfgSecuenciaComprobanteRetencion	(employee.getSecCretencion());
	}
	
}
