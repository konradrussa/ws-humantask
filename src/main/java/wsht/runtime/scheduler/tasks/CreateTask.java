package wsht.runtime.scheduler.tasks;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import wsht.infrastructure.domain.entity.Task;
import wsht.infrastructure.domain.entity.TaskInfo;
import wsht.infrastructure.service.IRepositoryService;
import wsht.runtime.enums.TaskStatesEnum;
import wsht.runtime.scheduler.enums.TaskParameterTypeEnum;

import wsht.runtime.processor.TaskEngine;

public class CreateTask extends AbstractTask {

	private static final Logger log = LoggerFactory.getLogger(CreateTask.class);

	@Override
	public void process(TaskContext taskContext) {
		log.debug("Wywolanie zadania: Utworzenie zadania");

		ApplicationContext context = taskContext.getApplicationContext();
		Task task = (Task) taskContext.getParameters().get(TaskParameterTypeEnum.CREATE_TASK);
		TaskInfo taskInfo = new TaskInfo();
		taskInfo.setLeanTask(false);
		taskInfo.setCreated(new Date());
		taskInfo.setState(TaskStatesEnum.CREATED);
		taskInfo.setTask(task);
		taskInfo.setTaskIdentifier(UUID.randomUUID().toString().substring(0, 10));
		
		IRepositoryService service = (IRepositoryService)context.getBean("repositoryService");
		service.createTaskInfo(taskInfo);

	}

}
