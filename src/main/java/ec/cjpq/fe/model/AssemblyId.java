package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AssemblyId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class AssemblyId  implements java.io.Serializable
 {


     private Integer id;
     private Integer partsId;
     private Double qty;
     private Boolean bom;
     private Boolean adj;
     private Integer aid;

    public AssemblyId() {
    }

    public AssemblyId(Integer id, Integer partsId, Double qty, Boolean bom, Boolean adj, Integer aid) {
       this.id = id;
       this.partsId = partsId;
       this.qty = qty;
       this.bom = bom;
       this.adj = adj;
       this.aid = aid;
    }
   


    @Column(name="id")
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name="parts_id")
    public Integer getPartsId() {
        return this.partsId;
    }
    
    public void setPartsId(Integer partsId) {
        this.partsId = partsId;
    }


    @Column(name="qty", precision=17, scale=17)
    public Double getQty() {
        return this.qty;
    }
    
    public void setQty(Double qty) {
        this.qty = qty;
    }


    @Column(name="bom")
    public Boolean getBom() {
        return this.bom;
    }
    
    public void setBom(Boolean bom) {
        this.bom = bom;
    }


    @Column(name="adj")
    public Boolean getAdj() {
        return this.adj;
    }
    
    public void setAdj(Boolean adj) {
        this.adj = adj;
    }


    @Column(name="aid")
    public Integer getAid() {
        return this.aid;
    }
    
    public void setAid(Integer aid) {
        this.aid = aid;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AssemblyId) ) return false;
		 AssemblyId castOther = ( AssemblyId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getPartsId()==castOther.getPartsId()) || ( this.getPartsId()!=null && castOther.getPartsId()!=null && this.getPartsId().equals(castOther.getPartsId()) ) )
 && ( (this.getQty()==castOther.getQty()) || ( this.getQty()!=null && castOther.getQty()!=null && this.getQty().equals(castOther.getQty()) ) )
 && ( (this.getBom()==castOther.getBom()) || ( this.getBom()!=null && castOther.getBom()!=null && this.getBom().equals(castOther.getBom()) ) )
 && ( (this.getAdj()==castOther.getAdj()) || ( this.getAdj()!=null && castOther.getAdj()!=null && this.getAdj().equals(castOther.getAdj()) ) )
 && ( (this.getAid()==castOther.getAid()) || ( this.getAid()!=null && castOther.getAid()!=null && this.getAid().equals(castOther.getAid()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getPartsId() == null ? 0 : this.getPartsId().hashCode() );
         result = 37 * result + ( getQty() == null ? 0 : this.getQty().hashCode() );
         result = 37 * result + ( getBom() == null ? 0 : this.getBom().hashCode() );
         result = 37 * result + ( getAdj() == null ? 0 : this.getAdj().hashCode() );
         result = 37 * result + ( getAid() == null ? 0 : this.getAid().hashCode() );
         return result;
   }   


}


