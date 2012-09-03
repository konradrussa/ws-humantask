package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.DeadlineExpr;

@Repository("deadlineExprRepository")
public class DeadlineExprRepositoryJpa extends DomainRepositoryJpa<DeadlineExpr> implements IDeadlineExprRepository {

	@Override
	public Class<DeadlineExpr> getRepositoryModelClass() {
		return DeadlineExpr.class;
	}

}
