package wsht.infrastructure.webservice.leantask;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.Holder;
import javax.xml.ws.soap.Addressing;

import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TLeanTask;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTask.InputMessage;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskAsync;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskResponse.OutputMessage;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.IllegalAccessFault;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.IllegalArgumentFault;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.IllegalState;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.IllegalStateFault;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.LeanTaskOperations;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.ListLeanTaskDefinitionsResponse.LeanTaskDefinitions;
import org.springframework.beans.factory.annotation.Autowired;

import wsht.infrastructure.domain.entity.LeanTask;
import wsht.infrastructure.service.IRepositoryService;
import wsht.infrastructure.web.SessionInfo;
import wsht.marshalling.IBeanMapper;

@WebService(endpointInterface="org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.LeanTaskOperations")
@Addressing
public class LeanTaskOperationsImpl implements LeanTaskOperations {
	
	@Autowired
	private SessionInfo sessionInfo;
	
	@Resource
	private IRepositoryService repositoryService;
	@Resource
	private IBeanMapper beanMapper;

	public String registerLeanTaskDefinition(TLeanTask taskDefinition)
			throws IllegalAccessFault, IllegalStateFault {
		
		String taskName = taskDefinition.getName();
		if(repositoryService.checkIfLeanTaskWithNameExists(taskName)) {
			throw new IllegalStateFault("Lean Task definition with name: " + taskName + " exists", new IllegalState());
		}
		
		LeanTask leanTask = beanMapper.map(taskDefinition, LeanTask.class);
		leanTask = repositoryService.createLeanTaskDefinition(leanTask);
		
		return "LeanTask definition created";
	}

	public void unregisterLeanTaskDefinition(Holder<String> taskName)
			throws IllegalAccessFault, IllegalArgumentFault {
		
		
		
		System.out.println("registerLeanTaskDefinition");
	}

	public LeanTaskDefinitions listLeanTaskDefinitions()
			throws IllegalAccessFault {
		
		System.out.println("registerLeanTaskDefinition");
		return new LeanTaskDefinitions();
	}

	public OutputMessage createLeanTask(InputMessage inputMessage,
			TLeanTask taskDefinition, String taskName)
			throws IllegalAccessFault, IllegalArgumentFault {
		
		System.out.println("createLeanTask");
		return new OutputMessage();
	}

	public void createLeanTaskAsync(CreateLeanTaskAsync.InputMessage inputMessage,
			TLeanTask taskDefinition, String taskName)
			throws IllegalAccessFault, IllegalArgumentFault {
		
		System.out.println("createLeanTaskAsync");
		
	}
	
}
