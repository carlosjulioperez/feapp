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
 * NewIds por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="new_ids",schema="public")
public class NewIds  implements java.io.Serializable
 {


     private NewIdsId id;

    public NewIds() {
    }

    public NewIds(NewIdsId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="oldId", column=@Column(name="old_id") ), 
        @AttributeOverride(name="transdate", column=@Column(name="transdate", length=13) ), 
        @AttributeOverride(name="transtype", column=@Column(name="transtype", length=10) ), 
        @AttributeOverride(name="newId", column=@Column(name="new_id") ) } )
    public NewIdsId getId() {
        return this.id;
    }
    
    public void setId(NewIdsId id) {
        this.id = id;
    }




}


