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
 * Lineitem por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="lineitem",schema="public")
public class Lineitem  implements java.io.Serializable
 {


     private LineitemId id;

    public Lineitem() {
    }

    public Lineitem(LineitemId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id", nullable=false) ), 
        @AttributeOverride(name="linumber", column=@Column(name="linumber", length=4) ), 
        @AttributeOverride(name="description", column=@Column(name="description", length=35) ) } )
    public LineitemId getId() {
        return this.id;
    }
    
    public void setId(LineitemId id) {
        this.id = id;
    }




}


