package wsht.runtime.communication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import wsht.infrastructure.domain.entity.Notification;
import wsht.runtime.utils.ActorUtils;
import akka.actor.ActorSystem;
import akka.actor.TypedActor;
import akka.actor.TypedProps;
import akka.kernel.Bootable;

@Component("integratingActor")
public class IntegratingActor implements Bootable, IIntegration, InitializingBean, DisposableBean {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IntegratingActor.class);
	
	private ActorSystem system;
	
	private ITaskService service;
	
	public ITaskService getService() {
		return service;
	}

	public static void main(String[] args) {	
		System.out.println("!!! Main w IntegratingActor !!!");
		//Timeout timeout = new Timeout(Duration.parse("5 seconds"));
		
		IntegratingActor integrator = new IntegratingActor();
		integrator.startup();
		Notification notification = new Notification();
		
		integrator.getService().process(notification);
		System.out.println("Przyszla odpowiedz narazie z service ");
		
	}


	public void shutdown() {
		system.shutdown();
		LOGGER.debug(">>>>>>> ACTOR SYETEM " + this.getClass().getSimpleName() + " shutdown! <<<<<<<");
		
	}

	public void startup() {
		LOGGER.debug(">>>>>>> ACTOR SYSTEM " + this.getClass().getSimpleName() + " startup. <<<<<<<");
		if(system == null)
			system = ActorSystem.create(ActorUtils.a_0_system);
		service = TypedActor.get(system).typedActorOf(new TypedProps<TaskServiceImpl>(ITaskService.class, TaskServiceImpl.class));
	}

	public void destroy() throws Exception {
		shutdown();
	}

	public void afterPropertiesSet() throws Exception {
		startup();
	}

}





