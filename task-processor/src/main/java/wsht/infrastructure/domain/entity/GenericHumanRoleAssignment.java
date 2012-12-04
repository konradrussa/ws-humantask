package wsht.infrastructure.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.GenericHumanRoleAssignmentBase;

@Entity
@Table(name="WshtGenericHumanRoleAssignment")
public class GenericHumanRoleAssignment extends GenericHumanRoleAssignmentBase {
	private static final long serialVersionUID = 2192136176977436119L;
	
	public GenericHumanRoleAssignment(){}

	@OneToOne(orphanRemoval=true,cascade={CascadeType.ALL})
	private From from;

	public From getFrom() {
		return from;
	}

	public void setFrom(From from) {
		this.from = from;
	}
	
}
