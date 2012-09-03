package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.CompletionBehavior;

@Repository("completionBehaviorRepository")
public class CompletionBehaviorRepositoryJpa extends DomainRepositoryJpa<CompletionBehavior> implements ICompletionBehaviorRepository {


	@Override
	public Class<CompletionBehavior> getRepositoryModelClass() {
		return CompletionBehavior.class;
	}

}
