package ec.cjpq.fe.bean;

import java.math.BigDecimal;

import lombok.Data;

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
