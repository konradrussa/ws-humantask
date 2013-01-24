package wsht.infrastructure.web.service;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.ws.addressing.AddressingBuilder;
import org.apache.cxf.ws.addressing.AddressingProperties;
import org.apache.cxf.ws.addressing.AttributedURIType;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.apache.cxf.ws.addressing.JAXWSAConstants;
import org.apache.cxf.ws.addressing.ObjectFactory;
import org.apache.cxf.ws.addressing.ReferenceParametersType;
import org.apache.cxf.ws.addressing.WSAddressingFeature;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.LeanTaskOperations;
import org.springframework.beans.factory.FactoryBean;

public class LeanTaskOperationsSessionService implements SessionService {

	private String endpoint;
	private String callbackEndpoint;
	private LeanTaskOperations service;
	private Bus bus;
	private Class[] externalContextObjects;
	
	public LeanTaskOperations getService() {
		return service;
	}

	public void setService(LeanTaskOperations service) {
		this.service = service;
	}

	public String getEndpoint() {
		return endpoint;
	}
	
	public void setCallbackEndpoint(String callbackEndpoint) {
		this.callbackEndpoint = callbackEndpoint;
	}
	
	public String getCallbackEndpoint() {
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

	public void setEndpoint(String endpoint) throws Exception {
		this.endpoint = endpoint;
		if(service == null) {
			JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
			WSAddressingFeature addressingFeature = new WSAddressingFeature();
			bean.getFeatures().add(addressingFeature);
			addressingFeature.setAddressingRequired(true);
			
			Map props = bean.getProperties();
			if (props == null) { props = new HashMap<String, Object>(); }
			props.put("jaxb.additionalContextClasses", object.ClaimApprovalRequest.class);
			bean.setProperties(props);
			
			bean.setBus(bus);
			bean.setServiceClass(LeanTaskOperations.class);
			bean.setAddress(endpoint);
			
			service = (LeanTaskOperations) bean.create();
			
		}
	}
	
	public void setUpAddressingProperties() {
		ObjectFactory wsaObjectFactory = new ObjectFactory();
		AddressingBuilder builder = AddressingBuilder.getAddressingBuilder();
		AddressingProperties maps = builder.newAddressingProperties();
		AttributedURIType messageId = wsaObjectFactory.createAttributedURIType();
		messageId.setValue("messageId:"+System.currentTimeMillis());
		maps.setMessageID(messageId);
		EndpointReferenceType replyToRef = wsaObjectFactory.createEndpointReferenceType();
		AttributedURIType replyTo = wsaObjectFactory.createAttributedURIType();
		replyTo.setValue(callbackEndpoint);
		replyToRef.setAddress(replyTo);
		ReferenceParametersType referenceParametersType = wsaObjectFactory.createReferenceParametersType();
		replyToRef.setReferenceParameters(referenceParametersType);
		maps.setReplyTo(replyToRef);
		// associate MAPs with request context
		Map<String, Object> requestContext = ((BindingProvider) service).getRequestContext();
		requestContext.put(JAXWSAConstants.CLIENT_ADDRESSING_PROPERTIES, maps);
		requestContext.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
	}
}