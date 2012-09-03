package wsht.infrastructure.domain.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TaskAttachmentInfos")
public class AttachmentInfos implements Serializable {
	private static final long serialVersionUID = -5019887807323245143L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@OneToMany(orphanRemoval=true,cascade=CascadeType.ALL)
	private List<AttachmentInfo> info;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<AttachmentInfo> getInfo() {
		return info;
	}

	public void setInfo(List<AttachmentInfo> info) {
		this.info = info;
	}
	
	
}
