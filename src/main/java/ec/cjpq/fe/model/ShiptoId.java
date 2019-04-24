package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ShiptoId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class ShiptoId  implements java.io.Serializable
 {


     private Integer transId;
     private String shiptoname;
     private String shiptoaddress1;
     private String shiptoaddress2;
     private String shiptocity;
     private String shiptostate;
     private String shiptozipcode;
     private String shiptocountry;
     private String shiptocontact;
     private String shiptophone;
     private String shiptofax;
     private String shiptoemail;

    public ShiptoId() {
    }

    public ShiptoId(Integer transId, String shiptoname, String shiptoaddress1, String shiptoaddress2, String shiptocity, String shiptostate, String shiptozipcode, String shiptocountry, String shiptocontact, String shiptophone, String shiptofax, String shiptoemail) {
       this.transId = transId;
       this.shiptoname = shiptoname;
       this.shiptoaddress1 = shiptoaddress1;
       this.shiptoaddress2 = shiptoaddress2;
       this.shiptocity = shiptocity;
       this.shiptostate = shiptostate;
       this.shiptozipcode = shiptozipcode;
       this.shiptocountry = shiptocountry;
       this.shiptocontact = shiptocontact;
       this.shiptophone = shiptophone;
       this.shiptofax = shiptofax;
       this.shiptoemail = shiptoemail;
    }
   


    @Column(name="trans_id")
    public Integer getTransId() {
        return this.transId;
    }
    
    public void setTransId(Integer transId) {
        this.transId = transId;
    }


    @Column(name="shiptoname", length=64)
    public String getShiptoname() {
        return this.shiptoname;
    }
    
    public void setShiptoname(String shiptoname) {
        this.shiptoname = shiptoname;
    }


    @Column(name="shiptoaddress1", length=32)
    public String getShiptoaddress1() {
        return this.shiptoaddress1;
    }
    
    public void setShiptoaddress1(String shiptoaddress1) {
        this.shiptoaddress1 = shiptoaddress1;
    }


    @Column(name="shiptoaddress2", length=32)
    public String getShiptoaddress2() {
        return this.shiptoaddress2;
    }
    
    public void setShiptoaddress2(String shiptoaddress2) {
        this.shiptoaddress2 = shiptoaddress2;
    }


    @Column(name="shiptocity", length=32)
    public String getShiptocity() {
        return this.shiptocity;
    }
    
    public void setShiptocity(String shiptocity) {
        this.shiptocity = shiptocity;
    }


    @Column(name="shiptostate", length=32)
    public String getShiptostate() {
        return this.shiptostate;
    }
    
    public void setShiptostate(String shiptostate) {
        this.shiptostate = shiptostate;
    }


    @Column(name="shiptozipcode", length=10)
    public String getShiptozipcode() {
        return this.shiptozipcode;
    }
    
    public void setShiptozipcode(String shiptozipcode) {
        this.shiptozipcode = shiptozipcode;
    }


    @Column(name="shiptocountry", length=32)
    public String getShiptocountry() {
        return this.shiptocountry;
    }
    
    public void setShiptocountry(String shiptocountry) {
        this.shiptocountry = shiptocountry;
    }


    @Column(name="shiptocontact", length=64)
    public String getShiptocontact() {
        return this.shiptocontact;
    }
    
    public void setShiptocontact(String shiptocontact) {
        this.shiptocontact = shiptocontact;
    }


    @Column(name="shiptophone", length=20)
    public String getShiptophone() {
        return this.shiptophone;
    }
    
    public void setShiptophone(String shiptophone) {
        this.shiptophone = shiptophone;
    }


    @Column(name="shiptofax", length=20)
    public String getShiptofax() {
        return this.shiptofax;
    }
    
    public void setShiptofax(String shiptofax) {
        this.shiptofax = shiptofax;
    }


    @Column(name="shiptoemail")
    public String getShiptoemail() {
        return this.shiptoemail;
    }
    
    public void setShiptoemail(String shiptoemail) {
        this.shiptoemail = shiptoemail;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ShiptoId) ) return false;
		 ShiptoId castOther = ( ShiptoId ) other; 
         
		 return ( (this.getTransId()==castOther.getTransId()) || ( this.getTransId()!=null && castOther.getTransId()!=null && this.getTransId().equals(castOther.getTransId()) ) )
 && ( (this.getShiptoname()==castOther.getShiptoname()) || ( this.getShiptoname()!=null && castOther.getShiptoname()!=null && this.getShiptoname().equals(castOther.getShiptoname()) ) )
 && ( (this.getShiptoaddress1()==castOther.getShiptoaddress1()) || ( this.getShiptoaddress1()!=null && castOther.getShiptoaddress1()!=null && this.getShiptoaddress1().equals(castOther.getShiptoaddress1()) ) )
 && ( (this.getShiptoaddress2()==castOther.getShiptoaddress2()) || ( this.getShiptoaddress2()!=null && castOther.getShiptoaddress2()!=null && this.getShiptoaddress2().equals(castOther.getShiptoaddress2()) ) )
 && ( (this.getShiptocity()==castOther.getShiptocity()) || ( this.getShiptocity()!=null && castOther.getShiptocity()!=null && this.getShiptocity().equals(castOther.getShiptocity()) ) )
 && ( (this.getShiptostate()==castOther.getShiptostate()) || ( this.getShiptostate()!=null && castOther.getShiptostate()!=null && this.getShiptostate().equals(castOther.getShiptostate()) ) )
 && ( (this.getShiptozipcode()==castOther.getShiptozipcode()) || ( this.getShiptozipcode()!=null && castOther.getShiptozipcode()!=null && this.getShiptozipcode().equals(castOther.getShiptozipcode()) ) )
 && ( (this.getShiptocountry()==castOther.getShiptocountry()) || ( this.getShiptocountry()!=null && castOther.getShiptocountry()!=null && this.getShiptocountry().equals(castOther.getShiptocountry()) ) )
 && ( (this.getShiptocontact()==castOther.getShiptocontact()) || ( this.getShiptocontact()!=null && castOther.getShiptocontact()!=null && this.getShiptocontact().equals(castOther.getShiptocontact()) ) )
 && ( (this.getShiptophone()==castOther.getShiptophone()) || ( this.getShiptophone()!=null && castOther.getShiptophone()!=null && this.getShiptophone().equals(castOther.getShiptophone()) ) )
 && ( (this.getShiptofax()==castOther.getShiptofax()) || ( this.getShiptofax()!=null && castOther.getShiptofax()!=null && this.getShiptofax().equals(castOther.getShiptofax()) ) )
 && ( (this.getShiptoemail()==castOther.getShiptoemail()) || ( this.getShiptoemail()!=null && castOther.getShiptoemail()!=null && this.getShiptoemail().equals(castOther.getShiptoemail()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getTransId() == null ? 0 : this.getTransId().hashCode() );
         result = 37 * result + ( getShiptoname() == null ? 0 : this.getShiptoname().hashCode() );
         result = 37 * result + ( getShiptoaddress1() == null ? 0 : this.getShiptoaddress1().hashCode() );
         result = 37 * result + ( getShiptoaddress2() == null ? 0 : this.getShiptoaddress2().hashCode() );
         result = 37 * result + ( getShiptocity() == null ? 0 : this.getShiptocity().hashCode() );
         result = 37 * result + ( getShiptostate() == null ? 0 : this.getShiptostate().hashCode() );
         result = 37 * result + ( getShiptozipcode() == null ? 0 : this.getShiptozipcode().hashCode() );
         result = 37 * result + ( getShiptocountry() == null ? 0 : this.getShiptocountry().hashCode() );
         result = 37 * result + ( getShiptocontact() == null ? 0 : this.getShiptocontact().hashCode() );
         result = 37 * result + ( getShiptophone() == null ? 0 : this.getShiptophone().hashCode() );
         result = 37 * result + ( getShiptofax() == null ? 0 : this.getShiptofax().hashCode() );
         result = 37 * result + ( getShiptoemail() == null ? 0 : this.getShiptoemail().hashCode() );
         return result;
   }   


}


