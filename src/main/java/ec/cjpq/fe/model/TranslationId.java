package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TranslationId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class TranslationId  implements java.io.Serializable
 {


     private Integer transId;
     private String languageCode;
     private String description;

    public TranslationId() {
    }

    public TranslationId(Integer transId, String languageCode, String description) {
       this.transId = transId;
       this.languageCode = languageCode;
       this.description = description;
    }
   


    @Column(name="trans_id")
    public Integer getTransId() {
        return this.transId;
    }
    
    public void setTransId(Integer transId) {
        this.transId = transId;
    }


    @Column(name="language_code", length=6)
    public String getLanguageCode() {
        return this.languageCode;
    }
    
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
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
		 if ( !(other instanceof TranslationId) ) return false;
		 TranslationId castOther = ( TranslationId ) other; 
         
		 return ( (this.getTransId()==castOther.getTransId()) || ( this.getTransId()!=null && castOther.getTransId()!=null && this.getTransId().equals(castOther.getTransId()) ) )
 && ( (this.getLanguageCode()==castOther.getLanguageCode()) || ( this.getLanguageCode()!=null && castOther.getLanguageCode()!=null && this.getLanguageCode().equals(castOther.getLanguageCode()) ) )
 && ( (this.getDescription()==castOther.getDescription()) || ( this.getDescription()!=null && castOther.getDescription()!=null && this.getDescription().equals(castOther.getDescription()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getTransId() == null ? 0 : this.getTransId().hashCode() );
         result = 37 * result + ( getLanguageCode() == null ? 0 : this.getLanguageCode().hashCode() );
         result = 37 * result + ( getDescription() == null ? 0 : this.getDescription().hashCode() );
         return result;
   }   


}


