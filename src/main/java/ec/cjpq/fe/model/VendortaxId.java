package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VendortaxId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class VendortaxId  implements java.io.Serializable
 {


     private Integer vendorId;
     private Integer chartId;

    public VendortaxId() {
    }

    public VendortaxId(Integer vendorId, Integer chartId) {
       this.vendorId = vendorId;
       this.chartId = chartId;
    }
   


    @Column(name="vendor_id")
    public Integer getVendorId() {
        return this.vendorId;
    }
    
    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }


    @Column(name="chart_id")
    public Integer getChartId() {
        return this.chartId;
    }
    
    public void setChartId(Integer chartId) {
        this.chartId = chartId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VendortaxId) ) return false;
		 VendortaxId castOther = ( VendortaxId ) other; 
         
		 return ( (this.getVendorId()==castOther.getVendorId()) || ( this.getVendorId()!=null && castOther.getVendorId()!=null && this.getVendorId().equals(castOther.getVendorId()) ) )
 && ( (this.getChartId()==castOther.getChartId()) || ( this.getChartId()!=null && castOther.getChartId()!=null && this.getChartId().equals(castOther.getChartId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getVendorId() == null ? 0 : this.getVendorId().hashCode() );
         result = 37 * result + ( getChartId() == null ? 0 : this.getChartId().hashCode() );
         return result;
   }   


}


