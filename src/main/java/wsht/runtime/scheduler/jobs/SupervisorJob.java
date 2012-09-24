package wsht.runtime.scheduler.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import wsht.infrastructure.configuration.ConfigurationConfigFactory;

public class SupervisorJob extends QuartzJobBean  {

	private ConfigurationConfigFactory configurationConfigFactory;
	  
	
	public ConfigurationConfigFactory getConfigurationConfigFactory() {
		return configurationConfigFactory;
	}

	public void setConfigurationConfigFactory(
			ConfigurationConfigFactory configurationConfigFactory) {
		this.configurationConfigFactory = configurationConfigFactory;
	}


	@Override
	protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		
	}

}
