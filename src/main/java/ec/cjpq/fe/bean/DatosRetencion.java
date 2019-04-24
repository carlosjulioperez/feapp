package ec.cjpq.fe.bean;

import java.math.BigDecimal;

import lombok.Data;

/**
 * Pojo para almacenar retenciones en DAO
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2016-06-04
 * 2016-06-09 Agregar columna idprov
 * 2016-06-10 Agregar columna id
 * 2016-06-11 email, phone
 */
@Data
public class DatosRetencion {
	private Integer id; 
	private String name;
	private String idprov;
	private String email;
	private String cc;
	private String phone;
	private String code; 
	private String tipodocId;
	private String estab; 
	private String ptoemi; 
	private String sec; 
	private String transdate; 
	private Integer tiporetId; 
	private String tiporet; 
	private String secret; 
	private String transdateret; 
	private Double base0; 
	private Double based0; 
	private Double baseni; 
	private Integer porcret; 
	private BigDecimal valret; 
}
