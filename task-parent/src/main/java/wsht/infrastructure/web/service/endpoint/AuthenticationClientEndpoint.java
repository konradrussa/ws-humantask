package wsht.infrastructure.web.service.endpoint;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import wsht.infrastructure.web.SessionInfo;
import wsht.infrastructure.web.UserInfo;
import wsht.infrastructure.web.service.AuthenticationSessionService;
import wsht.infrastructure.webservice.commons.AuthenticatorWebService;
import wsht.infrastructure.webservice.exceptions.WSHTWebServiceException;

public class AuthenticationClientEndpoint implements AuthenticatorWebService {

	private SessionInfo sessionInfo;
	private AuthenticationSessionService service;
	
	@Override
	public UserInfo logIn(UserInfo userInfo) throws WSHTWebServiceException {
		UserInfo uInfo = service.getService().logIn(userInfo);
		sessionInfo.setUserInfo(uInfo);
		return uInfo;
	}

	@Override
	public void logOut() throws WSHTWebServiceException {
		service.getService().logOut();
		((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().invalidate();
		
	}
	
	@Override
	public boolean checkCurrentUser(UserInfo userInfo) throws WSHTWebServiceException {
		return service.getService().checkCurrentUser(userInfo);
	}
	
	@Override
	public boolean checkLoggedIn() throws WSHTWebServiceException {
		return service.getService().checkLoggedIn();
		
	}
	
	

	public AuthenticationSessionService getService() {
		return service;
	}

	public void setService(AuthenticationSessionService service) {
		this.service = service;
	}

	public SessionInfo getSessionInfo() {
		return sessionInfo;
	}

	public void setSessionInfo(SessionInfo sessionInfo) {
		this.sessionInfo = sessionInfo;
	}
	
	
	
}
