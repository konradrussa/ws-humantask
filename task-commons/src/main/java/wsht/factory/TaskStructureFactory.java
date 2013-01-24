package wsht.factory;

import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.apache.commons.lang.StringUtils;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.ObjectFactory;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TAggregate;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TArgument;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TBooleanExpr;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TCompletion;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TCompletionBehavior;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TCopy;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TDeadline;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TDeadlineExpr;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TDeadlines;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TDefaultCompletion;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TDescription;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TDocumentation;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TDurationExpr;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TEscalation;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TExpression;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TExtensibleElements;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TFrom;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TGenericHumanRoleAssignment;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TGenericHumanRoleAssignmentBase;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TLiteral;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TLogicalPeopleGroup;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TLogicalPeopleGroups;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TNotification;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TNotificationInterface;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TParallel;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TParameter;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TPattern;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TPeopleAssignments;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TPotentialOwnerAssignment;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TPresentationElements;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TPresentationParameter;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TPresentationParameters;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TPriorityExpr;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TQuery;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TReassignment;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TRenderings;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TResult;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TSequence;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TText;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TOrganizationalEntity;

import wsht.exception.WSHTException;

public class TaskStructureFactory {
	
	private TaskStructureFactory(){};
	
	private static ObjectFactory factory;
	private static org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.ObjectFactory factoryTypes;
	private static TaskStructureFactory instance;
	
	public static TaskStructureFactory getInstance() {
		if(instance == null) {
			instance = new TaskStructureFactory();
			factory = new ObjectFactory();
			factoryTypes = new org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.ObjectFactory();
		}
		return instance;
	}
		
	//common methods

	public QName createQName(String namespaceURI, String localPart) throws WSHTException {
		return createQName(namespaceURI, localPart, null);
	}
	
	public QName createQName(String namespaceURI, String localPart, String prefix) throws WSHTException {
		if(StringUtils.isBlank(namespaceURI) && StringUtils.isBlank(localPart)) {
			throw new WSHTException("error - Parameter type QName without namespaceURI and localPart");
		}
		QName type = null;
		if(StringUtils.isBlank(prefix))
			type = new QName(namespaceURI, localPart);
		else
			type = new QName(namespaceURI, localPart, prefix);
		return type;
	}
	
	public <T> TExtensibleElements addDocumentation(TExtensibleElements element, TDocumentation documentation) throws WSHTException {
		if(element == null || documentation == null) {
			throw new WSHTException("error - documentation and element should be presended");
		}
		element.getDocumentation().add(documentation);
		return element;
	}
	
	
	//logical people groups methods
	public TParameter createParameter(QName type, String name, String parameterQuery) throws WSHTException {
		if(type == null || StringUtils.isBlank(name) || StringUtils.isBlank(parameterQuery)) {
			throw new WSHTException("error - parameter should have type, name and query");
		}
		TParameter parameter = factory.createTParameter();
		parameter.setName(name);
		parameter.setType(type);
		parameter.getContent().add(parameterQuery);
		return parameter;
	}
	
	public TLogicalPeopleGroup createLogicalPeopleGroup(String name, TParameter parameter) throws WSHTException {
		if(StringUtils.isBlank(name)) {
			throw new WSHTException("error - LPG should have name");
		}
		TLogicalPeopleGroup logicalPeopleGroup = factory.createTLogicalPeopleGroup();
		logicalPeopleGroup.setName(name);
		return logicalPeopleGroup;
	}
	
	public TLogicalPeopleGroups createLogicalPeopleGroups(TLogicalPeopleGroup... groups) throws WSHTException {
		if(groups == null || groups.length == 0) {
			throw new WSHTException("error - passed 0 Logical People Groups for assignment");
		}
		TLogicalPeopleGroups logicalPeopleGroups = factory.createTLogicalPeopleGroups();
		logicalPeopleGroups.getLogicalPeopleGroup().addAll(Arrays.asList(groups));
		return logicalPeopleGroups;
	}
	
	//types for definition metadata
	
	public JAXBElement<String> createOrganizationalEntityUserElement(String username) throws WSHTException {
		if(StringUtils.isBlank(username)) {
			throw new WSHTException("error - username empty");
		}
		JAXBElement<String> userElement = factoryTypes.createTOrganizationalEntityGroup(username);
		return userElement;
	}
	
	public JAXBElement<String> createOrganizationalEntityGroupElement(String groupname) throws WSHTException {
		if(StringUtils.isBlank(groupname)) {
			throw new WSHTException("error - groupname empty");
		}
		JAXBElement<String> groupElement = factoryTypes.createTOrganizationalEntityGroup(groupname);
		return groupElement;
	}
	
	public TOrganizationalEntity createOrganizationalEntity(List<JAXBElement<String>> listElements) {
		TOrganizationalEntity organizationalEntity = factoryTypes.createTOrganizationalEntity();
		organizationalEntity.getUserOrGroup().addAll(listElements);
		return organizationalEntity;
	}
	
