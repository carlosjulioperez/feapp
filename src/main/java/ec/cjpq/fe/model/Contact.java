package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Contact por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="contact",schema="public")
public class Contact  implements java.io.Serializable
 {


     private int id;
     private int transId;
     private String salutation;
     private String firstname;
     private String lastname;
     private String contacttitle;
     private String occupation;
     private String phone;
     private String fax;
     private String mobile;
     private String email;
     private Character gender;
     private Integer parentId;
     private String typeofcontact;

    public Contact() {
    }

	
    public Contact(int id, int transId) {
        this.id = id;
        this.transId = transId;
    }
    public Contact(int id, int transId, String salutation, String firstname, String lastname, String contacttitle, String occupation, String phone, String fax, String mobile, String email, Character gender, Integer parentId, String typeofcontact) {
       this.id = id;
       this.transId = transId;
       this.salutation = salutation;
       this.firstname = firstname;
       this.lastname = lastname;
       this.contacttitle = contacttitle;
       this.occupation = occupation;
       this.phone = phone;
       this.fax = fax;
       this.mobile = mobile;
       this.email = email;
       this.gender = gender;
       this.parentId = parentId;
       this.typeofcontact = typeofcontact;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="trans_id", nullable=false)
    public int getTransId() {
        return this.transId;
    }
    
    public void setTransId(int transId) {
        this.transId = transId;
    }

    
    @Column(name="salutation", length=32)
    public String getSalutation() {
        return this.salutation;
    }
    
    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    
    @Column(name="firstname", length=32)
    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    
    @Column(name="lastname", length=32)
    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    
    @Column(name="contacttitle", length=32)
    public String getContacttitle() {
        return this.contacttitle;
    }
    
    public void setContacttitle(String contacttitle) {
        this.contacttitle = contacttitle;
    }

    
    @Column(name="occupation", length=32)
    public String getOccupation() {
        return this.occupation;
    }
    
    public void setOccupation(String occupation) {
        this.occupation = occupation;
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

    
    @Column(name="mobile", length=20)
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    
    @Column(name="email")
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="gender", length=1)
    public Character getGender() {
        return this.gender;
    }
    
    public void setGender(Character gender) {
        this.gender = gender;
    }

    
    @Column(name="parent_id")
    public Integer getParentId() {
        return this.parentId;
    }
    
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    
    @Column(name="typeofcontact", length=20)
    public String getTypeofcontact() {
        return this.typeofcontact;
    }
    
    public void setTypeofcontact(String typeofcontact) {
        this.typeofcontact = typeofcontact;
    }




}


