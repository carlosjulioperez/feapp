 descripción de una tabla
\d+ tablename
\d+ retenc;

-- Cambiar a entorno PRUEBAS
UPDATE fe_config SET cfg_tip_ambiente = 1 WHERE id = 1;

-- Cambiar a entorno PRODUCCION
UPDATE fe_config SET cfg_tip_ambiente = 2 WHERE id = 1;

UPDATE fe_config SET email_bcc = 'amvalladares@apracom-ec.com' WHERE id = 1;

-- Ruta del logotipo
UPDATE fe_config SET emi_logo='/img/oy_logo.jpg' WHERE id = 1;
select emi_logo from fe_config;

-- NOTA: PARA LAS PRUEBAS EST Y SUC LA TOMA DE fe_config
--1 pruebas, 2 producción

--1 pruebas
UPDATE fe_config SET 
	cfg_tip_ambiente = 1,
	emi_cod_establ  = '001',
    emi_cod_pto_emi = '001'
WHERE id = 1; 

--2 producción
UPDATE fe_config SET 
	cfg_tip_ambiente = 2,
	emi_cod_establ  = '004'
    emi_cod_pto_emi = '003'
WHERE id = 1; 

--PRUEBAS
update employee set 
    p12_archivo     = '/usr/local/fe/p12s/monica_martillo.p12',
    p12_clave       = 'MRMC0908',
    sec_factura     = 0,
    sec_gremision   = 0,
    sec_ncredito    = 0,
    sec_ndebito     = 0,
    sec_cretencion	= 0
where login = 'aoyague';

update employee set 
	tip_ambiente	= 1,
    cod_establ  	= '001',
    cod_pto_emi 	= '001'
where login = 'aoyague';

--PRODUCCION
update employee set 
	tip_ambiente	= 2,
    cod_establ  	= '001',
    cod_pto_emi 	= '001'
where login = 'aoyague';

