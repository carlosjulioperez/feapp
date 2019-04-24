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
 * Oe por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="oe",schema="public")
public class Oe  implements java.io.Serializable
 {


     private OeId id;

    public Oe() {
    }

    public Oe(OeId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id") ), 
        @AttributeOverride(name="ordnumber", column=@Column(name="ordnumber") ), 
        @AttributeOverride(name="transdate", column=@Column(name="transdate", length=13) ), 
        @AttributeOverride(name="vendorId", column=@Column(name="vendor_id") ), 
        @AttributeOverride(name="customerId", column=@Column(name="customer_id") ), 
        @AttributeOverride(name="amount", column=@Column(name="amount", precision=17, scale=17) ), 
        @AttributeOverride(name="netamount", column=@Column(name="netamount", precision=17, scale=17) ), 
        @AttributeOverride(name="reqdate", column=@Column(name="reqdate", length=13) ), 
        @AttributeOverride(name="taxincluded", column=@Column(name="taxincluded") ), 
        @AttributeOverride(name="shippingpoint", column=@Column(name="shippingpoint") ), 
        @AttributeOverride(name="notes", column=@Column(name="notes") ), 
        @AttributeOverride(name="curr", column=@Column(name="curr", length=3) ), 
        @AttributeOverride(name="employeeId", column=@Column(name="employee_id") ), 
        @AttributeOverride(name="closed", column=@Column(name="closed") ), 
        @AttributeOverride(name="quotation", column=@Column(name="quotation") ), 
        @AttributeOverride(name="quonumber", column=@Column(name="quonumber") ), 
        @AttributeOverride(name="intnotes", column=@Column(name="intnotes") ), 
        @AttributeOverride(name="departmentId", column=@Column(name="department_id") ), 
        @AttributeOverride(name="shipvia", column=@Column(name="shipvia") ), 
        @AttributeOverride(name="languageCode", column=@Column(name="language_code", length=6) ), 
        @AttributeOverride(name="ponumber", column=@Column(name="ponumber") ), 
        @AttributeOverride(name="terms", column=@Column(name="terms") ), 
        @AttributeOverride(name="waybill", column=@Column(name="waybill") ), 
        @AttributeOverride(name="warehouseId", column=@Column(name="warehouse_id") ), 
        @AttributeOverride(name="description", column=@Column(name="description") ), 
        @AttributeOverride(name="aaId", column=@Column(name="aa_id") ), 
        @AttributeOverride(name="exchangerate", column=@Column(name="exchangerate", precision=17, scale=17) ), 
        @AttributeOverride(name="ticketId", column=@Column(name="ticket_id") ), 
        @AttributeOverride(name="internalFreight", column=@Column(name="internal_freight", precision=12) ), 
        @AttributeOverride(name="shippingFreight", column=@Column(name="shipping_freight", precision=12) ), 
        @AttributeOverride(name="shippingInsurance", column=@Column(name="shipping_insurance", precision=12) ), 
        @AttributeOverride(name="airportExpenses", column=@Column(name="airport_expenses", precision=12) ), 
        @AttributeOverride(name="localFreight", column=@Column(name="local_freight", precision=12) ), 
        @AttributeOverride(name="otherExpenses", column=@Column(name="other_expenses", precision=12) ), 
        @AttributeOverride(name="totalExpenses", column=@Column(name="total_expenses", precision=12) ), 
        @AttributeOverride(name="totalCustoms", column=@Column(name="total_customs", precision=12) ), 
        @AttributeOverride(name="netweight", column=@Column(name="netweight", precision=12) ), 
        @AttributeOverride(name="grossweight", column=@Column(name="grossweight", precision=12) ) } )
    public OeId getId() {
        return this.id;
    }
    
    public void setId(OeId id) {
        this.id = id;
    }




}


