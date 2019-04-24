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
 * Bank por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="bank",schema="public")
public class Bank  implements java.io.Serializable
 {


     private BankId id;

    public Bank() {
    }

    public Bank(BankId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id") ), 
        @AttributeOverride(name="name", column=@Column(name="name", length=64) ), 
        @AttributeOverride(name="iban", column=@Column(name="iban", length=34) ), 
        @AttributeOverride(name="bic", column=@Column(name="bic", length=11) ), 
        @AttributeOverride(name="addressId", column=@Column(name="address_id") ), 
        @AttributeOverride(name="dcn", column=@Column(name="dcn") ), 
        @AttributeOverride(name="rvc", column=@Column(name="rvc") ), 
        @AttributeOverride(name="membernumber", column=@Column(name="membernumber") ) } )
    public BankId getId() {
        return this.id;
    }
    
    public void setId(BankId id) {
        this.id = id;
    }




}


