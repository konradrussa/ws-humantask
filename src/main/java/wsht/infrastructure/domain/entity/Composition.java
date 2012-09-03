package wsht.infrastructure.domain.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;
import wsht.infrastructure.domain.enums.CompositionTypeEnum;
import wsht.infrastructure.domain.enums.PatternEnum;

@Entity
@Table(name="WshtComposition")
public class Composition extends ExtensibleElementsBase {
	private static final long serialVersionUID = 6683066940552175221L;

	@OneToMany(orphanRemoval=true,mappedBy="composition")
    private List<Subtask> subtask;
    
    @Enumerated(EnumType.STRING)
    private CompositionTypeEnum type;
    
    @Enumerated(EnumType.STRING)
    private PatternEnum instantiationPattern;

	public List<Subtask> getSubtask() {
		return subtask;
	}

	public void setSubtask(List<Subtask> subtask) {
		this.subtask = subtask;
	}

	public CompositionTypeEnum getType() {
		return type;
	}

	public void setType(CompositionTypeEnum type) {
		this.type = type;
	}

	public PatternEnum getInstantiationPattern() {
		return instantiationPattern;
	}

	public void setInstantiationPattern(PatternEnum instantiationPattern) {
		this.instantiationPattern = instantiationPattern;
	}
    
}
