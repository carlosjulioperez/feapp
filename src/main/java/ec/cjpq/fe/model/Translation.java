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
 * Translation por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="translation",schema="public")
public class Translation  implements java.io.Serializable
 {


     private TranslationId id;

    public Translation() {
    }

    public Translation(TranslationId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="transId", column=@Column(name="trans_id") ), 
        @AttributeOverride(name="languageCode", column=@Column(name="language_code", length=6) ), 
        @AttributeOverride(name="description", column=@Column(name="description") ) } )
    public TranslationId getId() {
        return this.id;
    }
    
    public void setId(TranslationId id) {
        this.id = id;
    }




}


