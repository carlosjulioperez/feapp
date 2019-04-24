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
 * Gifi por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="gifi",schema="public", uniqueConstraints = @UniqueConstraint(columnNames="accno"))
public class Gifi  implements java.io.Serializable
 {


     private GifiId id;

    public Gifi() {
    }

    public Gifi(GifiId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="accno", column=@Column(name="accno", unique=true) ), 
        @AttributeOverride(name="description", column=@Column(name="description") ) } )
    public GifiId getId() {
        return this.id;
    }
    
    public void setId(GifiId id) {
        this.id = id;
    }




}


