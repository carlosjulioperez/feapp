-- Codificación postgres
-- https://www.postgresql.org/message-id/CAHQFj70viWLzxhpZ3iZEGLRO9kahiACSTE+WSfypZ89deZ=QuQ@mail.gmail.com
set client_encoding ='LATIN1';

-- Determinar los usuarios activos en una base:
select count(*) from employee where length(login) > 0;
prueba:      58
agroavilab:     28
prueba:    47
catver:         45
blutec:         56
peru326:        9
gambalit:       10 
tradetecsa:     28


-- Listar todas las columnas
select column_name from information_schema.columns

SELECT table_name, column_name, data_type, is_nullable 
FROM information_schema.columns
WHERE table_schema = 'public'
--AND column_name LIKE '%tipodoc_id%'; --shipvia, waybill
AND column_name LIKE 'bank_id';

select * from information_schema.columns

SELECT * FROM defaults;
SELECT fldvalue FROM defaults WHERE fldname='businessnumber') AS numeroRuc
SELECT fldvalue FROM defaults WHERE fldname='address' AS puntoPartida;


select * from tipodoc;

select * from ar where invnumber like '005-002-000001729'; --152698

select * from ar where transdate >= '01-06-2018';
select * from ar where tipodoc_id IS NOT NULL;  

--FA
select * from ar where id = 187373; --2018-10-23
--RE
select * from ar where id = 111435;
--NC
select * from ar where tipodoc_id = 4;
select * from ar where id = 123849;
--ND
select * from ar where tipodoc_id = 5;
select * from ar where id = 126951;

SELECT to_char(transdate, 'dd/MM/YYYY') AS transdate, id FROM ar WHERE invnumber = '999-999-123456789'

select * from tax;
select * from tax where validto is null;

--VALIDACION DEL IVA
select * from tax where validto >= current_date or validto is null;

--current_date es la fecha actual de PostgreSQL

-- Consulta de la Factura

-- Consulta de productos de factura 2017/11/28

SELECT p.partnumber, m.model, i.description, i.qty, i.sellprice, 
( COALESCE ( 
	(SELECT rate FROM tax t, chart c, partstax p 
	WHERE t.chart_id = c.id AND 
	rate > 0 AND 
	c.category = 'L' AND 
	p.chart_id = c.id AND 
	(t.validto >= current_date or t.validto is null) AND 
	p.parts_id = i.parts_id) ,0) ) AS iva,
    i.discount, i.sellprice, lotnum
FROM invoice i
LEFT OUTER JOIN parts AS p ON i.parts_id = p.id
LEFT OUTER JOIN makemodel AS m ON i.parts_id = m.parts_id 
WHERE i.trans_id = 152698;

select * from invoice where trans_id = 152698;

 partnumber | model  |             description              | qty | sellprice | iva  | discount | sellprice |     lotnum      
------------+--------+--------------------------------------+-----+-----------+------+----------+-----------+-----------------
 HGQS1200   | QS1200 | Q-Swab Letheen Medium 250 Tests/Box  | 300 |      1.65 | 0.12 |        0 |      1.65 | Lot0148116-0317
 NGPT8479   |        | Reveal 3-D Total Milk Allergen       |   3 |       170 | 0.12 |        0 |       170 | Lot0235194-1216
 HGUS2020   | US2020 | Ultrasnap ATP Surface Test (100/Box) | 500 |       2.8 | 0.12 |        0 |       2.8 | Lot0009717-0717
 HGAQ100X   | AQ100X | Aquasnap ATP Total                   |   3 |       280 | 0.12 |        0 |       280 | Lot0082616-1216

	SELECT rate FROM tax t, chart c, partstax p 
	WHERE t.chart_id = c.id AND
	rate > 0 AND 
	c.category = 'L' AND 
	p.chart_id = c.id AND 
	t.validto >= current_date or t.validto is null AND 
	p.parts_id = 22739 ;

Con: p.parts_id = 17158:
 rate  
-------
  0.12
 -0.01
 -0.02
(3 filas)


ERROR:  una subconsulta utilizada como expresión retornó más de un registro

