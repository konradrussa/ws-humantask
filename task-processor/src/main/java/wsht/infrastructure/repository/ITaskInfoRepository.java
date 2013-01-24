package wsht.infrastructure.repository;

import java.util.List;

import wsht.exception.WSHTException;
import wsht.infrastructure.domain.entity.OrganizationalEntity;
import wsht.infrastructure.domain.entity.TaskInfo;
import wsht.infrastructure.domain.entity.UserEntityInfo;

public interface ITaskInfoRepository extends DomainRepository<TaskInfo> {

	public TaskInfo getTaskInfoByTaskIdentifier(String taskIdentifier) throws WSHTException;
	
	public TaskInfo getLeanTaskTaskInfoByTaskIdentifier(String taskIdentifier) throws WSHTException;
	
	public UserEntityInfo getGetActualOwnerByTaskIdentifier(String taskIdentifier) throws WSHTException;

	public List<TaskInfo> getLeanTaskTaskInfosByUsernameIsPotentialOwner(String username);

	public List<TaskInfo> getLeanTaskTaskInfosByUsernameIsBusinessAdministrator(String username);
}
