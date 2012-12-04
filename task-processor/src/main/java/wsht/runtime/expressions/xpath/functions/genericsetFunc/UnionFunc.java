package wsht.runtime.expressions.xpath.functions.genericsetFunc;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;

public class UnionFunc implements XPathFunction {

	//IN
	// set1 (htt:organizationalEntity |htt:user)
	// set2 (htt:organizationalEntity |htt:user)
	//OUT
	// result (htt:organizationalEntity)
	
	//Constructs an organizationalEntity containing every user that
	//occurs in either set1 or set2, eliminating duplicate users.
	
	final static QName functionName = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803", "union", "htd");

	public Object evaluate(List args) throws XPathFunctionException {
		return null;
	}

	public static QName getFunctionname() {
		return functionName;
	}

}