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
 * Fifo por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="fifo",schema="public")
public class Fifo  implements java.io.Serializable
 {


     private FifoId id;

    public Fifo() {
    }

    public Fifo(FifoId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="transId", column=@Column(name="trans_id") ), 
        @AttributeOverride(name="transdate", column=@Column(name="transdate", length=13) ), 
        @AttributeOverride(name="partsId", column=@Column(name="parts_id") ), 
        @AttributeOverride(name="qty", column=@Column(name="qty", precision=17, scale=17) ), 
        @AttributeOverride(name="costprice", column=@Column(name="costprice", precision=17, scale=17) ), 
        @AttributeOverride(name="sellprice", column=@Column(name="sellprice", precision=17, scale=17) ), 
        @AttributeOverride(name="warehouseId", column=@Column(name="warehouse_id") ), 
        @AttributeOverride(name="invoiceId", column=@Column(name="invoice_id") ), 
        @AttributeOverride(name="lotnum", column=@Column(name="lotnum") ) } )
    public FifoId getId() {
        return this.id;
    }
    
    public void setId(FifoId id) {
        this.id = id;
    }




}


