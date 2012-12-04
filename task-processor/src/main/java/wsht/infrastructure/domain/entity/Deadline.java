package wsht.infrastructure.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name="WshtDeadline")
public class Deadline extends ExtensibleElementsBase {
	private static final long serialVersionUID = 3233694423357879147L;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private DurationExpr _for;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private DeadlineExpr until;
	
	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
	private List<Escalation> escalation;
	
	private String name;

	public DurationExpr get_for() {
		return _for;
	}

	public void set_for(DurationExpr _for) {
		this._for = _for;
	}

	public DeadlineExpr getUntil() {
		return until;
	}

	public void setUntil(DeadlineExpr until) {
		this.until = until;
	}

	public List<Escalation> getEscalation() {
		return escalation;
	}

	public void setEscalation(List<Escalation> escalation) {
		this.escalation = escalation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
