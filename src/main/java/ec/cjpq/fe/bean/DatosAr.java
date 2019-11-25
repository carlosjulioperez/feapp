package ec.cjpq.fe.bean;

import lombok.Data;

@Data
public class DatosAr {
	private Integer id; 
	private String transdate; 
	private String invnumber;
	private String name;
	private String email;
	private String description;
	private Double amount; 
	private Double netamount;
	private String transdateto; //Usado como filtro para la consulta
	private String ordnumber;
	private String tipo;
	private String ponumber;
	private String taxnumber;
	private String cc;
	private String notes;
	private String phone;
}
