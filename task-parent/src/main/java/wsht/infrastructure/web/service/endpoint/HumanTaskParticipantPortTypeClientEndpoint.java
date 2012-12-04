package wsht.infrastructure.web.service.endpoint;

import org.oasis_open.docs.ns.bpel4people.ws_humantask.protocol._200803.HumanTaskParticipantPortType;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.protocol._200803.TProtocolMsgType;

import wsht.infrastructure.web.service.HumanTaskParticipantPortTypeSessionService;

public class HumanTaskParticipantPortTypeClientEndpoint implements HumanTaskParticipantPortType {

	private HumanTaskParticipantPortTypeSessionService service;
	
	public void exitOperation(TProtocolMsgType parameters) {
		service.getService().exitOperation(parameters);
	}

	public HumanTaskParticipantPortTypeSessionService getService() {
		return service;
	}

	public void setService(HumanTaskParticipantPortTypeSessionService service) {
		this.service = service;
	}
}
