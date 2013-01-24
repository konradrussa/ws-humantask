package test.infrastructure;

import object.ClaimApprovalRequest;
import object.Customer;
import object.Location;
import wsht.runtime.expressions.sbql.ast.operators.wsht.ext.ExpressionContextService;
import wsht.runtime.expressions.sbql.ast.operators.wsht.ext.IValuable;
import wsht.runtime.expressions.sbql.envs.ENVS;
import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.store.TaskInstance;

public class TestDB4O {


	@org.junit.Test
	public void testObjectDB() {
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		//context.getBean("applicationContextProvider");
		
		try {
			
			
			TaskInstance container = new TaskInstance("task123");
			container.fillInActualOwner("Jozef Staszewski");
			
		//	Customer person = new Customer("idCust1", "PersonAccount", "Bruce", "Willis", null);
			String region = "regionalClerks";
			
		//	container.getContent().add(new ClaimApprovalRequest(person, region, 2, 2000));
			
			//IDB4oInterface db4oInterface = (IDB4oInterface) context.getBean("db4oInterface");
			//db4oInterface.storeObject(container);
			
			//IValuable valuable = (IValuable) context.getBean("expressionContextService");
			IValuable valuable = new ExpressionContextService();
			valuable.setUpTaskInstance(container);
			
			AbstractQueryResult res = valuable.eval("getInput(\"ClaimApprovalRequest\").amount", false);
			System.out.println(res);
			System.out.println("QRES " + QRES.getInstance().getStackSize());
			System.out.println("ENVS " + ENVS.getInstance().getStackSize());
			
			res = valuable.eval("getInput(\"ClaimApprovalRequest\").amount - 20", false);
			System.out.println(res);
			System.out.println("QRES " + QRES.getInstance().getStackSize());
			System.out.println("ENVS " + ENVS.getInstance().getStackSize());
			
			res = valuable.eval("getInput(\"ClaimApprovalRequest\").prio", false);
			System.out.println(res);
			System.out.println("QRES " + QRES.getInstance().getStackSize());
			System.out.println("ENVS " + ENVS.getInstance().getStackSize());
			
			res = valuable.eval("getInput(\"ClaimApprovalRequest\").cust.firstname", false);
			System.out.println(res);
			System.out.println("QRES " + QRES.getInstance().getStackSize());
			System.out.println("ENVS " + ENVS.getInstance().getStackSize());
			
			res = valuable.eval("getInput(\"ClaimApprovalRequest\").cust.lastname", false);
			System.out.println(res);
			System.out.println("QRES " + QRES.getInstance().getStackSize());
			System.out.println("ENVS " + ENVS.getInstance().getStackSize());
			
			//res = valuable.evalExternal("getInput(\"firstname\")", new ClaimApprovalRequest(), false);
			//System.out.println(res);
			//System.out.println("QRES " + QRES.getInstance().getStackSize());
			//System.out.println("ENVS " + ENVS.getInstance().getStackSize());
			
			res = valuable.eval("getActualOwner(\"ApproveClaim\").id", false);
			System.out.println(res);
			System.out.println("QRES " + QRES.getInstance().getStackSize());
			System.out.println("ENVS " + ENVS.getInstance().getStackSize());
			
			res = valuable.eval("getInput(\"ClaimApprovalRequest\").amount >= 10000", false);
			System.out.println(res);
			System.out.println("QRES " + QRES.getInstance().getStackSize());
			System.out.println("ENVS " + ENVS.getInstance().getStackSize());
			
			res = valuable.eval("((getInput(\"ClaimApprovalRequest\").amount < 10000) && (getInput(\"ClaimApprovalRequest\").prio <= 2))", false);
			System.out.println(res);
			System.out.println("QRES " + QRES.getInstance().getStackSize());
			System.out.println("ENVS " + ENVS.getInstance().getStackSize());
			
			//res = valuable.eval("getInput(\"firstname\")", false);
			//System.out.println(res);
			
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

}
