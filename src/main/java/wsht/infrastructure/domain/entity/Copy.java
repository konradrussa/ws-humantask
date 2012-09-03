package wsht.infrastructure.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.Expression;
import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name="WshtCopy")
public class Copy extends ExtensibleElementsBase {
	private static final long serialVersionUID = 3862834909774968632L;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Expression from;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Query to;
	
	public Expression getFrom() {
		return from;
	}
	public void setFrom(Expression from) {
		this.from = from;
	}
	public Query getTo() {
		return to;
	}
	public void setTo(Query to) {
		this.to = to;
	}
	
	
	
	
}
