package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * LineitemId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class LineitemId  implements java.io.Serializable
 {


     private int id;
     private String linumber;
     private String description;

    public LineitemId() {
    }

	
    public LineitemId(int id) {
        this.id = id;
    }
    public LineitemId(int id, String linumber, String description) {
       this.id = id;
       this.linumber = linumber;
       this.description = description;
    }
   


    @Column(name="id", nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }


    @Column(name="linumber", length=4)
    public String getLinumber() {
        return this.linumber;
    }
    
    public void setLinumber(String linumber) {
        this.linumber = linumber;
    }


    @Column(name="description", length=35)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof LineitemId) ) return false;
		 LineitemId castOther = ( LineitemId ) other; 
         
		 return (this.getId()==castOther.getId())
 && ( (this.getLinumber()==castOther.getLinumber()) || ( this.getLinumber()!=null && castOther.getLinumber()!=null && this.getLinumber().equals(castOther.getLinumber()) ) )
 && ( (this.getDescription()==castOther.getDescription()) || ( this.getDescription()!=null && castOther.getDescription()!=null && this.getDescription().equals(castOther.getDescription()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getId();
         result = 37 * result + ( getLinumber() == null ? 0 : this.getLinumber().hashCode() );
         result = 37 * result + ( getDescription() == null ? 0 : this.getDescription().hashCode() );
         return result;
   }   


}


