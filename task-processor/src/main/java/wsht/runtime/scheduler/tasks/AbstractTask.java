package wsht.runtime.scheduler.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.quartz.StatefulJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import wsht.runtime.scheduler.enums.TaskParameterTypeEnum;

public abstract class AbstractTask implements StatefulJob {
	
	private static final Logger log = LoggerFactory.getLogger(AbstractTask.class);

	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDetail detail = context.getJobDetail();
        log.info("Przetwarzanie zadania: "+detail.getName());
        String description = detail.getDescription();
        String fullName = detail.getFullName();
        SchedulerContext schedulerContext;
        try {
            schedulerContext = context.getScheduler().getContext();
            //-- Pobranie kontekstu aplikacji (Spring) z kontekstu Schedulera
            ApplicationContext applicationContext =
                    (ApplicationContext) schedulerContext.get("applicationContext");

            //Konwersja parametrów
            Set<Entry<String, Object>> sourceParametersSet =
                    context.getTrigger().getJobDataMap().getWrappedMap().entrySet();

            log.info("Liczba parametrow zadania: "+sourceParametersSet.size());

            Map<TaskParameterTypeEnum, Object> targetParameters = new HashMap<TaskParameterTypeEnum, Object>();
            for (Entry<String, Object> entry : sourceParametersSet) {
                targetParameters.put(TaskParameterTypeEnum.getType(entry.getKey()),entry.getValue());
            }                        

            TaskContext taskContext = new TaskContext(applicationContext, targetParameters);
            process(taskContext);

        } catch (SchedulerException ex) {
            throw new JobExecutionException(ex);
        }
		
	}
	
	public abstract void process(TaskContext taskContext);

	
	
}
