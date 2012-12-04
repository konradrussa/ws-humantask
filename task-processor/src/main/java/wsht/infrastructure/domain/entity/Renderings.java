package wsht.infrastructure.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name="WshtRenderings")
public class Renderings extends ExtensibleElementsBase {
	private static final long serialVersionUID = 4730804631719454017L;
	
	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
	@NotNull
	private List<Rendering> rendering;

	public List<Rendering> getRendering() {
		return rendering;
	}

	public void setRendering(List<Rendering> rendering) {
		this.rendering = rendering;
	}
	
	
	
	
}
