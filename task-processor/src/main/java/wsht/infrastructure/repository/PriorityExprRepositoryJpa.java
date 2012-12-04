package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.PriorityExpr;

@Repository("priorityExprRepository")
public class PriorityExprRepositoryJpa extends DomainRepositoryJpa<PriorityExpr> implements IPriorityExprRepository {

	@Override
	public Class<PriorityExpr> getRepositoryModelClass() {
		return PriorityExpr.class;
	}

}
