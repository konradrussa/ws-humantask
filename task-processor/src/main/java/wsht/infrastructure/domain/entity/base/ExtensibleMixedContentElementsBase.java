package wsht.infrastructure.domain.entity.base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;

@Entity
@Table(name = "WshtMixedContentElement")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ExtensibleMixedContentElementsBase implements Serializable {
	private static final long serialVersionUID = 8357788425722047128L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ElementCollection
	@CollectionTable
    private Set<String> content;
    
	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
    @MapKey(name="name")
    private Map<String, AttributeBase> otherAttributes = new HashMap<String, AttributeBase>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<String> getContent() {
		return content;
	}

	public void setContent(Set<String> content) {
		this.content = content;
	}

	public Map<String, AttributeBase> getOtherAttributes() {
		return otherAttributes;
	}

	public void setOtherAttributes(Map<String, AttributeBase> otherAttributes) {
		this.otherAttributes = otherAttributes;
	}
    
	@PrePersist
	public void changeContentElements() {
		Set<String> temp = new HashSet<String>();
		if(content != null && !content.isEmpty()) {
			for(String s : content) {
				s = StringUtils.removeStart(s, "\"");
				s = StringUtils.removeEnd(s, "\"");
				s = StringUtils.trimToEmpty(s);
				temp.add(s);
			}
			content = temp;
		}
	}
    
}
