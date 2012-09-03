package wsht.runtime.scheduler.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class SupervisorJob extends QuartzJobBean  {

	  private int timeout;
	  
	  /**
	   * Setter called after the ExampleJob is instantiated
	   * with the value from the JobDetailBean (5)
	   */ 
	  public void setTimeout(int timeout) {
	    this.timeout = timeout;
	  }
	
	@Override
	protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		System.out.println("SupervisorJob executing: " + timeout);
	}

}
