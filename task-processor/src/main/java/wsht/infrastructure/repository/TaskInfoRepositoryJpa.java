package wsht.infrastructure.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.OrganizationalEntity;
import wsht.infrastructure.domain.entity.TaskInfo;

@Repository("taskInfoRepository")
public class TaskInfoRepositoryJpa extends DomainRepositoryJpa<TaskInfo> implements ITaskInfoRepository {

	public Class<TaskInfo> getRepositoryModelClass() {
		return TaskInfo.class;
	}

	public TaskInfo getTaskInfoByTaskIdentifier(String taskIdentifier) {
		Session session  = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(getRepositoryModelClass());
		criteria.add(Restrictions.eq("taskIdentifier", taskIdentifier));
		return (TaskInfo) criteria.uniqueResult();
	}

	public OrganizationalEntity getGetActualOwnerByTaskIdentifier(String taskIdentifier) {
		Session session  = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(getRepositoryModelClass());
		criteria.add(Restrictions.eq("taskIdentifier", taskIdentifier));
		TaskInfo task = (TaskInfo) criteria.uniqueResult();
		return task.getOwner();
	}	

}
