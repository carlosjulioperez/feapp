package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Vr por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="vr",schema="public")
public class Vr  implements java.io.Serializable
 {


     private VrId id;
     private Br br;

    public Vr() {
    }

	
    public Vr(VrId id) {
        this.id = id;
    }
    public Vr(VrId id, Br br) {
       this.id = id;
       this.br = br;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="brId", column=@Column(name="br_id") ), 
        @AttributeOverride(name="transId", column=@Column(name="trans_id", nullable=false) ), 
        @AttributeOverride(name="id", column=@Column(name="id", nullable=false) ), 
        @AttributeOverride(name="vouchernumber", column=@Column(name="vouchernumber") ) } )
    public VrId getId() {
        return this.id;
    }
    
    public void setId(VrId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="br_id", insertable=false, updatable=false)
    public Br getBr() {
        return this.br;
    }
    
    public void setBr(Br br) {
        this.br = br;
    }




}


