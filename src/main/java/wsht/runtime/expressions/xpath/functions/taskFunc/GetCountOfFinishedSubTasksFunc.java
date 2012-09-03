package wsht.runtime.expressions.xpath.functions.taskFunc;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;

public class GetCountOfFinishedSubTasksFunc implements XPathFunction {

	//IN
	private String taskName; //optional
	//OUT
	//Number of the finished task sub-tasks. If the task doesn't have sub tasks then 0 is returned

	//Returns the number of finished sub tasks of a task
	//If the task name is not present the current task MUST be considered
	
	final static QName functionName = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803", "getCountOfFinishedSubTasks", "htd");
	
	public Object evaluate(List args) throws XPathFunctionException {
		return null;
	}

	public static QName getFunctionname() {
		return functionName;
	}
	
}
