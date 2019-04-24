package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TaxId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class TaxId  implements java.io.Serializable
 {


     private Integer chartId;
     private Double rate;
     private String taxnumber;
     private Date validto;

    public TaxId() {
    }

    public TaxId(Integer chartId, Double rate, String taxnumber, Date validto) {
       this.chartId = chartId;
       this.rate = rate;
       this.taxnumber = taxnumber;
       this.validto = validto;
    }
   


    @Column(name="chart_id")
    public Integer getChartId() {
        return this.chartId;
    }
    
    public void setChartId(Integer chartId) {
        this.chartId = chartId;
    }


    @Column(name="rate", precision=17, scale=17)
    public Double getRate() {
        return this.rate;
    }
    
    public void setRate(Double rate) {
        this.rate = rate;
    }


    @Column(name="taxnumber")
    public String getTaxnumber() {
        return this.taxnumber;
    }
    
    public void setTaxnumber(String taxnumber) {
        this.taxnumber = taxnumber;
    }


    @Column(name="validto", length=13)
    public Date getValidto() {
        return this.validto;
    }
    
    public void setValidto(Date validto) {
        this.validto = validto;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TaxId) ) return false;
		 TaxId castOther = ( TaxId ) other; 
         
		 return ( (this.getChartId()==castOther.getChartId()) || ( this.getChartId()!=null && castOther.getChartId()!=null && this.getChartId().equals(castOther.getChartId()) ) )
 && ( (this.getRate()==castOther.getRate()) || ( this.getRate()!=null && castOther.getRate()!=null && this.getRate().equals(castOther.getRate()) ) )
 && ( (this.getTaxnumber()==castOther.getTaxnumber()) || ( this.getTaxnumber()!=null && castOther.getTaxnumber()!=null && this.getTaxnumber().equals(castOther.getTaxnumber()) ) )
 && ( (this.getValidto()==castOther.getValidto()) || ( this.getValidto()!=null && castOther.getValidto()!=null && this.getValidto().equals(castOther.getValidto()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getChartId() == null ? 0 : this.getChartId().hashCode() );
         result = 37 * result + ( getRate() == null ? 0 : this.getRate().hashCode() );
         result = 37 * result + ( getTaxnumber() == null ? 0 : this.getTaxnumber().hashCode() );
         result = 37 * result + ( getValidto() == null ? 0 : this.getValidto().hashCode() );
         return result;
   }   


}


