package wsht.infrastructure.domain.entity.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "WshtGenericHumanRoleAssignmentBase")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class GenericHumanRoleAssignmentBase extends ExtensibleElementsBase {
	private static final long serialVersionUID = -541411580597861100L;
	
	@Column
	@NotNull
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
