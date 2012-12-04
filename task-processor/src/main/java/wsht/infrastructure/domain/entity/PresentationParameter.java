package wsht.infrastructure.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="WshtPresentationParameter")
public class PresentationParameter extends Parameter {
	private static final long serialVersionUID = 4310993967501293485L;

}
