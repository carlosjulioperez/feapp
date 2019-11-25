package ec.cjpq.fe.model;
// Autor: CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com 099-3208265 Guayaquil-Ecuador
// Generated 10/07/2016 07:32:40 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FeColaAut por hbm2java el 10/07/2016 07:32:40 PM - Hibernate Tools 3.2.4.GA
 */
@Entity
@Table(name="fe_cola_aut",schema="public")
public class FeColaAut  implements java.io.Serializable
 {


     private int colaId;
     private String tipoComp;
     private String fecha;
     private String numeroSl;
     private String cliente;
     private Double total;
     private String mensaje;
     private String numAut;
     private String fecAut;
     private Boolean autorizado;
     private String numSec;
     private String archivo;

    public FeColaAut() {
    }

	
    public FeColaAut(int colaId) {
        this.colaId = colaId;
    }
    public FeColaAut(int colaId, String tipoComp, String fecha, String numeroSl, String cliente, Double total, String mensaje, String numAut, String fecAut, Boolean autorizado, String numSec, String archivo) {
       this.colaId = colaId;
       this.tipoComp = tipoComp;
       this.fecha = fecha;
       this.numeroSl = numeroSl;
       this.cliente = cliente;
       this.total = total;
       this.mensaje = mensaje;
       this.numAut = numAut;
       this.fecAut = fecAut;
       this.autorizado = autorizado;
       this.numSec = numSec;
       this.archivo = archivo;
    }
   
     @Id 

    
    @Column(name="cola_id", unique=true, nullable=false)
    public int getColaId() {
        return this.colaId;
    }
    
    public void setColaId(int colaId) {
        this.colaId = colaId;
    }

    
    @Column(name="tipo_comp", length=2)
    public String getTipoComp() {
        return this.tipoComp;
    }
    
    public void setTipoComp(String tipoComp) {
        this.tipoComp = tipoComp;
    }

    
    @Column(name="fecha", length=10)
    public String getFecha() {
        return this.fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
    @Column(name="numero_sl", length=20)
    public String getNumeroSl() {
        return this.numeroSl;
    }
    
    public void setNumeroSl(String numeroSl) {
        this.numeroSl = numeroSl;
    }

    
    @Column(name="cliente", length=64)
    public String getCliente() {
        return this.cliente;
    }
    
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    
    @Column(name="total", precision=17, scale=17)
    public Double getTotal() {
        return this.total;
    }
    
    public void setTotal(Double total) {
        this.total = total;
    }

    
    @Column(name="mensaje")
    public String getMensaje() {
        return this.mensaje;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    
    @Column(name="num_aut", length=40)
    public String getNumAut() {
        return this.numAut;
    }
    
    public void setNumAut(String numAut) {
        this.numAut = numAut;
    }

    
    @Column(name="fec_aut", length=40)
    public String getFecAut() {
        return this.fecAut;
    }
    
    public void setFecAut(String fecAut) {
        this.fecAut = fecAut;
    }

    
    @Column(name="autorizado")
    public Boolean getAutorizado() {
        return this.autorizado;
    }
    
    public void setAutorizado(Boolean autorizado) {
        this.autorizado = autorizado;
    }

    
    @Column(name="num_sec", length=20)
    public String getNumSec() {
        return this.numSec;
    }
    
    public void setNumSec(String numSec) {
        this.numSec = numSec;
    }

    
    @Column(name="archivo", length=42)
    public String getArchivo() {
        return this.archivo;
    }
    
    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }




}


