package wsht.runtime.enums;

public enum GenericHumanRolesEnum {

	TASK_INITIATOR,
	TASK_STAKEHOLDERS,
	POTENTIAL_OWNERS,
	ACTUAL_OWNER,
	BUSINESS_ADMINISTRATOR,
	NOTIFICATION_RECIPIENTS;
	
	public boolean isTaskInitiator() {
		return TASK_INITIATOR == this;
	}
	
	public boolean isTaskStakeHolders() {
		return TASK_STAKEHOLDERS == this;
	}
	
	public boolean isPotentialOwners() {
		return POTENTIAL_OWNERS == this;
	}
	
	public boolean isActualOwner() {
		return ACTUAL_OWNER == this;
	}
	
	public boolean isBusinessAdministrator() {
		return BUSINESS_ADMINISTRATOR == this;
	}
	
	public boolean isNotificationsrecipients() {
		return NOTIFICATION_RECIPIENTS == this;
	}
}
