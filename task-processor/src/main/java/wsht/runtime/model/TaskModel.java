package wsht.runtime.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import wsht.exception.WSHTException;
import wsht.infrastructure.domain.entity.Argument;
import wsht.infrastructure.domain.entity.Comment;
import wsht.infrastructure.domain.entity.Comments;
import wsht.infrastructure.domain.entity.Deadline;
import wsht.infrastructure.domain.entity.DeadlineExpr;
import wsht.infrastructure.domain.entity.Deadlines;
import wsht.infrastructure.domain.entity.DurationExpr;
import wsht.infrastructure.domain.entity.From;
import wsht.infrastructure.domain.entity.GenericHumanRoleAssignment;
import wsht.infrastructure.domain.entity.LeanTask;
import wsht.infrastructure.domain.entity.Literal;
import wsht.infrastructure.domain.entity.LogicalPeopleDefinition;
import wsht.infrastructure.domain.entity.OrganizationalEntity;
import wsht.infrastructure.domain.entity.PeopleAssignments;
import wsht.infrastructure.domain.entity.PotentialOwnerAssignment;
import wsht.infrastructure.domain.entity.PriorityExpr;
import wsht.infrastructure.domain.entity.TaskInfo;
import wsht.infrastructure.domain.entity.UserEntityInfo;
import wsht.infrastructure.domain.entity.base.Expression;
import wsht.infrastructure.domain.entity.base.GenericHumanRoleAssignmentBase;
import wsht.infrastructure.service.IRepositoryService;
import wsht.runtime.db4o.IDB4oInterface;
import wsht.runtime.enums.TaskStatesEnum;
import wsht.runtime.expressions.sbql.ast.operators.wsht.ext.IValuable;
import wsht.runtime.expressions.sbql.qres.exception.SBQLEvalException;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.BagResult;
import wsht.runtime.expressions.sbql.qres.result.IntegerResult;
import wsht.runtime.expressions.sbql.store.TaskInstance;
import wsht.runtime.factories.TaskFactory;
import wsht.runtime.listeners.IEventProcessingListenser;
import wsht.runtime.listeners.ITaskListener;
import wsht.runtime.model.query.IPeopleQuery;

@Service("taskModel")
public class TaskModel extends AbstractTaskModel implements ITaskListener {
	private static final long serialVersionUID = 796725152091254822L;
	
	
	@Resource
	private IRepositoryService repositoryService;
	@Resource
	private IDB4oInterface db4oInterface;
	@Resource
	private IValuable expressionContextService;
	@Resource
	private IEventProcessingListenser communicatingModel;
	@Resource
	private IPeopleQuery peopleQuery;
	
	private Map<String, AbstractQueryResult> evaluationMap;

	private Map<String, Tuple> peopleRolesAssignment;
	
	private Set<Expression> expressions;
	
