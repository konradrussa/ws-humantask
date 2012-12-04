package wsht.infrastructure.web.service;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import wsht.infrastructure.webservice.commons.AuthenticatorWebService;

public class AuthenticationSessionService  implements SessionService {

	private String endpoint;
	private AuthenticatorWebService service;
	private Bus bus;
	
	
	public AuthenticatorWebService getService() {
		return service;
	}

	public void setService(AuthenticatorWebService service) {
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
			bean.setServiceClass(AuthenticatorWebService.class);
			bean.setAddress(endpoint);
			service = (AuthenticatorWebService) bean.create();
			((BindingProvider)service).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
		}
	}	

}

