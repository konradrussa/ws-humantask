package wsht.infrastructure.web.interceptor;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.jaxws.JaxWsClientProxy;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import wsht.infrastructure.web.service.SessionService;

public class JSessionIdInterceptor extends AbstractPhaseInterceptor<Message> {
	
	private List<SessionService> services;

	public JSessionIdInterceptor() {
		super(Phase.PRE_LOGICAL);
	}

	@SuppressWarnings("unchecked")
	public void handleMessage(Message message) throws Fault {
		Map<String, Object> headers = (Map<String, Object>) message.getContextualProperty(Message.PROTOCOL_HEADERS);
		Collection<String> object = (Collection<String>) headers.get("Set-Cookie");
		if (object == null) return;
		for(SessionService service : services){
			Client cxfClient = JaxWsClientProxy.getClient(service.getService());
			HTTPClientPolicy policy = ((HTTPConduit) cxfClient.getConduit()).getClient();
			if (policy == null) {
				policy = new HTTPClientPolicy();
				((HTTPConduit) cxfClient.getConduit()).setClient(policy);
			}
			policy.setCookie(object.toArray(new String[0])[0]);
		}
		return;
	}
	
	/**
	 * Gettery i Settery
	 */
	public List<SessionService> getServices() {
		return services;
	}
	public void setServices(List<SessionService> services) {
		this.services = services;
	}
}
