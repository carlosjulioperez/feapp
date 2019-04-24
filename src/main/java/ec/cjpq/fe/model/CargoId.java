package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CargoId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class CargoId  implements java.io.Serializable
 {


     private int id;
     private int transId;
     private String package_;
     private Double netweight;
     private Double grossweight;
     private Double volume;

    public CargoId() {
    }

	
    public CargoId(int id, int transId) {
        this.id = id;
        this.transId = transId;
    }
    public CargoId(int id, int transId, String package_, Double netweight, Double grossweight, Double volume) {
       this.id = id;
       this.transId = transId;
       this.package_ = package_;
       this.netweight = netweight;
       this.grossweight = grossweight;
       this.volume = volume;
    }
   


    @Column(name="id", nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }


    @Column(name="trans_id", nullable=false)
    public int getTransId() {
        return this.transId;
    }
    
    public void setTransId(int transId) {
        this.transId = transId;
    }


    @Column(name="package")
    public String getPackage_() {
        return this.package_;
    }
    
    public void setPackage_(String package_) {
        this.package_ = package_;
    }


    @Column(name="netweight", precision=17, scale=17)
    public Double getNetweight() {
        return this.netweight;
    }
    
    public void setNetweight(Double netweight) {
        this.netweight = netweight;
    }


    @Column(name="grossweight", precision=17, scale=17)
    public Double getGrossweight() {
        return this.grossweight;
    }
    
    public void setGrossweight(Double grossweight) {
        this.grossweight = grossweight;
    }


    @Column(name="volume", precision=17, scale=17)
    public Double getVolume() {
        return this.volume;
    }
    
    public void setVolume(Double volume) {
        this.volume = volume;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CargoId) ) return false;
		 CargoId castOther = ( CargoId ) other; 
         
		 return (this.getId()==castOther.getId())
 && (this.getTransId()==castOther.getTransId())
 && ( (this.getPackage_()==castOther.getPackage_()) || ( this.getPackage_()!=null && castOther.getPackage_()!=null && this.getPackage_().equals(castOther.getPackage_()) ) )
 && ( (this.getNetweight()==castOther.getNetweight()) || ( this.getNetweight()!=null && castOther.getNetweight()!=null && this.getNetweight().equals(castOther.getNetweight()) ) )
 && ( (this.getGrossweight()==castOther.getGrossweight()) || ( this.getGrossweight()!=null && castOther.getGrossweight()!=null && this.getGrossweight().equals(castOther.getGrossweight()) ) )
 && ( (this.getVolume()==castOther.getVolume()) || ( this.getVolume()!=null && castOther.getVolume()!=null && this.getVolume().equals(castOther.getVolume()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getId();
         result = 37 * result + this.getTransId();
         result = 37 * result + ( getPackage_() == null ? 0 : this.getPackage_().hashCode() );
         result = 37 * result + ( getNetweight() == null ? 0 : this.getNetweight().hashCode() );
         result = 37 * result + ( getGrossweight() == null ? 0 : this.getGrossweight().hashCode() );
         result = 37 * result + ( getVolume() == null ? 0 : this.getVolume().hashCode() );
         return result;
   }   


}


