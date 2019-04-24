package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * GifiId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class GifiId  implements java.io.Serializable
 {


     private String accno;
     private String description;

    public GifiId() {
    }

    public GifiId(String accno, String description) {
       this.accno = accno;
       this.description = description;
    }
   


    @Column(name="accno", unique=true)
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof GifiId) ) return false;
		 GifiId castOther = ( GifiId ) other; 
         
		 return ( (this.getAccno()==castOther.getAccno()) || ( this.getAccno()!=null && castOther.getAccno()!=null && this.getAccno().equals(castOther.getAccno()) ) )
 && ( (this.getDescription()==castOther.getDescription()) || ( this.getDescription()!=null && castOther.getDescription()!=null && this.getDescription().equals(castOther.getDescription()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAccno() == null ? 0 : this.getAccno().hashCode() );
         result = 37 * result + ( getDescription() == null ? 0 : this.getDescription().hashCode() );
         return result;
   }   


}


