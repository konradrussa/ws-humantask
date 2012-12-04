package wsht.infrastructure.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;


@Entity
@Table(name="WshtMessageSchema")
public class MessageSchema extends ExtensibleElementsBase {
	private static final long serialVersionUID = 4786145323519612383L;
	
	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
	private List<MessageField> messageField;

	public List<MessageField> getMessageField() {
		return messageField;
	}

	public void setMessageField(List<MessageField> messageField) {
		this.messageField = messageField;
	}

}
