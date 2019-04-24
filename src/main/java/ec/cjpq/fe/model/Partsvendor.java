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
 * Partsvendor por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="partsvendor",schema="public")
public class Partsvendor  implements java.io.Serializable
 {


     private PartsvendorId id;

    public Partsvendor() {
    }

    public Partsvendor(PartsvendorId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="vendorId", column=@Column(name="vendor_id") ), 
        @AttributeOverride(name="partsId", column=@Column(name="parts_id") ), 
        @AttributeOverride(name="partnumber", column=@Column(name="partnumber") ), 
        @AttributeOverride(name="leadtime", column=@Column(name="leadtime") ), 
        @AttributeOverride(name="lastcost", column=@Column(name="lastcost", precision=17, scale=17) ), 
        @AttributeOverride(name="curr", column=@Column(name="curr", length=3) ) } )
    public PartsvendorId getId() {
        return this.id;
    }
    
    public void setId(PartsvendorId id) {
        this.id = id;
    }




}


