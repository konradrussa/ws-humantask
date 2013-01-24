package test.main;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.namespace.QName;

import object.ObjectPreparator;

import org.junit.Assert;
import org.junit.Test;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TArgument;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TBooleanExpr;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TDeadline;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TDeadlineExpr;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TDeadlines;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TDescription;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TDurationExpr;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TEscalation;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TFrom;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TGenericHumanRoleAssignment;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TLeanTask;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TLiteral;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TLogicalPeopleGroup;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TLogicalPeopleGroups;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TNotification;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TParameter;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TPeopleAssignments;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TPotentialOwnerAssignment;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TPresentationElements;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TPresentationParameter;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TPresentationParameters;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TPriorityExpr;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TReassignment;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TText;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTask.InputMessage;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskResponse.OutputMessage;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.IllegalAccessFault;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.IllegalArgumentFault;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.LeanTaskOperations;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TOrganizationalEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import wsht.exception.WSHTException;
import wsht.factory.TaskStructureFactory;
import wsht.infrastructure.web.UserInfo;
import wsht.infrastructure.webservice.commons.AuthenticatorWebService;
import wsht.infrastructure.webservice.exceptions.WSHTWebServiceException;

public class TestParentTask {

	//marshalling do pliku tylko z @XmlRootElement
	
	@Test
	public void testCreateLeanTask() throws WSHTWebServiceException, InterruptedException {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		AuthenticatorWebService authService = (AuthenticatorWebService) context.getBean("authServiceWebServicesClient");
		
		UserInfo userInfo = new UserInfo();
		userInfo.setIpAddress("1.2.3.4");
		userInfo.setPassword("pass123");
		userInfo.setUserName("krussa");
		
		userInfo = authService.logIn(userInfo);
		Assert.assertTrue(userInfo.getLoggedIn());
		System.out.println(userInfo);
		
		boolean afterCheckIfLogged = authService.checkLoggedIn();
		System.out.println("1afterCheckIfLogged = " + afterCheckIfLogged);
		
		//Coordinator najpierw
		//ActivationPortType activationPortType = (ActivationPortType) context.getBean("coordinatorWebServicesClient");
		//RegistrationPortType reqistrationPortType = (RegistrationPortType) context.getBean("coordinatorWebServicesClient");

		
		

		
		LeanTaskOperations leanTaskOperations = (LeanTaskOperations) context.getBean("leanTaskOperationsWebServicesClient");
		
		try {
			
			//task definition
			TLeanTask taskDefinition = prepareTaskDefinition();
			
			//operational data
			InputMessage inputMessage = new InputMessage();
			inputMessage.setAny(ObjectPreparator.getRequestObject());
			
			try {
				
				OutputMessage outputMessage = leanTaskOperations.createLeanTask(inputMessage, taskDefinition, null);
				System.out.println(outputMessage.getAny());
				
			} catch (IllegalAccessFault e) {
				e.printStackTrace();
			} catch (IllegalArgumentFault e) {
				e.printStackTrace();
			}
			
		} catch(Throwable t) {
			t.printStackTrace();
			System.err.println("error " + t);
		}
		
		//Object lock = new Object();
        //synchronized (lock) {
        //    lock.wait();  
        //}
	}
	
