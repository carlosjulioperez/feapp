--Generado con SQuirreL (Script / Create Template data script / Format SQL)
TRUNCATE table fe_config;
INSERT INTO fe_config 
(id ,emi_ruc,emi_raz_social,emi_nom_comerc,emi_dir_matriz,emi_dir_establ,emi_cod_establ,emi_cod_pto_emi,emi_num_resoluc,emi_obl_contab,emi_logo,dir_generados,dir_firmados,dir_autorizados,dir_noautotizados,p12_archivo,p12_clave,cfg_tip_emision,cfg_tip_ambiente,cfg_sec_factura,cfg_sec_ncredito,cfg_sec_ndebito,cfg_sec_gremision,cfg_sec_cretencion,email_puerto_tsl,email_asunto,email_cuerpo_mens,email_host,email_user,email_password,email_starttls_enab,email_cc,email_bcc,ws_tiempo_espera,ws_prefijo_pruebas,ws_prefijo_produc) VALUES
(1  ,'s'    ,'s'           ,'s'           ,'s'           ,'s'           ,'s'           ,'s'            ,'s'            ,'s'           ,'s'     ,'s'          ,'s'         ,'s'            ,'s'              ,'s'        ,'s'      ,0              ,0               ,0              ,0               ,0              ,0                ,0                 ,0               ,'s'         ,'s'              ,'s'       ,'s'       ,'s'           ,'s'                ,'s'     ,'s'      ,0               ,'s'               ,'s'              )
;

TRUNCATE table fe_cola_aut;
INSERT INTO fe_cola_aut 
(tipo_comp,fecha        ,numero_sl,cliente                      ,total  ,mensaje,num_aut,fec_aut,autorizado) VALUES
('FA'     ,'2015-12-01' ,'111435'  ,'COSMICA CIA. LTDA.' ,310.24 ,null   ,null   ,null   ,false     );

INSERT INTO fe_cola_aut 
(tipo_comp,fecha        ,numero_sl,cliente                      ,total  ,mensaje,num_aut,fec_aut,autorizado) VALUES
('FA'     ,'2016-06-10' ,'123815' ,'CAMARONERA AGROMARINA S.A.', 38333.93,null   ,null   ,null   ,false     );

insert into tax (chart_id, rate, taxnumber) VALUES (10930, 0.14, '');
insert into tax (chart_id, rate, taxnumber) VALUES (10864, 0.14, '');

--2018-06-28 Agregar línea de bodega por defecto en tabla defaults
INSERT INTO "public"."defaults" (fldname,fldvalue) VALUES ('production_warehouse_id','32777');
