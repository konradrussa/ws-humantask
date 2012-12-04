package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.Aggregate;

@Repository("aggregateRepository")
public class AggregateRepositoryJpa extends DomainRepositoryJpa<Aggregate> implements IAggregateRepository {

	@Override
	public Class<Aggregate> getRepositoryModelClass() {
		return Aggregate.class;
	}

}
