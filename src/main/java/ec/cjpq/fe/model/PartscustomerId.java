package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PartscustomerId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class PartscustomerId  implements java.io.Serializable
 {


     private Integer partsId;
     private Integer customerId;
     private Integer pricegroupId;
     private Double pricebreak;
     private Double sellprice;
     private Date validfrom;
     private Date validto;
     private String curr;
     private BigDecimal discount;

    public PartscustomerId() {
    }

    public PartscustomerId(Integer partsId, Integer customerId, Integer pricegroupId, Double pricebreak, Double sellprice, Date validfrom, Date validto, String curr, BigDecimal discount) {
       this.partsId = partsId;
       this.customerId = customerId;
       this.pricegroupId = pricegroupId;
       this.pricebreak = pricebreak;
       this.sellprice = sellprice;
       this.validfrom = validfrom;
       this.validto = validto;
       this.curr = curr;
       this.discount = discount;
    }
   


    @Column(name="parts_id")
    public Integer getPartsId() {
        return this.partsId;
    }
    
    public void setPartsId(Integer partsId) {
        this.partsId = partsId;
    }


    @Column(name="customer_id")
    public Integer getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }


    @Column(name="pricegroup_id")
    public Integer getPricegroupId() {
        return this.pricegroupId;
    }
    
    public void setPricegroupId(Integer pricegroupId) {
        this.pricegroupId = pricegroupId;
    }


    @Column(name="pricebreak", precision=17, scale=17)
    public Double getPricebreak() {
        return this.pricebreak;
    }
    
    public void setPricebreak(Double pricebreak) {
        this.pricebreak = pricebreak;
    }


    @Column(name="sellprice", precision=17, scale=17)
    public Double getSellprice() {
        return this.sellprice;
    }
    
    public void setSellprice(Double sellprice) {
        this.sellprice = sellprice;
    }


    @Column(name="validfrom", length=13)
    public Date getValidfrom() {
        return this.validfrom;
    }
    
    public void setValidfrom(Date validfrom) {
        this.validfrom = validfrom;
    }


    @Column(name="validto", length=13)
    public Date getValidto() {
        return this.validto;
    }
    
    public void setValidto(Date validto) {
        this.validto = validto;
    }


    @Column(name="curr", length=3)
    public String getCurr() {
        return this.curr;
    }
    
    public void setCurr(String curr) {
        this.curr = curr;
    }


    @Column(name="discount", precision=10)
    public BigDecimal getDiscount() {
        return this.discount;
    }
    
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PartscustomerId) ) return false;
		 PartscustomerId castOther = ( PartscustomerId ) other; 
         
		 return ( (this.getPartsId()==castOther.getPartsId()) || ( this.getPartsId()!=null && castOther.getPartsId()!=null && this.getPartsId().equals(castOther.getPartsId()) ) )
 && ( (this.getCustomerId()==castOther.getCustomerId()) || ( this.getCustomerId()!=null && castOther.getCustomerId()!=null && this.getCustomerId().equals(castOther.getCustomerId()) ) )
 && ( (this.getPricegroupId()==castOther.getPricegroupId()) || ( this.getPricegroupId()!=null && castOther.getPricegroupId()!=null && this.getPricegroupId().equals(castOther.getPricegroupId()) ) )
 && ( (this.getPricebreak()==castOther.getPricebreak()) || ( this.getPricebreak()!=null && castOther.getPricebreak()!=null && this.getPricebreak().equals(castOther.getPricebreak()) ) )
 && ( (this.getSellprice()==castOther.getSellprice()) || ( this.getSellprice()!=null && castOther.getSellprice()!=null && this.getSellprice().equals(castOther.getSellprice()) ) )
 && ( (this.getValidfrom()==castOther.getValidfrom()) || ( this.getValidfrom()!=null && castOther.getValidfrom()!=null && this.getValidfrom().equals(castOther.getValidfrom()) ) )
 && ( (this.getValidto()==castOther.getValidto()) || ( this.getValidto()!=null && castOther.getValidto()!=null && this.getValidto().equals(castOther.getValidto()) ) )
 && ( (this.getCurr()==castOther.getCurr()) || ( this.getCurr()!=null && castOther.getCurr()!=null && this.getCurr().equals(castOther.getCurr()) ) )
 && ( (this.getDiscount()==castOther.getDiscount()) || ( this.getDiscount()!=null && castOther.getDiscount()!=null && this.getDiscount().equals(castOther.getDiscount()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getPartsId() == null ? 0 : this.getPartsId().hashCode() );
         result = 37 * result + ( getCustomerId() == null ? 0 : this.getCustomerId().hashCode() );
         result = 37 * result + ( getPricegroupId() == null ? 0 : this.getPricegroupId().hashCode() );
         result = 37 * result + ( getPricebreak() == null ? 0 : this.getPricebreak().hashCode() );
         result = 37 * result + ( getSellprice() == null ? 0 : this.getSellprice().hashCode() );
         result = 37 * result + ( getValidfrom() == null ? 0 : this.getValidfrom().hashCode() );
         result = 37 * result + ( getValidto() == null ? 0 : this.getValidto().hashCode() );
         result = 37 * result + ( getCurr() == null ? 0 : this.getCurr().hashCode() );
         result = 37 * result + ( getDiscount() == null ? 0 : this.getDiscount().hashCode() );
         return result;
   }   


}


