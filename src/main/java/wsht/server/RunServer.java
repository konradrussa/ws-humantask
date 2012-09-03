package wsht.server;

import javax.xml.ws.Endpoint;

import wsht.infrastructure.webservice.leantask.LeanTaskCallbackOperationsImpl;
import wsht.infrastructure.webservice.leantask.LeanTaskOperationsImpl;


public class RunServer {

	public static void main(String[] args) {
	      Endpoint endpoint1 = Endpoint.create(new LeanTaskOperationsImpl());
	      
//	      Binding binding1 = endpoint1.getBinding();
//	      List<Handler> handlerChain1 = new LinkedList<Handler>();
//	      handlerChain1.add(new SecurityHandler("server"));
//	      binding1.setHandlerChain(handlerChain1);
	      
	      endpoint1.publish("http://localhost:8080/leanTaskOperations");
	      
	      Endpoint endpoint2 = Endpoint.create(new LeanTaskCallbackOperationsImpl());
	      
//	      Binding binding2 = endpoint2.getBinding();
//	      List<Handler> handlerChain2 = new LinkedList<Handler>();
//	      handlerChain2.add(new SecurityHandler("server"));
//	      binding2.setHandlerChain(handlerChain2);
	      
	      endpoint2.publish("http://localhost:8080/leanTaskCallbackOperations");
	      
	      System.out.println("START");
	}
}
