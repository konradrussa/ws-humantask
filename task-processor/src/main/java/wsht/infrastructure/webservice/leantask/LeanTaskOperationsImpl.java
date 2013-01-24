package wsht.infrastructure.webservice.leantask;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.Addressing;

import object.ObjectPreparator;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.apache.commons.lang.StringUtils;
import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;
import org.apache.cxf.ws.addressing.AddressingBuilder;
import org.apache.cxf.ws.addressing.AddressingProperties;
import org.apache.cxf.ws.addressing.AttributedURIType;
import org.apache.cxf.ws.addressing.JAXWSAConstants;
import org.apache.cxf.ws.addressing.ObjectFactory;
import org.apache.cxf.ws.addressing.RelatesToType;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import wsht.infrastructure.domain.entity.Argument;
import wsht.infrastructure.domain.entity.From;
import wsht.infrastructure.domain.entity.GenericHumanRoleAssignment;
import wsht.infrastructure.domain.entity.GroupEntityInfo;
import wsht.infrastructure.domain.entity.LeanTask;
import wsht.infrastructure.domain.entity.Literal;
import wsht.infrastructure.domain.entity.OrganizationalEntity;
import wsht.infrastructure.domain.entity.Parallel;
import wsht.infrastructure.domain.entity.PeopleAssignments;
import wsht.infrastructure.domain.entity.PotentialOwnerAssignment;
import wsht.infrastructure.domain.entity.Sequence;
import wsht.infrastructure.domain.entity.TaskInfo;
import wsht.infrastructure.domain.entity.UserEntityInfo;
import wsht.infrastructure.domain.entity.base.GenericHumanRoleAssignmentBase;
import wsht.infrastructure.service.IRepositoryService;
import wsht.infrastructure.utils.ReflectionUtils;
import wsht.infrastructure.web.TaskSessionInfo;
import wsht.infrastructure.webservice.WSHTService;
import wsht.marshalling.IBeanMapper;
import wsht.exception.WSHTException;
import wsht.runtime.configuration.PublicProtocolConfiguration;
import wsht.runtime.db4o.IDB4oInterface;
import wsht.runtime.exceptions.WSHTExpressionException;
import wsht.runtime.expressions.sbql.ast.operators.wsht.ext.IValuable;
import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.grammar.SBQLLexer;
import wsht.runtime.expressions.sbql.qres.grammar.SBQLParser;
import wsht.runtime.expressions.sbql.store.SBAStore;
import wsht.runtime.expressions.sbql.store.TaskInstance;
import wsht.runtime.expressions.sbql.util.SBQLUtil;
import wsht.runtime.factories.TaskFactory;
import wsht.runtime.listeners.ITaskListener;
import wsht.runtime.model.TaskModel;
import wsht.runtime.utils.TaskSemanticUtils;

import com.sun.xml.ws.api.addressing.OneWayFeature;

