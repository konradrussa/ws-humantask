package wsht.infrastructure.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;
import wsht.infrastructure.domain.enums.RoutingPatternTypeEnum;


@Entity
@Table(name="WshtParallel")
public class Parallel extends ExtensibleElementsBase {
	private static final long serialVersionUID = 3440014738746857240L;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private CompletionBehavior completionBehavior;
	
	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
    private List<From> from;
	
	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
    private List<ExtensibleElementsBase> parallelOrSequence;
    
	@Enumerated(EnumType.STRING)
	private RoutingPatternTypeEnum type;
	
    public CompletionBehavior getCompletionBehavior() {
		return completionBehavior;
	}
	
    public void setCompletionBehavior(CompletionBehavior completionBehavior) {
		this.completionBehavior = completionBehavior;
	}
	
    public List<From> getFrom() {
		return from;
	}
	
    public void setFrom(List<From> from) {
		this.from = from;
	}
	
    public List<ExtensibleElementsBase> getParallelOrSequence() {
		return parallelOrSequence;
	}
	
    public void setParallelOrSequence(
			List<ExtensibleElementsBase> parallelOrSequence) {
		this.parallelOrSequence = parallelOrSequence;
	}
	
    public RoutingPatternTypeEnum getType() {
		return type;
	}
	
    public void setType(RoutingPatternTypeEnum type) {
		this.type = type;
	}

}
