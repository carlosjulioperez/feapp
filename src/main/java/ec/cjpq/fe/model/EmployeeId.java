package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EmployeeId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class EmployeeId  implements java.io.Serializable
 {


     private Integer id;
     private String login;
     private String name;
     private String address1;
     private String address2;
     private String city;
     private String state;
     private String zipcode;
     private String country;
     private String workphone;
     private String workfax;
     private String workmobile;
     private String homephone;
     private Date startdate;
     private Date enddate;
     private String notes;
     private String role;
     private Boolean sales;
     private String email;
     private String ssn;
     private String iban;
     private String bic;
     private Integer managerid;
     private String employeenumber;
     private Date dob;
     private String p12Archivo;
     private String p12Clave;
     private String codEstabl;
     private String codPtoEmi;
     private Integer secFactura;
     private Integer secNcredito;
     private Integer secNdebito;
     private Integer secGremision;
     private Integer secCretencion;
     private Short tipAmbiente;

    public EmployeeId() {
    }

    public EmployeeId(Integer id, String login, String name, String address1, String address2, String city, String state, String zipcode, String country, String workphone, String workfax, String workmobile, String homephone, Date startdate, Date enddate, String notes, String role, Boolean sales, String email, String ssn, String iban, String bic, Integer managerid, String employeenumber, Date dob, String p12Archivo, String p12Clave, String codEstabl, String codPtoEmi, Integer secFactura, Integer secNcredito, Integer secNdebito, Integer secGremision, Integer secCretencion, Short tipAmbiente) {
       this.id = id;
       this.login = login;
       this.name = name;
       this.address1 = address1;
       this.address2 = address2;
       this.city = city;
       this.state = state;
       this.zipcode = zipcode;
       this.country = country;
       this.workphone = workphone;
       this.workfax = workfax;
       this.workmobile = workmobile;
       this.homephone = homephone;
       this.startdate = startdate;
       this.enddate = enddate;
       this.notes = notes;
       this.role = role;
       this.sales = sales;
       this.email = email;
       this.ssn = ssn;
       this.iban = iban;
       this.bic = bic;
       this.managerid = managerid;
       this.employeenumber = employeenumber;
       this.dob = dob;
       this.p12Archivo = p12Archivo;
       this.p12Clave = p12Clave;
       this.codEstabl = codEstabl;
       this.codPtoEmi = codPtoEmi;
       this.secFactura = secFactura;
       this.secNcredito = secNcredito;
       this.secNdebito = secNdebito;
       this.secGremision = secGremision;
       this.secCretencion = secCretencion;
       this.tipAmbiente = tipAmbiente;
    }
   


    @Column(name="id")
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name="login", unique=true)
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }


    @Column(name="name", length=64)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }


    @Column(name="address1", length=32)
    public String getAddress1() {
        return this.address1;
    }
    
    public void setAddress1(String address1) {
        this.address1 = address1;
    }


    @Column(name="address2", length=32)
    public String getAddress2() {
        return this.address2;
    }
    
    public void setAddress2(String address2) {
        this.address2 = address2;
    }


    @Column(name="city", length=32)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }


    @Column(name="state", length=32)
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }


    @Column(name="zipcode", length=10)
    public String getZipcode() {
        return this.zipcode;
    }
    
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }


    @Column(name="country", length=32)
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }


    @Column(name="workphone", length=20)
    public String getWorkphone() {
        return this.workphone;
    }
    
    public void setWorkphone(String workphone) {
        this.workphone = workphone;
    }


    @Column(name="workfax", length=20)
    public String getWorkfax() {
        return this.workfax;
    }
    
    public void setWorkfax(String workfax) {
        this.workfax = workfax;
    }


    @Column(name="workmobile", length=20)
    public String getWorkmobile() {
        return this.workmobile;
    }
    
    public void setWorkmobile(String workmobile) {
        this.workmobile = workmobile;
    }


    @Column(name="homephone", length=20)
    public String getHomephone() {
        return this.homephone;
    }
    
    public void setHomephone(String homephone) {
        this.homephone = homephone;
    }


    @Column(name="startdate", length=13)
    public Date getStartdate() {
        return this.startdate;
    }
    
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }


    @Column(name="enddate", length=13)
    public Date getEnddate() {
        return this.enddate;
    }
    
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }


    @Column(name="notes")
    public String getNotes() {
        return this.notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }


    @Column(name="role", length=20)
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }


    @Column(name="sales")
    public Boolean getSales() {
        return this.sales;
    }
    
    public void setSales(Boolean sales) {
        this.sales = sales;
    }


    @Column(name="email")
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }


    @Column(name="ssn", length=20)
    public String getSsn() {
        return this.ssn;
    }
    
    public void setSsn(String ssn) {
        this.ssn = ssn;
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


    @Column(name="managerid")
    public Integer getManagerid() {
        return this.managerid;
    }
    
    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }


    @Column(name="employeenumber", length=32)
    public String getEmployeenumber() {
        return this.employeenumber;
    }
    
    public void setEmployeenumber(String employeenumber) {
        this.employeenumber = employeenumber;
    }


    @Column(name="dob", length=13)
    public Date getDob() {
        return this.dob;
    }
    
    public void setDob(Date dob) {
        this.dob = dob;
    }


    @Column(name="p12_archivo", length=100)
    public String getP12Archivo() {
        return this.p12Archivo;
    }
    
    public void setP12Archivo(String p12Archivo) {
        this.p12Archivo = p12Archivo;
    }


    @Column(name="p12_clave", length=100)
    public String getP12Clave() {
        return this.p12Clave;
    }
    
    public void setP12Clave(String p12Clave) {
        this.p12Clave = p12Clave;
    }


    @Column(name="cod_establ", length=3)
    public String getCodEstabl() {
        return this.codEstabl;
    }
    
    public void setCodEstabl(String codEstabl) {
        this.codEstabl = codEstabl;
    }


    @Column(name="cod_pto_emi", length=3)
    public String getCodPtoEmi() {
        return this.codPtoEmi;
    }
    
    public void setCodPtoEmi(String codPtoEmi) {
        this.codPtoEmi = codPtoEmi;
    }


    @Column(name="sec_factura")
    public Integer getSecFactura() {
        return this.secFactura;
    }
    
    public void setSecFactura(Integer secFactura) {
        this.secFactura = secFactura;
    }


    @Column(name="sec_ncredito")
    public Integer getSecNcredito() {
        return this.secNcredito;
    }
    
    public void setSecNcredito(Integer secNcredito) {
        this.secNcredito = secNcredito;
    }


    @Column(name="sec_ndebito")
    public Integer getSecNdebito() {
        return this.secNdebito;
    }
    
    public void setSecNdebito(Integer secNdebito) {
        this.secNdebito = secNdebito;
    }


    @Column(name="sec_gremision")
    public Integer getSecGremision() {
        return this.secGremision;
    }
    
    public void setSecGremision(Integer secGremision) {
        this.secGremision = secGremision;
    }


    @Column(name="sec_cretencion")
    public Integer getSecCretencion() {
        return this.secCretencion;
    }
    
    public void setSecCretencion(Integer secCretencion) {
        this.secCretencion = secCretencion;
    }


    @Column(name="tip_ambiente")
    public Short getTipAmbiente() {
        return this.tipAmbiente;
    }
    
    public void setTipAmbiente(Short tipAmbiente) {
        this.tipAmbiente = tipAmbiente;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof EmployeeId) ) return false;
		 EmployeeId castOther = ( EmployeeId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getLogin()==castOther.getLogin()) || ( this.getLogin()!=null && castOther.getLogin()!=null && this.getLogin().equals(castOther.getLogin()) ) )
 && ( (this.getName()==castOther.getName()) || ( this.getName()!=null && castOther.getName()!=null && this.getName().equals(castOther.getName()) ) )
 && ( (this.getAddress1()==castOther.getAddress1()) || ( this.getAddress1()!=null && castOther.getAddress1()!=null && this.getAddress1().equals(castOther.getAddress1()) ) )
 && ( (this.getAddress2()==castOther.getAddress2()) || ( this.getAddress2()!=null && castOther.getAddress2()!=null && this.getAddress2().equals(castOther.getAddress2()) ) )
 && ( (this.getCity()==castOther.getCity()) || ( this.getCity()!=null && castOther.getCity()!=null && this.getCity().equals(castOther.getCity()) ) )
 && ( (this.getState()==castOther.getState()) || ( this.getState()!=null && castOther.getState()!=null && this.getState().equals(castOther.getState()) ) )
 && ( (this.getZipcode()==castOther.getZipcode()) || ( this.getZipcode()!=null && castOther.getZipcode()!=null && this.getZipcode().equals(castOther.getZipcode()) ) )
 && ( (this.getCountry()==castOther.getCountry()) || ( this.getCountry()!=null && castOther.getCountry()!=null && this.getCountry().equals(castOther.getCountry()) ) )
 && ( (this.getWorkphone()==castOther.getWorkphone()) || ( this.getWorkphone()!=null && castOther.getWorkphone()!=null && this.getWorkphone().equals(castOther.getWorkphone()) ) )
 && ( (this.getWorkfax()==castOther.getWorkfax()) || ( this.getWorkfax()!=null && castOther.getWorkfax()!=null && this.getWorkfax().equals(castOther.getWorkfax()) ) )
 && ( (this.getWorkmobile()==castOther.getWorkmobile()) || ( this.getWorkmobile()!=null && castOther.getWorkmobile()!=null && this.getWorkmobile().equals(castOther.getWorkmobile()) ) )
 && ( (this.getHomephone()==castOther.getHomephone()) || ( this.getHomephone()!=null && castOther.getHomephone()!=null && this.getHomephone().equals(castOther.getHomephone()) ) )
 && ( (this.getStartdate()==castOther.getStartdate()) || ( this.getStartdate()!=null && castOther.getStartdate()!=null && this.getStartdate().equals(castOther.getStartdate()) ) )
 && ( (this.getEnddate()==castOther.getEnddate()) || ( this.getEnddate()!=null && castOther.getEnddate()!=null && this.getEnddate().equals(castOther.getEnddate()) ) )
 && ( (this.getNotes()==castOther.getNotes()) || ( this.getNotes()!=null && castOther.getNotes()!=null && this.getNotes().equals(castOther.getNotes()) ) )
 && ( (this.getRole()==castOther.getRole()) || ( this.getRole()!=null && castOther.getRole()!=null && this.getRole().equals(castOther.getRole()) ) )
 && ( (this.getSales()==castOther.getSales()) || ( this.getSales()!=null && castOther.getSales()!=null && this.getSales().equals(castOther.getSales()) ) )
 && ( (this.getEmail()==castOther.getEmail()) || ( this.getEmail()!=null && castOther.getEmail()!=null && this.getEmail().equals(castOther.getEmail()) ) )
 && ( (this.getSsn()==castOther.getSsn()) || ( this.getSsn()!=null && castOther.getSsn()!=null && this.getSsn().equals(castOther.getSsn()) ) )
 && ( (this.getIban()==castOther.getIban()) || ( this.getIban()!=null && castOther.getIban()!=null && this.getIban().equals(castOther.getIban()) ) )
 && ( (this.getBic()==castOther.getBic()) || ( this.getBic()!=null && castOther.getBic()!=null && this.getBic().equals(castOther.getBic()) ) )
 && ( (this.getManagerid()==castOther.getManagerid()) || ( this.getManagerid()!=null && castOther.getManagerid()!=null && this.getManagerid().equals(castOther.getManagerid()) ) )
 && ( (this.getEmployeenumber()==castOther.getEmployeenumber()) || ( this.getEmployeenumber()!=null && castOther.getEmployeenumber()!=null && this.getEmployeenumber().equals(castOther.getEmployeenumber()) ) )
 && ( (this.getDob()==castOther.getDob()) || ( this.getDob()!=null && castOther.getDob()!=null && this.getDob().equals(castOther.getDob()) ) )
 && ( (this.getP12Archivo()==castOther.getP12Archivo()) || ( this.getP12Archivo()!=null && castOther.getP12Archivo()!=null && this.getP12Archivo().equals(castOther.getP12Archivo()) ) )
 && ( (this.getP12Clave()==castOther.getP12Clave()) || ( this.getP12Clave()!=null && castOther.getP12Clave()!=null && this.getP12Clave().equals(castOther.getP12Clave()) ) )
 && ( (this.getCodEstabl()==castOther.getCodEstabl()) || ( this.getCodEstabl()!=null && castOther.getCodEstabl()!=null && this.getCodEstabl().equals(castOther.getCodEstabl()) ) )
 && ( (this.getCodPtoEmi()==castOther.getCodPtoEmi()) || ( this.getCodPtoEmi()!=null && castOther.getCodPtoEmi()!=null && this.getCodPtoEmi().equals(castOther.getCodPtoEmi()) ) )
 && ( (this.getSecFactura()==castOther.getSecFactura()) || ( this.getSecFactura()!=null && castOther.getSecFactura()!=null && this.getSecFactura().equals(castOther.getSecFactura()) ) )
 && ( (this.getSecNcredito()==castOther.getSecNcredito()) || ( this.getSecNcredito()!=null && castOther.getSecNcredito()!=null && this.getSecNcredito().equals(castOther.getSecNcredito()) ) )
 && ( (this.getSecNdebito()==castOther.getSecNdebito()) || ( this.getSecNdebito()!=null && castOther.getSecNdebito()!=null && this.getSecNdebito().equals(castOther.getSecNdebito()) ) )
 && ( (this.getSecGremision()==castOther.getSecGremision()) || ( this.getSecGremision()!=null && castOther.getSecGremision()!=null && this.getSecGremision().equals(castOther.getSecGremision()) ) )
 && ( (this.getSecCretencion()==castOther.getSecCretencion()) || ( this.getSecCretencion()!=null && castOther.getSecCretencion()!=null && this.getSecCretencion().equals(castOther.getSecCretencion()) ) )
 && ( (this.getTipAmbiente()==castOther.getTipAmbiente()) || ( this.getTipAmbiente()!=null && castOther.getTipAmbiente()!=null && this.getTipAmbiente().equals(castOther.getTipAmbiente()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getLogin() == null ? 0 : this.getLogin().hashCode() );
         result = 37 * result + ( getName() == null ? 0 : this.getName().hashCode() );
         result = 37 * result + ( getAddress1() == null ? 0 : this.getAddress1().hashCode() );
         result = 37 * result + ( getAddress2() == null ? 0 : this.getAddress2().hashCode() );
         result = 37 * result + ( getCity() == null ? 0 : this.getCity().hashCode() );
         result = 37 * result + ( getState() == null ? 0 : this.getState().hashCode() );
         result = 37 * result + ( getZipcode() == null ? 0 : this.getZipcode().hashCode() );
         result = 37 * result + ( getCountry() == null ? 0 : this.getCountry().hashCode() );
         result = 37 * result + ( getWorkphone() == null ? 0 : this.getWorkphone().hashCode() );
         result = 37 * result + ( getWorkfax() == null ? 0 : this.getWorkfax().hashCode() );
         result = 37 * result + ( getWorkmobile() == null ? 0 : this.getWorkmobile().hashCode() );
         result = 37 * result + ( getHomephone() == null ? 0 : this.getHomephone().hashCode() );
         result = 37 * result + ( getStartdate() == null ? 0 : this.getStartdate().hashCode() );
         result = 37 * result + ( getEnddate() == null ? 0 : this.getEnddate().hashCode() );
         result = 37 * result + ( getNotes() == null ? 0 : this.getNotes().hashCode() );
         result = 37 * result + ( getRole() == null ? 0 : this.getRole().hashCode() );
         result = 37 * result + ( getSales() == null ? 0 : this.getSales().hashCode() );
         result = 37 * result + ( getEmail() == null ? 0 : this.getEmail().hashCode() );
         result = 37 * result + ( getSsn() == null ? 0 : this.getSsn().hashCode() );
         result = 37 * result + ( getIban() == null ? 0 : this.getIban().hashCode() );
         result = 37 * result + ( getBic() == null ? 0 : this.getBic().hashCode() );
         result = 37 * result + ( getManagerid() == null ? 0 : this.getManagerid().hashCode() );
         result = 37 * result + ( getEmployeenumber() == null ? 0 : this.getEmployeenumber().hashCode() );
         result = 37 * result + ( getDob() == null ? 0 : this.getDob().hashCode() );
         result = 37 * result + ( getP12Archivo() == null ? 0 : this.getP12Archivo().hashCode() );
         result = 37 * result + ( getP12Clave() == null ? 0 : this.getP12Clave().hashCode() );
         result = 37 * result + ( getCodEstabl() == null ? 0 : this.getCodEstabl().hashCode() );
         result = 37 * result + ( getCodPtoEmi() == null ? 0 : this.getCodPtoEmi().hashCode() );
         result = 37 * result + ( getSecFactura() == null ? 0 : this.getSecFactura().hashCode() );
         result = 37 * result + ( getSecNcredito() == null ? 0 : this.getSecNcredito().hashCode() );
         result = 37 * result + ( getSecNdebito() == null ? 0 : this.getSecNdebito().hashCode() );
         result = 37 * result + ( getSecGremision() == null ? 0 : this.getSecGremision().hashCode() );
         result = 37 * result + ( getSecCretencion() == null ? 0 : this.getSecCretencion().hashCode() );
         result = 37 * result + ( getTipAmbiente() == null ? 0 : this.getTipAmbiente().hashCode() );
         return result;
   }   


}


