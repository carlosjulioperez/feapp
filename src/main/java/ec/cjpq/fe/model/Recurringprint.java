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
 * Recurringprint por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="recurringprint",schema="public")
public class Recurringprint  implements java.io.Serializable
 {


     private RecurringprintId id;

    public Recurringprint() {
    }

    public Recurringprint(RecurringprintId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id") ), 
        @AttributeOverride(name="formname", column=@Column(name="formname") ), 
        @AttributeOverride(name="format", column=@Column(name="format") ), 
        @AttributeOverride(name="printer", column=@Column(name="printer") ) } )
    public RecurringprintId getId() {
        return this.id;
    }
    
    public void setId(RecurringprintId id) {
        this.id = id;
    }




}


