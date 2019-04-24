package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MakemodelId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class MakemodelId  implements java.io.Serializable
 {


     private Integer partsId;
     private String make;
     private String model;

    public MakemodelId() {
    }

    public MakemodelId(Integer partsId, String make, String model) {
       this.partsId = partsId;
       this.make = make;
       this.model = model;
    }
   


    @Column(name="parts_id")
    public Integer getPartsId() {
        return this.partsId;
    }
    
    public void setPartsId(Integer partsId) {
        this.partsId = partsId;
    }


    @Column(name="make")
    public String getMake() {
        return this.make;
    }
    
    public void setMake(String make) {
        this.make = make;
    }


    @Column(name="model")
    public String getModel() {
        return this.model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof MakemodelId) ) return false;
		 MakemodelId castOther = ( MakemodelId ) other; 
         
		 return ( (this.getPartsId()==castOther.getPartsId()) || ( this.getPartsId()!=null && castOther.getPartsId()!=null && this.getPartsId().equals(castOther.getPartsId()) ) )
 && ( (this.getMake()==castOther.getMake()) || ( this.getMake()!=null && castOther.getMake()!=null && this.getMake().equals(castOther.getMake()) ) )
 && ( (this.getModel()==castOther.getModel()) || ( this.getModel()!=null && castOther.getModel()!=null && this.getModel().equals(castOther.getModel()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getPartsId() == null ? 0 : this.getPartsId().hashCode() );
         result = 37 * result + ( getMake() == null ? 0 : this.getMake().hashCode() );
         result = 37 * result + ( getModel() == null ? 0 : this.getModel().hashCode() );
         return result;
   }   


}


