package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Br por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="br",schema="public")
public class Br  implements java.io.Serializable
 {


     private int id;
     private String batchnumber;
     private String description;
     private String batch;
     private Date transdate;
     private Date apprdate;
     private Double amount;
     private Integer managerid;
     private Integer employeeId;
     private Set<Vr> vrs = new HashSet<Vr>(0);

    public Br() {
    }

	
    public Br(int id) {
        this.id = id;
    }
    public Br(int id, String batchnumber, String description, String batch, Date transdate, Date apprdate, Double amount, Integer managerid, Integer employeeId, Set<Vr> vrs) {
       this.id = id;
       this.batchnumber = batchnumber;
       this.description = description;
       this.batch = batch;
       this.transdate = transdate;
       this.apprdate = apprdate;
       this.amount = amount;
       this.managerid = managerid;
       this.employeeId = employeeId;
       this.vrs = vrs;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="batchnumber")
    public String getBatchnumber() {
        return this.batchnumber;
    }
    
    public void setBatchnumber(String batchnumber) {
        this.batchnumber = batchnumber;
    }

    
    @Column(name="description")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="batch")
    public String getBatch() {
        return this.batch;
    }
    
    public void setBatch(String batch) {
        this.batch = batch;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="transdate", length=13)
    public Date getTransdate() {
        return this.transdate;
    }
    
    public void setTransdate(Date transdate) {
        this.transdate = transdate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="apprdate", length=13)
    public Date getApprdate() {
        return this.apprdate;
    }
    
    public void setApprdate(Date apprdate) {
        this.apprdate = apprdate;
    }

    
    @Column(name="amount", precision=17, scale=17)
    public Double getAmount() {
        return this.amount;
    }
    
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    
    @Column(name="managerid")
    public Integer getManagerid() {
        return this.managerid;
    }
    
    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    
    @Column(name="employee_id")
    public Integer getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="br")
    public Set<Vr> getVrs() {
        return this.vrs;
    }
    
    public void setVrs(Set<Vr> vrs) {
        this.vrs = vrs;
    }




}