@WebService(endpointInterface="org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.LeanTaskOperations")
@InInterceptors(interceptors = "org.apache.cxf.interceptor.LoggingInInterceptor")
@OutInterceptors(interceptors = "org.apache.cxf.interceptor.LoggingOutInterceptor")
@Addressing(enabled = true, required=true)
public class LeanTaskOperationsImpl extends WSHTService implements LeanTaskOperations {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LeanTaskOperationsImpl.class);
	
	@Resource
    private WebServiceContext context;
	@Resource
	private IRepositoryService repositoryService;
	@Resource
	private IBeanMapper beanMapper;
	@Resource
	private ITaskListener taskModel;

	public String registerLeanTaskDefinition(TLeanTask taskDefinition)
			throws IllegalAccessFault, IllegalStateFault {
		
		String taskName = taskDefinition.getName();
		if(repositoryService.checkIfLeanTaskDefinitionWithNameExists(taskName)) {
			throw new IllegalStateFault("error - Lean Task definition with name: " + taskName + " exists", new IllegalState());
		}
		
		LeanTask leanTask = beanMapper.map(taskDefinition, LeanTask.class);
		try {
			leanTask = repositoryService.createLeanTaskDefinition(leanTask);
			return "success - LeanTask definition created";
		} catch (WSHTException e) {
			throw new IllegalAccessFault("error - Register Lean Task Definition", e.getMessage());
		}
		
		
	}

	public void unregisterLeanTaskDefinition(Holder<String> taskName)
			throws IllegalAccessFault, IllegalArgumentFault {
		
		if(taskName == null || taskName.value == null){
			if(repositoryService.checkIfLeanTaskDefinitionWithNameExists(taskName.value)) {
				try {
					repositoryService.deleteLeanTaskDefinition(taskName.value);
				} catch (WSHTException e) {
					throw new IllegalAccessFault("error - Unregister Lean Task", e.getMessage());
				}
			} else {
				throw new IllegalAccessFault("error - Unregister Lean Task"," Task Definition not exists: " + taskName.value);
			}
		} else {
			throw new IllegalArgumentFault("error - Unregister Lean Task"," Invalid parameters");
		}
		
		System.out.println("unregisterLeanTaskDefinition");
	}

	public LeanTaskDefinitions listLeanTaskDefinitions()
			throws IllegalAccessFault {
		
		
		System.out.println("listLeanTaskDefinitions");
		
		try {
			List<LeanTask> listLanTaskDefinitions = repositoryService.listLeanTaskDefinitions();
			List<TLeanTask> tLeanTaskDefinitions = beanMapper.mapList(listLanTaskDefinitions, TLeanTask.class);
			LeanTaskDefinitions leanTaskDefinitions = new LeanTaskDefinitions();
			leanTaskDefinitions.getLeanTaskDefinition().addAll(tLeanTaskDefinitions);
			return leanTaskDefinitions;
		} catch (WSHTException e) {
			throw new IllegalAccessFault("error - List Lean Task Definitions", "");
		}

	}

	public OutputMessage createLeanTask(InputMessage inputMessage, TLeanTask taskDefinition, String taskName)
			throws IllegalAccessFault, IllegalArgumentFault {
		
		System.out.println("createLeanTask");
		
		if(inputMessage == null || inputMessage.getAny() == null) {
			throw new IllegalArgumentFault("error - no input data presented","");
		}
		
		if(taskDefinition == null && StringUtils.isBlank(taskName)) {
			throw new IllegalArgumentFault("error - no taskName or taskDefinition presented","");
		}
		
		if(taskDefinition != null && !StringUtils.isBlank(taskName)) {
			throw new IllegalArgumentFault("error - Error while creating LeanTask", "both taskDefinition and taskName presented");
		}
		
		if(taskDefinition != null && StringUtils.isBlank(taskDefinition.getName())) {
			throw new IllegalArgumentFault("error - Error while creating LeanTask", "taskDefinition has no name");
		}
		
		
		if(!StringUtils.isBlank(taskName)) {
			if(repositoryService.checkIfLeanTaskDefinitionWithNameExists(taskName)) {
				try {
					LeanTask leanTask = repositoryService.getLeanTaskDefinitionByName(taskName);
					taskModel.processLeanTaskDefinitionAndCreate(inputMessage.getAny(), leanTask);
				} catch (WSHTException e) {
					throw new IllegalArgumentFault("error - Error while creating LeanTask", e.getMessage());
				} catch(Throwable t) {
					throw new IllegalAccessFault("error - Register Lean Task Definition", t.getMessage());
				}
	
			} else {
				throw new IllegalArgumentFault("error - Error while creating LeanTask", "Task Definition with given name " + taskName + " not exists.");
			}
			
		} else {
			String localTaskName = taskDefinition.getName();
			if(repositoryService.checkIfLeanTaskDefinitionWithNameExists(localTaskName)) {
				throw new IllegalArgumentFault("error - Lean Task definition with name: " + localTaskName + " exists", "");
			}
			
			try {
				LeanTask leanTask = beanMapper.map(taskDefinition, LeanTask.class);
				taskModel.processLeanTaskDefinitionAndCreate(inputMessage.getAny(), leanTask);
			} catch (WSHTException e) {
				throw new IllegalAccessFault("error - Register Lean Task Definition", e.getMessage());
			} catch(Throwable t) {
				throw new IllegalAccessFault("error - Register Lean Task Definition", t.getMessage());
			}
		}
		
		//odbieranie Response od klienta
		
		OutputMessage outputMessage = new OutputMessage();
		outputMessage.setAny(ObjectPreparator.getResponseObject());
		return outputMessage;
	}
	

	@SuppressWarnings("unchecked")
	public void createLeanTaskAsync(CreateLeanTaskAsync.InputMessage inputMessage,
			TLeanTask taskDefinition, String taskName)
			throws IllegalAccessFault, IllegalArgumentFault {
		
			  System.out.println("createLeanTaskAsync");

		      try {
		    	 
		  		 if(repositoryService.checkIfLeanTaskDefinitionWithNameExists(taskName)) {
		  			throw new IllegalStateFault("error - Lean Task definition with name: " + taskName + " exists", new IllegalState());
		  		 }
		  		 
		    	 LeanTask leanTask = beanMapper.map(taskDefinition, LeanTask.class);
		    	 
		    	 taskModel.processLeanTaskDefinitionAsync(leanTask);
		    	 
		    	
		    	 
		    	 MessageContext requestContext = context.getMessageContext();
		    	  
		    	 AddressingProperties mapsIn = (AddressingProperties) requestContext.get(JAXWSAConstants.CLIENT_ADDRESSING_PROPERTIES_INBOUND);
				 String messageId = mapsIn.getMessageID().getValue();
			     String replyTo = mapsIn.getReplyTo().getAddress().getValue();
			    
			     
		         Service service = Service.create(new URL(replyTo + "?wsdl"),
		                                          	new QName("http://leantask.webservice.infrastructure.wsht/", 
		                                        		  "LeanTaskCallbackOperationsImplService"));
		         Object callbackPort = service.getPort(new QName("http://leantask.webservice.infrastructure.wsht/", 
		        		 										 "LeanTaskCallbackOperationsImplPort"),
		        		 										 PublicProtocolConfiguration.getLeanTaskCallbackOperationInterface(), 
		        		 										 new OneWayFeature());
		         
		         

		    	 ObjectFactory wsaObjectFactory = new ObjectFactory();
		    	 AddressingBuilder builder = AddressingBuilder.getAddressingBuilder();
		    	 AddressingProperties mapsOut = builder.newAddressingProperties();
		    	 // set Action property
		    	 AttributedURIType soapAction = wsaObjectFactory.createAttributedURIType();
		    	 soapAction.setValue("createLeanTaskAsyncCallback");        
		    	 mapsOut.setAction(soapAction); 
		    	 RelatesToType relatesTo = wsaObjectFactory.createRelatesToType();
		    	 relatesTo.setValue(messageId);
		    	 mapsOut.setRelatesTo(relatesTo);
	
		    	 // associate MAPs with request context
		    	 BindingProvider bindingProvider = (BindingProvider) callbackPort;
		    	 Map<String, Object> requestContextOutbound = bindingProvider.getRequestContext();
		    	 requestContextOutbound.put(JAXWSAConstants.CLIENT_ADDRESSING_PROPERTIES_OUTBOUND, mapsOut);

		         org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskAsyncCallback.OutputMessage outputMessage 
		         		= new org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskAsyncCallback.OutputMessage();
		         //callbackPort.createLeanTaskAsyncCallback(outputMessage);
		         ReflectionUtils.invokeMethod(callbackPort, PublicProtocolConfiguration.getLeanTaskCallbackOperationInterface().getMethods()[0], outputMessage);
		      } catch (Exception e) {
		    	 LOGGER.error("error - Error while calling callback operation.", e);
		         throw new WebServiceException(e);
		      }
	}

		
	@Resource
    public void setContext(WebServiceContext context) {
        this.context = context;
    }

	
}
