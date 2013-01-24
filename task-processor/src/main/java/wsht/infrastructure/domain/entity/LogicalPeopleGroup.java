package wsht.infrastructure.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name = "WshtLogicalPeopleGroup")
public class LogicalPeopleGroup extends ExtensibleElementsBase {
	private static final long serialVersionUID = -2242780421463820890L;

	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
	private List<Parameter> parameter;

	@NotNull
	private String name;

	private String reference;

	public List<Parameter> getParameter() {
		return parameter;
	}

	public void setParameter(List<Parameter> parameter) {
		this.parameter = parameter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
	
}
