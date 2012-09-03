package wsht.infrastructure.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.AttributeBase;
import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name="WshtNotificationInterface")
public class NotificationInterface extends ExtensibleElementsBase {
	private static final long serialVersionUID = 1894753345315877482L;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private AttributeBase portType;
    
	private String operation;
    
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
    
    
}
