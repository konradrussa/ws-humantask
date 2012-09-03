package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.Deadline;

@Repository("deadlineRepository")
public class DeadlineRepositoryJpa extends DomainRepositoryJpa<Deadline> implements IDeadlineRepository {

	@Override
	public Class<Deadline> getRepositoryModelClass() {
		return Deadline.class;
	}

}
