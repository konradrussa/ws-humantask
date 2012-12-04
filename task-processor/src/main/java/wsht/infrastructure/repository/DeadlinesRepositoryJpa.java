package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.Deadlines;

@Repository("deadlinesRepository")
public class DeadlinesRepositoryJpa extends DomainRepositoryJpa<Deadlines> implements IDeadlinesRepository {

	@Override
	public Class<Deadlines> getRepositoryModelClass() {
		return Deadlines.class;
	}

}
