package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AudittrailId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class AudittrailId  implements java.io.Serializable
 {


     private Integer transId;
     private String tablename;
     private String reference;
     private String formname;
     private String action;
     private Date transdate;
     private Integer employeeId;

    public AudittrailId() {
    }

    public AudittrailId(Integer transId, String tablename, String reference, String formname, String action, Date transdate, Integer employeeId) {
       this.transId = transId;
       this.tablename = tablename;
       this.reference = reference;
       this.formname = formname;
       this.action = action;
       this.transdate = transdate;
       this.employeeId = employeeId;
    }
   


    @Column(name="trans_id")
    public Integer getTransId() {
        return this.transId;
    }
    
    public void setTransId(Integer transId) {
        this.transId = transId;
    }


    @Column(name="tablename")
    public String getTablename() {
        return this.tablename;
    }
    
    public void setTablename(String tablename) {
        this.tablename = tablename;
    }


    @Column(name="reference")
    public String getReference() {
        return this.reference;
    }
    
    public void setReference(String reference) {
        this.reference = reference;
    }


    @Column(name="formname")
    public String getFormname() {
        return this.formname;
    }
    
    public void setFormname(String formname) {
        this.formname = formname;
    }


    @Column(name="action")
    public String getAction() {
        return this.action;
    }
    
    public void setAction(String action) {
        this.action = action;
    }


    @Column(name="transdate", length=29)
    public Date getTransdate() {
        return this.transdate;
    }
    
    public void setTransdate(Date transdate) {
        this.transdate = transdate;
    }


    @Column(name="employee_id")
    public Integer getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AudittrailId) ) return false;
		 AudittrailId castOther = ( AudittrailId ) other; 
         
		 return ( (this.getTransId()==castOther.getTransId()) || ( this.getTransId()!=null && castOther.getTransId()!=null && this.getTransId().equals(castOther.getTransId()) ) )
 && ( (this.getTablename()==castOther.getTablename()) || ( this.getTablename()!=null && castOther.getTablename()!=null && this.getTablename().equals(castOther.getTablename()) ) )
 && ( (this.getReference()==castOther.getReference()) || ( this.getReference()!=null && castOther.getReference()!=null && this.getReference().equals(castOther.getReference()) ) )
 && ( (this.getFormname()==castOther.getFormname()) || ( this.getFormname()!=null && castOther.getFormname()!=null && this.getFormname().equals(castOther.getFormname()) ) )
 && ( (this.getAction()==castOther.getAction()) || ( this.getAction()!=null && castOther.getAction()!=null && this.getAction().equals(castOther.getAction()) ) )
 && ( (this.getTransdate()==castOther.getTransdate()) || ( this.getTransdate()!=null && castOther.getTransdate()!=null && this.getTransdate().equals(castOther.getTransdate()) ) )
 && ( (this.getEmployeeId()==castOther.getEmployeeId()) || ( this.getEmployeeId()!=null && castOther.getEmployeeId()!=null && this.getEmployeeId().equals(castOther.getEmployeeId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getTransId() == null ? 0 : this.getTransId().hashCode() );
         result = 37 * result + ( getTablename() == null ? 0 : this.getTablename().hashCode() );
         result = 37 * result + ( getReference() == null ? 0 : this.getReference().hashCode() );
         result = 37 * result + ( getFormname() == null ? 0 : this.getFormname().hashCode() );
         result = 37 * result + ( getAction() == null ? 0 : this.getAction().hashCode() );
         result = 37 * result + ( getTransdate() == null ? 0 : this.getTransdate().hashCode() );
         result = 37 * result + ( getEmployeeId() == null ? 0 : this.getEmployeeId().hashCode() );
         return result;
   }   


}


