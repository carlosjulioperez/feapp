package ec.cjpq.cjfews.util;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;

import ec.cjpq.util.Utileria;


public class LectorXPath {

	private static final Logger log = Logger.getLogger(LectorXPath.class);

	private String xmlFile;
	private Document xmlDocument;
	private XPath xPath;

	public LectorXPath(String xmlFile) {
		this.xmlFile = xmlFile;
		inicializar();
	}

	private void inicializar() {
		try {
			this.xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(this.xmlFile);
			this.xPath = XPathFactory.newInstance().newXPath();
		} catch (Exception e) {
	        log.warn(Utileria.stack2String(e));
		}
	}

	public Object leerArchivo(String expression, QName returnType) {
		try {
			XPathExpression xPathExpression = this.xPath.compile(expression);
			return xPathExpression.evaluate(this.xmlDocument, returnType);
		} catch (Exception e) {
	        log.warn(Utileria.stack2String(e));
		}
		return null;
	}

}
