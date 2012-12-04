package wsht.infrastructure.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name="WshtToParts")
public class ToParts extends ExtensibleElementsBase {
	private static final long serialVersionUID = -518048161680386964L;
	
	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
	private List<ToPart> toPart;

	public List<ToPart> getToPart() {
		return toPart;
	}

	public void setToPart(List<ToPart> toPart) {
		this.toPart = toPart;
	}

}
