package test.infrastructure;

import java.util.Date;
import java.util.UUID;

import org.junit.Assert;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.THumanInteractions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.utils.ResourceUtil;
import wsht.infrastructure.domain.entity.HumanInteractions;
import wsht.infrastructure.domain.entity.Task;
import wsht.infrastructure.domain.entity.TaskInfo;
import wsht.infrastructure.service.IRepositoryService;
import wsht.marshalling.IBeanMapper;
import wsht.marshalling.IJAXBUtilBean;
import wsht.marshalling.exception.RejectedMessageException;
import wsht.marshalling.exception.WSHTException;
import wsht.runtime.enums.TaskStatesEnum;
import wsht.runtime.expressions.sbql.ast.operators.wsht.ext.IValuable;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.utils.ApplicationContextProvider;

public class TestSpringAndDB {

	@org.junit.Test
	public void testObjectDB() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		context.getBean("applicationContextProvider");
		
		try {
			IJAXBUtilBean jaxbUtilBean = (IJAXBUtilBean) context.getBean("jaxbUtilBean");
			THumanInteractions interaction = jaxbUtilBean.parseAndUnmarshal(ResourceUtil.loadToString("oasis_example.xml"));
			Assert.assertNotNull(interaction);
			IBeanMapper mapper = (IBeanMapper) context.getBean("beanMapper");
			HumanInteractions hi = mapper.map(interaction, HumanInteractions.class);
			Assert.assertNotNull(hi);
			
			IRepositoryService service = (IRepositoryService) context.getBean("repositoryService");
			hi = service.createHumanInteractions(hi);
			
			Task storedTask = hi.getTasks().getTask().get(0);
			Assert.assertNotNull(storedTask);
			
			TaskInfo taskInfo = new TaskInfo();
			taskInfo.setTaskIdentifier(UUID.randomUUID().toString().substring(0, 10));
			taskInfo.setCreated(new Date());
			taskInfo.setTask(storedTask);
			taskInfo.setState(TaskStatesEnum.CREATED);
			taskInfo = service.createTaskInfo(taskInfo);
			Assert.assertNotNull(taskInfo);
			
			//IValuable valuable = (IValuable) context.getBean("expContextService");
			
			//AbstractQueryResult res = valuable.eval("getInput(\"ClaimApprovalRequest\").amount", false);
			//System.out.println(res);
			
		} catch (WSHTException e) {
			e.printStackTrace();
		} catch (RejectedMessageException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	
	class Container {
		
		public Integer containerId = 1;
		public ClaimApprovalRequest ClaimApprovalRequest = new ClaimApprovalRequest();
		

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
