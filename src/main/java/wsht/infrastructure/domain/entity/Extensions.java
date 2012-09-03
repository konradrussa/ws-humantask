package wsht.infrastructure.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name="WshtExtensions")
public class Extensions extends ExtensibleElementsBase {
	
	private static final long serialVersionUID = -4993140891798309033L;
	
	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
	private List<Extension> extension;

	public List<Extension> getExtension() {
		return extension;
	}

	public void setExtension(List<Extension> extension) {
		this.extension = extension;
	}
	
	
}
