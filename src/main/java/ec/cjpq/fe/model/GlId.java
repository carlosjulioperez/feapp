package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * GlId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class GlId  implements java.io.Serializable
 {


     private Integer id;
     private String reference;
     private String description;
     private Date transdate;
     private Integer employeeId;
     private String notes;
     private Integer departmentId;
     private Boolean approved;
     private String curr;
     private Double exchangerate;
     private Integer ticketId;

    public GlId() {
    }

    public GlId(Integer id, String reference, String description, Date transdate, Integer employeeId, String notes, Integer departmentId, Boolean approved, String curr, Double exchangerate, Integer ticketId) {
       this.id = id;
       this.reference = reference;
       this.description = description;
       this.transdate = transdate;
       this.employeeId = employeeId;
       this.notes = notes;
       this.departmentId = departmentId;
       this.approved = approved;
       this.curr = curr;
       this.exchangerate = exchangerate;
       this.ticketId = ticketId;
    }
   


    @Column(name="id")
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name="reference")
    public String getReference() {
        return this.reference;
    }
    
    public void setReference(String reference) {
        this.reference = reference;
    }


    @Column(name="description")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }


    @Column(name="transdate", length=13)
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


    @Column(name="notes")
    public String getNotes() {
        return this.notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }


    @Column(name="department_id")
    public Integer getDepartmentId() {
        return this.departmentId;
    }
    
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }


    @Column(name="approved")
    public Boolean getApproved() {
        return this.approved;
    }
    
    public void setApproved(Boolean approved) {
        this.approved = approved;
    }


    @Column(name="curr", length=3)
    public String getCurr() {
        return this.curr;
    }
    
    public void setCurr(String curr) {
        this.curr = curr;
    }


    @Column(name="exchangerate", precision=17, scale=17)
    public Double getExchangerate() {
        return this.exchangerate;
    }
    
    public void setExchangerate(Double exchangerate) {
        this.exchangerate = exchangerate;
    }


    @Column(name="ticket_id")
    public Integer getTicketId() {
        return this.ticketId;
    }
    
    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof GlId) ) return false;
		 GlId castOther = ( GlId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getReference()==castOther.getReference()) || ( this.getReference()!=null && castOther.getReference()!=null && this.getReference().equals(castOther.getReference()) ) )
 && ( (this.getDescription()==castOther.getDescription()) || ( this.getDescription()!=null && castOther.getDescription()!=null && this.getDescription().equals(castOther.getDescription()) ) )
 && ( (this.getTransdate()==castOther.getTransdate()) || ( this.getTransdate()!=null && castOther.getTransdate()!=null && this.getTransdate().equals(castOther.getTransdate()) ) )
 && ( (this.getEmployeeId()==castOther.getEmployeeId()) || ( this.getEmployeeId()!=null && castOther.getEmployeeId()!=null && this.getEmployeeId().equals(castOther.getEmployeeId()) ) )
 && ( (this.getNotes()==castOther.getNotes()) || ( this.getNotes()!=null && castOther.getNotes()!=null && this.getNotes().equals(castOther.getNotes()) ) )
 && ( (this.getDepartmentId()==castOther.getDepartmentId()) || ( this.getDepartmentId()!=null && castOther.getDepartmentId()!=null && this.getDepartmentId().equals(castOther.getDepartmentId()) ) )
 && ( (this.getApproved()==castOther.getApproved()) || ( this.getApproved()!=null && castOther.getApproved()!=null && this.getApproved().equals(castOther.getApproved()) ) )
 && ( (this.getCurr()==castOther.getCurr()) || ( this.getCurr()!=null && castOther.getCurr()!=null && this.getCurr().equals(castOther.getCurr()) ) )
 && ( (this.getExchangerate()==castOther.getExchangerate()) || ( this.getExchangerate()!=null && castOther.getExchangerate()!=null && this.getExchangerate().equals(castOther.getExchangerate()) ) )
 && ( (this.getTicketId()==castOther.getTicketId()) || ( this.getTicketId()!=null && castOther.getTicketId()!=null && this.getTicketId().equals(castOther.getTicketId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getReference() == null ? 0 : this.getReference().hashCode() );
         result = 37 * result + ( getDescription() == null ? 0 : this.getDescription().hashCode() );
         result = 37 * result + ( getTransdate() == null ? 0 : this.getTransdate().hashCode() );
         result = 37 * result + ( getEmployeeId() == null ? 0 : this.getEmployeeId().hashCode() );
         result = 37 * result + ( getNotes() == null ? 0 : this.getNotes().hashCode() );
         result = 37 * result + ( getDepartmentId() == null ? 0 : this.getDepartmentId().hashCode() );
         result = 37 * result + ( getApproved() == null ? 0 : this.getApproved().hashCode() );
         result = 37 * result + ( getCurr() == null ? 0 : this.getCurr().hashCode() );
         result = 37 * result + ( getExchangerate() == null ? 0 : this.getExchangerate().hashCode() );
         result = 37 * result + ( getTicketId() == null ? 0 : this.getTicketId().hashCode() );
         return result;
   }   


}


