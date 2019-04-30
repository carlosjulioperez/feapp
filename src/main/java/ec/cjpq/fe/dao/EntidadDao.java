package ec.cjpq.fe.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import ec.cjpq.cjfews.comprobante.notadebito.Motivo;
import ec.cjpq.fe.bean.DatosAp;
import ec.cjpq.fe.bean.DatosAr;
import ec.cjpq.fe.bean.DatosGuiaRemision;
import ec.cjpq.fe.bean.DatosRetencion;
import ec.cjpq.fe.model.Department;
import ec.cjpq.fe.model.EmployeeId;
import ec.cjpq.fe.model.FeColaAut;
import ec.cjpq.fe.model.FeConfig;
import ec.cjpq.fe.util.Comprobante;
import ec.cjpq.fe.util.HibernateUtil;
import ec.cjpq.fe.util.Util;

@SuppressWarnings({"unchecked", "rawtypes"})
public class EntidadDao {
	
	private Session session = null;
	private Transaction tx = null;
	
	public EntidadDao() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
	}

	/**
	 * Obtiene los datos de configuración del emisor
	 * @param id
	 * @return
	 */
	public FeConfig getFeConfig(short id){
        tx = session.beginTransaction();

        FeConfig objeto = null;
		try {
			objeto = (FeConfig)session.get(FeConfig.class, id);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} 
		return objeto;
	}

	/**
	 * Actualiza la secuencia de las facturas
	 * @param id
	 * @return
	 */
	public int getSecuenciaFactura(short id){
        tx = session.beginTransaction();
        int numero = 0;
		try {
			FeConfig objeto = (FeConfig)session.get(FeConfig.class, id);
			numero = objeto.getCfgSecFactura() + 1;
			objeto.setCfgSecFactura(numero);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} 
		return numero;
	}

	//TODOs: Obtener el ID por medio de SQL nativo y actualizar la numeracion de acuerdo al tipo de documento
	public int getSecuenciaComprobanteEmpleado(Comprobante tipo, String login){
        int numero = 0;
        EmployeeId employeeId = getEmployeeByLogin(login);

        if (employeeId != null){
        	Session miSession = HibernateUtil.getSessionFactory().getCurrentSession();
        	Transaction miTx = miSession.beginTransaction();
	        try {
				
	        	String campo = "";
				switch (tipo) {
				case FACTURA: 
					campo = "sec_factura"; numero = employeeId.getSecFactura() + 1; break;
					
				case CRETENCION: 
					campo = "sec_cretencion"; numero = employeeId.getSecCretencion() + 1; break;

				case GREMISION: 
					campo = "sec_gremision"; numero = employeeId.getSecGremision() + 1; break;
					
				case NCREDITO: 
					campo = "sec_ncredito"; numero = employeeId.getSecNcredito() + 1; break;

				case NDEBITO: 
					campo = "sec_ndebito"; numero = employeeId.getSecNdebito() + 1; break;

				}
				miSession.createSQLQuery("UPDATE employee set "+campo+" = ? where login=? ").setInteger(0, numero).setString(1, login).executeUpdate();
				
				miTx.commit();
			} catch (HibernateException e) {
				miTx.rollback();
				e.printStackTrace();
			} 
        }
		return numero;
	}

	/**
	 * Obtiene la cabecera y el detalle de la factura
	 * @param numero
	 * @return
	 */
	public Object[]getFactura(int numero){
        tx = session.beginTransaction();
		
        StringBuilder sb;
        Object []cabecera = null;
        List<Object[]> detalles = null;
		try {
			sb = new StringBuilder();
			sb.append("select ar.id, ar.invnumber, to_char(ar.transdate,'dd/MM/YYYY'),");
			sb.append("c.name, c.taxnumber, c.email, c.phone, ar.amount, ar.cashdiscount, ");
			sb.append("ar.ponumber, ar.notes, ar.ordnumber, c.cc, ar.description, ar.intnotes ");
			sb.append("from ar, customer c ");
			sb.append("where ar.id=? and invoice=true ");
			sb.append("and ar.customer_id = c.id ");
			sb.append("order by transdate desc ");
			cabecera = (Object[]) session.createSQLQuery(sb.toString()).setInteger(0, numero).uniqueResult();

			//Detalle de las facturas (productos) con el valor del IVA que aplica, iva0=NULL
			sb = new StringBuilder();
			
			//sb.append("SELECT p.partnumber, m.model, i.description, i.qty, i.fxsellprice, "); 
            //2019-02-14 Agregar unidad en la descripción
            sb.append("SELECT p.partnumber, m.model, ");
            sb.append("(CASE WHEN (i.unit IS NULL OR i.unit = '') THEN '' ELSE '('||i.unit||') ' END)");
            sb.append(" || i.description AS description, i.qty, i.fxsellprice, ");

            sb.append("( COALESCE ( "); 
			sb.append("	(SELECT t.rate FROM tax t, chart c, partstax p "); 
			sb.append("	WHERE t.chart_id = c.id AND "); 
			sb.append("	t.rate > 0 AND "); //Agregado 29/mar/2016
			sb.append("	c.category = 'L' AND "); 
			sb.append("	p.chart_id = c.id AND "); 
			sb.append("	(t.validto >= current_date or t.validto is null) AND "); //Agregado 1/jun/2016
			sb.append("	p.parts_id = i.parts_id) ,0) ) AS iva, "); 
			sb.append(" i.discount, i.sellprice, lotnum "); //Agregado 29-Nov-2017
			sb.append("FROM invoice i "); 
			sb.append("LEFT OUTER JOIN parts AS p ON i.parts_id = p.id "); 
			sb.append("LEFT OUTER JOIN makemodel AS m ON i.parts_id = m.parts_id "); 
			sb.append("WHERE i.trans_id = ? ");
			
			detalles = session.createSQLQuery(sb.toString()).setInteger(0, numero).list();
			
			tx.commit();
		}catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
		return new Object[]{cabecera, detalles};
	}
	
	public Department getDepartments(int id){
        tx = session.beginTransaction();
        
        Department objeto = null;
		try {
			objeto = (Department) session.createQuery("from Department d where d.id.id=?").setInteger(0, id).uniqueResult();
			tx.commit();
		}catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} 
		return objeto;
	}

	public void actualizarColaAutorizacion(FeColaAut cola){
        tx = session.beginTransaction();
		try {
			session.update(cola);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} 
	}

	public void quitarDeColaAutorizacion(FeColaAut cola){
        tx = session.beginTransaction();
		try {
			session.delete(cola);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} 
	}

	public void grabarColaAutorizacion(FeColaAut cola){
        tx = session.beginTransaction();
		try {
			session.save(cola);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} 
	}
	
	public List <FeColaAut> getListadoFeColaAut(){
        tx = session.beginTransaction();
        List <FeColaAut>listado = null;
		try {
			listado = (List <FeColaAut>) session.createQuery("from FeColaAut").list();
			tx.commit();
		}catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} 
		return listado;
	}
	
	public List <FeColaAut> getListadoFeColaAut(String condicion){
        tx = session.beginTransaction();
        List <FeColaAut>listado = null;
		try {
			listado = (List <FeColaAut>) session.createQuery("from FeColaAut "+ condicion).list();
			tx.commit();
		}catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} 
		return listado;
	}

    public List <FeColaAut> getListadoFeColaAut(String tipoComprobante, String cliente, String mensaje, boolean noAutorizados, int firstResult, int maxResults){
		
        tx = session.beginTransaction();
        List <FeColaAut>listado = null;
		try {
			Criteria criteria = session.createCriteria(FeColaAut.class);
			criteria.addOrder(Order.asc("fecha"));
			if (maxResults > 0){
				criteria.setFirstResult(firstResult);
				criteria.setMaxResults(maxResults);
			}
			
			if(tipoComprobante.length()>0)
				criteria.add( Expression.eq("tipoComp", tipoComprobante ) );
			
			if(cliente.length()>0)
				criteria.add( Expression.like("cliente", "%"+cliente+"%") );

			if(mensaje.length()>0)
				criteria.add( Expression.like("mensaje", "%"+mensaje+"%") );

			//2016-08-04
			if (noAutorizados)
				criteria.add(Restrictions.isNull("mensaje"));
				
			listado = criteria.list();

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} 
		return listado;
    }
    
    public EmployeeId getEmployeeByLogin(String login){
        //https://stackoverflow.com/questions/4436419/aliastobeanresulttransformer-and-hibernate-sqlquery 
        tx = session.beginTransaction();
        StringBuilder sb;
        EmployeeId employeeId = null;
		try {
			sb = new StringBuilder();
			sb.append("select ");
			
			sb.append("login          as \"login\",        ");
			sb.append("name           as \"name\",        ");
			sb.append("p12_archivo    as \"p12Archivo\",   ");
			sb.append("p12_clave      as \"p12Clave\",     ");
			sb.append("tip_ambiente   as \"tipAmbiente\",  ");
			sb.append("cod_establ     as \"codEstabl\",    ");
			sb.append("cod_pto_emi    as \"codPtoEmi\",    ");
			sb.append("sec_factura    as \"secFactura\",   ");
			sb.append("sec_ncredito   as \"secNcredito\",  ");
			sb.append("sec_ndebito    as \"secNdebito\",   ");
			sb.append("sec_gremision  as \"secGremision\", ");
			sb.append("sec_cretencion as \"secCretencion\" ");
			sb.append("from employee where login=? ");
			
			List lista = ((SQLQuery) session.createSQLQuery(sb.toString())
					.setString(0, login))
					.setResultTransformer(Transformers.aliasToBean(EmployeeId.class)).list();
			
			if (lista.size() > 0)
				employeeId = (EmployeeId)lista.get(0);
			tx.commit();
		}catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} 
		return employeeId;
    }
    
