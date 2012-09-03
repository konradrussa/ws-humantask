package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.Completion;

@Repository("completionRepository")
public class CompletionRepositoryJpa extends DomainRepositoryJpa<Completion> implements
		ICompletionRepository {

	@Override
	public Class<Completion> getRepositoryModelClass() {
		return Completion.class;
	}

}
