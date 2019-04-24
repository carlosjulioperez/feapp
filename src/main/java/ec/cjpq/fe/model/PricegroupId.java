package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PricegroupId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class PricegroupId  implements java.io.Serializable
 {


     private Integer id;
     private String pricegroup;

    public PricegroupId() {
    }

    public PricegroupId(Integer id, String pricegroup) {
       this.id = id;
       this.pricegroup = pricegroup;
    }
   


    @Column(name="id")
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name="pricegroup")
    public String getPricegroup() {
        return this.pricegroup;
    }
    
    public void setPricegroup(String pricegroup) {
        this.pricegroup = pricegroup;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PricegroupId) ) return false;
		 PricegroupId castOther = ( PricegroupId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getPricegroup()==castOther.getPricegroup()) || ( this.getPricegroup()!=null && castOther.getPricegroup()!=null && this.getPricegroup().equals(castOther.getPricegroup()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getPricegroup() == null ? 0 : this.getPricegroup().hashCode() );
         return result;
   }   


}


