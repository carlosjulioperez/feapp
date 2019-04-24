package ec.cjpq.cjfews.comprobante.guia;

import java.util.List;

import javax.xml.bind.annotation.XmlType;

import lombok.Data;
import ec.cjpq.cjfews.comprobante.DetAdicional;

@Data
@XmlType(name="guiaRemisionDetalle")
public class GuiaRemisionDetalle {

    private String codigoInterno; 
    private String codigoAdicional;
    private String descripcion;
    private String cantidad;
    
    private List<DetAdicional> detallesAdicionales;

}
