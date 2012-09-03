package wsht.infrastructure.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.activation.DataHandler;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="WshtAttachmentInfo")
public class AttachmentInfo implements Serializable {
	private static final long serialVersionUID = -1844138377064105089L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

    @NotNull
    private String identifier;

    @NotNull
    private String name;

    @NotNull
    private String accessType;

    @NotNull
    private String contentType;
    
    @NotNull
    private String contentCategory;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date attachedTime;

    @NotNull
    private String attachedBy;

    @Transient
    private List<DataHandler> any;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentCategory() {
		return contentCategory;
	}

	public void setContentCategory(String contentCategory) {
		this.contentCategory = contentCategory;
	}

	public Date getAttachedTime() {
		return attachedTime;
	}

	public void setAttachedTime(Date attachedTime) {
		this.attachedTime = attachedTime;
	}

	public String getAttachedBy() {
		return attachedBy;
	}

	public void setAttachedBy(String attachedBy) {
		this.attachedBy = attachedBy;
	}

	public List<DataHandler> getAny() {
		return any;
	}

	public void setAny(List<DataHandler> any) {
		this.any = any;
	}
    
    
}
