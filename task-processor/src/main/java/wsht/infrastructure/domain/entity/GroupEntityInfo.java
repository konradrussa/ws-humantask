package wsht.infrastructure.domain.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="GroupEntityInfo", uniqueConstraints = @UniqueConstraint(columnNames={"groupName"/*,"groupCode"*/}))
public class GroupEntityInfo implements Serializable {
	private static final long serialVersionUID = 8820340612389946109L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	@NotNull
	private String groupName;
	
	@Column
	private String regionName;
	
	@Column
	@NotNull
	private String groupCode;

	@ManyToMany(mappedBy="groupInfos")
	private List<UserEntityInfo> userInfos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<UserEntityInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(List<UserEntityInfo> userInfos) {
		this.userInfos = userInfos;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	
	
}
