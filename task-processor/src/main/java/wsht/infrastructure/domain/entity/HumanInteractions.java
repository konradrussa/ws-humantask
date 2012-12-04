package wsht.infrastructure.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name="WshtHumanInteractions")
public class HumanInteractions extends ExtensibleElementsBase {
	private static final long serialVersionUID = 7009222592274200517L;

	@OneToOne(orphanRemoval=true,cascade = { CascadeType.ALL })
	private Extensions extensions;

	@OneToMany(orphanRemoval=true,cascade = { CascadeType.ALL })
	private List<Import> _import;

	@OneToOne(orphanRemoval=true,cascade = { CascadeType.ALL })
	private LogicalPeopleGroups logicalPeopleGroups;

	@OneToOne(orphanRemoval=true,cascade = { CascadeType.ALL })
	private Tasks tasks;

	@OneToOne(orphanRemoval=true,cascade = { CascadeType.ALL })
	private Notifications notifications;
	
	@NotNull
	private String targetNamespace;
	
	private String queryLanguage;
	
	private String expressionLanguage;

	public Extensions getExtensions() {
		return extensions;
	}

	public void setExtensions(Extensions extensions) {
		this.extensions = extensions;
	}

	public List<Import> get_import() {
		return _import;
	}

	public void set_import(List<Import> _import) {
		this._import = _import;
	}

	public LogicalPeopleGroups getLogicalPeopleGroups() {
		return logicalPeopleGroups;
	}

	public void setLogicalPeopleGroups(LogicalPeopleGroups logicalPeopleGroups) {
		this.logicalPeopleGroups = logicalPeopleGroups;
	}

	public Tasks getTasks() {
		return tasks;
	}

	public void setTasks(Tasks tasks) {
		this.tasks = tasks;
	}

	public Notifications getNotifications() {
		return notifications;
	}

	public void setNotifications(Notifications notifications) {
		this.notifications = notifications;
	}

	public String getTargetNamespace() {
		return targetNamespace;
	}

	public void setTargetNamespace(String targetNamespace) {
		this.targetNamespace = targetNamespace;
	}

	public String getQueryLanguage() {
		return queryLanguage;
	}

	public void setQueryLanguage(String queryLanguage) {
		this.queryLanguage = queryLanguage;
	}

	public String getExpressionLanguage() {
		return expressionLanguage;
	}

	public void setExpressionLanguage(String expressionLanguage) {
		this.expressionLanguage = expressionLanguage;
	}

}
