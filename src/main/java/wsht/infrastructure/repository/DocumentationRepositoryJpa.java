package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.Documentation;

@Repository("documentationRepository")
public class DocumentationRepositoryJpa extends DomainRepositoryJpa<Documentation> implements IDocumentationRepository {

	@Override
	public Class<Documentation> getRepositoryModelClass() {
		return Documentation.class;
	}

}
