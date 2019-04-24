package ec.cjpq.cjfews.comprobante.guia;

import java.util.List;

import javax.xml.bind.annotation.XmlType;

import lombok.Data;
import ec.cjpq.cjfews.comprobante.DetAdicional;

/**
 * Pojo para el XML de los Detalles del Destinatario de la Guía de Remisión
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2015-12-21
 */
@Data
@XmlType(name="guiaRemisionDetalle")
public class GuiaRemisionDetalle {

    private String codigoInterno; 
    private String codigoAdicional;
    private String descripcion;
    private String cantidad;
    
    private List<DetAdicional> detallesAdicionales;

}
