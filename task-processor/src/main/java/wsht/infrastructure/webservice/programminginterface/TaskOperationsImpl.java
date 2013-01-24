package wsht.infrastructure.webservice.programminginterface;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.soap.MTOM;

import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.GetTaskHistory;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.GetTaskHistoryResponse;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.IllegalAccessFault;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.IllegalArgumentFault;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.IllegalOperationFault;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.IllegalState;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.IllegalStateFault;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.RecipientNotAllowed;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.TBatchResponse;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.TaskOperations;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TAttachment;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TAttachmentInfo;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TComment;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TFault;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TOrganizationalEntity;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TRenderingTypes;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TTaskAbstract;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TTaskDetails;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TTaskHistoryFilter;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TTaskInstanceData;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TTaskOperations;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TTaskQueryResultSet;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import wsht.infrastructure.domain.entity.Attachment;
import wsht.infrastructure.domain.entity.Comment;
import wsht.infrastructure.domain.entity.Fault;
import wsht.infrastructure.domain.entity.OrganizationalEntity;
import wsht.infrastructure.domain.entity.TaskInfo;
import wsht.infrastructure.domain.entity.UserEntityInfo;
import wsht.infrastructure.domain.entity.UserSession;
import wsht.infrastructure.service.IRepositoryService;
import wsht.infrastructure.web.SessionInfo;
import wsht.infrastructure.web.TaskSessionInfo;
import wsht.infrastructure.webservice.WSHTService;
import wsht.marshalling.IBeanMapper;
import wsht.exception.WSHTException;
import wsht.runtime.db4o.IDB4oInterface;
import wsht.runtime.enums.OperationsEnum;
import wsht.runtime.enums.TaskStatesEnum;
import wsht.runtime.listeners.ITaskListener;
import wsht.runtime.model.TaskModel;
import wsht.runtime.utils.OperationsAuthorization;
import wsht.runtime.utils.TaskMethodsUtils;

