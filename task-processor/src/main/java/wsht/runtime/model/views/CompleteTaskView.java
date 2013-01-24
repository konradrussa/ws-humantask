package wsht.runtime.model.views;

import java.util.Date;

public class CompleteTaskView extends AbstractTaskView {

	
	private String GenericHumanRole;
	private Date LastModifiedTime;
	private String LastModifiedBy;
	private Boolean IsSkipable;
	private Date StartByTime;
	private Date CompleteByTime;
	private String PresentationName;
	private String PresentationSubject;
	private String RenderingMethodName;
	private Boolean HasOutput;
	private Boolean HasFault;
	private Boolean HasAttachments;
	private Boolean HasComments;
	private Long ParentTaskId;
	private Boolean HasSubTasks;
	private String SearchBy;
	private Class TaskOperations;
	public String getGenericHumanRole() {
		return GenericHumanRole;
	}
	public void setGenericHumanRole(String genericHumanRole) {
		GenericHumanRole = genericHumanRole;
	}
	public Date getLastModifiedTime() {
		return LastModifiedTime;
	}
	public void setLastModifiedTime(Date lastModifiedTime) {
		LastModifiedTime = lastModifiedTime;
	}
	public String getLastModifiedBy() {
		return LastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		LastModifiedBy = lastModifiedBy;
	}
	public Boolean getIsSkipable() {
		return IsSkipable;
	}
	public void setIsSkipable(Boolean isSkipable) {
		IsSkipable = isSkipable;
	}
	public Date getStartByTime() {
		return StartByTime;
	}
	public void setStartByTime(Date startByTime) {
		StartByTime = startByTime;
	}
	public Date getCompleteByTime() {
		return CompleteByTime;
	}
	public void setCompleteByTime(Date completeByTime) {
		CompleteByTime = completeByTime;
	}
	public String getPresentationName() {
		return PresentationName;
	}
	public void setPresentationName(String presentationName) {
		PresentationName = presentationName;
	}
	public String getPresentationSubject() {
		return PresentationSubject;
	}
	public void setPresentationSubject(String presentationSubject) {
		PresentationSubject = presentationSubject;
	}
	public String getRenderingMethodName() {
		return RenderingMethodName;
	}
	public void setRenderingMethodName(String renderingMethodName) {
		RenderingMethodName = renderingMethodName;
	}
	public Boolean getHasOutput() {
		return HasOutput;
	}
	public void setHasOutput(Boolean hasOutput) {
		HasOutput = hasOutput;
	}
	public Boolean getHasFault() {
		return HasFault;
	}
	public void setHasFault(Boolean hasFault) {
		HasFault = hasFault;
	}
	public Boolean getHasAttachments() {
		return HasAttachments;
	}
	public void setHasAttachments(Boolean hasAttachments) {
		HasAttachments = hasAttachments;
	}
	public Boolean getHasComments() {
		return HasComments;
	}
	public void setHasComments(Boolean hasComments) {
		HasComments = hasComments;
	}
	public Long getParentTaskId() {
		return ParentTaskId;
	}
	public void setParentTaskId(Long parentTaskId) {
		ParentTaskId = parentTaskId;
	}
	public String getSearchBy() {
		return SearchBy;
	}
	public void setSearchBy(String searchBy) {
		SearchBy = searchBy;
	}
	public Class getTaskOperations() {
		return TaskOperations;
	}
	public void setTaskOperations(Class taskOperations) {
		TaskOperations = taskOperations;
	}
	
}
