package wsht.infrastructure.domain.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;
import wsht.infrastructure.domain.enums.BooleanEnum;

@Entity
@Table(name="WshtExtension")
public class Extension extends ExtensibleElementsBase {
	private static final long serialVersionUID = -9175385054834637962L;
	
	@NotNull
	private String namespace;
	
	@NotNull
	@Enumerated(EnumType.STRING)
    private BooleanEnum mustUnderstand;

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public BooleanEnum getMustUnderstand() {
		return mustUnderstand;
	}

	public void setMustUnderstand(BooleanEnum mustUnderstand) {
		this.mustUnderstand = mustUnderstand;
	}
	
}
