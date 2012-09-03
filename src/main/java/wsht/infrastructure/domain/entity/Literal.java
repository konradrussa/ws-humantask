package wsht.infrastructure.domain.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.AttributeBase;

@Entity
@Table(name="WshtLiteral")
public class Literal implements Serializable {
	private static final long serialVersionUID = -4280896736476008094L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@OneToOne(orphanRemoval=true,cascade={CascadeType.ALL})
	private OrganizationalEntity organizationalEntity;
	
	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
    @MapKey(name="name")
    private Map<String, AttributeBase> otherAttributes = new HashMap<String, AttributeBase>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrganizationalEntity getOrganizationalEntity() {
		return organizationalEntity;
	}

	public void setOrganizationalEntity(OrganizationalEntity organizationalEntity) {
		this.organizationalEntity = organizationalEntity;
	}

	public Map<String, AttributeBase> getOtherAttributes() {
		return otherAttributes;
	}

	public void setOtherAttributes(Map<String, AttributeBase> otherAttributes) {
		this.otherAttributes = otherAttributes;
	}

	
}
