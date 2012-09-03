package wsht.infrastructure.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import wsht.infrastructure.domain.enums.TaskEventTypeEnum;

@Entity
@Table(name="WshtTaskEvent", uniqueConstraints = @UniqueConstraint(columnNames={"identifier"}))
public class TaskInfoEvent implements Serializable {
	private static final long serialVersionUID = -5978219949902017519L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private Date eventTime;
	private String identifier;
	private String principal;

	@Enumerated(EnumType.STRING)
	private TaskEventTypeEnum eventType;
	private String startOwner;
	private String endOwner;
	private String status;
	private Boolean hasData;
	private String eventData;
	private String faultName;

	@ElementCollection
	@CollectionTable
	private Set<String> anyElement;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getEventTime() {
		return eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public TaskEventTypeEnum getEventType() {
		return eventType;
	}

	public void setEventType(TaskEventTypeEnum eventType) {
		this.eventType = eventType;
	}

	public String getStartOwner() {
		return startOwner;
	}

	public void setStartOwner(String startOwner) {
		this.startOwner = startOwner;
	}

	public String getEndOwner() {
		return endOwner;
	}

	public void setEndOwner(String endOwner) {
		this.endOwner = endOwner;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getHasData() {
		return hasData;
	}

	public void setHasData(Boolean hasData) {
		this.hasData = hasData;
	}

	public String getEventData() {
		return eventData;
	}

	public void setEventData(String eventData) {
		this.eventData = eventData;
	}

	public String getFaultName() {
		return faultName;
	}

	public void setFaultName(String faultName) {
		this.faultName = faultName;
	}

	public Set<String> getAnyElement() {
		return anyElement;
	}

	public void setAnyElement(Set<String> anyElement) {
		this.anyElement = anyElement;
	}

	

}
