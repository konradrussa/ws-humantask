package wsht.runtime.expressions.xpath.functions.numberFunc;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;

import org.w3c.dom.NodeList;

public class AvgFunc implements XPathFunction {
	
	//IN
	//node-set of number nodes
	
	//Returns the average value of all number nodes - returns NaN for an empty node-set
	
	final static QName functionName = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803", "avg", "htd");

	public Object evaluate(List args) throws XPathFunctionException {
		Object arg = args.iterator().next();
        if (arg instanceof NodeList)
        {
            NodeList nodes = (NodeList)arg;
            if (nodes.getLength() == 0)
                return "";
            else
                return nodes.item(0).getTextContent().toUpperCase();
        }
        else if (arg instanceof String)
        {
            return ((String)arg).toUpperCase();
        }
        else
            throw new XPathFunctionException("invalid argument: " + arg);
	}

	public static QName getFunctionname() {
		return functionName;
	}

}
