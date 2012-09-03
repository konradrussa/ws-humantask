package wsht.runtime.expressions.xpath.functions.genericsetFunc;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;

public class ExceptFunc implements XPathFunction {

	//IN
	// set1 (htt:organizationalEntity |htt:user)
	// set2 (htt:organizationalEntity |htt:user)
	//OUT
	// result (htt:organizationalEntity)
	
	//Constructs an organizationalEntity containing every user that occurs in set1 but not in set2.
	//Note: This function is required to allow enforcing the separation of duties (“4-eyes principle”).
	
	
	final static QName functionName = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803", "except", "htd");

	public Object evaluate(List args) throws XPathFunctionException {
		return null;
	}

	public static QName getFunctionname() {
		return functionName;
	}
	
}
