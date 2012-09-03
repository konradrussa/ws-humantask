package wsht.infrastructure.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.db4o.ObjectSet;

import wsht.infrastructure.domain.entity.Attachment;
import wsht.infrastructure.domain.entity.Comment;
import wsht.infrastructure.domain.entity.Fault;
import wsht.infrastructure.domain.entity.HumanInteractions;
import wsht.infrastructure.domain.entity.LeanTask;
import wsht.infrastructure.domain.entity.TaskInfo;
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
import wsht.infrastructure.repository.IHumanInteractionsRepository;
import wsht.infrastructure.repository.ILeanTaskRepository;
import wsht.infrastructure.repository.ILocalNotificationRepository;
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
import wsht.marshalling.exception.WSHTException;

@Service("repositoryService")
public class RepositoryService implements IRepositoryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryService.class);

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
	private ITaskRepository taskRepository;
	@Resource
	private ILeanTaskRepository leanTaskRepository;
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
	private ITaskInfoRepository taskInfoRepository;
	@Resource
	private ITextRepository textRepository;
	@Resource
	private IToPartRepository toPartRepository;
	@Resource
	private IToPartsRepository toPartsRepository;
	@Resource
	private IFaultRepository faultRepository;
	@Resource
	private IHumanInteractionsRepository humanInteractionsRepository;
	@Resource
	private IAttachmentInfoRepository attachmentInfoRepository;
	@Resource
	private IAttachmentRepository attachmentRepository;
	@Resource
	private ICommentRepository commentRepository;
	@Resource
	private ICommentsRepository commentsRepository;
	
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public TaskInfo createTaskInfo(TaskInfo task) {
		LOGGER.debug("task creation");
		TaskBase taskBase = null;
		if(task.getLeanTask()) {
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
		LOGGER.debug("det all tasks");
		List<TaskInfo> tasks = taskInfoRepository.getAll();
		return tasks;
	}

	@Transactional(readOnly=true)
	public TaskInfo getTaskInfoByTaskIdentifier(String taskIdentifier) {
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
			throw new WSHTException("fault not found");
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
		return leanTaskRepository.checkIfLeanTaskWithNameExists(leanTaskName);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public LeanTask createLeanTaskDefinition(LeanTask leanTask) {
		return leanTaskRepository.create(leanTask);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteLeanTask(String taskName) {
		leanTaskRepository.deleteLeanTaskDefinition(taskName);
		leanTaskRepository.errorStateForInstances(taskName);
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

	
	

}
