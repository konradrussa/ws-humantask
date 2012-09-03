package wsht.infrastructure.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name="WshtDefaultCompletion")
public class DefaultCompletion extends ExtensibleElementsBase {
	private static final long serialVersionUID = -3054049985842001962L;

	@NotNull
	@ManyToOne(cascade=CascadeType.ALL)
	private Result result;


	public Result getResult() {
		return result;
	}


	public void setResult(Result result) {
		this.result = result;
	}
	
	
}
