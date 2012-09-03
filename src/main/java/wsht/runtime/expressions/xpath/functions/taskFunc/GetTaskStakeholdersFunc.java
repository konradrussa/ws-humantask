package wsht.runtime.expressions.xpath.functions.taskFunc;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;

public class GetTaskStakeholdersFunc implements XPathFunction {

	//IN
	//task name (optional)
	//OUT
	//task stakeholders (htt:organizationalEntity)
	
	
	//Returns the stakeholders of the task.
	//It MUST evaluate to an empty htt:organizationalEntity in case of an error.
	//If the task name is not present the current task MUST be considered.
	
	final static QName functionName = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803", "getTaskStakeholders", "htd");

	public Object evaluate(List args) throws XPathFunctionException {
		return null;
	}

	public static QName getFunctionname() {
		return functionName;
	}
	
}
