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
 * Trf por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="trf",schema="public")
public class Trf  implements java.io.Serializable
 {


     private int id;
     private Date transdate;
     private String trfnumber;
     private String description;
     private String notes;
     private Integer departmentId;
     private Integer fromWarehouseId;
     private Integer toWarehouseId;
     private Integer employeeId;
     private Date delivereddate;
     private String trftype;
     private String ctrfnumber;
     private Integer ticketId;

    public Trf() {
    }

	
    public Trf(int id) {
        this.id = id;
    }
    public Trf(int id, Date transdate, String trfnumber, String description, String notes, Integer departmentId, Integer fromWarehouseId, Integer toWarehouseId, Integer employeeId, Date delivereddate, String trftype, String ctrfnumber, Integer ticketId) {
       this.id = id;
       this.transdate = transdate;
       this.trfnumber = trfnumber;
       this.description = description;
       this.notes = notes;
       this.departmentId = departmentId;
       this.fromWarehouseId = fromWarehouseId;
       this.toWarehouseId = toWarehouseId;
       this.employeeId = employeeId;
       this.delivereddate = delivereddate;
       this.trftype = trftype;
       this.ctrfnumber = ctrfnumber;
       this.ticketId = ticketId;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="transdate", length=13)
    public Date getTransdate() {
        return this.transdate;
    }
    
    public void setTransdate(Date transdate) {
        this.transdate = transdate;
    }

    
    @Column(name="trfnumber")
    public String getTrfnumber() {
        return this.trfnumber;
    }
    
    public void setTrfnumber(String trfnumber) {
        this.trfnumber = trfnumber;
    }

    
    @Column(name="description")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="notes")
    public String getNotes() {
        return this.notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }

    
    @Column(name="department_id")
    public Integer getDepartmentId() {
        return this.departmentId;
    }
    
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    
    @Column(name="from_warehouse_id")
    public Integer getFromWarehouseId() {
        return this.fromWarehouseId;
    }
    
    public void setFromWarehouseId(Integer fromWarehouseId) {
        this.fromWarehouseId = fromWarehouseId;
    }

    
    @Column(name="to_warehouse_id")
    public Integer getToWarehouseId() {
        return this.toWarehouseId;
    }
    
    public void setToWarehouseId(Integer toWarehouseId) {
        this.toWarehouseId = toWarehouseId;
    }

    
    @Column(name="employee_id")
    public Integer getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="delivereddate", length=13)
    public Date getDelivereddate() {
        return this.delivereddate;
    }
    
    public void setDelivereddate(Date delivereddate) {
        this.delivereddate = delivereddate;
    }

    
    @Column(name="trftype", length=10)
    public String getTrftype() {
        return this.trftype;
    }
    
    public void setTrftype(String trftype) {
        this.trftype = trftype;
    }

    
    @Column(name="ctrfnumber")
    public String getCtrfnumber() {
        return this.ctrfnumber;
    }
    
    public void setCtrfnumber(String ctrfnumber) {
        this.ctrfnumber = ctrfnumber;
    }

    
    @Column(name="ticket_id")
    public Integer getTicketId() {
        return this.ticketId;
    }
    
    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }




}


