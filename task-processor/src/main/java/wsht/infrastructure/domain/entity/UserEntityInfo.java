package wsht.infrastructure.domain.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="UserEntityInfo", uniqueConstraints = @UniqueConstraint(columnNames={"userName"/*, "email"*/}))
public class UserEntityInfo implements Serializable {
	private static final long serialVersionUID = -3648324773499669546L;

	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToMany
	@JoinTable(
      name="wsht_user_groups",
      joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
      inverseJoinColumns={@JoinColumn(name="group_id", referencedColumnName="id")})
	private List<GroupEntityInfo> groupInfos;
	
	@ManyToMany
	@JoinTable(
      name="wsht_potentialowner_taskInfos",
      joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
      inverseJoinColumns={@JoinColumn(name="taskinfo_id", referencedColumnName="id")})
	private List<TaskInfo> potentialOwnerTaskInfos;
	
	@ManyToMany
	@JoinTable(
      name="wsht_businessadministrator_taskInfos",
      joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
      inverseJoinColumns={@JoinColumn(name="taskinfo_id", referencedColumnName="id")})
	private List<TaskInfo> businessAdministratorTaskInfos;
	
	@Column
	@NotNull
	private String name;
	
	@Column
	@NotNull
	@Email
	private String email;
	
	@Column
	@NotNull
	private String userName;
	
	@Column
	@NotNull
	private String password;
	
	@Column
	private Boolean active;
	
	@Column
	private Boolean parentSide;
	
	@Column
	private Boolean clientSide;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<GroupEntityInfo> getGroupInfos() {
		return groupInfos;
	}

	public void setGroupInfos(List<GroupEntityInfo> groupInfos) {
		this.groupInfos = groupInfos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getParentSide() {
		return parentSide;
	}

	public void setParentSide(Boolean parentSide) {
		this.parentSide = parentSide;
	}

	public Boolean getClientSide() {
		return clientSide;
	}

	public void setClientSide(Boolean clientSide) {
		this.clientSide = clientSide;
	}

	public List<TaskInfo> getPotentialOwnerTaskInfos() {
		return potentialOwnerTaskInfos;
	}

	public void setPotentialOwnerTaskInfos(List<TaskInfo> potentialOwnerTaskInfos) {
		this.potentialOwnerTaskInfos = potentialOwnerTaskInfos;
	}

	public List<TaskInfo> getBusinessAdministratorTaskInfos() {
		return businessAdministratorTaskInfos;
	}

	public void setBusinessAdministratorTaskInfos(
			List<TaskInfo> businessAdministratorTaskInfos) {
		this.businessAdministratorTaskInfos = businessAdministratorTaskInfos;
	}
	
	
	
}
