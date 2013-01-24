package wsht.infrastructure.web.service;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.ws.addressing.WSAddressingFeature;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.TaskOperations;

public class TaskOperationsSessionService implements SessionService {

	private String endpoint;
	private TaskOperations service;
	private Bus bus;
	private Class[] externalContextObjects;
	
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
	
	public Class[] getExternalContextObjects() {
		return externalContextObjects;
	}

	public void setExternalContextObjects(Class[] externalContextObjects) {
		this.externalContextObjects = externalContextObjects;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
		if(service == null) {
			JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
			WSAddressingFeature addressingFeature = new WSAddressingFeature();
			bean.getFeatures().add(addressingFeature);
			addressingFeature.setAddressingRequired(true);
			
			Map props = bean.getProperties();
			if (props == null) { props = new HashMap<String, Object>(); }
			props.put("jaxb.additionalContextClasses", object.ClaimApprovalResponse.class);
			bean.setProperties(props);
			
			bean.setBus(bus);
			bean.setServiceClass(TaskOperations.class);
			bean.setAddress(endpoint);
			service = (TaskOperations) bean.create();
			((BindingProvider)service).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
		}
	}	

}
