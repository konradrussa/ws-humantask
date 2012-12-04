package wsht.runtime.expressions.xpath.functions.taskFunc;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;

public class WaitUntilFunc implements XPathFunction {
	
	final static QName functionName = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803", "waitUntil", "htd");

	public Object evaluate(List args) throws XPathFunctionException {
		
		return null;
	}

	public static QName getFunctionname() {
		return functionName;
	}

}
