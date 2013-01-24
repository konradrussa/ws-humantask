package wsht.infrastructure.webservice.handlers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.oasis_open.docs.ns.bpel4people.ws_humantask.context._200803.THumanTaskRequestContext;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.context._200803.THumanTaskResponseContext;
import org.springframework.stereotype.Component;

import wsht.marshalling.JAXBUtilBean;
import wsht.marshalling.exception.WSHTMarshallingException;

public class ContextHandler implements SOAPHandler<SOAPMessageContext> {

	
	public boolean handleMessage(SOAPMessageContext context) {

		Boolean outMessageIndicator = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if (outMessageIndicator.booleanValue()) {
			try {
				SOAPEnvelope envelope = context.getMessage().getSOAPPart().getEnvelope();
				SOAPFactory factory = SOAPFactory.newInstance();
				String prefix = "X";
                String uri = "http://openvoid";
				SOAPElement el = factory.createElement("coord", prefix, uri);
				THumanTaskResponseContext humanTaskResponseContext = new THumanTaskResponseContext();
				humanTaskResponseContext.setOutcome(null);
				humanTaskResponseContext.setActualPeopleAssignments(null);
				humanTaskResponseContext.setAttachments(null);
				humanTaskResponseContext.setPriority(null);
				humanTaskResponseContext.setActualOwner(null);
				humanTaskResponseContext.getAny();
				el.addTextNode(new JAXBUtilBean().marshal(humanTaskResponseContext));
				SOAPHeader header = envelope.addHeader();
                header.addChildElement(el);
			} catch (SOAPException e) {
				e.printStackTrace();
			} catch (WSHTMarshallingException e) {
				e.printStackTrace();
			}
		} else {
			// inbound
			try {
				SOAPEnvelope envelope = context.getMessage().getSOAPPart().getEnvelope();
				Iterator<? extends SOAPElement> it = envelope.getHeader().getChildElements();
				while(it.hasNext()) {
					SOAPElement obj = it.next();
					THumanTaskRequestContext humanTaskRequestContext = new THumanTaskRequestContext();
					humanTaskRequestContext.getActivationDeferralTime();
					humanTaskRequestContext.getAny();
					humanTaskRequestContext.getAttachments();
					humanTaskRequestContext.getExpirationTime();
					humanTaskRequestContext.getPeopleAssignments();
					humanTaskRequestContext.getPriority();
				}
				
			} catch (SOAPException e) {
				e.printStackTrace();
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
		HashSet<QName> headers = new HashSet<QName>();
		QName securityHeader1 = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/protocol/200803/", "Human Task Protocol Participants", "htp");
		headers.add(securityHeader1);
		QName securityHeader2 = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/context/200803/", "Human Task Context for Task Interactions", "htc");
        headers.add(securityHeader2);
        return headers;
	}

}
