package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Shipto por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="shipto",schema="public")
public class Shipto  implements java.io.Serializable
 {


     private ShiptoId id;

    public Shipto() {
    }

    public Shipto(ShiptoId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="transId", column=@Column(name="trans_id") ), 
        @AttributeOverride(name="shiptoname", column=@Column(name="shiptoname", length=64) ), 
        @AttributeOverride(name="shiptoaddress1", column=@Column(name="shiptoaddress1", length=32) ), 
        @AttributeOverride(name="shiptoaddress2", column=@Column(name="shiptoaddress2", length=32) ), 
        @AttributeOverride(name="shiptocity", column=@Column(name="shiptocity", length=32) ), 
        @AttributeOverride(name="shiptostate", column=@Column(name="shiptostate", length=32) ), 
        @AttributeOverride(name="shiptozipcode", column=@Column(name="shiptozipcode", length=10) ), 
        @AttributeOverride(name="shiptocountry", column=@Column(name="shiptocountry", length=32) ), 
        @AttributeOverride(name="shiptocontact", column=@Column(name="shiptocontact", length=64) ), 
        @AttributeOverride(name="shiptophone", column=@Column(name="shiptophone", length=20) ), 
        @AttributeOverride(name="shiptofax", column=@Column(name="shiptofax", length=20) ), 
        @AttributeOverride(name="shiptoemail", column=@Column(name="shiptoemail") ) } )
    public ShiptoId getId() {
        return this.id;
    }
    
    public void setId(ShiptoId id) {
        this.id = id;
    }




}


