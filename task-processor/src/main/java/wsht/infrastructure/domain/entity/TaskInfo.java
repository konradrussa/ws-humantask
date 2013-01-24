package wsht.infrastructure.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import wsht.infrastructure.domain.entity.base.TaskBase;
import wsht.runtime.enums.OperationsEnum;
import wsht.runtime.enums.TaskStatesEnum;
import wsht.runtime.utils.OperationsAuthorization;

@Entity
@Table(name = "TaskInfo",uniqueConstraints=@UniqueConstraint(columnNames={"taskIdentifier"}))
public class TaskInfo implements Serializable {
	private static final long serialVersionUID = 3748426146533256681L;

	public TaskInfo() {
		created = new Date();
	}
	
	public TaskInfo(String identifier) {
		this();
		this.taskIdentifier = identifier;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	@NotNull
	private String taskIdentifier;
	
	@OneToOne(orphanRemoval=true,cascade=CascadeType.ALL)
	@NotNull
	private TaskBase task;
	
	@OneToOne(orphanRemoval=true,cascade=CascadeType.ALL)
	private TaskInfo taskParent;
	
	@ManyToOne
	private UserEntityInfo owner;
	
	@ManyToMany(mappedBy="potentialOwnerTaskInfos")
	private List<UserEntityInfo> potentialOwners;
	
	@ManyToMany(mappedBy="businessAdministratorTaskInfos")
	private List<UserEntityInfo> businessAdministrators;
	
	@OneToMany(orphanRemoval=true,mappedBy="taskInfo")
	private List<UserSession> currentOwnerStack;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private TaskStatesEnum state;
	
	@Column
	private Integer priority;
	
	@Column
	private Boolean escalated;
	
	@Column(name="created", columnDefinition="TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
	private Date created;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date activated;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date expired;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;
	
	@OneToOne(orphanRemoval=true,cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Fault fault;
	
	private boolean isLeanTask;
	
	private boolean isSubtask;
	
	@OneToOne(orphanRemoval=true,cascade=CascadeType.ALL)
	private Attachments attachments;
	
	@OneToOne(orphanRemoval=true,cascade=CascadeType.ALL)
	private Comments comments;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TaskBase getTask() {
		return task;
	}

	public void setTask(TaskBase task) {
		this.task = task;
	}

	public TaskStatesEnum getState() {
		return state;
	}

	public void setState(TaskStatesEnum state) {
		this.state = state;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	public Boolean getEscalated() {
		return escalated;
	}

	public void setEscalated(Boolean escalated) {
		this.escalated = escalated;
	}

	public Date getActivated() {
		return activated;
	}

	public void setActivated(Date activated) {
		this.activated = activated;
	}

	public Date getExpired() {
		return expired;
	}

	public void setExpired(Date expired) {
		this.expired = expired;
	}

	public String getTaskIdentifier() {
		return taskIdentifier;
	}

	public void setTaskIdentifier(String taskIdentifier) {
		this.taskIdentifier = taskIdentifier;
	}

	public UserEntityInfo getOwner() {
		return owner;
	}

	public void setOwner(UserEntityInfo owner) {
		this.owner = owner;
	}

	public List<UserSession> getCurrentOwnerStack() {
		return currentOwnerStack;
	}

	public void setCurrentOwnerStack(List<UserSession> currentOwnerStack) {
		this.currentOwnerStack = currentOwnerStack;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Fault getFault() {
		return fault;
	}

	public void setFault(Fault fault) {
		this.fault = fault;
	}

	public boolean getIsLeanTask() {
		return isLeanTask;
	}

	public void setIsLeanTask(boolean isLeanTask) {
		this.isLeanTask = isLeanTask;
	}

	public boolean getIsSubtask() {
		return isSubtask;
	}

	public void setIsSubtask(boolean isSubtask) {
		this.isSubtask = isSubtask;
	}

	public Attachments getAttachments() {
		return attachments;
	}

	public void setAttachments(Attachments attachments) {
		this.attachments = attachments;
	}

	public Comments getComments() {
		return comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}
	
	public TaskInfo getTaskParent() {
		return taskParent;
	}

	public void setTaskParent(TaskInfo taskParent) {
		this.taskParent = taskParent;
	}
	
	public List<UserEntityInfo> getPotentialOwners() {
		return potentialOwners;
	}

	public void setPotentialOwners(List<UserEntityInfo> potentialOwners) {
		this.potentialOwners = potentialOwners;
	}

	public List<UserEntityInfo> getBusinessAdministrators() {
		return businessAdministrators;
	}

	public void setBusinessAdministrators(
			List<UserEntityInfo> businessAdministrators) {
		this.businessAdministrators = businessAdministrators;
	}
	
	//methods

	public boolean checkPermission(OperationsEnum operation) {
		return OperationsAuthorization.checkPreStatePermission(operation, this);
	}
	
}
