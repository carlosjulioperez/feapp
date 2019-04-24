package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * InvoicetaxId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class InvoicetaxId  implements java.io.Serializable
 {


     private Integer transId;
     private Integer invoiceId;
     private Integer chartId;
     private Double taxamount;

    public InvoicetaxId() {
    }

    public InvoicetaxId(Integer transId, Integer invoiceId, Integer chartId, Double taxamount) {
       this.transId = transId;
       this.invoiceId = invoiceId;
       this.chartId = chartId;
       this.taxamount = taxamount;
    }
   


    @Column(name="trans_id")
    public Integer getTransId() {
        return this.transId;
    }
    
    public void setTransId(Integer transId) {
        this.transId = transId;
    }


    @Column(name="invoice_id")
    public Integer getInvoiceId() {
        return this.invoiceId;
    }
    
    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }


    @Column(name="chart_id")
    public Integer getChartId() {
        return this.chartId;
    }
    
    public void setChartId(Integer chartId) {
        this.chartId = chartId;
    }


    @Column(name="taxamount", precision=17, scale=17)
    public Double getTaxamount() {
        return this.taxamount;
    }
    
    public void setTaxamount(Double taxamount) {
        this.taxamount = taxamount;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof InvoicetaxId) ) return false;
		 InvoicetaxId castOther = ( InvoicetaxId ) other; 
         
		 return ( (this.getTransId()==castOther.getTransId()) || ( this.getTransId()!=null && castOther.getTransId()!=null && this.getTransId().equals(castOther.getTransId()) ) )
 && ( (this.getInvoiceId()==castOther.getInvoiceId()) || ( this.getInvoiceId()!=null && castOther.getInvoiceId()!=null && this.getInvoiceId().equals(castOther.getInvoiceId()) ) )
 && ( (this.getChartId()==castOther.getChartId()) || ( this.getChartId()!=null && castOther.getChartId()!=null && this.getChartId().equals(castOther.getChartId()) ) )
 && ( (this.getTaxamount()==castOther.getTaxamount()) || ( this.getTaxamount()!=null && castOther.getTaxamount()!=null && this.getTaxamount().equals(castOther.getTaxamount()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getTransId() == null ? 0 : this.getTransId().hashCode() );
         result = 37 * result + ( getInvoiceId() == null ? 0 : this.getInvoiceId().hashCode() );
         result = 37 * result + ( getChartId() == null ? 0 : this.getChartId().hashCode() );
         result = 37 * result + ( getTaxamount() == null ? 0 : this.getTaxamount().hashCode() );
         return result;
   }   


}


