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
 * Cargo por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="cargo",schema="public")
public class Cargo  implements java.io.Serializable
 {


     private CargoId id;

    public Cargo() {
    }

    public Cargo(CargoId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id", nullable=false) ), 
        @AttributeOverride(name="transId", column=@Column(name="trans_id", nullable=false) ), 
        @AttributeOverride(name="package_", column=@Column(name="package") ), 
        @AttributeOverride(name="netweight", column=@Column(name="netweight", precision=17, scale=17) ), 
        @AttributeOverride(name="grossweight", column=@Column(name="grossweight", precision=17, scale=17) ), 
        @AttributeOverride(name="volume", column=@Column(name="volume", precision=17, scale=17) ) } )
    public CargoId getId() {
        return this.id;
    }
    
    public void setId(CargoId id) {
        this.id = id;
    }




}


