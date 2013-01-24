package wsht.runtime.model.views;

import java.io.Serializable;
import java.util.Date;

import wsht.infrastructure.domain.entity.TaskInfo;

public abstract class AbstractTaskView implements Serializable {
	private static final long serialVersionUID = -1085804221811562088L;
	
	private Long ID;
	private String TaskType;
	private String Name;
	private String Status;
	private Integer Priority;
	
	private Date CreatedTime;
	private Date ActivationTime;
	private Date ExpirationTime;
	
	private Boolean Escalated;
	private Long ParentTaskId;
	private String HasSubTasks;
	private String SearchBy;
	private String Outcome;
	
	private TaskInfo taskInfo;
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getTaskType() {
		return TaskType;
	}
	public void setTaskType(String taskType) {
		TaskType = taskType;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Integer getPriority() {
		return Priority;
	}
	public void setPriority(Integer priority) {
		Priority = priority;
	}
	public Date getCreatedTime() {
		return CreatedTime;
	}
	public void setCreatedTime(Date createdTime) {
		CreatedTime = createdTime;
	}
	public Date getActivationTime() {
		return ActivationTime;
	}
	public void setActivationTime(Date activationTime) {
		ActivationTime = activationTime;
	}
	public Date getExpirationTime() {
		return ExpirationTime;
	}
	public void setExpirationTime(Date expirationTime) {
		ExpirationTime = expirationTime;
	}
	public Boolean getEscalated() {
		return Escalated;
	}
	public void setEscalated(Boolean escalated) {
		Escalated = escalated;
	}
	public Long getParentTaskId() {
		return ParentTaskId;
	}
	public void setParentTaskId(Long parentTaskId) {
		ParentTaskId = parentTaskId;
	}
	public String getHasSubTasks() {
		return HasSubTasks;
	}
	public void setHasSubTasks(String hasSubTasks) {
		HasSubTasks = hasSubTasks;
	}
	public String getSearchBy() {
		return SearchBy;
	}
	public void setSearchBy(String searchBy) {
		SearchBy = searchBy;
	}
	public String getOutcome() {
		return Outcome;
	}
	public void setOutcome(String outcome) {
		Outcome = outcome;
	}
	public TaskInfo getTaskInfo() {
		return taskInfo;
	}
	public void setTaskInfo(TaskInfo taskInfo) {
		this.taskInfo = taskInfo;
	}
	
	
}
