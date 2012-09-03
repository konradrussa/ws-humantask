package wsht.infrastructure.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.AttributeBase;
import wsht.infrastructure.domain.entity.base.ExtensibleMixedContentElementsBase;

@Entity
@Table(name="WshtParameter")
public class Parameter extends ExtensibleMixedContentElementsBase {
	private static final long serialVersionUID = 4719566919616358937L;

	private String name;

	@OneToOne(orphanRemoval=true,cascade={CascadeType.ALL})
	private AttributeBase type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AttributeBase getType() {
		return type;
	}

	public void setType(AttributeBase type) {
		this.type = type;
	}

}
