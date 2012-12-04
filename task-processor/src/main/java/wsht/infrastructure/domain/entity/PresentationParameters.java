package wsht.infrastructure.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name="WshtPresentationParameters")
public class PresentationParameters extends ExtensibleElementsBase {
	private static final long serialVersionUID = -9103279605680605919L;
	
	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
	private List<PresentationParameter> presentationParameter;
    
	private String expressionLanguage;
    
	public List<PresentationParameter> getPresentationParameter() {
		return presentationParameter;
	}
	public void setPresentationParameter(
			List<PresentationParameter> presentationParameter) {
		this.presentationParameter = presentationParameter;
	}
	public String getExpressionLanguage() {
		return expressionLanguage;
	}
	public void setExpressionLanguage(String expressionLanguage) {
		this.expressionLanguage = expressionLanguage;
	}
    
    
}
