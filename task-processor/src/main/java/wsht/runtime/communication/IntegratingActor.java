package wsht.runtime.communication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import akka.actor.*;
import akka.dispatch.Await;
import akka.dispatch.Future;
import akka.japi.Option;
import akka.kernel.Bootable;
import akka.util.Duration;
import akka.util.Timeout;

import wsht.errorkernel.actors.*;


public class IntegratingActor implements Bootable , IIntegration {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IntegratingActor.class);
	
	final ActorSystem system = ActorSystem.create("mainkernel");
	
	public static void main(String[] args) {	

		Timeout timeout = new Timeout(Duration.parse("5 seconds"));
		
		
		/* 
		  val service: Service =
		    TypedActor(system).typedActorOf(
		      TypedProps[ServiceImpl]()
		    )

		  val req = Request("hello world!")

		  service.request(req) onSuccess {
		    case Response(response) =>
		      println(response)
		      system.shutdown()
		  }*/
	}

	public void shutdown() {
		system.shutdown();
		LOGGER.debug(">>>>>>>" + this.getClass().getSimpleName() + " shutdown! <<<<<<<");
		
	}

	public void startup() {
		LOGGER.debug(">>>>>>>" + this.getClass().getSimpleName() + " startup. <<<<<<<");
		
	}

}
