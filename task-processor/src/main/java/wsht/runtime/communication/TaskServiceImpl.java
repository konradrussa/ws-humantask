package wsht.runtime.communication;

import wsht.errorkernel.actors.FaultTolerantSupervisor;
import wsht.infrastructure.domain.entity.Deadline;
import wsht.infrastructure.domain.entity.Escalation;
import wsht.infrastructure.domain.entity.Notification;
import wsht.infrastructure.domain.entity.Reassignment;
import wsht.runtime.utils.ActorUtils;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.TypedActor;

public class TaskServiceImpl implements ITaskService {
	public ActorRef faultTolerantSupervisor;

	public TaskServiceImpl() {
		faultTolerantSupervisor = TypedActor.context().actorOf(new Props(FaultTolerantSupervisor.class), ActorUtils.a_1_faultTolerantSupervisor);
	}
	
	public void process(Deadline deadline) {
		faultTolerantSupervisor.tell(deadline);
	}
	
	public void process(Reassignment reassignment) {
		faultTolerantSupervisor.tell(reassignment);
	}
	
	public void process(Escalation escalation) {
		faultTolerantSupervisor.tell(escalation);
	}

	public void process(Notification notification) {
		faultTolerantSupervisor.tell(notification);
	}
	


}