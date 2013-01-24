package test.main;

import java.util.List;

import javax.jws.WebParam;

import object.ObjectPreparator;

import org.junit.Assert;
import org.junit.Test;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.IllegalAccessFault;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.IllegalArgumentFault;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.IllegalOperationFault;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.IllegalStateFault;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.TaskOperations;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TTaskAbstract;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import wsht.infrastructure.web.UserInfo;
import wsht.infrastructure.webservice.commons.AuthenticatorWebService;
import wsht.infrastructure.webservice.exceptions.WSHTWebServiceException;

public class TestClientTask {

	@Test
	public void testParentTask() throws WSHTWebServiceException {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
			AuthenticatorWebService authService = (AuthenticatorWebService) context.getBean("authServiceWebServicesClient");
			
			UserInfo userInfo = new UserInfo();
			userInfo.setIpAddress("1.2.3.4");
			userInfo.setPassword("pass123");
			userInfo.setUserName("krussa");
	
			userInfo = authService.logIn(userInfo);
			Assert.assertTrue(userInfo.getLoggedIn());
			System.out.println(userInfo);
			
			
			TaskOperations taskOperations = (TaskOperations) context.getBean("taskServiceWebServicesClient");
			
			String taskType = "LeanTask";
		    String genericHumanRole = "potentialOwner";
		    String workQueue = null;
		    List<String> status = null;
		    String whereClause = null;
		    String orderByClause = null;
		    String createdOnClause = null;
		    Integer maxTasks = 2;
		    Integer taskIndexOffset = 0;
		
		    List<TTaskAbstract> abstracts = taskOperations.getMyTaskAbstracts(taskType, genericHumanRole, workQueue, 
		    										status, whereClause, orderByClause, createdOnClause, maxTasks, taskIndexOffset);
		
		    Assert.assertNotNull(abstracts != null);
		    Assert.assertTrue(!abstracts.isEmpty());
		    
		    for(TTaskAbstract a : abstracts) {
		    	String taskIndentifier = a.getId();
		    	taskOperations.claim(taskIndentifier);
		    	taskOperations.start(taskIndentifier);
		    	taskOperations.complete(taskIndentifier, ObjectPreparator.getResponseObject());
		    }
		    
		} catch (IllegalArgumentFault e) {
			e.printStackTrace();
		} catch (IllegalOperationFault e) {
			e.printStackTrace();
		} catch (IllegalStateFault e) {
			e.printStackTrace();
		} catch (IllegalAccessFault e) {
			e.printStackTrace();
		}
	}
}
