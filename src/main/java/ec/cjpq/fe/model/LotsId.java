package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * LotsId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class LotsId  implements java.io.Serializable
 {


     private String lotnum;
     private Integer partsId;
     private Integer warehouseId;
     private Date expiry;
     private Double qty;
     private Double allocated;
     private Double lastcost;

    public LotsId() {
    }

    public LotsId(String lotnum, Integer partsId, Integer warehouseId, Date expiry, Double qty, Double allocated, Double lastcost) {
       this.lotnum = lotnum;
       this.partsId = partsId;
       this.warehouseId = warehouseId;
       this.expiry = expiry;
       this.qty = qty;
       this.allocated = allocated;
       this.lastcost = lastcost;
    }
   


    @Column(name="lotnum")
    public String getLotnum() {
        return this.lotnum;
    }
    
    public void setLotnum(String lotnum) {
        this.lotnum = lotnum;
    }


    @Column(name="parts_id")
    public Integer getPartsId() {
        return this.partsId;
    }
    
    public void setPartsId(Integer partsId) {
        this.partsId = partsId;
    }


    @Column(name="warehouse_id")
    public Integer getWarehouseId() {
        return this.warehouseId;
    }
    
    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }


    @Column(name="expiry", length=13)
    public Date getExpiry() {
        return this.expiry;
    }
    
    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }


    @Column(name="qty", precision=17, scale=17)
    public Double getQty() {
        return this.qty;
    }
    
    public void setQty(Double qty) {
        this.qty = qty;
    }


    @Column(name="allocated", precision=17, scale=17)
    public Double getAllocated() {
        return this.allocated;
    }
    
    public void setAllocated(Double allocated) {
        this.allocated = allocated;
    }


    @Column(name="lastcost", precision=17, scale=17)
    public Double getLastcost() {
        return this.lastcost;
    }
    
    public void setLastcost(Double lastcost) {
        this.lastcost = lastcost;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof LotsId) ) return false;
		 LotsId castOther = ( LotsId ) other; 
         
		 return ( (this.getLotnum()==castOther.getLotnum()) || ( this.getLotnum()!=null && castOther.getLotnum()!=null && this.getLotnum().equals(castOther.getLotnum()) ) )
 && ( (this.getPartsId()==castOther.getPartsId()) || ( this.getPartsId()!=null && castOther.getPartsId()!=null && this.getPartsId().equals(castOther.getPartsId()) ) )
 && ( (this.getWarehouseId()==castOther.getWarehouseId()) || ( this.getWarehouseId()!=null && castOther.getWarehouseId()!=null && this.getWarehouseId().equals(castOther.getWarehouseId()) ) )
 && ( (this.getExpiry()==castOther.getExpiry()) || ( this.getExpiry()!=null && castOther.getExpiry()!=null && this.getExpiry().equals(castOther.getExpiry()) ) )
 && ( (this.getQty()==castOther.getQty()) || ( this.getQty()!=null && castOther.getQty()!=null && this.getQty().equals(castOther.getQty()) ) )
 && ( (this.getAllocated()==castOther.getAllocated()) || ( this.getAllocated()!=null && castOther.getAllocated()!=null && this.getAllocated().equals(castOther.getAllocated()) ) )
 && ( (this.getLastcost()==castOther.getLastcost()) || ( this.getLastcost()!=null && castOther.getLastcost()!=null && this.getLastcost().equals(castOther.getLastcost()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getLotnum() == null ? 0 : this.getLotnum().hashCode() );
         result = 37 * result + ( getPartsId() == null ? 0 : this.getPartsId().hashCode() );
         result = 37 * result + ( getWarehouseId() == null ? 0 : this.getWarehouseId().hashCode() );
         result = 37 * result + ( getExpiry() == null ? 0 : this.getExpiry().hashCode() );
         result = 37 * result + ( getQty() == null ? 0 : this.getQty().hashCode() );
         result = 37 * result + ( getAllocated() == null ? 0 : this.getAllocated().hashCode() );
         result = 37 * result + ( getLastcost() == null ? 0 : this.getLastcost().hashCode() );
         return result;
   }   


}


