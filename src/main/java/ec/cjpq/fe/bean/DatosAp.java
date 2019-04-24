package ec.cjpq.fe.bean;

import lombok.Data;

/**
 * Pojo para almacenar transacciones Ap de N/D en DAO.
 * También se usa pojo de parámetros de databinding en datosnotadebito.zul
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2016-07-26
 * 2016-06-28 Agregar campos adicionales como gifiAccno
 * 2016-07-31 Agregar campo cc
 * 2016-08-03 Agregar netamount
 * 2016-08-05 Agregar notes y vendor.phone
 */
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
