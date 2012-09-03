package wsht.infrastructure.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import wsht.infrastructure.domain.entity.base.AttributeBase;
import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name="WshtRendering")
public class Rendering extends ExtensibleElementsBase {
	private static final long serialVersionUID = -6264348262507964582L;

	@OneToOne(orphanRemoval=true,cascade=CascadeType.ALL)
	@NotNull
	private AttributeBase type;

	public AttributeBase getType() {
		return type;
	}

	public void setType(AttributeBase type) {
		this.type = type;
	}
	
}
