package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * StatusId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class StatusId  implements java.io.Serializable
 {


     private Integer transId;
     private String formname;
     private Boolean printed;
     private Boolean emailed;
     private String spoolfile;

    public StatusId() {
    }

    public StatusId(Integer transId, String formname, Boolean printed, Boolean emailed, String spoolfile) {
       this.transId = transId;
       this.formname = formname;
       this.printed = printed;
       this.emailed = emailed;
       this.spoolfile = spoolfile;
    }
   


    @Column(name="trans_id")
    public Integer getTransId() {
        return this.transId;
    }
    
    public void setTransId(Integer transId) {
        this.transId = transId;
    }


    @Column(name="formname")
    public String getFormname() {
        return this.formname;
    }
    
    public void setFormname(String formname) {
        this.formname = formname;
    }


    @Column(name="printed")
    public Boolean getPrinted() {
        return this.printed;
    }
    
    public void setPrinted(Boolean printed) {
        this.printed = printed;
    }


    @Column(name="emailed")
    public Boolean getEmailed() {
        return this.emailed;
    }
    
    public void setEmailed(Boolean emailed) {
        this.emailed = emailed;
    }


    @Column(name="spoolfile")
    public String getSpoolfile() {
        return this.spoolfile;
    }
    
    public void setSpoolfile(String spoolfile) {
        this.spoolfile = spoolfile;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof StatusId) ) return false;
		 StatusId castOther = ( StatusId ) other; 
         
		 return ( (this.getTransId()==castOther.getTransId()) || ( this.getTransId()!=null && castOther.getTransId()!=null && this.getTransId().equals(castOther.getTransId()) ) )
 && ( (this.getFormname()==castOther.getFormname()) || ( this.getFormname()!=null && castOther.getFormname()!=null && this.getFormname().equals(castOther.getFormname()) ) )
 && ( (this.getPrinted()==castOther.getPrinted()) || ( this.getPrinted()!=null && castOther.getPrinted()!=null && this.getPrinted().equals(castOther.getPrinted()) ) )
 && ( (this.getEmailed()==castOther.getEmailed()) || ( this.getEmailed()!=null && castOther.getEmailed()!=null && this.getEmailed().equals(castOther.getEmailed()) ) )
 && ( (this.getSpoolfile()==castOther.getSpoolfile()) || ( this.getSpoolfile()!=null && castOther.getSpoolfile()!=null && this.getSpoolfile().equals(castOther.getSpoolfile()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getTransId() == null ? 0 : this.getTransId().hashCode() );
         result = 37 * result + ( getFormname() == null ? 0 : this.getFormname().hashCode() );
         result = 37 * result + ( getPrinted() == null ? 0 : this.getPrinted().hashCode() );
         result = 37 * result + ( getEmailed() == null ? 0 : this.getEmailed().hashCode() );
         result = 37 * result + ( getSpoolfile() == null ? 0 : this.getSpoolfile().hashCode() );
         return result;
   }   


}


