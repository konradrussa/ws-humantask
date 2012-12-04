package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.Description;

@Repository("descriptionRepository")
public class DescriptionRepositoryJpa extends DomainRepositoryJpa<Description> implements IDescriptionRepository {

	@Override
	public Class<Description> getRepositoryModelClass() {
		return Description.class;
	}

}
