package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ExchangerateId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class ExchangerateId  implements java.io.Serializable
 {


     private String curr;
     private Date transdate;
     private Double buy;
     private Double sell;

    public ExchangerateId() {
    }

    public ExchangerateId(String curr, Date transdate, Double buy, Double sell) {
       this.curr = curr;
       this.transdate = transdate;
       this.buy = buy;
       this.sell = sell;
    }
   


    @Column(name="curr", length=3)
    public String getCurr() {
        return this.curr;
    }
    
    public void setCurr(String curr) {
        this.curr = curr;
    }


    @Column(name="transdate", length=13)
    public Date getTransdate() {
        return this.transdate;
    }
    
    public void setTransdate(Date transdate) {
        this.transdate = transdate;
    }


    @Column(name="buy", precision=17, scale=17)
    public Double getBuy() {
        return this.buy;
    }
    
    public void setBuy(Double buy) {
        this.buy = buy;
    }


    @Column(name="sell", precision=17, scale=17)
    public Double getSell() {
        return this.sell;
    }
    
    public void setSell(Double sell) {
        this.sell = sell;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ExchangerateId) ) return false;
		 ExchangerateId castOther = ( ExchangerateId ) other; 
         
		 return ( (this.getCurr()==castOther.getCurr()) || ( this.getCurr()!=null && castOther.getCurr()!=null && this.getCurr().equals(castOther.getCurr()) ) )
 && ( (this.getTransdate()==castOther.getTransdate()) || ( this.getTransdate()!=null && castOther.getTransdate()!=null && this.getTransdate().equals(castOther.getTransdate()) ) )
 && ( (this.getBuy()==castOther.getBuy()) || ( this.getBuy()!=null && castOther.getBuy()!=null && this.getBuy().equals(castOther.getBuy()) ) )
 && ( (this.getSell()==castOther.getSell()) || ( this.getSell()!=null && castOther.getSell()!=null && this.getSell().equals(castOther.getSell()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCurr() == null ? 0 : this.getCurr().hashCode() );
         result = 37 * result + ( getTransdate() == null ? 0 : this.getTransdate().hashCode() );
         result = 37 * result + ( getBuy() == null ? 0 : this.getBuy().hashCode() );
         result = 37 * result + ( getSell() == null ? 0 : this.getSell().hashCode() );
         return result;
   }   


}


