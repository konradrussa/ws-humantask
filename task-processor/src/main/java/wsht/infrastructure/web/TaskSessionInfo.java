package wsht.infrastructure.web;

import wsht.infrastructure.domain.entity.UserSession;

public class TaskSessionInfo extends SessionInfo {
	
	private UserSession userSession;

	public UserSession getUserSession() {
		return userSession;
	}

	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}
	
	

}
