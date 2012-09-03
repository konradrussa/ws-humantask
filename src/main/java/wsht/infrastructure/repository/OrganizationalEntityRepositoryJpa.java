package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.OrganizationalEntity;

@Repository("organizationalEntityRepository")
public class OrganizationalEntityRepositoryJpa extends DomainRepositoryJpa<OrganizationalEntity> implements IOrganizationalEntityRepository {

	@Override
	public Class<OrganizationalEntity> getRepositoryModelClass() {
		return OrganizationalEntity.class;
	}

}