	public void setUpTaskInfo() {
		this.taskInfo = getSessionInfo().getUserSession().getTaskInfo();
	}
	
	
	private void evaluateExpressions(Object input, Set<Expression> expressions) throws WSHTException {
		try {
			Set<String> expressionSet = new HashSet<String>();
			for(Expression expr : expressions) {
				if(expr.getContent() != null && !expr.getContent().isEmpty()) {
					expressionSet.addAll(expr.getContent());
				}
			}
			evaluationMap = expressionContextService.evalInputConditions(expressionSet, input, false);
		} catch(SBQLEvalException e) {
			throw new WSHTException(e.getMessage());
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, rollbackFor={Throwable.class})
	public void processLeanTaskDefinitionAndCreate(Object input, LeanTask leanTask) throws WSHTException {
		
		if(input == null) {
			throw new WSHTException("error - Process Lean Task Definition for instance failed, no input schema");
		}
		
		String taskIdentifier = leanTask.getName() + "_" + UUID.randomUUID().toString().substring(0,3);
		TaskInstance taskInstance = new TaskInstance(taskIdentifier);
		taskInstance.getContent().add(input);
		
		//1
		PriorityExpr prio = leanTask.getPriority();
		taskInstance = processTaskPriority(prio, taskInstance);
		
		//2
		PeopleAssignments peopleAssignments = leanTask.getPeopleAssignments();
		processPeopleAssignment(peopleAssignments);
		List<LogicalPeopleDefinition> logicalPeopleDefinitions = peopleQuery.evaluate(taskInstance, peopleRolesAssignment);
		taskInstance = assignPeopleToInstance(taskInstance, logicalPeopleDefinitions);
		
		
		//3
		Deadlines deadlines = leanTask.getDeadlines();
		List<Deadline> startDeadlines = deadlines.getStartDeadline();
		processDeadlines(startDeadlines, taskInstance);
		List<Deadline> completeDeadlines = deadlines.getCompletionDeadline();
		processDeadlines(completeDeadlines, taskInstance);
		
		//4
		leanTask.getPresentationElements();
		
		
		leanTask = repositoryService.createLeanTaskDefinition(leanTask);
		TaskInfo taskInfo = TaskFactory.instance().buildTaskInfo(leanTask);
		taskInfo.setTaskIdentifier(taskIdentifier);
		taskInfo = repositoryService.createTaskInfo(taskInfo);
		logicalPeopleDefinitions = repositoryService.createLogicalPeopleDefinitions(logicalPeopleDefinitions);
		//db4oInterface.storeObject(taskInstance);
   	 	

	}
	
	public class CClass {
		public Integer prio = 2;
	}
	

	
	private void processDeadlines(List<Deadline> deadlines, TaskInstance taskInstance) throws WSHTException {
		for(Deadline deadline : deadlines) {
			processDeadline(deadline, taskInstance);
		}
	}
	
	private void processDeadline(Deadline deadline, TaskInstance taskInstance) throws WSHTException {
		DurationExpr _for = deadline.get_for();
		DeadlineExpr until = deadline.getUntil();
		
		if(_for != null && until != null) {
			throw new WSHTException("error - deadline shouldnt have both conditions, choose for or until");
		}
		
		if(_for != null) {
			Set<String> forConditions = _for.getContent();
			if(forConditions == null || forConditions.isEmpty()) {
				throw new WSHTException("error - for condition empty");
			}
			processDurationExpr(_for, taskInstance);
		}
		
		if(until != null) {
			Set<String> untilConditions = until.getContent();
			if(untilConditions == null || untilConditions.isEmpty()) {
				throw new WSHTException("error - until condition empty");
			}
		}
	}
	
	private void processDurationExpr(DurationExpr _for, TaskInstance taskInstance) throws WSHTException {
		if(_for.getContent() == null || _for.getContent().isEmpty()) {
			throw new WSHTException("error - for should have query");
		}
		String expression = _for.getContent().iterator().next();
		AbstractQueryResult result = expressionContextService.evalExternal(expression, taskInstance, false);
		if(!(result instanceof BagResult)) {
			throw new WSHTException("error - duration should be an struct<elapsed,date>");
		}
	}
	

	
	private TaskInstance processTaskPriority(PriorityExpr prio, TaskInstance instance) throws WSHTException {
		if(prio == null || prio.getContent() == null || prio.getContent().isEmpty()) {
			throw new WSHTException("error - No priority query");
		}
		String expression = prio.getContent().iterator().next();
		try {
			expressionContextService.setUpTaskInstance(instance);
			AbstractQueryResult result = expressionContextService.eval(expression, false);
			if(!(result instanceof IntegerResult)) {
				throw new WSHTException("error - priority should be an integer");
			}
			instance.setTaskPriority(((IntegerResult)result).getValue());
		} catch(SBQLEvalException e) {
			throw new WSHTException(e.getMessage());
		}
		return instance;
	}
	
	
	private TaskInstance assignPeopleToInstance(TaskInstance instance, List<LogicalPeopleDefinition> logicalPeopleDefinitions) {
		for(LogicalPeopleDefinition lpd : logicalPeopleDefinitions) {
			if("businessAdministrators".equals(lpd.getRoleName())) {
				for(UserEntityInfo ue : lpd.getUserInfos()) {
					instance.fillInBusinessAdministrator(ue.getUserName());
				}
			}
			if("potentialOwners".equals(lpd.getRoleName())) {
				for(UserEntityInfo ue : lpd.getUserInfos()) {
					instance.fillInPotentialOwner(ue.getUserName());
				}
			}
			if("recipients".equals(lpd.getRoleName())) {
				for(UserEntityInfo ue : lpd.getUserInfos()) {
					instance.fillInRecipient(ue.getUserName());
				}
			}
			if("excludedOwners".equals(lpd.getRoleName())) {
				for(UserEntityInfo ue : lpd.getUserInfos()) {
					instance.fillInExcludedOwner(ue.getUserName());
				}
			}
			
		}
		instance.fillInTaskInitiator(getSessionInfo().getUserInfo().getUserName());
		return instance;
	}

	
	private void processPeopleAssignment(PeopleAssignments peopleAssignments) throws WSHTException {
		List<GenericHumanRoleAssignmentBase> genericRoles = peopleAssignments.getGenericHumanRole();
		if(genericRoles == null || genericRoles.isEmpty()) {
			throw new WSHTException("error - No PeopleAssignment");
		}
		for(GenericHumanRoleAssignmentBase r : genericRoles) {
			if(GenericHumanRoleAssignment.class.isInstance(r)) {
				processGenericHumanRoleAssignment((GenericHumanRoleAssignment) r);
			}
			if(PotentialOwnerAssignment.class.isInstance(r)) {
				processPotentialOwnerAssignment((PotentialOwnerAssignment) r);
			}
		}
	}
	
	private void processGenericHumanRoleAssignment(GenericHumanRoleAssignment genericHumanRole) throws WSHTException {
		GenericHumanRoleAssignment genericRole = (GenericHumanRoleAssignment)genericHumanRole;
		String roleName = genericRole.getName();
		From from = genericRole.getFrom();
		if(from  == null) {
			throw new WSHTException("error - generic role without query elements");
		}
		processFrom(from, roleName);
	}
	
	private void processPotentialOwnerAssignment(PotentialOwnerAssignment potentialOwner) throws WSHTException {
		PotentialOwnerAssignment potentialOwners = (PotentialOwnerAssignment)potentialOwner;
		String roleName = potentialOwners.getName();
		From from = potentialOwners.getFrom();
		if(from  == null) {
			throw new WSHTException("error - potential owner without query elements");
		}
		processFrom(from, roleName);
	}
	
	private void processFrom(From from, String roleName) throws WSHTException {
		if(from  == null) {
			throw new WSHTException("error - generic human role "+roleName+" without query elements");
		}
		
		Argument argument = from.getArgument();
		Literal literal = from.getLiteral();
		
		if(literal == null && argument == null) {
			throw new WSHTException("error - generic human role with name " + roleName + " has no literal and argument");
		}
		if(argument != null) {
			String logicalPeopleGroups = from.getLogicalPeopleGroup();
			if(StringUtils.isBlank(logicalPeopleGroups)) {
				throw new WSHTException("error - logicalPeopleQuery has no name");
			}
			if(peopleRolesAssignment.containsKey(roleName)) {
				throw new WSHTException("error - role with name " + roleName + " exists in definition");
			}
			Tuple tuple = processArgument(argument, logicalPeopleGroups, roleName);
			peopleRolesAssignment.put(roleName, tuple);
		}
		if(literal != null) {
			Tuple tuple = processLiteral(literal, roleName);
			peopleRolesAssignment.put(roleName, tuple);
		}
	}
	
	private Tuple processArgument(Argument argument, String logicalPeopleGroups, String roleName) throws WSHTException {
		String argumentName = argument.getName();
		if(StringUtils.isBlank(argumentName)) {
			throw new WSHTException("error - argument without name");
		}
	    Set<String> argContent = argument.getContent();
	    if(argContent == null || argContent.isEmpty()) {
	    	throw new WSHTException("error - argument without query");
	    }
	    Tuple tuple = new Tuple();
	    tuple.logicalPeopleGroup = logicalPeopleGroups;
	    tuple.argumentName = argumentName;
	    tuple.expression = argContent.iterator().next();
	    return tuple;
	}
	
	private Tuple processLiteral(Literal literal, String roleName) throws WSHTException {
		OrganizationalEntity organizationalEntity = literal.getOrganizationalEntity();
		if(organizationalEntity == null) {
			throw new WSHTException("error - literal without organizational entity");
		}
		Set<String> userOrg = organizationalEntity.getUserOrg();
		Set<String> groupOrg = organizationalEntity.getGroupOrg();
		if((userOrg == null || userOrg.isEmpty()) && (groupOrg == null || groupOrg.isEmpty())) {
			throw new WSHTException("error - literal without organizational entity");
		}
		Tuple tuple = new Tuple();
		if(groupOrg == null || groupOrg.isEmpty()) {
			tuple.groups = new HashSet<String>();
			tuple.groups.addAll(groupOrg);
		}
		if((userOrg == null || userOrg.isEmpty())) {
			tuple.users = new HashSet<String>();
			tuple.users.addAll(groupOrg);
		}
		return tuple;
	}

	
	public TaskInstance createTaskInstance(String taskIdentifier) {
		TaskInstance taskInstance = new TaskInstance(taskIdentifier);
		return taskInstance;
	}

	
	
	public class Tuple {
		private String roleName;
		private String logicalPeopleGroup;
		private String argumentName;
		private String expression;
		private Set<String> users;
		private Set<String> groups;
		
		public Tuple(){}

		public String getRoleName() {
			return roleName;
		}

		public String getLogicalPeopleGroup() {
			return logicalPeopleGroup;
		}

		public String getArgumentName() {
			return argumentName;
		}

		public String getExpression() {
			return expression;
		}

		public Set<String> getUsers() {
			return users;
		}

		public Set<String> getGroups() {
			return groups;
		}

	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void stateChanged(TaskStatesEnum newState) {
		Comments comments = taskInfo.getComments();
		Comment comment = new Comment();
		comment.setAddedBy(getSessionInfo().getUserInfo().getUserName());
		comment.setLastModifiedBy(getSessionInfo().getUserInfo().getUserName());
		comment.setLastModifiedTime(new Date());
		comment.setText("Event - Task State changed from " + taskInfo.getState() + " to " + newState);
		taskInfo.setState(newState);
		comment = repositoryService.createComment(comment);
		comments.getComment().add(comment);
		repositoryService.mergeComments(comments);
		repositoryService.updateTaskInfo(taskInfo);
	}


	@Override
	public void onTaskReady() {
		
	}


	@Override
	public void onResumeReady() {
		
	}


	public void processLeanTaskDefinitionAsync(LeanTask leanTask) {
		// TODO Auto-generated method stub
		
	}
}
