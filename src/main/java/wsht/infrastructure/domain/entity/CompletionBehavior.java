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
import wsht.infrastructure.domain.enums.PatternEnum;

@Entity
@Table(name="WshtCompletionBehavior")
public class CompletionBehavior extends ExtensibleElementsBase {
	private static final long serialVersionUID = -5634573551222846220L;

	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
    private List<Completion> completion;
    
	@ManyToOne(cascade=CascadeType.ALL)
	private DefaultCompletion defaultCompletion;
    
    @Enumerated(EnumType.STRING)
    private PatternEnum completionAction;

	public List<Completion> getCompletion() {
		return completion;
	}

	public void setCompletion(List<Completion> completion) {
		this.completion = completion;
	}

	public DefaultCompletion getDefaultCompletion() {
		return defaultCompletion;
	}

	public void setDefaultCompletion(DefaultCompletion defaultCompletion) {
		this.defaultCompletion = defaultCompletion;
	}

	public PatternEnum getCompletionAction() {
		return completionAction;
	}

	public void setCompletionAction(PatternEnum completionAction) {
		this.completionAction = completionAction;
	}

    
}
