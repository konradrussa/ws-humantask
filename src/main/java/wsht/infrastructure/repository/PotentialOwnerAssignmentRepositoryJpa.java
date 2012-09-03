package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.PotentialOwnerAssignment;

@Repository("potentialOwnerAssignmentRepository")
public class PotentialOwnerAssignmentRepositoryJpa extends DomainRepositoryJpa<PotentialOwnerAssignment> implements IPotentialOwnerAssignmentRepository {

	@Override
	public Class<PotentialOwnerAssignment> getRepositoryModelClass() {
		return PotentialOwnerAssignment.class;
	}

}
