package wsht.infrastructure.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.db4o.ObjectSet;

import wsht.infrastructure.domain.entity.Attachment;
import wsht.infrastructure.domain.entity.Comment;
import wsht.infrastructure.domain.entity.Comments;
import wsht.infrastructure.domain.entity.Fault;
import wsht.infrastructure.domain.entity.GroupEntityInfo;
import wsht.infrastructure.domain.entity.HumanInteractions;
import wsht.infrastructure.domain.entity.LeanTask;
import wsht.infrastructure.domain.entity.LogicalPeopleDefinition;
import wsht.infrastructure.domain.entity.TaskInfo;
import wsht.infrastructure.domain.entity.UserEntityInfo;
import wsht.infrastructure.domain.entity.base.TaskBase;
import wsht.infrastructure.repository.IAggregateRepository;
import wsht.infrastructure.repository.IAttachmentInfoRepository;
import wsht.infrastructure.repository.IAttachmentRepository;
import wsht.infrastructure.repository.IBooleanExprRepository;
import wsht.infrastructure.repository.ICommentRepository;
import wsht.infrastructure.repository.ICommentsRepository;
import wsht.infrastructure.repository.ICompletionBehaviorRepository;
import wsht.infrastructure.repository.ICompletionRepository;
import wsht.infrastructure.repository.ICopyRepository;
import wsht.infrastructure.repository.IDeadlineExprRepository;
import wsht.infrastructure.repository.IDeadlineRepository;
import wsht.infrastructure.repository.IDeadlinesRepository;
import wsht.infrastructure.repository.IDefaultCompletionRepository;
import wsht.infrastructure.repository.IDelegationRepository;
import wsht.infrastructure.repository.IDescriptionRepository;
import wsht.infrastructure.repository.IDocumentationRepository;
import wsht.infrastructure.repository.IDurationExprRepository;
import wsht.infrastructure.repository.IEscalationRepository;
import wsht.infrastructure.repository.IFaultRepository;
import wsht.infrastructure.repository.IFromRepository;
import wsht.infrastructure.repository.IGenericHumanRoleAssignmentRepository;
import wsht.infrastructure.repository.IGroupEntityInfoRepository;
import wsht.infrastructure.repository.IHumanInteractionsRepository;
import wsht.infrastructure.repository.ILeanTaskRepository;
import wsht.infrastructure.repository.ILocalNotificationRepository;
import wsht.infrastructure.repository.ILogicalPeopleDefinitionRepository;
import wsht.infrastructure.repository.IMessageChoiceRepository;
import wsht.infrastructure.repository.IMessageDisplayRepository;
import wsht.infrastructure.repository.IMessageFieldRepository;
import wsht.infrastructure.repository.IMessageSchemaRepository;
import wsht.infrastructure.repository.INotificationInterfaceRepository;
import wsht.infrastructure.repository.INotificationRepository;
import wsht.infrastructure.repository.IOrganizationalEntityRepository;
import wsht.infrastructure.repository.IParallelRepository;
import wsht.infrastructure.repository.IParameterRepository;
import wsht.infrastructure.repository.IPeopleAssignmentsRepository;
import wsht.infrastructure.repository.IPotentialOwnerAssignmentRepository;
import wsht.infrastructure.repository.IPresentationParameterRepository;
import wsht.infrastructure.repository.IPriorityExprRepository;
import wsht.infrastructure.repository.IQueryRepository;
import wsht.infrastructure.repository.IRenderingsRepository;
import wsht.infrastructure.repository.IResultRepository;
import wsht.infrastructure.repository.ISequenceRepository;
import wsht.infrastructure.repository.ITaskInfoRepository;
import wsht.infrastructure.repository.ITaskRepository;
import wsht.infrastructure.repository.ITextRepository;
import wsht.infrastructure.repository.IToPartRepository;
import wsht.infrastructure.repository.IToPartsRepository;
import wsht.infrastructure.repository.IUserEntityInfoRepository;
import wsht.exception.WSHTException;

