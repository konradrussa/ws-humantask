package wsht.runtime.expressions.xpath.evaluator;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;
import javax.xml.xpath.XPathFunctionResolver;
import javax.xml.xpath.XPathVariableResolver;

import wsht.runtime.expressions.xpath.functions.FunctionNamespaceResolver;
import wsht.runtime.expressions.xpath.functions.booleanFunc.AndFunc;
import wsht.runtime.expressions.xpath.functions.booleanFunc.OrFunc;
import wsht.runtime.expressions.xpath.functions.booleanFunc.VoteFunc;
import wsht.runtime.expressions.xpath.functions.genericsetFunc.ExceptFunc;
import wsht.runtime.expressions.xpath.functions.genericsetFunc.IntersectFunc;
import wsht.runtime.expressions.xpath.functions.genericsetFunc.UnionFunc;
import wsht.runtime.expressions.xpath.functions.stringFunc.ConcatWithDelimiterFunc;
import wsht.runtime.expressions.xpath.functions.stringFunc.LeastFrequentOccurenceFunc;
import wsht.runtime.expressions.xpath.functions.stringFunc.MostFrequentOccurenceFunc;
import wsht.runtime.expressions.xpath.functions.stringFunc.VoteOnStringFunc;
import wsht.runtime.expressions.xpath.functions.taskFunc.GetActualOwnerFunc;
import wsht.runtime.expressions.xpath.functions.taskFunc.GetBusinessAdministratorsFunc;
import wsht.runtime.expressions.xpath.functions.taskFunc.GetCountOfFinishedSubTasksFunc;
import wsht.runtime.expressions.xpath.functions.taskFunc.GetCountOfSubTasksFunc;
import wsht.runtime.expressions.xpath.functions.taskFunc.GetCountOfSubTasksInStateFunc;
import wsht.runtime.expressions.xpath.functions.taskFunc.GetCountOfSubTasksWithOutcomeFunc;
import wsht.runtime.expressions.xpath.functions.taskFunc.GetExcludedOwnersFunc;
import wsht.runtime.expressions.xpath.functions.taskFunc.GetInputFunc;
import wsht.runtime.expressions.xpath.functions.taskFunc.GetLogicalPeopleGroupFunc;
import wsht.runtime.expressions.xpath.functions.taskFunc.GetOutcomeFunc;
import wsht.runtime.expressions.xpath.functions.taskFunc.GetOutputFunc;
import wsht.runtime.expressions.xpath.functions.taskFunc.GetPotentialOwnersFunc;
import wsht.runtime.expressions.xpath.functions.taskFunc.GetSubtaskOutputFunc;
import wsht.runtime.expressions.xpath.functions.taskFunc.GetSubtaskOutputsFunc;
import wsht.runtime.expressions.xpath.functions.taskFunc.GetTaskInitiatorFunc;
import wsht.runtime.expressions.xpath.functions.taskFunc.GetTaskPriorityFunc;
import wsht.runtime.expressions.xpath.functions.taskFunc.GetTaskStakeholdersFunc;
import wsht.runtime.expressions.xpath.functions.taskFunc.WaitForFunc;
import wsht.runtime.expressions.xpath.functions.taskFunc.WaitUntilFunc;

//urn:ws-ht:sublang:xpath1.0
public class FunctionEvaluator {
	
	private XPathFactory xPathFactory = null;
	private XPath xPath = null;
	
	public FunctionEvaluator() {
		xPathFactory = XPathFactory.newInstance();
		createXPathInstance();
	}
	
