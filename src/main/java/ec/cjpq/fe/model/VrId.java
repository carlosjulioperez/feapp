package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VrId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class VrId  implements java.io.Serializable
 {


     private Integer brId;
     private int transId;
     private int id;
     private String vouchernumber;

    public VrId() {
    }

	
    public VrId(int transId, int id) {
        this.transId = transId;
        this.id = id;
    }
    public VrId(Integer brId, int transId, int id, String vouchernumber) {
       this.brId = brId;
       this.transId = transId;
       this.id = id;
       this.vouchernumber = vouchernumber;
    }
   


    @Column(name="br_id")
    public Integer getBrId() {
        return this.brId;
    }
    
    public void setBrId(Integer brId) {
        this.brId = brId;
    }


    @Column(name="trans_id", nullable=false)
    public int getTransId() {
        return this.transId;
    }
    
    public void setTransId(int transId) {
        this.transId = transId;
    }


    @Column(name="id", nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }


    @Column(name="vouchernumber")
    public String getVouchernumber() {
        return this.vouchernumber;
    }
    
    public void setVouchernumber(String vouchernumber) {
        this.vouchernumber = vouchernumber;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VrId) ) return false;
		 VrId castOther = ( VrId ) other; 
         
		 return ( (this.getBrId()==castOther.getBrId()) || ( this.getBrId()!=null && castOther.getBrId()!=null && this.getBrId().equals(castOther.getBrId()) ) )
 && (this.getTransId()==castOther.getTransId())
 && (this.getId()==castOther.getId())
 && ( (this.getVouchernumber()==castOther.getVouchernumber()) || ( this.getVouchernumber()!=null && castOther.getVouchernumber()!=null && this.getVouchernumber().equals(castOther.getVouchernumber()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getBrId() == null ? 0 : this.getBrId().hashCode() );
         result = 37 * result + this.getTransId();
         result = 37 * result + this.getId();
         result = 37 * result + ( getVouchernumber() == null ? 0 : this.getVouchernumber().hashCode() );
         return result;
   }   


}


