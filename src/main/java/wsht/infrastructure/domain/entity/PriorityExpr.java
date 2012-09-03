package wsht.infrastructure.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.Expression;

@Entity
@Table(name="WshtPriorityExpr")
public class PriorityExpr extends Expression {
	private static final long serialVersionUID = 4364065797702819582L;

}
