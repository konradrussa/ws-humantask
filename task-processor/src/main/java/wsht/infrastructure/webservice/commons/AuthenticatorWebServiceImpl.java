package wsht.infrastructure.webservice.commons;

import java.util.UUID;

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

import wsht.exception.WSHTException;
import wsht.infrastructure.domain.entity.UserEntityInfo;
import wsht.infrastructure.repository.IUserEntityInfoRepository;
import wsht.infrastructure.repository.IUserSessionRepository;
import wsht.infrastructure.service.IRepositoryService;
import wsht.infrastructure.web.UserInfo;
import wsht.infrastructure.webservice.WSHTService;
import wsht.infrastructure.webservice.exceptions.WSHTWebServiceException;

public class AuthenticatorWebServiceImpl extends WSHTService implements AuthenticatorWebService, ApplicationListener {
	
	@Resource
	private WebServiceContext wsContext;
	
	@Resource
	private IRepositoryService repositoryService;

	
	public UserInfo logIn(UserInfo userInfo) throws WSHTWebServiceException {
		
		try {
			UserEntityInfo userEntityInfo = repositoryService.getUserEntity(userInfo.getUserName(), userInfo.getPassword());
			userInfo.setLoggedIn(true);
			getSessionInfo().setUserInfo(userInfo);
			
			//String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
			//getUsersMap().put(UUID.randomUUID().toString().substring(0,6), getSessionInfo().getUserInfo().getUserName());
		} catch (WSHTException e) {
			throw new WSHTWebServiceException(e.getMessage());
		}
		
		return userInfo;
	}

	
	public void logOut() throws WSHTWebServiceException {
		
		//String sessionId = RequestContextHolder.getRequestAttributes().getSessionId();
		//this.getUsersMap().remove(sessionId);
		
		if(getSessionInfo().getUserInfo() != null && getSessionInfo().getUserInfo().getLoggedIn()) {
			getSessionInfo().setUserInfo(null);
			//((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().invalidate();
			
		}
	}
	
	
	public boolean checkLoggedIn() throws WSHTWebServiceException {
		return (getSessionInfo().getUserInfo() != null && getSessionInfo().getUserInfo().getLoggedIn());
	}
	
	public boolean checkCurrentUser(UserInfo userInfo)throws WSHTWebServiceException {
		return (getSessionInfo().getUserInfo() != null && getSessionInfo().getUserInfo().equals(userInfo));
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
