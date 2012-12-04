package wsht.infrastructure.web.service.endpoint;

import java.util.List;

import javax.xml.namespace.QName;

import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.GetTaskHistory;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.GetTaskHistoryResponse;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.IllegalAccessFault;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.IllegalArgumentFault;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.IllegalOperationFault;
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

import wsht.infrastructure.web.service.TaskOperationsSessionService;

public class TaskOperationsClientEndpoint implements TaskOperations {
	
	private TaskOperationsSessionService service;

	@Override
	public String addAttachment(String taskIdentifier, String name,
			String accessType, String contentType, Object attachment)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		return service.getService().addAttachment(taskIdentifier, name, accessType, contentType, attachment);
	}

	@Override
	public String addComment(String identifier, String text)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		return service.getService().addComment(identifier, text);
	}

	@Override
	public void claim(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {
		service.getService().claim(identifier);
		
	}

	@Override
	public List<TBatchResponse> batchClaim(List<String> identifier) {
		return service.getService().batchClaim(identifier);
	}

	@Override
	public void complete(String identifier, Object taskData)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		service.getService().complete(identifier, taskData);
		
	}

	@Override
	public List<TBatchResponse> batchComplete(List<String> identifier,
			Object taskData) {
		return service.getService().batchComplete(identifier, taskData);
	}

	@Override
	public void delegate(String identifier,
			TOrganizationalEntity organizationalEntity)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault, RecipientNotAllowed {
		service.getService().delegate(identifier, organizationalEntity);
		
	}

	@Override
	public List<TBatchResponse> batchDelegate(List<String> identifier,
			TOrganizationalEntity organizationalEntity) {
		return service.getService().batchDelegate(identifier, organizationalEntity);
	}

	@Override
	public void deleteAttachment(String taskIdentifier,
			String attachmentIdentifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {
		service.getService().deleteAttachment(taskIdentifier, attachmentIdentifier);
		
	}

	@Override
	public void deleteComment(String taskIdentifier, String commentIdentifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		service.getService().deleteComment(taskIdentifier, commentIdentifier);
		
	}

	@Override
	public void deleteFault(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {
		service.getService().deleteFault(identifier);
		
	}

	@Override
	public void deleteOutput(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {
		service.getService().deleteOutput(identifier);
		
	}

	@Override
	public void fail(String identifier, TFault fault)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		service.getService().fail(identifier, fault);
		
	}

	@Override
	public List<TBatchResponse> batchFail(List<String> identifier, TFault fault) {
		return service.getService().batchFail(identifier, fault);
	}

	@Override
	public void forward(String identifier,
			TOrganizationalEntity organizationalEntity)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		service.getService().forward(identifier, organizationalEntity);
		
	}

	@Override
	public List<TBatchResponse> batchForward(List<String> identifier,
			TOrganizationalEntity organizationalEntity) {
		return service.getService().batchForward(identifier, organizationalEntity);
	}

	@Override
	public List<TAttachment> getAttachment(String taskIdentifier,
			String attachmentIdentifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {
		return service.getService().getAttachment(taskIdentifier, attachmentIdentifier);
	}

	@Override
	public List<TAttachmentInfo> getAttachmentInfos(String identifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		return service.getService().getAttachmentInfos(identifier);
	}

	@Override
	public List<TComment> getComments(String identifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		return service.getService().getComments(identifier);
	}

	@Override
	public TFault getFault(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {
		return service.getService().getFault(identifier);
	}

	@Override
	public Object getInput(String identifier, String part)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		return service.getService().getInput(identifier, part);
	}

	@Override
	public String getOutcome(String identifier) throws IllegalArgumentFault,
			IllegalOperationFault {
		return service.getService().getOutcome(identifier);
	}

	@Override
	public Object getOutput(String identifier, String part)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		return service.getService().getOutput(identifier, part);
	}

	@Override
	public TTaskDetails getParentTask(String taskIdentifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		return service.getService().getParentTask(taskIdentifier);
	}

	@Override
	public String getParentTaskIdentifier(String taskIdentifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		return service.getService().getParentTaskIdentifier(taskIdentifier);
	}

	@Override
	public Object getRendering(String identifier, QName renderingType)
			throws IllegalArgumentFault {
		return service.getService().getRendering(identifier, renderingType);
	}

	@Override
	public List<QName> getRenderingTypes(String identifier)
			throws IllegalArgumentFault {
		return service.getService().getRenderingTypes(identifier);
	}

	@Override
	public List<String> getSubtaskIdentifiers(String taskIdentifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		return service.getService().getSubtaskIdentifiers(taskIdentifier);
	}

	@Override
	public List<TTaskDetails> getSubtasks(String taskIdentifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		return service.getService().getSubtasks(taskIdentifier);
	}

	@Override
	public String getTaskDescription(String identifier, String contentType)
			throws IllegalArgumentFault {
		return service.getService().getTaskDescription(identifier, contentType);
	}

	@Override
	public TTaskDetails getTaskDetails(String identifier)
			throws IllegalArgumentFault {
		return service.getService().getTaskDetails(identifier);
	}

	@Override
	public GetTaskHistoryResponse getTaskHistory(GetTaskHistory getTaskHistory)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault {
		return service.getService().getTaskHistory(getTaskHistory);
	}

	@Override
	public TTaskInstanceData getTaskInstanceData(String identifier,
			String properties, List<TRenderingTypes> renderingPreferences)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault {
		return service.getService().getTaskInstanceData(identifier, properties, renderingPreferences);
	}

	@Override
	public TTaskOperations getTaskOperations(String identifier)
			throws IllegalArgumentFault, IllegalOperationFault {
		return service.getService().getTaskOperations(identifier);
	}

	@Override
	public boolean hasSubtasks(String taskIdentifier)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		return service.getService().hasSubtasks(taskIdentifier);
	}

	@Override
	public String instantiateSubtask(String taskIdentifier, String name)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		return service.getService().instantiateSubtask(taskIdentifier, name);
	}

	@Override
	public boolean isSubtask(String taskIdentifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {
		return service.getService().isSubtask(taskIdentifier);
	}

	@Override
	public void release(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {
		service.getService().release(identifier);
		
	}

	@Override
	public List<TBatchResponse> batchRelease(List<String> identifier) {
		return service.getService().batchRelease(identifier);
	}

	@Override
	public void remove(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault {
		service.getService().remove(identifier);
		
	}

	@Override
	public List<TBatchResponse> batchRemove(List<String> identifier) {
		return service.getService().batchRemove(identifier);
	}

	@Override
	public void resume(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {
		service.getService().resume(identifier);
		
	}

	@Override
	public List<TBatchResponse> batchResume(List<String> identifier) {
		return service.getService().batchResume(identifier);
	}

	@Override
	public void setFault(String identifier, TFault fault)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		service.getService().setFault(identifier, fault);
		
	}

	@Override
	public void setOutput(String identifier, String part, Object taskData)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		service.getService().setOutput(identifier, part, taskData);
		
	}

	@Override
	public void setPriority(String identifier, int priority)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		service.getService().setPriority(identifier, priority);
		
	}

	@Override
	public List<TBatchResponse> batchSetPriority(List<String> identifier,
			int priority) {
		return service.getService().batchSetPriority(identifier, priority);
	}

	@Override
	public void setTaskCompletionDeadlineExpression(String identifier,
			String deadlineName, String deadlineExpression)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		service.getService().setTaskCompletionDeadlineExpression(identifier, deadlineName, deadlineExpression);
		
	}

	@Override
	public void setTaskCompletionDurationExpression(String identifier,
			String deadlineName, String durationExpression)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		service.getService().setTaskCompletionDurationExpression(identifier, deadlineName, durationExpression);
		
	}

	@Override
	public void setTaskStartDeadlineExpression(String identifier,
			String deadlineName, String deadlineExpression)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		service.getService().setTaskStartDeadlineExpression(identifier, deadlineName, deadlineExpression);
		
	}

	@Override
	public void setTaskStartDurationExpression(String identifier,
			String deadlineName, String durationExpression)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		service.getService().setTaskStartDurationExpression(identifier, deadlineName, durationExpression);
		
	}

	@Override
	public void skip(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {
		service.getService().skip(identifier);
		
	}

	@Override
	public List<TBatchResponse> batchSkip(List<String> identifier) {
		return service.getService().batchSkip(identifier);
	}

	@Override
	public void start(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {
		service.getService().start(identifier);
		
	}

	@Override
	public List<TBatchResponse> batchStart(List<String> identifier) {
		return service.getService().batchStart(identifier);
	}

	@Override
	public void stop(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {
		service.getService().stop(identifier);
	}

	@Override
	public List<TBatchResponse> batchStop(List<String> identifier) {
		return service.getService().batchStop(identifier);
	}

	@Override
	public void suspend(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {
		service.getService().suspend(identifier);
		
	}

	@Override
	public List<TBatchResponse> batchSuspend(List<String> identifier) {
		return service.getService().batchSuspend(identifier);
	}

	@Override
	public void suspendUntil(String identifier, TTime time)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		service.getService().suspendUntil(identifier, time);
		
	}

	@Override
	public List<TBatchResponse> batchSuspendUntil(List<String> identifier,
			TTime time) {
		return service.getService().batchSuspendUntil(identifier, time);
	}

	@Override
	public void updateComment(String taskIdentifier, String commentIdentifier,
			String text) throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		service.getService().updateComment(taskIdentifier, commentIdentifier, text);
		
	}

	@Override
	public List<TTaskAbstract> getMyTaskAbstracts(String taskType,
			String genericHumanRole, String workQueue, List<String> status,
			String whereClause, String orderByClause, String createdOnClause,
			Integer maxTasks, Integer taskIndexOffset)
			throws IllegalArgumentFault, IllegalOperationFault,
			IllegalStateFault {
		return service.getService().getMyTaskAbstracts(taskType, genericHumanRole, workQueue, status, whereClause, orderByClause, createdOnClause, maxTasks, taskIndexOffset);
	}

	@Override
	public List<TTaskDetails> getMyTaskDetails(String taskType,
			String genericHumanRole, String workQueue, List<String> status,
			String whereClause, String orderByClause, String createdOnClause,
			Integer maxTasks, Integer taskIndexOffset)
			throws IllegalArgumentFault, IllegalOperationFault,
			IllegalStateFault {
		return service.getService().getMyTaskDetails(taskType, genericHumanRole, workQueue, status, whereClause, orderByClause, createdOnClause, maxTasks, taskIndexOffset);
	}

	@Override
	public TTaskQueryResultSet query(String selectClause, String whereClause,
			String orderByClause, Integer maxTasks, Integer taskIndexOffset)
			throws IllegalArgumentFault, IllegalStateFault {
		return service.getService().query(selectClause, whereClause, orderByClause, maxTasks, taskIndexOffset);
	}

	@Override
	public void activate(String identifier) throws IllegalAccessFault,
			IllegalArgumentFault, IllegalOperationFault, IllegalStateFault {
		service.getService().activate(identifier);
		
	}

	@Override
	public List<TBatchResponse> batchActivate(List<String> identifier) {
		return service.getService().batchActivate(identifier);
	}

	@Override
	public void nominate(String identifier,
			TOrganizationalEntity organizationalEntity)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		service.getService().nominate(identifier, organizationalEntity);
		
	}

	@Override
	public List<TBatchResponse> batchNominate(List<String> identifier) {
		return service.getService().batchNominate(identifier);
	}

	@Override
	public void setGenericHumanRole(String identifier, String genericHumanRole,
			TOrganizationalEntity organizationalEntity)
			throws IllegalAccessFault, IllegalArgumentFault,
			IllegalOperationFault, IllegalStateFault {
		service.getService().setGenericHumanRole(identifier, genericHumanRole, organizationalEntity);
		
	}

	@Override
	public List<TBatchResponse> batchSetGenericHumanRole(
			List<String> identifier, String genericHumanRole,
			TOrganizationalEntity organizationalEntity) {
		return service.getService().batchSetGenericHumanRole(identifier, genericHumanRole, organizationalEntity);
	}
	
	public TaskOperationsSessionService getService() {
		return service;
	}

	public void setService(TaskOperationsSessionService service) {
		this.service = service;
	}

}
