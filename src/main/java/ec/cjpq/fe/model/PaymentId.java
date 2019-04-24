package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PaymentId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class PaymentId  implements java.io.Serializable
 {


     private int id;
     private int transId;
     private Double exchangerate;
     private Integer paymentmethodId;

    public PaymentId() {
    }

	
    public PaymentId(int id, int transId) {
        this.id = id;
        this.transId = transId;
    }
    public PaymentId(int id, int transId, Double exchangerate, Integer paymentmethodId) {
       this.id = id;
       this.transId = transId;
       this.exchangerate = exchangerate;
       this.paymentmethodId = paymentmethodId;
    }
   


    @Column(name="id", nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }


    @Column(name="trans_id", nullable=false)
    public int getTransId() {
        return this.transId;
    }
    
    public void setTransId(int transId) {
        this.transId = transId;
    }


    @Column(name="exchangerate", precision=17, scale=17)
    public Double getExchangerate() {
        return this.exchangerate;
    }
    
    public void setExchangerate(Double exchangerate) {
        this.exchangerate = exchangerate;
    }


    @Column(name="paymentmethod_id")
    public Integer getPaymentmethodId() {
        return this.paymentmethodId;
    }
    
    public void setPaymentmethodId(Integer paymentmethodId) {
        this.paymentmethodId = paymentmethodId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PaymentId) ) return false;
		 PaymentId castOther = ( PaymentId ) other; 
         
		 return (this.getId()==castOther.getId())
 && (this.getTransId()==castOther.getTransId())
 && ( (this.getExchangerate()==castOther.getExchangerate()) || ( this.getExchangerate()!=null && castOther.getExchangerate()!=null && this.getExchangerate().equals(castOther.getExchangerate()) ) )
 && ( (this.getPaymentmethodId()==castOther.getPaymentmethodId()) || ( this.getPaymentmethodId()!=null && castOther.getPaymentmethodId()!=null && this.getPaymentmethodId().equals(castOther.getPaymentmethodId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getId();
         result = 37 * result + this.getTransId();
         result = 37 * result + ( getExchangerate() == null ? 0 : this.getExchangerate().hashCode() );
         result = 37 * result + ( getPaymentmethodId() == null ? 0 : this.getPaymentmethodId().hashCode() );
         return result;
   }   


}


