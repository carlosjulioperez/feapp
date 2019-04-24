package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ChartId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class ChartId  implements java.io.Serializable
 {


     private Integer id;
     private String accno;
     private String description;
     private Character charttype;
     private Character category;
     private String link;
     private String gifiAccno;
     private Boolean contra;

    public ChartId() {
    }

	
    public ChartId(String accno) {
        this.accno = accno;
    }
    public ChartId(Integer id, String accno, String description, Character charttype, Character category, String link, String gifiAccno, Boolean contra) {
       this.id = id;
       this.accno = accno;
       this.description = description;
       this.charttype = charttype;
       this.category = category;
       this.link = link;
       this.gifiAccno = gifiAccno;
       this.contra = contra;
    }
   


    @Column(name="id")
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name="accno", unique=true, nullable=false)
    public String getAccno() {
        return this.accno;
    }
    
    public void setAccno(String accno) {
        this.accno = accno;
    }


    @Column(name="description")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }


    @Column(name="charttype", length=1)
    public Character getCharttype() {
        return this.charttype;
    }
    
    public void setCharttype(Character charttype) {
        this.charttype = charttype;
    }


    @Column(name="category", length=1)
    public Character getCategory() {
        return this.category;
    }
    
    public void setCategory(Character category) {
        this.category = category;
    }


    @Column(name="link")
    public String getLink() {
        return this.link;
    }
    
    public void setLink(String link) {
        this.link = link;
    }


    @Column(name="gifi_accno")
    public String getGifiAccno() {
        return this.gifiAccno;
    }
    
    public void setGifiAccno(String gifiAccno) {
        this.gifiAccno = gifiAccno;
    }


    @Column(name="contra")
    public Boolean getContra() {
        return this.contra;
    }
    
    public void setContra(Boolean contra) {
        this.contra = contra;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ChartId) ) return false;
		 ChartId castOther = ( ChartId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getAccno()==castOther.getAccno()) || ( this.getAccno()!=null && castOther.getAccno()!=null && this.getAccno().equals(castOther.getAccno()) ) )
 && ( (this.getDescription()==castOther.getDescription()) || ( this.getDescription()!=null && castOther.getDescription()!=null && this.getDescription().equals(castOther.getDescription()) ) )
 && ( (this.getCharttype()==castOther.getCharttype()) || ( this.getCharttype()!=null && castOther.getCharttype()!=null && this.getCharttype().equals(castOther.getCharttype()) ) )
 && ( (this.getCategory()==castOther.getCategory()) || ( this.getCategory()!=null && castOther.getCategory()!=null && this.getCategory().equals(castOther.getCategory()) ) )
 && ( (this.getLink()==castOther.getLink()) || ( this.getLink()!=null && castOther.getLink()!=null && this.getLink().equals(castOther.getLink()) ) )
 && ( (this.getGifiAccno()==castOther.getGifiAccno()) || ( this.getGifiAccno()!=null && castOther.getGifiAccno()!=null && this.getGifiAccno().equals(castOther.getGifiAccno()) ) )
 && ( (this.getContra()==castOther.getContra()) || ( this.getContra()!=null && castOther.getContra()!=null && this.getContra().equals(castOther.getContra()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getAccno() == null ? 0 : this.getAccno().hashCode() );
         result = 37 * result + ( getDescription() == null ? 0 : this.getDescription().hashCode() );
         result = 37 * result + ( getCharttype() == null ? 0 : this.getCharttype().hashCode() );
         result = 37 * result + ( getCategory() == null ? 0 : this.getCategory().hashCode() );
         result = 37 * result + ( getLink() == null ? 0 : this.getLink().hashCode() );
         result = 37 * result + ( getGifiAccno() == null ? 0 : this.getGifiAccno().hashCode() );
         result = 37 * result + ( getContra() == null ? 0 : this.getContra().hashCode() );
         return result;
   }   


}


