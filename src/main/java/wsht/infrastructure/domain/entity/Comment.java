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
@Table(name="WshtComment")
public class Comment implements Serializable {
	private static final long serialVersionUID = -1823690882620561892L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedTime;

    @NotNull
    protected String addedBy;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedTime;

    @NotNull
    private String lastModifiedBy;

    @NotNull
    protected String text;

    @Transient
    protected List<DataHandler> any;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAddedTime() {
		return addedTime;
	}

	public void setAddedTime(Date addedTime) {
		this.addedTime = addedTime;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<DataHandler> getAny() {
		return any;
	}

	public void setAny(List<DataHandler> any) {
		this.any = any;
	}
    
    
}
