package test.task.definition;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.EndpointReference;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder;

import org.junit.Assert;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TBoolean;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TCompletionBehavior;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TComposition;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TCompositionType;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TDeadlines;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TDefaultCompletion;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TDelegation;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TDescription;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TDocumentation;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TExpression;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TFrom;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TGenericHumanRoleAssignment;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.THumanInteractions;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TLeanTask;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TMessageChoice;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TMessageDisplay;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TMessageField;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TMessageSchema;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TParallel;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TPattern;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TPeopleAssignments;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TPotentialDelegatees;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TPotentialOwnerAssignment;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TPresentationElements;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TPresentationParameter;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TPresentationParameters;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TPriorityExpr;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TQuery;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TRendering;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TRenderings;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TResult;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TTaskInterface;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.Nominate;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.RegisterLeanTaskDefinition;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TOrganizationalEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.utils.ResourceUtil;
import wsht.infrastructure.service.IRepositoryService;
import wsht.marshalling.BeanMapper;
import wsht.marshalling.JAXBUtil;
import wsht.marshalling.exception.RejectedMessageException;
import wsht.marshalling.exception.WSHTException;

public class TaskDefinition {
	
	
	//@org.junit.Test
	public void testWSHT() {
		try {
			THumanInteractions interaction = JAXBUtil.parseAndUnmarshal(ResourceUtil.loadToString("oasis_example.xml"));
			Assert.assertNotNull(interaction);
		} catch (WSHTException e) {
			e.printStackTrace();
		} catch (RejectedMessageException e) {
			e.printStackTrace();
		}
	}
	
