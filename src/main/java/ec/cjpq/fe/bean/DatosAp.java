package ec.cjpq.fe.bean;

import lombok.Data;

@Data
public class DatosAp {
	private Integer id; 
	private String transdate; 
	private String invnumber;
	private String name;
	private String email;
	private String description;
	private Double amount; 
	private Double netamount;
	private String transdateto; //Usado como filtro para la consulta
	private String ponumber;
	private String gifiAccno;
	private String cc;
	private String notes;
	private String phone;
}
