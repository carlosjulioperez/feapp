package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PartsvendorId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class PartsvendorId  implements java.io.Serializable
 {


     private Integer vendorId;
     private Integer partsId;
     private String partnumber;
     private Short leadtime;
     private Double lastcost;
     private String curr;

    public PartsvendorId() {
    }

    public PartsvendorId(Integer vendorId, Integer partsId, String partnumber, Short leadtime, Double lastcost, String curr) {
       this.vendorId = vendorId;
       this.partsId = partsId;
       this.partnumber = partnumber;
       this.leadtime = leadtime;
       this.lastcost = lastcost;
       this.curr = curr;
    }
   


    @Column(name="vendor_id")
    public Integer getVendorId() {
        return this.vendorId;
    }
    
    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }


    @Column(name="parts_id")
    public Integer getPartsId() {
        return this.partsId;
    }
    
    public void setPartsId(Integer partsId) {
        this.partsId = partsId;
    }


    @Column(name="partnumber")
    public String getPartnumber() {
        return this.partnumber;
    }
    
    public void setPartnumber(String partnumber) {
        this.partnumber = partnumber;
    }


    @Column(name="leadtime")
    public Short getLeadtime() {
        return this.leadtime;
    }
    
    public void setLeadtime(Short leadtime) {
        this.leadtime = leadtime;
    }


    @Column(name="lastcost", precision=17, scale=17)
    public Double getLastcost() {
        return this.lastcost;
    }
    
    public void setLastcost(Double lastcost) {
        this.lastcost = lastcost;
    }


    @Column(name="curr", length=3)
    public String getCurr() {
        return this.curr;
    }
    
    public void setCurr(String curr) {
        this.curr = curr;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PartsvendorId) ) return false;
		 PartsvendorId castOther = ( PartsvendorId ) other; 
         
		 return ( (this.getVendorId()==castOther.getVendorId()) || ( this.getVendorId()!=null && castOther.getVendorId()!=null && this.getVendorId().equals(castOther.getVendorId()) ) )
 && ( (this.getPartsId()==castOther.getPartsId()) || ( this.getPartsId()!=null && castOther.getPartsId()!=null && this.getPartsId().equals(castOther.getPartsId()) ) )
 && ( (this.getPartnumber()==castOther.getPartnumber()) || ( this.getPartnumber()!=null && castOther.getPartnumber()!=null && this.getPartnumber().equals(castOther.getPartnumber()) ) )
 && ( (this.getLeadtime()==castOther.getLeadtime()) || ( this.getLeadtime()!=null && castOther.getLeadtime()!=null && this.getLeadtime().equals(castOther.getLeadtime()) ) )
 && ( (this.getLastcost()==castOther.getLastcost()) || ( this.getLastcost()!=null && castOther.getLastcost()!=null && this.getLastcost().equals(castOther.getLastcost()) ) )
 && ( (this.getCurr()==castOther.getCurr()) || ( this.getCurr()!=null && castOther.getCurr()!=null && this.getCurr().equals(castOther.getCurr()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getVendorId() == null ? 0 : this.getVendorId().hashCode() );
         result = 37 * result + ( getPartsId() == null ? 0 : this.getPartsId().hashCode() );
         result = 37 * result + ( getPartnumber() == null ? 0 : this.getPartnumber().hashCode() );
         result = 37 * result + ( getLeadtime() == null ? 0 : this.getLeadtime().hashCode() );
         result = 37 * result + ( getLastcost() == null ? 0 : this.getLastcost().hashCode() );
         result = 37 * result + ( getCurr() == null ? 0 : this.getCurr().hashCode() );
         return result;
   }   


}


