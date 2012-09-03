package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.Copy;

@Repository("copyRepository")
public class CopyRepositoryJpa extends DomainRepositoryJpa<Copy> implements ICopyRepository {

	@Override
	public Class<Copy> getRepositoryModelClass() {
		return Copy.class;
	}

}
