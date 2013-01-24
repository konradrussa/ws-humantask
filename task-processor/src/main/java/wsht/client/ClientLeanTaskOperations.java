package wsht.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;



import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TLeanTask;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskAsync;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.IllegalAccessFault;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.IllegalArgumentFault;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.IllegalStateFault;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.LeanTaskOperations;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTask.InputMessage;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.ListLeanTaskDefinitionsResponse.LeanTaskDefinitions;

import wsht.infrastructure.webservice.handlers.SecurityHandler;

public class ClientLeanTaskOperations {

	public static void main(String[] args) throws IllegalAccessFault, MalformedURLException {
		
		
		System.setProperty("javax.xml.ws.addressing.AddressingBuilder", "com.sun.xml.ws.addressing.v200408.AddressingBuilderImpl");
		URL url = new URL("http://localhost:8081/services/leanTaskOperations?wsdl");
		QName qname = new QName("http://leantask.webservice.infrastructure.wsht/", "LeanTaskOperationsImplService");
		Service service = Service.create(url, qname);
		LeanTaskOperations stub = service.getPort(LeanTaskOperations.class);

//		List<Handler> handlerChain = new LinkedList<Handler>();
//		handlerChain.add(new SecurityHandler("client"));
//		((BindingProvider) stub).getBinding().setHandlerChain(handlerChain);
		
		
		LeanTaskDefinitions definitions = stub.listLeanTaskDefinitions();
		System.out.println(definitions);
		
		try {
			stub.createLeanTask(new InputMessage(), new TLeanTask(), "task");
		} catch (IllegalArgumentFault e) {
			e.printStackTrace();
		}
		
		try {
			stub.createLeanTaskAsync(new CreateLeanTaskAsync.InputMessage(), new TLeanTask(), "taskAsync");
		} catch (IllegalArgumentFault e) {
			e.printStackTrace();
		}
		
		try {
			stub.registerLeanTaskDefinition(new TLeanTask());
		} catch (IllegalStateFault e) {
			e.printStackTrace();
		}
		
		try {
			stub.unregisterLeanTaskDefinition(new Holder<String>("task"));
		} catch (IllegalArgumentFault e) {
			e.printStackTrace();
		}
		
	}
}
