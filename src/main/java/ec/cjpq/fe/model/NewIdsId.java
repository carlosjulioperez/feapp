package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * NewIdsId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class NewIdsId  implements java.io.Serializable
 {


     private Integer oldId;
     private Date transdate;
     private String transtype;
     private Integer newId;

    public NewIdsId() {
    }

    public NewIdsId(Integer oldId, Date transdate, String transtype, Integer newId) {
       this.oldId = oldId;
       this.transdate = transdate;
       this.transtype = transtype;
       this.newId = newId;
    }
   


    @Column(name="old_id")
    public Integer getOldId() {
        return this.oldId;
    }
    
    public void setOldId(Integer oldId) {
        this.oldId = oldId;
    }


    @Column(name="transdate", length=13)
    public Date getTransdate() {
        return this.transdate;
    }
    
    public void setTransdate(Date transdate) {
        this.transdate = transdate;
    }


    @Column(name="transtype", length=10)
    public String getTranstype() {
        return this.transtype;
    }
    
    public void setTranstype(String transtype) {
        this.transtype = transtype;
    }


    @Column(name="new_id")
    public Integer getNewId() {
        return this.newId;
    }
    
    public void setNewId(Integer newId) {
        this.newId = newId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof NewIdsId) ) return false;
		 NewIdsId castOther = ( NewIdsId ) other; 
         
		 return ( (this.getOldId()==castOther.getOldId()) || ( this.getOldId()!=null && castOther.getOldId()!=null && this.getOldId().equals(castOther.getOldId()) ) )
 && ( (this.getTransdate()==castOther.getTransdate()) || ( this.getTransdate()!=null && castOther.getTransdate()!=null && this.getTransdate().equals(castOther.getTransdate()) ) )
 && ( (this.getTranstype()==castOther.getTranstype()) || ( this.getTranstype()!=null && castOther.getTranstype()!=null && this.getTranstype().equals(castOther.getTranstype()) ) )
 && ( (this.getNewId()==castOther.getNewId()) || ( this.getNewId()!=null && castOther.getNewId()!=null && this.getNewId().equals(castOther.getNewId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getOldId() == null ? 0 : this.getOldId().hashCode() );
         result = 37 * result + ( getTransdate() == null ? 0 : this.getTransdate().hashCode() );
         result = 37 * result + ( getTranstype() == null ? 0 : this.getTranstype().hashCode() );
         result = 37 * result + ( getNewId() == null ? 0 : this.getNewId().hashCode() );
         return result;
   }   


}


