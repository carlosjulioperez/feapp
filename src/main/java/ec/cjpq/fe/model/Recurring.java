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
 * Recurring por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="recurring",schema="public")
public class Recurring  implements java.io.Serializable
 {


     private RecurringId id;

    public Recurring() {
    }

    public Recurring(RecurringId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id") ), 
        @AttributeOverride(name="reference", column=@Column(name="reference") ), 
        @AttributeOverride(name="startdate", column=@Column(name="startdate", length=13) ), 
        @AttributeOverride(name="nextdate", column=@Column(name="nextdate", length=13) ), 
        @AttributeOverride(name="enddate", column=@Column(name="enddate", length=13) ), 
        @AttributeOverride(name="repeat", column=@Column(name="repeat") ), 
        @AttributeOverride(name="unit", column=@Column(name="unit", length=6) ), 
        @AttributeOverride(name="howmany", column=@Column(name="howmany") ), 
        @AttributeOverride(name="payment", column=@Column(name="payment") ), 
        @AttributeOverride(name="description", column=@Column(name="description") ) } )
    public RecurringId getId() {
        return this.id;
    }
    
    public void setId(RecurringId id) {
        this.id = id;
    }




}


