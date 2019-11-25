package ec.cjpq.cjfews.util;

public enum Constante {

	DEVUELTA, RECIBIDA, AUTORIZADO, NO_AUTORIZADO, EN_PROCESO,
	INFO_TRIBUTARIA, INFO_FACTURA, INFO_NCREDITO, DETALLE, E_MAIL_CLIENTE, BCE_IKEY2032;

	public String toString(){
		return name().toString();
	}
	
}
