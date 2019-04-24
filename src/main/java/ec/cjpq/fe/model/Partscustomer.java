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
 * Partscustomer por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="partscustomer",schema="public")
public class Partscustomer  implements java.io.Serializable
 {


     private PartscustomerId id;

    public Partscustomer() {
    }

    public Partscustomer(PartscustomerId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="partsId", column=@Column(name="parts_id") ), 
        @AttributeOverride(name="customerId", column=@Column(name="customer_id") ), 
        @AttributeOverride(name="pricegroupId", column=@Column(name="pricegroup_id") ), 
        @AttributeOverride(name="pricebreak", column=@Column(name="pricebreak", precision=17, scale=17) ), 
        @AttributeOverride(name="sellprice", column=@Column(name="sellprice", precision=17, scale=17) ), 
        @AttributeOverride(name="validfrom", column=@Column(name="validfrom", length=13) ), 
        @AttributeOverride(name="validto", column=@Column(name="validto", length=13) ), 
        @AttributeOverride(name="curr", column=@Column(name="curr", length=3) ), 
        @AttributeOverride(name="discount", column=@Column(name="discount", precision=10) ) } )
    public PartscustomerId getId() {
        return this.id;
    }
    
    public void setId(PartscustomerId id) {
        this.id = id;
    }




}


