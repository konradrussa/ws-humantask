package wsht.infrastructure.web.service.endpoint;

import javax.xml.ws.Holder;

import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TLeanTask;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTask.InputMessage;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskResponse.OutputMessage;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.IllegalAccessFault;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.IllegalArgumentFault;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.IllegalStateFault;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.LeanTaskOperations;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.ListLeanTaskDefinitionsResponse.LeanTaskDefinitions;

import wsht.infrastructure.web.service.LeanTaskOperationsSessionService;

public class LeanTaskOperationsClientEndpoint implements LeanTaskOperations {

	private LeanTaskOperationsSessionService service;
	

	@Override
	public String registerLeanTaskDefinition(TLeanTask taskDefinition)
			throws IllegalAccessFault, IllegalStateFault {
		return service.getService().registerLeanTaskDefinition(taskDefinition);
	}

	@Override
	public void unregisterLeanTaskDefinition(Holder<String> taskName)
			throws IllegalAccessFault, IllegalArgumentFault {
		service.getService().unregisterLeanTaskDefinition(taskName);
	}

	@Override
	public LeanTaskDefinitions listLeanTaskDefinitions()
			throws IllegalAccessFault {
		return service.getService().listLeanTaskDefinitions();
	}

	@Override
	public OutputMessage createLeanTask(InputMessage inputMessage,
			TLeanTask taskDefinition, String taskName)
			throws IllegalAccessFault, IllegalArgumentFault {
		return service.getService().createLeanTask(inputMessage, taskDefinition, taskName);
	}

	@Override
	public void createLeanTaskAsync(
			org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskAsync.InputMessage inputMessage,
			TLeanTask taskDefinition, String taskName)
			throws IllegalAccessFault, IllegalArgumentFault {
		service.getService().createLeanTaskAsync(inputMessage, taskDefinition, taskName);
		
	}
	
	public LeanTaskOperationsSessionService getService() {
		return service;
	}

	public void setService(LeanTaskOperationsSessionService service) {
		this.service = service;
	}
}
