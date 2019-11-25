package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FeConfig por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="fe_config",schema="public")
public class FeConfig  implements java.io.Serializable
 {


     private short id;
     private String emiRuc;
     private String emiRazSocial;
     private String emiNomComerc;
     private String emiDirMatriz;
     private String emiDirEstabl;
     private String emiCodEstabl;
     private String emiCodPtoEmi;
     private String emiNumResoluc;
     private String emiOblContab;
     private String emiLogo;
     private String dirGenerados;
     private String dirFirmados;
     private String dirAutorizados;
     private String dirNoautotizados;
     private String p12Archivo;
     private String p12Clave;
     private Short cfgTipEmision;
     private Short cfgTipAmbiente;
     private Integer cfgSecFactura;
     private Integer cfgSecNcredito;
     private Integer cfgSecNdebito;
     private Integer cfgSecGremision;
     private Integer cfgSecCretencion;
     private Short emailPuertoTsl;
     private String emailAsunto;
     private String emailCuerpoMens;
     private String emailHost;
     private String emailUser;
     private String emailPassword;
     private String emailStarttlsEnab;
     private String emailCc;
     private String emailBcc;
     private Short wsTiempoEspera;
     private String wsPrefijoPruebas;
     private String wsPrefijoProduc;

    public FeConfig() {
    }

	
    public FeConfig(short id) {
        this.id = id;
    }
    public FeConfig(short id, String emiRuc, String emiRazSocial, String emiNomComerc, String emiDirMatriz, String emiDirEstabl, String emiCodEstabl, String emiCodPtoEmi, String emiNumResoluc, String emiOblContab, String emiLogo, String dirGenerados, String dirFirmados, String dirAutorizados, String dirNoautotizados, String p12Archivo, String p12Clave, Short cfgTipEmision, Short cfgTipAmbiente, Integer cfgSecFactura, Integer cfgSecNcredito, Integer cfgSecNdebito, Integer cfgSecGremision, Integer cfgSecCretencion, Short emailPuertoTsl, String emailAsunto, String emailCuerpoMens, String emailHost, String emailUser, String emailPassword, String emailStarttlsEnab, String emailCc, String emailBcc, Short wsTiempoEspera, String wsPrefijoPruebas, String wsPrefijoProduc) {
       this.id = id;
       this.emiRuc = emiRuc;
       this.emiRazSocial = emiRazSocial;
       this.emiNomComerc = emiNomComerc;
       this.emiDirMatriz = emiDirMatriz;
       this.emiDirEstabl = emiDirEstabl;
       this.emiCodEstabl = emiCodEstabl;
       this.emiCodPtoEmi = emiCodPtoEmi;
       this.emiNumResoluc = emiNumResoluc;
       this.emiOblContab = emiOblContab;
       this.emiLogo = emiLogo;
       this.dirGenerados = dirGenerados;
       this.dirFirmados = dirFirmados;
       this.dirAutorizados = dirAutorizados;
       this.dirNoautotizados = dirNoautotizados;
       this.p12Archivo = p12Archivo;
       this.p12Clave = p12Clave;
       this.cfgTipEmision = cfgTipEmision;
       this.cfgTipAmbiente = cfgTipAmbiente;
       this.cfgSecFactura = cfgSecFactura;
       this.cfgSecNcredito = cfgSecNcredito;
       this.cfgSecNdebito = cfgSecNdebito;
       this.cfgSecGremision = cfgSecGremision;
       this.cfgSecCretencion = cfgSecCretencion;
       this.emailPuertoTsl = emailPuertoTsl;
       this.emailAsunto = emailAsunto;
       this.emailCuerpoMens = emailCuerpoMens;
       this.emailHost = emailHost;
       this.emailUser = emailUser;
       this.emailPassword = emailPassword;
       this.emailStarttlsEnab = emailStarttlsEnab;
       this.emailCc = emailCc;
       this.emailBcc = emailBcc;
       this.wsTiempoEspera = wsTiempoEspera;
       this.wsPrefijoPruebas = wsPrefijoPruebas;
       this.wsPrefijoProduc = wsPrefijoProduc;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public short getId() {
        return this.id;
    }
    
    public void setId(short id) {
        this.id = id;
    }

    
    @Column(name="emi_ruc", length=15)
    public String getEmiRuc() {
        return this.emiRuc;
    }
    
    public void setEmiRuc(String emiRuc) {
        this.emiRuc = emiRuc;
    }

    
    @Column(name="emi_raz_social", length=70)
    public String getEmiRazSocial() {
        return this.emiRazSocial;
    }
    
    public void setEmiRazSocial(String emiRazSocial) {
        this.emiRazSocial = emiRazSocial;
    }

    
    @Column(name="emi_nom_comerc", length=100)
    public String getEmiNomComerc() {
        return this.emiNomComerc;
    }
    
    public void setEmiNomComerc(String emiNomComerc) {
        this.emiNomComerc = emiNomComerc;
    }

    
    @Column(name="emi_dir_matriz", length=250)
    public String getEmiDirMatriz() {
        return this.emiDirMatriz;
    }
    
    public void setEmiDirMatriz(String emiDirMatriz) {
        this.emiDirMatriz = emiDirMatriz;
    }

    
    @Column(name="emi_dir_establ", length=250)
    public String getEmiDirEstabl() {
        return this.emiDirEstabl;
    }
    
    public void setEmiDirEstabl(String emiDirEstabl) {
        this.emiDirEstabl = emiDirEstabl;
    }

    
    @Column(name="emi_cod_establ", length=3)
    public String getEmiCodEstabl() {
        return this.emiCodEstabl;
    }
    
    public void setEmiCodEstabl(String emiCodEstabl) {
        this.emiCodEstabl = emiCodEstabl;
    }

    
    @Column(name="emi_cod_pto_emi", length=3)
    public String getEmiCodPtoEmi() {
        return this.emiCodPtoEmi;
    }
    
    public void setEmiCodPtoEmi(String emiCodPtoEmi) {
        this.emiCodPtoEmi = emiCodPtoEmi;
    }

    
    @Column(name="emi_num_resoluc", length=5)
    public String getEmiNumResoluc() {
        return this.emiNumResoluc;
    }
    
    public void setEmiNumResoluc(String emiNumResoluc) {
        this.emiNumResoluc = emiNumResoluc;
    }

    
    @Column(name="emi_obl_contab", length=2)
    public String getEmiOblContab() {
        return this.emiOblContab;
    }
    
    public void setEmiOblContab(String emiOblContab) {
        this.emiOblContab = emiOblContab;
    }

    
    @Column(name="emi_logo", length=100)
    public String getEmiLogo() {
        return this.emiLogo;
    }
    
    public void setEmiLogo(String emiLogo) {
        this.emiLogo = emiLogo;
    }

    
    @Column(name="dir_generados", length=100)
    public String getDirGenerados() {
        return this.dirGenerados;
    }
    
    public void setDirGenerados(String dirGenerados) {
        this.dirGenerados = dirGenerados;
    }

    
    @Column(name="dir_firmados", length=100)
    public String getDirFirmados() {
        return this.dirFirmados;
    }
    
    public void setDirFirmados(String dirFirmados) {
        this.dirFirmados = dirFirmados;
    }

    
    @Column(name="dir_autorizados", length=100)
    public String getDirAutorizados() {
        return this.dirAutorizados;
    }
    
    public void setDirAutorizados(String dirAutorizados) {
        this.dirAutorizados = dirAutorizados;
    }

    
    @Column(name="dir_noautotizados", length=100)
    public String getDirNoautotizados() {
        return this.dirNoautotizados;
    }
    
    public void setDirNoautotizados(String dirNoautotizados) {
        this.dirNoautotizados = dirNoautotizados;
    }

    
    @Column(name="p12_archivo", length=100)
    public String getP12Archivo() {
        return this.p12Archivo;
    }
    
    public void setP12Archivo(String p12Archivo) {
        this.p12Archivo = p12Archivo;
    }

    
    @Column(name="p12_clave", length=100)
    public String getP12Clave() {
        return this.p12Clave;
    }
    
    public void setP12Clave(String p12Clave) {
        this.p12Clave = p12Clave;
    }

    
    @Column(name="cfg_tip_emision")
    public Short getCfgTipEmision() {
        return this.cfgTipEmision;
    }
    
    public void setCfgTipEmision(Short cfgTipEmision) {
        this.cfgTipEmision = cfgTipEmision;
    }

    
    @Column(name="cfg_tip_ambiente")
    public Short getCfgTipAmbiente() {
        return this.cfgTipAmbiente;
    }
    
    public void setCfgTipAmbiente(Short cfgTipAmbiente) {
        this.cfgTipAmbiente = cfgTipAmbiente;
    }

    
    @Column(name="cfg_sec_factura")
    public Integer getCfgSecFactura() {
        return this.cfgSecFactura;
    }
    
    public void setCfgSecFactura(Integer cfgSecFactura) {
        this.cfgSecFactura = cfgSecFactura;
    }

    
    @Column(name="cfg_sec_ncredito")
    public Integer getCfgSecNcredito() {
        return this.cfgSecNcredito;
    }
    
    public void setCfgSecNcredito(Integer cfgSecNcredito) {
        this.cfgSecNcredito = cfgSecNcredito;
    }

    
    @Column(name="cfg_sec_ndebito")
    public Integer getCfgSecNdebito() {
        return this.cfgSecNdebito;
    }
    
    public void setCfgSecNdebito(Integer cfgSecNdebito) {
        this.cfgSecNdebito = cfgSecNdebito;
    }

    
    @Column(name="cfg_sec_gremision")
    public Integer getCfgSecGremision() {
        return this.cfgSecGremision;
    }
    
    public void setCfgSecGremision(Integer cfgSecGremision) {
        this.cfgSecGremision = cfgSecGremision;
    }

    
    @Column(name="cfg_sec_cretencion")
    public Integer getCfgSecCretencion() {
        return this.cfgSecCretencion;
    }
    
    public void setCfgSecCretencion(Integer cfgSecCretencion) {
        this.cfgSecCretencion = cfgSecCretencion;
    }

    
    @Column(name="email_puerto_tsl")
    public Short getEmailPuertoTsl() {
        return this.emailPuertoTsl;
    }
    
    public void setEmailPuertoTsl(Short emailPuertoTsl) {
        this.emailPuertoTsl = emailPuertoTsl;
    }

    
    @Column(name="email_asunto", length=100)
    public String getEmailAsunto() {
        return this.emailAsunto;
    }
    
    public void setEmailAsunto(String emailAsunto) {
        this.emailAsunto = emailAsunto;
    }

    
    @Column(name="email_cuerpo_mens", length=400)
    public String getEmailCuerpoMens() {
        return this.emailCuerpoMens;
    }
    
    public void setEmailCuerpoMens(String emailCuerpoMens) {
        this.emailCuerpoMens = emailCuerpoMens;
    }

    
    @Column(name="email_host", length=50)
    public String getEmailHost() {
        return this.emailHost;
    }
    
    public void setEmailHost(String emailHost) {
        this.emailHost = emailHost;
    }

    
    @Column(name="email_user", length=100)
    public String getEmailUser() {
        return this.emailUser;
    }
    
    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    
    @Column(name="email_password", length=30)
    public String getEmailPassword() {
        return this.emailPassword;
    }
    
    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }

    
    @Column(name="email_starttls_enab", length=1)
    public String getEmailStarttlsEnab() {
        return this.emailStarttlsEnab;
    }
    
    public void setEmailStarttlsEnab(String emailStarttlsEnab) {
        this.emailStarttlsEnab = emailStarttlsEnab;
    }

    
    @Column(name="email_cc", length=100)
    public String getEmailCc() {
        return this.emailCc;
    }
    
    public void setEmailCc(String emailCc) {
        this.emailCc = emailCc;
    }

    
    @Column(name="email_bcc", length=100)
    public String getEmailBcc() {
        return this.emailBcc;
    }
    
    public void setEmailBcc(String emailBcc) {
        this.emailBcc = emailBcc;
    }

    
    @Column(name="ws_tiempo_espera")
    public Short getWsTiempoEspera() {
        return this.wsTiempoEspera;
    }
    
    public void setWsTiempoEspera(Short wsTiempoEspera) {
        this.wsTiempoEspera = wsTiempoEspera;
    }

    
    @Column(name="ws_prefijo_pruebas", length=25)
    public String getWsPrefijoPruebas() {
        return this.wsPrefijoPruebas;
    }
    
    public void setWsPrefijoPruebas(String wsPrefijoPruebas) {
        this.wsPrefijoPruebas = wsPrefijoPruebas;
    }

    
    @Column(name="ws_prefijo_produc", length=25)
    public String getWsPrefijoProduc() {
        return this.wsPrefijoProduc;
    }
    
    public void setWsPrefijoProduc(String wsPrefijoProduc) {
        this.wsPrefijoProduc = wsPrefijoProduc;
    }




}
