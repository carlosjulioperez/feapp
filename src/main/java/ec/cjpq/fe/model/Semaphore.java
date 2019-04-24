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
 * Semaphore por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="semaphore",schema="public")
public class Semaphore  implements java.io.Serializable
 {


     private SemaphoreId id;

    public Semaphore() {
    }

    public Semaphore(SemaphoreId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id") ), 
        @AttributeOverride(name="login", column=@Column(name="login") ), 
        @AttributeOverride(name="module", column=@Column(name="module") ), 
        @AttributeOverride(name="expires", column=@Column(name="expires", length=10) ) } )
    public SemaphoreId getId() {
        return this.id;
    }
    
    public void setId(SemaphoreId id) {
        this.id = id;
    }




}


