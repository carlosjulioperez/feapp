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
 * OpeningGl por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="opening_gl",schema="public")
public class OpeningGl  implements java.io.Serializable
 {


     private OpeningGlId id;

    public OpeningGl() {
    }

    public OpeningGl(OpeningGlId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="departmentId", column=@Column(name="department_id") ), 
        @AttributeOverride(name="chartId", column=@Column(name="chart_id") ), 
        @AttributeOverride(name="amount", column=@Column(name="amount", precision=17, scale=17) ) } )
    public OpeningGlId getId() {
        return this.id;
    }
    
    public void setId(OpeningGlId id) {
        this.id = id;
    }




}