//    public RetencId getRetencId(){
//    	
//    }
    
    /**
     * Ejemplo para actualizar una tabla en SQL-Ledger
     * @param eId
     */
	public void actualizarEmployee(EmployeeId eId){
        tx = session.beginTransaction();
        
    	Session miSession = HibernateUtil.getSessionFactory().getCurrentSession();
    	Transaction miTx = miSession.beginTransaction();
		try {
			
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE employee set ");
			sb.append("p12_archivo = ?,");
			sb.append("p12_clave = ?, ");
			sb.append("tip_ambiente= ?, ");
			sb.append("cod_establ = ?, ");
			sb.append("cod_pto_emi = ?, ");
			sb.append("sec_factura = ?, ");
			sb.append("sec_ncredito = ?, ");
			sb.append("sec_ndebito = ?, ");
			sb.append("sec_gremision = ?, ");
			sb.append("sec_cretencion = ? ");
			sb.append("WHERE login = ? ");
			
			miSession.createSQLQuery(sb.toString())
			.setString (0, eId.getP12Archivo())
			.setString (1, eId.getP12Clave())
			.setShort  (2, eId.getTipAmbiente())
			.setString (3, eId.getCodEstabl())
			.setString (4, eId.getCodPtoEmi())
			.setInteger(5, eId.getSecFactura())
			.setInteger(6, eId.getSecNcredito())
			.setInteger(7, eId.getSecNdebito())
			.setInteger(8, eId.getSecGremision())
			.setInteger(9, eId.getSecCretencion())
			.setString (10, eId.getLogin())
			.executeUpdate();

			miTx.commit();
		} catch (Exception e) {
			miTx.rollback();
			e.printStackTrace();
		} 
	}

    /**
     * Ejemplo para actualizar una tabla en SQL-Ledger
     * @param eId
     */
	public void actualizarFactura(Integer id, String autorizacion, String secuencia){
        tx = session.beginTransaction();
        
    	Session miSession = HibernateUtil.getSessionFactory().getCurrentSession();
    	Transaction miTx = miSession.beginTransaction();
		try {
			
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE ar set ");
			sb.append("ordnumber = ?, ");
			sb.append("invnumber = ? ");
			sb.append("WHERE id = ? ");
			
			miSession.createSQLQuery(sb.toString())
			.setString (0, autorizacion)
			.setString (1, secuencia)
			.setInteger (2, id)
			.executeUpdate();

			miTx.commit();
		} catch (Exception e) {
			miTx.rollback();
			e.printStackTrace();
		} 
	}

	public void actualizarAp(Integer id, String autorizacion, String secuencia){
        tx = session.beginTransaction();
        
    	Session miSession = HibernateUtil.getSessionFactory().getCurrentSession();
    	Transaction miTx = miSession.beginTransaction();
		try {
			
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE ap set ");
			sb.append("ordnumber = ?, ");
			sb.append("invnumber = ? ");
			sb.append("WHERE id = ? ");
			
			miSession.createSQLQuery(sb.toString())
			.setString (0, autorizacion)
			.setString (1, secuencia)
			.setInteger (2, id)
			.executeUpdate();

			miTx.commit();
		} catch (Exception e) {
			miTx.rollback();
			e.printStackTrace();
		} 
	}

    /**
     * Ejemplo para actualizar una tabla en SQL-Ledger
     * @param eId
     */
	public void actualizarDatosRetencion(Integer id, String autorizacion, String secuencia, Date fecha){
        tx = session.beginTransaction();
        
    	Session miSession = HibernateUtil.getSessionFactory().getCurrentSession();
    	Transaction miTx = miSession.beginTransaction();
		try {
		
			String[] cadena = secuencia.split("-");
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE retenc set ");
			sb.append("estabret = ?, ");
			sb.append("ptoemiret = ?, ");
			sb.append("secret = ?, ");
			sb.append("ordnumberret = ?, ");
			sb.append("transdateret = ? ");
			sb.append("WHERE id = ? ");
			
			miSession.createSQLQuery(sb.toString())
			.setString  (0, cadena[0])
			.setString  (1, cadena[1])
			.setString  (2, cadena[2])
			.setString  (3, autorizacion)
			.setDate    (4, fecha)
			.setInteger (5, id)
			.executeUpdate();
			
			//2017-09-21
			sb = new StringBuilder();
			sb.append("UPDATE acc_trans a "); 
			sb.append("SET source = r.estabret || '-' || r.ptoemiret || '-' || r.secret ");
			sb.append("FROM retenc r ");
			sb.append("WHERE a.trans_id = ? AND ");
			sb.append("a.trans_id = r.id AND  ");
			sb.append("a.chart_id = r.chart_id ");

			miSession.createSQLQuery(sb.toString())
			.setInteger (0, id)
			.executeUpdate();

			miTx.commit();
		} catch (Exception e) {
			miTx.rollback();
			e.printStackTrace();
		} 
	}

	public DatosGuiaRemision getDatosGuiaRemision(int arId) throws Exception{
        tx = session.beginTransaction();
        StringBuilder sb;

        DatosGuiaRemision datos = null;
		try {
			sb = new StringBuilder();

			sb.append("SELECT ");
			sb.append("shippingpoint AS \"transportistaId\", ");
			sb.append("shipvia AS \"transportistaRazonSocial\", ");
			sb.append("waybill AS \"placa\", ");
			sb.append("(SELECT fldvalue FROM defaults WHERE fldname='address') AS \"puntoPartida\", ");
			sb.append("TO_CHAR(ar.transdate, 'dd/MM/YYYY') AS \"fecha\", ");
			sb.append("invnumber AS \"numeroFactura\", ");
			sb.append("ordnumber AS \"numeroAutorizacionFactura\", ");
			sb.append("description AS \"motivoTraslado\", ");

			sb.append("(SELECT address1 || address2 FROM address WHERE trans_id = ar.customer_id) AS \"puntoLlegada\", ");
			sb.append("(SELECT taxnumber FROM customer WHERE id = ar.customer_id) AS \"destinatarioId\", ");
			sb.append("(SELECT name      FROM customer WHERE id = ar.customer_id) AS \"destinatarioRazonSocial\" ");
			
			sb.append("FROM ar ");
			sb.append("WHERE id = ? ");
			sb.append("AND invoice = TRUE ");
			
			List lista = ((SQLQuery) session.createSQLQuery(sb.toString())
					.setInteger(0, arId))
					.setResultTransformer(Transformers.aliasToBean(DatosGuiaRemision.class)).list();
					
			if (lista.size() > 0){
				datos = (DatosGuiaRemision)lista.get(0);
				
				if (Util.isCadenaVacia(datos.getTransportistaId()))
					throw new Exception("No tiene datos el id de transportista (shippingpoint)");

				if (Util.isCadenaVacia(datos.getTransportistaRazonSocial()))
					throw new Exception("No tiene datos la razón social de transportista (shipvia)");

				if (Util.isCadenaVacia(datos.getPlaca()))
					throw new Exception("No tiene datos la placa (waybill)");
				
				if (Util.isCadenaVacia(datos.getPuntoPartida()))
					throw new Exception("No tiene datos el punto de partida (defaults.fldname('address'))");

				if (Util.isCadenaVacia(datos.getFecha()))
					throw new Exception("No tiene datos la fecha (transdate)");

				if (Util.isCadenaVacia(datos.getNumeroFactura()))
					throw new Exception("No tiene datos el número de factura (invnumber)");
				
				if (Util.isCadenaVacia(datos.getNumeroAutorizacionFactura()))
					throw new Exception("No tiene datos el número de autorización de la factura (ordnumber)");

				if (Util.isCadenaVacia(datos.getMotivoTraslado()))
					throw new Exception("No tiene datos el motivo de traslado (description)");

				if (Util.isCadenaVacia(datos.getPuntoLlegada()))
					throw new Exception("No tiene datos el punto de llegada o dirección del cliente (customer.address1 + customer.address2 )");

				if (Util.isCadenaVacia(datos.getDestinatarioId()))
					throw new Exception("No tiene datos el id del destinatario o ruc del cliente (customer.taxnumber)");

				if (Util.isCadenaVacia(datos.getDestinatarioRazonSocial()))
					throw new Exception("No tiene datos la razón social del destinatario o nombre del cliente (customer.name)");

			}else
				throw new Exception("No existe la Factura Sql-Ledger # " + arId + " para generar la Guía de Remisión.");
			tx.commit();
		}catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} 
		return datos;

	}
	
	public DatosGuiaRemision getConsultaGuiaRemision(String numeroFactura){
        tx = session.beginTransaction();
        StringBuilder sb;

        DatosGuiaRemision datos = null;
		try {
			sb = new StringBuilder();

			sb.append("SELECT ");
			sb.append("(SELECT name FROM customer WHERE id = ar.customer_id) AS \"destinatarioRazonSocial\", ");
			sb.append("TO_CHAR(ar.transdate, 'dd/MM/YYYY') AS \"fecha\", ");
			sb.append("id AS \"id\", ");
			sb.append("shippingpoint AS \"transportistaId\", ");
			sb.append("shipvia AS \"transportistaRazonSocial\", ");
			sb.append("waybill AS \"placa\", ");
			sb.append("description AS \"motivoTraslado\" ");
			sb.append("FROM ar ");
			sb.append("WHERE invnumber = ? ");
			sb.append("AND invoice = TRUE ");
			
			List lista = ((SQLQuery) session.createSQLQuery(sb.toString())
					.setString(0, numeroFactura))
					.setResultTransformer(Transformers.aliasToBean(DatosGuiaRemision.class)).list();
					
			if (lista.size() > 0)
				datos = (DatosGuiaRemision)lista.get(0);
			
			tx.commit();
		}catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} 
		return datos;
	}

    /**
     * Ejemplo para actualizar una tabla en SQL-Ledger
     * @param eId
     */
	public void actualizarDatosGuiaRemision(Map<String, String> parametro){
        tx = session.beginTransaction();
        
    	Session miSession = HibernateUtil.getSessionFactory().getCurrentSession();
    	Transaction miTx = miSession.beginTransaction();
		try {
			
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE ar set ");
			sb.append("shippingpoint = ?, ");
			sb.append("shipvia = ?, ");
			sb.append("waybill = ?, ");
			sb.append("description = ? ");
			sb.append("WHERE invnumber = ? ");
			
			miSession.createSQLQuery(sb.toString())
			.setString (0, parametro.get("id"))
			.setString (1, parametro.get("razonSocial"))
			.setString (2, parametro.get("placa"))
			.setString (3, parametro.get("motivo"))
			.setString (4, parametro.get("numeroFactura"))
			.executeUpdate();

			miTx.commit();
		} catch (Exception e) {
			miTx.rollback();
			e.printStackTrace();
		} 
	}
	
	/**
	 * Devuelve el String del Query usado en la consulta.
	 * Uso el mismo objeto dr para pasar los parámetros y no crear demasiadas variables...   ;)
	 * @return
	 */
	//private String getConsultaRetencionString(String nombre, String idprov, String tipodocCod, String tipodocId, String secuencia, String fechaDesde, String fechaHasta){
	private String getConsultaRetencionString(DatosRetencion dr){
        StringBuilder sb;

		sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append("	r.id, v.name, idprov, email, cc, phone, td.code, to_char(tipodoc_id, 'fm00') AS \"tipodocId\", estab, ptoemi, sec, ");
		sb.append("	to_char(transdate, 'dd-MM-YYYY') AS transdate, ");
		sb.append("	tiporet_id AS \"tiporetId\", tr.impuesto AS tiporet, ");
		sb.append("	secret, to_char(transdateret, 'dd-MM-YYYY') AS transdateret, ");
		sb.append("	base0, based0, baseni, r.porcret, valret ");
		sb.append("FROM ");
		sb.append("	retenc r, vendor v, tipodoc td, tiporet tr ");
		sb.append("WHERE ");
		sb.append("	r.vendor_id = v.id ");
		sb.append("	AND r.tipodoc_id = td.id ");
		sb.append("	AND tiporet_id = tr.id ");
		
		if (dr.getId()!=null && dr.getId() > 0)
			sb.append(String.format(" AND r.id = %s ", dr.getId()));
		
		if (dr.getName()!=null && dr.getName().length() > 0)
			sb.append(String.format(" AND v.name like '%s' ", "%"+dr.getName()+"%"));
		
		if (dr.getIdprov()!=null && dr.getIdprov().length() > 0)
			sb.append(String.format(" AND idprov = '%s' ", dr.getIdprov()));
		
		if (dr.getCode()!=null && dr.getCode().length() > 0)
			sb.append(String.format(" AND td.code = '%s' ", dr.getCode()));
		
		if (dr.getTipodocId()!=null && dr.getTipodocId().length() > 0)
			sb.append(String.format(" AND tipodoc_id = %s ", Integer.parseInt(dr.getTipodocId())));
		
		if (dr.getEstab()!=null && dr.getEstab().length() > 0)
			sb.append(String.format(" AND estab = '%s' ", dr.getEstab()));
		
		if (dr.getPtoemi()!=null && dr.getPtoemi().length() > 0)
			sb.append(String.format(" AND ptoemi = '%s' ", dr.getPtoemi()));
		
		if (dr.getSec()!=null && dr.getSec().length() > 0)
			sb.append(String.format(" AND sec = '%s' ", dr.getSec()));
		
		if (dr.getTiporetId()!=null && dr.getTiporetId() > 0)
			sb.append(String.format(" AND tiporet_id = %s ", dr.getTiporetId()));
		
		if ( ( dr.getTransdate()!=null && dr.getTransdate().length() > 0) && (dr.getTransdateret()!=null && dr.getTransdateret().length() > 0) )
			sb.append(String.format(" AND transdate BETWEEN '%s' AND '%s' ", dr.getTransdate(), dr.getTransdateret()));
		
		sb.append("ORDER BY ");
		sb.append("	v.name, transdate, estab, ptoemi, sec ");
			
		return sb.toString();
	}
	
	//public int getConsultaRetencionSize(String nombre, String tipo, String secuencia, String fechaDesde, String fechaHasta){
	public int getConsultaRetencionSize(DatosRetencion dr){
        tx = session.beginTransaction();
        int total = 0;
		try {
			//Query query = session.createSQLQuery( getConsultaRetencionString(nombre, tipo, secuencia, fechaDesde, fechaHasta ));
			Query query = session.createSQLQuery( getConsultaRetencionString( dr ));
			total = query.list().size();
			tx.commit();
		}catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} 
		return total;
	}
	
	public List<DatosRetencion>getConsultaRetencionList(DatosRetencion dr, int firstResult, int maxResult){
        tx = session.beginTransaction();
        List<DatosRetencion>lista = null;
		try {
			Query query = session.createSQLQuery( getConsultaRetencionString( dr ));
			if (maxResult > 0 ){
				query.setFirstResult(firstResult);
				query.setMaxResults(maxResult);
			}
			query.setResultTransformer(Transformers.aliasToBean(DatosRetencion.class));
			lista = (List<DatosRetencion>)query.list();
			tx.commit();
		}catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} 
		return lista;
	}
	/**
	 * Consulta para NC
	 * @param dar
	 * @return
	 */
	private String getConsultaArString(DatosAr dar){
        StringBuilder sb;

        //5 Nota de Debito                              NDB
        //4 Nota de Credito                             NCR
        
		sb = new StringBuilder();
		
		sb.append("SELECT "); 
		sb.append("	ar.id, "); 
		sb.append("	to_char(transdate, 'dd/MM/YYYY') AS transdate, "); 
		sb.append("	invnumber, c.name, c.email, description, amount, netamount, ponumber, "); 
		sb.append("	ordnumber, ar.notes, taxnumber, cc, phone  "); 
		sb.append("FROM "); 
		sb.append("	ar, customer c "); 
		sb.append("WHERE "); 
		sb.append("	c.id = ar.customer_id "); 
		
		//Solo filtrar por tipo de documento para ND
		if ( dar.getTipo().equals("5") )
			sb.append(String.format("AND ar.tipodoc_id = %s ", dar.getTipo() )); //2016-08-05
		
		if (dar.getName()!=null && dar.getName().length() > 0)
			sb.append(String.format(" AND c.name like '%s' ", "%"+dar.getName()+"%"));

		if (dar.getDescription()!=null && dar.getDescription().length() > 0)
			sb.append(String.format(" AND description like '%s' ", "%"+dar.getDescription()+"%"));

		if ( ( dar.getTransdate()!=null && dar.getTransdate().length() > 0) && (dar.getTransdateto()!=null && dar.getTransdateto().length() > 0) )
			sb.append(String.format(" AND transdate BETWEEN '%s' AND '%s' ", dar.getTransdate(), dar.getTransdateto()));
		
		sb.append("ORDER BY "); 
		sb.append("	transdate, name ");	
			
		return sb.toString();
	}
	public int getConsultaArSize(DatosAr dar){
        tx = session.beginTransaction();
        int total = 0;
		try {
			Query query = session.createSQLQuery( getConsultaArString ( dar ));
			total = query.list().size();
			tx.commit();
		}catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} 
		return total;
	}
	
	public List<DatosAr>getConsultaArList(DatosAr dar, int firstResult, int maxResult){
        tx = session.beginTransaction();
        List<DatosAr>lista = null;
		try {
			Query query = session.createSQLQuery( getConsultaArString( dar ));
			if (maxResult > 0 ){
				query.setFirstResult(firstResult);
				query.setMaxResults(maxResult);
			}
			query.setResultTransformer(Transformers.aliasToBean(DatosAr.class));
			lista = (List<DatosAr>)query.list();
			tx.commit();
		}catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} 
		return lista;
	}
	
	public Object[] getDatosArInvoice(String invnumber){
        tx = session.beginTransaction();

        Object []datos = null;
		try {
			//String consulta = String.format("SELECT to_char(transdate, 'dd/MM/YYYY') AS transdate, id FROM ar WHERE invnumber = '%s'", invnumber);
			String consulta = "SELECT to_char(transdate, 'dd/MM/YYYY') AS transdate, id FROM ar WHERE invnumber = ? AND amount > 0";
			List lista = session.createSQLQuery(consulta).setString(0, invnumber) .list();
			if (lista.size() > 0)
				datos = (Object[]) lista.get(0);

			tx.commit();
		}catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
		return datos;
	}

	/**
	 * Consulta para NC
	 * @param dap
	 * @return
	 */
	private String getConsultaApString(DatosAp dap){
        StringBuilder sb;

		sb = new StringBuilder();
		sb.append("SELECT "); 
		sb.append("	ap.id, "); 
		sb.append("	to_char(transdate, 'dd/MM/YYYY') AS transdate, "); 
		sb.append("	invnumber, name, email, description, amount, netamount, ponumber, ");
		sb.append(" gifi_accno AS \"gifiAccno\", ");
		sb.append(" v.cc, ap.notes, v.phone ");
		sb.append("FROM ap, vendor v "); 
		sb.append("WHERE ");
		sb.append("	v.id = ap.vendor_id "); 
		
		if (dap.getId()!=null && dap.getId().intValue() > 0)
			sb.append(String.format(" AND ap.id = %s ", dap.getId() ));
		
		if (dap.getName()!=null && dap.getName().length() > 0)
			sb.append(String.format(" AND name like '%s' ", "%"+dap.getName()+"%"));

		if (dap.getDescription()!=null && dap.getDescription().length() > 0)
			sb.append(String.format(" AND description like '%s' ", "%"+dap.getDescription()+"%"));

		if ( ( dap.getTransdate()!=null && dap.getTransdate().length() > 0) && (dap.getTransdateto()!=null && dap.getTransdateto().length() > 0) )
			sb.append(String.format(" AND transdate BETWEEN '%s' AND '%s' ", dap.getTransdate(), dap.getTransdateto()));
		
		sb.append("ORDER BY "); 
		sb.append("	transdate ");	
			
		return sb.toString();
	}
	public int getConsultaApSize(DatosAp dap){
        tx = session.beginTransaction();
        int total = 0;
		try {
			Query query = session.createSQLQuery( getConsultaApString ( dap ));
			total = query.list().size();
			tx.commit();
		}catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} 
		return total;
	}
	
	public List<DatosAp>getConsultaApList(DatosAp dap, int firstResult, int maxResult){
        tx = session.beginTransaction();
        List<DatosAp>lista = null;
		try {
			Query query = session.createSQLQuery( getConsultaApString( dap ));
			if (maxResult > 0 ){
				query.setFirstResult(firstResult);
				query.setMaxResults(maxResult);
			}
			query.setResultTransformer(Transformers.aliasToBean(DatosAp.class));
			lista = (List<DatosAp>)query.list();
			tx.commit();
		}catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} 
		return lista;
	}

	public List<Motivo>getMotivosAp(Integer transId){
        tx = session.beginTransaction();
        List<Motivo>lista = null;
		try {
			String consulta = "SELECT memo AS \"razon\", TRIM(both ' ' from to_char(abs(amount), '99999999.99')) AS \"valor\" FROM acc_trans WHERE trans_id = ? AND memo IS NOT NULL AND id IS NULL AND source IS NULL";

			Query query = session.createSQLQuery( consulta ).setInteger(0, transId);
			query.setResultTransformer(Transformers.aliasToBean(Motivo.class));
			lista = (List<Motivo>)query.list();
			tx.commit();
		}catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} 
		return lista;
	}
	
	public Object[] getImpuestoAr(Integer numero){
        StringBuilder sb = new StringBuilder();
        Object []datos = null;

        tx = session.beginTransaction();
		try {
			sb.append("SELECT "); 
			sb.append("	abs(amount) AS valor, rate "); 
			sb.append("FROM "); 
			sb.append("	acc_trans a, tax t "); 
			sb.append("WHERE "); 
			sb.append("	trans_id = ? "); 
			sb.append("	AND amount > 0 AND memo IS NULL AND source IS NULL "); 
			sb.append("	AND a.chart_id = t.chart_id "); 
			sb.append("	AND rate > 0 AND (validto >= current_date OR validto IS NULL) ");
			List lista = session.createSQLQuery(sb.toString()).setInteger(0, numero) .list();
			if (lista.size() > 0)
				datos = (Object[]) lista.get(0);

			tx.commit();
		}catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
		return datos;
	}

	/*
	public boolean isValidarUsuario(String login){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Usuario usuario = null;
		try {
			usuario = (Usuario) session.createQuery("from Usuario u where u.login = ?")
			.setString(0, login).uniqueResult();

			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			String mensaje = Util.stack2string(e);
			log.warn(mensaje);
		} 
		return usuario!=null ? true: false;
	}
	*/

	
	/*
	public List<Object[]> getTransaccionesAsignadas(String usuarioId){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        List <Object[]>retorno = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("Select t.aplicacion.descripcion, t.tipotransaccion.descripcion, t.descripcion ");
			sb.append("from Transaccion t, Usuario u, UsuarioRol ur, RolTransaccion rt ");
			sb.append("where u.login = ? ");
			sb.append("and ur.usuario.id = u.id ");
			sb.append("and ur.rol.id = rt.rol.id ");
			sb.append("and rt.transaccion.id = t.id ");
			sb.append("order by t.aplicacion.descripcion, t.orden ");
			retorno = (List<Object[]>) session.createQuery(sb.toString()).setString(0, usuarioId).list();

			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			String mensaje = Util.stack2String(e);
			log.warn(mensaje);
		} 
		return retorno;
	}
	*/
}
