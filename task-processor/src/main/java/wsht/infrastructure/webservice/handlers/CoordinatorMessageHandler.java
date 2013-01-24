package wsht.infrastructure.webservice.handlers;

import java.net.URL;
import java.util.Set;

import javax.jws.WebService;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.Addressing;
import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sun.xml.ws.api.SOAPVersion;
import com.sun.xml.ws.api.addressing.AddressingVersion;
import com.sun.xml.ws.api.addressing.OneWayFeature;
import com.sun.xml.ws.api.addressing.WSEndpointReference;
import com.sun.xml.ws.api.message.HeaderList;
import com.sun.xml.ws.api.message.Headers;
import com.sun.xml.ws.developer.JAXWSProperties;
import com.sun.xml.ws.developer.WSBindingProvider;

import wsht.infrastructure.webservice.programminginterface.TaskOperationsImpl;

public class CoordinatorMessageHandler implements SOAPHandler<SOAPMessageContext> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CoordinatorMessageHandler.class);

	
	public boolean handleMessage(SOAPMessageContext context) {

		Boolean outMessageIndicator = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if (outMessageIndicator.booleanValue()) {
			
		} else {
			// inbound
			MessageContext ctx = (MessageContext)context;
			HeaderList hl = (HeaderList) ctx.get(JAXWSProperties.INBOUND_HEADER_LIST_PROPERTY);
			WSEndpointReference reference = hl.getReplyTo(AddressingVersion.W3C, SOAPVersion.SOAP_11);
			String messageId = hl.getMessageID(AddressingVersion.W3C, SOAPVersion.SOAP_11);
			String callbackAddress = reference.getAddress();
			LOGGER.info("Received message id: " + messageId);
			LOGGER.info("Received callback address: " + callbackAddress);
				 
			// Process something...
				 
			// Send response...
			try {
			    Service service = Service.create(new URL(reference.getAddress() + "?WSDL"),
			                                       new QName("http://lantoniak.edu/wsaddressing/service", "svSampleCallback"));
			    /*SampleCallback callbackPort = service.getPort(new QName("http://lantoniak.edu/wsaddressing/service", "prSampleCallback"),
			                                                     SampleCallback.class, new OneWayFeature());
			    WSBindingProvider bindingProvider = (WSBindingProvider) callbackPort;
			    bindingProvider.setAddress(reference.getAddress());
			    bindingProvider.setOutboundHeaders(Headers.create(AddressingVersion.W3C.relatesToTag, messageId));
			    bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, reference.getAddress());
				 
			    callbackPort.reviewAccountDetails(account);*/
			} catch (Exception e) {
			 	  LOGGER.error("Error while calling callback operation.", e);
			      throw new WebServiceException(e);
			}
		}
		
		// true continue processing
		return true;
	}

	
	public boolean handleFault(SOAPMessageContext context) {
		// true continue processing
		return true;
	}

	
	public void close(MessageContext context) {}

	
	public Set<QName> getHeaders() {
        return null;
	}

}
