package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.Sequence;

@Repository("sequenceRepository")
public class SequenceRepositoryJpa extends DomainRepositoryJpa<Sequence> implements ISequenceRepository {

	@Override
	public Class<Sequence> getRepositoryModelClass() {
		return Sequence.class;
	}

}
