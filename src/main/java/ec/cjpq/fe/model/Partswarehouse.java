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
 * Partswarehouse por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="partswarehouse",schema="public", uniqueConstraints = @UniqueConstraint(columnNames={"parts_id", "warehouse_id"}))
public class Partswarehouse  implements java.io.Serializable
 {


     private PartswarehouseId id;

    public Partswarehouse() {
    }

    public Partswarehouse(PartswarehouseId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="partsId", column=@Column(name="parts_id") ), 
        @AttributeOverride(name="warehouseId", column=@Column(name="warehouse_id") ), 
        @AttributeOverride(name="lastcost", column=@Column(name="lastcost", precision=6) ) } )
    public PartswarehouseId getId() {
        return this.id;
    }
    
    public void setId(PartswarehouseId id) {
        this.id = id;
    }




}


