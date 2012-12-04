package wsht.infrastructure.repository;

import wsht.infrastructure.domain.entity.OrganizationalEntity;
import wsht.infrastructure.domain.entity.TaskInfo;

public interface ITaskInfoRepository extends DomainRepository<TaskInfo> {

	public TaskInfo getTaskInfoByTaskIdentifier(String taskIdentifier);
	
	public OrganizationalEntity getGetActualOwnerByTaskIdentifier(String taskIdentifier);
}
