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
 * Status por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="status",schema="public")
public class Status  implements java.io.Serializable
 {


     private StatusId id;

    public Status() {
    }

    public Status(StatusId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="transId", column=@Column(name="trans_id") ), 
        @AttributeOverride(name="formname", column=@Column(name="formname") ), 
        @AttributeOverride(name="printed", column=@Column(name="printed") ), 
        @AttributeOverride(name="emailed", column=@Column(name="emailed") ), 
        @AttributeOverride(name="spoolfile", column=@Column(name="spoolfile") ) } )
    public StatusId getId() {
        return this.id;
    }
    
    public void setId(StatusId id) {
        this.id = id;
    }




}


