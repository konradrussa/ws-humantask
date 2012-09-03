package wsht.runtime.expressions.xpath.functions.taskFunc;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;

import wsht.runtime.enums.TaskStatesEnum;

public class GetCountOfSubTasksWithOutcomeFunc implements XPathFunction {

	//IN
	//outcome
	private String taskName; //optional
	//OUT
	//Number of the task sub tasks that match the specified outcome. If the task doesn't have sub tasks then 0 is returned
	
	//Returns the number of a task sub tasks that match the given outcome
	//If the task name is not present the current task MUST be considered
	
	final static QName functionName = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803", "getCountOfSubTasksWithOutcome", "htd");

	@Override
	public Object evaluate(List args) throws XPathFunctionException {
		return null;
	}

	public static QName getFunctionname() {
		return functionName;
	}
	
}
