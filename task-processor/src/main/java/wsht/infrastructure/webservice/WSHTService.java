package wsht.infrastructure.webservice;

import wsht.infrastructure.web.CurrentUsersMap;
import wsht.infrastructure.web.SessionInfo;

public abstract class WSHTService {

	protected SessionInfo sessionInfo;
	protected CurrentUsersMap usersMap;
	
	public SessionInfo getSessionInfo() {
		return sessionInfo;
	}
	public void setSessionInfo(SessionInfo sessionInfo) {
		this.sessionInfo = sessionInfo;
	}
	public CurrentUsersMap getUsersMap() {
		return usersMap;
	}
	public void setUsersMap(CurrentUsersMap usersMap) {
		this.usersMap = usersMap;
	}
	
		

}
