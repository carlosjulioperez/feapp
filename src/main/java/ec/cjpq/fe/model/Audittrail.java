package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Audittrail por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="audittrail",schema="public")
public class Audittrail  implements java.io.Serializable
 {


     private AudittrailId id;

    public Audittrail() {
    }

    public Audittrail(AudittrailId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="transId", column=@Column(name="trans_id") ), 
        @AttributeOverride(name="tablename", column=@Column(name="tablename") ), 
        @AttributeOverride(name="reference", column=@Column(name="reference") ), 
        @AttributeOverride(name="formname", column=@Column(name="formname") ), 
        @AttributeOverride(name="action", column=@Column(name="action") ), 
        @AttributeOverride(name="transdate", column=@Column(name="transdate", length=29) ), 
        @AttributeOverride(name="employeeId", column=@Column(name="employee_id") ) } )
    public AudittrailId getId() {
        return this.id;
    }
    
    public void setId(AudittrailId id) {
        this.id = id;
    }




}


