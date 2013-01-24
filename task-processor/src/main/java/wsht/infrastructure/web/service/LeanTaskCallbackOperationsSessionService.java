package wsht.infrastructure.web.service;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.LeanTaskCallbackOperations;
import org.springframework.beans.factory.FactoryBean;

public class LeanTaskCallbackOperationsSessionService implements SessionService {

	private String endpoint;
	private LeanTaskCallbackOperations service;
	private Bus bus;
	private Class[] externalContextObjects;
	
	public LeanTaskCallbackOperations getService() {
		return service;
	}

	public void setService(LeanTaskCallbackOperations service) {
		this.service = service;
	}
	
	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Class[] getExternalContextObjects() {
		return externalContextObjects;
	}

	public void setExternalContextObjects(Class[] externalContextObjects) {
		this.externalContextObjects = externalContextObjects;
	}

	public void setEndpoint(String endpoint) throws Exception {
		this.endpoint = endpoint;
		if(service == null) {
			JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
			
			Map props = bean.getProperties();
			if (props == null) { props = new HashMap<String, Object>(); }
			props.put("jaxb.additionalContextClasses", externalContextObjects);
			props.put("mtom-enabled", true);
			bean.setProperties(props);
			
			bean.setBus(bus);
			bean.setServiceClass(LeanTaskCallbackOperations.class);
			bean.setAddress(endpoint);
			service = (LeanTaskCallbackOperations) bean.create();
			((BindingProvider)service).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
		}
	}	
}