package wsht.infrastructure.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleMixedContentElementsBase;

@Entity
@Table(name="WshtFrom")
public class From extends ExtensibleMixedContentElementsBase{
	private static final long serialVersionUID = -7599052515131699856L;

	private String expressionLanguage;
	
	private String logicalPeopleGroup;
	
	@OneToOne(orphanRemoval=true,cascade = {CascadeType.ALL})
	private Argument argument;
	
	@OneToOne(orphanRemoval=true,cascade = {CascadeType.ALL})
	private Literal literal;

	public String getExpressionLanguage() {
		return expressionLanguage;
	}

	public void setExpressionLanguage(String expressionLanguage) {
		this.expressionLanguage = expressionLanguage;
	}

	public String getLogicalPeopleGroup() {
		return logicalPeopleGroup;
	}

	public void setLogicalPeopleGroup(String logicalPeopleGroup) {
		this.logicalPeopleGroup = logicalPeopleGroup;
	}

	public Argument getArgument() {
		return argument;
	}

	public void setArgument(Argument argument) {
		this.argument = argument;
	}

	public Literal getLiteral() {
		return literal;
	}

	public void setLiteral(Literal literal) {
		this.literal = literal;
	}
	
	
	
}
