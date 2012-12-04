package wsht.infrastructure.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.Expression;

@Entity
@Table(name="WshtBooleanExpr")
public class BooleanExpr extends Expression {
	private static final long serialVersionUID = 3195213605504224208L;


}
