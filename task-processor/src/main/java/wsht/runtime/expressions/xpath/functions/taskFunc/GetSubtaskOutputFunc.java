package wsht.runtime.expressions.xpath.functions.taskFunc;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;

public class GetSubtaskOutputFunc implements XPathFunction {

	//IN
	// sub task name
	// part name
	// location path
	//OUT
	//node-set of output message element(s)
	
	//Returns a node-set representing the specified part or contained elements of a sub task‟s output message. 
	//Only completed sub tasks of the current task MUST be considered
	
	final static QName functionName = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803", "getSubtaskOutput", "htd");

	public Object evaluate(List args) throws XPathFunctionException {
		
		return null;
	}

	public static QName getFunctionname() {
		return functionName;
	}
	
	
}