@Service("repositoryService")
public class RepositoryService implements IRepositoryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryService.class);

	@Resource
	private ITaskRepository taskRepository;
	@Resource
	private ILeanTaskRepository leanTaskRepository;
	@Resource
	private ITaskInfoRepository taskInfoRepository;
	@Resource
	private IAttachmentRepository attachmentRepository;
	@Resource
	private ICommentRepository commentRepository;
	@Resource
	private ICommentsRepository commentsRepository;
	@Resource
	private IGroupEntityInfoRepository groupEntityInfoRepository;
	@Resource
	private IUserEntityInfoRepository userEntityInfoRepository;
	@Resource
	private ILogicalPeopleDefinitionRepository logicalPeopleDefinitionRepository;
	@Resource
	private IFaultRepository faultRepository;
	@Resource
	private IHumanInteractionsRepository humanInteractionsRepository;
	
	@Resource
	private IAggregateRepository aggregateRepository;
	@Resource
	private IBooleanExprRepository booleanExprRepository;
	@Resource
	private ICompletionBehaviorRepository completionBehaviorRepository;
	@Resource
	private ICompletionRepository completionRepository;
	@Resource
	private ICopyRepository copyRepository;
	@Resource
	private IDeadlineExprRepository deadlineExprRepository;
	@Resource
	private IDeadlineRepository deadlineRepository;
	@Resource
	private IDeadlinesRepository deadlinesRepository;
	@Resource
	private IDefaultCompletionRepository defaultCompletionRepository;
	@Resource
	private IDelegationRepository delegationRepository;
	@Resource
	private IDescriptionRepository descriptionRepository;
	@Resource
	private IDocumentationRepository documentationRepository;
	@Resource
	private IDurationExprRepository durationExprRepository;
	@Resource
	private IGenericHumanRoleAssignmentRepository genericHumanRoleAssignmentRepository;
	@Resource
	private IEscalationRepository escalationRepository;
	@Resource
	private IFromRepository fromRepository;
	@Resource
	private ILocalNotificationRepository localNotificationRepository;
	@Resource
	private IMessageChoiceRepository messageChoiceRepository;
	@Resource
	private IMessageDisplayRepository messageDisplayRepository;
	@Resource
	private IMessageFieldRepository messageFieldRepository;
	@Resource
	private IMessageSchemaRepository messageSchemaRepository;
	@Resource
	private INotificationInterfaceRepository notificationInterfaceRepository;
	@Resource
	private INotificationRepository notificationRepository;
	@Resource
	private IOrganizationalEntityRepository organizationalEntityRepository;
	@Resource
	private IParallelRepository parallelRepository;
	@Resource
	private IParameterRepository parameterRepository;
	@Resource
	private IPeopleAssignmentsRepository peopleAssignmentsRepository;
	@Resource
	private IPotentialOwnerAssignmentRepository potentialOwnerAssignmentRepository;
	@Resource
	private IPresentationParameterRepository presentationParameterRepository;
	@Resource
	private IPriorityExprRepository priorityExprRepository;
	@Resource
	private IQueryRepository queryRepository;
	@Resource
	private IRenderingsRepository renderingsRepository;
	@Resource
	private IResultRepository resultRepository;
	@Resource
	private ISequenceRepository sequenceRepository;
	@Resource
	private ITextRepository textRepository;
	@Resource
	private IToPartRepository toPartRepository;
	@Resource
	private IToPartsRepository toPartsRepository;
	@Resource
	private IAttachmentInfoRepository attachmentInfoRepository;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public TaskInfo createTaskInfo(TaskInfo task) {
		LOGGER.debug("task creation");
		TaskBase taskBase = null;
		if(task.getIsLeanTask()) {
			taskBase = leanTaskRepository.get(task.getTask().getId());
		} else {
			taskBase = taskRepository.get(task.getTask().getId());
		}
		task.setTask(taskBase);
		task = taskInfoRepository.create(task);
		return task;
	}
	
	@Transactional(readOnly=true)
	public List<TaskInfo> getAllTasksInfo() {
		LOGGER.debug("get all tasks");
		List<TaskInfo> tasks = taskInfoRepository.getAll();
		return tasks;
	}

	@Transactional(readOnly=true)
	public TaskInfo getTaskInfoByTaskIdentifier(String taskIdentifier) throws WSHTException {
		LOGGER.debug("get task by id: " + taskIdentifier);
		return taskInfoRepository.getTaskInfoByTaskIdentifier(taskIdentifier);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updateTaskInfo(TaskInfo taskInfo) {
		LOGGER.debug("actualize task with id:" + taskInfo.getTaskIdentifier());
		taskInfoRepository.update(taskInfo);
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void deleteFault(Long id) throws WSHTException {
		LOGGER.debug("delete fault:" + id);
		
		Fault f = faultRepository.get(id);
		if(f == null) {
			throw new WSHTException("error - Fault not found");
		}
		faultRepository.delete(id);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Fault createFault(Fault f) {
		return faultRepository.create(f);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public HumanInteractions createHumanInteractions(HumanInteractions hi) {
		return humanInteractionsRepository.create(hi);
	}

	@Transactional(readOnly=true)
	public boolean checkIfLeanTaskWithNameExists(String leanTaskName) {
		return leanTaskRepository.checkIfLeanTaskDefinitionWithNameExists(leanTaskName);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public LeanTask createLeanTaskDefinition(LeanTask leanTask) throws WSHTException {
		return leanTaskRepository.createLeanTaskDefinition(leanTask);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteLeanTaskDefinition(String taskName) throws WSHTException {
		if(leanTaskRepository.checkIfLeanTaskDefinitionWithNameExists(taskName)) {
			LeanTask leanTask = leanTaskRepository.getLeanTaskDefinitionByName(taskName);
			leanTaskRepository.deleteLeanTaskDefinition(leanTask);
			leanTaskRepository.errorStateForInstances(leanTask);
		}
		
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Comment createComment(Comment comment) {
		return commentRepository.create(comment);
		
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteAttachment(Attachment attachment) {
		attachmentRepository.delete(attachment);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteComment(Comment comment) {
		commentRepository.delete(comment);
		
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void mergeComments(Comments comments) {
		commentsRepository.update(comments);
		
	}

	@Transactional(readOnly=true)
	public List<LeanTask> listLeanTaskDefinitions() throws WSHTException {
		return leanTaskRepository.listLeanTaskDefinitions();
	}

	@Transactional(readOnly=true)
	public LeanTask getLeanTaskDefinitionByName(String taskName) throws WSHTException {
		return leanTaskRepository.getLeanTaskDefinitionByName(taskName);
	}

	@Transactional(readOnly=true)
	public boolean checkIfLeanTaskDefinitionWithNameExists(String leanTaskName) {
		return leanTaskRepository.checkIfLeanTaskDefinitionWithNameExists(leanTaskName);
	}

	@Transactional(readOnly=true)
	public List<UserEntityInfo> getUserEntityInfoByUserNames(Set<String> userNames) throws WSHTException {
		if(userNames == null || userNames.isEmpty()) {
			throw new WSHTException("error - userNames for taking from UserDirectory empty");
		}
		return userEntityInfoRepository.getUserEntityInfoByUserNames(userNames);
	}

	@Transactional(readOnly=true)
	public List<GroupEntityInfo> getGroupEntityInfoByGroupCodes(Set<String> groupCodes) throws WSHTException {
		if(groupCodes == null || groupCodes.isEmpty()) {
			throw new WSHTException("error - groupCodes for taking from UserDirectory empty");
		}
		return groupEntityInfoRepository.getGroupEntityInfoByGroupCodes(groupCodes);
	}

	@Transactional(readOnly=true)
	public UserEntityInfo getUserEntity(String userName, String password) throws WSHTException {
		return userEntityInfoRepository.getUserEntity(userName, password);
		
	}

	@Transactional(readOnly=true)
	public List<UserEntityInfo> getUserEntityInfoByArgument(String logicalPeopleGroup, String param, Object value) throws WSHTException {
		return userEntityInfoRepository.getUserEntityInfoByArgument(logicalPeopleGroup, param, value);
	}

	@Transactional(readOnly=true)
	public List<UserEntityInfo> getUserEntityInfoByGroupNames(Set<String> groupNames) throws WSHTException {
		return userEntityInfoRepository.getUserEntityInfoByGroupNames(groupNames);
	}

	@Transactional(propagation=Propagation.MANDATORY)
	public List<LogicalPeopleDefinition> createLogicalPeopleDefinitions(List<LogicalPeopleDefinition> logicalPeopleDefinitions) throws WSHTException {
		List<LogicalPeopleDefinition> definitions = new ArrayList<LogicalPeopleDefinition>();
		for(LogicalPeopleDefinition lpd : logicalPeopleDefinitions) {
			definitions.add(logicalPeopleDefinitionRepository.create(lpd));
		}
		return definitions;
	}

	@Transactional(readOnly=true)
	public TaskInfo getLeanTaskTaskInfoByTaskIdentifier(String taskIdentifier) throws WSHTException {
		return taskInfoRepository.getLeanTaskTaskInfoByTaskIdentifier(taskIdentifier);
	}

	@Transactional(readOnly=true)
	public List<TaskInfo> getTaskInfoByUserAndTaskType(String username, String roleType, boolean isLeanTask) throws WSHTException {
		if(isLeanTask) {
			if("potentialOwner".equals(roleType)) {
				return taskInfoRepository.getLeanTaskTaskInfosByUsernameIsPotentialOwner(username);
			}
			if("businessAdministrator".equals(roleType)) {
				return taskInfoRepository.getLeanTaskTaskInfosByUsernameIsBusinessAdministrator(username);
			}
			throw new WSHTException("error - role " + roleType + " is not supported");
		} else {
			throw new WSHTException("error - standard Task is not supported");
		}
	}

}
