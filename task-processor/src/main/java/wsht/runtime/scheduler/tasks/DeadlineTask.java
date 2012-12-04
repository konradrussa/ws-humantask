package wsht.runtime.scheduler.tasks;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import wsht.infrastructure.domain.entity.Deadline;
import wsht.infrastructure.domain.entity.LeanTask;
import wsht.infrastructure.domain.entity.TaskInfo;
import wsht.infrastructure.service.IRepositoryService;
import wsht.runtime.enums.TaskStatesEnum;
import wsht.runtime.scheduler.enums.TaskParameterTypeEnum;

public class DeadlineTask extends AbstractTask {

	private static final Logger log = LoggerFactory
			.getLogger(DeadlineTask.class);

	@Override
	public void process(TaskContext taskContext) {
		log.debug("Wywolanie zadania: Utworzenie zadania typu deadline");

		ApplicationContext context = taskContext.getApplicationContext();
		Deadline deadline = (Deadline) taskContext.getParameters().get(TaskParameterTypeEnum.DEADLINE);

		IRepositoryService service = (IRepositoryService) context.getBean("repositoryService");

	}

}
