package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.Query;

@Repository("queryRepository")
public class QueryRepositoryJpa extends DomainRepositoryJpa<Query> implements IQueryRepository {

	@Override
	public Class<Query> getRepositoryModelClass() {
		return Query.class;
	}

}
