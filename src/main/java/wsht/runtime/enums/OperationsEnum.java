package wsht.runtime.enums;


public enum OperationsEnum {

	activate,
	addAttachment,
	addComment,
	batchClaim,
	batchComplete,
	batchDelegate,
	batchFail,
	batchForward,
	batchRelease,
	batchRemove,
	batchResume,
	batchSetPriority,
	batchSkip,
	batchStart,
	batchStop,
	batchSuspend,
	batchSuspendUntil,
	batchActivate,
	batchNominate,
	batchSetGenericHumanRole,
	claim,
	complete,
	delegate,
	deleteAttachment,
	deleteComment,
	deleteFault,
	deleteOutput,
	fail,
	forward,
	getAttachment,
	getAttachmentInfos,
	getComments,
	getFault,
	getInput,
	getMyTaskAbstracts,
	getMyTaskDetails,
	getOutcome,
	getOutput,
	getParentTask,
	getParentTaskIdentifier,
	getRendering,
	getRenderingTypes,
	getSubtaskIdentifiers,
	getSubtasks,
	getTaskDescription,
	getTaskDetails,
	getTaskHistory,
	getTaskInstanceData,
	getTaskOperations,
	hasSubtasks,
	instantiateSubTask,
	isSubtask,
	nominate,
	release,
	remove,
	resume,
	setFault,
	setGenericHumanRole,
	setOutput,
	setPriority,
	setTaskCompletionDeadlineExpression,
	setTaskCompletionDurationExpression,
	setTaskStartDeadlineExpression,
	setTaskStartDurationExpression,
	skip,
	start,
	stop,
	suspend,
	suspendUntil,
	updateComment;
	
	
	public static OperationsEnum getOperationForName(String methodName) {
		for(OperationsEnum e : OperationsEnum.values()) {
			if(e.name().equals(methodName)) {
				return e;
			}
		}
		throw new IllegalArgumentException("OperationName not found !!!");
	}
       
}
