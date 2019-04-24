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
 * Invoicetax por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="invoicetax",schema="public")
public class Invoicetax  implements java.io.Serializable
 {


     private InvoicetaxId id;

    public Invoicetax() {
    }

    public Invoicetax(InvoicetaxId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="transId", column=@Column(name="trans_id") ), 
        @AttributeOverride(name="invoiceId", column=@Column(name="invoice_id") ), 
        @AttributeOverride(name="chartId", column=@Column(name="chart_id") ), 
        @AttributeOverride(name="taxamount", column=@Column(name="taxamount", precision=17, scale=17) ) } )
    public InvoicetaxId getId() {
        return this.id;
    }
    
    public void setId(InvoicetaxId id) {
        this.id = id;
    }




}


