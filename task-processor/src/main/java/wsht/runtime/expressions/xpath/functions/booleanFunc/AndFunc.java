package wsht.runtime.expressions.xpath.functions.booleanFunc;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;

import org.w3c.dom.NodeList;

public class AndFunc implements XPathFunction {

	//IN
	//node-set of boolean nodes
	
	//Returns the conjunction of all boolean nodes - returns false for an empty node-set
	
	final static QName functionName = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803", "and", "htd");

	public Object evaluate(List args) throws XPathFunctionException {
		Boolean value = true;
		boolean first = true; 
		if(args == null || args.isEmpty()) return false;
		for(Object arg : args) {
			if(arg instanceof Boolean) {
				Boolean b = (Boolean) arg;
				if(first)
					value = b;
				first = false;
				value =  value && b;
			} else
	            throw new XPathFunctionException("invalid argument: " + arg);
		}
		return value;
	}

	public static QName getFunctionname() {
		return functionName;
	}

}