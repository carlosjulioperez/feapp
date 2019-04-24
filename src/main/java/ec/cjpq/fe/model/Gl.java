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
 * Gl por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="gl",schema="public")
public class Gl  implements java.io.Serializable
 {


     private GlId id;

    public Gl() {
    }

    public Gl(GlId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id") ), 
        @AttributeOverride(name="reference", column=@Column(name="reference") ), 
        @AttributeOverride(name="description", column=@Column(name="description") ), 
        @AttributeOverride(name="transdate", column=@Column(name="transdate", length=13) ), 
        @AttributeOverride(name="employeeId", column=@Column(name="employee_id") ), 
        @AttributeOverride(name="notes", column=@Column(name="notes") ), 
        @AttributeOverride(name="departmentId", column=@Column(name="department_id") ), 
        @AttributeOverride(name="approved", column=@Column(name="approved") ), 
        @AttributeOverride(name="curr", column=@Column(name="curr", length=3) ), 
        @AttributeOverride(name="exchangerate", column=@Column(name="exchangerate", precision=17, scale=17) ), 
        @AttributeOverride(name="ticketId", column=@Column(name="ticket_id") ) } )
    public GlId getId() {
        return this.id;
    }
    
    public void setId(GlId id) {
        this.id = id;
    }




}


