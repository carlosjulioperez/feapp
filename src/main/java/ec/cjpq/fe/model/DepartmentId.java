package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DepartmentId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class DepartmentId  implements java.io.Serializable
 {


     private Integer id;
     private String description;
     private Character role;

    public DepartmentId() {
    }

    public DepartmentId(Integer id, String description, Character role) {
       this.id = id;
       this.description = description;
       this.role = role;
    }
   


    @Column(name="id")
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name="description")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }


    @Column(name="role", length=1)
    public Character getRole() {
        return this.role;
    }
    
    public void setRole(Character role) {
        this.role = role;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DepartmentId) ) return false;
		 DepartmentId castOther = ( DepartmentId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getDescription()==castOther.getDescription()) || ( this.getDescription()!=null && castOther.getDescription()!=null && this.getDescription().equals(castOther.getDescription()) ) )
 && ( (this.getRole()==castOther.getRole()) || ( this.getRole()!=null && castOther.getRole()!=null && this.getRole().equals(castOther.getRole()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getDescription() == null ? 0 : this.getDescription().hashCode() );
         result = 37 * result + ( getRole() == null ? 0 : this.getRole().hashCode() );
         return result;
   }   


}