select * from invoice where trans_id = 152698;
----------------------------------------------------------------------------------------------------
-- Determinar el cliente en varias facturas
select ar.id, c.name, c.cc from ar, customer c
where c.id = ar.customer_id and c.id = 126951;

select customer_id, * from ar where id = 111435;

select * from customer;
select * from customer where email like '%carlosjulioperez%';

select * from customer where id = 90646;

--nube
select * from ar where id = 112485;

select * from ar where id=33702 and invoice=true;
select * from invoice;

-- Guias de remision

SELECT * FROM ar 
WHERE invoice = true
AND shippingpoint IS NOT NULL 
AND shippingpoint != ''
AND shipvia IS NOT NULL 
AND shipvia != ''
AND waybill IS NOT NULL 
AND waybill != '';

UPDATE ar SET 
	shippingpoint = '0918056664001',
	shipvia = 'PEREZ QUIZHPE CARLOS JULIO',
	ordnumber = '1234567890',
	waybill = 'GYE-040',
	description = 'VENTA'
WHERE id = 111435

select * from address where address1 like '%KM 10.5 VIA DAULE%';

--Cliente real BC: INT. FOOD SERVICES CORP.  
--correo: grp-ecu-facturaselectronicasplt@kfc.com.ec
select * from customer where id = 40595;

--SELECT * FROM ar WHERE invoice = true and id = 115620;
SELECT * FROM ar WHERE invoice = true and id = 166761;

--TABLA fe_config
select * from fe_config;

select emi_cod_establ, emi_cod_pto_emi  from fe_config;
select 
	cfg_tip_ambiente, emi_cod_establ, emi_cod_pto_emi,
	cfg_sec_factura, cfg_sec_ncredito, cfg_sec_ndebito, cfg_sec_gremision, cfg_sec_cretencion
from fe_config;

select * from fe_cola_aut;
select * from fe_cola_aut order by cola_id;
select * from fe_cola_aut where cola_id > 309
select * from fe_cola_aut where autorizado = false;
select * from fe_cola_aut where autorizado = false and fecha >= '01-12-2017';
select * from fe_cola_aut where numero_sl = '158131';
select * from fe_cola_aut where cliente like 'CAMARONERA AGROMARINA S.A.';

select * from fe_cola_aut where tipo_comp = 'FA';
select * from fe_cola_aut where tipo_comp = 'GR';
select * from fe_cola_aut where tipo_comp = 'RE';
select * from fe_cola_aut where tipo_comp = 'NC';
select * from fe_cola_aut where tipo_comp = 'ND';

prueba=> select * from fe_cola_aut where numero_sl = '173754';

2017-09-18
select cola_id,tipo_comp,fecha,numero_sl,fec_aut,total,cliente from fe_cola_aut;

2016-04-08 Determinar el error del PDF de la GR
select * from fe_cola_aut where autorizado = false and tipo_comp = 'GR';
 
select * from employee where login = 'ap_cromero';
select * from employee where login = 'ap_amvalladares';

select login, tip_ambiente, cod_establ, cod_pto_emi, sec_factura, sec_gremision, sec_cretencion, sec_ncredito, sec_ndebito from employee where login = 'ap_amvalladares';

--2018-02-08 Usuarios y roles
select id, name, login, acsrole_id from employee;
select * from acsrole;

--2018-10-04 Usuarios y archivos p12 asignados
SELECT id, login, name, email, p12_clave, p12_archivo FROM employee WHERE p12_archivo IS NOT NULL;

Copy (
) To '/tmp/test.csv' With CSV DELIMITER ',';


Copy (
    SELECT id, login, name, email, p12_clave, p12_archivo FROM employee WHERE p12_archivo IS NOT NULL
) To '/tmp/usuarios.csv' With CSV DELIMITER ',';


--PRUEBAS
2016-05-31

--productos, 46466 Heat Sensor DUO (lleva IVA)
select * from parts where id in (61536,46466);
select * from partstax where parts_id in (61536,46466);

select i.parts_id, i.id, i.description, i.qty, i.sellprice FROM invoice i WHERE i.trans_id = 115620;


	SELECT t.rate FROM tax t, chart c, partstax p 
	WHERE t.chart_id = c.id AND
	t.rate > 0 AND 
	c.category = 'L' AND 
	p.chart_id = c.id AND 
	(t.validto >= current_date or t.validto is null) AND 
	p.parts_id = 11892;

