package wsht.infrastructure.webservice.commons;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import wsht.infrastructure.web.SessionInfo;
import wsht.infrastructure.web.UserInfo;
import wsht.infrastructure.webservice.exceptions.WSHTWebServiceException;

public class AuthenticatorWebServiceImpl implements AuthenticatorWebService {
	
	@Resource
	private WebServiceContext wsContext;
	
	private SessionInfo sessionInfo;

	@Override
	public UserInfo logIn(UserInfo userInfo) throws WSHTWebServiceException {
//		MessageContext mc = wsContext.getMessageContext();
//		HttpSession session = ((javax.servlet.http.HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST)).getSession();
//		if (session == null) {
//		System.out.println("Starting the Session");
//		} 
		userInfo.setLoggedIn(true);
		sessionInfo.setUserInfo(userInfo);
		return userInfo;
	}

	@Override
	public void logOut() throws WSHTWebServiceException {
		if(sessionInfo.getUserInfo() != null && sessionInfo.getUserInfo().getLoggedIn()) {
			sessionInfo.setUserInfo(null);
			((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().invalidate();
			
		}
	}
	
	@Override
	public boolean checkLoggedIn() throws WSHTWebServiceException {
		return (sessionInfo.getUserInfo() != null && sessionInfo.getUserInfo().getLoggedIn());
	}
	
	@Override
	public boolean checkCurrentUser(UserInfo userInfo)throws WSHTWebServiceException {
		return (sessionInfo.getUserInfo() != null && sessionInfo.getUserInfo().equals(userInfo));
	}

	public SessionInfo getSessionInfo() {
		return sessionInfo;
	}

	public void setSessionInfo(SessionInfo sessionInfo) {
		this.sessionInfo = sessionInfo;
	}


	
	

}
