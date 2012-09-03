package wsht.runtime.expressions.xpath.functions.taskFunc;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;

public class GetOutputFunc implements XPathFunction {

	//IN
	//part name
	private String taskName; //optional
	//OUT
	//output message part
	
	//Returns the part of the task's output message.
	//If the task name is not present the current task MUST be considered
	
	final static QName functionName = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803", "getOutput", "htd");

	public Object evaluate(List args) throws XPathFunctionException {
		return null;
	}

	public static QName getFunctionname() {
		return functionName;
	}

}
