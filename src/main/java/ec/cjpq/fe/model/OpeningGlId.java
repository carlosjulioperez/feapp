package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OpeningGlId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class OpeningGlId  implements java.io.Serializable
 {


     private Integer departmentId;
     private Integer chartId;
     private Double amount;

    public OpeningGlId() {
    }

    public OpeningGlId(Integer departmentId, Integer chartId, Double amount) {
       this.departmentId = departmentId;
       this.chartId = chartId;
       this.amount = amount;
    }
   


    @Column(name="department_id")
    public Integer getDepartmentId() {
        return this.departmentId;
    }
    
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }


    @Column(name="chart_id")
    public Integer getChartId() {
        return this.chartId;
    }
    
    public void setChartId(Integer chartId) {
        this.chartId = chartId;
    }


    @Column(name="amount", precision=17, scale=17)
    public Double getAmount() {
        return this.amount;
    }
    
    public void setAmount(Double amount) {
        this.amount = amount;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof OpeningGlId) ) return false;
		 OpeningGlId castOther = ( OpeningGlId ) other; 
         
		 return ( (this.getDepartmentId()==castOther.getDepartmentId()) || ( this.getDepartmentId()!=null && castOther.getDepartmentId()!=null && this.getDepartmentId().equals(castOther.getDepartmentId()) ) )
 && ( (this.getChartId()==castOther.getChartId()) || ( this.getChartId()!=null && castOther.getChartId()!=null && this.getChartId().equals(castOther.getChartId()) ) )
 && ( (this.getAmount()==castOther.getAmount()) || ( this.getAmount()!=null && castOther.getAmount()!=null && this.getAmount().equals(castOther.getAmount()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getDepartmentId() == null ? 0 : this.getDepartmentId().hashCode() );
         result = 37 * result + ( getChartId() == null ? 0 : this.getChartId().hashCode() );
         result = 37 * result + ( getAmount() == null ? 0 : this.getAmount().hashCode() );
         return result;
   }   


}


