package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CustomertaxId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class CustomertaxId  implements java.io.Serializable
 {


     private Integer customerId;
     private Integer chartId;

    public CustomertaxId() {
    }

    public CustomertaxId(Integer customerId, Integer chartId) {
       this.customerId = customerId;
       this.chartId = chartId;
    }
   


    @Column(name="customer_id")
    public Integer getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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
		 if ( !(other instanceof CustomertaxId) ) return false;
		 CustomertaxId castOther = ( CustomertaxId ) other; 
         
		 return ( (this.getCustomerId()==castOther.getCustomerId()) || ( this.getCustomerId()!=null && castOther.getCustomerId()!=null && this.getCustomerId().equals(castOther.getCustomerId()) ) )
 && ( (this.getChartId()==castOther.getChartId()) || ( this.getChartId()!=null && castOther.getChartId()!=null && this.getChartId().equals(castOther.getChartId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCustomerId() == null ? 0 : this.getCustomerId().hashCode() );
         result = 37 * result + ( getChartId() == null ? 0 : this.getChartId().hashCode() );
         return result;
   }   


}


