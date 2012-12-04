package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.PresentationElements;

@Repository("presentationElementsRepository")
public class PresentationElementsRepositoryJpa extends DomainRepositoryJpa<PresentationElements> implements IPresentationElementsRepository {

	@Override
	public Class<PresentationElements> getRepositoryModelClass() {
		return PresentationElements.class;
	}

}
