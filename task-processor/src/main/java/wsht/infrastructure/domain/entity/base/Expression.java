package wsht.infrastructure.domain.entity.base;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;




@Entity
@Table(name="WshtExpression")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Expression extends ExtensibleMixedContentElementsBase {
	private static final long serialVersionUID = 7230262572395475978L;
	
	
	private String expressionLanguage;

	public String getExpressionLanguage() {
		return expressionLanguage;
	}

	public void setExpressionLanguage(String expressionLanguage) {
		this.expressionLanguage = expressionLanguage;
	}
	
}
