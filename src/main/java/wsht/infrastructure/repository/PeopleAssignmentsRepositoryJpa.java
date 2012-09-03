package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.PeopleAssignments;

@Repository("peopleAssignmentsRepository")
public class PeopleAssignmentsRepositoryJpa extends DomainRepositoryJpa<PeopleAssignments> implements IPeopleAssignmentsRepository {

	@Override
	public Class<PeopleAssignments> getRepositoryModelClass() {
		return PeopleAssignments.class;
	}

}
