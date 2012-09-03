package wsht.runtime.expressions.xpath.functions.taskFunc;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;

import org.w3c.dom.NodeList;

public class GetInputFunc implements XPathFunction {
	
	//IN
	//part name
	private String taskName; //optional
	//OUT
	//input message part
	
	//Returns the part of the task‟s input message.
	//If the task name is not present the current task MUST be considered.
	
	final static QName functionName = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803", "getInput", "htd");

	public Object evaluate(List args) throws XPathFunctionException {
		Object arg = args.iterator().next();
        if (arg instanceof NodeList)
        {
            NodeList nodes = (NodeList)arg;
            if (nodes.getLength() == 0)
                return "";
            else
                return nodes.item(0).getTextContent();
        }
        else if (arg instanceof String)
        {
            return ((String)arg);
        }
        else
            throw new XPathFunctionException("invalid argument: " + arg);
	}

	public static QName getFunctionname() {
		return functionName;
	}

}
