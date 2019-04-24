package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Partsgroup por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="partsgroup",schema="public", uniqueConstraints = @UniqueConstraint(columnNames="partsgroup"))
public class Partsgroup  implements java.io.Serializable
 {


     private PartsgroupId id;

    public Partsgroup() {
    }

    public Partsgroup(PartsgroupId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id") ), 
        @AttributeOverride(name="partsgroup", column=@Column(name="partsgroup", unique=true) ), 
        @AttributeOverride(name="pos", column=@Column(name="pos") ) } )
    public PartsgroupId getId() {
        return this.id;
    }
    
    public void setId(PartsgroupId id) {
        this.id = id;
    }




}


