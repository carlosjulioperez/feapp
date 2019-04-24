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
 * Sic por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="sic",schema="public")
public class Sic  implements java.io.Serializable
 {


     private SicId id;

    public Sic() {
    }

    public Sic(SicId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="code", column=@Column(name="code", length=6) ), 
        @AttributeOverride(name="sictype", column=@Column(name="sictype", length=1) ), 
        @AttributeOverride(name="description", column=@Column(name="description") ) } )
    public SicId getId() {
        return this.id;
    }
    
    public void setId(SicId id) {
        this.id = id;
    }




}


