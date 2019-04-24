package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * JcitemsId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class JcitemsId  implements java.io.Serializable
 {


     private Integer id;
     private Integer projectId;
     private Integer partsId;
     private String description;
     private Double qty;
     private Double allocated;
     private Double sellprice;
     private Double fxsellprice;
     private String serialnumber;
     private Date checkedin;
     private Date checkedout;
     private Integer employeeId;
     private String notes;

    public JcitemsId() {
    }

    public JcitemsId(Integer id, Integer projectId, Integer partsId, String description, Double qty, Double allocated, Double sellprice, Double fxsellprice, String serialnumber, Date checkedin, Date checkedout, Integer employeeId, String notes) {
       this.id = id;
       this.projectId = projectId;
       this.partsId = partsId;
       this.description = description;
       this.qty = qty;
       this.allocated = allocated;
       this.sellprice = sellprice;
       this.fxsellprice = fxsellprice;
       this.serialnumber = serialnumber;
       this.checkedin = checkedin;
       this.checkedout = checkedout;
       this.employeeId = employeeId;
       this.notes = notes;
    }
   


    @Column(name="id")
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name="project_id")
    public Integer getProjectId() {
        return this.projectId;
    }
    
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }


    @Column(name="parts_id")
    public Integer getPartsId() {
        return this.partsId;
    }
    
    public void setPartsId(Integer partsId) {
        this.partsId = partsId;
    }


    @Column(name="description")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }


    @Column(name="qty", precision=17, scale=17)
    public Double getQty() {
        return this.qty;
    }
    
    public void setQty(Double qty) {
        this.qty = qty;
    }


    @Column(name="allocated", precision=17, scale=17)
    public Double getAllocated() {
        return this.allocated;
    }
    
    public void setAllocated(Double allocated) {
        this.allocated = allocated;
    }


    @Column(name="sellprice", precision=17, scale=17)
    public Double getSellprice() {
        return this.sellprice;
    }
    
    public void setSellprice(Double sellprice) {
        this.sellprice = sellprice;
    }


    @Column(name="fxsellprice", precision=17, scale=17)
    public Double getFxsellprice() {
        return this.fxsellprice;
    }
    
    public void setFxsellprice(Double fxsellprice) {
        this.fxsellprice = fxsellprice;
    }


    @Column(name="serialnumber")
    public String getSerialnumber() {
        return this.serialnumber;
    }
    
    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }


    @Column(name="checkedin", length=35)
    public Date getCheckedin() {
        return this.checkedin;
    }
    
    public void setCheckedin(Date checkedin) {
        this.checkedin = checkedin;
    }


    @Column(name="checkedout", length=35)
    public Date getCheckedout() {
        return this.checkedout;
    }
    
    public void setCheckedout(Date checkedout) {
        this.checkedout = checkedout;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof JcitemsId) ) return false;
		 JcitemsId castOther = ( JcitemsId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getProjectId()==castOther.getProjectId()) || ( this.getProjectId()!=null && castOther.getProjectId()!=null && this.getProjectId().equals(castOther.getProjectId()) ) )
 && ( (this.getPartsId()==castOther.getPartsId()) || ( this.getPartsId()!=null && castOther.getPartsId()!=null && this.getPartsId().equals(castOther.getPartsId()) ) )
 && ( (this.getDescription()==castOther.getDescription()) || ( this.getDescription()!=null && castOther.getDescription()!=null && this.getDescription().equals(castOther.getDescription()) ) )
 && ( (this.getQty()==castOther.getQty()) || ( this.getQty()!=null && castOther.getQty()!=null && this.getQty().equals(castOther.getQty()) ) )
 && ( (this.getAllocated()==castOther.getAllocated()) || ( this.getAllocated()!=null && castOther.getAllocated()!=null && this.getAllocated().equals(castOther.getAllocated()) ) )
 && ( (this.getSellprice()==castOther.getSellprice()) || ( this.getSellprice()!=null && castOther.getSellprice()!=null && this.getSellprice().equals(castOther.getSellprice()) ) )
 && ( (this.getFxsellprice()==castOther.getFxsellprice()) || ( this.getFxsellprice()!=null && castOther.getFxsellprice()!=null && this.getFxsellprice().equals(castOther.getFxsellprice()) ) )
 && ( (this.getSerialnumber()==castOther.getSerialnumber()) || ( this.getSerialnumber()!=null && castOther.getSerialnumber()!=null && this.getSerialnumber().equals(castOther.getSerialnumber()) ) )
 && ( (this.getCheckedin()==castOther.getCheckedin()) || ( this.getCheckedin()!=null && castOther.getCheckedin()!=null && this.getCheckedin().equals(castOther.getCheckedin()) ) )
 && ( (this.getCheckedout()==castOther.getCheckedout()) || ( this.getCheckedout()!=null && castOther.getCheckedout()!=null && this.getCheckedout().equals(castOther.getCheckedout()) ) )
 && ( (this.getEmployeeId()==castOther.getEmployeeId()) || ( this.getEmployeeId()!=null && castOther.getEmployeeId()!=null && this.getEmployeeId().equals(castOther.getEmployeeId()) ) )
 && ( (this.getNotes()==castOther.getNotes()) || ( this.getNotes()!=null && castOther.getNotes()!=null && this.getNotes().equals(castOther.getNotes()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getProjectId() == null ? 0 : this.getProjectId().hashCode() );
         result = 37 * result + ( getPartsId() == null ? 0 : this.getPartsId().hashCode() );
         result = 37 * result + ( getDescription() == null ? 0 : this.getDescription().hashCode() );
         result = 37 * result + ( getQty() == null ? 0 : this.getQty().hashCode() );
         result = 37 * result + ( getAllocated() == null ? 0 : this.getAllocated().hashCode() );
         result = 37 * result + ( getSellprice() == null ? 0 : this.getSellprice().hashCode() );
         result = 37 * result + ( getFxsellprice() == null ? 0 : this.getFxsellprice().hashCode() );
         result = 37 * result + ( getSerialnumber() == null ? 0 : this.getSerialnumber().hashCode() );
         result = 37 * result + ( getCheckedin() == null ? 0 : this.getCheckedin().hashCode() );
         result = 37 * result + ( getCheckedout() == null ? 0 : this.getCheckedout().hashCode() );
         result = 37 * result + ( getEmployeeId() == null ? 0 : this.getEmployeeId().hashCode() );
         result = 37 * result + ( getNotes() == null ? 0 : this.getNotes().hashCode() );
         return result;
   }   


}