	@org.junit.Test
	public void testMarshalling() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
		"spring/applicationContext.xml");

		BeanMapper mapper = (BeanMapper) context.getBean("beanMapper");
		
	}
	
	
	//... All elements from htd:task except <interface> and <composition> ...
	//@org.junit.Test
	public void testLeanTask() {
		//marshal element with @XmlRootElement
		try {
			TLeanTask leanTask = new TLeanTask();
			leanTask.setName("lenTaskName");
			
//			TTaskInterface taskInterface = new TTaskInterface();
//			taskInterface.setOperation("wsdlOperation");
//			taskInterface.setPortType(new QName("http://wsdl.server", "localPartServiceImpl"));
//			taskInterface.setResponseOperation("wsdlResponseOperation");
//			taskInterface.setResponsePortType(new QName("http://response.wsdl.server", "responseLocalPartServiceImpl"));
//			leanTask.setInterface(taskInterface);
			
//			TComposition composition = new TComposition();
//			composition.setInstantiationPattern(TPattern.MANUAL);
//			composition.setType(TCompositionType.SEQUENTIAL);
//			leanTask.setComposition(composition);
			
			TMessageSchema messageSchema = new TMessageSchema();
			TMessageField messageField = new TMessageField();
			messageField.setName("field1");
			messageField.setType(new QName("namespaceUri", "localPart"));
			TMessageChoice messageChoice = new TMessageChoice();
			messageChoice.setValue("vallue");
			TMessageDisplay messageDisplay = new TMessageDisplay();
			messageDisplay.setLang("html");
			//messageDisplay.getContent().add("content1");
			messageChoice.getMessageDisplay().add(messageDisplay);
			messageField.getMessageChoice().add(messageChoice);
			messageSchema.getMessageField().add(messageField);
			leanTask.setMessageSchema(messageSchema);
			
			
			leanTask.setActualOwnerRequired(TBoolean.YES);
			
			TCompletionBehavior completionBehavior = new TCompletionBehavior();
			completionBehavior.setCompletionAction(TPattern.MANUAL);
			TDefaultCompletion defaultCompletion = new TDefaultCompletion();
			TResult result = new TResult();
			defaultCompletion.setResult(result);
			completionBehavior.setDefaultCompletion(defaultCompletion);
			leanTask.setCompletionBehavior(completionBehavior);
			
			TDeadlines deadlines = new TDeadlines();
			leanTask.setDeadlines(deadlines);
			
			TDelegation delegation = new TDelegation();
			TFrom from = new TFrom();
			from.setExpressionLanguage("sbql");
			from.setLogicalPeopleGroup("logicalPeopleGroup");
			delegation.setFrom(from);
			delegation.setPotentialDelegatees(TPotentialDelegatees.ANYBODY);
			leanTask.setDelegation(delegation);
			

			TQuery query = new TQuery();
			query.setPart("partQuery");
			query.setQueryLanguage("sbqlQueryLanguage");
			//query.getContent().add("content");
			query.getOtherAttributes().put(new QName("localPart"), "attributeValue");
			leanTask.setOutcome(query);
			
			TPeopleAssignments peopleAssignments = new TPeopleAssignments();
			peopleAssignments.getOtherAttributes().put(new QName("localPart"), "attributeValue");
			//peopleAssignments.getAny().add("any1");
			TDocumentation documentation = new TDocumentation();
			documentation.setLang("lang");
			//documentation.getContent().add("content");
			peopleAssignments.getDocumentation().add(documentation);
			TGenericHumanRoleAssignment genericHumanRoleAssignment = new TGenericHumanRoleAssignment();
			TFrom from2 = new TFrom();
			from2.setExpressionLanguage("sbql");
			from2.setLogicalPeopleGroup("logicalPeopleGroup");
			genericHumanRoleAssignment.setFrom(from2);
			JAXBElement<TGenericHumanRoleAssignment> element1 = new JAXBElement<TGenericHumanRoleAssignment>(new QName("localPart"), TGenericHumanRoleAssignment.class, genericHumanRoleAssignment);
			TPotentialOwnerAssignment potentialOwnerAssignment = new TPotentialOwnerAssignment();
			TFrom from3 = new TFrom();
			from3.setExpressionLanguage("sbql");
			from3.setLogicalPeopleGroup("logicalPeopleGroup");
			TParallel parallel = new TParallel();
			TCompletionBehavior completionBehavior2 = new TCompletionBehavior();
			completionBehavior2.setCompletionAction(TPattern.MANUAL);
			TDefaultCompletion defaultCompletion2 = new TDefaultCompletion();
			TResult result2 = new TResult();
			defaultCompletion2.setResult(result2);
			completionBehavior2.setDefaultCompletion(defaultCompletion2);			
			parallel.setCompletionBehavior(completionBehavior2);
			potentialOwnerAssignment.setParallel(parallel);
			potentialOwnerAssignment.setFrom(from3);
			JAXBElement<TPotentialOwnerAssignment> element2 = new JAXBElement<TPotentialOwnerAssignment>(new QName("localPart"), TPotentialOwnerAssignment.class, potentialOwnerAssignment);
			peopleAssignments.getGenericHumanRole().add(element1);
			peopleAssignments.getGenericHumanRole().add(element2);
			leanTask.setPeopleAssignments(peopleAssignments);
			
			TPresentationElements presentationElements = new TPresentationElements();
			TPresentationParameters presentationParameters = new TPresentationParameters();
			presentationParameters.setExpressionLanguage("sbql");
			TPresentationParameter presentationParameter = new TPresentationParameter();
			//presentationParameter.getContent().add("content");
			presentationParameter.setName("param1");
			presentationParameter.setType(new QName("lP"));
			presentationParameters.getPresentationParameter().add(presentationParameter);
			presentationParameters.getDocumentation().add(documentation);
			//presentationParameters.getAny().add("any");
			presentationParameters.getOtherAttributes().put(new QName("localPart"), "attributeValue");
			presentationElements.setPresentationParameters(presentationParameters);
			//presentationElements.getAny().add("any");
			TDescription description = new TDescription();
			description.setContentType("text/html");
			description.setLang("html");
			//description.getContent().add("content");
			description.getOtherAttributes().put(new QName("localPart"), "attributeValue");
			presentationElements.getDescription().add(description);
			leanTask.setPresentationElements(presentationElements);
			
			TPriorityExpr priorityExpr = new TPriorityExpr();
			priorityExpr.setExpressionLanguage("sbql");
			//priorityExpr.getContent().add("content");
			priorityExpr.getOtherAttributes().put(new QName("localPart"), "attributeValue");
			leanTask.setPriority(priorityExpr);
			
			TRenderings renderings = new TRenderings();
			TRendering rendering = new TRendering();
			rendering.setType(new QName("lP"));
			renderings.getRendering().add(rendering);
			leanTask.setRenderings(renderings);
			
			TExpression expression = new TExpression();
			expression.setExpressionLanguage("sbql");
			leanTask.setSearchBy(expression);
			
			RegisterLeanTaskDefinition registerLeanTaskDefinition = new RegisterLeanTaskDefinition();
			registerLeanTaskDefinition.setTaskDefinition(leanTask);
			System.out.println(JAXBUtil.marshal(registerLeanTaskDefinition));
		} catch (WSHTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
