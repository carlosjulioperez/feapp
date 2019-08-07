 descripción de una tabla
\d+ tablename
\d+ retenc;

-- Cambiar a entorno PRUEBAS
UPDATE fe_config SET cfg_tip_ambiente = 1 WHERE id = 1;

-- Cambiar a entorno PRODUCCION
UPDATE fe_config SET cfg_tip_ambiente = 2 WHERE id = 1;

UPDATE fe_config SET email_bcc = 'amvalladares@apracom-ec.com' WHERE id = 1;

-- Cambiar password
UPDATE fe_config SET email_password = 'Busicentury23' WHERE id = 1;

-- Ruta del logotipo
UPDATE fe_config SET emi_logo='/img/oy_logo.jpg' WHERE id = 1;
select emi_logo from fe_config;

-- Cambiar usuario y password
UPDATE fe_config SET emi_ruc ='0992815086001', emi_raz_social = 'BUSINESS CENTURY S.A. BUSICENTURY' WHERE id = 1;
UPDATE fe_config SET emi_ruc ='1301896963001', emi_raz_social = 'DE LA CRUZ CEDEÑO MANUEL ANTONIO' WHERE id = 1;
UPDATE fe_config SET email_user='yo.candidato@gmail.com', email_password = '4Z1vvgyd' WHERE id = 1;

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

Busicentury23 | /usr/local/fe/p12s/carlos_omar_juarez_arguello.p12
Delacruz2019 | /usr/local/fe/p12s/manuel_antonio_de_la_cruz_cedeno.p12

--PRUEBAS
update employee set 
    p12_archivo     = '/usr/local/fe/p12s/carlos_omar_juarez_arguello.p12',
    p12_clave       = 'Busicentury23',
    sec_factura     = 0,
    sec_gremision   = 0,
    sec_ncredito    = 0,
    sec_ndebito     = 0,
    sec_cretencion	= 0
where login = 'carper';

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

--Actualizar campos de productos después de importarlos vía CSV
update parts set partsgroup_id=null, priceupdate='2010-01-01';
TRUNCATE partsgroup;

UPDATE  ar SET intnotes='FP,20,88,0,dias' WHERE id=4104;
