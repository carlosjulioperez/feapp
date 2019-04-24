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
 * Inventory por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="inventory",schema="public")
public class Inventory  implements java.io.Serializable
 {


     private InventoryId id;

    public Inventory() {
    }

    public Inventory(InventoryId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id") ), 
        @AttributeOverride(name="warehouseId", column=@Column(name="warehouse_id") ), 
        @AttributeOverride(name="partsId", column=@Column(name="parts_id") ), 
        @AttributeOverride(name="transId", column=@Column(name="trans_id") ), 
        @AttributeOverride(name="orderitemsId", column=@Column(name="orderitems_id") ), 
        @AttributeOverride(name="qty", column=@Column(name="qty", precision=17, scale=17) ), 
        @AttributeOverride(name="shippingdate", column=@Column(name="shippingdate", length=13) ), 
        @AttributeOverride(name="employeeId", column=@Column(name="employee_id") ), 
        @AttributeOverride(name="departmentId", column=@Column(name="department_id") ), 
        @AttributeOverride(name="warehouseId2", column=@Column(name="warehouse_id2") ), 
        @AttributeOverride(name="serialnumber", column=@Column(name="serialnumber") ), 
        @AttributeOverride(name="itemnotes", column=@Column(name="itemnotes") ), 
        @AttributeOverride(name="cost", column=@Column(name="cost", precision=17, scale=17) ), 
        @AttributeOverride(name="linetype", column=@Column(name="linetype", length=1) ), 
        @AttributeOverride(name="description", column=@Column(name="description") ), 
        @AttributeOverride(name="invoiceId", column=@Column(name="invoice_id") ), 
        @AttributeOverride(name="cogs", column=@Column(name="cogs", precision=17, scale=17) ), 
        @AttributeOverride(name="lotnum", column=@Column(name="lotnum") ), 
        @AttributeOverride(name="expiry", column=@Column(name="expiry", length=13) ), 
        @AttributeOverride(name="reporttype", column=@Column(name="reporttype", length=3) ) } )
    public InventoryId getId() {
        return this.id;
    }
    
    public void setId(InventoryId id) {
        this.id = id;
    }




}


