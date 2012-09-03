package wsht.infrastructure.webservice.interoperableprotocol;

import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

import org.oasis_open.docs.ns.bpel4people.ws_humantask.protocol._200803.ClientParticipantPortType;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.protocol._200803.TProtocolMsgType;

@WebService(endpointInterface="org.oasis_open.docs.ns.bpel4people.ws_humantask.protocol._200803.ClientParticipantPortType")
@Addressing
public class ClientParticipantPortTypeImpl implements ClientParticipantPortType {

	@Override
	public void skippedOperation(TProtocolMsgType parameters) {

	}

	@Override
	public void faultOperation(TProtocolMsgType parameters) {

	}

}
