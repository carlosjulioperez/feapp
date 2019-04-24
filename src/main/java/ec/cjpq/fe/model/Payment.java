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
 * Payment por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="payment",schema="public")
public class Payment  implements java.io.Serializable
 {


     private PaymentId id;

    public Payment() {
    }

    public Payment(PaymentId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id", nullable=false) ), 
        @AttributeOverride(name="transId", column=@Column(name="trans_id", nullable=false) ), 
        @AttributeOverride(name="exchangerate", column=@Column(name="exchangerate", precision=17, scale=17) ), 
        @AttributeOverride(name="paymentmethodId", column=@Column(name="paymentmethod_id") ) } )
    public PaymentId getId() {
        return this.id;
    }
    
    public void setId(PaymentId id) {
        this.id = id;
    }




}


