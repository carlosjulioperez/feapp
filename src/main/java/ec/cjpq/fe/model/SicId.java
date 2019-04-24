package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SicId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class SicId  implements java.io.Serializable
 {


     private String code;
     private Character sictype;
     private String description;

    public SicId() {
    }

    public SicId(String code, Character sictype, String description) {
       this.code = code;
       this.sictype = sictype;
       this.description = description;
    }
   


    @Column(name="code", length=6)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }


    @Column(name="sictype", length=1)
    public Character getSictype() {
        return this.sictype;
    }
    
    public void setSictype(Character sictype) {
        this.sictype = sictype;
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
		 if ( !(other instanceof SicId) ) return false;
		 SicId castOther = ( SicId ) other; 
         
		 return ( (this.getCode()==castOther.getCode()) || ( this.getCode()!=null && castOther.getCode()!=null && this.getCode().equals(castOther.getCode()) ) )
 && ( (this.getSictype()==castOther.getSictype()) || ( this.getSictype()!=null && castOther.getSictype()!=null && this.getSictype().equals(castOther.getSictype()) ) )
 && ( (this.getDescription()==castOther.getDescription()) || ( this.getDescription()!=null && castOther.getDescription()!=null && this.getDescription().equals(castOther.getDescription()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCode() == null ? 0 : this.getCode().hashCode() );
         result = 37 * result + ( getSictype() == null ? 0 : this.getSictype().hashCode() );
         result = 37 * result + ( getDescription() == null ? 0 : this.getDescription().hashCode() );
         return result;
   }   


}


