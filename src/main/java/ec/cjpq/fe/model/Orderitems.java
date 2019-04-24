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
 * Orderitems por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="orderitems",schema="public")
public class Orderitems  implements java.io.Serializable
 {


     private OrderitemsId id;

    public Orderitems() {
    }

    public Orderitems(OrderitemsId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id") ), 
        @AttributeOverride(name="transId", column=@Column(name="trans_id") ), 
        @AttributeOverride(name="partsId", column=@Column(name="parts_id") ), 
        @AttributeOverride(name="description", column=@Column(name="description") ), 
        @AttributeOverride(name="qty", column=@Column(name="qty", precision=17, scale=17) ), 
        @AttributeOverride(name="sellprice", column=@Column(name="sellprice", precision=17, scale=17) ), 
        @AttributeOverride(name="discount", column=@Column(name="discount", precision=8, scale=8) ), 
        @AttributeOverride(name="unit", column=@Column(name="unit", length=5) ), 
        @AttributeOverride(name="projectId", column=@Column(name="project_id") ), 
        @AttributeOverride(name="reqdate", column=@Column(name="reqdate", length=13) ), 
        @AttributeOverride(name="ship", column=@Column(name="ship", precision=17, scale=17) ), 
        @AttributeOverride(name="serialnumber", column=@Column(name="serialnumber") ), 
        @AttributeOverride(name="itemnotes", column=@Column(name="itemnotes") ), 
        @AttributeOverride(name="lineitemdetail", column=@Column(name="lineitemdetail") ), 
        @AttributeOverride(name="ordernumber", column=@Column(name="ordernumber") ), 
        @AttributeOverride(name="ponumber", column=@Column(name="ponumber") ), 
        @AttributeOverride(name="newcost", column=@Column(name="newcost", precision=10) ), 
        @AttributeOverride(name="sellprice2", column=@Column(name="sellprice2", precision=10) ), 
        @AttributeOverride(name="lotnum", column=@Column(name="lotnum") ), 
        @AttributeOverride(name="expiry", column=@Column(name="expiry", length=13) ), 
        @AttributeOverride(name="warehouseId", column=@Column(name="warehouse_id") ), 
        @AttributeOverride(name="internalFreight", column=@Column(name="internal_freight", precision=12) ), 
        @AttributeOverride(name="fobPrice", column=@Column(name="fob_price", precision=12) ), 
        @AttributeOverride(name="shippingFreight", column=@Column(name="shipping_freight", precision=12) ), 
        @AttributeOverride(name="shippingInsurance", column=@Column(name="shipping_insurance", precision=12) ), 
        @AttributeOverride(name="cifPrice", column=@Column(name="cif_price", precision=12) ), 
        @AttributeOverride(name="advaloren", column=@Column(name="advaloren", precision=12) ), 
        @AttributeOverride(name="fodinfa", column=@Column(name="fodinfa", precision=12) ), 
        @AttributeOverride(name="customsPrice", column=@Column(name="customs_price", precision=12) ), 
        @AttributeOverride(name="totalExpenses", column=@Column(name="total_expenses", precision=12) ), 
        @AttributeOverride(name="warehousePrice", column=@Column(name="warehouse_price", precision=12) ), 
        @AttributeOverride(name="cb2", column=@Column(name="cb2") ) } )
    public OrderitemsId getId() {
        return this.id;
    }
    
    public void setId(OrderitemsId id) {
        this.id = id;
    }




}


