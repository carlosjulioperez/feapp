package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TiporetId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class TiporetId  implements java.io.Serializable
 {


     private int id;
     private String description;
     private Integer porcret;
     private String impuesto;

    public TiporetId() {
    }

	
    public TiporetId(int id) {
        this.id = id;
    }
    public TiporetId(int id, String description, Integer porcret, String impuesto) {
       this.id = id;
       this.description = description;
       this.porcret = porcret;
       this.impuesto = impuesto;
    }
   


    @Column(name="id", nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }


    @Column(name="description", length=120)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }


    @Column(name="porcret")
    public Integer getPorcret() {
        return this.porcret;
    }
    
    public void setPorcret(Integer porcret) {
        this.porcret = porcret;
    }


    @Column(name="impuesto", length=10)
    public String getImpuesto() {
        return this.impuesto;
    }
    
    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TiporetId) ) return false;
		 TiporetId castOther = ( TiporetId ) other; 
         
		 return (this.getId()==castOther.getId())
 && ( (this.getDescription()==castOther.getDescription()) || ( this.getDescription()!=null && castOther.getDescription()!=null && this.getDescription().equals(castOther.getDescription()) ) )
 && ( (this.getPorcret()==castOther.getPorcret()) || ( this.getPorcret()!=null && castOther.getPorcret()!=null && this.getPorcret().equals(castOther.getPorcret()) ) )
 && ( (this.getImpuesto()==castOther.getImpuesto()) || ( this.getImpuesto()!=null && castOther.getImpuesto()!=null && this.getImpuesto().equals(castOther.getImpuesto()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getId();
         result = 37 * result + ( getDescription() == null ? 0 : this.getDescription().hashCode() );
         result = 37 * result + ( getPorcret() == null ? 0 : this.getPorcret().hashCode() );
         result = 37 * result + ( getImpuesto() == null ? 0 : this.getImpuesto().hashCode() );
         return result;
   }   


}


