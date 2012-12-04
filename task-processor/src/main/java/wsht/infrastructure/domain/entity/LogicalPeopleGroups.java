package wsht.infrastructure.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name="WshtLogicalPeopleGroups")
public class LogicalPeopleGroups extends ExtensibleElementsBase {
	private static final long serialVersionUID = -1693555074937767202L;
	
	@OneToMany(orphanRemoval=true,cascade = { CascadeType.ALL })
	private List<LogicalPeopleGroup> logicalPeopleGroup;

	public List<LogicalPeopleGroup> getLogicalPeopleGroup() {
		return logicalPeopleGroup;
	}

	public void setLogicalPeopleGroup(List<LogicalPeopleGroup> logicalPeopleGroup) {
		this.logicalPeopleGroup = logicalPeopleGroup;
	}
	
	
}
