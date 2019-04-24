package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProjectId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class ProjectId  implements java.io.Serializable
 {


     private Integer id;
     private String projectnumber;
     private String description;
     private Date startdate;
     private Date enddate;
     private Integer partsId;
     private Double production;
     private Double completed;
     private Integer customerId;

    public ProjectId() {
    }

    public ProjectId(Integer id, String projectnumber, String description, Date startdate, Date enddate, Integer partsId, Double production, Double completed, Integer customerId) {
       this.id = id;
       this.projectnumber = projectnumber;
       this.description = description;
       this.startdate = startdate;
       this.enddate = enddate;
       this.partsId = partsId;
       this.production = production;
       this.completed = completed;
       this.customerId = customerId;
    }
   


    @Column(name="id")
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name="projectnumber", unique=true)
    public String getProjectnumber() {
        return this.projectnumber;
    }
    
    public void setProjectnumber(String projectnumber) {
        this.projectnumber = projectnumber;
    }


    @Column(name="description")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }


    @Column(name="startdate", length=13)
    public Date getStartdate() {
        return this.startdate;
    }
    
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }


    @Column(name="enddate", length=13)
    public Date getEnddate() {
        return this.enddate;
    }
    
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }


    @Column(name="parts_id")
    public Integer getPartsId() {
        return this.partsId;
    }
    
    public void setPartsId(Integer partsId) {
        this.partsId = partsId;
    }


    @Column(name="production", precision=17, scale=17)
    public Double getProduction() {
        return this.production;
    }
    
    public void setProduction(Double production) {
        this.production = production;
    }


    @Column(name="completed", precision=17, scale=17)
    public Double getCompleted() {
        return this.completed;
    }
    
    public void setCompleted(Double completed) {
        this.completed = completed;
    }


    @Column(name="customer_id")
    public Integer getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ProjectId) ) return false;
		 ProjectId castOther = ( ProjectId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getProjectnumber()==castOther.getProjectnumber()) || ( this.getProjectnumber()!=null && castOther.getProjectnumber()!=null && this.getProjectnumber().equals(castOther.getProjectnumber()) ) )
 && ( (this.getDescription()==castOther.getDescription()) || ( this.getDescription()!=null && castOther.getDescription()!=null && this.getDescription().equals(castOther.getDescription()) ) )
 && ( (this.getStartdate()==castOther.getStartdate()) || ( this.getStartdate()!=null && castOther.getStartdate()!=null && this.getStartdate().equals(castOther.getStartdate()) ) )
 && ( (this.getEnddate()==castOther.getEnddate()) || ( this.getEnddate()!=null && castOther.getEnddate()!=null && this.getEnddate().equals(castOther.getEnddate()) ) )
 && ( (this.getPartsId()==castOther.getPartsId()) || ( this.getPartsId()!=null && castOther.getPartsId()!=null && this.getPartsId().equals(castOther.getPartsId()) ) )
 && ( (this.getProduction()==castOther.getProduction()) || ( this.getProduction()!=null && castOther.getProduction()!=null && this.getProduction().equals(castOther.getProduction()) ) )
 && ( (this.getCompleted()==castOther.getCompleted()) || ( this.getCompleted()!=null && castOther.getCompleted()!=null && this.getCompleted().equals(castOther.getCompleted()) ) )
 && ( (this.getCustomerId()==castOther.getCustomerId()) || ( this.getCustomerId()!=null && castOther.getCustomerId()!=null && this.getCustomerId().equals(castOther.getCustomerId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getProjectnumber() == null ? 0 : this.getProjectnumber().hashCode() );
         result = 37 * result + ( getDescription() == null ? 0 : this.getDescription().hashCode() );
         result = 37 * result + ( getStartdate() == null ? 0 : this.getStartdate().hashCode() );
         result = 37 * result + ( getEnddate() == null ? 0 : this.getEnddate().hashCode() );
         result = 37 * result + ( getPartsId() == null ? 0 : this.getPartsId().hashCode() );
         result = 37 * result + ( getProduction() == null ? 0 : this.getProduction().hashCode() );
         result = 37 * result + ( getCompleted() == null ? 0 : this.getCompleted().hashCode() );
         result = 37 * result + ( getCustomerId() == null ? 0 : this.getCustomerId().hashCode() );
         return result;
   }   


}


