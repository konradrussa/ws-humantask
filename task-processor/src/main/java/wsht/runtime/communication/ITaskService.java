package wsht.runtime.communication;

import wsht.infrastructure.domain.entity.Deadline;
import wsht.infrastructure.domain.entity.Escalation;
import wsht.infrastructure.domain.entity.Notification;
import wsht.infrastructure.domain.entity.Reassignment;

public interface ITaskService {
	
	public void process(Deadline deadline);
	public void process(Reassignment reassignment);
	public void process(Escalation escalation);
	public void process(Notification notification); 
	

}
