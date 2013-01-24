package wsht.infrastructure.repository;

import java.util.List;

import wsht.infrastructure.domain.entity.LeanTask;
import wsht.exception.WSHTException;

public interface ILeanTaskRepository extends DomainRepository<LeanTask> {

	public boolean checkIfLeanTaskDefinitionWithNameExists(String name);

	public void deleteLeanTaskDefinition(LeanTask leanTask) throws WSHTException;
	
	public void errorStateForInstances(LeanTask leanTask) throws WSHTException;
	public LeanTask getLeanTaskDefinitionByName(String taskName) throws WSHTException;
	
	public LeanTask createLeanTaskDefinition(LeanTask leanTask) throws WSHTException;
	
	public List<LeanTask> listLeanTaskDefinitions() throws WSHTException;
}
