package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.GenericHumanRoleAssignment;

@Repository("genericHumanRoleAssignmentRepository")
public class GenericHumanRoleAssignmentRepositoryJpa extends
		DomainRepositoryJpa<GenericHumanRoleAssignment> implements
		IGenericHumanRoleAssignmentRepository {

	@Override
	public Class<GenericHumanRoleAssignment> getRepositoryModelClass() {
		return GenericHumanRoleAssignment.class;
	}

}