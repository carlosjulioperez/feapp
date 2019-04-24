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
 * Tiporet por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="tiporet",schema="public")
public class Tiporet  implements java.io.Serializable
 {


     private TiporetId id;

    public Tiporet() {
    }

    public Tiporet(TiporetId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id", nullable=false) ), 
        @AttributeOverride(name="description", column=@Column(name="description", length=120) ), 
        @AttributeOverride(name="porcret", column=@Column(name="porcret") ), 
        @AttributeOverride(name="impuesto", column=@Column(name="impuesto", length=10) ) } )
    public TiporetId getId() {
        return this.id;
    }
    
    public void setId(TiporetId id) {
        this.id = id;
    }




}


