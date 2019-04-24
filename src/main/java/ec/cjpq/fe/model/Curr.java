package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Curr por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="curr",schema="public")
public class Curr  implements java.io.Serializable
 {


     private String curr;
     private Integer rn;
     private Short precision;

    public Curr() {
    }

	
    public Curr(String curr) {
        this.curr = curr;
    }
    public Curr(String curr, Integer rn, Short precision) {
       this.curr = curr;
       this.rn = rn;
       this.precision = precision;
    }
   
     @Id 

    
    @Column(name="curr", unique=true, nullable=false, length=3)
    public String getCurr() {
        return this.curr;
    }
    
    public void setCurr(String curr) {
        this.curr = curr;
    }

    
    @Column(name="rn")
    public Integer getRn() {
        return this.rn;
    }
    
    public void setRn(Integer rn) {
        this.rn = rn;
    }

    
    @Column(name="precision")
    public Short getPrecision() {
        return this.precision;
    }
    
    public void setPrecision(Short precision) {
        this.precision = precision;
    }




}


