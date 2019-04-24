package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RecurringId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class RecurringId  implements java.io.Serializable
 {


     private Integer id;
     private String reference;
     private Date startdate;
     private Date nextdate;
     private Date enddate;
     private Short repeat;
     private String unit;
     private Integer howmany;
     private Boolean payment;
     private String description;

    public RecurringId() {
    }

    public RecurringId(Integer id, String reference, Date startdate, Date nextdate, Date enddate, Short repeat, String unit, Integer howmany, Boolean payment, String description) {
       this.id = id;
       this.reference = reference;
       this.startdate = startdate;
       this.nextdate = nextdate;
       this.enddate = enddate;
       this.repeat = repeat;
       this.unit = unit;
       this.howmany = howmany;
       this.payment = payment;
       this.description = description;
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


    @Column(name="startdate", length=13)
    public Date getStartdate() {
        return this.startdate;
    }
    
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }


    @Column(name="nextdate", length=13)
    public Date getNextdate() {
        return this.nextdate;
    }
    
    public void setNextdate(Date nextdate) {
        this.nextdate = nextdate;
    }


    @Column(name="enddate", length=13)
    public Date getEnddate() {
        return this.enddate;
    }
    
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }


    @Column(name="repeat")
    public Short getRepeat() {
        return this.repeat;
    }
    
    public void setRepeat(Short repeat) {
        this.repeat = repeat;
    }


    @Column(name="unit", length=6)
    public String getUnit() {
        return this.unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }


    @Column(name="howmany")
    public Integer getHowmany() {
        return this.howmany;
    }
    
    public void setHowmany(Integer howmany) {
        this.howmany = howmany;
    }


    @Column(name="payment")
    public Boolean getPayment() {
        return this.payment;
    }
    
    public void setPayment(Boolean payment) {
        this.payment = payment;
    }


    @Column(name="description")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RecurringId) ) return false;
		 RecurringId castOther = ( RecurringId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getReference()==castOther.getReference()) || ( this.getReference()!=null && castOther.getReference()!=null && this.getReference().equals(castOther.getReference()) ) )
 && ( (this.getStartdate()==castOther.getStartdate()) || ( this.getStartdate()!=null && castOther.getStartdate()!=null && this.getStartdate().equals(castOther.getStartdate()) ) )
 && ( (this.getNextdate()==castOther.getNextdate()) || ( this.getNextdate()!=null && castOther.getNextdate()!=null && this.getNextdate().equals(castOther.getNextdate()) ) )
 && ( (this.getEnddate()==castOther.getEnddate()) || ( this.getEnddate()!=null && castOther.getEnddate()!=null && this.getEnddate().equals(castOther.getEnddate()) ) )
 && ( (this.getRepeat()==castOther.getRepeat()) || ( this.getRepeat()!=null && castOther.getRepeat()!=null && this.getRepeat().equals(castOther.getRepeat()) ) )
 && ( (this.getUnit()==castOther.getUnit()) || ( this.getUnit()!=null && castOther.getUnit()!=null && this.getUnit().equals(castOther.getUnit()) ) )
 && ( (this.getHowmany()==castOther.getHowmany()) || ( this.getHowmany()!=null && castOther.getHowmany()!=null && this.getHowmany().equals(castOther.getHowmany()) ) )
 && ( (this.getPayment()==castOther.getPayment()) || ( this.getPayment()!=null && castOther.getPayment()!=null && this.getPayment().equals(castOther.getPayment()) ) )
 && ( (this.getDescription()==castOther.getDescription()) || ( this.getDescription()!=null && castOther.getDescription()!=null && this.getDescription().equals(castOther.getDescription()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getReference() == null ? 0 : this.getReference().hashCode() );
         result = 37 * result + ( getStartdate() == null ? 0 : this.getStartdate().hashCode() );
         result = 37 * result + ( getNextdate() == null ? 0 : this.getNextdate().hashCode() );
         result = 37 * result + ( getEnddate() == null ? 0 : this.getEnddate().hashCode() );
         result = 37 * result + ( getRepeat() == null ? 0 : this.getRepeat().hashCode() );
         result = 37 * result + ( getUnit() == null ? 0 : this.getUnit().hashCode() );
         result = 37 * result + ( getHowmany() == null ? 0 : this.getHowmany().hashCode() );
         result = 37 * result + ( getPayment() == null ? 0 : this.getPayment().hashCode() );
         result = 37 * result + ( getDescription() == null ? 0 : this.getDescription().hashCode() );
         return result;
   }   


}


