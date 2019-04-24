drop table if exists fe_config;
drop table if exists fe_cola_aut;

create table fe_cola_aut(
	cola_id 		serial primary key,
	tipo_comp		varchar(2),
	fecha			varchar(10),
	numero_sl		varchar(20),
	cliente			varchar(64),
	total			float8,
	mensaje			text,
	num_aut			varchar(40),
	fec_aut			varchar(40),
	num_sec			varchar(20),
	clave_acceso	varchar(49),
	autorizado		boolean
);

create table fe_config(
	id					smallint,
	emi_ruc				varchar(15),
	emi_raz_social		varchar(70),
	emi_nom_comerc		varchar(100),
	emi_dir_matriz		varchar(250),
	emi_dir_establ		varchar(250),
	emi_cod_establ		varchar(3),
	emi_cod_pto_emi		varchar(3),
	emi_num_resoluc		varchar(5),
	emi_obl_contab		varchar(2),
	emi_logo			varchar(100),
	dir_generados		varchar(100),
	dir_firmados		varchar(100),
	dir_autorizados		varchar(100),
	dir_noautotizados	varchar(100),
	p12_archivo			varchar(100),
	p12_clave			varchar(100),
	cfg_tip_emision		smallint,
	cfg_tip_ambiente	smallint,
	
	cfg_sec_factura 	integer,
	cfg_sec_ncredito	integer,
	cfg_sec_ndebito 	integer,
	cfg_sec_gremision	integer,
	cfg_sec_cretencion	integer,
	
	email_puerto_tsl	smallint,
	email_asunto		varchar(100),
	email_cuerpo_mens	varchar(400),
	email_host			varchar(50),
	email_user			varchar(100),
	email_password		varchar(30),
	email_starttls_enab	varchar(1),
	email_cc			varchar(100),
	email_bcc			varchar(100),
	ws_tiempo_espera	smallint,
	ws_prefijo_pruebas 	varchar(25),
	ws_prefijo_produc 	varchar(25),
	
	primary key (id)
);
comment on table fe_config 				is 'CONFIGURACION DE FACTURACON ELECTRONICA BC';
comment on column fe_config.id 			is 'IDENTIFICACION DEL REGISTRO';
comment on column fe_config.emi_ruc		is 'RUC';
comment on column fe_config.emi_raz_social	is 'RAZON SOCIAL';
comment on column fe_config.emi_nom_comerc	is 'NOMBRE COMERCIAL';
comment on column fe_config.emi_dir_matriz	is 'DIRECCION MATRIZ';
comment on column fe_config.emi_dir_establ	is 'DIRECCION DE ESTABLECIMIENTO';
comment on column fe_config.emi_cod_establ	is 'CODIGO DE ESTABLECIMIENTO';
comment on column fe_config.emi_cod_pto_emi	is 'CODIGO DE PUNTO DE EMISION';
comment on column fe_config.emi_num_resoluc	is 'NUMERO DE RESOLUCION SRI';
comment on column fe_config.emi_obl_contab	is 'OBLIGADO A LLEVAR CONTABILIDAD: S,N';
comment on column fe_config.emi_logo		is 'RUTA DE LA IMAGEN DEL LOGOTIPO';
comment on column fe_config.dir_generados	is 'DIRECTORIO DE COMPROBANTES GENERADOS';
comment on column fe_config.dir_firmados	is 'DIRECTORIO DE COMPROBANTES FIRMADOS';
comment on column fe_config.dir_autorizados	is 'DIRECTORIO DE COMPROBANTES AUTORIZADOS';
comment on column fe_config.dir_noautotizados	is 'DIRECTORIO DE COMPROBANTES NO AUTORIZADOS';
comment on column fe_config.p12_archivo		is 'ARCHIVO P12';
comment on column fe_config.p12_clave		is 'CLAVE DEL ARCHIVO P12';
comment on column fe_config.cfg_tip_emision	is 'TIPO DE EMISION 1:NORMAL, 2:INDISPONIBILIDAD SISTEMA';
comment on column fe_config.cfg_tip_ambiente	is 'TIPO DE AMBIENTE 1:PRUEBAS, 2:PRODUCCION';

comment on column fe_config.cfg_sec_factura   	is 'ULTIMA SECUENCIA DE FACTURA';
comment on column fe_config.cfg_sec_ncredito  	is 'ULTIMA SECUENCIA DE NOTA DE CREDITO';
comment on column fe_config.cfg_sec_ndebito   	is 'ULTIMA SECUENCIA DE NOTA DE DEBITO';
comment on column fe_config.cfg_sec_gremision 	is 'ULTIMA SECUENCIA DE GUIA DE REMISION';
comment on column fe_config.cfg_sec_cretencion	is 'ULTIMA SECUENCIA DE COMPROBANTE DE RETENCION';

comment on column fe_config.email_puerto_tsl	is 'PUERTO TSL PARA SALIDA DE CORREOS';
comment on column fe_config.email_asunto	is 'ASUNTO DEL CORREO';
comment on column fe_config.email_cuerpo_mens	is 'CUERPO DEL MENSAJE DEL CORREO';
comment on column fe_config.email_host		is 'HOST DEL CORREO';
comment on column fe_config.email_user		is 'USUARIO DEL CORREO';
comment on column fe_config.email_password	is 'PASSWORD DEL USUARIO DEL CORREO';
comment on column fe_config.email_starttls_enab	is 'ACTIVAR TLS';
comment on column fe_config.email_cc				is 'CORREO PARA COPIA';
comment on column fe_config.email_bcc				is 'CORREO PARA COPIA OCULTA';

comment on column fe_config.ws_tiempo_espera	is 'TIEMPO DE ESPERA DEL WEB SERVICE';
comment on column fe_config.ws_prefijo_pruebas 	is 'PREFIJO DE LA DIRECCION WS DE PRUEBAS';
comment on column fe_config.ws_prefijo_produc 	is 'PREFIJO DE LA DIRECCION WS DE PRODUCCION';

