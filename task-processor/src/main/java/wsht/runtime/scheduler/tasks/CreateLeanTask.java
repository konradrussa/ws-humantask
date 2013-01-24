package wsht.runtime.scheduler.tasks;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import wsht.infrastructure.domain.entity.LeanTask;
import wsht.infrastructure.domain.entity.TaskInfo;
import wsht.infrastructure.service.IRepositoryService;
import wsht.runtime.enums.TaskStatesEnum;
import wsht.runtime.scheduler.enums.TaskParameterTypeEnum;

public class CreateLeanTask extends AbstractTask {

	private static final Logger log = LoggerFactory.getLogger(CreateLeanTask.class);

	@Override
	public void process(TaskContext taskContext) {
		log.debug("Wywolanie zadania: Utworzenie zadania typu lean task");

		ApplicationContext context = taskContext.getApplicationContext();
		//LeanTask task = (LeanTask) taskContext.getParameters().get(TaskParameterTypeEnum.CREATE_LEAN_TASK);
		//TaskInfo taskInfo = new TaskInfo();
		//taskInfo.setIsLeanTask(true);
		//taskInfo.setCreated(new Date());
		//taskInfo.setState(TaskStatesEnum.CREATED);
		//taskInfo.setTask(task);
		//taskInfo.setTaskIdentifier(UUID.randomUUID().toString().substring(0, 10));
		
		IRepositoryService service = (IRepositoryService)context.getBean("repositoryService");
		//service.createTaskInfo(taskInfo);

	}

}
