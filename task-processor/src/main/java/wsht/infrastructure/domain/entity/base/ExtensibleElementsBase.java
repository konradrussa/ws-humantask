package wsht.infrastructure.domain.entity.base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.Documentation;


@Entity
@Table(name = "WshtElement")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ExtensibleElementsBase implements Serializable {
	private static final long serialVersionUID = 7433655951452840877L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@OneToMany(orphanRemoval=true, cascade={CascadeType.ALL})
    private List<Documentation> documentation;

	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
    private List<ExtensibleElementsBase> any;

	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
    @MapKey(name = "name")
    private Map<String, AttributeBase> otherAttributes = new HashMap<String, AttributeBase>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Documentation> getDocumentation() {
		return documentation;
	}

	public void setDocumentation(List<Documentation> documentation) {
		this.documentation = documentation;
	}

	public List<ExtensibleElementsBase> getAny() {
		return any;
	}

	public void setAny(List<ExtensibleElementsBase> any) {
		this.any = any;
	}

	public Map<String, AttributeBase> getOtherAttributes() {
		return otherAttributes;
	}

	public void setOtherAttributes(Map<String, AttributeBase> otherAttributes) {
		this.otherAttributes = otherAttributes;
	}
    
}
