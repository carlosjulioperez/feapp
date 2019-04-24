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
 * Lots por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="lots",schema="public", uniqueConstraints = @UniqueConstraint(columnNames={"lotnum", "parts_id", "warehouse_id"}))
public class Lots  implements java.io.Serializable
 {


     private LotsId id;

    public Lots() {
    }

    public Lots(LotsId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="lotnum", column=@Column(name="lotnum") ), 
        @AttributeOverride(name="partsId", column=@Column(name="parts_id") ), 
        @AttributeOverride(name="warehouseId", column=@Column(name="warehouse_id") ), 
        @AttributeOverride(name="expiry", column=@Column(name="expiry", length=13) ), 
        @AttributeOverride(name="qty", column=@Column(name="qty", precision=17, scale=17) ), 
        @AttributeOverride(name="allocated", column=@Column(name="allocated", precision=17, scale=17) ), 
        @AttributeOverride(name="lastcost", column=@Column(name="lastcost", precision=17, scale=17) ) } )
    public LotsId getId() {
        return this.id;
    }
    
    public void setId(LotsId id) {
        this.id = id;
    }




}


