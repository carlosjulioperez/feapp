package ec.cjpq.cjfews.comprobante;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class DetAdicionalConverter implements Converter{

	@SuppressWarnings("rawtypes")
	public boolean canConvert(Class clazz) {
		return clazz.equals(DetAdicional.class);
	}

	public void marshal(Object valor, HierarchicalStreamWriter writer, MarshallingContext context) {
		DetAdicional detAdicional = (DetAdicional)valor;
		writer.addAttribute("nombre", detAdicional.getNombre());
		writer.addAttribute("valor", detAdicional.getValor());
	}

	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		DetAdicional detAdicional = new DetAdicional();
		detAdicional.setNombre(reader.getAttribute("nombre"));
		detAdicional.setValor(reader.getAttribute("valor"));
		return detAdicional;
	}

}