	//people assigmnets methods
	public TArgument createArgument(String name, String argumentQuery) throws WSHTException {
		if(StringUtils.isBlank(name)) {
			throw new WSHTException("error - argument should have name");
		}
		TArgument argument = factory.createTArgument();
		argument.setName(name);
		argument.getContent().add(argumentQuery);
		return argument;
	}
	
	public TLiteral createLiteral(TOrganizationalEntity organizationalEntity) {
		TLiteral literal = factory.createTLiteral();
		literal.setOrganizationalEntity(organizationalEntity);
		return literal;
	}
	
	public TFrom createFrom(String fromQuery) throws WSHTException {
		if(StringUtils.isBlank(fromQuery)) {
			throw new WSHTException("error - From should have query");
		}
		TFrom from = factory.createTFrom();
		from.getContent().add(fromQuery);
		return from;
	}
	
	public TFrom createFrom(String logicalPeopleGroup, TArgument argument) throws WSHTException {
		if(StringUtils.isBlank(logicalPeopleGroup)) {
			throw new WSHTException("error - from should have LPG name if created with an argument");
		}
		TFrom from = factory.createTFrom();
		from.setLogicalPeopleGroup(logicalPeopleGroup);
		from.setArgument(argument);
		return from;
	}
	
	public TFrom createFrom(TLiteral literal) {
		TFrom from = factory.createTFrom();
		from.setLiteral(literal);
		return from;
	}
	
	public TGenericHumanRoleAssignment createGenericHumanRoleAssignment(TFrom from) throws WSHTException {
		TGenericHumanRoleAssignment assignment = factory.createTGenericHumanRoleAssignment();
		assignment.setFrom(from);
		return assignment;
	}
	
	public TParallel createParallel() {
		throw new IllegalAccessError("error - createParallel operation not implemented");
		//TParallel parallel = factory.createTParallel();
		//return parallel;
	}
	
	public TSequence getSequence() {
		throw new IllegalAccessError("error - createSequence operation not implemented");
		//TSequence sequence = factory.createTSequence();
		//return sequence;
	}
	
	public TPotentialOwnerAssignment createPotentialOwnerAssignment(TFrom from, TParallel parallel, TSequence sequence) throws WSHTException {
		if(parallel != null && sequence != null) {
	    	throw new WSHTException("error - creation of potential owner assignment not permitted, pass parallel or sequence");
	    }
		if(from == null) {
			throw new WSHTException("error - creation of potential owner assignment not permitted, from not exists");
		}
		TPotentialOwnerAssignment assignment = factory.createTPotentialOwnerAssignment();
	    assignment.setFrom(from);
	    assignment.setParallel(parallel);
	    assignment.setSequence(sequence);
		return assignment;
	}
	
	public JAXBElement<TPotentialOwnerAssignment> createPotentialOwners(TPotentialOwnerAssignment assignment) throws WSHTException {
		return factory.createPotentialOwners(assignment);
	}
	
	public JAXBElement<TGenericHumanRoleAssignment> createBusinessAdministrator(TGenericHumanRoleAssignment assignment) throws WSHTException {
		return factory.createBusinessAdministrators(assignment);
	}
	
	public JAXBElement<TGenericHumanRoleAssignment> createTaskStakeholders(TGenericHumanRoleAssignment assignment) throws WSHTException {
		return factory.createTaskStakeholders(assignment);
	}
	
	public JAXBElement<TGenericHumanRoleAssignment> createExcludedOwners(TGenericHumanRoleAssignment assignment) throws WSHTException {
		return factory.createExcludedOwners(assignment);
	}
	
	public JAXBElement<TGenericHumanRoleAssignment> createNotificationRecipients(TGenericHumanRoleAssignment assignment) throws WSHTException {
		return factory.createRecipients(assignment);
	}
	
	public JAXBElement<TGenericHumanRoleAssignment> createTaskInitiator(TGenericHumanRoleAssignment assignment) throws WSHTException {
		return factory.createTaskInitiator(assignment);
	}
	
	public TPeopleAssignments createPeopleAssignments(JAXBElement<? extends TGenericHumanRoleAssignmentBase>... assignments) throws WSHTException {
		if(assignments == null || assignments.length == 0) {
			throw new WSHTException("error - passed 0 assignments");
		}
		TPeopleAssignments peopleAssignments = factory.createTPeopleAssignments();
		peopleAssignments.getGenericHumanRole().addAll(Arrays.asList(assignments));
		return peopleAssignments;
	}
	
