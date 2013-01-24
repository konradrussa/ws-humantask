package wsht.infrastructure.domain.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "LogicalPeopleGroupDefinition")
public class LogicalPeopleDefinition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	private TaskInfo taskInfo;
	
	@Column
	@NotNull
	private String roleName;
	
	@Column
	private String logicalPeopleName;
	
	@OneToMany
	private List<UserEntityInfo> userInfos;
	
	@OneToMany
	private List<GroupEntityInfo> groupInfos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogicalPeopleName() {
		return logicalPeopleName;
	}

	public void setLogicalPeopleName(String logicalPeopleName) {
		this.logicalPeopleName = logicalPeopleName;
	}
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<UserEntityInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(List<UserEntityInfo> userInfos) {
		this.userInfos = userInfos;
	}

	public List<GroupEntityInfo> getGroupInfos() {
		return groupInfos;
	}

	public void setGroupInfos(List<GroupEntityInfo> groupInfos) {
		this.groupInfos = groupInfos;
	}

	public TaskInfo getTaskInfo() {
		return taskInfo;
	}

	public void setTaskInfo(TaskInfo taskInfo) {
		this.taskInfo = taskInfo;
	}
	
	

}
