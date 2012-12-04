package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.PresentationParameter;

@Repository("presentationParameterRepository")
public class PresentationParameterRepositoryJpa extends DomainRepositoryJpa<PresentationParameter> implements
		IPresentationParameterRepository {


	@Override
	public Class<PresentationParameter> getRepositoryModelClass() {
		return PresentationParameter.class;
	}

}
