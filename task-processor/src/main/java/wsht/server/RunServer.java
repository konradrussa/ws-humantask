package wsht.server;

import javax.xml.ws.Endpoint;

import wsht.infrastructure.webservice.leantask.LeanTaskOperationsImpl;


public class RunServer {

	public static void main(String[] args) {
	      Endpoint endpoint1 = Endpoint.create(new LeanTaskOperationsImpl());
	      
//	      Binding binding1 = endpoint1.getBinding();
//	      List<Handler> handlerChain1 = new LinkedList<Handler>();
//	      handlerChain1.add(new SecurityHandler("server"));
//	      binding1.setHandlerChain(handlerChain1);
	      
	      endpoint1.publish("http://localhost:8080/leanTaskOperations");
	      
	      System.out.println("START");
	}
}
