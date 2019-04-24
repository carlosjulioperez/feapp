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
 * Chart por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="chart",schema="public", uniqueConstraints = @UniqueConstraint(columnNames="accno"))
public class Chart  implements java.io.Serializable
 {


     private ChartId id;

    public Chart() {
    }

    public Chart(ChartId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id") ), 
        @AttributeOverride(name="accno", column=@Column(name="accno", unique=true, nullable=false) ), 
        @AttributeOverride(name="description", column=@Column(name="description") ), 
        @AttributeOverride(name="charttype", column=@Column(name="charttype", length=1) ), 
        @AttributeOverride(name="category", column=@Column(name="category", length=1) ), 
        @AttributeOverride(name="link", column=@Column(name="link") ), 
        @AttributeOverride(name="gifiAccno", column=@Column(name="gifi_accno") ), 
        @AttributeOverride(name="contra", column=@Column(name="contra") ) } )
    public ChartId getId() {
        return this.id;
    }
    
    public void setId(ChartId id) {
        this.id = id;
    }




}


