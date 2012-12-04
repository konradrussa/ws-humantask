package wsht.infrastructure.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name="WshtReassignment")
public class Reassignment extends ExtensibleElementsBase {
	private static final long serialVersionUID = 9082264415834363800L;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private PotentialOwnerAssignment potentialOwners;

	public PotentialOwnerAssignment getPotentialOwners() {
		return potentialOwners;
	}

	public void setPotentialOwners(PotentialOwnerAssignment potentialOwners) {
		this.potentialOwners = potentialOwners;
	}
	

}
