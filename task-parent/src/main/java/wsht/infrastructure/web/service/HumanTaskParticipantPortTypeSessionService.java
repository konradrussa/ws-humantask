package wsht.infrastructure.web.service;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.protocol._200803.HumanTaskParticipantPortType;

public class HumanTaskParticipantPortTypeSessionService implements SessionService {

	private String endpoint;
	private HumanTaskParticipantPortType service;
	private Bus bus;

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	public HumanTaskParticipantPortType getService() {
		return service;
	}

	public void setService(HumanTaskParticipantPortType service) {
		this.service = service;
	}
	
	public String getEndpoint() {
		return endpoint;
	}
	
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
		if(service == null) {
			JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
			bean.setBus(bus);
			bean.setServiceClass(HumanTaskParticipantPortType.class);
			bean.setAddress(endpoint);
			service = (HumanTaskParticipantPortType) bean.create();
			((BindingProvider)service).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
		}
	}
	
	
}
