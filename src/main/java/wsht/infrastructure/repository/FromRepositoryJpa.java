package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.From;

@Repository("fromRepository")
public class FromRepositoryJpa extends DomainRepositoryJpa<From> implements IFromRepository {

	@Override
	public Class<From> getRepositoryModelClass() {
		return From.class;
	}

}
