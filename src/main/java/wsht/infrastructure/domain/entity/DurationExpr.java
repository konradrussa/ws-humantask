package wsht.infrastructure.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.Expression;

@Entity
@Table(name="WshtDurationExpr")
public class DurationExpr extends Expression {
	private static final long serialVersionUID = -2873411755095439407L;

}
