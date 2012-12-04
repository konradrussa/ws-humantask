package test.infrastructure;

import java.util.Date;
import java.util.LinkedList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import wsht.runtime.db4o.IDB4oInterface;
import wsht.runtime.expressions.sbql.ast.operators.wsht.ext.IValuable;
import wsht.runtime.expressions.sbql.envs.ENVS;
import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;

public class TestDB4O {


	@org.junit.Test
	public void testObjectDB() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		context.getBean("applicationContextProvider");
		
		try {
			
			IDB4oInterface db4oInterface = (IDB4oInterface) context.getBean("db4oInterface");
			wsht.runtime.expressions.sbql.store.Container container = new wsht.runtime.expressions.sbql.store.Container("task123");
			container.getContent().add(new ClaimApprovalRequest());
			db4oInterface.storeObject(container);
			
			IValuable valuable = (IValuable) context.getBean("expContextService");
			
			AbstractQueryResult res = valuable.eval("getInput(\"ClaimApprovalRequest\").amount", false);
			System.out.println(res);
			System.out.println("QRES " + QRES.getInstance().getStackSize());
			System.out.println("ENVS " + ENVS.getInstance().getStackSize());
			res = valuable.eval("getInput(\"ClaimApprovalRequest\").amount", false);
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
			//res = valuable.eval("getInput(\"firstname\")", false);
			//System.out.println(res);
			
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}
	

	
	class ClaimApprovalRequest {
		public Integer amount = 2000;
		public String region = "regionalClerks";
		public Integer prio = 2;
		public Date activateAt = new Date();
		public Cust cust = new Cust();
	}
	
	class Cust {
		public String id = "idCust1";
		public String firstname = "John";
		public String lastname = "Rambo";
		
	}

}