	//@Test
	public void testCreateLeanTaskAsync() throws WSHTWebServiceException, InterruptedException {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		AuthenticatorWebService authService = (AuthenticatorWebService) context.getBean("authServiceWebServicesClient");
		
		UserInfo userInfo = new UserInfo();
		userInfo.setIpAddress("1.2.3.4");
		userInfo.setPassword("pass123");
		userInfo.setUserName("krussa");
		
		//Coordinator najpierw
		//ActivationPortType activationPortType = (ActivationPortType) context.getBean("coordinatorWebServicesClient");
		//RegistrationPortType reqistrationPortType = (RegistrationPortType) context.getBean("coordinatorWebServicesClient");

		userInfo = authService.logIn(userInfo);
		//Assert.assertTrue(userInfo.getLoggedIn());
		System.out.println(userInfo);
		
		//boolean afterCheckIfLogged = authService.checkLoggedIn();
		//System.out.println("1afterCheckIfLogged = " + afterCheckIfLogged);
		//boolean checkedUser = authService.checkCurrentUser(userInfo);
		//System.out.println("1checkedUser = " + checkedUser);
		//afterCheckIfLogged = authService.checkLoggedIn();
		//System.out.println("2afterCheckIfLogged = " + afterCheckIfLogged);
		//checkedUser = authService.checkCurrentUser(userInfo);
		//System.out.println("2checkedUser = " + checkedUser);
		
		
		LeanTaskOperations leanTaskOperations = (LeanTaskOperations) context.getBean("leanTaskOperationsWebServicesClient");
		
		try {
			
			//task definition
			TLeanTask taskDefinition = prepareTaskDefinition();
			
			//operational data
			org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskAsync.InputMessage inputMessage = new org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskAsync.InputMessage();
			inputMessage.setAny(ObjectPreparator.getRequestObject());
			
			try {
				
				leanTaskOperations.createLeanTaskAsync(inputMessage, taskDefinition, null);
				
			} catch (IllegalAccessFault e) {
				e.printStackTrace();
			} catch (IllegalArgumentFault e) {
				e.printStackTrace();
			}
			
		} catch(Throwable t) {
			t.printStackTrace();
			System.err.println("error " + t);
		}
		
		//Object lock = new Object();
        //synchronized (lock) {
        //    lock.wait();  
        //}
	}
	
