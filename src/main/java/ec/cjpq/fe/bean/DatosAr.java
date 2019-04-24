package ec.cjpq.fe.bean;

import lombok.Data;

/**
 * Pojo para almacenar transacciones Ar en DAO.
 * También se usa pojo de parámetros de databinding en datosnotacredito.zul
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2016-07-17
 * 2016-08-04 agregar campo "notes" que es "Guía de Remisión" que contendrá la factura referenciada.
 * 2016-08-05 Cambio de funcionalidad para NC y ND
 */
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
