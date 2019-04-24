package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * InventoryId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class InventoryId  implements java.io.Serializable
 {


     private Integer id;
     private Integer warehouseId;
     private Integer partsId;
     private Integer transId;
     private Integer orderitemsId;
     private Double qty;
     private Date shippingdate;
     private Integer employeeId;
     private Integer departmentId;
     private Integer warehouseId2;
     private String serialnumber;
     private String itemnotes;
     private Double cost;
     private Character linetype;
     private String description;
     private Integer invoiceId;
     private Double cogs;
     private String lotnum;
     private Date expiry;
     private String reporttype;

    public InventoryId() {
    }

    public InventoryId(Integer id, Integer warehouseId, Integer partsId, Integer transId, Integer orderitemsId, Double qty, Date shippingdate, Integer employeeId, Integer departmentId, Integer warehouseId2, String serialnumber, String itemnotes, Double cost, Character linetype, String description, Integer invoiceId, Double cogs, String lotnum, Date expiry, String reporttype) {
       this.id = id;
       this.warehouseId = warehouseId;
       this.partsId = partsId;
       this.transId = transId;
       this.orderitemsId = orderitemsId;
       this.qty = qty;
       this.shippingdate = shippingdate;
       this.employeeId = employeeId;
       this.departmentId = departmentId;
       this.warehouseId2 = warehouseId2;
       this.serialnumber = serialnumber;
       this.itemnotes = itemnotes;
       this.cost = cost;
       this.linetype = linetype;
       this.description = description;
       this.invoiceId = invoiceId;
       this.cogs = cogs;
       this.lotnum = lotnum;
       this.expiry = expiry;
       this.reporttype = reporttype;
    }
   


    @Column(name="id")
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name="warehouse_id")
    public Integer getWarehouseId() {
        return this.warehouseId;
    }
    
    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }


    @Column(name="parts_id")
    public Integer getPartsId() {
        return this.partsId;
    }
    
    public void setPartsId(Integer partsId) {
        this.partsId = partsId;
    }


    @Column(name="trans_id")
    public Integer getTransId() {
        return this.transId;
    }
    
    public void setTransId(Integer transId) {
        this.transId = transId;
    }


    @Column(name="orderitems_id")
    public Integer getOrderitemsId() {
        return this.orderitemsId;
    }
    
    public void setOrderitemsId(Integer orderitemsId) {
        this.orderitemsId = orderitemsId;
    }


    @Column(name="qty", precision=17, scale=17)
    public Double getQty() {
        return this.qty;
    }
    
    public void setQty(Double qty) {
        this.qty = qty;
    }


    @Column(name="shippingdate", length=13)
    public Date getShippingdate() {
        return this.shippingdate;
    }
    
    public void setShippingdate(Date shippingdate) {
        this.shippingdate = shippingdate;
    }


    @Column(name="employee_id")
    public Integer getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }


    @Column(name="department_id")
    public Integer getDepartmentId() {
        return this.departmentId;
    }
    
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }


    @Column(name="warehouse_id2")
    public Integer getWarehouseId2() {
        return this.warehouseId2;
    }
    
    public void setWarehouseId2(Integer warehouseId2) {
        this.warehouseId2 = warehouseId2;
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


    @Column(name="cost", precision=17, scale=17)
    public Double getCost() {
        return this.cost;
    }
    
    public void setCost(Double cost) {
        this.cost = cost;
    }


    @Column(name="linetype", length=1)
    public Character getLinetype() {
        return this.linetype;
    }
    
    public void setLinetype(Character linetype) {
        this.linetype = linetype;
    }


    @Column(name="description")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }


    @Column(name="invoice_id")
    public Integer getInvoiceId() {
        return this.invoiceId;
    }
    
    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }


    @Column(name="cogs", precision=17, scale=17)
    public Double getCogs() {
        return this.cogs;
    }
    
    public void setCogs(Double cogs) {
        this.cogs = cogs;
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


    @Column(name="reporttype", length=3)
    public String getReporttype() {
        return this.reporttype;
    }
    
    public void setReporttype(String reporttype) {
        this.reporttype = reporttype;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof InventoryId) ) return false;
		 InventoryId castOther = ( InventoryId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getWarehouseId()==castOther.getWarehouseId()) || ( this.getWarehouseId()!=null && castOther.getWarehouseId()!=null && this.getWarehouseId().equals(castOther.getWarehouseId()) ) )
 && ( (this.getPartsId()==castOther.getPartsId()) || ( this.getPartsId()!=null && castOther.getPartsId()!=null && this.getPartsId().equals(castOther.getPartsId()) ) )
 && ( (this.getTransId()==castOther.getTransId()) || ( this.getTransId()!=null && castOther.getTransId()!=null && this.getTransId().equals(castOther.getTransId()) ) )
 && ( (this.getOrderitemsId()==castOther.getOrderitemsId()) || ( this.getOrderitemsId()!=null && castOther.getOrderitemsId()!=null && this.getOrderitemsId().equals(castOther.getOrderitemsId()) ) )
 && ( (this.getQty()==castOther.getQty()) || ( this.getQty()!=null && castOther.getQty()!=null && this.getQty().equals(castOther.getQty()) ) )
 && ( (this.getShippingdate()==castOther.getShippingdate()) || ( this.getShippingdate()!=null && castOther.getShippingdate()!=null && this.getShippingdate().equals(castOther.getShippingdate()) ) )
 && ( (this.getEmployeeId()==castOther.getEmployeeId()) || ( this.getEmployeeId()!=null && castOther.getEmployeeId()!=null && this.getEmployeeId().equals(castOther.getEmployeeId()) ) )
 && ( (this.getDepartmentId()==castOther.getDepartmentId()) || ( this.getDepartmentId()!=null && castOther.getDepartmentId()!=null && this.getDepartmentId().equals(castOther.getDepartmentId()) ) )
 && ( (this.getWarehouseId2()==castOther.getWarehouseId2()) || ( this.getWarehouseId2()!=null && castOther.getWarehouseId2()!=null && this.getWarehouseId2().equals(castOther.getWarehouseId2()) ) )
 && ( (this.getSerialnumber()==castOther.getSerialnumber()) || ( this.getSerialnumber()!=null && castOther.getSerialnumber()!=null && this.getSerialnumber().equals(castOther.getSerialnumber()) ) )
 && ( (this.getItemnotes()==castOther.getItemnotes()) || ( this.getItemnotes()!=null && castOther.getItemnotes()!=null && this.getItemnotes().equals(castOther.getItemnotes()) ) )
 && ( (this.getCost()==castOther.getCost()) || ( this.getCost()!=null && castOther.getCost()!=null && this.getCost().equals(castOther.getCost()) ) )
 && ( (this.getLinetype()==castOther.getLinetype()) || ( this.getLinetype()!=null && castOther.getLinetype()!=null && this.getLinetype().equals(castOther.getLinetype()) ) )
 && ( (this.getDescription()==castOther.getDescription()) || ( this.getDescription()!=null && castOther.getDescription()!=null && this.getDescription().equals(castOther.getDescription()) ) )
 && ( (this.getInvoiceId()==castOther.getInvoiceId()) || ( this.getInvoiceId()!=null && castOther.getInvoiceId()!=null && this.getInvoiceId().equals(castOther.getInvoiceId()) ) )
 && ( (this.getCogs()==castOther.getCogs()) || ( this.getCogs()!=null && castOther.getCogs()!=null && this.getCogs().equals(castOther.getCogs()) ) )
 && ( (this.getLotnum()==castOther.getLotnum()) || ( this.getLotnum()!=null && castOther.getLotnum()!=null && this.getLotnum().equals(castOther.getLotnum()) ) )
 && ( (this.getExpiry()==castOther.getExpiry()) || ( this.getExpiry()!=null && castOther.getExpiry()!=null && this.getExpiry().equals(castOther.getExpiry()) ) )
 && ( (this.getReporttype()==castOther.getReporttype()) || ( this.getReporttype()!=null && castOther.getReporttype()!=null && this.getReporttype().equals(castOther.getReporttype()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getWarehouseId() == null ? 0 : this.getWarehouseId().hashCode() );
         result = 37 * result + ( getPartsId() == null ? 0 : this.getPartsId().hashCode() );
         result = 37 * result + ( getTransId() == null ? 0 : this.getTransId().hashCode() );
         result = 37 * result + ( getOrderitemsId() == null ? 0 : this.getOrderitemsId().hashCode() );
         result = 37 * result + ( getQty() == null ? 0 : this.getQty().hashCode() );
         result = 37 * result + ( getShippingdate() == null ? 0 : this.getShippingdate().hashCode() );
         result = 37 * result + ( getEmployeeId() == null ? 0 : this.getEmployeeId().hashCode() );
         result = 37 * result + ( getDepartmentId() == null ? 0 : this.getDepartmentId().hashCode() );
         result = 37 * result + ( getWarehouseId2() == null ? 0 : this.getWarehouseId2().hashCode() );
         result = 37 * result + ( getSerialnumber() == null ? 0 : this.getSerialnumber().hashCode() );
         result = 37 * result + ( getItemnotes() == null ? 0 : this.getItemnotes().hashCode() );
         result = 37 * result + ( getCost() == null ? 0 : this.getCost().hashCode() );
         result = 37 * result + ( getLinetype() == null ? 0 : this.getLinetype().hashCode() );
         result = 37 * result + ( getDescription() == null ? 0 : this.getDescription().hashCode() );
         result = 37 * result + ( getInvoiceId() == null ? 0 : this.getInvoiceId().hashCode() );
         result = 37 * result + ( getCogs() == null ? 0 : this.getCogs().hashCode() );
         result = 37 * result + ( getLotnum() == null ? 0 : this.getLotnum().hashCode() );
         result = 37 * result + ( getExpiry() == null ? 0 : this.getExpiry().hashCode() );
         result = 37 * result + ( getReporttype() == null ? 0 : this.getReporttype().hashCode() );
         return result;
   }   


}


