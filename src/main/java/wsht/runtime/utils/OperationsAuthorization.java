package wsht.runtime.utils;

import wsht.infrastructure.domain.entity.TaskInfo;
import wsht.runtime.enums.GenericHumanRolesEnum;
import wsht.runtime.enums.OperationsEnum;

public class OperationsAuthorization {

	
	public static boolean checkRolePermission(GenericHumanRolesEnum genericHumanRole, OperationsEnum operation) {
		
		switch(operation) {

			case skip:
			case activate:
				return genericHumanRole.isTaskInitiator() 
					|| genericHumanRole.isTaskStakeHolders() 
					|| genericHumanRole.isBusinessAdministrator();
				
			case addAttachment:
			case addComment:
				return genericHumanRole.isTaskStakeHolders()
				|| genericHumanRole.isPotentialOwners()
				|| genericHumanRole.isActualOwner()
				|| genericHumanRole.isBusinessAdministrator();

			case getTaskOperations:
			case getTaskDescription:
			case getRendering:
			case getRenderingTypes:
			case getMyTaskAbstracts:
			case getMyTaskDetails:
			case batchActivate:
			case batchClaim:
			case batchComplete:
			case batchDelegate:
			case batchFail:
			case batchForward:
			case batchNominate:
			case batchRelease:
			case batchRemove:
			case batchResume:
			case batchSetGenericHumanRole:
			case batchSetPriority:
			case batchSkip:
			case batchStart:
			case batchStop:
			case batchSuspend:
			case batchSuspendUntil:
				return genericHumanRole.isTaskInitiator()
				|| genericHumanRole.isTaskStakeHolders()
				|| genericHumanRole.isPotentialOwners()
				|| genericHumanRole.isActualOwner()
				|| genericHumanRole.isBusinessAdministrator()
				|| genericHumanRole.isNotificationsrecipients();

			case claim:
				return genericHumanRole.isPotentialOwners();
					
			case delegate:
				return genericHumanRole.isTaskStakeHolders()
				|| genericHumanRole.isActualOwner()
				|| genericHumanRole.isBusinessAdministrator();
			
			case updateComment:
			case getAttachment:
			case getAttachmentInfos:
			case getComments:
			case deleteAttachment:
			case deleteComment:
				return genericHumanRole.isTaskStakeHolders()
				|| genericHumanRole.isPotentialOwners()
				|| genericHumanRole.isActualOwner()
				|| genericHumanRole.isBusinessAdministrator();
			
			case complete:
			case instantiateSubTask:
			case stop:
			case setOutput:
			case setFault:
			case release:
			case deleteFault:
			case deleteOutput:
			case fail:
				return genericHumanRole.isActualOwner();
				
			case forward:
				return genericHumanRole.isTaskStakeHolders()
				|| genericHumanRole.isActualOwner()
				|| genericHumanRole.isBusinessAdministrator();

			case getTaskHistory:
			case getOutcome:
			case getOutput:
			case getParentTask:
			case getParentTaskIdentifier:
			case getFault:
				return genericHumanRole.isTaskInitiator()
				|| genericHumanRole.isTaskStakeHolders()
				|| genericHumanRole.isActualOwner()
				|| genericHumanRole.isBusinessAdministrator();
			
			case isSubtask:
			case hasSubtasks:
			case getTaskInstanceData:
			case getSubtaskIdentifiers:
			case getSubtasks:
			case getInput:
				return genericHumanRole.isTaskInitiator()
				|| genericHumanRole.isTaskStakeHolders()
				|| genericHumanRole.isPotentialOwners()
				|| genericHumanRole.isActualOwner()
				|| genericHumanRole.isBusinessAdministrator();
				
			case getTaskDetails:
				return genericHumanRole.isTaskStakeHolders()
				|| genericHumanRole.isPotentialOwners()
				|| genericHumanRole.isActualOwner()
				|| genericHumanRole.isBusinessAdministrator()
				|| genericHumanRole.isNotificationsrecipients();
				
			case setGenericHumanRole:
			case nominate:
				return genericHumanRole.isBusinessAdministrator();
			
			case remove:
				return genericHumanRole.isBusinessAdministrator()
				|| genericHumanRole.isNotificationsrecipients();
			
			case suspend:
			case suspendUntil:
			case setTaskCompletionDeadlineExpression:
			case setTaskCompletionDurationExpression:
			case setTaskStartDeadlineExpression:
			case setTaskStartDurationExpression:
			case setPriority:
			case resume:
				return genericHumanRole.isTaskStakeHolders()
				|| genericHumanRole.isBusinessAdministrator();
				
			case start:
				return genericHumanRole.isPotentialOwners()
				|| genericHumanRole.isActualOwner();
				
			default :
				throw new IllegalArgumentException();
			
		}
	}
	
	public static boolean checkPreStatePermission(OperationsEnum operation, TaskInfo task) {
		
		switch(operation) {
			
			case remove:
				return task.getState().isNotificationReady();
				
			case claim:
				return task.getState().isReady();
			
			case start:
				return task.getState().isReady()
				|| task.getState().isReserved();
			
			case stop:
			case setOutput:
			case setFault:
			case fail:
			case deleteOutput:
			case deleteFault:
			case complete:
				return task.getState().isInProgress();
			
			case suspendUntil:
			case suspend:
			case forward:
			case delegate:
				return task.getState().isReady() 
				|| task.getState().isReserved()
				|| task.getState().isInProgress();
			
			case release:
			case instantiateSubTask:
				return task.getState().isReserved()
				|| task.getState().isInProgress();
			
			case resume:
				return task.getState().isSuspendedInProgress()
				|| task.getState().isSuspendedReady()
				|| task.getState().isSuspendedReserved();
				
			case skip:
			case setTaskCompletionDeadlineExpression:
			case setTaskCompletionDurationExpression:
			case setTaskStartDeadlineExpression:
			case setTaskStartDurationExpression:
				return task.getState().isCreated()
				|| task.getState().isReady()
				|| task.getState().isReserved()
				|| task.getState().isInProgress();
				
			case updateComment:
			case setPriority:
			case isSubtask:
			case hasSubtasks:
			case getTaskOperations:
			case getTaskInstanceData:
			case getTaskHistory:
			case getTaskDetails:
			case getTaskDescription:
			case getSubtasks:
			case getSubtaskIdentifiers:
			case getRenderingTypes:
			case getRendering:
			case getParentTaskIdentifier:
			case getParentTask:
			case getOutput:
			case getOutcome:
			case getInput:
			case getFault:
			case getComments:
			case getAttachmentInfos:
			case getAttachment:
			case deleteComment:
			case deleteAttachment:	
			case addComment: 
			case addAttachment:
				return true;
			
			default:
				throw new IllegalArgumentException();
		}
	}
}
