package wsht.infrastructure.webservice.coordinator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.wsaddressing.W3CEndpointReference;
import javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder;

import org.oasis_open.docs.ws_tx.wscoor._2006._06.ActivationPortType;
import org.oasis_open.docs.ws_tx.wscoor._2006._06.CreateCoordinationContextResponseType;
import org.oasis_open.docs.ws_tx.wscoor._2006._06.CreateCoordinationContextType;
import org.oasis_open.docs.ws_tx.wscoor._2006._06.Expires;
import org.oasis_open.docs.ws_tx.wscoor._2006._06.RegisterResponseType;
import org.oasis_open.docs.ws_tx.wscoor._2006._06.RegisterType;
import org.oasis_open.docs.ws_tx.wscoor._2006._06.RegistrationPortType;

import com.sun.xml.ws.api.message.HeaderList;
import com.sun.xml.ws.developer.JAXWSProperties;

import wsht.infrastructure.webservice.WSHTService;

@Addressing(enabled = true, required=true)
public class CoordinationServiceWebServiceImpl extends WSHTService 
					implements ActivationPortType, RegistrationPortType {
	
	@Resource
    private WebServiceContext context;

	public CreateCoordinationContextResponseType createCoordinationContextOperation(
			CreateCoordinationContextType parameters) {
		
		System.out.println("CoordinationServiceWebServiceImpl: createCoordinationContextOperation START");
		
		Expires expires = parameters.getExpires();
		CreateCoordinationContextType.CurrentContext currentContext = parameters.getCurrentContext();
		String coordinationType = parameters.getCoordinationType();
		List<Object> any = parameters.getAny();
		Map<QName, String> otherAttributes = parameters.getOtherAttributes();
		
		//processing
		CreateCoordinationContextResponseType contextResponseType = new CreateCoordinationContextResponseType();
		
		System.out.println("CoordinationServiceWebServiceImpl: createCoordinationContextOperation END");
		return contextResponseType;
	}

	public RegisterResponseType registerOperation(RegisterType parameters) {
		
		System.out.println("CoordinationServiceWebServiceImpl: registerOperation START");
		
		String protocolIdentifier = parameters.getProtocolIdentifier();
	    W3CEndpointReference participantProtocolService = parameters.getParticipantProtocolService();
	    List<Object> any = parameters.getAny();
	    Map<QName, String> otherAttributes = parameters.getOtherAttributes();
		
	    //processing
	    RegisterResponseType responseType = new RegisterResponseType();
	    
	    // Create the builder object
        W3CEndpointReferenceBuilder builder = new W3CEndpointReferenceBuilder();

        // Modify builder properties
        builder.address("");
        

        W3CEndpointReference epr = builder.build();
        responseType.setCoordinatorProtocolService(epr);
        
        System.out.println("CoordinationServiceWebServiceImpl: registerOperation END");
	    
		return responseType;
	}

}
