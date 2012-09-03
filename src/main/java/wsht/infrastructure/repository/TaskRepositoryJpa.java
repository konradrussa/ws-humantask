package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.Task;

@Repository("taskRepository")
public class TaskRepositoryJpa extends DomainRepositoryJpa<Task> implements ITaskRepository {


	@Override
	public Class<Task> getRepositoryModelClass() {
		return Task.class;
	}

}
