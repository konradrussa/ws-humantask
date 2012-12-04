package wsht.runtime.communication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import akka.actor.ActorRef;
import akka.actor.TypedActor;
import akka.actor.TypedActor.PostStop;
import akka.actor.TypedActor.PreStart;
import akka.actor.TypedActor.Receiver;
import akka.dispatch.Future;
import akka.dispatch.Futures;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Option;

public class CommunicatingActor implements ICommunication, InitializingBean {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommunicatingActor.class);
	
	IIntegration integratingActor;

	public Future<String> processMessage(String param) {
		
		return null;
	}

	public Option<String> computeAndReturn() {
		
		return null;
	}

	public void afterPropertiesSet() throws Exception {
		integratingActor = new IntegratingActor();
	}

}
