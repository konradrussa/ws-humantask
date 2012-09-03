package wsht.infrastructure.webservice.handlers;

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

import org.oasis_open.docs.ns.bpel4people.ws_humantask.context._200803.THumanTaskResponseContext;

import wsht.marshalling.JAXBUtilBean;
import wsht.marshalling.exception.WSHTException;

public class ContextHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {

		Boolean outMessageIndicator = (Boolean) context
				.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if (outMessageIndicator.booleanValue()) {
			try {
				SOAPEnvelope envelope = context.getMessage().getSOAPPart().getEnvelope();
				SOAPFactory factory = SOAPFactory.newInstance();
				String prefix = "X";
                String uri = "http://openvoid";
				SOAPElement el = factory.createElement("coord", prefix, uri);
				el.addTextNode(new JAXBUtilBean().marshal(new THumanTaskResponseContext()));
				SOAPHeader header = envelope.addHeader();
                header.addChildElement(el);
			} catch (SOAPException e) {
				e.printStackTrace();
			} catch (WSHTException e) {
				e.printStackTrace();
			}

		} else {
			// inbound
		}

		return false;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// continue processing
		return true;
	}

	@Override
	public void close(MessageContext context) {

	}

	@Override
	public Set<QName> getHeaders() {
		//http://docs.oasis-open.org/ns/bpel4people/ws-humantask/protocol/200803 htcp
		//http://docs.oasis-open.org/ns/bpel4people/ws-humantask/context/200803 htc
		return null;
	}

}
