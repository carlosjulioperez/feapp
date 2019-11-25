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
 * Department por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="department",schema="public")
public class Department  implements java.io.Serializable
 {


     private DepartmentId id;

    public Department() {
    }

    public Department(DepartmentId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id") ), 
        @AttributeOverride(name="description", column=@Column(name="description") ), 
        @AttributeOverride(name="role", column=@Column(name="role", length=1) ) } )
    public DepartmentId getId() {
        return this.id;
    }
    
    public void setId(DepartmentId id) {
        this.id = id;
    }




}


