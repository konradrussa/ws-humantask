package wsht.infrastructure.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name="WshtSubtask")
public class Subtask extends ExtensibleElementsBase {
	private static final long serialVersionUID = -1340314599775874211L;
	
	@ManyToOne
	private Task task;
	
	@OneToOne(orphanRemoval=true,cascade=CascadeType.ALL)
	private LocalTask localTask;
	
	private String name;
	
	@ManyToOne
	private Composition composition;

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public LocalTask getLocalTask() {
		return localTask;
	}

	public void setLocalTask(LocalTask localTask) {
		this.localTask = localTask;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Composition getComposition() {
		return composition;
	}

	public void setComposition(Composition composition) {
		this.composition = composition;
	}

	
}
