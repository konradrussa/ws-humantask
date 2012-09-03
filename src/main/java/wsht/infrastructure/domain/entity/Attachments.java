package wsht.infrastructure.domain.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import wsht.infrastructure.domain.enums.ReturnAttachmentsEnum;

@Entity
@Table(name="WshtAttachments")
public class Attachments implements Serializable {
	private static final long serialVersionUID = -8609177539553407116L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private ReturnAttachmentsEnum returnAttachments;
	
	@OneToMany(orphanRemoval=true,cascade=CascadeType.ALL)
	private List<Attachment> attachment;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ReturnAttachmentsEnum getReturnAttachments() {
		return returnAttachments;
	}

	public void setReturnAttachments(ReturnAttachmentsEnum returnAttachments) {
		this.returnAttachments = returnAttachments;
	}

	public List<Attachment> getAttachment() {
		return attachment;
	}

	public void setAttachment(List<Attachment> attachment) {
		this.attachment = attachment;
	}
	
	public Attachment returnAttachemntById(String id) {
		for(Attachment a : attachment) {
			if(a.getId().toString().equals(id)) return a;
		}
		return null;
	}
	
	
}
