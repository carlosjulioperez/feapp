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
 * Language por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="language",schema="public", uniqueConstraints = @UniqueConstraint(columnNames="code"))
public class Language  implements java.io.Serializable
 {


     private LanguageId id;

    public Language() {
    }

    public Language(LanguageId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="code", column=@Column(name="code", unique=true, length=6) ), 
        @AttributeOverride(name="description", column=@Column(name="description") ) } )
    public LanguageId getId() {
        return this.id;
    }
    
    public void setId(LanguageId id) {
        this.id = id;
    }




}


