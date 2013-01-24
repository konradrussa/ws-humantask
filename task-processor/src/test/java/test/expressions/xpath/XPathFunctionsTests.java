package test.expressions.xpath;

import javax.xml.xpath.XPathExpressionException;

import org.junit.Test;

import wsht.runtime.expressions.xpath.evaluator.FunctionEvaluator;
import wsht.runtime.utils.ResourceUtil;

public class XPathFunctionsTests {
	

	
	@Test
	public void testGetInput() throws XPathExpressionException {
		
		
		FunctionEvaluator evaluator = new FunctionEvaluator();
		
		Object result = evaluator.evaluate("(htd:getInput(\"ClaimApprovalRequest\")/amount < 10000 && htd:getInput(\"ClaimApprovalRequest\")/prio <= 2)", ResourceUtil.loadToString("ClaimApprovalRequest.xml"));
	
		System.out.println(result);
	}

}
