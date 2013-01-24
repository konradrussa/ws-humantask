package wsht.infrastructure.web.service;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.oasis_open.docs.ws_tx.wscoor._2006._06.RegistrationPortType;

public class RegistrationSessionService implements SessionService {

	private String endpoint;
	private RegistrationPortType service;
	private Bus bus;
	
	
	public RegistrationPortType getService() {
		return service;
	}

	public void setService(RegistrationPortType service) {
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
			bean.setServiceClass(RegistrationPortType.class);
			bean.setAddress(endpoint);
			service = (RegistrationPortType) bean.create();
			((BindingProvider)service).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
		}
	}	

}

