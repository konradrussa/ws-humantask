package wsht.infrastructure.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;


@Entity
@Table(name="WshtMessageField")
public class MessageField extends ExtensibleElementsBase {
	private static final long serialVersionUID = -6687981204921977190L;
	
	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
	@NotNull
	private List<MessageDisplay> messageDisplay;
	
	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
	private List<MessageChoice> messageChoice;
	
	private String name;
	
	private String type;
	
	public List<MessageDisplay> getMessageDisplay() {
		return messageDisplay;
	}
	public void setMessageDisplay(List<MessageDisplay> messageDisplay) {
		this.messageDisplay = messageDisplay;
	}
	public List<MessageChoice> getMessageChoice() {
		return messageChoice;
	}
	public void setMessageChoice(List<MessageChoice> messageChoice) {
		this.messageChoice = messageChoice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
    
    

}
