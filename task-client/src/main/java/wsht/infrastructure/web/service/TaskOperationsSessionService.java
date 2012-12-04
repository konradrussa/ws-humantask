package wsht.infrastructure.web.service;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.TaskOperations;

public class TaskOperationsSessionService implements SessionService {

	private String endpoint;
	private TaskOperations service;
	private Bus bus;
	
	
	public TaskOperations getService() {
		return service;
	}

	public void setService(TaskOperations service) {
		this.service = service;
	}

	public String getEndpoint() {
		return endpoint;
	}

	
	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
		if(service == null) {
			JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
			bean.setBus(bus);
			bean.setServiceClass(TaskOperations.class);
			bean.setAddress(endpoint);
			service = (TaskOperations) bean.create();
			((BindingProvider)service).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
		}
	}	

}
