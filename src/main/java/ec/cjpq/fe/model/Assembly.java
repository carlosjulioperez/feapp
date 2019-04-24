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
 * Assembly por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="assembly",schema="public")
public class Assembly  implements java.io.Serializable
 {


     private AssemblyId id;

    public Assembly() {
    }

    public Assembly(AssemblyId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id") ), 
        @AttributeOverride(name="partsId", column=@Column(name="parts_id") ), 
        @AttributeOverride(name="qty", column=@Column(name="qty", precision=17, scale=17) ), 
        @AttributeOverride(name="bom", column=@Column(name="bom") ), 
        @AttributeOverride(name="adj", column=@Column(name="adj") ), 
        @AttributeOverride(name="aid", column=@Column(name="aid") ) } )
    public AssemblyId getId() {
        return this.id;
    }
    
    public void setId(AssemblyId id) {
        this.id = id;
    }




}


