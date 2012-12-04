package wsht.infrastructure.web.service.endpoint;

import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.LeanTaskCallbackOperations;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskAsyncCallback.OutputMessage;

import wsht.infrastructure.web.service.LeanTaskCallbackOperationsSessionService;

public class LeanTaskCallbackOperationsClientEndpoint implements LeanTaskCallbackOperations {
	
	private LeanTaskCallbackOperationsSessionService service;

	public void createLeanTaskAsyncCallback(OutputMessage outputMessage) {
		service.getService().createLeanTaskAsyncCallback(outputMessage);
	}

	public LeanTaskCallbackOperationsSessionService getService() {
		return service;
	}

	public void setService(LeanTaskCallbackOperationsSessionService service) {
		this.service = service;
	}
	
}
