UPDATE
	fe_config
SET
	emi_ruc             = '0908927148001',
	emi_raz_social      = 'MARTILLO ROMERO MONICA CLARITA',
	emi_nom_comerc      = 'OY-MAR',
	emi_dir_matriz      = 'FERROVIARIA AV. TERCERA 309 CALLE OCTAVA - CALLE NOVENA',
	emi_dir_establ      = 'Cdla. Santa Leonor Calle Benjamín Rosales Mz. 11, Lote 21',
	emi_cod_establ      = '001',
	emi_cod_pto_emi     = '001',
	emi_num_resoluc     = null,
	emi_obl_contab      = 'SI',
	emi_logo            = '/img/oy_logo.jpg',
	dir_generados       = '/usr/local/fe/dir/cg',
	dir_firmados        = '/usr/local/fe/dir/cf',
	dir_autorizados     = '/usr/local/fe/dir/ca',
	dir_noautotizados   = '/usr/local/fe/dir/cn',

	p12_archivo         = '/usr/local/fe/p12s/monica_martillo.p12',
	p12_clave           = 'MRMC0908',
	
    cfg_tip_emision     = 1,
	cfg_tip_ambiente    = 1,
	cfg_sec_factura     = 0,
	cfg_sec_ncredito    = 0,
	cfg_sec_ndebito     = 0,
	cfg_sec_gremision   = 0,
	cfg_sec_cretencion  = 0,
	email_puerto_tsl    = 587,
	email_asunto        = 'Mensaje Servicio Autorización Electrónica',
	email_cuerpo_mens   = '<b>Estimado Cliente:<br> %s<br><br> </b>El comprobante %s
	se ha generado satisfactoriamente.<br> <b>NUMERO DE AUTORIZACION
	SRI</b>: %s<br> <b>FECHA DE AUTORIZACION SRI:</b> %s<br><br> <b>No. %s</b>:
    %s<br> No. Interno: %s<br> Emisión: %s<br> Adjunto puede revisar su
	documento digital en formato XML y su respectivo RIDE.<br><br> Atte.<br><br>
	%s<br>',
	email_host          = 'smtp.gmail.com',
	email_user          = 'contabilidad.oymar@gmail.com',
	email_password      = '0908927148',
	email_starttls_enab = 'S',
	email_cc            = '',
	email_bcc           = '',
	ws_tiempo_espera    = 5,
	ws_prefijo_pruebas  = 'https://celcer.sri.gob.ec',
	ws_prefijo_produc   = 'https://cel.sri.gob.ec'
WHERE
	id = 1;
