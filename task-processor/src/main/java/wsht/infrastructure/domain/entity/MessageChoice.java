package wsht.infrastructure.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;


@Entity
@Table(name="WshtmessageChoice")
public class MessageChoice extends ExtensibleElementsBase {
	private static final long serialVersionUID = 7516688847273001453L;
	
	@OneToMany(orphanRemoval=true,cascade=CascadeType.ALL)
	private List<MessageDisplay> messageDisplay;
	
	private String value;
	
	public List<MessageDisplay> getMessageDisplay() {
		return messageDisplay;
	}
	
	public void setMessageDisplay(List<MessageDisplay> messageDisplay) {
		this.messageDisplay = messageDisplay;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
    
	
}
