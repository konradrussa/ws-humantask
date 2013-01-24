package wsht.infrastructure.domain.entity.base;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import wsht.infrastructure.domain.entity.CompletionBehavior;
import wsht.infrastructure.domain.entity.Composition;
import wsht.infrastructure.domain.entity.Deadlines;
import wsht.infrastructure.domain.entity.Delegation;
import wsht.infrastructure.domain.entity.MessageSchema;
import wsht.infrastructure.domain.entity.PeopleAssignments;
import wsht.infrastructure.domain.entity.PresentationElements;
import wsht.infrastructure.domain.entity.PriorityExpr;
import wsht.infrastructure.domain.entity.Query;
import wsht.infrastructure.domain.entity.Renderings;
import wsht.infrastructure.domain.entity.TaskInterface;
import wsht.infrastructure.domain.enums.BooleanEnum;

@Entity
@Table(name = "WshtTaskBase")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class TaskBase extends ExtensibleElementsBase implements
		Serializable {

	private static final long serialVersionUID = -2450199585880900111L;

	@ManyToOne(cascade=CascadeType.ALL)
	private TaskInterface _interface; //not in lean task

	@ManyToOne(cascade=CascadeType.ALL)
	private Composition composition; //not in lean task
	
	@ManyToOne(cascade=CascadeType.ALL)  
    private MessageSchema messageSchema;
    
	@ManyToOne(cascade=CascadeType.ALL)
	private PriorityExpr priority;
    
	@ManyToOne(cascade=CascadeType.ALL)
	private PeopleAssignments peopleAssignments;
    
	@ManyToOne(cascade=CascadeType.ALL)
	private CompletionBehavior completionBehavior;
    
	@ManyToOne(cascade=CascadeType.ALL)
	private Delegation delegation;
    
	@ManyToOne(cascade=CascadeType.ALL)
	private PresentationElements presentationElements;
    
	@ManyToOne(cascade=CascadeType.ALL)
	private Query outcome;
    
	@ManyToOne(cascade=CascadeType.ALL)
	private Expression searchBy;
    
	@ManyToOne(cascade=CascadeType.ALL)
	private Renderings renderings;
    
	@ManyToOne(cascade=CascadeType.ALL)
	private Deadlines deadlines;
    
	@NotNull
	private String name;
    
    @Enumerated(EnumType.STRING)
    private BooleanEnum actualOwnerRequired;
    
    private Boolean definition = true;
    
    private Boolean deleted = false;

	public TaskInterface get_interface() {
		return _interface;
	}

	public void set_interface(TaskInterface _interface) {
		this._interface = _interface;
	}

	public MessageSchema getMessageSchema() {
		return messageSchema;
	}

	public void setMessageSchema(MessageSchema messageSchema) {
		this.messageSchema = messageSchema;
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

	public CompletionBehavior getCompletionBehavior() {
		return completionBehavior;
	}

	public void setCompletionBehavior(CompletionBehavior completionBehavior) {
		this.completionBehavior = completionBehavior;
	}

	public Delegation getDelegation() {
		return delegation;
	}

	public void setDelegation(Delegation delegation) {
		this.delegation = delegation;
	}

	public PresentationElements getPresentationElements() {
		return presentationElements;
	}

	public void setPresentationElements(
			PresentationElements presentationElements) {
		this.presentationElements = presentationElements;
	}

	public Query getOutcome() {
		return outcome;
	}

	public void setOutcome(Query outcome) {
		this.outcome = outcome;
	}

	public Expression getSearchBy() {
		return searchBy;
	}

	public void setSearchBy(Expression searchBy) {
		this.searchBy = searchBy;
	}

	public Renderings getRenderings() {
		return renderings;
	}

	public void setRenderings(Renderings renderings) {
		this.renderings = renderings;
	}

	public Deadlines getDeadlines() {
		return deadlines;
	}

	public void setDeadlines(Deadlines deadlines) {
		this.deadlines = deadlines;
	}

	public Composition getComposition() {
		return composition;
	}

	public void setComposition(Composition composition) {
		this.composition = composition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BooleanEnum getActualOwnerRequired() {
		return actualOwnerRequired;
	}

	public void setActualOwnerRequired(BooleanEnum actualOwnerRequired) {
		this.actualOwnerRequired = actualOwnerRequired;
	}

	public Boolean getDefinition() {
		return definition;
	}

	public void setDefinition(Boolean definition) {
		this.definition = definition;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	

}
