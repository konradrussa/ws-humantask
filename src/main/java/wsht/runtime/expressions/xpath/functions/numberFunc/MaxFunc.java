package wsht.runtime.expressions.xpath.functions.numberFunc;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;

public class MaxFunc implements XPathFunction {
	
	//IN
	//node-set of number nodes
	
	//Returns the maximum value of all number nodes - returns NaN for an empty node-set
	
	final static QName functionName = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803", "avg", "htd");

	public Object evaluate(List args) throws XPathFunctionException {
		
		return null;
	}

	public static QName getFunctionname() {
		return functionName;
	}

}