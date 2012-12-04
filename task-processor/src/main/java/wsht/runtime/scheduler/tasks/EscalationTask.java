package wsht.runtime.scheduler.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import wsht.infrastructure.domain.entity.Deadline;
import wsht.infrastructure.domain.entity.Escalation;
import wsht.infrastructure.service.IRepositoryService;
import wsht.runtime.scheduler.enums.TaskParameterTypeEnum;

public class EscalationTask extends AbstractTask {

	private static final Logger log = LoggerFactory
			.getLogger(EscalationTask.class);

	@Override
	public void process(TaskContext taskContext) {
		log.debug("Wywolanie zadania: Utworzenie zadania escalation");

		ApplicationContext context = taskContext.getApplicationContext();
		Escalation escalation = (Escalation) taskContext.getParameters().get(TaskParameterTypeEnum.ESCALATION);


	}

}