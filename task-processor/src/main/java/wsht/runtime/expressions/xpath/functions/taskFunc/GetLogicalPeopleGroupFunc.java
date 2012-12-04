package wsht.runtime.expressions.xpath.functions.taskFunc;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;

public class GetLogicalPeopleGroupFunc implements XPathFunction {

	//IN
	//name of the logical people group
	//The optional parameters that follow MUST appear in pairs. Each pair is defined as:
	//	o the qualified name of a logical people group parameter
	//	o the value for the named logical people group parameter; it can be an XPath expression
	//OUT
	//the value of the logical people group (htt:organizationalEntity)
	
	//Returns the value of a logical people group. 
	//In case of an error (e.g., when referencing a non existing logical people group) 
	//the htt:organizationalEntity MUST contain an empty user list.
	//If the task name is not present the current task MUST be considered.
	
	final static QName functionName = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803", "getLogicalPeopleGroup", "htd");

	public Object evaluate(List args) throws XPathFunctionException {
		
		return null;
	}

	public static QName getFunctionname() {
		return functionName;
	}
	
}
