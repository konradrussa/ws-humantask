package wsht.infrastructure.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name="WshtPresentationElements")
public class PresentationElements extends ExtensibleElementsBase {
	private static final long serialVersionUID = 3447391897926836378L;
	
	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
	@JoinColumn(nullable=true)
	private List<Text> name;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private PresentationParameters presentationParameters;
	
	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
	@JoinColumn(nullable=true)
	private List<Text> subject;
	
	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
	private List<Description> description;
	
	public List<Text> getName() {
		return name;
	}
	public void setName(List<Text> name) {
		this.name = name;
	}
	public PresentationParameters getPresentationParameters() {
		return presentationParameters;
	}
	public void setPresentationParameters(
			PresentationParameters presentationParameters) {
		this.presentationParameters = presentationParameters;
	}
	public List<Text> getSubject() {
		return subject;
	}
	public void setSubject(List<Text> subject) {
		this.subject = subject;
	}
	public List<Description> getDescription() {
		return description;
	}
	public void setDescription(List<Description> description) {
		this.description = description;
	}
	
	

}
