package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PartswarehouseId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class PartswarehouseId  implements java.io.Serializable
 {


     private Integer partsId;
     private Integer warehouseId;
     private BigDecimal lastcost;

    public PartswarehouseId() {
    }

    public PartswarehouseId(Integer partsId, Integer warehouseId, BigDecimal lastcost) {
       this.partsId = partsId;
       this.warehouseId = warehouseId;
       this.lastcost = lastcost;
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


    @Column(name="lastcost", precision=6)
    public BigDecimal getLastcost() {
        return this.lastcost;
    }
    
    public void setLastcost(BigDecimal lastcost) {
        this.lastcost = lastcost;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PartswarehouseId) ) return false;
		 PartswarehouseId castOther = ( PartswarehouseId ) other; 
         
		 return ( (this.getPartsId()==castOther.getPartsId()) || ( this.getPartsId()!=null && castOther.getPartsId()!=null && this.getPartsId().equals(castOther.getPartsId()) ) )
 && ( (this.getWarehouseId()==castOther.getWarehouseId()) || ( this.getWarehouseId()!=null && castOther.getWarehouseId()!=null && this.getWarehouseId().equals(castOther.getWarehouseId()) ) )
 && ( (this.getLastcost()==castOther.getLastcost()) || ( this.getLastcost()!=null && castOther.getLastcost()!=null && this.getLastcost().equals(castOther.getLastcost()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getPartsId() == null ? 0 : this.getPartsId().hashCode() );
         result = 37 * result + ( getWarehouseId() == null ? 0 : this.getWarehouseId().hashCode() );
         result = 37 * result + ( getLastcost() == null ? 0 : this.getLastcost().hashCode() );
         return result;
   }   


}


