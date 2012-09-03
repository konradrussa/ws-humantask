package wsht.runtime.expressions.xpath.functions.booleanFunc;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;

public class VoteFunc implements XPathFunction {
	
	//IN
	// node-set of boolean nodes
	// percentage
	
	//Returns the most frequently occurring boolean value 
	//if its occurrence is above the specified percentage, 
	//or false otherwise (including an empty node-set)
	
	final static QName functionName = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803", "vote", "htd");

	public Object evaluate(List args) throws XPathFunctionException {
		
		return null;
	}

	public static QName getFunctionname() {
		return functionName;
	}

}
