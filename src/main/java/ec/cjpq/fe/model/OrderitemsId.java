package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OrderitemsId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class OrderitemsId  implements java.io.Serializable
 {


     private Integer id;
     private Integer transId;
     private Integer partsId;
     private String description;
     private Double qty;
     private Double sellprice;
     private Float discount;
     private String unit;
     private Integer projectId;
     private Date reqdate;
     private Double ship;
     private String serialnumber;
     private String itemnotes;
     private Boolean lineitemdetail;
     private String ordernumber;
     private String ponumber;
     private BigDecimal newcost;
     private BigDecimal sellprice2;
     private String lotnum;
     private Date expiry;
     private Integer warehouseId;
     private BigDecimal internalFreight;
     private BigDecimal fobPrice;
     private BigDecimal shippingFreight;
     private BigDecimal shippingInsurance;
     private BigDecimal cifPrice;
     private BigDecimal advaloren;
     private BigDecimal fodinfa;
     private BigDecimal customsPrice;
     private BigDecimal totalExpenses;
     private BigDecimal warehousePrice;
     private Boolean cb2;

    public OrderitemsId() {
    }

    public OrderitemsId(Integer id, Integer transId, Integer partsId, String description, Double qty, Double sellprice, Float discount, String unit, Integer projectId, Date reqdate, Double ship, String serialnumber, String itemnotes, Boolean lineitemdetail, String ordernumber, String ponumber, BigDecimal newcost, BigDecimal sellprice2, String lotnum, Date expiry, Integer warehouseId, BigDecimal internalFreight, BigDecimal fobPrice, BigDecimal shippingFreight, BigDecimal shippingInsurance, BigDecimal cifPrice, BigDecimal advaloren, BigDecimal fodinfa, BigDecimal customsPrice, BigDecimal totalExpenses, BigDecimal warehousePrice, Boolean cb2) {
       this.id = id;
       this.transId = transId;
       this.partsId = partsId;
       this.description = description;
       this.qty = qty;
       this.sellprice = sellprice;
       this.discount = discount;
       this.unit = unit;
       this.projectId = projectId;
       this.reqdate = reqdate;
       this.ship = ship;
       this.serialnumber = serialnumber;
       this.itemnotes = itemnotes;
       this.lineitemdetail = lineitemdetail;
       this.ordernumber = ordernumber;
       this.ponumber = ponumber;
       this.newcost = newcost;
       this.sellprice2 = sellprice2;
       this.lotnum = lotnum;
       this.expiry = expiry;
       this.warehouseId = warehouseId;
       this.internalFreight = internalFreight;
       this.fobPrice = fobPrice;
       this.shippingFreight = shippingFreight;
       this.shippingInsurance = shippingInsurance;
       this.cifPrice = cifPrice;
       this.advaloren = advaloren;
       this.fodinfa = fodinfa;
       this.customsPrice = customsPrice;
       this.totalExpenses = totalExpenses;
       this.warehousePrice = warehousePrice;
       this.cb2 = cb2;
    }
   


    @Column(name="id")
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name="trans_id")
    public Integer getTransId() {
        return this.transId;
    }
    
    public void setTransId(Integer transId) {
        this.transId = transId;
    }


    @Column(name="parts_id")
    public Integer getPartsId() {
        return this.partsId;
    }
    
    public void setPartsId(Integer partsId) {
        this.partsId = partsId;
    }


    @Column(name="description")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }


    @Column(name="qty", precision=17, scale=17)
    public Double getQty() {
        return this.qty;
    }
    
    public void setQty(Double qty) {
        this.qty = qty;
    }


    @Column(name="sellprice", precision=17, scale=17)
    public Double getSellprice() {
        return this.sellprice;
    }
    
    public void setSellprice(Double sellprice) {
        this.sellprice = sellprice;
    }


    @Column(name="discount", precision=8, scale=8)
    public Float getDiscount() {
        return this.discount;
    }
    
    public void setDiscount(Float discount) {
        this.discount = discount;
    }


    @Column(name="unit", length=5)
    public String getUnit() {
        return this.unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }


    @Column(name="project_id")
    public Integer getProjectId() {
        return this.projectId;
    }
    
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }


    @Column(name="reqdate", length=13)
    public Date getReqdate() {
        return this.reqdate;
    }
    
    public void setReqdate(Date reqdate) {
        this.reqdate = reqdate;
    }


    @Column(name="ship", precision=17, scale=17)
    public Double getShip() {
        return this.ship;
    }
    
    public void setShip(Double ship) {
        this.ship = ship;
    }


    @Column(name="serialnumber")
    public String getSerialnumber() {
        return this.serialnumber;
    }
    
    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }


    @Column(name="itemnotes")
    public String getItemnotes() {
        return this.itemnotes;
    }
    
    public void setItemnotes(String itemnotes) {
        this.itemnotes = itemnotes;
    }


    @Column(name="lineitemdetail")
    public Boolean getLineitemdetail() {
        return this.lineitemdetail;
    }
    
    public void setLineitemdetail(Boolean lineitemdetail) {
        this.lineitemdetail = lineitemdetail;
    }


    @Column(name="ordernumber")
    public String getOrdernumber() {
        return this.ordernumber;
    }
    
    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }


    @Column(name="ponumber")
    public String getPonumber() {
        return this.ponumber;
    }
    
    public void setPonumber(String ponumber) {
        this.ponumber = ponumber;
    }


    @Column(name="newcost", precision=10)
    public BigDecimal getNewcost() {
        return this.newcost;
    }
    
    public void setNewcost(BigDecimal newcost) {
        this.newcost = newcost;
    }


    @Column(name="sellprice2", precision=10)
    public BigDecimal getSellprice2() {
        return this.sellprice2;
    }
    
    public void setSellprice2(BigDecimal sellprice2) {
        this.sellprice2 = sellprice2;
    }


    @Column(name="lotnum")
    public String getLotnum() {
        return this.lotnum;
    }
    
    public void setLotnum(String lotnum) {
        this.lotnum = lotnum;
    }


    @Column(name="expiry", length=13)
    public Date getExpiry() {
        return this.expiry;
    }
    
    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }


    @Column(name="warehouse_id")
    public Integer getWarehouseId() {
        return this.warehouseId;
    }
    
    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }


    @Column(name="internal_freight", precision=12)
    public BigDecimal getInternalFreight() {
        return this.internalFreight;
    }
    
    public void setInternalFreight(BigDecimal internalFreight) {
        this.internalFreight = internalFreight;
    }


    @Column(name="fob_price", precision=12)
    public BigDecimal getFobPrice() {
        return this.fobPrice;
    }
    
    public void setFobPrice(BigDecimal fobPrice) {
        this.fobPrice = fobPrice;
    }


    @Column(name="shipping_freight", precision=12)
    public BigDecimal getShippingFreight() {
        return this.shippingFreight;
    }
    
    public void setShippingFreight(BigDecimal shippingFreight) {
        this.shippingFreight = shippingFreight;
    }


    @Column(name="shipping_insurance", precision=12)
    public BigDecimal getShippingInsurance() {
        return this.shippingInsurance;
    }
    
    public void setShippingInsurance(BigDecimal shippingInsurance) {
        this.shippingInsurance = shippingInsurance;
    }


    @Column(name="cif_price", precision=12)
    public BigDecimal getCifPrice() {
        return this.cifPrice;
    }
    
    public void setCifPrice(BigDecimal cifPrice) {
        this.cifPrice = cifPrice;
    }


    @Column(name="advaloren", precision=12)
    public BigDecimal getAdvaloren() {
        return this.advaloren;
    }
    
    public void setAdvaloren(BigDecimal advaloren) {
        this.advaloren = advaloren;
    }


    @Column(name="fodinfa", precision=12)
    public BigDecimal getFodinfa() {
        return this.fodinfa;
    }
    
    public void setFodinfa(BigDecimal fodinfa) {
        this.fodinfa = fodinfa;
    }


    @Column(name="customs_price", precision=12)
    public BigDecimal getCustomsPrice() {
        return this.customsPrice;
    }
    
    public void setCustomsPrice(BigDecimal customsPrice) {
        this.customsPrice = customsPrice;
    }


    @Column(name="total_expenses", precision=12)
    public BigDecimal getTotalExpenses() {
        return this.totalExpenses;
    }
    
    public void setTotalExpenses(BigDecimal totalExpenses) {
        this.totalExpenses = totalExpenses;
    }


    @Column(name="warehouse_price", precision=12)
    public BigDecimal getWarehousePrice() {
        return this.warehousePrice;
    }
    
    public void setWarehousePrice(BigDecimal warehousePrice) {
        this.warehousePrice = warehousePrice;
    }


    @Column(name="cb2")
    public Boolean getCb2() {
        return this.cb2;
    }
    
    public void setCb2(Boolean cb2) {
        this.cb2 = cb2;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof OrderitemsId) ) return false;
		 OrderitemsId castOther = ( OrderitemsId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getTransId()==castOther.getTransId()) || ( this.getTransId()!=null && castOther.getTransId()!=null && this.getTransId().equals(castOther.getTransId()) ) )
 && ( (this.getPartsId()==castOther.getPartsId()) || ( this.getPartsId()!=null && castOther.getPartsId()!=null && this.getPartsId().equals(castOther.getPartsId()) ) )
 && ( (this.getDescription()==castOther.getDescription()) || ( this.getDescription()!=null && castOther.getDescription()!=null && this.getDescription().equals(castOther.getDescription()) ) )
 && ( (this.getQty()==castOther.getQty()) || ( this.getQty()!=null && castOther.getQty()!=null && this.getQty().equals(castOther.getQty()) ) )
 && ( (this.getSellprice()==castOther.getSellprice()) || ( this.getSellprice()!=null && castOther.getSellprice()!=null && this.getSellprice().equals(castOther.getSellprice()) ) )
 && ( (this.getDiscount()==castOther.getDiscount()) || ( this.getDiscount()!=null && castOther.getDiscount()!=null && this.getDiscount().equals(castOther.getDiscount()) ) )
 && ( (this.getUnit()==castOther.getUnit()) || ( this.getUnit()!=null && castOther.getUnit()!=null && this.getUnit().equals(castOther.getUnit()) ) )
 && ( (this.getProjectId()==castOther.getProjectId()) || ( this.getProjectId()!=null && castOther.getProjectId()!=null && this.getProjectId().equals(castOther.getProjectId()) ) )
 && ( (this.getReqdate()==castOther.getReqdate()) || ( this.getReqdate()!=null && castOther.getReqdate()!=null && this.getReqdate().equals(castOther.getReqdate()) ) )
 && ( (this.getShip()==castOther.getShip()) || ( this.getShip()!=null && castOther.getShip()!=null && this.getShip().equals(castOther.getShip()) ) )
 && ( (this.getSerialnumber()==castOther.getSerialnumber()) || ( this.getSerialnumber()!=null && castOther.getSerialnumber()!=null && this.getSerialnumber().equals(castOther.getSerialnumber()) ) )
 && ( (this.getItemnotes()==castOther.getItemnotes()) || ( this.getItemnotes()!=null && castOther.getItemnotes()!=null && this.getItemnotes().equals(castOther.getItemnotes()) ) )
 && ( (this.getLineitemdetail()==castOther.getLineitemdetail()) || ( this.getLineitemdetail()!=null && castOther.getLineitemdetail()!=null && this.getLineitemdetail().equals(castOther.getLineitemdetail()) ) )
 && ( (this.getOrdernumber()==castOther.getOrdernumber()) || ( this.getOrdernumber()!=null && castOther.getOrdernumber()!=null && this.getOrdernumber().equals(castOther.getOrdernumber()) ) )
 && ( (this.getPonumber()==castOther.getPonumber()) || ( this.getPonumber()!=null && castOther.getPonumber()!=null && this.getPonumber().equals(castOther.getPonumber()) ) )
 && ( (this.getNewcost()==castOther.getNewcost()) || ( this.getNewcost()!=null && castOther.getNewcost()!=null && this.getNewcost().equals(castOther.getNewcost()) ) )
 && ( (this.getSellprice2()==castOther.getSellprice2()) || ( this.getSellprice2()!=null && castOther.getSellprice2()!=null && this.getSellprice2().equals(castOther.getSellprice2()) ) )
 && ( (this.getLotnum()==castOther.getLotnum()) || ( this.getLotnum()!=null && castOther.getLotnum()!=null && this.getLotnum().equals(castOther.getLotnum()) ) )
 && ( (this.getExpiry()==castOther.getExpiry()) || ( this.getExpiry()!=null && castOther.getExpiry()!=null && this.getExpiry().equals(castOther.getExpiry()) ) )
 && ( (this.getWarehouseId()==castOther.getWarehouseId()) || ( this.getWarehouseId()!=null && castOther.getWarehouseId()!=null && this.getWarehouseId().equals(castOther.getWarehouseId()) ) )
 && ( (this.getInternalFreight()==castOther.getInternalFreight()) || ( this.getInternalFreight()!=null && castOther.getInternalFreight()!=null && this.getInternalFreight().equals(castOther.getInternalFreight()) ) )
 && ( (this.getFobPrice()==castOther.getFobPrice()) || ( this.getFobPrice()!=null && castOther.getFobPrice()!=null && this.getFobPrice().equals(castOther.getFobPrice()) ) )
 && ( (this.getShippingFreight()==castOther.getShippingFreight()) || ( this.getShippingFreight()!=null && castOther.getShippingFreight()!=null && this.getShippingFreight().equals(castOther.getShippingFreight()) ) )
 && ( (this.getShippingInsurance()==castOther.getShippingInsurance()) || ( this.getShippingInsurance()!=null && castOther.getShippingInsurance()!=null && this.getShippingInsurance().equals(castOther.getShippingInsurance()) ) )
 && ( (this.getCifPrice()==castOther.getCifPrice()) || ( this.getCifPrice()!=null && castOther.getCifPrice()!=null && this.getCifPrice().equals(castOther.getCifPrice()) ) )
 && ( (this.getAdvaloren()==castOther.getAdvaloren()) || ( this.getAdvaloren()!=null && castOther.getAdvaloren()!=null && this.getAdvaloren().equals(castOther.getAdvaloren()) ) )
 && ( (this.getFodinfa()==castOther.getFodinfa()) || ( this.getFodinfa()!=null && castOther.getFodinfa()!=null && this.getFodinfa().equals(castOther.getFodinfa()) ) )
 && ( (this.getCustomsPrice()==castOther.getCustomsPrice()) || ( this.getCustomsPrice()!=null && castOther.getCustomsPrice()!=null && this.getCustomsPrice().equals(castOther.getCustomsPrice()) ) )
 && ( (this.getTotalExpenses()==castOther.getTotalExpenses()) || ( this.getTotalExpenses()!=null && castOther.getTotalExpenses()!=null && this.getTotalExpenses().equals(castOther.getTotalExpenses()) ) )
 && ( (this.getWarehousePrice()==castOther.getWarehousePrice()) || ( this.getWarehousePrice()!=null && castOther.getWarehousePrice()!=null && this.getWarehousePrice().equals(castOther.getWarehousePrice()) ) )
 && ( (this.getCb2()==castOther.getCb2()) || ( this.getCb2()!=null && castOther.getCb2()!=null && this.getCb2().equals(castOther.getCb2()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getTransId() == null ? 0 : this.getTransId().hashCode() );
         result = 37 * result + ( getPartsId() == null ? 0 : this.getPartsId().hashCode() );
         result = 37 * result + ( getDescription() == null ? 0 : this.getDescription().hashCode() );
         result = 37 * result + ( getQty() == null ? 0 : this.getQty().hashCode() );
         result = 37 * result + ( getSellprice() == null ? 0 : this.getSellprice().hashCode() );
         result = 37 * result + ( getDiscount() == null ? 0 : this.getDiscount().hashCode() );
         result = 37 * result + ( getUnit() == null ? 0 : this.getUnit().hashCode() );
         result = 37 * result + ( getProjectId() == null ? 0 : this.getProjectId().hashCode() );
         result = 37 * result + ( getReqdate() == null ? 0 : this.getReqdate().hashCode() );
         result = 37 * result + ( getShip() == null ? 0 : this.getShip().hashCode() );
         result = 37 * result + ( getSerialnumber() == null ? 0 : this.getSerialnumber().hashCode() );
         result = 37 * result + ( getItemnotes() == null ? 0 : this.getItemnotes().hashCode() );
         result = 37 * result + ( getLineitemdetail() == null ? 0 : this.getLineitemdetail().hashCode() );
         result = 37 * result + ( getOrdernumber() == null ? 0 : this.getOrdernumber().hashCode() );
         result = 37 * result + ( getPonumber() == null ? 0 : this.getPonumber().hashCode() );
         result = 37 * result + ( getNewcost() == null ? 0 : this.getNewcost().hashCode() );
         result = 37 * result + ( getSellprice2() == null ? 0 : this.getSellprice2().hashCode() );
         result = 37 * result + ( getLotnum() == null ? 0 : this.getLotnum().hashCode() );
         result = 37 * result + ( getExpiry() == null ? 0 : this.getExpiry().hashCode() );
         result = 37 * result + ( getWarehouseId() == null ? 0 : this.getWarehouseId().hashCode() );
         result = 37 * result + ( getInternalFreight() == null ? 0 : this.getInternalFreight().hashCode() );
         result = 37 * result + ( getFobPrice() == null ? 0 : this.getFobPrice().hashCode() );
         result = 37 * result + ( getShippingFreight() == null ? 0 : this.getShippingFreight().hashCode() );
         result = 37 * result + ( getShippingInsurance() == null ? 0 : this.getShippingInsurance().hashCode() );
         result = 37 * result + ( getCifPrice() == null ? 0 : this.getCifPrice().hashCode() );
         result = 37 * result + ( getAdvaloren() == null ? 0 : this.getAdvaloren().hashCode() );
         result = 37 * result + ( getFodinfa() == null ? 0 : this.getFodinfa().hashCode() );
         result = 37 * result + ( getCustomsPrice() == null ? 0 : this.getCustomsPrice().hashCode() );
         result = 37 * result + ( getTotalExpenses() == null ? 0 : this.getTotalExpenses().hashCode() );
         result = 37 * result + ( getWarehousePrice() == null ? 0 : this.getWarehousePrice().hashCode() );
         result = 37 * result + ( getCb2() == null ? 0 : this.getCb2().hashCode() );
         return result;
   }   


}


