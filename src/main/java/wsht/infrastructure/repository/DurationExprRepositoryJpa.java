package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.DurationExpr;

@Repository("durationExprRepository")
public class DurationExprRepositoryJpa extends DomainRepositoryJpa<DurationExpr> implements IDurationExprRepository {

	@Override
	public Class<DurationExpr> getRepositoryModelClass() {
		return DurationExpr.class;
	}

}
