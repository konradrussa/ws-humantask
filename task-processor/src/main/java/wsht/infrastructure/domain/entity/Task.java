package wsht.infrastructure.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.TaskBase;

@Entity
@Table(name="WshtTask")
public class Task extends TaskBase {
	private static final long serialVersionUID = 7242733463058516899L;

}
