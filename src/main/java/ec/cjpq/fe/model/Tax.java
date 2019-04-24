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
 * Tax por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="tax",schema="public")
public class Tax  implements java.io.Serializable
 {


     private TaxId id;

    public Tax() {
    }

    public Tax(TaxId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="chartId", column=@Column(name="chart_id") ), 
        @AttributeOverride(name="rate", column=@Column(name="rate", precision=17, scale=17) ), 
        @AttributeOverride(name="taxnumber", column=@Column(name="taxnumber") ), 
        @AttributeOverride(name="validto", column=@Column(name="validto", length=13) ) } )
    public TaxId getId() {
        return this.id;
    }
    
    public void setId(TaxId id) {
        this.id = id;
    }




}


