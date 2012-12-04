package wsht.infrastructure.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.AttributeBase;
import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name = "WshtTaskInterface")
public class TaskInterface extends ExtensibleElementsBase {
	private static final long serialVersionUID = 5121506982207928960L;

	@OneToOne(orphanRemoval=true,cascade={CascadeType.ALL})
	private AttributeBase portType;
	private String operation;
	@OneToOne(orphanRemoval=true,cascade={CascadeType.ALL})
	private AttributeBase responsePortType;
	private String responseOperation;

	public AttributeBase getPortType() {
		return portType;
	}

	public void setPortType(AttributeBase portType) {
		this.portType = portType;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public AttributeBase getResponsePortType() {
		return responsePortType;
	}

	public void setResponsePortType(AttributeBase responsePortType) {
		this.responsePortType = responsePortType;
	}

	public String getResponseOperation() {
		return responseOperation;
	}

	public void setResponseOperation(String responseOperation) {
		this.responseOperation = responseOperation;
	}

}
