package wsht.infrastructure.webservice.leantask;

import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.LeanTaskCallbackOperations;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskAsyncCallback.OutputMessage;

@WebService(endpointInterface="org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.LeanTaskCallbackOperations")
@InInterceptors(interceptors = "org.apache.cxf.interceptor.LoggingInInterceptor")
@OutInterceptors(interceptors = "org.apache.cxf.interceptor.LoggingOutInterceptor")
@Addressing(enabled=true, required=true)
public class LeanTaskCallbackOperationsImpl implements LeanTaskCallbackOperations {

	public void createLeanTaskAsyncCallback(OutputMessage outputMessage) {
		
		System.out.println("!!!!! Przyszla odpowiedz do PARENTA LeanTaskCallbackOperationsImpl createLeanTaskAsyncCallback");
		System.out.println("!!!!! outputMessage != null -> " + outputMessage != null);
	}

}
