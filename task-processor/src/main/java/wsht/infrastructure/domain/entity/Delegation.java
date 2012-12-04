package wsht.infrastructure.domain.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;
import wsht.infrastructure.domain.enums.PotentialDelegateesEnum;

@Entity
@Table(name="WshtDelegation")
public class Delegation extends ExtensibleElementsBase {
	private static final long serialVersionUID = 4259547963442960475L;

	@ManyToOne
	private From from;
	
	@Enumerated(EnumType.STRING)
	private PotentialDelegateesEnum potentialDelegatees;

	public From getFrom() {
		return from;
	}

	public void setFrom(From from) {
		this.from = from;
	}

	public PotentialDelegateesEnum getPotentialDelegatees() {
		return potentialDelegatees;
	}

	public void setPotentialDelegatees(PotentialDelegateesEnum potentialDelegatees) {
		this.potentialDelegatees = potentialDelegatees;
	}
	
	
}
