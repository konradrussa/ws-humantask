package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.ToPart;

@Repository("toPartRepository")
public class ToPartRepositoryJpa extends DomainRepositoryJpa<ToPart> implements IToPartRepository {

	@Override
	public Class<ToPart> getRepositoryModelClass() {
		return ToPart.class;
	}

}
