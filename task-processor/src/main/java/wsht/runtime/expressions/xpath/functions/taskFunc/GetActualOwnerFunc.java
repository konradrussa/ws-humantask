package wsht.runtime.expressions.xpath.functions.taskFunc;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;

public class GetActualOwnerFunc implements XPathFunction {
	
	//IN
	private String taskName; //optional
	//OUT
	//the actual owner (user id as htt:user)
	
	//Returns the actual owner of the task. 
	//It MUST evaluate to an empty htt:user in case there is no actual owner.
	//If the task name is not present the current task MUST be considered.	
	
	
	final static QName functionName = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803", "getActualOwner", "htd");
	
	public Object evaluate(List args) throws XPathFunctionException {
		return null;
	}

	public static QName getFunctionname() {
		return functionName;
	}
	
}
