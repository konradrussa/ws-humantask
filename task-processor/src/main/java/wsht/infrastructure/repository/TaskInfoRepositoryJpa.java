package wsht.infrastructure.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import wsht.exception.WSHTException;
import wsht.infrastructure.domain.entity.OrganizationalEntity;
import wsht.infrastructure.domain.entity.TaskInfo;
import wsht.infrastructure.domain.entity.UserEntityInfo;

@Repository("taskInfoRepository")
public class TaskInfoRepositoryJpa extends DomainRepositoryJpa<TaskInfo> implements ITaskInfoRepository {

	public Class<TaskInfo> getRepositoryModelClass() {
		return TaskInfo.class;
	}

	public TaskInfo getTaskInfoByTaskIdentifier(String taskIdentifier) throws WSHTException {
		Session session  = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(getRepositoryModelClass());
		criteria.add(Restrictions.eq("taskIdentifier", taskIdentifier));
		try {
			return (TaskInfo) criteria.uniqueResult();
		} catch(Throwable t) {
			throw new WSHTException(t.getMessage());
		}
	}
	
	public TaskInfo getLeanTaskTaskInfoByTaskIdentifier(String taskIdentifier) throws WSHTException {
		Session session  = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(getRepositoryModelClass());
		criteria.add(Restrictions.eq("taskIdentifier", taskIdentifier));
		criteria.add(Restrictions.eq("isSubtask", true));
		try {
			return (TaskInfo) criteria.uniqueResult();
		} catch(Throwable t) {
			throw new WSHTException(t.getMessage());
		}
	}

	public UserEntityInfo getGetActualOwnerByTaskIdentifier(String taskIdentifier) throws WSHTException {
		Session session  = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(getRepositoryModelClass());
		criteria.add(Restrictions.eq("taskIdentifier", taskIdentifier));
		try {
			TaskInfo task = (TaskInfo) criteria.uniqueResult();
			return task.getOwner();
		} catch(Throwable t) {
			throw new WSHTException(t.getMessage());
		}
	}

	@Override
	public List<TaskInfo> getLeanTaskTaskInfosByUsernameIsPotentialOwner(String username) {
		Session session  = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(getRepositoryModelClass());
		Criteria potentialOwner =criteria.createCriteria("potentialOwners");
		potentialOwner.add(Restrictions.eq("userName", username));
		criteria.add(Restrictions.eq("isSubtask", true));
		return criteria.list();
	}
	
	@Override
	public List<TaskInfo> getLeanTaskTaskInfosByUsernameIsBusinessAdministrator(String username) {
		Session session  = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(getRepositoryModelClass());
		Criteria potentialOwner =criteria.createCriteria("businessAdministrators");
		potentialOwner.add(Restrictions.eq("userName", username));
		criteria.add(Restrictions.eq("isSubtask", true));
		return criteria.list();
	}

}
