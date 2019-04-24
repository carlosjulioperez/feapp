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
 * Ar por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="ar",schema="public")
public class Ar  implements java.io.Serializable
 {


     private ArId id;

    public Ar() {
    }

    public Ar(ArId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id") ), 
        @AttributeOverride(name="invnumber", column=@Column(name="invnumber") ), 
        @AttributeOverride(name="transdate", column=@Column(name="transdate", length=13) ), 
        @AttributeOverride(name="customerId", column=@Column(name="customer_id") ), 
        @AttributeOverride(name="taxincluded", column=@Column(name="taxincluded") ), 
        @AttributeOverride(name="amount", column=@Column(name="amount", precision=17, scale=17) ), 
        @AttributeOverride(name="netamount", column=@Column(name="netamount", precision=17, scale=17) ), 
        @AttributeOverride(name="paid", column=@Column(name="paid", precision=17, scale=17) ), 
        @AttributeOverride(name="datepaid", column=@Column(name="datepaid", length=13) ), 
        @AttributeOverride(name="duedate", column=@Column(name="duedate", length=13) ), 
        @AttributeOverride(name="invoice", column=@Column(name="invoice") ), 
        @AttributeOverride(name="shippingpoint", column=@Column(name="shippingpoint") ), 
        @AttributeOverride(name="terms", column=@Column(name="terms") ), 
        @AttributeOverride(name="notes", column=@Column(name="notes") ), 
        @AttributeOverride(name="curr", column=@Column(name="curr", length=3) ), 
        @AttributeOverride(name="ordnumber", column=@Column(name="ordnumber") ), 
        @AttributeOverride(name="employeeId", column=@Column(name="employee_id") ), 
        @AttributeOverride(name="till", column=@Column(name="till", length=20) ), 
        @AttributeOverride(name="quonumber", column=@Column(name="quonumber") ), 
        @AttributeOverride(name="intnotes", column=@Column(name="intnotes") ), 
        @AttributeOverride(name="departmentId", column=@Column(name="department_id") ), 
        @AttributeOverride(name="shipvia", column=@Column(name="shipvia") ), 
        @AttributeOverride(name="languageCode", column=@Column(name="language_code", length=6) ), 
        @AttributeOverride(name="ponumber", column=@Column(name="ponumber") ), 
        @AttributeOverride(name="approved", column=@Column(name="approved") ), 
        @AttributeOverride(name="cashdiscount", column=@Column(name="cashdiscount", precision=8, scale=8) ), 
        @AttributeOverride(name="discountterms", column=@Column(name="discountterms") ), 
        @AttributeOverride(name="waybill", column=@Column(name="waybill") ), 
        @AttributeOverride(name="warehouseId", column=@Column(name="warehouse_id") ), 
        @AttributeOverride(name="description", column=@Column(name="description") ), 
        @AttributeOverride(name="onhold", column=@Column(name="onhold") ), 
        @AttributeOverride(name="exchangerate", column=@Column(name="exchangerate", precision=17, scale=17) ), 
        @AttributeOverride(name="dcn", column=@Column(name="dcn") ), 
        @AttributeOverride(name="bankId", column=@Column(name="bank_id") ), 
        @AttributeOverride(name="paymentmethodId", column=@Column(name="paymentmethod_id") ), 
        @AttributeOverride(name="tipodocId", column=@Column(name="tipodoc_id") ), 
        @AttributeOverride(name="ticketId", column=@Column(name="ticket_id") ) } )
    public ArId getId() {
        return this.id;
    }
    
    public void setId(ArId id) {
        this.id = id;
    }




}


