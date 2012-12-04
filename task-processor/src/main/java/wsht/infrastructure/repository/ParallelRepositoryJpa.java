package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.Parallel;

@Repository("parallelRepositoryRepository")
public class ParallelRepositoryJpa extends DomainRepositoryJpa<Parallel> implements IParallelRepository {

	@Override
	public Class<Parallel> getRepositoryModelClass() {
		return Parallel.class;
	}

}
