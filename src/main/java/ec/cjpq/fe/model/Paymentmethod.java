package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Paymentmethod por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="paymentmethod",schema="public")
public class Paymentmethod  implements java.io.Serializable
 {


     private int id;
     private String description;
     private Double fee;
     private Integer rn;

    public Paymentmethod() {
    }

	
    public Paymentmethod(int id) {
        this.id = id;
    }
    public Paymentmethod(int id, String description, Double fee, Integer rn) {
       this.id = id;
       this.description = description;
       this.fee = fee;
       this.rn = rn;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="description")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="fee", precision=17, scale=17)
    public Double getFee() {
        return this.fee;
    }
    
    public void setFee(Double fee) {
        this.fee = fee;
    }

    
    @Column(name="rn")
    public Integer getRn() {
        return this.rn;
    }
    
    public void setRn(Integer rn) {
        this.rn = rn;
    }




}


