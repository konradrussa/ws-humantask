package wsht.runtime.listeners;

import wsht.exception.WSHTException;
import wsht.infrastructure.domain.entity.LeanTask;
import wsht.runtime.enums.TaskStatesEnum;

public interface ITaskListener {
	
	
	public void onTaskReady();
	public void onResumeReady();
	public void stateChanged(TaskStatesEnum newState);
	public void processLeanTaskDefinitionAndCreate(Object any, LeanTask leanTask) throws WSHTException;
	public void processLeanTaskDefinitionAsync(LeanTask leanTask);
}
