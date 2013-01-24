package wsht.infrastructure.web.service;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.oasis_open.docs.ws_tx.wscoor._2006._06.ActivationPortType;


public class ActivationSessionService implements SessionService {

	private String endpoint;
	private ActivationPortType service;
	private Bus bus;
	
	
	public ActivationPortType getService() {
		return service;
	}

	public void setService(ActivationPortType service) {
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
			bean.setServiceClass(ActivationPortType.class);
			bean.setAddress(endpoint);
			service = (ActivationPortType) bean.create();
			((BindingProvider)service).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
		}
	}	

}