	public static TLeanTask prepareTaskDefinition() throws WSHTException {
		TaskStructureFactory factory = TaskStructureFactory.getInstance();			
		
		TLeanTask taskDefinition = new TLeanTask();
		String taskName = "Task N1:" + UUID.randomUUID().toString().substring(0,3);
		taskDefinition.setName(taskName);
		
		TPriorityExpr expr = factory.createPriorityExpr("sbql", "getInput(\"ClaimApprovalRequest\").prio");
		taskDefinition.setPriority(expr);
		
		//definition presentation data
		List<TText> name = new ArrayList<TText>();
		TText nameText= factory.createText("en-US", "Approve Claim");
		name.add(nameText);
		QName lastStringType = factory.createQName("http://www.w3.org/2001/XMLSchema", "string", "xsd");
		QName lastIntegerType = factory.createQName("http://www.w3.org/2001/XMLSchema", "integer", "xsd");
		TPresentationParameter parameterFirstName = factory.createPresentationParameter(lastStringType, "firstname", "getInput(\"ClaimApprovalRequest\").person.firstname");
		TPresentationParameter parameterLastName = factory.createPresentationParameter(lastStringType, "lastname", "getInput(\"ClaimApprovalRequest\").person.lastname");
		TPresentationParameter parameterEuroAmount = factory.createPresentationParameter(lastIntegerType, "euroAmount", "getInput(\"ClaimApprovalRequest\").amount * 4");
		TPresentationParameters presentationParameters = factory.createPresentationParameters("sbql", parameterFirstName, parameterLastName, parameterEuroAmount);
		List<TText> subject = new ArrayList<TText>();
		TText subjectText = factory.createText("en-US", " Approve the insurance claim for $euroAmount$ on behalf of $firstname$ $lastname$");
		subject.add(subjectText);
		List<TDescription> descriptions = new ArrayList<TDescription>();
		TDescription description = factory.createDescription("en-US", "plain/text", "Approve this claim following corporate guideline #4711.0815/7 ...");
		descriptions.add(description);
		TPresentationElements presentationElements = factory.createPresentationElements(name, presentationParameters, subject, descriptions);
		taskDefinition.setPresentationElements(presentationElements);
		
		
		//context data people assignment
		TArgument agrument1 = factory.createArgument("regionname", "getInput(\"ClaimApprovalRequest\").region");
		TFrom from1 = factory.createFrom("regionalClerks", agrument1);
		TPotentialOwnerAssignment assignment1 = factory.createPotentialOwnerAssignment(from1, null, null);
		JAXBElement<TPotentialOwnerAssignment> potentialOwners = factory.createPotentialOwners(assignment1);
		TArgument agrument2 = factory.createArgument("regionname", "getInput(\"ClaimApprovalRequest\").region");
		TFrom from2 = factory.createFrom("regionalManager", agrument2);
		TGenericHumanRoleAssignment assignment2 = factory.createGenericHumanRoleAssignment(from2);
		JAXBElement<TGenericHumanRoleAssignment> businessAdministrators = factory.createBusinessAdministrator(assignment2);
		@SuppressWarnings("unchecked")
		TPeopleAssignments peopleAssignments = factory.createPeopleAssignments(potentialOwners, businessAdministrators);
		taskDefinition.setPeopleAssignments(peopleAssignments);
		
		//start deadline and escalation with reassignment
		TDurationExpr _forStart = factory.createDurationExpr("sqbl", "P3DT3M");
		TBooleanExpr booleanExpr = factory.createBooleanExpr("sbql", "getInput(\"ClaimApprovalRequest\").amount > 10000");
		JAXBElement<String> listElement = factory.createOrganizationalEntityUserElement("jceo");
		List<JAXBElement<String>> listElements = new ArrayList<JAXBElement<String>>();
		listElements.add(listElement);
		TOrganizationalEntity organizationalEntity = factory.createOrganizationalEntity(listElements);
		TLiteral literal = factory.createLiteral(organizationalEntity); 
		TFrom fromReassign = factory.createFrom(literal);
		TPotentialOwnerAssignment potentialOwnerAssignment = factory.createPotentialOwnerAssignment(fromReassign, null, null);
		TReassignment reassignment = factory.createReassignment(potentialOwnerAssignment);
		TEscalation escalation = factory.createEscalation("highAmountReassign", booleanExpr, reassignment);
		List<TEscalation> startEscalations = new ArrayList<TEscalation>();
		startEscalations.add(escalation);
		TDeadline startDeadline = factory.createDeadline("sendReminder", _forStart, null, startEscalations);
		List<TDeadline> startDeadlines = new ArrayList<TDeadline>();
		startDeadlines.add(startDeadline);
		
		//completion deadline and escalation with notification
		TEscalation completionEscalation = factory.createEscalation("highAmountReassign", null, null);
		List<TText> notifPresentationName = new ArrayList<TText>();
		TText notifText = factory.createText("en-US", "Claim approval overdue");
		notifPresentationName.add(notifText);
		TPresentationElements notificationPresentationElements = factory.createPresentationElements(notifPresentationName, null, null, null);
		TNotification notification = factory.createNotification("wait to long", null, null, null, notificationPresentationElements, null);
		completionEscalation.setNotification(notification);
		List<TEscalation> completionEscalations = new ArrayList<TEscalation>();
		completionEscalations.add(completionEscalation);
		TDeadlineExpr untilComplete = factory.createDeadlineExpr("sqbl", "2013-01-23T22:00:00");
		TDeadline completionDeadline = factory.createDeadline("notifyManager", null, untilComplete, completionEscalations);
		List<TDeadline> completionDeadlines = new ArrayList<TDeadline>();
		completionDeadlines.add(completionDeadline);
		
		
		TDeadlines deadlines = factory.createDeadlines(startDeadlines, completionDeadlines);
		taskDefinition.setDeadlines(deadlines);
		return taskDefinition;
	}
	
	public static TLogicalPeopleGroups prepareTestLogicalPeopleGrooups() throws WSHTException {
		TaskStructureFactory factory = TaskStructureFactory.getInstance();
		QName type = factory.createQName("http://www.w3.org/2001/XMLSchema", "string", "xsd");
		TParameter parameter1 = factory.createParameter(type, "regionname", "getInput(\"ClaimApprovalRequest\").region");
		TLogicalPeopleGroup logicalPeopleGroup1 = factory.createLogicalPeopleGroup("regionalClerks", parameter1);
		TParameter parameter2 = factory.createParameter(type, "regionname", "getInput(\"ClaimApprovalRequest\").region");
		TLogicalPeopleGroup logicalPeopleGroup2 = factory.createLogicalPeopleGroup("regionalManager", parameter2);
		TLogicalPeopleGroups logicalPeopleGroups = factory.createLogicalPeopleGroups(logicalPeopleGroup1,logicalPeopleGroup2);
		return logicalPeopleGroups;
	}
	
	
}
