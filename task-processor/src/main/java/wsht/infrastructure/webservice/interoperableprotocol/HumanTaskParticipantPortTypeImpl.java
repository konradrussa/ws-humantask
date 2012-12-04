package wsht.infrastructure.webservice.interoperableprotocol;

import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

import org.oasis_open.docs.ns.bpel4people.ws_humantask.protocol._200803.HumanTaskParticipantPortType;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.protocol._200803.TProtocolMsgType;

@WebService(endpointInterface="org.oasis_open.docs.ns.bpel4people.ws_humantask.protocol._200803.HumanTaskParticipantPortType")
@Addressing
public class HumanTaskParticipantPortTypeImpl implements HumanTaskParticipantPortType {

	public void exitOperation(TProtocolMsgType parameters) {

	}

}
