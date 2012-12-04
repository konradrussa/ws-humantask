package wsht.runtime.scheduler.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class SupervisorJob extends QuartzJobBean  {


	@Override
	protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		
	}

}
