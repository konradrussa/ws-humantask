package wsht.runtime.communication;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import wsht.runtime.enums.TaskStatesEnum;
import wsht.runtime.listeners.IEventProcessingListenser;
import wsht.runtime.listeners.INotificationListener;
import wsht.runtime.listeners.ITaskListener;
import akka.dispatch.Future;
import akka.japi.Option;

@Component("communicatingModel")
public class CommunicatingModel implements IEventProcessingListenser {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommunicatingModel.class);
	
	@Resource
	private IIntegration integratingActor;	


	public void onStartDeadlineEvent() {
		//integratingActor.getService();
		
	}

	public void onEndDeadlineEvent() {
		// TODO Auto-generated method stub
		
	}

	

}
