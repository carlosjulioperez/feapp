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
 * Defaults por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="defaults",schema="public")
public class Defaults  implements java.io.Serializable
 {


     private DefaultsId id;

    public Defaults() {
    }

    public Defaults(DefaultsId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="fldname", column=@Column(name="fldname") ), 
        @AttributeOverride(name="fldvalue", column=@Column(name="fldvalue") ) } )
    public DefaultsId getId() {
        return this.id;
    }
    
    public void setId(DefaultsId id) {
        this.id = id;
    }




}


