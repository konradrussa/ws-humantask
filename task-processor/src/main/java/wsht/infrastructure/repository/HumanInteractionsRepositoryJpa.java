package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.HumanInteractions;

@Repository("humanInteractionsRepository")
public class HumanInteractionsRepositoryJpa extends DomainRepositoryJpa<HumanInteractions> implements IHumanInteractionsRepository {

	@Override
	public Class<HumanInteractions> getRepositoryModelClass() {
		return HumanInteractions.class;
	}

}
