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
 * Yearend por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="yearend",schema="public")
public class Yearend  implements java.io.Serializable
 {


     private YearendId id;

    public Yearend() {
    }

    public Yearend(YearendId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="transId", column=@Column(name="trans_id") ), 
        @AttributeOverride(name="transdate", column=@Column(name="transdate", length=13) ) } )
    public YearendId getId() {
        return this.id;
    }
    
    public void setId(YearendId id) {
        this.id = id;
    }




}


