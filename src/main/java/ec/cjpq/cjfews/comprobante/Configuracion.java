package ec.cjpq.cjfews.comprobante;

import lombok.Data;

/**
 * Pojo para cargar la configuración del emisor
 * @author carper
 * 2015-03-18, 24, 31
 * 2015-10-05
 */
@Data
public class Configuracion {

	private String emisorRuc;
	private String emisorRazonSocial;
	private String emisorNombreComercial;
	private String emisorDireccionMatriz;
	private String emisorDireccionEstablecimiento;
	private String emisorCodigoEstablecimiento;
	private String emisorCodigoPuntoEmision;
	private String emisorNumeroResolucion;
	private String emisorObligadoLlevarContabilidad;
	private String emisorRutaLogo;
	
	private String directorioGenerados;
	private String directorioFirmados;
	private String directorioAutorizados;
	private String directorioNoAutorizados;

	private String archivoP12Ruta;
	private String archivoP12Clave;

	private short cfgTipoEmision;
	private short cfgTipoAmbiente;
	
	private int cfgSecuenciaFactura;
	private int cfgSecuenciaNotaCredito;
	private int cfgSecuenciaNotaDebito;
	private int cfgSecuenciaGuiaRemision;
	private int cfgSecuenciaComprobanteRetencion;
	
	private short emailPuertoTsl;
	private String emailAsunto;
	private String emailCuerpoMensaje;
	private String emailHost;
	private String emailUser;
	private String emailPassword;
	private String emailStartTlsEnable;
	private String emailCc;
	private String emailBcc;

	private short wsTiempoEspera;
	private String wsPrefijoPruebas;
	private String wsPrefijoProduccion;
	
}
