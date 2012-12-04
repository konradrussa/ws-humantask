package wsht.infrastructure.domain.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="WshtDocumentation")
public class Documentation implements Serializable {
	private static final long serialVersionUID = -5636566742739359421L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@ElementCollection
	@CollectionTable
	@Column(length=2048)
    private Set<String> content;
	
	
    private String lang;
    
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
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
    
    
}
