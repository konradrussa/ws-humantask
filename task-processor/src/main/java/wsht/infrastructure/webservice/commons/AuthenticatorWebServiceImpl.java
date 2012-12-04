package wsht.infrastructure.webservice.commons;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.web.session.HttpSessionCreatedEvent;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import wsht.infrastructure.repository.IUserSessionRepository;
import wsht.infrastructure.web.UserInfo;
import wsht.infrastructure.webservice.WSHTService;
import wsht.infrastructure.webservice.exceptions.WSHTWebServiceException;

public class AuthenticatorWebServiceImpl extends WSHTService implements AuthenticatorWebService, ApplicationListener {
	
	@Resource
	private WebServiceContext wsContext;
	
	@Resource
	private IUserSessionRepository userSessionRepository;
	

	
	public UserInfo logIn(UserInfo userInfo) throws WSHTWebServiceException {
		MessageContext messageContext = wsContext.getMessageContext();
		userInfo.setLoggedIn(true);
		sessionInfo.setUserInfo(userInfo);
		String sessionId = RequestContextHolder.getRequestAttributes().getSessionId();
		getUsersMap().put(sessionId, sessionInfo.getUserInfo().getUserName());
		return userInfo;
	}

	
	public void logOut() throws WSHTWebServiceException {
		
		String sessionId = RequestContextHolder.getRequestAttributes().getSessionId();
		this.getUsersMap().remove(sessionId);
		
		if(sessionInfo.getUserInfo() != null && sessionInfo.getUserInfo().getLoggedIn()) {
			sessionInfo.setUserInfo(null);
			((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().invalidate();
			
		}
	}
	
	
	public boolean checkLoggedIn() throws WSHTWebServiceException {
		return (sessionInfo.getUserInfo() != null && sessionInfo.getUserInfo().getLoggedIn());
	}
	
	public boolean checkCurrentUser(UserInfo userInfo)throws WSHTWebServiceException {
		return (sessionInfo.getUserInfo() != null && sessionInfo.getUserInfo().equals(userInfo));
	}

	public void onApplicationEvent(ApplicationEvent event) {

		if(event instanceof HttpSessionCreatedEvent){
			HttpSession session = ((HttpSessionCreatedEvent) event).getSession();
			System.out.println("SessionCreatedEvent, session:"+session.getId());
		}
		if(event instanceof HttpSessionDestroyedEvent){
			HttpSession session = ((HttpSessionDestroyedEvent) event).getSession();
			session.getId();
			this.getUsersMap().remove(session.getId());
			System.out.println("SessionDestroyedEvent, session:"+session.getId());
		}
	}
	
	

}
