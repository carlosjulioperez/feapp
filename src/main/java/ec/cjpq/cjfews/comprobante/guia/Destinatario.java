package ec.cjpq.cjfews.comprobante.guia;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Destinatario {

	private String identificacionDestinatario;
	private String razonSocialDestinatario;
	private String dirDestinatario;
	private String motivoTraslado;
	private String docAduaneroUnico;
	private String codEstabDestino;
	private String ruta;
	private String codDocSustento;
	private String numDocSustento;
	private String numAutDocSustento;
	private String fechaEmisionDocSustento;
	private List<GuiaRemisionDetalle> detalles = new ArrayList<GuiaRemisionDetalle>();
	
}
