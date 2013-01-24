package wsht.infrastructure.web.service.endpoint;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;

import org.oasis_open.docs.ws_tx.wscoor._2006._06.ActivationPortType;
import org.oasis_open.docs.ws_tx.wscoor._2006._06.CreateCoordinationContextResponseType;
import org.oasis_open.docs.ws_tx.wscoor._2006._06.CreateCoordinationContextType;
import org.oasis_open.docs.ws_tx.wscoor._2006._06.RegisterResponseType;
import org.oasis_open.docs.ws_tx.wscoor._2006._06.RegisterType;
import org.oasis_open.docs.ws_tx.wscoor._2006._06.RegistrationPortType;

import wsht.infrastructure.web.SessionInfo;
import wsht.infrastructure.web.service.ActivationSessionService;
import wsht.infrastructure.web.service.RegistrationSessionService;

public class CoordinationClientEndpoint implements ActivationPortType, RegistrationPortType {

	private SessionInfo sessionInfo;
	private ActivationSessionService activationSessionService;
	private RegistrationSessionService registrationSessionService;
	
	@Resource
	private WebServiceContext context;
	
	public RegisterResponseType registerOperation(RegisterType parameters) {
		return registrationSessionService.getService().registerOperation(parameters);
	}

	public CreateCoordinationContextResponseType createCoordinationContextOperation(CreateCoordinationContextType parameters) {
		return activationSessionService.getService().createCoordinationContextOperation(parameters);
	}

	//S & G
	
	public SessionInfo getSessionInfo() {
		return sessionInfo;
	}

	public void setSessionInfo(SessionInfo sessionInfo) {
		this.sessionInfo = sessionInfo;
	}

	public ActivationSessionService getActivationSessionService() {
		return activationSessionService;
	}

	public void setActivationSessionService(
			ActivationSessionService activationSessionService) {
		this.activationSessionService = activationSessionService;
	}

	public RegistrationSessionService getRegistrationSessionService() {
		return registrationSessionService;
	}

	public void setRegistrationSessionService(
			RegistrationSessionService registrationSessionService) {
		this.registrationSessionService = registrationSessionService;
	}

	
	
}
