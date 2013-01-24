package wsht.infrastructure.webservice.interoperableprotocol;

import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

import org.oasis_open.docs.ns.bpel4people.ws_humantask.protocol._200803.ClientParticipantPortType;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.protocol._200803.TProtocolMsgType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebService(endpointInterface="org.oasis_open.docs.ns.bpel4people.ws_humantask.protocol._200803.ClientParticipantPortType")
@Addressing(enabled=true,required=true)
public class ClientParticipantPortTypeImpl implements ClientParticipantPortType {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientParticipantPortTypeImpl.class);

	public void skippedOperation(TProtocolMsgType parameters) {
		LOGGER.debug("!!! task skipped !!!");

	}

	public void faultOperation(TProtocolMsgType parameters) {
		LOGGER.debug("!!! task fault !!!");
	}

}
