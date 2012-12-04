package wsht.infrastructure.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name="WshtResult")
public class Result extends ExtensibleElementsBase {
	private static final long serialVersionUID = 8265709093858698635L;
	
	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
	private List<ExtensibleElementsBase> aggregateOrCopy;

	public List<ExtensibleElementsBase> getAggregateOrCopy() {
		return aggregateOrCopy;
	}

	public void setAggregateOrCopy(List<ExtensibleElementsBase> aggregateOrCopy) {
		this.aggregateOrCopy = aggregateOrCopy;
	}
	
}