--Puebas con IVA
SELECT * FROM tax;
DELETE FROM tax WHERE chart_id=10864 AND rate=0.14
UPDATE tax SET validto = '2016-05-31' WHERE chart_id=10930 AND rate=0.12
UPDATE tax SET validto = '2016-05-31' WHERE chart_id=10864 AND rate=0.12

select rate from tax t, chart c, partstax p
where t.chart_id = c.id and
c.category = 'L' and
p.chart_id = c.id
and p.parts_id = 46466

select i.parts_id, i.id, i.description, i.qty, i.sellprice, (
	select rate from tax t, chart c, partstax p
	where t.chart_id = c.id and
	c.category = 'L' and
	p.chart_id = c.id
	and p.parts_id = i.parts_id
) as iva12 
FROM invoice i WHERE i.trans_id = 91617;

--Varios 
select * from customertax where customer_id = 11830;
select * from chart where id = 10930; --12% IVA por Pagar (Todos los clientes tienen 12% de IVA) Category L
select * from chart where id = 10864; --12% IVA Compras
select * from chart where id in (10930,10864);
select * from chart where description like '12%';
select * from gifi;


-- CONSULTA PARA RETENCIONES 2017-09-21
select * from retenc where id = 128120;
select * from retenc where id = 128081; --dos filas
select * from retenc where id = 173754;
select * from retenc where id = 173728;




select * from retenc where secret = '000002470'; --prod
--transdateret Guardar la fecha en formato aaaa-mm-dd

select trans_id, chart_id, amount, transdate, source, memo from acc_trans where trans_id = 128120;
select trans_id, chart_id, amount, transdate, source, memo from acc_trans where trans_id = 128081; --dos filas, source=004-002-000003501
select trans_id, chart_id, amount, transdate, source, memo from acc_trans where trans_id = 156088; --prod
select trans_id, chart_id, amount, transdate, source, memo from acc_trans where trans_id = 156966; --prod

select * from ap where id = 128120;

select * from ap where id = 156991; --prod
select * from ap where invnumber like '004-001-000002481'; --prod

select * from tipodoc;
select * from tiporet;
select * from vendor where id = 51564;
--aaaa-mm-dd
select * from retenc where transdate >= '2016/01/01';
select * from retenc where transdate >= '08-08-16' and transdate <= '08-08-16' 

SELECT 
	v.name, estab, ptoemi, sec, to_char(transdate, 'dd-MM-YYYY') AS transdate, 
	td.code, tiporet_id, tr.description AS tiporet, 
	secret, to_char(transdateret, 'dd-MM-YYYY') AS transdateret, 
	base0, based0, baseni, r.porcret, valret
FROM 
	retenc r, vendor v, tipodoc td, tiporet tr
WHERE
	r.vendor_id = v.id
	AND r.tipodoc_id = td.id
	AND tiporet_id = tr.id 
	--AND valret > 0
	--AND v.name like '%TAME%'
	--AND td.code = 'LIQ'
	--AND sec = '1379'
	AND transdate BETWEEN '06-01-2016' AND '06-01-2016' --'05/01/2016' AND '06/01/2016' 
ORDER BY 
	v.name, transdate, estab, ptoemi, sec;

--Prueba de descuentos
select * from ar where invnumber like '5984';
select * from invoice where trans_id = 123815;

select * from invoice where sellprice <> fxsellprice;

SELECT id, description, to_char(transdate, 'dd/MM/YYYY'),* FROM ar WHERE invnumber='001-001-000000618';

--Consulta de transacciones NC
SELECT 
	ar.id,
	to_char(ar.transdate, 'dd-MM-YYYY') AS transdate1,
	invnumber, c.name, description, amount, ordnumber, ar.notes
FROM 
	ar, customer c
WHERE 
	c.id = ar.customer_id
	AND c.name like 'INDUSTRIAS LACTEAS TONI S.A.'
	--AND description LIKE '%N/C%'
	AND transdate BETWEEN '01-06-2016' AND '31-07-2016'
ORDER BY
	transdate, name;
	
