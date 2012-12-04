package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.Renderings;

@Repository("renderingsRepository")
public class RenderingsRepositoryJpa extends DomainRepositoryJpa<Renderings> implements IRenderingsRepository {

	@Override
	public Class<Renderings> getRepositoryModelClass() {
		return Renderings.class;
	}

}
