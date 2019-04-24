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
 * Pricegroup por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="pricegroup",schema="public")
public class Pricegroup  implements java.io.Serializable
 {


     private PricegroupId id;

    public Pricegroup() {
    }

    public Pricegroup(PricegroupId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id") ), 
        @AttributeOverride(name="pricegroup", column=@Column(name="pricegroup") ) } )
    public PricegroupId getId() {
        return this.id;
    }
    
    public void setId(PricegroupId id) {
        this.id = id;
    }




}


