package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SemaphoreId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class SemaphoreId  implements java.io.Serializable
 {


     private Integer id;
     private String login;
     private String module;
     private String expires;

    public SemaphoreId() {
    }

    public SemaphoreId(Integer id, String login, String module, String expires) {
       this.id = id;
       this.login = login;
       this.module = module;
       this.expires = expires;
    }
   


    @Column(name="id")
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name="login")
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }


    @Column(name="module")
    public String getModule() {
        return this.module;
    }
    
    public void setModule(String module) {
        this.module = module;
    }


    @Column(name="expires", length=10)
    public String getExpires() {
        return this.expires;
    }
    
    public void setExpires(String expires) {
        this.expires = expires;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SemaphoreId) ) return false;
		 SemaphoreId castOther = ( SemaphoreId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getLogin()==castOther.getLogin()) || ( this.getLogin()!=null && castOther.getLogin()!=null && this.getLogin().equals(castOther.getLogin()) ) )
 && ( (this.getModule()==castOther.getModule()) || ( this.getModule()!=null && castOther.getModule()!=null && this.getModule().equals(castOther.getModule()) ) )
 && ( (this.getExpires()==castOther.getExpires()) || ( this.getExpires()!=null && castOther.getExpires()!=null && this.getExpires().equals(castOther.getExpires()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getLogin() == null ? 0 : this.getLogin().hashCode() );
         result = 37 * result + ( getModule() == null ? 0 : this.getModule().hashCode() );
         result = 37 * result + ( getExpires() == null ? 0 : this.getExpires().hashCode() );
         return result;
   }   


}


