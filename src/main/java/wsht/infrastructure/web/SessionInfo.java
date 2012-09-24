package wsht.infrastructure.web;

import wsht.infrastructure.domain.entity.UserSession;


public class SessionInfo {

	private UserInfo userInfo;
	private UserSession userSession;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public UserSession getUserSession() {
		return userSession;
	}

	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}
	
	
	 
}
