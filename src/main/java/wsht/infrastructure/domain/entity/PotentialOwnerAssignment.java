package wsht.infrastructure.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.GenericHumanRoleAssignmentBase;

@Entity
@Table(name="WshtPotentialOwnerAssignment")
public class PotentialOwnerAssignment extends GenericHumanRoleAssignmentBase {
	private static final long serialVersionUID = -6584474707709240107L;
	
	public PotentialOwnerAssignment(){}

	@OneToOne(orphanRemoval=true,cascade=CascadeType.ALL)
	private From from;
	
	@OneToOne(orphanRemoval=true,cascade=CascadeType.ALL)
	private Parallel parallel;
	
	@OneToOne(orphanRemoval=true,cascade=CascadeType.ALL)
	private Sequence sequence;
	
	
	public From getFrom() {
		return from;
	}
	public void setFrom(From from) {
		this.from = from;
	}
	public Parallel getParallel() {
		return parallel;
	}
	public void setParallel(Parallel parallel) {
		this.parallel = parallel;
	}
	public Sequence getSequence() {
		return sequence;
	}
	public void setSequence(Sequence sequence) {
		this.sequence = sequence;
	}
	
	
	
}
