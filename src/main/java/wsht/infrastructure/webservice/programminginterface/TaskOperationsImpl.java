package wsht.infrastructure.webservice.programminginterface;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.soap.MTOM;

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
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TTaskInstanceData;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TTaskOperations;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TTaskQueryResultSet;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wsht.infrastructure.domain.entity.Attachment;
import wsht.infrastructure.domain.entity.Comment;
import wsht.infrastructure.domain.entity.Fault;
import wsht.infrastructure.domain.entity.OrganizationalEntity;
import wsht.infrastructure.domain.entity.TaskInfo;
import wsht.infrastructure.domain.entity.UserSession;
import wsht.infrastructure.service.IRepositoryService;
import wsht.marshalling.IBeanMapper;
import wsht.marshalling.exception.WSHTException;
import wsht.runtime.db4o.IDB4oInterface;
import wsht.runtime.enums.OperationsEnum;
import wsht.runtime.enums.TaskStatesEnum;
import wsht.runtime.utils.OperationsAuthorization;

@WebService(endpointInterface="org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.TaskOperations")
@Addressing
@MTOM(enabled=true)
public class TaskOperationsImpl implements TaskOperations {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskOperationsImpl.class);
	
	private UserSession userSession;
	
	@Resource
	private IRepositoryService repositoryService;
	
	@Resource
	private IDB4oInterface db4oInterface;
	
	@Resource
	private IBeanMapper beanMapper;
	

	@Override
	public String addAttachment(String taskIdentifier, String name,
			String accessType, String contentType, Object attachment)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		
		//(any state) -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(taskIdentifier);
		
		
		
		
		return null;
	}

	//TODO
	@Override
	public String addComment(String identifier, String text)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		
		//(any state) -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		Comment comment = new Comment();
		comment.setAddedBy(userSession.getName());
		comment.setAddedTime(new Date());
		comment.setLastModifiedBy(comment.getAddedBy());
		comment.setLastModifiedTime(comment.getAddedTime());
		comment.setText(text);
		
		comment = repositoryService.createComment(comment);
		taskInfo.getComments().getComment().add(comment);
		repositoryService.updateTaskInfo(taskInfo);
		
		return comment.getId().toString();
	}

	public void claim(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		//Ready -> Reserved
	
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		if(!OperationsAuthorization.checkPreStatePermission(OperationsEnum.claim, taskInfo)) {
			throw new IllegalStateFault("state not in: ready", new IllegalState());
		}
		taskInfo.setState(TaskStatesEnum.RESERVED);
		repositoryService.updateTaskInfo(taskInfo);
	}


	//FIXME: process taskData
	@Override
	public void complete(String identifier, Object taskData)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		//InProgress -> Completed
	
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		if(!OperationsAuthorization.checkPreStatePermission(OperationsEnum.complete, taskInfo)) {
			throw new IllegalStateFault("state not in: inprogress", new IllegalState());
		}
		
		taskInfo.setState(TaskStatesEnum.COMPLETED);
		repositoryService.updateTaskInfo(taskInfo);
		
	}


	@Override
	public void delegate(String identifier,
			TOrganizationalEntity organizationalEntity)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault, RecipientNotAllowed {

		//Ready,Reserved,InProgress -> Reserved
	
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		if(!OperationsAuthorization.checkPreStatePermission(OperationsEnum.delegate, taskInfo)) {
			throw new IllegalStateFault("state not in: ready, reserved, inprogress", new IllegalState());
		}
		
		OrganizationalEntity owner = null;
		if(taskInfo.getOwner() == null) {
			owner = new OrganizationalEntity();
		} else {
			owner = taskInfo.getOwner();
		}
		String userOrGroup = organizationalEntity.getUserOrGroup().get(0).getValue();
		
		if(organizationalEntity.getUserOrGroup().get(0).getName() == new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803", "user")) {
			owner.setUserOrg(new HashSet<String>());
			owner.getUserOrg().add(userOrGroup);
		} else {
			owner.setGroupOrg(new HashSet<String>());
		}
		
		taskInfo.setOwner(owner);
		taskInfo.setState(TaskStatesEnum.RESERVED);
		repositoryService.updateTaskInfo(taskInfo);
		
	}


	@Override
	public void deleteAttachment(String taskIdentifier,
			String attachmentIdentifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {
		
		//(any state) -> (no state transition)

		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(taskIdentifier);
		
		Attachment attachment = taskInfo.getAttachments().returnAttachemntById(attachmentIdentifier);
		if(attachment != null) {
			repositoryService.deleteAttachment(attachment);
			taskInfo.getAttachments().getAttachment().remove(attachment);
			repositoryService.updateTaskInfo(taskInfo);
		}
		
	}

	@Override
	public void deleteComment(String taskIdentifier, String commentIdentifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		//(any state) -> (no state transition)
	
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(taskIdentifier);
		
		Comment comment = taskInfo.getComments().returnCommentById(commentIdentifier);
		if(comment != null) {
			repositoryService.deleteComment(comment);
			taskInfo.getComments().getComment().remove(comment);
			repositoryService.updateTaskInfo(taskInfo);
		}
	}

	@Override
	public void deleteFault(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		//InProgress -> (no state transition)
	
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		if(!OperationsAuthorization.checkPreStatePermission(OperationsEnum.deleteFault, taskInfo)) {
			throw new IllegalStateFault("state not in: inprogress", new IllegalState());
		}
		
		try {
			repositoryService.deleteFault(taskInfo.getFault().getId());
		} catch (WSHTException e) {
			throw new IllegalArgumentFault("delete error", "fault not found");
		}
	}

	//TODO:
	@Override
	public void deleteOutput(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		//InProgress -> (no state transition)

		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		if(!OperationsAuthorization.checkPreStatePermission(OperationsEnum.deleteOutput, taskInfo)) {
			throw new IllegalStateFault("state not in: inprogress", new IllegalState());
		}
	}

	public void fail(String identifier, TFault fault)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		//InProgress -> Failed
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		if(!OperationsAuthorization.checkPreStatePermission(OperationsEnum.fail, taskInfo)) {
			throw new IllegalStateFault("state not in: inprogress", new IllegalState());
		}
		
		taskInfo.setState(TaskStatesEnum.FAILED);
		
		Fault f = new Fault();
		f.setFaultData(fault.getFaultData().toString());
		f.setFaultName(fault.getFaultName());
		f = repositoryService.createFault(f);
		taskInfo.setFault(f);
		
		repositoryService.updateTaskInfo(taskInfo);
	
	}


	@Override
	public void forward(String identifier,
			TOrganizationalEntity organizationalEntity)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		//Ready,Reserved,InProgress -> Ready
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		if(!OperationsAuthorization.checkPreStatePermission(OperationsEnum.forward, taskInfo)) {
			throw new IllegalStateFault("state not in: ready, reserved, inprogress", new IllegalState());
		}
	
		OrganizationalEntity owner = null;
		if(taskInfo.getOwner() == null) {
			owner = new OrganizationalEntity();
		} else {
			owner = taskInfo.getOwner();
		}
		String userOrGroup = organizationalEntity.getUserOrGroup().get(0).getValue();
		
		if(organizationalEntity.getUserOrGroup().get(0).getName() == new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803", "user")) {
			owner.setUserOrg(new HashSet<String>());
			owner.getUserOrg().add(userOrGroup);
		} else {
			owner.setGroupOrg(new HashSet<String>());
		}
		
		taskInfo.setState(TaskStatesEnum.READY);
		repositoryService.updateTaskInfo(taskInfo);

	}


	@Override
	public List<TAttachment> getAttachment(String taskIdentifier,
			String attachmentIdentifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		//(any state) -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(taskIdentifier);
		
		return null;
	}

	@Override
	public List<TAttachmentInfo> getAttachmentInfos(String identifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		//(any state) -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		return null;
	}

	//TODO:
	public List<TComment> getComments(String identifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		//(any state) -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		return null;
	}

	@Override
	public TFault getFault(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		//(any state) -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		Fault f = taskInfo.getFault();
		
		TFault fault = beanMapper.map(f, TFault.class);
		return fault;
	}

	//TODO:
	@Override
	public Object getInput(String identifier, String part)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		//(any state) -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		//db4oInterface
		
		return null;
	}

	//TODO: get outcome (query)
	@Override
	public String getOutcome(String identifier) throws IllegalArgumentFault,
			IllegalOperationFault {

		//(any state) -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		return null;
	}

	//TODO: get output (WS ???)
	@Override
	public Object getOutput(String identifier, String part)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		//(any state) -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		return null;
	}

	@Override
	public TTaskDetails getParentTask(String taskIdentifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		//(any state) -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(taskIdentifier);
		
		return null;
	}

	@Override
	public String getParentTaskIdentifier(String taskIdentifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		//(any state) -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(taskIdentifier);
		if(taskInfo.getSubtask()) {
			return taskInfo.getTaskParent().getTaskIdentifier();
		}
		return null;
	}

	@Override
	public Object getRendering(String identifier, QName renderingType)
			throws IllegalArgumentFault {

		//(any state) -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		return null;
	}

	@Override
	public List<QName> getRenderingTypes(String identifier)
			throws IllegalArgumentFault {

		//(any state) -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		return null;
	}

	@Override
	public List<String> getSubtaskIdentifiers(String taskIdentifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		//(any state) -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(taskIdentifier);
		
		return null;
	}

	@Override
	public List<TTaskDetails> getSubtasks(String taskIdentifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		//(any state) -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(taskIdentifier);
		
		return null;
	}

	@Override
	public String getTaskDescription(String identifier, String contentType)
			throws IllegalArgumentFault {

		//(any state) -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		return null;
	}

	@Override
	public TTaskDetails getTaskDetails(String identifier)
			throws IllegalArgumentFault {

		//(any state) -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		return null;
	}

	@Override
	public GetTaskHistoryResponse getTaskHistory(GetTaskHistory getTaskHistory)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault {

		//(any state) -> (no state transition)
		
		return null;
	}

	@Override
	public TTaskInstanceData getTaskInstanceData(String identifier,
			String properties, List<TRenderingTypes> renderingPreferences)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault {

		//(any state) -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		return null;
	}

	@Override
	public TTaskOperations getTaskOperations(String identifier)
			throws IllegalArgumentFault, IllegalOperationFault {

		//(any state) -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		return null;
	}

	@Override
	public boolean hasSubtasks(String taskIdentifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		//(any state) -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(taskIdentifier);
		
		return false;
	}

	@Override
	public String instantiateSubtask(String taskIdentifier, String name)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		//Reserved,In Progress -> (no state transition)
		
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(taskIdentifier);
		
		if(!OperationsAuthorization.checkPreStatePermission(OperationsEnum.instantiateSubTask, taskInfo)) {
			throw new IllegalStateFault("state not in: reserved, inprogress", new IllegalState());
		}
		
		return null;
	}

	@Override
	public boolean isSubtask(String taskIdentifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		//(any state) -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(taskIdentifier);
		return taskInfo.getSubtask();
	}

	@Override
	public void release(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		//InProgress,Reserved -> Ready
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		if(!OperationsAuthorization.checkPreStatePermission(OperationsEnum.instantiateSubTask, taskInfo)) {
			throw new IllegalStateFault("state not in: reserved, inprogress", new IllegalState());
		}
		
		taskInfo.setState(TaskStatesEnum.READY);
		repositoryService.updateTaskInfo(taskInfo);
		
	}


	@Override
	public void remove(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault {

		//Ready (Notification state) -> Removed (Notification state)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		if(!OperationsAuthorization.checkPreStatePermission(OperationsEnum.remove, taskInfo)) {
			throw new IllegalArgumentFault("state not in: notification_ready", "");
		}

		taskInfo.setState(TaskStatesEnum.NOTIFICATION_REMOVED);	
		repositoryService.updateTaskInfo(taskInfo);
		
	}


	@Override
	public void resume(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		//Suspended/Ready,Suspended/Reserved,Suspended/InProgress
		// ->	
		//Ready (from Suspended/Ready),Reserved (from Suspended/Reserved),InProgress (from Suspended/InProgress)

		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		if(!OperationsAuthorization.checkPreStatePermission(OperationsEnum.remove, taskInfo)) {
			throw new IllegalStateFault("state not in: suspended_ready, suspended_reserved, suspended_inprogress", new IllegalState());
		}
		
		TaskStatesEnum state = taskInfo.getState();
		
		if(state.isSuspendedReady()) {
			state = TaskStatesEnum.READY;
		} else if(state.isSuspendedReserved()) {
			state = TaskStatesEnum.RESERVED;
		} else if(state.isSuspendedInProgress()) {
			state = TaskStatesEnum.IN_PROGRESS;
		}
		
		taskInfo.setState(state);
		repositoryService.updateTaskInfo(taskInfo);
	}


	@Override
	public void setFault(String identifier, TFault fault)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		//InProgress -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		if(!OperationsAuthorization.checkPreStatePermission(OperationsEnum.setFault, taskInfo)) {
			throw new IllegalStateFault("state not in: inprogress", new IllegalState());
		}
		
		Fault f = beanMapper.map(fault, Fault.class);
		f = repositoryService.createFault(f);
		taskInfo.setFault(f);
		repositoryService.updateTaskInfo(taskInfo);
		
	}

	@Override
	public void setOutput(String identifier, String part, Object taskData)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		//InProgress -> (no state transition)
		TaskStatesEnum preState = TaskStatesEnum.IN_PROGRESS;
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		if(!OperationsAuthorization.checkPreStatePermission(OperationsEnum.setFault, taskInfo)) {
			throw new IllegalStateFault("state not in: inprogress", new IllegalState());
		}
	}

	@Override
	public void setPriority(String identifier, int priority)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		//(any state) -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
	}


	@Override
	public void setTaskCompletionDeadlineExpression(String identifier,
			String deadlineName, String deadlineExpression)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		//Created,Ready,Reserved,In Progress -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		if(!OperationsAuthorization.checkPreStatePermission(OperationsEnum.setTaskCompletionDeadlineExpression, taskInfo)) {
			throw new IllegalStateFault("state not in: created, ready, reserved, inprogress", new IllegalState());
		}
	}

	@Override
	public void setTaskCompletionDurationExpression(String identifier,
			String deadlineName, String durationExpression)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		//Created,Ready,Reserved,In Progress -> (no state transition)
	
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		if(!OperationsAuthorization.checkPreStatePermission(OperationsEnum.setTaskCompletionDurationExpression, taskInfo)) {
			throw new IllegalStateFault("state not in: created, ready, reserved, inprogress", new IllegalState());
		}
		
	}

	@Override
	public void setTaskStartDeadlineExpression(String identifier,
			String deadlineName, String deadlineExpression)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		//Created,Ready,Reserved,In Progress -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		if(!OperationsAuthorization.checkPreStatePermission(OperationsEnum.setTaskStartDeadlineExpression, taskInfo)) {
			throw new IllegalStateFault("state not in: created, ready, reserved, inprogress", new IllegalState());
		}
	}

	@Override
	public void setTaskStartDurationExpression(String identifier,
			String deadlineName, String durationExpression)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		//Created,Ready,Reserved,In Progress -> (no state transition)
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		if(!OperationsAuthorization.checkPreStatePermission(OperationsEnum.setTaskStartDurationExpression, taskInfo)) {
			throw new IllegalStateFault("state not in: created, ready, reserved, inprogress", new IllegalState());
		}
	}

	@Override
	public void skip(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		//Created,Ready,Reserved,In Progress -> Obsolete
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		if(!OperationsAuthorization.checkPreStatePermission(OperationsEnum.skip, taskInfo)) {
			throw new IllegalStateFault("state not in: created, ready, reserved, inprogress", new IllegalState());
		}
		
		taskInfo.setState(TaskStatesEnum.OBSOLETE);
		repositoryService.updateTaskInfo(taskInfo);
		
	}


	@Override
	public void start(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		//Ready,Reserved -> InProgress
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		if(!OperationsAuthorization.checkPreStatePermission(OperationsEnum.start, taskInfo)) {
			throw new IllegalStateFault("state not in: created, ready, reserved", new IllegalState());
		}
		
		
		taskInfo.setState(TaskStatesEnum.IN_PROGRESS);
		repositoryService.updateTaskInfo(taskInfo);
	
	}


	@Override
	public void stop(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		//InProgress -> Reserved
		
		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		if(!OperationsAuthorization.checkPreStatePermission(OperationsEnum.stop, taskInfo)) {
			throw new IllegalStateFault("state not in: in progress", new IllegalState());
		}
		
		taskInfo.setState(TaskStatesEnum.RESERVED);
		repositoryService.updateTaskInfo(taskInfo);
		
	}


	@Override
	public void suspend(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		
		//Ready,Reserved,InProgress
		// ->	
		//Suspended/Ready (from Ready),Suspended/Reserved (from Reserved),Suspended/InProgress (from InProgress)

		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		if(!OperationsAuthorization.checkPreStatePermission(OperationsEnum.suspend, taskInfo)) {
			throw new IllegalStateFault("state not in: ready, reserved, in progress", new IllegalState());
		}
		TaskStatesEnum state = taskInfo.getState();
		
		if(state.isReady()) {
			taskInfo.setState(TaskStatesEnum.SUSPENDED_READY);
		} else if(state.isReserved()) {
			taskInfo.setState(TaskStatesEnum.SUSPENDED_RESERVED);
		} else if(state.isInProgress()) {
			taskInfo.setState(TaskStatesEnum.SUSPENDED_IN_PROGRES);
		}
		
		repositoryService.updateTaskInfo(taskInfo);
	}


	@Override
	public void suspendUntil(String identifier, TTime time)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {


		//Ready,Reserved,InProgress
		// ->	
		//Suspended/Ready (from Ready),Suspended/Reserved (from Reserved),Suspended/InProgress (from InProgress)

		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
		
		if(!OperationsAuthorization.checkPreStatePermission(OperationsEnum.suspendUntil, taskInfo)) {
			throw new IllegalStateFault("state not in: ready, reserved, in progress", new IllegalState());
		}
		
		if(taskInfo.getState().isReady()) {
			
		} else if(taskInfo.getState().isReserved()) {
			
		} else if(taskInfo.getState().isInProgress()) {
			
		}
	}


	@Override
	public void updateComment(String taskIdentifier, String commentIdentifier,
			String text) throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		//(any state) -> (no state transition)

		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(taskIdentifier);
	}

	public List<TTaskAbstract> getMyTaskAbstracts(String taskType,
			String genericHumanRole, String workQueue, List<String> status,
			String whereClause, String orderByClause, String createdOnClause,
			Integer maxTasks, Integer taskIndexOffset)
			throws IllegalArgumentFault, IllegalOperationFault,
			IllegalStateFault {

		return null;
	}

	@Override
	public List<TTaskDetails> getMyTaskDetails(String taskType,
			String genericHumanRole, String workQueue, List<String> status,
			String whereClause, String orderByClause, String createdOnClause,
			Integer maxTasks, Integer taskIndexOffset)
			throws IllegalArgumentFault, IllegalOperationFault,
			IllegalStateFault {

		return null;
	}

	@Override
	public TTaskQueryResultSet query(String selectClause, String whereClause,
			String orderByClause, Integer maxTasks, Integer taskIndexOffset)
			throws IllegalArgumentFault, IllegalStateFault {

		return null;
	}

	@Override
	public void activate(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {

		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);


	}


	@Override
	public void nominate(String identifier,
			TOrganizationalEntity organizationalEntity)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);

	}


	@Override
	public void setGenericHumanRole(String identifier, String genericHumanRole,
			TOrganizationalEntity organizationalEntity)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {

		TaskInfo taskInfo = repositoryService.getTaskInfoByTaskIdentifier(identifier);
	}

	
	
	@Override
	public List<TBatchResponse> batchSetGenericHumanRole(
			List<String> identifier, String genericHumanRole,
			TOrganizationalEntity organizationalEntity) {

		return null;
	}

	
	@Override
	public List<TBatchResponse> batchClaim(List<String> identifier) {
			return null;
	}

	@Override
	public List<TBatchResponse> batchNominate(List<String> identifier) {

		return null;
	}

	@Override
	public List<TBatchResponse> batchActivate(List<String> identifier) {

		return null;
	}


	@Override
	public List<TBatchResponse> batchSuspendUntil(List<String> identifier,
			TTime time) {

		return null;
	}

	@Override
	public List<TBatchResponse> batchComplete(List<String> identifier,
			Object taskData) {

		return null;
	}

	@Override
	public List<TBatchResponse> batchDelegate(List<String> identifier,
			TOrganizationalEntity organizationalEntity) {

		return null;
	}

	@Override
	public List<TBatchResponse> batchFail(List<String> identifier, TFault fault) {

		return null;
	}


	@Override
	public List<TBatchResponse> batchForward(List<String> identifier,
			TOrganizationalEntity organizationalEntity) {

		return null;
	}

	
	@Override
	public List<TBatchResponse> batchRelease(List<String> identifier) {

		return null;
	}

	@Override
	public List<TBatchResponse> batchRemove(List<String> identifier) {

		return null;
	}


	@Override
	public List<TBatchResponse> batchResume(List<String> identifier) {

		return null;
	}

	@Override
	public List<TBatchResponse> batchSetPriority(List<String> identifier,
			int priority) {

		return null;
	}


	@Override
	public List<TBatchResponse> batchSkip(List<String> identifier) {

		return null;
	}

	@Override
	public List<TBatchResponse> batchStart(List<String> identifier) {

		return null;
	}

	@Override
	public List<TBatchResponse> batchStop(List<String> identifier) {

		return null;
	}

	@Override
	public List<TBatchResponse> batchSuspend(List<String> identifier) {

		return null;
	}
	
	
}
