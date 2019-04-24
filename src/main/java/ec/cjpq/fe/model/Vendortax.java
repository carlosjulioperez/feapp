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
 * Vendortax por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="vendortax",schema="public")
public class Vendortax  implements java.io.Serializable
 {


     private VendortaxId id;

    public Vendortax() {
    }

    public Vendortax(VendortaxId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="vendorId", column=@Column(name="vendor_id") ), 
        @AttributeOverride(name="chartId", column=@Column(name="chart_id") ) } )
    public VendortaxId getId() {
        return this.id;
    }
    
    public void setId(VendortaxId id) {
        this.id = id;
    }




}


