package ec.cjpq.cjfews.util;

/**
 * Enumeraciones de constantes del Sistema
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2014-07-25, 26
 * 2014-08-28
 * 2015-08-15
 */
public enum Constante {

	DEVUELTA, RECIBIDA, AUTORIZADO,
	INFO_TRIBUTARIA, INFO_FACTURA, INFO_NCREDITO, DETALLE, E_MAIL_CLIENTE, BCE_IKEY2032;

	public String toString(){
		return name().toString();
	}
	
}
