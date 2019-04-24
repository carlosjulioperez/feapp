package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RetencId por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Embeddable

public class RetencId  implements java.io.Serializable
 {


     private int id;
     private Integer vendorId;
     private String tipoidId;
     private String idprov;
     private Integer tipodocId;
     private String estab;
     private String ptoemi;
     private String sec;
     private String ordnumber;
     private Date transdate;
     private String estabret;
     private String ptoemiret;
     private String secret;
     private String ordnumberret;
     private Date transdateret;
     private Integer tiporetId;
     private Integer porcret;
     private Double base0;
     private Double based0;
     private Double baseni;
     private BigDecimal valret;
     private Integer chartId;

    public RetencId() {
    }

	
    public RetencId(int id) {
        this.id = id;
    }
    public RetencId(int id, Integer vendorId, String tipoidId, String idprov, Integer tipodocId, String estab, String ptoemi, String sec, String ordnumber, Date transdate, String estabret, String ptoemiret, String secret, String ordnumberret, Date transdateret, Integer tiporetId, Integer porcret, Double base0, Double based0, Double baseni, BigDecimal valret, Integer chartId) {
       this.id = id;
       this.vendorId = vendorId;
       this.tipoidId = tipoidId;
       this.idprov = idprov;
       this.tipodocId = tipodocId;
       this.estab = estab;
       this.ptoemi = ptoemi;
       this.sec = sec;
       this.ordnumber = ordnumber;
       this.transdate = transdate;
       this.estabret = estabret;
       this.ptoemiret = ptoemiret;
       this.secret = secret;
       this.ordnumberret = ordnumberret;
       this.transdateret = transdateret;
       this.tiporetId = tiporetId;
       this.porcret = porcret;
       this.base0 = base0;
       this.based0 = based0;
       this.baseni = baseni;
       this.valret = valret;
       this.chartId = chartId;
    }
   


    @Column(name="id", nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }


    @Column(name="vendor_id")
    public Integer getVendorId() {
        return this.vendorId;
    }
    
    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }


    @Column(name="tipoid_id", length=2)
    public String getTipoidId() {
        return this.tipoidId;
    }
    
    public void setTipoidId(String tipoidId) {
        this.tipoidId = tipoidId;
    }


    @Column(name="idprov")
    public String getIdprov() {
        return this.idprov;
    }
    
    public void setIdprov(String idprov) {
        this.idprov = idprov;
    }


    @Column(name="tipodoc_id")
    public Integer getTipodocId() {
        return this.tipodocId;
    }
    
    public void setTipodocId(Integer tipodocId) {
        this.tipodocId = tipodocId;
    }


    @Column(name="estab", length=3)
    public String getEstab() {
        return this.estab;
    }
    
    public void setEstab(String estab) {
        this.estab = estab;
    }


    @Column(name="ptoemi", length=3)
    public String getPtoemi() {
        return this.ptoemi;
    }
    
    public void setPtoemi(String ptoemi) {
        this.ptoemi = ptoemi;
    }


    @Column(name="sec", length=9)
    public String getSec() {
        return this.sec;
    }
    
    public void setSec(String sec) {
        this.sec = sec;
    }


    @Column(name="ordnumber")
    public String getOrdnumber() {
        return this.ordnumber;
    }
    
    public void setOrdnumber(String ordnumber) {
        this.ordnumber = ordnumber;
    }


    @Column(name="transdate", length=13)
    public Date getTransdate() {
        return this.transdate;
    }
    
    public void setTransdate(Date transdate) {
        this.transdate = transdate;
    }


    @Column(name="estabret", length=3)
    public String getEstabret() {
        return this.estabret;
    }
    
    public void setEstabret(String estabret) {
        this.estabret = estabret;
    }


    @Column(name="ptoemiret", length=3)
    public String getPtoemiret() {
        return this.ptoemiret;
    }
    
    public void setPtoemiret(String ptoemiret) {
        this.ptoemiret = ptoemiret;
    }


    @Column(name="secret", length=9)
    public String getSecret() {
        return this.secret;
    }
    
    public void setSecret(String secret) {
        this.secret = secret;
    }


    @Column(name="ordnumberret")
    public String getOrdnumberret() {
        return this.ordnumberret;
    }
    
    public void setOrdnumberret(String ordnumberret) {
        this.ordnumberret = ordnumberret;
    }


    @Column(name="transdateret", length=13)
    public Date getTransdateret() {
        return this.transdateret;
    }
    
    public void setTransdateret(Date transdateret) {
        this.transdateret = transdateret;
    }


    @Column(name="tiporet_id")
    public Integer getTiporetId() {
        return this.tiporetId;
    }
    
    public void setTiporetId(Integer tiporetId) {
        this.tiporetId = tiporetId;
    }


    @Column(name="porcret")
    public Integer getPorcret() {
        return this.porcret;
    }
    
    public void setPorcret(Integer porcret) {
        this.porcret = porcret;
    }


    @Column(name="base0", precision=17, scale=17)
    public Double getBase0() {
        return this.base0;
    }
    
    public void setBase0(Double base0) {
        this.base0 = base0;
    }


    @Column(name="based0", precision=17, scale=17)
    public Double getBased0() {
        return this.based0;
    }
    
    public void setBased0(Double based0) {
        this.based0 = based0;
    }


    @Column(name="baseni", precision=17, scale=17)
    public Double getBaseni() {
        return this.baseni;
    }
    
    public void setBaseni(Double baseni) {
        this.baseni = baseni;
    }


    @Column(name="valret", precision=6)
    public BigDecimal getValret() {
        return this.valret;
    }
    
    public void setValret(BigDecimal valret) {
        this.valret = valret;
    }


    @Column(name="chart_id")
    public Integer getChartId() {
        return this.chartId;
    }
    
    public void setChartId(Integer chartId) {
        this.chartId = chartId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RetencId) ) return false;
		 RetencId castOther = ( RetencId ) other; 
         
		 return (this.getId()==castOther.getId())
 && ( (this.getVendorId()==castOther.getVendorId()) || ( this.getVendorId()!=null && castOther.getVendorId()!=null && this.getVendorId().equals(castOther.getVendorId()) ) )
 && ( (this.getTipoidId()==castOther.getTipoidId()) || ( this.getTipoidId()!=null && castOther.getTipoidId()!=null && this.getTipoidId().equals(castOther.getTipoidId()) ) )
 && ( (this.getIdprov()==castOther.getIdprov()) || ( this.getIdprov()!=null && castOther.getIdprov()!=null && this.getIdprov().equals(castOther.getIdprov()) ) )
 && ( (this.getTipodocId()==castOther.getTipodocId()) || ( this.getTipodocId()!=null && castOther.getTipodocId()!=null && this.getTipodocId().equals(castOther.getTipodocId()) ) )
 && ( (this.getEstab()==castOther.getEstab()) || ( this.getEstab()!=null && castOther.getEstab()!=null && this.getEstab().equals(castOther.getEstab()) ) )
 && ( (this.getPtoemi()==castOther.getPtoemi()) || ( this.getPtoemi()!=null && castOther.getPtoemi()!=null && this.getPtoemi().equals(castOther.getPtoemi()) ) )
 && ( (this.getSec()==castOther.getSec()) || ( this.getSec()!=null && castOther.getSec()!=null && this.getSec().equals(castOther.getSec()) ) )
 && ( (this.getOrdnumber()==castOther.getOrdnumber()) || ( this.getOrdnumber()!=null && castOther.getOrdnumber()!=null && this.getOrdnumber().equals(castOther.getOrdnumber()) ) )
 && ( (this.getTransdate()==castOther.getTransdate()) || ( this.getTransdate()!=null && castOther.getTransdate()!=null && this.getTransdate().equals(castOther.getTransdate()) ) )
 && ( (this.getEstabret()==castOther.getEstabret()) || ( this.getEstabret()!=null && castOther.getEstabret()!=null && this.getEstabret().equals(castOther.getEstabret()) ) )
 && ( (this.getPtoemiret()==castOther.getPtoemiret()) || ( this.getPtoemiret()!=null && castOther.getPtoemiret()!=null && this.getPtoemiret().equals(castOther.getPtoemiret()) ) )
 && ( (this.getSecret()==castOther.getSecret()) || ( this.getSecret()!=null && castOther.getSecret()!=null && this.getSecret().equals(castOther.getSecret()) ) )
 && ( (this.getOrdnumberret()==castOther.getOrdnumberret()) || ( this.getOrdnumberret()!=null && castOther.getOrdnumberret()!=null && this.getOrdnumberret().equals(castOther.getOrdnumberret()) ) )
 && ( (this.getTransdateret()==castOther.getTransdateret()) || ( this.getTransdateret()!=null && castOther.getTransdateret()!=null && this.getTransdateret().equals(castOther.getTransdateret()) ) )
 && ( (this.getTiporetId()==castOther.getTiporetId()) || ( this.getTiporetId()!=null && castOther.getTiporetId()!=null && this.getTiporetId().equals(castOther.getTiporetId()) ) )
 && ( (this.getPorcret()==castOther.getPorcret()) || ( this.getPorcret()!=null && castOther.getPorcret()!=null && this.getPorcret().equals(castOther.getPorcret()) ) )
 && ( (this.getBase0()==castOther.getBase0()) || ( this.getBase0()!=null && castOther.getBase0()!=null && this.getBase0().equals(castOther.getBase0()) ) )
 && ( (this.getBased0()==castOther.getBased0()) || ( this.getBased0()!=null && castOther.getBased0()!=null && this.getBased0().equals(castOther.getBased0()) ) )
 && ( (this.getBaseni()==castOther.getBaseni()) || ( this.getBaseni()!=null && castOther.getBaseni()!=null && this.getBaseni().equals(castOther.getBaseni()) ) )
 && ( (this.getValret()==castOther.getValret()) || ( this.getValret()!=null && castOther.getValret()!=null && this.getValret().equals(castOther.getValret()) ) )
 && ( (this.getChartId()==castOther.getChartId()) || ( this.getChartId()!=null && castOther.getChartId()!=null && this.getChartId().equals(castOther.getChartId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getId();
         result = 37 * result + ( getVendorId() == null ? 0 : this.getVendorId().hashCode() );
         result = 37 * result + ( getTipoidId() == null ? 0 : this.getTipoidId().hashCode() );
         result = 37 * result + ( getIdprov() == null ? 0 : this.getIdprov().hashCode() );
         result = 37 * result + ( getTipodocId() == null ? 0 : this.getTipodocId().hashCode() );
         result = 37 * result + ( getEstab() == null ? 0 : this.getEstab().hashCode() );
         result = 37 * result + ( getPtoemi() == null ? 0 : this.getPtoemi().hashCode() );
         result = 37 * result + ( getSec() == null ? 0 : this.getSec().hashCode() );
         result = 37 * result + ( getOrdnumber() == null ? 0 : this.getOrdnumber().hashCode() );
         result = 37 * result + ( getTransdate() == null ? 0 : this.getTransdate().hashCode() );
         result = 37 * result + ( getEstabret() == null ? 0 : this.getEstabret().hashCode() );
         result = 37 * result + ( getPtoemiret() == null ? 0 : this.getPtoemiret().hashCode() );
         result = 37 * result + ( getSecret() == null ? 0 : this.getSecret().hashCode() );
         result = 37 * result + ( getOrdnumberret() == null ? 0 : this.getOrdnumberret().hashCode() );
         result = 37 * result + ( getTransdateret() == null ? 0 : this.getTransdateret().hashCode() );
         result = 37 * result + ( getTiporetId() == null ? 0 : this.getTiporetId().hashCode() );
         result = 37 * result + ( getPorcret() == null ? 0 : this.getPorcret().hashCode() );
         result = 37 * result + ( getBase0() == null ? 0 : this.getBase0().hashCode() );
         result = 37 * result + ( getBased0() == null ? 0 : this.getBased0().hashCode() );
         result = 37 * result + ( getBaseni() == null ? 0 : this.getBaseni().hashCode() );
         result = 37 * result + ( getValret() == null ? 0 : this.getValret().hashCode() );
         result = 37 * result + ( getChartId() == null ? 0 : this.getChartId().hashCode() );
         return result;
   }   


}


