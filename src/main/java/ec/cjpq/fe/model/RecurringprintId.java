package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RecurringprintId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class RecurringprintId  implements java.io.Serializable
 {


     private Integer id;
     private String formname;
     private String format;
     private String printer;

    public RecurringprintId() {
    }

    public RecurringprintId(Integer id, String formname, String format, String printer) {
       this.id = id;
       this.formname = formname;
       this.format = format;
       this.printer = printer;
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


    @Column(name="printer")
    public String getPrinter() {
        return this.printer;
    }
    
    public void setPrinter(String printer) {
        this.printer = printer;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RecurringprintId) ) return false;
		 RecurringprintId castOther = ( RecurringprintId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getFormname()==castOther.getFormname()) || ( this.getFormname()!=null && castOther.getFormname()!=null && this.getFormname().equals(castOther.getFormname()) ) )
 && ( (this.getFormat()==castOther.getFormat()) || ( this.getFormat()!=null && castOther.getFormat()!=null && this.getFormat().equals(castOther.getFormat()) ) )
 && ( (this.getPrinter()==castOther.getPrinter()) || ( this.getPrinter()!=null && castOther.getPrinter()!=null && this.getPrinter().equals(castOther.getPrinter()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getFormname() == null ? 0 : this.getFormname().hashCode() );
         result = 37 * result + ( getFormat() == null ? 0 : this.getFormat().hashCode() );
         result = 37 * result + ( getPrinter() == null ? 0 : this.getPrinter().hashCode() );
         return result;
   }   


}


