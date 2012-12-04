package wsht.infrastructure.repository;

import java.util.List;

import wsht.infrastructure.domain.entity.LeanTask;
import wsht.marshalling.exception.WSHTException;

public interface ILeanTaskRepository extends DomainRepository<LeanTask> {

	public boolean checkIfLeanTaskWithNameExists(String name);

	public void deleteLeanTaskDefinition(String taskName) throws WSHTException;
	
	public void errorStateForInstances(String taskName) throws WSHTException;
	
	public LeanTask createLeanTaskDefinition(LeanTask leanTask) throws WSHTException;
	
	public List<LeanTask> listLeanTaskDefinitions() throws WSHTException;
}