	//operational data methods
	public TPriorityExpr createPriorityExpr(String expressionLanguage, String priorityQuery) throws WSHTException {
		if(StringUtils.isBlank(priorityQuery)) {
			throw new WSHTException("error - expr should have query");
		}
		TPriorityExpr priorityExpr = factory.createTPriorityExpr();
		priorityExpr.setExpressionLanguage(expressionLanguage);
		priorityExpr.getContent().add(priorityQuery);
		return priorityExpr;
	}
	
	//deadlines and escalations
	
	public TDurationExpr createDurationExpr(String expressionLanguage, String durationQuery) throws WSHTException {
		if(StringUtils.isBlank(durationQuery)) {
			throw new WSHTException("error - expr should have query");
		}
		TDurationExpr durationExpr = factory.createTDurationExpr();
		durationExpr.setExpressionLanguage(expressionLanguage);
		durationExpr.getContent().add(durationQuery);
		return durationExpr;
	}
	
	public TDeadlineExpr createDeadlineExpr(String expressionLanguage, String deadlineQuery) throws WSHTException {
		if(StringUtils.isBlank(deadlineQuery)) {
			throw new WSHTException("error - expr should have query");
		}
		TDeadlineExpr deadlineExpr = factory.createTDeadlineExpr();
		deadlineExpr.setExpressionLanguage(expressionLanguage);
		deadlineExpr.getContent().add(deadlineQuery);
		return deadlineExpr;
	}
	public TBooleanExpr createBooleanExpr(String expressionLanguage, String booleanQuery) throws WSHTException {
		if(StringUtils.isBlank(booleanQuery)) {
			throw new WSHTException("error - expr should have query");
		}
		TBooleanExpr booleanExpr = factory.createTBooleanExpr();
		booleanExpr.setExpressionLanguage(expressionLanguage);
		booleanExpr.getContent().add(booleanQuery);
		return booleanExpr;
	}
	
	public TReassignment createReassignment(TPotentialOwnerAssignment potentialOwnerAssignment) {
		TReassignment reassignment = factory.createTReassignment();
		reassignment.setPotentialOwners(potentialOwnerAssignment);
		return reassignment;
	}
	
	public TEscalation createEscalation(String name, TBooleanExpr booleanExpr, TReassignment reassignment) throws WSHTException {
		if(StringUtils.isBlank(name)) {
			throw new WSHTException("error - escalation should have name");
		}
		TEscalation escalation = factory.createTEscalation();
		escalation.setName(name);
		escalation.setCondition(booleanExpr);
		escalation.setReassignment(reassignment);
		return escalation;
	}
	
	public TDeadline createDeadline(String name, TDurationExpr _for, TDeadlineExpr until, List<TEscalation> escalation) throws WSHTException {
		if(StringUtils.isBlank(name)) {
			throw new WSHTException("error - deadline should have name");
		}
		TDeadline deadline = factory.createTDeadline();
		deadline.setName(name);
		deadline.setFor(_for);
		deadline.setUntil(until);
		deadline.getEscalation().addAll(escalation);
		return deadline;
	}
	
	public TDeadlines createDeadlines(List<TDeadline> startDeadlines, List<TDeadline> completionDeadlines) throws WSHTException {
		if((startDeadlines == null || startDeadlines.isEmpty()) && (completionDeadlines == null || completionDeadlines.isEmpty())) {
			throw new WSHTException("error - deadlines created without start and completion deadlines");
		}
		TDeadlines deadlines = factory.createTDeadlines();
		deadlines.getStartDeadline().addAll(startDeadlines);
		deadlines.getCompletionDeadline().addAll(completionDeadlines);
		return deadlines;
	}
	
	//notifications
	public TNotification createNotification(String name, TNotificationInterface _interface, 
											TPriorityExpr priority, TPeopleAssignments peopleAssignments, 
											TPresentationElements presentationElements, TRenderings renderings) throws WSHTException {
			if(StringUtils.isBlank(name)) {
				throw new WSHTException("error - notification should have name, and the less presentationElements");
			}
			TNotification notification = factory.createTNotification();
			notification.setName(name);
			notification.setInterface(_interface);
			notification.setPriority(priority);
			notification.setPeopleAssignments(peopleAssignments);
			notification.setPresentationElements(presentationElements);
			notification.setRenderings(renderings);
			return notification;
	}
	
	public TNotificationInterface createNotificationInterface(QName portType, String operation) throws WSHTException {
		if(portType == null|| StringUtils.isBlank(operation)) {
			throw new WSHTException("error - notification interface should have portType and operation");
		}
		TNotificationInterface notificationInterface = factory.createTNotificationInterface();
		notificationInterface.setPortType(portType);
		notificationInterface.setOperation(operation);
		return notificationInterface;
	}
	
	
	//presentation
	public TPresentationElements createPresentationElements(List<TText> name, 
															TPresentationParameters presentationParameters, 
															List<TText> subject, 
															List<TDescription> description) throws WSHTException {
		if(name == null || name.isEmpty()) {
			throw new WSHTException("error - name for presentation elements should be presented");
		}
		TPresentationElements presentationElements = factory.createTPresentationElements();
		presentationElements.setPresentationParameters(presentationParameters);
		presentationElements.getName().addAll(name);
		if(subject != null )presentationElements.getSubject().addAll(subject);
		if(description != null )presentationElements.getDescription().addAll(description);
		return presentationElements;
	}
	
