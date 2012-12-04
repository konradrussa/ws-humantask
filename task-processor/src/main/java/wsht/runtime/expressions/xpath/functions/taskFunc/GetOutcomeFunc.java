package wsht.runtime.expressions.xpath.functions.taskFunc;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;

public class GetOutcomeFunc implements XPathFunction {
	
	//IN
	//part name
	private String taskName; //optional
	//OUT
	//the task outcome (xsd:string)
	
	//Returns the outcome of the task. 
	//It MUST evaluate to an empty string in case there is no outcome specified for the task.
	//If the task name is not present the current task MUST be considered.
	
	final static QName functionName = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803", "getOutcome", "htd");

	public Object evaluate(List args) throws XPathFunctionException {
		return null;
	}

	public static QName getFunctionname() {
		return functionName;
	}

}
