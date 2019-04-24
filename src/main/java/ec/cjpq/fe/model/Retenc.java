package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Retenc por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="retenc",schema="public")
public class Retenc  implements java.io.Serializable
 {


     private RetencId id;

    public Retenc() {
    }

    public Retenc(RetencId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id", nullable=false) ), 
        @AttributeOverride(name="vendorId", column=@Column(name="vendor_id") ), 
        @AttributeOverride(name="tipoidId", column=@Column(name="tipoid_id", length=2) ), 
        @AttributeOverride(name="idprov", column=@Column(name="idprov") ), 
        @AttributeOverride(name="tipodocId", column=@Column(name="tipodoc_id") ), 
        @AttributeOverride(name="estab", column=@Column(name="estab", length=3) ), 
        @AttributeOverride(name="ptoemi", column=@Column(name="ptoemi", length=3) ), 
        @AttributeOverride(name="sec", column=@Column(name="sec", length=9) ), 
        @AttributeOverride(name="ordnumber", column=@Column(name="ordnumber") ), 
        @AttributeOverride(name="transdate", column=@Column(name="transdate", length=13) ), 
        @AttributeOverride(name="estabret", column=@Column(name="estabret", length=3) ), 
        @AttributeOverride(name="ptoemiret", column=@Column(name="ptoemiret", length=3) ), 
        @AttributeOverride(name="secret", column=@Column(name="secret", length=9) ), 
        @AttributeOverride(name="ordnumberret", column=@Column(name="ordnumberret") ), 
        @AttributeOverride(name="transdateret", column=@Column(name="transdateret", length=13) ), 
        @AttributeOverride(name="tiporetId", column=@Column(name="tiporet_id") ), 
        @AttributeOverride(name="porcret", column=@Column(name="porcret") ), 
        @AttributeOverride(name="base0", column=@Column(name="base0", precision=17, scale=17) ), 
        @AttributeOverride(name="based0", column=@Column(name="based0", precision=17, scale=17) ), 
        @AttributeOverride(name="baseni", column=@Column(name="baseni", precision=17, scale=17) ), 
        @AttributeOverride(name="valret", column=@Column(name="valret", precision=6) ), 
        @AttributeOverride(name="chartId", column=@Column(name="chart_id") ) } )
    public RetencId getId() {
        return this.id;
    }
    
    public void setId(RetencId id) {
        this.id = id;
    }




}


