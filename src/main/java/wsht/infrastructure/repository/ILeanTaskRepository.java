package wsht.infrastructure.repository;

import wsht.infrastructure.domain.entity.LeanTask;

public interface ILeanTaskRepository extends DomainRepository<LeanTask> {

	public boolean checkIfLeanTaskWithNameExists(String name);

	public void deleteLeanTaskDefinition(String taskName);
	
	public void errorStateForInstances(String taskName);
}
