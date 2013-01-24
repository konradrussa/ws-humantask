package wsht.infrastructure.web;

import java.io.Serializable;


public class SessionInfo implements Serializable {
	private static final long serialVersionUID = -4274761428245036469L;
	
	private UserInfo userInfo;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;  
	}
	 
}
