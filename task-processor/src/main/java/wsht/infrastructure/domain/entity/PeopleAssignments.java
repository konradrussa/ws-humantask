package wsht.infrastructure.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;
import wsht.infrastructure.domain.entity.base.GenericHumanRoleAssignmentBase;

@Entity
@Table(name="WshtPeopleAssignments")
public class PeopleAssignments extends ExtensibleElementsBase {
	private static final long serialVersionUID = -4218607299043110753L;

	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
	private List<GenericHumanRoleAssignmentBase> genericHumanRole;

	public List<GenericHumanRoleAssignmentBase> getGenericHumanRole() {
		return genericHumanRole;
	}

	public void setGenericHumanRole(
			List<GenericHumanRoleAssignmentBase> genericHumanRole) {
		this.genericHumanRole = genericHumanRole;
	}
	
	
}
