package wsht.infrastructure.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name="WshtNotification")
public class Notification extends ExtensibleElementsBase {
	private static final long serialVersionUID = -1795331112432507771L;
	
	@NotNull
	@ManyToOne(cascade=CascadeType.ALL)
	private NotificationInterface _interface;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private PriorityExpr priority;
	
	@NotNull
	@ManyToOne(cascade=CascadeType.ALL)
	private PeopleAssignments peopleAssignments;
	
	@NotNull
	@ManyToOne(cascade=CascadeType.ALL)
	private PresentationElements presentationElements;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Renderings renderings;
	
	@NotNull
	private String name;

	public NotificationInterface get_interface() {
		return _interface;
	}

	public void set_interface(NotificationInterface _interface) {
		this._interface = _interface;
	}

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

	public PresentationElements getPresentationElements() {
		return presentationElements;
	}

	public void setPresentationElements(
			PresentationElements presentationElements) {
		this.presentationElements = presentationElements;
	}

	public Renderings getRenderings() {
		return renderings;
	}

	public void setRenderings(Renderings renderings) {
		this.renderings = renderings;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
