package wsht.infrastructure.webservice;

import wsht.infrastructure.web.CurrentUsersMap;
import wsht.infrastructure.web.SessionInfo;
import wsht.infrastructure.web.TaskSessionInfo;

public abstract class WSHTService {

	private TaskSessionInfo sessionInfo;
	private CurrentUsersMap usersMap;
	
	public TaskSessionInfo getSessionInfo() {
		return sessionInfo;
	}
	public void setSessionInfo(TaskSessionInfo sessionInfo) {
		this.sessionInfo = sessionInfo;
	}
	public CurrentUsersMap getUsersMap() {
		return usersMap;
	}
	public void setUsersMap(CurrentUsersMap usersMap) {
		this.usersMap = usersMap;
	}
	
		

}
