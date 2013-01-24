package wsht.runtime.model;

import java.io.Serializable;

import wsht.infrastructure.domain.entity.TaskInfo;
import wsht.infrastructure.webservice.WSHTService;
import wsht.runtime.enums.TaskStatesEnum;

public abstract class AbstractTaskModel  extends WSHTService implements Serializable {
	private static final long serialVersionUID = -1420069473651911405L;
	
	protected TaskInfo taskInfo;

	public TaskInfo getTaskInfo() {
		return taskInfo;
	}

	public void setTaskInfo(TaskInfo taskInfo) {
		this.taskInfo = taskInfo;
	}
		
	
	
}
