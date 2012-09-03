package wsht.infrastructure.domain.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.TaskInfo;
import wsht.runtime.enums.GenericHumanRolesEnum;
import wsht.runtime.enums.OperationsEnum;
import wsht.runtime.utils.OperationsAuthorization;

@Entity
@Table(name = "UserSession")
public class UserSession implements Serializable {
	private static final long serialVersionUID = 4952494415627554926L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne
	private TaskInfo taskInfo;
	
	@ManyToOne
	private OrganizationalEntity orgEntity;
	
	@ElementCollection
	@Enumerated(EnumType.STRING)
	private Set<GenericHumanRolesEnum> humanRoles;
	
	private String name;
	
	private String language;
	
	private boolean active;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public OrganizationalEntity getOrgEntity() {
		return orgEntity;
	}

	public void setOrgEntity(OrganizationalEntity orgEntity) {
		this.orgEntity = orgEntity;
	}

	public Set<GenericHumanRolesEnum> getHumanRoles() {
		return humanRoles;
	}
	
	public void setHumanRoles(Set<GenericHumanRolesEnum> humanRoles) {
		this.humanRoles = humanRoles;
	}
	
	public TaskInfo getTaskInfo() {
		return taskInfo;
	}

	public void setTaskInfo(TaskInfo taskInfo) {
		this.taskInfo = taskInfo;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	//methods


	public boolean checkPermission(OperationsEnum operation) {
		for(GenericHumanRolesEnum role : humanRoles) {
			if(OperationsAuthorization.checkRolePermission(role, operation)) return true;
		}
		return false;
	}
	
	
}
