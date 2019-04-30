package ec.cjpq.cjfews.util;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LectorXPath {

	private static final Logger log = LogManager.getLogger(LectorXPath.class);

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
	        log.warn(Util.stack2String(e));
		}
	}

	public Object leerArchivo(String expression, QName returnType) {
		try {
			XPathExpression xPathExpression = this.xPath.compile(expression);
			return xPathExpression.evaluate(this.xmlDocument, returnType);
		} catch (Exception e) {
	        log.warn(Util.stack2String(e));
		}
		return null;
	}

}
