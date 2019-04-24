package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OeId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class OeId  implements java.io.Serializable
 {


     private Integer id;
     private String ordnumber;
     private Date transdate;
     private Integer vendorId;
     private Integer customerId;
     private Double amount;
     private Double netamount;
     private Date reqdate;
     private Boolean taxincluded;
     private String shippingpoint;
     private String notes;
     private String curr;
     private Integer employeeId;
     private Boolean closed;
     private Boolean quotation;
     private String quonumber;
     private String intnotes;
     private Integer departmentId;
     private String shipvia;
     private String languageCode;
     private String ponumber;
     private Short terms;
     private String waybill;
     private Integer warehouseId;
     private String description;
     private Integer aaId;
     private Double exchangerate;
     private Integer ticketId;
     private BigDecimal internalFreight;
     private BigDecimal shippingFreight;
     private BigDecimal shippingInsurance;
     private BigDecimal airportExpenses;
     private BigDecimal localFreight;
     private BigDecimal otherExpenses;
     private BigDecimal totalExpenses;
     private BigDecimal totalCustoms;
     private BigDecimal netweight;
     private BigDecimal grossweight;

    public OeId() {
    }

    public OeId(Integer id, String ordnumber, Date transdate, Integer vendorId, Integer customerId, Double amount, Double netamount, Date reqdate, Boolean taxincluded, String shippingpoint, String notes, String curr, Integer employeeId, Boolean closed, Boolean quotation, String quonumber, String intnotes, Integer departmentId, String shipvia, String languageCode, String ponumber, Short terms, String waybill, Integer warehouseId, String description, Integer aaId, Double exchangerate, Integer ticketId, BigDecimal internalFreight, BigDecimal shippingFreight, BigDecimal shippingInsurance, BigDecimal airportExpenses, BigDecimal localFreight, BigDecimal otherExpenses, BigDecimal totalExpenses, BigDecimal totalCustoms, BigDecimal netweight, BigDecimal grossweight) {
       this.id = id;
       this.ordnumber = ordnumber;
       this.transdate = transdate;
       this.vendorId = vendorId;
       this.customerId = customerId;
       this.amount = amount;
       this.netamount = netamount;
       this.reqdate = reqdate;
       this.taxincluded = taxincluded;
       this.shippingpoint = shippingpoint;
       this.notes = notes;
       this.curr = curr;
       this.employeeId = employeeId;
       this.closed = closed;
       this.quotation = quotation;
       this.quonumber = quonumber;
       this.intnotes = intnotes;
       this.departmentId = departmentId;
       this.shipvia = shipvia;
       this.languageCode = languageCode;
       this.ponumber = ponumber;
       this.terms = terms;
       this.waybill = waybill;
       this.warehouseId = warehouseId;
       this.description = description;
       this.aaId = aaId;
       this.exchangerate = exchangerate;
       this.ticketId = ticketId;
       this.internalFreight = internalFreight;
       this.shippingFreight = shippingFreight;
       this.shippingInsurance = shippingInsurance;
       this.airportExpenses = airportExpenses;
       this.localFreight = localFreight;
       this.otherExpenses = otherExpenses;
       this.totalExpenses = totalExpenses;
       this.totalCustoms = totalCustoms;
       this.netweight = netweight;
       this.grossweight = grossweight;
    }
   


    @Column(name="id")
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name="ordnumber")
    public String getOrdnumber() {
        return this.ordnumber;
    }
    
    public void setOrdnumber(String ordnumber) {
        this.ordnumber = ordnumber;
    }


    @Column(name="transdate", length=13)
    public Date getTransdate() {
        return this.transdate;
    }
    
    public void setTransdate(Date transdate) {
        this.transdate = transdate;
    }


    @Column(name="vendor_id")
    public Integer getVendorId() {
        return this.vendorId;
    }
    
    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }


    @Column(name="customer_id")
    public Integer getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }


    @Column(name="amount", precision=17, scale=17)
    public Double getAmount() {
        return this.amount;
    }
    
    public void setAmount(Double amount) {
        this.amount = amount;
    }


    @Column(name="netamount", precision=17, scale=17)
    public Double getNetamount() {
        return this.netamount;
    }
    
    public void setNetamount(Double netamount) {
        this.netamount = netamount;
    }


    @Column(name="reqdate", length=13)
    public Date getReqdate() {
        return this.reqdate;
    }
    
    public void setReqdate(Date reqdate) {
        this.reqdate = reqdate;
    }


    @Column(name="taxincluded")
    public Boolean getTaxincluded() {
        return this.taxincluded;
    }
    
    public void setTaxincluded(Boolean taxincluded) {
        this.taxincluded = taxincluded;
    }


    @Column(name="shippingpoint")
    public String getShippingpoint() {
        return this.shippingpoint;
    }
    
    public void setShippingpoint(String shippingpoint) {
        this.shippingpoint = shippingpoint;
    }


    @Column(name="notes")
    public String getNotes() {
        return this.notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }


    @Column(name="curr", length=3)
    public String getCurr() {
        return this.curr;
    }
    
    public void setCurr(String curr) {
        this.curr = curr;
    }


    @Column(name="employee_id")
    public Integer getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }


    @Column(name="closed")
    public Boolean getClosed() {
        return this.closed;
    }
    
    public void setClosed(Boolean closed) {
        this.closed = closed;
    }


    @Column(name="quotation")
    public Boolean getQuotation() {
        return this.quotation;
    }
    
    public void setQuotation(Boolean quotation) {
        this.quotation = quotation;
    }


    @Column(name="quonumber")
    public String getQuonumber() {
        return this.quonumber;
    }
    
    public void setQuonumber(String quonumber) {
        this.quonumber = quonumber;
    }


    @Column(name="intnotes")
    public String getIntnotes() {
        return this.intnotes;
    }
    
    public void setIntnotes(String intnotes) {
        this.intnotes = intnotes;
    }


    @Column(name="department_id")
    public Integer getDepartmentId() {
        return this.departmentId;
    }
    
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }


    @Column(name="shipvia")
    public String getShipvia() {
        return this.shipvia;
    }
    
    public void setShipvia(String shipvia) {
        this.shipvia = shipvia;
    }


    @Column(name="language_code", length=6)
    public String getLanguageCode() {
        return this.languageCode;
    }
    
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }


    @Column(name="ponumber")
    public String getPonumber() {
        return this.ponumber;
    }
    
    public void setPonumber(String ponumber) {
        this.ponumber = ponumber;
    }


    @Column(name="terms")
    public Short getTerms() {
        return this.terms;
    }
    
    public void setTerms(Short terms) {
        this.terms = terms;
    }


    @Column(name="waybill")
    public String getWaybill() {
        return this.waybill;
    }
    
    public void setWaybill(String waybill) {
        this.waybill = waybill;
    }


    @Column(name="warehouse_id")
    public Integer getWarehouseId() {
        return this.warehouseId;
    }
    
    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }


    @Column(name="description")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }


    @Column(name="aa_id")
    public Integer getAaId() {
        return this.aaId;
    }
    
    public void setAaId(Integer aaId) {
        this.aaId = aaId;
    }


    @Column(name="exchangerate", precision=17, scale=17)
    public Double getExchangerate() {
        return this.exchangerate;
    }
    
    public void setExchangerate(Double exchangerate) {
        this.exchangerate = exchangerate;
    }


    @Column(name="ticket_id")
    public Integer getTicketId() {
        return this.ticketId;
    }
    
    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }


    @Column(name="internal_freight", precision=12)
    public BigDecimal getInternalFreight() {
        return this.internalFreight;
    }
    
    public void setInternalFreight(BigDecimal internalFreight) {
        this.internalFreight = internalFreight;
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


    @Column(name="airport_expenses", precision=12)
    public BigDecimal getAirportExpenses() {
        return this.airportExpenses;
    }
    
    public void setAirportExpenses(BigDecimal airportExpenses) {
        this.airportExpenses = airportExpenses;
    }


    @Column(name="local_freight", precision=12)
    public BigDecimal getLocalFreight() {
        return this.localFreight;
    }
    
    public void setLocalFreight(BigDecimal localFreight) {
        this.localFreight = localFreight;
    }


    @Column(name="other_expenses", precision=12)
    public BigDecimal getOtherExpenses() {
        return this.otherExpenses;
    }
    
    public void setOtherExpenses(BigDecimal otherExpenses) {
        this.otherExpenses = otherExpenses;
    }


    @Column(name="total_expenses", precision=12)
    public BigDecimal getTotalExpenses() {
        return this.totalExpenses;
    }
    
    public void setTotalExpenses(BigDecimal totalExpenses) {
        this.totalExpenses = totalExpenses;
    }


    @Column(name="total_customs", precision=12)
    public BigDecimal getTotalCustoms() {
        return this.totalCustoms;
    }
    
    public void setTotalCustoms(BigDecimal totalCustoms) {
        this.totalCustoms = totalCustoms;
    }


    @Column(name="netweight", precision=12)
    public BigDecimal getNetweight() {
        return this.netweight;
    }
    
    public void setNetweight(BigDecimal netweight) {
        this.netweight = netweight;
    }


    @Column(name="grossweight", precision=12)
    public BigDecimal getGrossweight() {
        return this.grossweight;
    }
    
    public void setGrossweight(BigDecimal grossweight) {
        this.grossweight = grossweight;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof OeId) ) return false;
		 OeId castOther = ( OeId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getOrdnumber()==castOther.getOrdnumber()) || ( this.getOrdnumber()!=null && castOther.getOrdnumber()!=null && this.getOrdnumber().equals(castOther.getOrdnumber()) ) )
 && ( (this.getTransdate()==castOther.getTransdate()) || ( this.getTransdate()!=null && castOther.getTransdate()!=null && this.getTransdate().equals(castOther.getTransdate()) ) )
 && ( (this.getVendorId()==castOther.getVendorId()) || ( this.getVendorId()!=null && castOther.getVendorId()!=null && this.getVendorId().equals(castOther.getVendorId()) ) )
 && ( (this.getCustomerId()==castOther.getCustomerId()) || ( this.getCustomerId()!=null && castOther.getCustomerId()!=null && this.getCustomerId().equals(castOther.getCustomerId()) ) )
 && ( (this.getAmount()==castOther.getAmount()) || ( this.getAmount()!=null && castOther.getAmount()!=null && this.getAmount().equals(castOther.getAmount()) ) )
 && ( (this.getNetamount()==castOther.getNetamount()) || ( this.getNetamount()!=null && castOther.getNetamount()!=null && this.getNetamount().equals(castOther.getNetamount()) ) )
 && ( (this.getReqdate()==castOther.getReqdate()) || ( this.getReqdate()!=null && castOther.getReqdate()!=null && this.getReqdate().equals(castOther.getReqdate()) ) )
 && ( (this.getTaxincluded()==castOther.getTaxincluded()) || ( this.getTaxincluded()!=null && castOther.getTaxincluded()!=null && this.getTaxincluded().equals(castOther.getTaxincluded()) ) )
 && ( (this.getShippingpoint()==castOther.getShippingpoint()) || ( this.getShippingpoint()!=null && castOther.getShippingpoint()!=null && this.getShippingpoint().equals(castOther.getShippingpoint()) ) )
 && ( (this.getNotes()==castOther.getNotes()) || ( this.getNotes()!=null && castOther.getNotes()!=null && this.getNotes().equals(castOther.getNotes()) ) )
 && ( (this.getCurr()==castOther.getCurr()) || ( this.getCurr()!=null && castOther.getCurr()!=null && this.getCurr().equals(castOther.getCurr()) ) )
 && ( (this.getEmployeeId()==castOther.getEmployeeId()) || ( this.getEmployeeId()!=null && castOther.getEmployeeId()!=null && this.getEmployeeId().equals(castOther.getEmployeeId()) ) )
 && ( (this.getClosed()==castOther.getClosed()) || ( this.getClosed()!=null && castOther.getClosed()!=null && this.getClosed().equals(castOther.getClosed()) ) )
 && ( (this.getQuotation()==castOther.getQuotation()) || ( this.getQuotation()!=null && castOther.getQuotation()!=null && this.getQuotation().equals(castOther.getQuotation()) ) )
 && ( (this.getQuonumber()==castOther.getQuonumber()) || ( this.getQuonumber()!=null && castOther.getQuonumber()!=null && this.getQuonumber().equals(castOther.getQuonumber()) ) )
 && ( (this.getIntnotes()==castOther.getIntnotes()) || ( this.getIntnotes()!=null && castOther.getIntnotes()!=null && this.getIntnotes().equals(castOther.getIntnotes()) ) )
 && ( (this.getDepartmentId()==castOther.getDepartmentId()) || ( this.getDepartmentId()!=null && castOther.getDepartmentId()!=null && this.getDepartmentId().equals(castOther.getDepartmentId()) ) )
 && ( (this.getShipvia()==castOther.getShipvia()) || ( this.getShipvia()!=null && castOther.getShipvia()!=null && this.getShipvia().equals(castOther.getShipvia()) ) )
 && ( (this.getLanguageCode()==castOther.getLanguageCode()) || ( this.getLanguageCode()!=null && castOther.getLanguageCode()!=null && this.getLanguageCode().equals(castOther.getLanguageCode()) ) )
 && ( (this.getPonumber()==castOther.getPonumber()) || ( this.getPonumber()!=null && castOther.getPonumber()!=null && this.getPonumber().equals(castOther.getPonumber()) ) )
 && ( (this.getTerms()==castOther.getTerms()) || ( this.getTerms()!=null && castOther.getTerms()!=null && this.getTerms().equals(castOther.getTerms()) ) )
 && ( (this.getWaybill()==castOther.getWaybill()) || ( this.getWaybill()!=null && castOther.getWaybill()!=null && this.getWaybill().equals(castOther.getWaybill()) ) )
 && ( (this.getWarehouseId()==castOther.getWarehouseId()) || ( this.getWarehouseId()!=null && castOther.getWarehouseId()!=null && this.getWarehouseId().equals(castOther.getWarehouseId()) ) )
 && ( (this.getDescription()==castOther.getDescription()) || ( this.getDescription()!=null && castOther.getDescription()!=null && this.getDescription().equals(castOther.getDescription()) ) )
 && ( (this.getAaId()==castOther.getAaId()) || ( this.getAaId()!=null && castOther.getAaId()!=null && this.getAaId().equals(castOther.getAaId()) ) )
 && ( (this.getExchangerate()==castOther.getExchangerate()) || ( this.getExchangerate()!=null && castOther.getExchangerate()!=null && this.getExchangerate().equals(castOther.getExchangerate()) ) )
 && ( (this.getTicketId()==castOther.getTicketId()) || ( this.getTicketId()!=null && castOther.getTicketId()!=null && this.getTicketId().equals(castOther.getTicketId()) ) )
 && ( (this.getInternalFreight()==castOther.getInternalFreight()) || ( this.getInternalFreight()!=null && castOther.getInternalFreight()!=null && this.getInternalFreight().equals(castOther.getInternalFreight()) ) )
 && ( (this.getShippingFreight()==castOther.getShippingFreight()) || ( this.getShippingFreight()!=null && castOther.getShippingFreight()!=null && this.getShippingFreight().equals(castOther.getShippingFreight()) ) )
 && ( (this.getShippingInsurance()==castOther.getShippingInsurance()) || ( this.getShippingInsurance()!=null && castOther.getShippingInsurance()!=null && this.getShippingInsurance().equals(castOther.getShippingInsurance()) ) )
 && ( (this.getAirportExpenses()==castOther.getAirportExpenses()) || ( this.getAirportExpenses()!=null && castOther.getAirportExpenses()!=null && this.getAirportExpenses().equals(castOther.getAirportExpenses()) ) )
 && ( (this.getLocalFreight()==castOther.getLocalFreight()) || ( this.getLocalFreight()!=null && castOther.getLocalFreight()!=null && this.getLocalFreight().equals(castOther.getLocalFreight()) ) )
 && ( (this.getOtherExpenses()==castOther.getOtherExpenses()) || ( this.getOtherExpenses()!=null && castOther.getOtherExpenses()!=null && this.getOtherExpenses().equals(castOther.getOtherExpenses()) ) )
 && ( (this.getTotalExpenses()==castOther.getTotalExpenses()) || ( this.getTotalExpenses()!=null && castOther.getTotalExpenses()!=null && this.getTotalExpenses().equals(castOther.getTotalExpenses()) ) )
 && ( (this.getTotalCustoms()==castOther.getTotalCustoms()) || ( this.getTotalCustoms()!=null && castOther.getTotalCustoms()!=null && this.getTotalCustoms().equals(castOther.getTotalCustoms()) ) )
 && ( (this.getNetweight()==castOther.getNetweight()) || ( this.getNetweight()!=null && castOther.getNetweight()!=null && this.getNetweight().equals(castOther.getNetweight()) ) )
 && ( (this.getGrossweight()==castOther.getGrossweight()) || ( this.getGrossweight()!=null && castOther.getGrossweight()!=null && this.getGrossweight().equals(castOther.getGrossweight()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getOrdnumber() == null ? 0 : this.getOrdnumber().hashCode() );
         result = 37 * result + ( getTransdate() == null ? 0 : this.getTransdate().hashCode() );
         result = 37 * result + ( getVendorId() == null ? 0 : this.getVendorId().hashCode() );
         result = 37 * result + ( getCustomerId() == null ? 0 : this.getCustomerId().hashCode() );
         result = 37 * result + ( getAmount() == null ? 0 : this.getAmount().hashCode() );
         result = 37 * result + ( getNetamount() == null ? 0 : this.getNetamount().hashCode() );
         result = 37 * result + ( getReqdate() == null ? 0 : this.getReqdate().hashCode() );
         result = 37 * result + ( getTaxincluded() == null ? 0 : this.getTaxincluded().hashCode() );
         result = 37 * result + ( getShippingpoint() == null ? 0 : this.getShippingpoint().hashCode() );
         result = 37 * result + ( getNotes() == null ? 0 : this.getNotes().hashCode() );
         result = 37 * result + ( getCurr() == null ? 0 : this.getCurr().hashCode() );
         result = 37 * result + ( getEmployeeId() == null ? 0 : this.getEmployeeId().hashCode() );
         result = 37 * result + ( getClosed() == null ? 0 : this.getClosed().hashCode() );
         result = 37 * result + ( getQuotation() == null ? 0 : this.getQuotation().hashCode() );
         result = 37 * result + ( getQuonumber() == null ? 0 : this.getQuonumber().hashCode() );
         result = 37 * result + ( getIntnotes() == null ? 0 : this.getIntnotes().hashCode() );
         result = 37 * result + ( getDepartmentId() == null ? 0 : this.getDepartmentId().hashCode() );
         result = 37 * result + ( getShipvia() == null ? 0 : this.getShipvia().hashCode() );
         result = 37 * result + ( getLanguageCode() == null ? 0 : this.getLanguageCode().hashCode() );
         result = 37 * result + ( getPonumber() == null ? 0 : this.getPonumber().hashCode() );
         result = 37 * result + ( getTerms() == null ? 0 : this.getTerms().hashCode() );
         result = 37 * result + ( getWaybill() == null ? 0 : this.getWaybill().hashCode() );
         result = 37 * result + ( getWarehouseId() == null ? 0 : this.getWarehouseId().hashCode() );
         result = 37 * result + ( getDescription() == null ? 0 : this.getDescription().hashCode() );
         result = 37 * result + ( getAaId() == null ? 0 : this.getAaId().hashCode() );
         result = 37 * result + ( getExchangerate() == null ? 0 : this.getExchangerate().hashCode() );
         result = 37 * result + ( getTicketId() == null ? 0 : this.getTicketId().hashCode() );
         result = 37 * result + ( getInternalFreight() == null ? 0 : this.getInternalFreight().hashCode() );
         result = 37 * result + ( getShippingFreight() == null ? 0 : this.getShippingFreight().hashCode() );
         result = 37 * result + ( getShippingInsurance() == null ? 0 : this.getShippingInsurance().hashCode() );
         result = 37 * result + ( getAirportExpenses() == null ? 0 : this.getAirportExpenses().hashCode() );
         result = 37 * result + ( getLocalFreight() == null ? 0 : this.getLocalFreight().hashCode() );
         result = 37 * result + ( getOtherExpenses() == null ? 0 : this.getOtherExpenses().hashCode() );
         result = 37 * result + ( getTotalExpenses() == null ? 0 : this.getTotalExpenses().hashCode() );
         result = 37 * result + ( getTotalCustoms() == null ? 0 : this.getTotalCustoms().hashCode() );
         result = 37 * result + ( getNetweight() == null ? 0 : this.getNetweight().hashCode() );
         result = 37 * result + ( getGrossweight() == null ? 0 : this.getGrossweight().hashCode() );
         return result;
   }   


}


