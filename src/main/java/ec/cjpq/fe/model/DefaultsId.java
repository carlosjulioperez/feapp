package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DefaultsId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class DefaultsId  implements java.io.Serializable
 {


     private String fldname;
     private String fldvalue;

    public DefaultsId() {
    }

    public DefaultsId(String fldname, String fldvalue) {
       this.fldname = fldname;
       this.fldvalue = fldvalue;
    }
   


    @Column(name="fldname")
    public String getFldname() {
        return this.fldname;
    }
    
    public void setFldname(String fldname) {
        this.fldname = fldname;
    }


    @Column(name="fldvalue")
    public String getFldvalue() {
        return this.fldvalue;
    }
    
    public void setFldvalue(String fldvalue) {
        this.fldvalue = fldvalue;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DefaultsId) ) return false;
		 DefaultsId castOther = ( DefaultsId ) other; 
         
		 return ( (this.getFldname()==castOther.getFldname()) || ( this.getFldname()!=null && castOther.getFldname()!=null && this.getFldname().equals(castOther.getFldname()) ) )
 && ( (this.getFldvalue()==castOther.getFldvalue()) || ( this.getFldvalue()!=null && castOther.getFldvalue()!=null && this.getFldvalue().equals(castOther.getFldvalue()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getFldname() == null ? 0 : this.getFldname().hashCode() );
         result = 37 * result + ( getFldvalue() == null ? 0 : this.getFldvalue().hashCode() );
         return result;
   }   


}


