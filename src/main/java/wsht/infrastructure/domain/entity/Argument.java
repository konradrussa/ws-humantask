package wsht.infrastructure.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleMixedContentElementsBase;

@Entity
@Table(name="WshtArgument")
public class Argument extends ExtensibleMixedContentElementsBase {
	private static final long serialVersionUID = 2527973507473702247L;
	
	
    private String name;
    private String expressionLanguage;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExpressionLanguage() {
		return expressionLanguage;
	}
	public void setExpressionLanguage(String expressionLanguage) {
		this.expressionLanguage = expressionLanguage;
	}
    
    
}
