package ec.cjpq.cjfews.comprobante;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

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
