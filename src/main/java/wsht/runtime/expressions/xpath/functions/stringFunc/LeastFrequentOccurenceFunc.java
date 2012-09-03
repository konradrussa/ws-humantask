package wsht.runtime.expressions.xpath.functions.stringFunc;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;

public class LeastFrequentOccurenceFunc implements XPathFunction {

	//IN
	// node-set of string nodes
	
	//Returns the least frequently occurring string value 
	//within all string nodes, or an empty string in case of a tie or for an empty node-set
	
	final static QName functionName = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803", "leastFrequentOccurence", "htd");

	public Object evaluate(List args) throws XPathFunctionException {
		return null;
	}

	public static QName getFunctionname() {
		return functionName;
	}
	
}
