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
 * Project por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="project",schema="public", uniqueConstraints = @UniqueConstraint(columnNames="projectnumber"))
public class Project  implements java.io.Serializable
 {


     private ProjectId id;

    public Project() {
    }

    public Project(ProjectId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id") ), 
        @AttributeOverride(name="projectnumber", column=@Column(name="projectnumber", unique=true) ), 
        @AttributeOverride(name="description", column=@Column(name="description") ), 
        @AttributeOverride(name="startdate", column=@Column(name="startdate", length=13) ), 
        @AttributeOverride(name="enddate", column=@Column(name="enddate", length=13) ), 
        @AttributeOverride(name="partsId", column=@Column(name="parts_id") ), 
        @AttributeOverride(name="production", column=@Column(name="production", precision=17, scale=17) ), 
        @AttributeOverride(name="completed", column=@Column(name="completed", precision=17, scale=17) ), 
        @AttributeOverride(name="customerId", column=@Column(name="customer_id") ) } )
    public ProjectId getId() {
        return this.id;
    }
    
    public void setId(ProjectId id) {
        this.id = id;
    }




}


