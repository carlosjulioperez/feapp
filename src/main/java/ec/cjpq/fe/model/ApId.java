package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ApId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class ApId  implements java.io.Serializable
 {


     private Integer id;
     private String invnumber;
     private Date transdate;
     private Integer vendorId;
     private Boolean taxincluded;
     private Double amount;
     private Double netamount;
     private Double paid;
     private Date datepaid;
     private Date duedate;
     private Boolean invoice;
     private String ordnumber;
     private String curr;
     private String notes;
     private Integer employeeId;
     private String till;
     private String quonumber;
     private String intnotes;
     private Integer departmentId;
     private String shipvia;
     private String languageCode;
     private String ponumber;
     private String shippingpoint;
     private Short terms;
     private Boolean approved;
     private Float cashdiscount;
     private Short discountterms;
     private String waybill;
     private Integer warehouseId;
     private String description;
     private Boolean onhold;
     private Double exchangerate;
     private String dcn;
     private Integer bankId;
     private Integer paymentmethodId;
     private Integer tipodocId;
     private Integer oldVendorId;
     private Integer ticketId;

    public ApId() {
    }

    public ApId(Integer id, String invnumber, Date transdate, Integer vendorId, Boolean taxincluded, Double amount, Double netamount, Double paid, Date datepaid, Date duedate, Boolean invoice, String ordnumber, String curr, String notes, Integer employeeId, String till, String quonumber, String intnotes, Integer departmentId, String shipvia, String languageCode, String ponumber, String shippingpoint, Short terms, Boolean approved, Float cashdiscount, Short discountterms, String waybill, Integer warehouseId, String description, Boolean onhold, Double exchangerate, String dcn, Integer bankId, Integer paymentmethodId, Integer tipodocId, Integer oldVendorId, Integer ticketId) {
       this.id = id;
       this.invnumber = invnumber;
       this.transdate = transdate;
       this.vendorId = vendorId;
       this.taxincluded = taxincluded;
       this.amount = amount;
       this.netamount = netamount;
       this.paid = paid;
       this.datepaid = datepaid;
       this.duedate = duedate;
       this.invoice = invoice;
       this.ordnumber = ordnumber;
       this.curr = curr;
       this.notes = notes;
       this.employeeId = employeeId;
       this.till = till;
       this.quonumber = quonumber;
       this.intnotes = intnotes;
       this.departmentId = departmentId;
       this.shipvia = shipvia;
       this.languageCode = languageCode;
       this.ponumber = ponumber;
       this.shippingpoint = shippingpoint;
       this.terms = terms;
       this.approved = approved;
       this.cashdiscount = cashdiscount;
       this.discountterms = discountterms;
       this.waybill = waybill;
       this.warehouseId = warehouseId;
       this.description = description;
       this.onhold = onhold;
       this.exchangerate = exchangerate;
       this.dcn = dcn;
       this.bankId = bankId;
       this.paymentmethodId = paymentmethodId;
       this.tipodocId = tipodocId;
       this.oldVendorId = oldVendorId;
       this.ticketId = ticketId;
    }
   


    @Column(name="id")
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name="invnumber")
    public String getInvnumber() {
        return this.invnumber;
    }
    
    public void setInvnumber(String invnumber) {
        this.invnumber = invnumber;
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


    @Column(name="taxincluded")
    public Boolean getTaxincluded() {
        return this.taxincluded;
    }
    
    public void setTaxincluded(Boolean taxincluded) {
        this.taxincluded = taxincluded;
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


    @Column(name="paid", precision=17, scale=17)
    public Double getPaid() {
        return this.paid;
    }
    
    public void setPaid(Double paid) {
        this.paid = paid;
    }


    @Column(name="datepaid", length=13)
    public Date getDatepaid() {
        return this.datepaid;
    }
    
    public void setDatepaid(Date datepaid) {
        this.datepaid = datepaid;
    }


    @Column(name="duedate", length=13)
    public Date getDuedate() {
        return this.duedate;
    }
    
    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }


    @Column(name="invoice")
    public Boolean getInvoice() {
        return this.invoice;
    }
    
    public void setInvoice(Boolean invoice) {
        this.invoice = invoice;
    }


    @Column(name="ordnumber")
    public String getOrdnumber() {
        return this.ordnumber;
    }
    
    public void setOrdnumber(String ordnumber) {
        this.ordnumber = ordnumber;
    }


    @Column(name="curr", length=3)
    public String getCurr() {
        return this.curr;
    }
    
    public void setCurr(String curr) {
        this.curr = curr;
    }


    @Column(name="notes")
    public String getNotes() {
        return this.notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }


    @Column(name="employee_id")
    public Integer getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }


    @Column(name="till", length=20)
    public String getTill() {
        return this.till;
    }
    
    public void setTill(String till) {
        this.till = till;
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


    @Column(name="shippingpoint")
    public String getShippingpoint() {
        return this.shippingpoint;
    }
    
    public void setShippingpoint(String shippingpoint) {
        this.shippingpoint = shippingpoint;
    }


    @Column(name="terms")
    public Short getTerms() {
        return this.terms;
    }
    
    public void setTerms(Short terms) {
        this.terms = terms;
    }


    @Column(name="approved")
    public Boolean getApproved() {
        return this.approved;
    }
    
    public void setApproved(Boolean approved) {
        this.approved = approved;
    }


    @Column(name="cashdiscount", precision=8, scale=8)
    public Float getCashdiscount() {
        return this.cashdiscount;
    }
    
    public void setCashdiscount(Float cashdiscount) {
        this.cashdiscount = cashdiscount;
    }


    @Column(name="discountterms")
    public Short getDiscountterms() {
        return this.discountterms;
    }
    
    public void setDiscountterms(Short discountterms) {
        this.discountterms = discountterms;
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


    @Column(name="onhold")
    public Boolean getOnhold() {
        return this.onhold;
    }
    
    public void setOnhold(Boolean onhold) {
        this.onhold = onhold;
    }


    @Column(name="exchangerate", precision=17, scale=17)
    public Double getExchangerate() {
        return this.exchangerate;
    }
    
    public void setExchangerate(Double exchangerate) {
        this.exchangerate = exchangerate;
    }


    @Column(name="dcn")
    public String getDcn() {
        return this.dcn;
    }
    
    public void setDcn(String dcn) {
        this.dcn = dcn;
    }


    @Column(name="bank_id")
    public Integer getBankId() {
        return this.bankId;
    }
    
    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }


    @Column(name="paymentmethod_id")
    public Integer getPaymentmethodId() {
        return this.paymentmethodId;
    }
    
    public void setPaymentmethodId(Integer paymentmethodId) {
        this.paymentmethodId = paymentmethodId;
    }


    @Column(name="tipodoc_id")
    public Integer getTipodocId() {
        return this.tipodocId;
    }
    
    public void setTipodocId(Integer tipodocId) {
        this.tipodocId = tipodocId;
    }


    @Column(name="old_vendor_id")
    public Integer getOldVendorId() {
        return this.oldVendorId;
    }
    
    public void setOldVendorId(Integer oldVendorId) {
        this.oldVendorId = oldVendorId;
    }


    @Column(name="ticket_id")
    public Integer getTicketId() {
        return this.ticketId;
    }
    
    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ApId) ) return false;
		 ApId castOther = ( ApId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getInvnumber()==castOther.getInvnumber()) || ( this.getInvnumber()!=null && castOther.getInvnumber()!=null && this.getInvnumber().equals(castOther.getInvnumber()) ) )
 && ( (this.getTransdate()==castOther.getTransdate()) || ( this.getTransdate()!=null && castOther.getTransdate()!=null && this.getTransdate().equals(castOther.getTransdate()) ) )
 && ( (this.getVendorId()==castOther.getVendorId()) || ( this.getVendorId()!=null && castOther.getVendorId()!=null && this.getVendorId().equals(castOther.getVendorId()) ) )
 && ( (this.getTaxincluded()==castOther.getTaxincluded()) || ( this.getTaxincluded()!=null && castOther.getTaxincluded()!=null && this.getTaxincluded().equals(castOther.getTaxincluded()) ) )
 && ( (this.getAmount()==castOther.getAmount()) || ( this.getAmount()!=null && castOther.getAmount()!=null && this.getAmount().equals(castOther.getAmount()) ) )
 && ( (this.getNetamount()==castOther.getNetamount()) || ( this.getNetamount()!=null && castOther.getNetamount()!=null && this.getNetamount().equals(castOther.getNetamount()) ) )
 && ( (this.getPaid()==castOther.getPaid()) || ( this.getPaid()!=null && castOther.getPaid()!=null && this.getPaid().equals(castOther.getPaid()) ) )
 && ( (this.getDatepaid()==castOther.getDatepaid()) || ( this.getDatepaid()!=null && castOther.getDatepaid()!=null && this.getDatepaid().equals(castOther.getDatepaid()) ) )
 && ( (this.getDuedate()==castOther.getDuedate()) || ( this.getDuedate()!=null && castOther.getDuedate()!=null && this.getDuedate().equals(castOther.getDuedate()) ) )
 && ( (this.getInvoice()==castOther.getInvoice()) || ( this.getInvoice()!=null && castOther.getInvoice()!=null && this.getInvoice().equals(castOther.getInvoice()) ) )
 && ( (this.getOrdnumber()==castOther.getOrdnumber()) || ( this.getOrdnumber()!=null && castOther.getOrdnumber()!=null && this.getOrdnumber().equals(castOther.getOrdnumber()) ) )
 && ( (this.getCurr()==castOther.getCurr()) || ( this.getCurr()!=null && castOther.getCurr()!=null && this.getCurr().equals(castOther.getCurr()) ) )
 && ( (this.getNotes()==castOther.getNotes()) || ( this.getNotes()!=null && castOther.getNotes()!=null && this.getNotes().equals(castOther.getNotes()) ) )
 && ( (this.getEmployeeId()==castOther.getEmployeeId()) || ( this.getEmployeeId()!=null && castOther.getEmployeeId()!=null && this.getEmployeeId().equals(castOther.getEmployeeId()) ) )
 && ( (this.getTill()==castOther.getTill()) || ( this.getTill()!=null && castOther.getTill()!=null && this.getTill().equals(castOther.getTill()) ) )
 && ( (this.getQuonumber()==castOther.getQuonumber()) || ( this.getQuonumber()!=null && castOther.getQuonumber()!=null && this.getQuonumber().equals(castOther.getQuonumber()) ) )
 && ( (this.getIntnotes()==castOther.getIntnotes()) || ( this.getIntnotes()!=null && castOther.getIntnotes()!=null && this.getIntnotes().equals(castOther.getIntnotes()) ) )
 && ( (this.getDepartmentId()==castOther.getDepartmentId()) || ( this.getDepartmentId()!=null && castOther.getDepartmentId()!=null && this.getDepartmentId().equals(castOther.getDepartmentId()) ) )
 && ( (this.getShipvia()==castOther.getShipvia()) || ( this.getShipvia()!=null && castOther.getShipvia()!=null && this.getShipvia().equals(castOther.getShipvia()) ) )
 && ( (this.getLanguageCode()==castOther.getLanguageCode()) || ( this.getLanguageCode()!=null && castOther.getLanguageCode()!=null && this.getLanguageCode().equals(castOther.getLanguageCode()) ) )
 && ( (this.getPonumber()==castOther.getPonumber()) || ( this.getPonumber()!=null && castOther.getPonumber()!=null && this.getPonumber().equals(castOther.getPonumber()) ) )
 && ( (this.getShippingpoint()==castOther.getShippingpoint()) || ( this.getShippingpoint()!=null && castOther.getShippingpoint()!=null && this.getShippingpoint().equals(castOther.getShippingpoint()) ) )
 && ( (this.getTerms()==castOther.getTerms()) || ( this.getTerms()!=null && castOther.getTerms()!=null && this.getTerms().equals(castOther.getTerms()) ) )
 && ( (this.getApproved()==castOther.getApproved()) || ( this.getApproved()!=null && castOther.getApproved()!=null && this.getApproved().equals(castOther.getApproved()) ) )
 && ( (this.getCashdiscount()==castOther.getCashdiscount()) || ( this.getCashdiscount()!=null && castOther.getCashdiscount()!=null && this.getCashdiscount().equals(castOther.getCashdiscount()) ) )
 && ( (this.getDiscountterms()==castOther.getDiscountterms()) || ( this.getDiscountterms()!=null && castOther.getDiscountterms()!=null && this.getDiscountterms().equals(castOther.getDiscountterms()) ) )
 && ( (this.getWaybill()==castOther.getWaybill()) || ( this.getWaybill()!=null && castOther.getWaybill()!=null && this.getWaybill().equals(castOther.getWaybill()) ) )
 && ( (this.getWarehouseId()==castOther.getWarehouseId()) || ( this.getWarehouseId()!=null && castOther.getWarehouseId()!=null && this.getWarehouseId().equals(castOther.getWarehouseId()) ) )
 && ( (this.getDescription()==castOther.getDescription()) || ( this.getDescription()!=null && castOther.getDescription()!=null && this.getDescription().equals(castOther.getDescription()) ) )
 && ( (this.getOnhold()==castOther.getOnhold()) || ( this.getOnhold()!=null && castOther.getOnhold()!=null && this.getOnhold().equals(castOther.getOnhold()) ) )
 && ( (this.getExchangerate()==castOther.getExchangerate()) || ( this.getExchangerate()!=null && castOther.getExchangerate()!=null && this.getExchangerate().equals(castOther.getExchangerate()) ) )
 && ( (this.getDcn()==castOther.getDcn()) || ( this.getDcn()!=null && castOther.getDcn()!=null && this.getDcn().equals(castOther.getDcn()) ) )
 && ( (this.getBankId()==castOther.getBankId()) || ( this.getBankId()!=null && castOther.getBankId()!=null && this.getBankId().equals(castOther.getBankId()) ) )
 && ( (this.getPaymentmethodId()==castOther.getPaymentmethodId()) || ( this.getPaymentmethodId()!=null && castOther.getPaymentmethodId()!=null && this.getPaymentmethodId().equals(castOther.getPaymentmethodId()) ) )
 && ( (this.getTipodocId()==castOther.getTipodocId()) || ( this.getTipodocId()!=null && castOther.getTipodocId()!=null && this.getTipodocId().equals(castOther.getTipodocId()) ) )
 && ( (this.getOldVendorId()==castOther.getOldVendorId()) || ( this.getOldVendorId()!=null && castOther.getOldVendorId()!=null && this.getOldVendorId().equals(castOther.getOldVendorId()) ) )
 && ( (this.getTicketId()==castOther.getTicketId()) || ( this.getTicketId()!=null && castOther.getTicketId()!=null && this.getTicketId().equals(castOther.getTicketId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getInvnumber() == null ? 0 : this.getInvnumber().hashCode() );
         result = 37 * result + ( getTransdate() == null ? 0 : this.getTransdate().hashCode() );
         result = 37 * result + ( getVendorId() == null ? 0 : this.getVendorId().hashCode() );
         result = 37 * result + ( getTaxincluded() == null ? 0 : this.getTaxincluded().hashCode() );
         result = 37 * result + ( getAmount() == null ? 0 : this.getAmount().hashCode() );
         result = 37 * result + ( getNetamount() == null ? 0 : this.getNetamount().hashCode() );
         result = 37 * result + ( getPaid() == null ? 0 : this.getPaid().hashCode() );
         result = 37 * result + ( getDatepaid() == null ? 0 : this.getDatepaid().hashCode() );
         result = 37 * result + ( getDuedate() == null ? 0 : this.getDuedate().hashCode() );
         result = 37 * result + ( getInvoice() == null ? 0 : this.getInvoice().hashCode() );
         result = 37 * result + ( getOrdnumber() == null ? 0 : this.getOrdnumber().hashCode() );
         result = 37 * result + ( getCurr() == null ? 0 : this.getCurr().hashCode() );
         result = 37 * result + ( getNotes() == null ? 0 : this.getNotes().hashCode() );
         result = 37 * result + ( getEmployeeId() == null ? 0 : this.getEmployeeId().hashCode() );
         result = 37 * result + ( getTill() == null ? 0 : this.getTill().hashCode() );
         result = 37 * result + ( getQuonumber() == null ? 0 : this.getQuonumber().hashCode() );
         result = 37 * result + ( getIntnotes() == null ? 0 : this.getIntnotes().hashCode() );
         result = 37 * result + ( getDepartmentId() == null ? 0 : this.getDepartmentId().hashCode() );
         result = 37 * result + ( getShipvia() == null ? 0 : this.getShipvia().hashCode() );
         result = 37 * result + ( getLanguageCode() == null ? 0 : this.getLanguageCode().hashCode() );
         result = 37 * result + ( getPonumber() == null ? 0 : this.getPonumber().hashCode() );
         result = 37 * result + ( getShippingpoint() == null ? 0 : this.getShippingpoint().hashCode() );
         result = 37 * result + ( getTerms() == null ? 0 : this.getTerms().hashCode() );
         result = 37 * result + ( getApproved() == null ? 0 : this.getApproved().hashCode() );
         result = 37 * result + ( getCashdiscount() == null ? 0 : this.getCashdiscount().hashCode() );
         result = 37 * result + ( getDiscountterms() == null ? 0 : this.getDiscountterms().hashCode() );
         result = 37 * result + ( getWaybill() == null ? 0 : this.getWaybill().hashCode() );
         result = 37 * result + ( getWarehouseId() == null ? 0 : this.getWarehouseId().hashCode() );
         result = 37 * result + ( getDescription() == null ? 0 : this.getDescription().hashCode() );
         result = 37 * result + ( getOnhold() == null ? 0 : this.getOnhold().hashCode() );
         result = 37 * result + ( getExchangerate() == null ? 0 : this.getExchangerate().hashCode() );
         result = 37 * result + ( getDcn() == null ? 0 : this.getDcn().hashCode() );
         result = 37 * result + ( getBankId() == null ? 0 : this.getBankId().hashCode() );
         result = 37 * result + ( getPaymentmethodId() == null ? 0 : this.getPaymentmethodId().hashCode() );
         result = 37 * result + ( getTipodocId() == null ? 0 : this.getTipodocId().hashCode() );
         result = 37 * result + ( getOldVendorId() == null ? 0 : this.getOldVendorId().hashCode() );
         result = 37 * result + ( getTicketId() == null ? 0 : this.getTicketId().hashCode() );
         return result;
   }   


}


