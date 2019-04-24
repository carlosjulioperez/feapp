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
 * Jcitems por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="jcitems",schema="public")
public class Jcitems  implements java.io.Serializable
 {


     private JcitemsId id;

    public Jcitems() {
    }

    public Jcitems(JcitemsId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="id") ), 
        @AttributeOverride(name="projectId", column=@Column(name="project_id") ), 
        @AttributeOverride(name="partsId", column=@Column(name="parts_id") ), 
        @AttributeOverride(name="description", column=@Column(name="description") ), 
        @AttributeOverride(name="qty", column=@Column(name="qty", precision=17, scale=17) ), 
        @AttributeOverride(name="allocated", column=@Column(name="allocated", precision=17, scale=17) ), 
        @AttributeOverride(name="sellprice", column=@Column(name="sellprice", precision=17, scale=17) ), 
        @AttributeOverride(name="fxsellprice", column=@Column(name="fxsellprice", precision=17, scale=17) ), 
        @AttributeOverride(name="serialnumber", column=@Column(name="serialnumber") ), 
        @AttributeOverride(name="checkedin", column=@Column(name="checkedin", length=35) ), 
        @AttributeOverride(name="checkedout", column=@Column(name="checkedout", length=35) ), 
        @AttributeOverride(name="employeeId", column=@Column(name="employee_id") ), 
        @AttributeOverride(name="notes", column=@Column(name="notes") ) } )
    public JcitemsId getId() {
        return this.id;
    }
    
    public void setId(JcitemsId id) {
        this.id = id;
    }




}


