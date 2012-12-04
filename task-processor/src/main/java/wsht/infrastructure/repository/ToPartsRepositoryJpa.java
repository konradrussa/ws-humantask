package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.ToParts;

@Repository("toPartsRepository")
public class ToPartsRepositoryJpa extends DomainRepositoryJpa<ToParts> implements IToPartsRepository {

	@Override
	public Class<ToParts> getRepositoryModelClass() {
		return ToParts.class;
	}

}
