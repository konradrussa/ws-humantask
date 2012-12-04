package wsht.infrastructure.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name="Wshtdeadlines")
public class Deadlines extends ExtensibleElementsBase {
	private static final long serialVersionUID = -210659776821659939L;
	
	
	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
	@JoinColumn(nullable=true)
	private List<Deadline> startDeadline;
	
	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
	@JoinColumn(nullable=true)
	private List<Deadline> completionDeadline;

	public List<Deadline> getStartDeadline() {
		return startDeadline;
	}

	public void setStartDeadline(List<Deadline> startDeadline) {
		this.startDeadline = startDeadline;
	}

	public List<Deadline> getCompletionDeadline() {
		return completionDeadline;
	}

	public void setCompletionDeadline(List<Deadline> completionDeadline) {
		this.completionDeadline = completionDeadline;
	}

}
