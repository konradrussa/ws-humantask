package wsht.runtime.expressions.xpath.functions.stringFunc;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;

public class ConcatWithDelimiterFunc implements XPathFunction {

	//IN
	// node-set of string nodes
	// delimiter string
	
	//Returns the concatenation of all string nodes, 
	//separated by the specified delimiter string - returns an empty string for an empty node-set
	
	final static QName functionName = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803", "concatWithDelimiter", "htd");

	public Object evaluate(List args) throws XPathFunctionException {
		return null;
	}

	public static QName getFunctionname() {
		return functionName;
	}

}
