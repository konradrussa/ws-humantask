package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.Result;

@Repository("resultRepository")
public class ResultRepositoryJpa extends DomainRepositoryJpa<Result> implements IResultRepository {

	@Override
	public Class<Result> getRepositoryModelClass() {
		return Result.class;
	}

}
