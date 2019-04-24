package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * BankId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class BankId  implements java.io.Serializable
 {


     private Integer id;
     private String name;
     private String iban;
     private String bic;
     private Integer addressId;
     private String dcn;
     private String rvc;
     private String membernumber;

    public BankId() {
    }

    public BankId(Integer id, String name, String iban, String bic, Integer addressId, String dcn, String rvc, String membernumber) {
       this.id = id;
       this.name = name;
       this.iban = iban;
       this.bic = bic;
       this.addressId = addressId;
       this.dcn = dcn;
       this.rvc = rvc;
       this.membernumber = membernumber;
    }
   


    @Column(name="id")
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name="name", length=64)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }


    @Column(name="iban", length=34)
    public String getIban() {
        return this.iban;
    }
    
    public void setIban(String iban) {
        this.iban = iban;
    }


    @Column(name="bic", length=11)
    public String getBic() {
        return this.bic;
    }
    
    public void setBic(String bic) {
        this.bic = bic;
    }


    @Column(name="address_id")
    public Integer getAddressId() {
        return this.addressId;
    }
    
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }


    @Column(name="dcn")
    public String getDcn() {
        return this.dcn;
    }
    
    public void setDcn(String dcn) {
        this.dcn = dcn;
    }


    @Column(name="rvc")
    public String getRvc() {
        return this.rvc;
    }
    
    public void setRvc(String rvc) {
        this.rvc = rvc;
    }


    @Column(name="membernumber")
    public String getMembernumber() {
        return this.membernumber;
    }
    
    public void setMembernumber(String membernumber) {
        this.membernumber = membernumber;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof BankId) ) return false;
		 BankId castOther = ( BankId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getName()==castOther.getName()) || ( this.getName()!=null && castOther.getName()!=null && this.getName().equals(castOther.getName()) ) )
 && ( (this.getIban()==castOther.getIban()) || ( this.getIban()!=null && castOther.getIban()!=null && this.getIban().equals(castOther.getIban()) ) )
 && ( (this.getBic()==castOther.getBic()) || ( this.getBic()!=null && castOther.getBic()!=null && this.getBic().equals(castOther.getBic()) ) )
 && ( (this.getAddressId()==castOther.getAddressId()) || ( this.getAddressId()!=null && castOther.getAddressId()!=null && this.getAddressId().equals(castOther.getAddressId()) ) )
 && ( (this.getDcn()==castOther.getDcn()) || ( this.getDcn()!=null && castOther.getDcn()!=null && this.getDcn().equals(castOther.getDcn()) ) )
 && ( (this.getRvc()==castOther.getRvc()) || ( this.getRvc()!=null && castOther.getRvc()!=null && this.getRvc().equals(castOther.getRvc()) ) )
 && ( (this.getMembernumber()==castOther.getMembernumber()) || ( this.getMembernumber()!=null && castOther.getMembernumber()!=null && this.getMembernumber().equals(castOther.getMembernumber()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getName() == null ? 0 : this.getName().hashCode() );
         result = 37 * result + ( getIban() == null ? 0 : this.getIban().hashCode() );
         result = 37 * result + ( getBic() == null ? 0 : this.getBic().hashCode() );
         result = 37 * result + ( getAddressId() == null ? 0 : this.getAddressId().hashCode() );
         result = 37 * result + ( getDcn() == null ? 0 : this.getDcn().hashCode() );
         result = 37 * result + ( getRvc() == null ? 0 : this.getRvc().hashCode() );
         result = 37 * result + ( getMembernumber() == null ? 0 : this.getMembernumber().hashCode() );
         return result;
   }   


}


