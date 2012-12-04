package wsht.infrastructure.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name="WshtTasks")
public class Tasks extends ExtensibleElementsBase {
	private static final long serialVersionUID = -2136236424869931013L;
	
	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
	private List<Task> task;

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}
	
}
