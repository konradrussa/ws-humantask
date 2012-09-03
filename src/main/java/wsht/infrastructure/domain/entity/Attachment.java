package wsht.infrastructure.domain.entity;

import java.io.Serializable;

import javax.activation.DataHandler;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="WshtAttachment")
public class Attachment implements Serializable {
	private static final long serialVersionUID = -4238419726822963021L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

    @NotNull
    @OneToOne(orphanRemoval=true,cascade=CascadeType.ALL)
    private AttachmentInfo attachmentInfo;
    
    @Transient
    private DataHandler value;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AttachmentInfo getAttachmentInfo() {
		return attachmentInfo;
	}
	public void setAttachmentInfo(AttachmentInfo attachmentInfo) {
		this.attachmentInfo = attachmentInfo;
	}
	public DataHandler getValue() {
		return value;
	}
	public void setValue(DataHandler value) {
		this.value = value;
	}
    
    
}
