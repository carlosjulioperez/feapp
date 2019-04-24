package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * InvoiceId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class InvoiceId  implements java.io.Serializable
 {


     private Integer id;
     private Integer transId;
     private Integer partsId;
     private String description;
     private Double qty;
     private Double allocated;
     private Double sellprice;
     private Double fxsellprice;
     private Float discount;
     private Boolean assemblyitem;
     private String unit;
     private Integer projectId;
     private Date deliverydate;
     private String serialnumber;
     private String itemnotes;
     private Boolean lineitemdetail;
     private Date transdate;
     private Double lastcost;
     private Integer warehouseId;
     private String ordernumber;
     private String ponumber;
     private Character linetype;
     private String lotnum;
     private Date expiry;
     private Double cogs;

    public InvoiceId() {
    }

    public InvoiceId(Integer id, Integer transId, Integer partsId, String description, Double qty, Double allocated, Double sellprice, Double fxsellprice, Float discount, Boolean assemblyitem, String unit, Integer projectId, Date deliverydate, String serialnumber, String itemnotes, Boolean lineitemdetail, Date transdate, Double lastcost, Integer warehouseId, String ordernumber, String ponumber, Character linetype, String lotnum, Date expiry, Double cogs) {
       this.id = id;
       this.transId = transId;
       this.partsId = partsId;
       this.description = description;
       this.qty = qty;
       this.allocated = allocated;
       this.sellprice = sellprice;
       this.fxsellprice = fxsellprice;
       this.discount = discount;
       this.assemblyitem = assemblyitem;
       this.unit = unit;
       this.projectId = projectId;
       this.deliverydate = deliverydate;
       this.serialnumber = serialnumber;
       this.itemnotes = itemnotes;
       this.lineitemdetail = lineitemdetail;
       this.transdate = transdate;
       this.lastcost = lastcost;
       this.warehouseId = warehouseId;
       this.ordernumber = ordernumber;
       this.ponumber = ponumber;
       this.linetype = linetype;
       this.lotnum = lotnum;
       this.expiry = expiry;
       this.cogs = cogs;
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


    @Column(name="allocated", precision=17, scale=17)
    public Double getAllocated() {
        return this.allocated;
    }
    
    public void setAllocated(Double allocated) {
        this.allocated = allocated;
    }


    @Column(name="sellprice", precision=17, scale=17)
    public Double getSellprice() {
        return this.sellprice;
    }
    
    public void setSellprice(Double sellprice) {
        this.sellprice = sellprice;
    }


    @Column(name="fxsellprice", precision=17, scale=17)
    public Double getFxsellprice() {
        return this.fxsellprice;
    }
    
    public void setFxsellprice(Double fxsellprice) {
        this.fxsellprice = fxsellprice;
    }


    @Column(name="discount", precision=8, scale=8)
    public Float getDiscount() {
        return this.discount;
    }
    
    public void setDiscount(Float discount) {
        this.discount = discount;
    }


    @Column(name="assemblyitem")
    public Boolean getAssemblyitem() {
        return this.assemblyitem;
    }
    
    public void setAssemblyitem(Boolean assemblyitem) {
        this.assemblyitem = assemblyitem;
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


    @Column(name="deliverydate", length=13)
    public Date getDeliverydate() {
        return this.deliverydate;
    }
    
    public void setDeliverydate(Date deliverydate) {
        this.deliverydate = deliverydate;
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


    @Column(name="transdate", length=13)
    public Date getTransdate() {
        return this.transdate;
    }
    
    public void setTransdate(Date transdate) {
        this.transdate = transdate;
    }


    @Column(name="lastcost", precision=17, scale=17)
    public Double getLastcost() {
        return this.lastcost;
    }
    
    public void setLastcost(Double lastcost) {
        this.lastcost = lastcost;
    }


    @Column(name="warehouse_id")
    public Integer getWarehouseId() {
        return this.warehouseId;
    }
    
    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
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


    @Column(name="linetype", length=1)
    public Character getLinetype() {
        return this.linetype;
    }
    
    public void setLinetype(Character linetype) {
        this.linetype = linetype;
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


    @Column(name="cogs", precision=17, scale=17)
    public Double getCogs() {
        return this.cogs;
    }
    
    public void setCogs(Double cogs) {
        this.cogs = cogs;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof InvoiceId) ) return false;
		 InvoiceId castOther = ( InvoiceId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getTransId()==castOther.getTransId()) || ( this.getTransId()!=null && castOther.getTransId()!=null && this.getTransId().equals(castOther.getTransId()) ) )
 && ( (this.getPartsId()==castOther.getPartsId()) || ( this.getPartsId()!=null && castOther.getPartsId()!=null && this.getPartsId().equals(castOther.getPartsId()) ) )
 && ( (this.getDescription()==castOther.getDescription()) || ( this.getDescription()!=null && castOther.getDescription()!=null && this.getDescription().equals(castOther.getDescription()) ) )
 && ( (this.getQty()==castOther.getQty()) || ( this.getQty()!=null && castOther.getQty()!=null && this.getQty().equals(castOther.getQty()) ) )
 && ( (this.getAllocated()==castOther.getAllocated()) || ( this.getAllocated()!=null && castOther.getAllocated()!=null && this.getAllocated().equals(castOther.getAllocated()) ) )
 && ( (this.getSellprice()==castOther.getSellprice()) || ( this.getSellprice()!=null && castOther.getSellprice()!=null && this.getSellprice().equals(castOther.getSellprice()) ) )
 && ( (this.getFxsellprice()==castOther.getFxsellprice()) || ( this.getFxsellprice()!=null && castOther.getFxsellprice()!=null && this.getFxsellprice().equals(castOther.getFxsellprice()) ) )
 && ( (this.getDiscount()==castOther.getDiscount()) || ( this.getDiscount()!=null && castOther.getDiscount()!=null && this.getDiscount().equals(castOther.getDiscount()) ) )
 && ( (this.getAssemblyitem()==castOther.getAssemblyitem()) || ( this.getAssemblyitem()!=null && castOther.getAssemblyitem()!=null && this.getAssemblyitem().equals(castOther.getAssemblyitem()) ) )
 && ( (this.getUnit()==castOther.getUnit()) || ( this.getUnit()!=null && castOther.getUnit()!=null && this.getUnit().equals(castOther.getUnit()) ) )
 && ( (this.getProjectId()==castOther.getProjectId()) || ( this.getProjectId()!=null && castOther.getProjectId()!=null && this.getProjectId().equals(castOther.getProjectId()) ) )
 && ( (this.getDeliverydate()==castOther.getDeliverydate()) || ( this.getDeliverydate()!=null && castOther.getDeliverydate()!=null && this.getDeliverydate().equals(castOther.getDeliverydate()) ) )
 && ( (this.getSerialnumber()==castOther.getSerialnumber()) || ( this.getSerialnumber()!=null && castOther.getSerialnumber()!=null && this.getSerialnumber().equals(castOther.getSerialnumber()) ) )
 && ( (this.getItemnotes()==castOther.getItemnotes()) || ( this.getItemnotes()!=null && castOther.getItemnotes()!=null && this.getItemnotes().equals(castOther.getItemnotes()) ) )
 && ( (this.getLineitemdetail()==castOther.getLineitemdetail()) || ( this.getLineitemdetail()!=null && castOther.getLineitemdetail()!=null && this.getLineitemdetail().equals(castOther.getLineitemdetail()) ) )
 && ( (this.getTransdate()==castOther.getTransdate()) || ( this.getTransdate()!=null && castOther.getTransdate()!=null && this.getTransdate().equals(castOther.getTransdate()) ) )
 && ( (this.getLastcost()==castOther.getLastcost()) || ( this.getLastcost()!=null && castOther.getLastcost()!=null && this.getLastcost().equals(castOther.getLastcost()) ) )
 && ( (this.getWarehouseId()==castOther.getWarehouseId()) || ( this.getWarehouseId()!=null && castOther.getWarehouseId()!=null && this.getWarehouseId().equals(castOther.getWarehouseId()) ) )
 && ( (this.getOrdernumber()==castOther.getOrdernumber()) || ( this.getOrdernumber()!=null && castOther.getOrdernumber()!=null && this.getOrdernumber().equals(castOther.getOrdernumber()) ) )
 && ( (this.getPonumber()==castOther.getPonumber()) || ( this.getPonumber()!=null && castOther.getPonumber()!=null && this.getPonumber().equals(castOther.getPonumber()) ) )
 && ( (this.getLinetype()==castOther.getLinetype()) || ( this.getLinetype()!=null && castOther.getLinetype()!=null && this.getLinetype().equals(castOther.getLinetype()) ) )
 && ( (this.getLotnum()==castOther.getLotnum()) || ( this.getLotnum()!=null && castOther.getLotnum()!=null && this.getLotnum().equals(castOther.getLotnum()) ) )
 && ( (this.getExpiry()==castOther.getExpiry()) || ( this.getExpiry()!=null && castOther.getExpiry()!=null && this.getExpiry().equals(castOther.getExpiry()) ) )
 && ( (this.getCogs()==castOther.getCogs()) || ( this.getCogs()!=null && castOther.getCogs()!=null && this.getCogs().equals(castOther.getCogs()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getTransId() == null ? 0 : this.getTransId().hashCode() );
         result = 37 * result + ( getPartsId() == null ? 0 : this.getPartsId().hashCode() );
         result = 37 * result + ( getDescription() == null ? 0 : this.getDescription().hashCode() );
         result = 37 * result + ( getQty() == null ? 0 : this.getQty().hashCode() );
         result = 37 * result + ( getAllocated() == null ? 0 : this.getAllocated().hashCode() );
         result = 37 * result + ( getSellprice() == null ? 0 : this.getSellprice().hashCode() );
         result = 37 * result + ( getFxsellprice() == null ? 0 : this.getFxsellprice().hashCode() );
         result = 37 * result + ( getDiscount() == null ? 0 : this.getDiscount().hashCode() );
         result = 37 * result + ( getAssemblyitem() == null ? 0 : this.getAssemblyitem().hashCode() );
         result = 37 * result + ( getUnit() == null ? 0 : this.getUnit().hashCode() );
         result = 37 * result + ( getProjectId() == null ? 0 : this.getProjectId().hashCode() );
         result = 37 * result + ( getDeliverydate() == null ? 0 : this.getDeliverydate().hashCode() );
         result = 37 * result + ( getSerialnumber() == null ? 0 : this.getSerialnumber().hashCode() );
         result = 37 * result + ( getItemnotes() == null ? 0 : this.getItemnotes().hashCode() );
         result = 37 * result + ( getLineitemdetail() == null ? 0 : this.getLineitemdetail().hashCode() );
         result = 37 * result + ( getTransdate() == null ? 0 : this.getTransdate().hashCode() );
         result = 37 * result + ( getLastcost() == null ? 0 : this.getLastcost().hashCode() );
         result = 37 * result + ( getWarehouseId() == null ? 0 : this.getWarehouseId().hashCode() );
         result = 37 * result + ( getOrdernumber() == null ? 0 : this.getOrdernumber().hashCode() );
         result = 37 * result + ( getPonumber() == null ? 0 : this.getPonumber().hashCode() );
         result = 37 * result + ( getLinetype() == null ? 0 : this.getLinetype().hashCode() );
         result = 37 * result + ( getLotnum() == null ? 0 : this.getLotnum().hashCode() );
         result = 37 * result + ( getExpiry() == null ? 0 : this.getExpiry().hashCode() );
         result = 37 * result + ( getCogs() == null ? 0 : this.getCogs().hashCode() );
         return result;
   }   


}