----------------------------------------------------------------------------------------------------
-- Notas de Débito
SELECT * FROM chart where id=10864;
SELECT * FROM chart where description like '%Anticipos Pro%';

-- Con IVA 
-- 123461 001-001-000008626
-- 123504 001-001-000000618 *
-- 123536 001-001-000050117
-- 123606 001-011-0005199245
-- 123708 002-002-000015367
-- 123753 001-001-000011927
-- 123754 001-001-000009147 

SELECT * FROM ap WHERE id = 123504; --122762; --123504;
SELECT * FROM ap WHERE invnumber = '001-001-000000618';

set client_encoding ='LATIN1';
select * from acc_trans where trans_id = 128120;

--2017-09-18 Pruebas para Retenciones
SELECT * FROM acc_trans WHERE trans_id = 2897;
SELECT * FROM acc_trans WHERE transdate >= '06-06-2018';

select * from ar where id = 169882;

--Listado de motivos
SELECT abs(amount), memo FROM acc_trans WHERE trans_id = 122762 AND memo IS NOT NULL AND id IS NULL AND source IS NULL;
SELECT * FROM acc_trans WHERE trans_id = 122762 AND memo IS NOT NULL AND id IS NULL AND source IS NULL;

--Determinar el valor de IVA
SELECT * FROM acc_trans WHERE trans_id = 123850 AND memo IS NULL AND source IS NULL;

SELECT 
	abs(amount) AS valor, rate
FROM 
	acc_trans a, tax t
WHERE 
	trans_id =123850 
	AND amount > 0 AND memo IS NULL AND source IS NULL
	AND a.chart_id = t.chart_id
	AND rate > 0 AND (validto >= current_date OR validto IS NULL)	
	
SELECT * FROM acc_trans WHERE trans_id = 123504;

--Listado de impuestos
SELECT * FROM tax 
WHERE chart_id = 10864 AND rate>0 AND (validto >= current_date OR validto IS null)

--Línea 26894
-- Data for Name: acc_trans; Type: TABLE DATA; Schema: public; Owner: sql-ledger

SELECT * FROM vendor WHERE id = 12456;
SELECT * FROM ap WHERE transdate BETWEEN '01-08-2015' AND '30-06-2016';
SELECT * FROM ap WHERE taxincluded = true;
	
SELECT
	ap.id,
	to_char(transdate, 'dd-MM-YYYY') AS transdate1,
	invnumber, name, description, amount
FROM ap, vendor v
WHERE 
	v.id = ap.vendor_id
	--AND name like 'INDUSTRIAS LACTEAS TONI S.A.'
	AND description LIKE '%N/D%'
	AND transdate BETWEEN '01-08-2015' AND '30-06-2016'
ORDER BY
	transdate, name;

--Resumen de ventas de clientes por periodo

Copy (Select * From foo) To '/tmp/test.csv' With CSV DELIMITER ',';

COPY (
    SELECT DISTINCT 
        c.id, c.name, c.email,
        SUM(netamount)
    FROM 
        ar, customer as c
    WHERE
        transdate BETWEEN '15-11-2016' AND '15-11-2017' 
        AND customer_id = c.id
    GROUP BY
        c.id, c.name, c.email
    HAVING SUM(netamount) > 0
    ORDER BY c.name
)
TO '/tmp/clientes_activos.csv' With CSV DELIMITER ',';


--2017-12-06
--2018-01-02

--Exportar maestros 
COPY ( SELECT * FROM customer ORDER BY name )
TO '/tmp/customer.csv' With CSV DELIMITER ',';

COPY ( SELECT * FROM vendor ORDER BY name )
TO '/tmp/vendor.csv' With CSV DELIMITER ',';

COPY ( SELECT * FROM parts ORDER BY description )
TO '/tmp/parts.csv' With CSV DELIMITER ',';

COPY ( SELECT * FROM chart order by accno )
TO '/tmp/chart.csv' With CSV DELIMITER ',';

--Importar

COPY customer FROM '/tmp/customer.csv' DELIMITERS ',' CSV;


SELECT * FROM customer where customernumber like '%602923567001';
SELECT * FROM customer where customernumber like '%990658749001';


