package wsht.infrastructure.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import wsht.infrastructure.domain.entity.base.AttributeBase;
import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name="WshtLocalNotification")
public class LocalNotification extends ExtensibleElementsBase {
	private static final long serialVersionUID = 1446918392379855599L;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private PriorityExpr priority;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private PeopleAssignments peopleAssignments;
	
	@NotNull
	@OneToOne(orphanRemoval=true,cascade={CascadeType.ALL})
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
