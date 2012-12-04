package wsht.infrastructure.web.service;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.LeanTaskCallbackOperations;

public class LeanTaskCallbackOperationsSessionService implements SessionService {

	private String endpoint;
	private LeanTaskCallbackOperations service;
	private Bus bus;
	
	
	public LeanTaskCallbackOperations getService() {
		return service;
	}

	public void setService(LeanTaskCallbackOperations service) {
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
			bean.setServiceClass(LeanTaskCallbackOperations.class);
			bean.setAddress(endpoint);
			service = (LeanTaskCallbackOperations) bean.create();
			((BindingProvider)service).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
		}
	}	
}