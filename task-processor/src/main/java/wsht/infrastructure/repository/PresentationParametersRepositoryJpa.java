package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.PresentationParameters;

@Repository("presentationParametersRepository")
public class PresentationParametersRepositoryJpa extends DomainRepositoryJpa<PresentationParameters>
		implements IPresentationParametersRepository {

	@Override
	public Class<PresentationParameters> getRepositoryModelClass() {
		return PresentationParameters.class;
	}

}
