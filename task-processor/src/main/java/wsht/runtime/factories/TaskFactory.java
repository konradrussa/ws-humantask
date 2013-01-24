package wsht.runtime.factories;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wsht.infrastructure.domain.entity.LeanTask;
import wsht.infrastructure.domain.entity.Task;
import wsht.infrastructure.domain.entity.TaskInfo;
import wsht.infrastructure.domain.entity.base.TaskBase;
import wsht.infrastructure.utils.ReflectionUtils;
import wsht.runtime.enums.TaskStatesEnum;
import wsht.exception.WSHTException;

public class TaskFactory  {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskFactory.class);
	
	private TaskFactory() {}
	
	private volatile static TaskFactory instance;
	
	public static TaskFactory instance() {
		synchronized(TaskFactory.class) {
			if(instance == null) {
				instance = new TaskFactory();
			}
			return instance;
		}
	}

	private TaskInfo buildTaskInfo(LeanTask leanTaskDefinition) {
		TaskInfo taskInfo = new TaskInfo();
		taskInfo.setTask(leanTaskDefinition);
		taskInfo.setIsLeanTask(true);
		taskInfo.setIsSubtask(false); //zawsze false ?
		taskInfo.setState(TaskStatesEnum.CREATED);
		System.out.println("buildTaskInfo(LeanTask leanTaskDefinition)");
		return taskInfo;
	}
	
	private TaskInfo buildTaskInfo(Task taskDefinition) {
		TaskInfo taskInfo = new TaskInfo();
		taskInfo.setTask(taskDefinition);
		taskInfo.setIsLeanTask(false);
		System.out.println("buildTaskInfo(Task taskDefinition)");
		return taskInfo;
	}

	public TaskInfo buildTaskInfo(TaskBase taskBase) {
		try {
			Method method = instance.getClass().getMethod("buildTaskInfo", taskBase.getClass());
			return (TaskInfo) ReflectionUtils.invokeMethod(instance, method, taskBase);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (WSHTException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//testing purposes
	public static void main(String[] args) {
		TaskFactory i = TaskFactory.instance();
		LeanTask t = new LeanTask();
		System.out.println("jest");
		TaskFactory.instance().buildTaskInfo(t);

	}
}
