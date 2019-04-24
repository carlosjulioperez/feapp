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
 * Parts por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="parts",schema="public")
public class Parts  implements java.io.Serializable
 {


     private PartsId id;

    public Parts() {
    }

    public Parts(PartsId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id") ), 
        @AttributeOverride(name="partnumber", column=@Column(name="partnumber") ), 
        @AttributeOverride(name="description", column=@Column(name="description") ), 
        @AttributeOverride(name="unit", column=@Column(name="unit", length=5) ), 
        @AttributeOverride(name="listprice", column=@Column(name="listprice", precision=17, scale=17) ), 
        @AttributeOverride(name="sellprice", column=@Column(name="sellprice", precision=17, scale=17) ), 
        @AttributeOverride(name="lastcost", column=@Column(name="lastcost", precision=17, scale=17) ), 
        @AttributeOverride(name="priceupdate", column=@Column(name="priceupdate", length=13) ), 
        @AttributeOverride(name="weight", column=@Column(name="weight", precision=17, scale=17) ), 
        @AttributeOverride(name="onhand", column=@Column(name="onhand", precision=17, scale=17) ), 
        @AttributeOverride(name="notes", column=@Column(name="notes") ), 
        @AttributeOverride(name="makemodel", column=@Column(name="makemodel") ), 
        @AttributeOverride(name="assembly", column=@Column(name="assembly") ), 
        @AttributeOverride(name="alternate", column=@Column(name="alternate") ), 
        @AttributeOverride(name="rop", column=@Column(name="rop", precision=17, scale=17) ), 
        @AttributeOverride(name="inventoryAccnoId", column=@Column(name="inventory_accno_id") ), 
        @AttributeOverride(name="incomeAccnoId", column=@Column(name="income_accno_id") ), 
        @AttributeOverride(name="expenseAccnoId", column=@Column(name="expense_accno_id") ), 
        @AttributeOverride(name="bin", column=@Column(name="bin") ), 
        @AttributeOverride(name="obsolete", column=@Column(name="obsolete") ), 
        @AttributeOverride(name="bom", column=@Column(name="bom") ), 
        @AttributeOverride(name="image", column=@Column(name="image") ), 
        @AttributeOverride(name="drawing", column=@Column(name="drawing") ), 
        @AttributeOverride(name="microfiche", column=@Column(name="microfiche") ), 
        @AttributeOverride(name="partsgroupId", column=@Column(name="partsgroup_id") ), 
        @AttributeOverride(name="projectId", column=@Column(name="project_id") ), 
        @AttributeOverride(name="avgcost", column=@Column(name="avgcost", precision=17, scale=17) ), 
        @AttributeOverride(name="tariffHscode", column=@Column(name="tariff_hscode") ), 
        @AttributeOverride(name="countryorigin", column=@Column(name="countryorigin") ), 
        @AttributeOverride(name="barcode", column=@Column(name="barcode") ), 
        @AttributeOverride(name="toolnumber", column=@Column(name="toolnumber") ), 
        @AttributeOverride(name="uselots", column=@Column(name="uselots", length=1) ), 
        @AttributeOverride(name="partnumber2", column=@Column(name="partnumber2") ), 
        @AttributeOverride(name="fodinfa", column=@Column(name="fodinfa", precision=5) ), 
        @AttributeOverride(name="advaloren", column=@Column(name="advaloren", precision=5) ) } )
    public PartsId getId() {
        return this.id;
    }
    
    public void setId(PartsId id) {
        this.id = id;
    }




}


