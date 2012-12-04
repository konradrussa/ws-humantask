package wsht.runtime.enums;

public enum TaskStatesEnum {

	INACTIVE, 
	CREATED, 
	READY, 
	SUSPENDED_READY, 
	RESERVED, 
	SUSPENDED_RESERVED, 
	IN_PROGRESS, 
	SUSPENDED_IN_PROGRES, 
	COMPLETED, 
	FAILED, 
	ERROR, 
	EXITED, 
	OBSOLETE, 
	CLOSED,
	NOTIFICATION_READY,
	NOTIFICATION_REMOVED;

	public boolean isInactive() {
		return INACTIVE == this;
	}

	public boolean isCreated() {
		return CREATED == this;
	}

	public boolean isReady() {
		return READY == this;
	}

	public boolean isSuspendedReady() {
		return SUSPENDED_READY == this;
	}

	public boolean isReserved() {
		return RESERVED == this;
	}

	public boolean isSuspendedReserved() {
		return SUSPENDED_RESERVED == this;
	}

	public boolean isInProgress() {
		return IN_PROGRESS == this;
	}

	public boolean isSuspendedInProgress() {
		return SUSPENDED_IN_PROGRES == this;
	}
	
	public boolean isCompleted() {
		return COMPLETED == this;
	}

	public boolean isFailed() {
		return FAILED == this;
	}

	public boolean isError() {
		return ERROR == this;
	}

	public boolean isExited() {
		return EXITED == this;
	}

	public boolean isObsolete() {
		return OBSOLETE == this;
	}

	public boolean isClosed() {
		return CLOSED == this;
	}
	
	public boolean isNotificationReady() {
		return NOTIFICATION_READY == this;
	}
	
	public boolean isNotificationRemoved() {
		return NOTIFICATION_REMOVED == this;
	}
}
