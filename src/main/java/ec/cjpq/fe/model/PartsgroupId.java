package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PartsgroupId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class PartsgroupId  implements java.io.Serializable
 {


     private Integer id;
     private String partsgroup;
     private Boolean pos;

    public PartsgroupId() {
    }

    public PartsgroupId(Integer id, String partsgroup, Boolean pos) {
       this.id = id;
       this.partsgroup = partsgroup;
       this.pos = pos;
    }
   


    @Column(name="id")
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name="partsgroup", unique=true)
    public String getPartsgroup() {
        return this.partsgroup;
    }
    
    public void setPartsgroup(String partsgroup) {
        this.partsgroup = partsgroup;
    }


    @Column(name="pos")
    public Boolean getPos() {
        return this.pos;
    }
    
    public void setPos(Boolean pos) {
        this.pos = pos;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PartsgroupId) ) return false;
		 PartsgroupId castOther = ( PartsgroupId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getPartsgroup()==castOther.getPartsgroup()) || ( this.getPartsgroup()!=null && castOther.getPartsgroup()!=null && this.getPartsgroup().equals(castOther.getPartsgroup()) ) )
 && ( (this.getPos()==castOther.getPos()) || ( this.getPos()!=null && castOther.getPos()!=null && this.getPos().equals(castOther.getPos()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getPartsgroup() == null ? 0 : this.getPartsgroup().hashCode() );
         result = 37 * result + ( getPos() == null ? 0 : this.getPos().hashCode() );
         return result;
   }   


}


