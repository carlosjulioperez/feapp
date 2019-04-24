package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Employee por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="employee",schema="public", uniqueConstraints = @UniqueConstraint(columnNames="login"))
public class Employee  implements java.io.Serializable
 {


     private EmployeeId id;

    public Employee() {
    }

    public Employee(EmployeeId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id") ), 
        @AttributeOverride(name="login", column=@Column(name="login", unique=true) ), 
        @AttributeOverride(name="name", column=@Column(name="name", length=64) ), 
        @AttributeOverride(name="address1", column=@Column(name="address1", length=32) ), 
        @AttributeOverride(name="address2", column=@Column(name="address2", length=32) ), 
        @AttributeOverride(name="city", column=@Column(name="city", length=32) ), 
        @AttributeOverride(name="state", column=@Column(name="state", length=32) ), 
        @AttributeOverride(name="zipcode", column=@Column(name="zipcode", length=10) ), 
        @AttributeOverride(name="country", column=@Column(name="country", length=32) ), 
        @AttributeOverride(name="workphone", column=@Column(name="workphone", length=20) ), 
        @AttributeOverride(name="workfax", column=@Column(name="workfax", length=20) ), 
        @AttributeOverride(name="workmobile", column=@Column(name="workmobile", length=20) ), 
        @AttributeOverride(name="homephone", column=@Column(name="homephone", length=20) ), 
        @AttributeOverride(name="startdate", column=@Column(name="startdate", length=13) ), 
        @AttributeOverride(name="enddate", column=@Column(name="enddate", length=13) ), 
        @AttributeOverride(name="notes", column=@Column(name="notes") ), 
        @AttributeOverride(name="role", column=@Column(name="role", length=20) ), 
        @AttributeOverride(name="sales", column=@Column(name="sales") ), 
        @AttributeOverride(name="email", column=@Column(name="email") ), 
        @AttributeOverride(name="ssn", column=@Column(name="ssn", length=20) ), 
        @AttributeOverride(name="iban", column=@Column(name="iban", length=34) ), 
        @AttributeOverride(name="bic", column=@Column(name="bic", length=11) ), 
        @AttributeOverride(name="managerid", column=@Column(name="managerid") ), 
        @AttributeOverride(name="employeenumber", column=@Column(name="employeenumber", length=32) ), 
        @AttributeOverride(name="dob", column=@Column(name="dob", length=13) ), 
        @AttributeOverride(name="p12Archivo", column=@Column(name="p12_archivo", length=100) ), 
        @AttributeOverride(name="p12Clave", column=@Column(name="p12_clave", length=100) ), 
        @AttributeOverride(name="codEstabl", column=@Column(name="cod_establ", length=3) ), 
        @AttributeOverride(name="codPtoEmi", column=@Column(name="cod_pto_emi", length=3) ), 
        @AttributeOverride(name="secFactura", column=@Column(name="sec_factura") ), 
        @AttributeOverride(name="secNcredito", column=@Column(name="sec_ncredito") ), 
        @AttributeOverride(name="secNdebito", column=@Column(name="sec_ndebito") ), 
        @AttributeOverride(name="secGremision", column=@Column(name="sec_gremision") ), 
        @AttributeOverride(name="secCretencion", column=@Column(name="sec_cretencion") ), 
        @AttributeOverride(name="tipAmbiente", column=@Column(name="tip_ambiente") ) } )
    public EmployeeId getId() {
        return this.id;
    }
    
    public void setId(EmployeeId id) {
        this.id = id;
    }




}


