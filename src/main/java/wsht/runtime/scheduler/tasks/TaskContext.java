package wsht.runtime.scheduler.tasks;

import java.util.Map;

import org.springframework.context.ApplicationContext;

import wsht.runtime.scheduler.enums.TaskParameterTypeEnum;

public class TaskContext {

	private ApplicationContext applicationContext;
	private Map<TaskParameterTypeEnum, Object> parameters;

	public TaskContext(ApplicationContext applicationContext,
			Map<TaskParameterTypeEnum, Object> parameters) {
		this.applicationContext = applicationContext;
		this.parameters = parameters;
	}

	/**
	 * Kontekst aplikacji(spring)
	 * 
	 * @return the applicationContext
	 */
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * Parametry wejściowe zadania
	 * 
	 * @return the parameters
	 */
	public Map<TaskParameterTypeEnum, Object> getParameters() {
		return parameters;
	}

}
