package ec.cjpq.cjfews.comprobante;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * Converter para el nodo infoAdicional/campoAdicional
 * https://stackoverflow.com/questions/2533800/xstream-parse-attributes-and-values-at-the-same-time
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2015-03-18, 24
 */
public class CampoAdicionalConverter implements Converter{

	@SuppressWarnings("rawtypes")
	public boolean canConvert(Class clazz) {
		return clazz.equals(CampoAdicional.class); 
	}

	public void marshal(Object valor, HierarchicalStreamWriter writer, MarshallingContext context) {
		CampoAdicional campoAdicional = (CampoAdicional)valor;
		writer.addAttribute("nombre", campoAdicional.getNombre());
		writer.setValue(campoAdicional.getValor());
	}

	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		CampoAdicional campoAdicional = new CampoAdicional();
		campoAdicional.setNombre(reader.getAttribute("nombre"));
		campoAdicional.setValor(reader.getValue());
		return campoAdicional;
	}
	
}
