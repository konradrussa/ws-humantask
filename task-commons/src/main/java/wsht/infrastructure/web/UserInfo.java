package wsht.infrastructure.web;

import java.io.Serializable;

public class UserInfo implements Serializable {
	private static final long serialVersionUID = 3502788594640215513L;
	
	private String userName;
	private String password;
	private String ipAddress;
	private Boolean loggedIn = false;
	private String taskIdentifier;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getTaskIdentifier() {
		return taskIdentifier;
	}

	public void setTaskIdentifier(String taskIdentifier) {
		this.taskIdentifier = taskIdentifier;
	}

	@Override
	public String toString() {
		return "UserInfo [userName=" + userName + ", password=" + password
				+ ", ipAddress=" + ipAddress + ", loggedIn=" + loggedIn + "]";
	}
	
	
}
