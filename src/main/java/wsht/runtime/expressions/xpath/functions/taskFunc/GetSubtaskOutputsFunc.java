package wsht.runtime.expressions.xpath.functions.taskFunc;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;

public class GetSubtaskOutputsFunc implements XPathFunction {

	//IN
	// part name
	// location path
	//OUT
	//node-set of output message elements from sub tasks
	
	//Returns a node-set of simple-typed or complex-typed elements, 
	//constructed from the sub tasks‟ output documents in a routing pattern. 
	//The string parameter contains a location path evaluated on each sub task‟s output document. 
	//The individual node-sets are combined into the returned node-set. 
	//Only completed sub tasks of the current task MUST be considered
	
	final static QName functionName = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803", "getSubtaskOutputs", "htd");

	public Object evaluate(List args) throws XPathFunctionException {
		return null;
	}

	public static QName getFunctionname() {
		return functionName;
	}

}
