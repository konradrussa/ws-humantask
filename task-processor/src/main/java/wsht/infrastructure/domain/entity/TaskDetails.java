package wsht.infrastructure.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import wsht.infrastructure.domain.entity.base.AttributeBase;

@Entity
@Table(name="WshtTaskDetails")
public class TaskDetails implements Serializable {
	private static final long serialVersionUID = 861453572881565470L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;

	@NotNull
	private String taskType;

	@NotNull
	@OneToOne(orphanRemoval=true,cascade=CascadeType.ALL)
	private AttributeBase name;

	@NotNull
	private String status;
	private Integer priority;
	private String taskInitiator;

	@OneToOne(orphanRemoval=true,cascade=CascadeType.ALL)
	private OrganizationalEntity taskStakeholders;

	@OneToOne(orphanRemoval=true,cascade=CascadeType.ALL)
	private OrganizationalEntity potentialOwners;

	@OneToOne(orphanRemoval=true,cascade=CascadeType.ALL)
	private OrganizationalEntity businessAdministrators;

	private String actualOwner;

	@OneToOne(orphanRemoval=true,cascade=CascadeType.ALL)
	private OrganizationalEntity notificationRecipients;

	private Date createdTime;
	private String createdBy;
	private Date lastModifiedTime;
	private String lastModifiedBy;
	private Date activationTime;
	private Date expirationTime;
	private Boolean isSkipable;
	private Boolean hasPotentialOwners;
	private Boolean startByTimeExists;
	private Boolean completeByTimeExists;
	private String presentationName;
	private String presentationSubject;
	private Boolean renderingMethodExists;
	private Boolean hasOutput;
	private Boolean hasFault;
	private Boolean hasAttachments;
	private Boolean hasComments;
	private Boolean escalated;
	private String searchBy;
	private String outcome;
	private String parentTaskId;
	private Boolean hasSubTasks;
	
	@ElementCollection
	@CollectionTable
	private Set<String> anyElement;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public AttributeBase getName() {
		return name;
	}

	public void setName(AttributeBase name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getTaskInitiator() {
		return taskInitiator;
	}

	public void setTaskInitiator(String taskInitiator) {
		this.taskInitiator = taskInitiator;
	}

	public OrganizationalEntity getTaskStakeholders() {
		return taskStakeholders;
	}

	public void setTaskStakeholders(OrganizationalEntity taskStakeholders) {
		this.taskStakeholders = taskStakeholders;
	}

	public OrganizationalEntity getPotentialOwners() {
		return potentialOwners;
	}

	public void setPotentialOwners(OrganizationalEntity potentialOwners) {
		this.potentialOwners = potentialOwners;
	}

	public OrganizationalEntity getBusinessAdministrators() {
		return businessAdministrators;
	}

	public void setBusinessAdministrators(
			OrganizationalEntity businessAdministrators) {
		this.businessAdministrators = businessAdministrators;
	}

	public String getActualOwner() {
		return actualOwner;
	}

	public void setActualOwner(String actualOwner) {
		this.actualOwner = actualOwner;
	}

	public OrganizationalEntity getNotificationRecipients() {
		return notificationRecipients;
	}

	public void setNotificationRecipients(
			OrganizationalEntity notificationRecipients) {
		this.notificationRecipients = notificationRecipients;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getActivationTime() {
		return activationTime;
	}

	public void setActivationTime(Date activationTime) {
		this.activationTime = activationTime;
	}

	public Date getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}

	public Boolean getIsSkipable() {
		return isSkipable;
	}

	public void setIsSkipable(Boolean isSkipable) {
		this.isSkipable = isSkipable;
	}

	public Boolean getHasPotentialOwners() {
		return hasPotentialOwners;
	}

	public void setHasPotentialOwners(Boolean hasPotentialOwners) {
		this.hasPotentialOwners = hasPotentialOwners;
	}

	public Boolean getStartByTimeExists() {
		return startByTimeExists;
	}

	public void setStartByTimeExists(Boolean startByTimeExists) {
		this.startByTimeExists = startByTimeExists;
	}

	public Boolean getCompleteByTimeExists() {
		return completeByTimeExists;
	}

	public void setCompleteByTimeExists(Boolean completeByTimeExists) {
		this.completeByTimeExists = completeByTimeExists;
	}

	public String getPresentationName() {
		return presentationName;
	}

	public void setPresentationName(String presentationName) {
		this.presentationName = presentationName;
	}

	public String getPresentationSubject() {
		return presentationSubject;
	}

	public void setPresentationSubject(String presentationSubject) {
		this.presentationSubject = presentationSubject;
	}

	public Boolean getRenderingMethodExists() {
		return renderingMethodExists;
	}

	public void setRenderingMethodExists(Boolean renderingMethodExists) {
		this.renderingMethodExists = renderingMethodExists;
	}

	public Boolean getHasOutput() {
		return hasOutput;
	}

	public void setHasOutput(Boolean hasOutput) {
		this.hasOutput = hasOutput;
	}

	public Boolean getHasFault() {
		return hasFault;
	}

	public void setHasFault(Boolean hasFault) {
		this.hasFault = hasFault;
	}

	public Boolean getHasAttachments() {
		return hasAttachments;
	}

	public void setHasAttachments(Boolean hasAttachments) {
		this.hasAttachments = hasAttachments;
	}

	public Boolean getHasComments() {
		return hasComments;
	}

	public void setHasComments(Boolean hasComments) {
		this.hasComments = hasComments;
	}

	public Boolean getEscalated() {
		return escalated;
	}

	public void setEscalated(Boolean escalated) {
		this.escalated = escalated;
	}

	public String getSearchBy() {
		return searchBy;
	}

	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public String getParentTaskId() {
		return parentTaskId;
	}

	public void setParentTaskId(String parentTaskId) {
		this.parentTaskId = parentTaskId;
	}

	public Boolean getHasSubTasks() {
		return hasSubTasks;
	}

	public void setHasSubTasks(Boolean hasSubTasks) {
		this.hasSubTasks = hasSubTasks;
	}

	public Set<String> getAnyElement() {
		return anyElement;
	}

	public void setAnyElement(Set<String> anyElement) {
		this.anyElement = anyElement;
	}
	
	

}
