package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AccTransId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class AccTransId  implements java.io.Serializable
 {


     private Integer transId;
     private Integer chartId;
     private Double amount;
     private Date transdate;
     private String source;
     private Boolean approved;
     private Boolean fxTransaction;
     private Integer projectId;
     private String memo;
     private Integer id;
     private Date cleared;
     private Integer vrId;
     private Integer cvId;

    public AccTransId() {
    }

    public AccTransId(Integer transId, Integer chartId, Double amount, Date transdate, String source, Boolean approved, Boolean fxTransaction, Integer projectId, String memo, Integer id, Date cleared, Integer vrId, Integer cvId) {
       this.transId = transId;
       this.chartId = chartId;
       this.amount = amount;
       this.transdate = transdate;
       this.source = source;
       this.approved = approved;
       this.fxTransaction = fxTransaction;
       this.projectId = projectId;
       this.memo = memo;
       this.id = id;
       this.cleared = cleared;
       this.vrId = vrId;
       this.cvId = cvId;
    }
   


    @Column(name="trans_id")
    public Integer getTransId() {
        return this.transId;
    }
    
    public void setTransId(Integer transId) {
        this.transId = transId;
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


    @Column(name="transdate", length=13)
    public Date getTransdate() {
        return this.transdate;
    }
    
    public void setTransdate(Date transdate) {
        this.transdate = transdate;
    }


    @Column(name="source")
    public String getSource() {
        return this.source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }


    @Column(name="approved")
    public Boolean getApproved() {
        return this.approved;
    }
    
    public void setApproved(Boolean approved) {
        this.approved = approved;
    }


    @Column(name="fx_transaction")
    public Boolean getFxTransaction() {
        return this.fxTransaction;
    }
    
    public void setFxTransaction(Boolean fxTransaction) {
        this.fxTransaction = fxTransaction;
    }


    @Column(name="project_id")
    public Integer getProjectId() {
        return this.projectId;
    }
    
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }


    @Column(name="memo")
    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo(String memo) {
        this.memo = memo;
    }


    @Column(name="id")
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name="cleared", length=13)
    public Date getCleared() {
        return this.cleared;
    }
    
    public void setCleared(Date cleared) {
        this.cleared = cleared;
    }


    @Column(name="vr_id")
    public Integer getVrId() {
        return this.vrId;
    }
    
    public void setVrId(Integer vrId) {
        this.vrId = vrId;
    }


    @Column(name="cv_id")
    public Integer getCvId() {
        return this.cvId;
    }
    
    public void setCvId(Integer cvId) {
        this.cvId = cvId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AccTransId) ) return false;
		 AccTransId castOther = ( AccTransId ) other; 
         
		 return ( (this.getTransId()==castOther.getTransId()) || ( this.getTransId()!=null && castOther.getTransId()!=null && this.getTransId().equals(castOther.getTransId()) ) )
 && ( (this.getChartId()==castOther.getChartId()) || ( this.getChartId()!=null && castOther.getChartId()!=null && this.getChartId().equals(castOther.getChartId()) ) )
 && ( (this.getAmount()==castOther.getAmount()) || ( this.getAmount()!=null && castOther.getAmount()!=null && this.getAmount().equals(castOther.getAmount()) ) )
 && ( (this.getTransdate()==castOther.getTransdate()) || ( this.getTransdate()!=null && castOther.getTransdate()!=null && this.getTransdate().equals(castOther.getTransdate()) ) )
 && ( (this.getSource()==castOther.getSource()) || ( this.getSource()!=null && castOther.getSource()!=null && this.getSource().equals(castOther.getSource()) ) )
 && ( (this.getApproved()==castOther.getApproved()) || ( this.getApproved()!=null && castOther.getApproved()!=null && this.getApproved().equals(castOther.getApproved()) ) )
 && ( (this.getFxTransaction()==castOther.getFxTransaction()) || ( this.getFxTransaction()!=null && castOther.getFxTransaction()!=null && this.getFxTransaction().equals(castOther.getFxTransaction()) ) )
 && ( (this.getProjectId()==castOther.getProjectId()) || ( this.getProjectId()!=null && castOther.getProjectId()!=null && this.getProjectId().equals(castOther.getProjectId()) ) )
 && ( (this.getMemo()==castOther.getMemo()) || ( this.getMemo()!=null && castOther.getMemo()!=null && this.getMemo().equals(castOther.getMemo()) ) )
 && ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getCleared()==castOther.getCleared()) || ( this.getCleared()!=null && castOther.getCleared()!=null && this.getCleared().equals(castOther.getCleared()) ) )
 && ( (this.getVrId()==castOther.getVrId()) || ( this.getVrId()!=null && castOther.getVrId()!=null && this.getVrId().equals(castOther.getVrId()) ) )
 && ( (this.getCvId()==castOther.getCvId()) || ( this.getCvId()!=null && castOther.getCvId()!=null && this.getCvId().equals(castOther.getCvId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getTransId() == null ? 0 : this.getTransId().hashCode() );
         result = 37 * result + ( getChartId() == null ? 0 : this.getChartId().hashCode() );
         result = 37 * result + ( getAmount() == null ? 0 : this.getAmount().hashCode() );
         result = 37 * result + ( getTransdate() == null ? 0 : this.getTransdate().hashCode() );
         result = 37 * result + ( getSource() == null ? 0 : this.getSource().hashCode() );
         result = 37 * result + ( getApproved() == null ? 0 : this.getApproved().hashCode() );
         result = 37 * result + ( getFxTransaction() == null ? 0 : this.getFxTransaction().hashCode() );
         result = 37 * result + ( getProjectId() == null ? 0 : this.getProjectId().hashCode() );
         result = 37 * result + ( getMemo() == null ? 0 : this.getMemo().hashCode() );
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getCleared() == null ? 0 : this.getCleared().hashCode() );
         result = 37 * result + ( getVrId() == null ? 0 : this.getVrId().hashCode() );
         result = 37 * result + ( getCvId() == null ? 0 : this.getCvId().hashCode() );
         return result;
   }   


}


