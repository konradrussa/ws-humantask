package wsht.server;

import java.util.LinkedList;
import java.util.List;

import javax.xml.ws.Binding;
import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;

import wsht.infrastructure.webservice.handlers.ContextHandler;
import wsht.infrastructure.webservice.handlers.SecurityHandler;
import wsht.infrastructure.webservice.leantask.LeanTaskOperationsImpl;
import wsht.infrastructure.webservice.programminginterface.TaskOperationsImpl;


public class RunServer {

	public static void main(String[] args) {
	      Endpoint endpoint1 = Endpoint.create(new TaskOperationsImpl());
	      
	      
	      List<Handler> handlerChain1 = new LinkedList<Handler>();
	      handlerChain1.add(new SecurityHandler("server"));
	      handlerChain1.add(new ContextHandler());
	      Binding binding1 = endpoint1.getBinding();
	      binding1.setHandlerChain(handlerChain1);
	      
	      endpoint1.publish("http://localhost:8080/services/taskOperations");
	      
	      System.out.println("START taskOperations");
	      
	      Endpoint endpoint2 = Endpoint.create(new LeanTaskOperationsImpl());
	      
	      
	      List<Handler> handlerChain2 = new LinkedList<Handler>();
	      handlerChain2.add(new SecurityHandler("server"));
	      handlerChain2.add(new ContextHandler());
	      Binding binding2 = endpoint2.getBinding();
	      binding2.setHandlerChain(handlerChain2);
	      
	      endpoint2.publish("http://localhost:8080/services/leanTaskOperations");
	      
	      System.out.println("START leanTaskOperations");
	}
}
