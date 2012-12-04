package wsht.infrastructure.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name="WshtCompletion")
public class Completion extends ExtensibleElementsBase {
	private static final long serialVersionUID = 4536231641306907247L;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private BooleanExpr condition;
    
	@ManyToOne(cascade=CascadeType.ALL)
	private Result result;
    
    
	public BooleanExpr getCondition() {
		return condition;
	}
	
	public void setCondition(BooleanExpr condition) {
		this.condition = condition;
	}
	
	public Result getResult() {
		return result;
	}
	
	public void setResult(Result result) {
		this.result = result;
	}
    
    
}
