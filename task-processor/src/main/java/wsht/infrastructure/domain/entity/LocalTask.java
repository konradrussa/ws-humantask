package wsht.infrastructure.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.AttributeBase;
import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name = "WshtLocalTask")
public class LocalTask extends ExtensibleElementsBase {
	private static final long serialVersionUID = 1734855581946877116L;

	@ManyToOne(cascade=CascadeType.ALL)
	private PriorityExpr priority;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private PeopleAssignments peopleAssignments;
	
	@OneToOne(orphanRemoval=true,cascade=CascadeType.ALL)
	private AttributeBase reference;

	public PriorityExpr getPriority() {
		return priority;
	}

	public void setPriority(PriorityExpr priority) {
		this.priority = priority;
	}

	public PeopleAssignments getPeopleAssignments() {
		return peopleAssignments;
	}

	public void setPeopleAssignments(PeopleAssignments peopleAssignments) {
		this.peopleAssignments = peopleAssignments;
	}

	public AttributeBase getReference() {
		return reference;
	}

	public void setReference(AttributeBase reference) {
		this.reference = reference;
	}

}
