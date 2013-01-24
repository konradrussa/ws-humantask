package test.expressions;

import object.ObjectPreparator;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import wsht.runtime.expressions.sbql.ast.operators.wsht.ext.IValuable;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.store.TaskInstance;
import wsht.runtime.expressions.sbql.util.SBQLUtil;

public class TestExpressionContextService {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		IValuable valuable = (IValuable) context.getBean("expressionContextService");
		
		TaskInstance container = new TaskInstance("task2");
		
		container.getContent().add(ObjectPreparator.getRequestObject());
		
		AbstractQueryResult res = valuable.evalExternal("getInput(\"ClaimApprovalRequest\").amount", container, false);
		System.out.println(SBQLUtil.deref(res));
	}
}
