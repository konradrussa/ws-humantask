package wsht.infrastructure.domain.entity.base;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//QName
@Entity
@Table(name="WshtAttribute")//, uniqueConstraints = @UniqueConstraint(columnNames={"name"})
public class AttributeBase implements Serializable {
	private static final long serialVersionUID = 4740796120635513263L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String name;
	
	private String value;
	
	private String localPart;
	
	private String namespaceUri;
	
	private String prefix;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLocalPart() {
		return localPart;
	}

	public void setLocalPart(String localPart) {
		this.localPart = localPart;
	}

	public String getNamespaceUri() {
		return namespaceUri;
	}

	public void setNamespaceUri(String namespaceUri) {
		this.namespaceUri = namespaceUri;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

}
