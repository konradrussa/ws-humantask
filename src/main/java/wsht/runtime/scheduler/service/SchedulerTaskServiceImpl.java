package wsht.runtime.scheduler.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import wsht.runtime.exceptions.WSHTSystemSchedulerException;
import wsht.runtime.scheduler.enums.TaskParameterTypeEnum;

@Service("schedulerTaskService")
public class SchedulerTaskServiceImpl implements SchedulerTaskService {

    private static final Logger log = LoggerFactory.getLogger(SchedulerTaskServiceImpl.class);
    private static final String JOB_GROUP_NAME = "WSHT_GROUP";
    
    @Resource(name = "wshtScheduler")
    private Scheduler scheduler;
	
	@Override
	public void addTask(Long taskID, Date runTime,
			Map<TaskParameterTypeEnum, Object> parameters, Class<?> jobClass) throws WSHTSystemSchedulerException {
		
		if (taskID == null) {
            throw new WSHTSystemSchedulerException("taskID is null");
        }
        if (runTime == null) {
            throw new WSHTSystemSchedulerException("runTime is null");
        }
        if (parameters == null || parameters.isEmpty()) {
            throw new WSHTSystemSchedulerException("parameters is not set");
        }
        if (jobClass == null) {
            throw new WSHTSystemSchedulerException("taskClass is null");
        }

        //-- Definicja nowego job'a
        JobDetail pJob = new JobDetail(taskID + "", jobClass.getSimpleName(), jobClass);

        //-- Nowy wyzwalacz
        SimpleTrigger trigger = new SimpleTrigger("trigger" + taskID + runTime, jobClass.getSimpleName(), runTime);

        //Konwersja parametrów
        Map<String, Object> parametersTask = new HashMap<String, Object>();
        Set<Entry<TaskParameterTypeEnum, Object>> paramSet =
                parameters.entrySet();//Set<Entry<TaskParameterType, Object>>
        for (Entry<TaskParameterTypeEnum, Object> entry : paramSet) {
            parametersTask.put(entry.getKey().name(),entry.getValue());
        }
        trigger.getJobDataMap().putAll(parametersTask);

        //trigger.setDescription("opis test");
        try {
            //-- Planuje zadanie w Quartz'ie
            Date ft = scheduler.scheduleJob(pJob, trigger);
            log.info("Quartz rozpocznie " + pJob.getFullName() + " o " + ft);
        } catch (SchedulerException e) {
            throw new WSHTSystemSchedulerException(e);
        }
    }
	
	@Override
	public boolean deleteTask(Long aTaskID, Class<?> jobClass) throws WSHTSystemSchedulerException {
		try {
            return scheduler.deleteJob(aTaskID + "", jobClass.getSimpleName());
        } catch (SchedulerException e) {
            throw new WSHTSystemSchedulerException(e);
        }
	}

	public Scheduler getScheduler() {
		return scheduler;
	}

	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}
	
	

}
