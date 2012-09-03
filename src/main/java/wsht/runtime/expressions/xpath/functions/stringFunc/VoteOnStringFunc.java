package wsht.runtime.expressions.xpath.functions.stringFunc;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;

public class VoteOnStringFunc implements XPathFunction {

	//IN
	// node-set of string nodes
	// percentage
	
	//Returns the most frequently occurring string value if its occurrence is 
	//above the specified percentage and there is no tie, 
	//or an empty string otherwise (including an empty node-set)
	
	final static QName functionName = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803", "voteOnString", "htd");

	public Object evaluate(List args) throws XPathFunctionException {
		return null;
	}

	public static QName getFunctionname() {
		return functionName;
	}

}