	private void createXPathInstance() {
		xPath = xPathFactory.newXPath();
		xPath.setNamespaceContext(new FunctionNamespaceResolver("htd", "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803"));
		xPath.setXPathFunctionResolver(new XPathFunctionResolver() {
			public XPathFunction resolveFunction(QName functionName, int arity) {
				
				if(AndFunc.getFunctionname().equals(functionName)) {
					return new AndFunc();
				}
				if(OrFunc.getFunctionname().equals(functionName)) {
					return new OrFunc();
				}
				if(VoteFunc.getFunctionname().equals(functionName)) {
					return new VoteFunc();
				}
				if(ExceptFunc.getFunctionname().equals(functionName)) {
					return new ExceptFunc();
				}
				if(IntersectFunc.getFunctionname().equals(functionName)) {
					return new IntersectFunc();
				}
				if(UnionFunc.getFunctionname().equals(functionName)) {
					return new UnionFunc();
				}
				if(ConcatWithDelimiterFunc.getFunctionname().equals(functionName)) {
					return new ConcatWithDelimiterFunc();
				}
				if(LeastFrequentOccurenceFunc.getFunctionname().equals(functionName)) {
					return new LeastFrequentOccurenceFunc();
				}
				if(MostFrequentOccurenceFunc.getFunctionname().equals(functionName)) {
					return new MostFrequentOccurenceFunc();
				}
				if(VoteOnStringFunc.getFunctionname().equals(functionName)) {
					return new VoteOnStringFunc();
				}
				if(GetActualOwnerFunc.getFunctionname().equals(functionName)) {
					return new GetBusinessAdministratorsFunc();
				}
				if(GetBusinessAdministratorsFunc.getFunctionname().equals(functionName)) {
					return new GetBusinessAdministratorsFunc();
				}
				if(GetCountOfFinishedSubTasksFunc.getFunctionname().equals(functionName)) {
					return new GetCountOfFinishedSubTasksFunc();
				}
				if(GetCountOfSubTasksFunc.getFunctionname().equals(functionName)) {
					return new GetCountOfSubTasksFunc();
				}
				if(GetCountOfSubTasksInStateFunc.getFunctionname().equals(functionName)) {
					return new GetCountOfSubTasksInStateFunc();
				}
				if(GetCountOfSubTasksWithOutcomeFunc.getFunctionname().equals(functionName)) {
					return new GetCountOfSubTasksWithOutcomeFunc();
				}
				if(GetExcludedOwnersFunc.getFunctionname().equals(functionName)) {
					return new GetExcludedOwnersFunc();
				}
				if(GetInputFunc.getFunctionname().equals(functionName)) {
					return new GetInputFunc();
				}
				if(GetLogicalPeopleGroupFunc.getFunctionname().equals(functionName)) {
					return new GetLogicalPeopleGroupFunc();
				}
				if(GetOutcomeFunc.getFunctionname().equals(functionName)) {
					return new GetOutcomeFunc();
				}
				if(GetOutputFunc.getFunctionname().equals(functionName)) {
					return new GetOutputFunc();
				}
				if(GetPotentialOwnersFunc.getFunctionname().equals(functionName)) {
					return new GetPotentialOwnersFunc();
				}
				if(GetSubtaskOutputFunc.getFunctionname().equals(functionName)) {
					return new GetSubtaskOutputFunc();
				}
				if(GetSubtaskOutputsFunc.getFunctionname().equals(functionName)) {
					return new GetSubtaskOutputsFunc();
				}
				if(GetTaskInitiatorFunc.getFunctionname().equals(functionName)) {
					return new GetTaskInitiatorFunc();
				}
				if(GetTaskPriorityFunc.getFunctionname().equals(functionName)) {
					return new GetTaskPriorityFunc();
				}
				if(GetTaskStakeholdersFunc.getFunctionname().equals(functionName)) {
					return new GetTaskStakeholdersFunc();
				}
				if(WaitForFunc.getFunctionname().equals(functionName)) {
					return new WaitForFunc();
				}
				if(WaitUntilFunc.getFunctionname().equals(functionName)) {
					return new WaitUntilFunc();
				}
				
				return null;
			}
		});
		xPath.setXPathVariableResolver(new XPathVariableResolver() {
			public Object resolveVariable(QName variableName) {
				
				return null;
			}
		});
	}
	
	public Object evaluate(String expression, Object source) throws XPathExpressionException {
		return xPath.evaluate(expression, source);
	}
	

}
