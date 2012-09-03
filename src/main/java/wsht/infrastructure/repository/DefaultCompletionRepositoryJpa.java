package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.DefaultCompletion;

@Repository("defaultCompletionRepository")
public class DefaultCompletionRepositoryJpa extends DomainRepositoryJpa<DefaultCompletion> implements IDefaultCompletionRepository {

	@Override
	public Class<DefaultCompletion> getRepositoryModelClass() {
		return DefaultCompletion.class;
	}

}
