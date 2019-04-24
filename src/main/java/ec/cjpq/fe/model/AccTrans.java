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
 * AccTrans por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="acc_trans",schema="public")
public class AccTrans  implements java.io.Serializable
 {


     private AccTransId id;

    public AccTrans() {
    }

    public AccTrans(AccTransId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="transId", column=@Column(name="trans_id") ), 
        @AttributeOverride(name="chartId", column=@Column(name="chart_id") ), 
        @AttributeOverride(name="amount", column=@Column(name="amount", precision=17, scale=17) ), 
        @AttributeOverride(name="transdate", column=@Column(name="transdate", length=13) ), 
        @AttributeOverride(name="source", column=@Column(name="source") ), 
        @AttributeOverride(name="approved", column=@Column(name="approved") ), 
        @AttributeOverride(name="fxTransaction", column=@Column(name="fx_transaction") ), 
        @AttributeOverride(name="projectId", column=@Column(name="project_id") ), 
        @AttributeOverride(name="memo", column=@Column(name="memo") ), 
        @AttributeOverride(name="id", column=@Column(name="id") ), 
        @AttributeOverride(name="cleared", column=@Column(name="cleared", length=13) ), 
        @AttributeOverride(name="vrId", column=@Column(name="vr_id") ), 
        @AttributeOverride(name="cvId", column=@Column(name="cv_id") ) } )
    public AccTransId getId() {
        return this.id;
    }
    
    public void setId(AccTransId id) {
        this.id = id;
    }




}


