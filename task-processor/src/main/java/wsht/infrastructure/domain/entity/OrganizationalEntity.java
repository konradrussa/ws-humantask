package wsht.infrastructure.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="WshtOrganizationalEntity")
public class OrganizationalEntity implements Serializable {
	private static final long serialVersionUID = -6886090228335794397L;
	
	public OrganizationalEntity() {
		created = new Date();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="created", columnDefinition="TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
	private Date created;
	
	@ElementCollection
	@CollectionTable
	private Set<String> userOrg;
	
	@ElementCollection
	@CollectionTable
	private Set<String> groupOrg;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Set<String> getUserOrg() {
		return userOrg;
	}

	public void setUserOrg(Set<String> userOrg) {
		this.userOrg = userOrg;
	}

	public Set<String> getGroupOrg() {
		return groupOrg;
	}

	public void setGroupOrg(Set<String> groupOrg) {
		this.groupOrg = groupOrg;
	}
	
	

}
