package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.BooleanExpr;

@Repository("booleanExprRepository")
public class BooleanExprRepositoryJpa extends DomainRepositoryJpa<BooleanExpr> implements
		IBooleanExprRepository {

	@Override
	public Class<BooleanExpr> getRepositoryModelClass() {
		return BooleanExpr.class;
	}

}