@WebService(endpointInterface = "org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.TaskOperations")
@InInterceptors(interceptors = "org.apache.cxf.interceptor.LoggingInInterceptor")
@OutInterceptors(interceptors = "org.apache.cxf.interceptor.LoggingOutInterceptor")
@Addressing(enabled = true, required = true)
@MTOM(enabled = true)
public class TaskOperationsImpl extends WSHTService implements TaskOperations {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TaskOperationsImpl.class);

	@Resource
	private IRepositoryService repositoryService;

	@Resource
	private IDB4oInterface db4oInterface;

	@Resource
	private IBeanMapper beanMapper;

	@Resource
	private ITaskListener taskModel;

	public List<TTaskAbstract> getMyTaskAbstracts(String taskType,
			String genericHumanRole, String workQueue, List<String> status,
			String whereClause, String orderByClause, String createdOnClause,
			Integer maxTasks, Integer taskIndexOffset)
			throws IllegalArgumentFault, IllegalOperationFault,
			IllegalStateFault {

		if ("Task".equals(taskType)) {
			throw new IllegalArgumentFault(
					"error - standard tasks not supported", "try later");
		}
		if (!"potentialOwner".equals(genericHumanRole)
				&& !"businessAdministrator".equals(genericHumanRole)) {
			throw new IllegalArgumentFault("error - role " + genericHumanRole
					+ " not supported", "try later");
		}

		List<TTaskAbstract> abstracts = new LinkedList<TTaskAbstract>();

		if ("LeanTask".equals(taskType)) {
			try {
				// problem pobierania informacji o uzytkowniku z sesji
				List<TaskInfo> taskInfos = repositoryService
						.getTaskInfoByUserAndTaskType("krussa",
								genericHumanRole, true);
				for (TaskInfo taskInfo : taskInfos) {
					TTaskAbstract abstractTask = new TTaskAbstract();
					abstractTask.setId(taskInfo.getTaskIdentifier());
					abstractTask.setTaskType(taskType);
					abstractTask.setName(new QName("http://wsht", "leanTask"));
					abstractTask.setStatus(taskInfo.getState().name());
					abstractTask.setPriority(taskInfo.getPriority());
					abstractTask.setCreatedTime(TaskMethodsUtils
							.createXMlGregorianCalendar(taskInfo.getCreated()));
					abstractTask
							.setActivationTime(TaskMethodsUtils
									.createXMlGregorianCalendar(taskInfo
											.getActivated()));
					// abstractTask.setIsSkipable(taskInfo.getTask().getSkippable());
					// protected String presentationName;
					// protected String presentationSubject;

					abstractTask.setEscalated(taskInfo.getEscalated());
					abstracts.add(abstractTask);
				}
			} catch (WSHTException e) {
				throw new IllegalOperationFault("error - operation errored",
						e.getMessage());
			}
		}
		return abstracts;
	}

	public void claim(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		// Ready -> Reserved
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			if (!OperationsAuthorization.checkPreStatePermission(
					OperationsEnum.claim, taskInfo)) {
				throw new IllegalStateFault("state not in: ready",
						new IllegalState());
			}
			taskInfo.setState(TaskStatesEnum.RESERVED);
			repositoryService.updateTaskInfo(taskInfo);
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}
	}

	public void start(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		// Ready,Reserved -> InProgress

		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			if (!OperationsAuthorization.checkPreStatePermission(
					OperationsEnum.start, taskInfo)) {
				throw new IllegalStateFault(
						"state not in: created, ready, reserved",
						new IllegalState());
			}

			taskInfo.setState(TaskStatesEnum.IN_PROGRESS);
			repositoryService.updateTaskInfo(taskInfo);
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}
	}

	// FIXME: process taskData

	public void complete(String identifier, Object taskData)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// InProgress -> Completed
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			if (!OperationsAuthorization.checkPreStatePermission(
					OperationsEnum.complete, taskInfo)) {
				throw new IllegalStateFault("state not in: inprogress",
						new IllegalState());
			}

			taskInfo.setState(TaskStatesEnum.COMPLETED);
			repositoryService.updateTaskInfo(taskInfo);
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}
	}

	public void delegate(String identifier,
			TOrganizationalEntity organizationalEntity)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault, RecipientNotAllowed {

		// Ready,Reserved,InProgress -> Reserved
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			if (!OperationsAuthorization.checkPreStatePermission(
					OperationsEnum.delegate, taskInfo)) {
				throw new IllegalStateFault(
						"state not in: ready, reserved, inprogress",
						new IllegalState());
			}

			UserEntityInfo owner = null;
			if (taskInfo.getOwner() == null) {
				owner = new UserEntityInfo();
			} else {
				owner = taskInfo.getOwner();
			}
			String userOrGroup = organizationalEntity.getUserOrGroup().get(0)
					.getValue();

			if (organizationalEntity
					.getUserOrGroup()
					.get(0)
					.getName()
					.equals("{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803}user")) {

			} else {
				// owner.setGroupOrg(new HashSet<String>());
			}

			// repositoryService.getUserEntityInfoByUserNames(userNames);

			taskInfo.setOwner(owner);
			taskInfo.setState(TaskStatesEnum.RESERVED);
			repositoryService.updateTaskInfo(taskInfo);
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}

	}

	public void fail(String identifier, TFault fault)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// InProgress -> Failed
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			if (!OperationsAuthorization.checkPreStatePermission(
					OperationsEnum.fail, taskInfo)) {
				throw new IllegalStateFault("state not in: inprogress",
						new IllegalState());
			}

			taskInfo.setState(TaskStatesEnum.FAILED);

			Fault f = new Fault();
			f.setFaultData(fault.getFaultData().toString());
			f.setFaultName(fault.getFaultName());
			f = repositoryService.createFault(f);
			taskInfo.setFault(f);

			repositoryService.updateTaskInfo(taskInfo);
		} catch (WSHTException e) {
			throw new IllegalArgumentFault("", "");
		}
	}

	public void forward(String identifier,
			TOrganizationalEntity organizationalEntity)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// Ready,Reserved,InProgress -> Ready
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			if (!OperationsAuthorization.checkPreStatePermission(
					OperationsEnum.forward, taskInfo)) {
				throw new IllegalStateFault(
						"state not in: ready, reserved, inprogress",
						new IllegalState());
			}

			OrganizationalEntity owner = null;
			if (taskInfo.getOwner() == null) {
				owner = new OrganizationalEntity();
			} else {
				// owner = taskInfo.getOwner();
			}
			String userOrGroup = organizationalEntity.getUserOrGroup().get(0)
					.getValue();

			if (organizationalEntity.getUserOrGroup().get(0).getName() == new QName(
					"http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803",
					"user")) {
				owner.setUserOrg(new HashSet<String>());
				owner.getUserOrg().add(userOrGroup);
			} else {
				owner.setGroupOrg(new HashSet<String>());
			}

			taskInfo.setState(TaskStatesEnum.READY);
			repositoryService.updateTaskInfo(taskInfo);
		} catch (WSHTException e) {
			throw new IllegalArgumentFault("", "");
		}
	}

	public void activate(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {
		// TaskInfo taskInfo =
		// repositoryService.getTaskInfoByTaskIdentifier(identifier);
		LOGGER.debug("XXX activate XXX");

	}

	public void nominate(String identifier,
			TOrganizationalEntity organizationalEntity)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}
	}

	public void setGenericHumanRole(String identifier, String genericHumanRole,
			TOrganizationalEntity organizationalEntity)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}
	}

	public boolean isSubtask(String taskIdentifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		// (any state) -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(taskIdentifier);
			return taskInfo.getIsSubtask();
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}
	}

	public void release(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		// InProgress,Reserved -> Ready
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			if (!OperationsAuthorization.checkPreStatePermission(
					OperationsEnum.instantiateSubTask, taskInfo)) {
				throw new IllegalStateFault(
						"state not in: reserved, inprogress",
						new IllegalState());
			}

			taskInfo.setState(TaskStatesEnum.READY);
			repositoryService.updateTaskInfo(taskInfo);
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}
	}

	public void remove(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault {

		// Ready (Notification state) -> Removed (Notification state)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			if (!OperationsAuthorization.checkPreStatePermission(
					OperationsEnum.remove, taskInfo)) {
				throw new IllegalArgumentFault(
						"state not in: notification_ready", "");
			}

			taskInfo.setState(TaskStatesEnum.NOTIFICATION_REMOVED);
			repositoryService.updateTaskInfo(taskInfo);
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}
	}

	public void resume(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		// Suspended/Ready,Suspended/Reserved,Suspended/InProgress
		// ->
		// Ready (from Suspended/Ready),Reserved (from
		// Suspended/Reserved),InProgress (from Suspended/InProgress)

		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			if (!OperationsAuthorization.checkPreStatePermission(
					OperationsEnum.remove, taskInfo)) {
				throw new IllegalStateFault(
						"state not in: suspended_ready, suspended_reserved, suspended_inprogress",
						new IllegalState());
			}

			TaskStatesEnum state = taskInfo.getState();

			if (state.isSuspendedReady()) {
				state = TaskStatesEnum.READY;
			} else if (state.isSuspendedReserved()) {
				state = TaskStatesEnum.RESERVED;
			} else if (state.isSuspendedInProgress()) {
				state = TaskStatesEnum.IN_PROGRESS;
			}

			taskInfo.setState(state);
			repositoryService.updateTaskInfo(taskInfo);
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}
	}

	public void setFault(String identifier, TFault fault)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// InProgress -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			if (!OperationsAuthorization.checkPreStatePermission(
					OperationsEnum.setFault, taskInfo)) {
				throw new IllegalStateFault("state not in: inprogress",
						new IllegalState());
			}

			Fault f = beanMapper.map(fault, Fault.class);
			f = repositoryService.createFault(f);
			taskInfo.setFault(f);
			repositoryService.updateTaskInfo(taskInfo);
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}
	}

	public void setOutput(String identifier, String part, Object taskData)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// InProgress -> (no state transition)
		try {
			TaskStatesEnum preState = TaskStatesEnum.IN_PROGRESS;

			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			if (!OperationsAuthorization.checkPreStatePermission(
					OperationsEnum.setFault, taskInfo)) {
				throw new IllegalStateFault("state not in: inprogress",
						new IllegalState());
			}
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}
	}

	public void setPriority(String identifier, int priority)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// (any state) -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}
	}

	public void setTaskCompletionDeadlineExpression(String identifier,
			String deadlineName, String deadlineExpression)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// Created,Ready,Reserved,In Progress -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			if (!OperationsAuthorization.checkPreStatePermission(
					OperationsEnum.setTaskCompletionDeadlineExpression,
					taskInfo)) {
				throw new IllegalStateFault(
						"state not in: created, ready, reserved, inprogress",
						new IllegalState());
			}
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}
	}

	public void setTaskCompletionDurationExpression(String identifier,
			String deadlineName, String durationExpression)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// Created,Ready,Reserved,In Progress -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			if (!OperationsAuthorization.checkPreStatePermission(
					OperationsEnum.setTaskCompletionDurationExpression,
					taskInfo)) {
				throw new IllegalStateFault(
						"state not in: created, ready, reserved, inprogress",
						new IllegalState());
			}
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}

	}

	public void setTaskStartDeadlineExpression(String identifier,
			String deadlineName, String deadlineExpression)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// Created,Ready,Reserved,In Progress -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			if (!OperationsAuthorization.checkPreStatePermission(
					OperationsEnum.setTaskStartDeadlineExpression, taskInfo)) {
				throw new IllegalStateFault(
						"state not in: created, ready, reserved, inprogress",
						new IllegalState());
			}
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}
	}

	public void setTaskStartDurationExpression(String identifier,
			String deadlineName, String durationExpression)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// Created,Ready,Reserved,In Progress -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			if (!OperationsAuthorization.checkPreStatePermission(
					OperationsEnum.setTaskStartDurationExpression, taskInfo)) {
				throw new IllegalStateFault(
						"state not in: created, ready, reserved, inprogress",
						new IllegalState());
			}
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}
	}

	public void skip(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		// Created,Ready,Reserved,In Progress -> Obsolete

		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			if (!OperationsAuthorization.checkPreStatePermission(
					OperationsEnum.skip, taskInfo)) {
				throw new IllegalStateFault(
						"state not in: created, ready, reserved, inprogress",
						new IllegalState());
			}

			taskInfo.setState(TaskStatesEnum.OBSOLETE);
			repositoryService.updateTaskInfo(taskInfo);
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}
	}

	public void stop(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		// InProgress -> Reserved
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			if (!OperationsAuthorization.checkPreStatePermission(
					OperationsEnum.stop, taskInfo)) {
				throw new IllegalStateFault("state not in: in progress",
						new IllegalState());
			}

			taskInfo.setState(TaskStatesEnum.RESERVED);
			repositoryService.updateTaskInfo(taskInfo);
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}
	}

	public void suspend(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		// Ready,Reserved,InProgress
		// ->
		// Suspended/Ready (from Ready),Suspended/Reserved (from
		// Reserved),Suspended/InProgress (from InProgress)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			if (!OperationsAuthorization.checkPreStatePermission(
					OperationsEnum.suspend, taskInfo)) {
				throw new IllegalStateFault(
						"state not in: ready, reserved, in progress",
						new IllegalState());
			}
			TaskStatesEnum state = taskInfo.getState();

			if (state.isReady()) {
				taskInfo.setState(TaskStatesEnum.SUSPENDED_READY);
			} else if (state.isReserved()) {
				taskInfo.setState(TaskStatesEnum.SUSPENDED_RESERVED);
			} else if (state.isInProgress()) {
				taskInfo.setState(TaskStatesEnum.SUSPENDED_IN_PROGRES);
			}

			repositoryService.updateTaskInfo(taskInfo);
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}
	}

	public void suspendUntil(String identifier, TTime time)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// Ready,Reserved,InProgress
		// ->
		// Suspended/Ready (from Ready),Suspended/Reserved (from
		// Reserved),Suspended/InProgress (from InProgress)

		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			if (!OperationsAuthorization.checkPreStatePermission(
					OperationsEnum.suspendUntil, taskInfo)) {
				throw new IllegalStateFault(
						"state not in: ready, reserved, in progress",
						new IllegalState());
			}

			if (taskInfo.getState().isReady()) {

			} else if (taskInfo.getState().isReserved()) {

			} else if (taskInfo.getState().isInProgress()) {

			}
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}
	}

	public TTaskOperations getTaskOperations(String identifier)
			throws IllegalArgumentFault, IllegalOperationFault {

		// (any state) -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			return null;
		} catch (WSHTException e) {
			throw new IllegalArgumentFault("", "");
		}
	}

	// TODO

	public String addAttachment(String taskIdentifier, String name,
			String accessType, String contentType, Object attachment)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// (any state) -> (no state transition)

		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(taskIdentifier);
		} catch (WSHTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// TODO

	public String addComment(String identifier, String text)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// (any state) -> (no state transition)

		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);
			Comment comment = new Comment();
			comment.setAddedBy(getSessionInfo().getUserSession().getName());
			comment.setAddedTime(new Date());
			comment.setLastModifiedBy(comment.getAddedBy());
			comment.setLastModifiedTime(comment.getAddedTime());
			comment.setText(text);

			comment = repositoryService.createComment(comment);
			taskInfo.getComments().getComment().add(comment);
			repositoryService.updateTaskInfo(taskInfo);

			return comment.getId().toString();
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}

	}

	public void deleteAttachment(String taskIdentifier,
			String attachmentIdentifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		// (any state) -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(taskIdentifier);

			Attachment attachment = taskInfo.getAttachments()
					.returnAttachemntById(attachmentIdentifier);
			if (attachment != null) {
				repositoryService.deleteAttachment(attachment);
				taskInfo.getAttachments().getAttachment().remove(attachment);
				repositoryService.updateTaskInfo(taskInfo);
			}
		} catch (WSHTException e) {
			throw new IllegalArgumentFault("", "");
		}
	}

	public void deleteComment(String taskIdentifier, String commentIdentifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// (any state) -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(taskIdentifier);

			Comment comment = taskInfo.getComments().returnCommentById(
					commentIdentifier);
			if (comment != null) {
				repositoryService.deleteComment(comment);
				taskInfo.getComments().getComment().remove(comment);
				repositoryService.updateTaskInfo(taskInfo);
			}
		} catch (WSHTException e) {
			throw new IllegalArgumentFault("", "");
		}
	}

	public void deleteFault(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		// InProgress -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			if (!OperationsAuthorization.checkPreStatePermission(
					OperationsEnum.deleteFault, taskInfo)) {
				throw new IllegalStateFault("state not in: inprogress",
						new IllegalState());
			}

			try {
				repositoryService.deleteFault(taskInfo.getFault().getId());
			} catch (WSHTException e) {
				throw new IllegalArgumentFault("delete error",
						"fault not found");
			}
		} catch (WSHTException e) {
			throw new IllegalArgumentFault("", "");
		}
	}

	// TODO:

	public void deleteOutput(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		// InProgress -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			if (!OperationsAuthorization.checkPreStatePermission(
					OperationsEnum.deleteOutput, taskInfo)) {
				throw new IllegalStateFault("state not in: inprogress",
						new IllegalState());
			}
		} catch (WSHTException e) {
			throw new IllegalArgumentFault("", "");
		}
	}

	public List<TAttachment> getAttachment(String taskIdentifier,
			String attachmentIdentifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		// (any state) -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(taskIdentifier);

			return null;
		} catch (WSHTException e) {
			throw new IllegalArgumentFault("", "");
		}
	}

	public List<TAttachmentInfo> getAttachmentInfos(String identifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// (any state) -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			return null;
		} catch (WSHTException e) {
			throw new IllegalArgumentFault("", "");
		}
	}

	// TODO:
	public List<TComment> getComments(String identifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// (any state) -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			return null;
		} catch (WSHTException e) {
			throw new IllegalArgumentFault("", "");
		}
	}

	public TFault getFault(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		// (any state) -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);
			Fault f = taskInfo.getFault();

			TFault fault = beanMapper.map(f, TFault.class);
			return fault;
		} catch (WSHTException e) {
			throw new IllegalArgumentFault("", "");
		}
	}

	// TODO:

	public Object getInput(String identifier, String part)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// (any state) -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			// db4oInterface

			return null;
		} catch (WSHTException e) {
			throw new IllegalArgumentFault("", "");
		}
	}

	// TODO: get outcome (query)

	public String getOutcome(String identifier) throws IllegalArgumentFault,
			IllegalOperationFault {

		// (any state) -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			return null;
		} catch (WSHTException e) {
			throw new IllegalArgumentFault("", "");
		}
	}

	// TODO: get output (WS ???)

	public Object getOutput(String identifier, String part)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// (any state) -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			return null;
		} catch (WSHTException e) {
			throw new IllegalArgumentFault("", "");
		}
	}

	public TTaskDetails getParentTask(String taskIdentifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// (any state) -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(taskIdentifier);

			return null;
		} catch (WSHTException e) {
			throw new IllegalArgumentFault("", "");
		}
	}

	public String getParentTaskIdentifier(String taskIdentifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// (any state) -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(taskIdentifier);
			if (taskInfo.getIsSubtask()) {
				return taskInfo.getTaskParent().getTaskIdentifier();
			}
			return null;
		} catch (WSHTException e) {
			throw new IllegalArgumentFault("", "");
		}
	}

	public Object getRendering(String identifier, QName renderingType)
			throws IllegalArgumentFault {

		// (any state) -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			return null;
		} catch (WSHTException e) {
			throw new IllegalArgumentFault("", "");
		}
	}

	public List<QName> getRenderingTypes(String identifier)
			throws IllegalArgumentFault {

		// (any state) -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			return null;
		} catch (WSHTException e) {
			throw new IllegalArgumentFault("", "");
		}
	}

	public List<String> getSubtaskIdentifiers(String taskIdentifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// (any state) -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(taskIdentifier);

			return null;
		} catch (WSHTException e) {
			throw new IllegalArgumentFault("", "");
		}
	}

	public List<TTaskDetails> getSubtasks(String taskIdentifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// (any state) -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(taskIdentifier);

			return null;
		} catch (WSHTException e) {
			throw new IllegalArgumentFault("", "");
		}
	}

	public String getTaskDescription(String identifier, String contentType)
			throws IllegalArgumentFault {

		// (any state) -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			return null;
		} catch (WSHTException e) {
			throw new IllegalArgumentFault("", "");
		}
	}

	public TTaskDetails getTaskDetails(String identifier)
			throws IllegalArgumentFault {

		// (any state) -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			return null;
		} catch (WSHTException e) {
			throw new IllegalArgumentFault("", "");
		}
	}

	public GetTaskHistoryResponse getTaskHistory(GetTaskHistory getTaskHistory)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault {

		// (any state) -> (no state transition)
		String identifier = getTaskHistory.getIdentifier();
		TTaskHistoryFilter filter = getTaskHistory.getFilter();
		Boolean isIncludedData = getTaskHistory.isIncludeData();
		Integer maxTasks = getTaskHistory.getMaxTasks();
		Integer startIndex = getTaskHistory.getStartIndex();

		return null;
	}

	public TTaskInstanceData getTaskInstanceData(String identifier,
			String properties, List<TRenderingTypes> renderingPreferences)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault {

		// (any state) -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(identifier);

			return null;
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}
	}

	public boolean hasSubtasks(String taskIdentifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// (any state) -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(taskIdentifier);

			return false;
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}
	}

	public String instantiateSubtask(String taskIdentifier, String name)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// Reserved,In Progress -> (no state transition)

		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(taskIdentifier);

			if (!OperationsAuthorization.checkPreStatePermission(
					OperationsEnum.instantiateSubTask, taskInfo)) {
				throw new IllegalStateFault(
						"state not in: reserved, inprogress",
						new IllegalState());
			}

			return null;
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}
	}

	public void updateComment(String taskIdentifier, String commentIdentifier,
			String text) throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		// (any state) -> (no state transition)
		try {
			TaskInfo taskInfo = repositoryService
					.getTaskInfoByTaskIdentifier(taskIdentifier);
		} catch (WSHTException e) {
			throw new IllegalAccessFault("", "");
		}
	}

	public List<TTaskDetails> getMyTaskDetails(String taskType,
			String genericHumanRole, String workQueue, List<String> status,
			String whereClause, String orderByClause, String createdOnClause,
			Integer maxTasks, Integer taskIndexOffset)
			throws IllegalArgumentFault, IllegalOperationFault,
			IllegalStateFault {

		return null;
	}

	public TTaskQueryResultSet query(String selectClause, String whereClause,
			String orderByClause, Integer maxTasks, Integer taskIndexOffset)
			throws IllegalArgumentFault, IllegalStateFault {

		return null;
	}

	public List<TBatchResponse> batchSetGenericHumanRole(
			List<String> identifier, String genericHumanRole,
			TOrganizationalEntity organizationalEntity) {

		return null;
	}

	public List<TBatchResponse> batchClaim(List<String> identifier) {
		return null;
	}

	public List<TBatchResponse> batchNominate(List<String> identifier) {

		return null;
	}

	public List<TBatchResponse> batchActivate(List<String> identifier) {

		return null;
	}

	public List<TBatchResponse> batchSuspendUntil(List<String> identifier,
			TTime time) {

		return null;
	}

	public List<TBatchResponse> batchComplete(List<String> identifier,
			Object taskData) {

		return null;
	}

	public List<TBatchResponse> batchDelegate(List<String> identifier,
			TOrganizationalEntity organizationalEntity) {

		return null;
	}

	public List<TBatchResponse> batchFail(List<String> identifier, TFault fault) {

		return null;
	}

	public List<TBatchResponse> batchForward(List<String> identifier,
			TOrganizationalEntity organizationalEntity) {

		return null;
	}

	public List<TBatchResponse> batchRelease(List<String> identifier) {

		return null;
	}

	public List<TBatchResponse> batchRemove(List<String> identifier) {

		return null;
	}

	public List<TBatchResponse> batchResume(List<String> identifier) {

		return null;
	}

	public List<TBatchResponse> batchSetPriority(List<String> identifier,
			int priority) {

		return null;
	}

	public List<TBatchResponse> batchSkip(List<String> identifier) {

		return null;
	}

	public List<TBatchResponse> batchStart(List<String> identifier) {

		return null;
	}

	public List<TBatchResponse> batchStop(List<String> identifier) {

		return null;
	}

	public List<TBatchResponse> batchSuspend(List<String> identifier) {

		return null;
	}

}
