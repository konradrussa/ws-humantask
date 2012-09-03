package wsht.infrastructure.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.TaskBase;


// przmapowanie obiektu do bazy dancyh

@Entity
@Table(name="WshtLeanTask")
public class LeanTask extends TaskBase implements Serializable {
	private static final long serialVersionUID = 8220099338285404869L;

}