	public TText createText(String lang, String content) throws WSHTException {
		if(StringUtils.isBlank(lang) || StringUtils.isBlank(content)) {
			throw new WSHTException("error - text should have content");
		}
		TText text = factory.createTText();
		text.setLang(lang);
		text.getContent().add(content);
		return text;
	}
	
	public TDescription createDescription(String lang, String contentType, String content) throws WSHTException {
		if(StringUtils.isBlank(lang) || StringUtils.isBlank(contentType) || StringUtils.isBlank(content)) {
			throw new WSHTException("error - description should have lang, content and contentType");
		}
		TDescription description = factory.createTDescription();
		description.setLang(lang);
		description.setContentType(contentType);
		description.getContent().add(content);
		return description;
	}
	
	public TPresentationParameter createPresentationParameter(QName type, String name, String parameterQuery) throws WSHTException {
		if(type == null || StringUtils.isBlank(name) || StringUtils.isBlank(parameterQuery)) {
			throw new WSHTException("error - parameter should have type, name and query");
		}
		TPresentationParameter presentationParameter = factory.createTPresentationParameter();
		presentationParameter.setName(name);
		presentationParameter.setType(type);
		presentationParameter.getContent().add(parameterQuery);
		return presentationParameter;
	}
	
	public TPresentationParameters createPresentationParameters(String expressionLanguage, TPresentationParameter... presentationParameter) {
		TPresentationParameters presentationParameters = factory.createTPresentationParameters();
		presentationParameters.setExpressionLanguage(expressionLanguage);
		presentationParameters.getPresentationParameter().addAll(Arrays.asList(presentationParameter));
		return presentationParameters;
	}
	
	public TRenderings createRenderings() {
		throw new IllegalAccessError("error - renderings not supported yet");
		//TRenderings renderings = factory.createTRenderings();
		//return renderings;
	}
	
	public TQuery createQuery(String part, String queryLanguage, String queryExpression) throws WSHTException {
		if(StringUtils.isBlank(queryExpression)) {
			throw new WSHTException("error - query should have query");
		}
		TQuery query = factory.createTQuery();
		query.setPart(part);
		query.setQueryLanguage(queryLanguage);
		query.getContent().add(queryExpression);
		return query;
		
	}
	
	public TExpression createExpression(String expressionLanguage, String expressionQuery) throws WSHTException {
		if(StringUtils.isBlank(expressionQuery)) {
			throw new WSHTException("error - expr should have query");
		}
		TExpression expression = factory.createTExpression();
		expression.setExpressionLanguage(expressionLanguage);
		expression.getContent().add(expressionQuery);
		return expression;
	}
	
	public TCopy createCopy(TExpression from, TQuery to) throws WSHTException {
		if(from == null || to == null) {
			throw new WSHTException("error - copy should have from and to");
		}
		TCopy copy = factory.createTCopy();
		copy.setFrom(from);
		copy.setTo(to);
		return copy;
	}
	
	public TAggregate createAggregate(String condition, String function, String location, String part) {
		TAggregate aggregate = factory.createTAggregate();
		aggregate.setCondition(condition);
		aggregate.setFunction(function);
		aggregate.setLocation(location);
		aggregate.setPart(part);
		return aggregate;
	}
	
	public TResult createResult() {
		TResult result = factory.createTResult();
		
		return result;
	}
	
	public TDefaultCompletion createDefaultCompletion(TResult result) throws WSHTException {
		if(result == null) {
			throw new WSHTException("error - default completion should have result");
		}
		TDefaultCompletion defaultCompletion = factory.createTDefaultCompletion();
		defaultCompletion.setResult(result);
		return defaultCompletion;
	}
	
	public TCompletion createCompletion(TBooleanExpr condition, TResult result) throws WSHTException {
		if(condition == null) {
			throw new WSHTException("error - completion should have condition");
		}
		TCompletion completion = factory.createTCompletion();
		completion.setCondition(condition);
		completion.setResult(result);
		return completion;
	}
	
	public TCompletionBehavior createCompletionBehavior(TPattern pattern, TDefaultCompletion defaultCompletion) {
		TCompletionBehavior completionBehavior = factory.createTCompletionBehavior();
		completionBehavior.setCompletionAction(pattern);
		completionBehavior.setDefaultCompletion(defaultCompletion);
		return completionBehavior;
	}
	
	//TTaskInterface
	//TMessageSchema
	//TDelegation
	//TComposition
	
	
}
