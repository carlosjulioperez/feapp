package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Vendor por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="vendor",schema="public")
public class Vendor  implements java.io.Serializable
 {


     private int id;
     private String name;
     private String contact;
     private String phone;
     private String fax;
     private String email;
     private String notes;
     private Short terms;
     private Boolean taxincluded;
     private String vendornumber;
     private String cc;
     private String bcc;
     private String gifiAccno;
     private Integer businessId;
     private String taxnumber;
     private String sicCode;
     private Float discount;
     private Double creditlimit;
     private String iban;
     private String bic;
     private Integer employeeId;
     private String languageCode;
     private Integer pricegroupId;
     private String curr;
     private Date startdate;
     private Date enddate;
     private Integer arapAccnoId;
     private Integer paymentAccnoId;
     private Integer discountAccnoId;
     private Float cashdiscount;
     private Short discountterms;
     private Double threshold;
     private Integer paymentmethodId;
     private Boolean remittancevoucher;
     private Integer tipoidId;
     private String htmlHeader;
     private String htmlFooter;
     private String latexHeader;
     private String latexFooter;

    public Vendor() {
    }

	
    public Vendor(int id) {
        this.id = id;
    }
    public Vendor(int id, String name, String contact, String phone, String fax, String email, String notes, Short terms, Boolean taxincluded, String vendornumber, String cc, String bcc, String gifiAccno, Integer businessId, String taxnumber, String sicCode, Float discount, Double creditlimit, String iban, String bic, Integer employeeId, String languageCode, Integer pricegroupId, String curr, Date startdate, Date enddate, Integer arapAccnoId, Integer paymentAccnoId, Integer discountAccnoId, Float cashdiscount, Short discountterms, Double threshold, Integer paymentmethodId, Boolean remittancevoucher, Integer tipoidId, String htmlHeader, String htmlFooter, String latexHeader, String latexFooter) {
       this.id = id;
       this.name = name;
       this.contact = contact;
       this.phone = phone;
       this.fax = fax;
       this.email = email;
       this.notes = notes;
       this.terms = terms;
       this.taxincluded = taxincluded;
       this.vendornumber = vendornumber;
       this.cc = cc;
       this.bcc = bcc;
       this.gifiAccno = gifiAccno;
       this.businessId = businessId;
       this.taxnumber = taxnumber;
       this.sicCode = sicCode;
       this.discount = discount;
       this.creditlimit = creditlimit;
       this.iban = iban;
       this.bic = bic;
       this.employeeId = employeeId;
       this.languageCode = languageCode;
       this.pricegroupId = pricegroupId;
       this.curr = curr;
       this.startdate = startdate;
       this.enddate = enddate;
       this.arapAccnoId = arapAccnoId;
       this.paymentAccnoId = paymentAccnoId;
       this.discountAccnoId = discountAccnoId;
       this.cashdiscount = cashdiscount;
       this.discountterms = discountterms;
       this.threshold = threshold;
       this.paymentmethodId = paymentmethodId;
       this.remittancevoucher = remittancevoucher;
       this.tipoidId = tipoidId;
       this.htmlHeader = htmlHeader;
       this.htmlFooter = htmlFooter;
       this.latexHeader = latexHeader;
       this.latexFooter = latexFooter;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="name", length=64)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="contact", length=64)
    public String getContact() {
        return this.contact;
    }
    
    public void setContact(String contact) {
        this.contact = contact;
    }

    
    @Column(name="phone", length=20)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    @Column(name="fax", length=20)
    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }

    
    @Column(name="email")
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="notes")
    public String getNotes() {
        return this.notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }

    
    @Column(name="terms")
    public Short getTerms() {
        return this.terms;
    }
    
    public void setTerms(Short terms) {
        this.terms = terms;
    }

    
    @Column(name="taxincluded")
    public Boolean getTaxincluded() {
        return this.taxincluded;
    }
    
    public void setTaxincluded(Boolean taxincluded) {
        this.taxincluded = taxincluded;
    }

    
    @Column(name="vendornumber", length=32)
    public String getVendornumber() {
        return this.vendornumber;
    }
    
    public void setVendornumber(String vendornumber) {
        this.vendornumber = vendornumber;
    }

    
    @Column(name="cc")
    public String getCc() {
        return this.cc;
    }
    
    public void setCc(String cc) {
        this.cc = cc;
    }

    
    @Column(name="bcc")
    public String getBcc() {
        return this.bcc;
    }
    
    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    
    @Column(name="gifi_accno", length=30)
    public String getGifiAccno() {
        return this.gifiAccno;
    }
    
    public void setGifiAccno(String gifiAccno) {
        this.gifiAccno = gifiAccno;
    }

    
    @Column(name="business_id")
    public Integer getBusinessId() {
        return this.businessId;
    }
    
    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    
    @Column(name="taxnumber", length=32)
    public String getTaxnumber() {
        return this.taxnumber;
    }
    
    public void setTaxnumber(String taxnumber) {
        this.taxnumber = taxnumber;
    }

    
    @Column(name="sic_code", length=6)
    public String getSicCode() {
        return this.sicCode;
    }
    
    public void setSicCode(String sicCode) {
        this.sicCode = sicCode;
    }

    
    @Column(name="discount", precision=8, scale=8)
    public Float getDiscount() {
        return this.discount;
    }
    
    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    
    @Column(name="creditlimit", precision=17, scale=17)
    public Double getCreditlimit() {
        return this.creditlimit;
    }
    
    public void setCreditlimit(Double creditlimit) {
        this.creditlimit = creditlimit;
    }

    
    @Column(name="iban", length=34)
    public String getIban() {
        return this.iban;
    }
    
    public void setIban(String iban) {
        this.iban = iban;
    }

    
    @Column(name="bic", length=11)
    public String getBic() {
        return this.bic;
    }
    
    public void setBic(String bic) {
        this.bic = bic;
    }

    
    @Column(name="employee_id")
    public Integer getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    
    @Column(name="language_code", length=6)
    public String getLanguageCode() {
        return this.languageCode;
    }
    
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    
    @Column(name="pricegroup_id")
    public Integer getPricegroupId() {
        return this.pricegroupId;
    }
    
    public void setPricegroupId(Integer pricegroupId) {
        this.pricegroupId = pricegroupId;
    }

    
    @Column(name="curr", length=3)
    public String getCurr() {
        return this.curr;
    }
    
    public void setCurr(String curr) {
        this.curr = curr;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="startdate", length=13)
    public Date getStartdate() {
        return this.startdate;
    }
    
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="enddate", length=13)
    public Date getEnddate() {
        return this.enddate;
    }
    
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    
    @Column(name="arap_accno_id")
    public Integer getArapAccnoId() {
        return this.arapAccnoId;
    }
    
    public void setArapAccnoId(Integer arapAccnoId) {
        this.arapAccnoId = arapAccnoId;
    }

    
    @Column(name="payment_accno_id")
    public Integer getPaymentAccnoId() {
        return this.paymentAccnoId;
    }
    
    public void setPaymentAccnoId(Integer paymentAccnoId) {
        this.paymentAccnoId = paymentAccnoId;
    }

    
    @Column(name="discount_accno_id")
    public Integer getDiscountAccnoId() {
        return this.discountAccnoId;
    }
    
    public void setDiscountAccnoId(Integer discountAccnoId) {
        this.discountAccnoId = discountAccnoId;
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

    
    @Column(name="threshold", precision=17, scale=17)
    public Double getThreshold() {
        return this.threshold;
    }
    
    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }

    
    @Column(name="paymentmethod_id")
    public Integer getPaymentmethodId() {
        return this.paymentmethodId;
    }
    
    public void setPaymentmethodId(Integer paymentmethodId) {
        this.paymentmethodId = paymentmethodId;
    }

    
    @Column(name="remittancevoucher")
    public Boolean getRemittancevoucher() {
        return this.remittancevoucher;
    }
    
    public void setRemittancevoucher(Boolean remittancevoucher) {
        this.remittancevoucher = remittancevoucher;
    }

    
    @Column(name="tipoid_id")
    public Integer getTipoidId() {
        return this.tipoidId;
    }
    
    public void setTipoidId(Integer tipoidId) {
        this.tipoidId = tipoidId;
    }

    
    @Column(name="html_header")
    public String getHtmlHeader() {
        return this.htmlHeader;
    }
    
    public void setHtmlHeader(String htmlHeader) {
        this.htmlHeader = htmlHeader;
    }

    
    @Column(name="html_footer")
    public String getHtmlFooter() {
        return this.htmlFooter;
    }
    
    public void setHtmlFooter(String htmlFooter) {
        this.htmlFooter = htmlFooter;
    }

    
    @Column(name="latex_header")
    public String getLatexHeader() {
        return this.latexHeader;
    }
    
    public void setLatexHeader(String latexHeader) {
        this.latexHeader = latexHeader;
    }

    
    @Column(name="latex_footer")
    public String getLatexFooter() {
        return this.latexFooter;
    }
    
    public void setLatexFooter(String latexFooter) {
        this.latexFooter = latexFooter;
    }




}


