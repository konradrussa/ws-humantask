package wsht.infrastructure.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="WshtFault", uniqueConstraints = @UniqueConstraint(columnNames={"identifier"}))
public class Fault implements Serializable {
	private static final long serialVersionUID = 7862782915666855202L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String identifier;
	
	private String faultName;
	
	private String faultData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFaultName() {
		return faultName;
	}

	public void setFaultName(String faultName) {
		this.faultName = faultName;
	}

	public String getFaultData() {
		return faultData;
	}

	public void setFaultData(String faultData) {
		this.faultData = faultData;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	
}
