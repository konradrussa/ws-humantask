package wsht.infrastructure.domain.entity;

import javax.persistence.*;


@Entity
@Table(name="WshtNominate", uniqueConstraints = @UniqueConstraint(columnNames={"identifier"}))
public class Nominate {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
    private String identifier;
    
    @OneToOne(orphanRemoval=true,cascade=CascadeType.ALL)
    private OrganizationalEntity organizationalEntity;

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

	public OrganizationalEntity getOrganizationalEntity() {
		return organizationalEntity;
	}

	public void setOrganizationalEntity(OrganizationalEntity organizationalEntity) {
		this.organizationalEntity = organizationalEntity;
	}
    
    
}
