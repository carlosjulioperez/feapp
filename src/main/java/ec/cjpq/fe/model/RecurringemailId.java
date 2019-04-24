package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RecurringemailId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class RecurringemailId  implements java.io.Serializable
 {


     private Integer id;
     private String formname;
     private String format;
     private String message;

    public RecurringemailId() {
    }

    public RecurringemailId(Integer id, String formname, String format, String message) {
       this.id = id;
       this.formname = formname;
       this.format = format;
       this.message = message;
    }
   


    @Column(name="id")
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name="formname")
    public String getFormname() {
        return this.formname;
    }
    
    public void setFormname(String formname) {
        this.formname = formname;
    }


    @Column(name="format")
    public String getFormat() {
        return this.format;
    }
    
    public void setFormat(String format) {
        this.format = format;
    }


    @Column(name="message")
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RecurringemailId) ) return false;
		 RecurringemailId castOther = ( RecurringemailId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getFormname()==castOther.getFormname()) || ( this.getFormname()!=null && castOther.getFormname()!=null && this.getFormname().equals(castOther.getFormname()) ) )
 && ( (this.getFormat()==castOther.getFormat()) || ( this.getFormat()!=null && castOther.getFormat()!=null && this.getFormat().equals(castOther.getFormat()) ) )
 && ( (this.getMessage()==castOther.getMessage()) || ( this.getMessage()!=null && castOther.getMessage()!=null && this.getMessage().equals(castOther.getMessage()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getFormname() == null ? 0 : this.getFormname().hashCode() );
         result = 37 * result + ( getFormat() == null ? 0 : this.getFormat().hashCode() );
         result = 37 * result + ( getMessage() == null ? 0 : this.getMessage().hashCode() );
         return result;
   }   


}


