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
 * Invoice por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="invoice",schema="public")
public class Invoice  implements java.io.Serializable
 {


     private InvoiceId id;

    public Invoice() {
    }

    public Invoice(InvoiceId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id") ), 
        @AttributeOverride(name="transId", column=@Column(name="trans_id") ), 
        @AttributeOverride(name="partsId", column=@Column(name="parts_id") ), 
        @AttributeOverride(name="description", column=@Column(name="description") ), 
        @AttributeOverride(name="qty", column=@Column(name="qty", precision=17, scale=17) ), 
        @AttributeOverride(name="allocated", column=@Column(name="allocated", precision=17, scale=17) ), 
        @AttributeOverride(name="sellprice", column=@Column(name="sellprice", precision=17, scale=17) ), 
        @AttributeOverride(name="fxsellprice", column=@Column(name="fxsellprice", precision=17, scale=17) ), 
        @AttributeOverride(name="discount", column=@Column(name="discount", precision=8, scale=8) ), 
        @AttributeOverride(name="assemblyitem", column=@Column(name="assemblyitem") ), 
        @AttributeOverride(name="unit", column=@Column(name="unit", length=5) ), 
        @AttributeOverride(name="projectId", column=@Column(name="project_id") ), 
        @AttributeOverride(name="deliverydate", column=@Column(name="deliverydate", length=13) ), 
        @AttributeOverride(name="serialnumber", column=@Column(name="serialnumber") ), 
        @AttributeOverride(name="itemnotes", column=@Column(name="itemnotes") ), 
        @AttributeOverride(name="lineitemdetail", column=@Column(name="lineitemdetail") ), 
        @AttributeOverride(name="transdate", column=@Column(name="transdate", length=13) ), 
        @AttributeOverride(name="lastcost", column=@Column(name="lastcost", precision=17, scale=17) ), 
        @AttributeOverride(name="warehouseId", column=@Column(name="warehouse_id") ), 
        @AttributeOverride(name="ordernumber", column=@Column(name="ordernumber") ), 
        @AttributeOverride(name="ponumber", column=@Column(name="ponumber") ), 
        @AttributeOverride(name="linetype", column=@Column(name="linetype", length=1) ), 
        @AttributeOverride(name="lotnum", column=@Column(name="lotnum") ), 
        @AttributeOverride(name="expiry", column=@Column(name="expiry", length=13) ), 
        @AttributeOverride(name="cogs", column=@Column(name="cogs", precision=17, scale=17) ) } )
    public InvoiceId getId() {
        return this.id;
    }
    
    public void setId(InvoiceId id) {
        this.id = id;
    }




}


