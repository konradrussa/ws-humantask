package wsht.infrastructure.webservice.leantask;

import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.LeanTaskCallbackOperations;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskAsyncCallback.OutputMessage;

@WebService(endpointInterface="org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.LeanTaskCallbackOperations")
@Addressing
public class LeanTaskCallbackOperationsImpl implements LeanTaskCallbackOperations {

	public void createLeanTaskAsyncCallback(OutputMessage outputMessage) {
		
		System.out.println("createLeanTaskAsyncCallback");
	}

}
