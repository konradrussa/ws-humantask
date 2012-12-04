package wsht.runtime.expressions.xpath.functions.taskFunc;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;

public class GetTaskPriorityFunc implements XPathFunction {

	//IN
	//task name (optional)
	//OUT
	//priority (htt:tPriority)
	
	//Returns the priority of the task.
	//It MUST evaluate to “5” in case the priority is not explicitly set.
	//If the task name is not present the current task MUST be considered.
	
	final static QName functionName = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803", "getTaskPriority", "htd");

	public Object evaluate(List args) throws XPathFunctionException {
		return null;
	}

	public static QName getFunctionname() {
		return functionName;
	}
	
}
