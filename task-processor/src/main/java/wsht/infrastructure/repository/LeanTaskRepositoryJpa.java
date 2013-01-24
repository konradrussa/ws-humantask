package wsht.infrastructure.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.LeanTask;
import wsht.exception.WSHTException;

@Repository("leanTaskRepository")
public class LeanTaskRepositoryJpa extends DomainRepositoryJpa<LeanTask> implements ILeanTaskRepository {

	
	
	public Class<LeanTask> getRepositoryModelClass() {
		return LeanTask.class;
	}

	
	public boolean checkIfLeanTaskDefinitionWithNameExists(String taskName) {
		Session session = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(getRepositoryModelClass());
		criteria.add(Restrictions.eq("name", taskName));
		criteria.add(Restrictions.eq("definition", true));
		criteria.add(Restrictions.eq("deleted", false));
		criteria.setProjection(Projections.rowCount());
		Long count = (Long) criteria.uniqueResult();
		return count > 0;
		
	}

	
	public void deleteLeanTaskDefinition(LeanTask leanTask) throws WSHTException {
		try {
			leanTask.setDeleted(true);
			update(leanTask);
		} catch(HibernateException e) {
			throw new WSHTException(e.getMessage(), e);
		} catch(Throwable t) {
			throw new WSHTException(t.getMessage());
		}
	}

	
	public void errorStateForInstances(LeanTask leanTask) throws WSHTException {
		
		
	}
	
	public LeanTask createLeanTaskDefinition(LeanTask leanTask) throws WSHTException {
		try {
			leanTask.setDefinition(true);
			return create(leanTask);
		} catch(HibernateException e) {
			throw new WSHTException(e.getMessage(), e);
		} catch(Throwable t) {
			throw new WSHTException(t.getMessage());
		}
	}
	
	public List<LeanTask> listLeanTaskDefinitions() throws WSHTException {
		Session session  = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(getRepositoryModelClass());
		criteria.add(Restrictions.eq("definition", true));
		criteria.add(Restrictions.eq("deleted", false));
		List<LeanTask> leanTasksDefinitions = criteria.list();
		return leanTasksDefinitions;
	}
	
	public LeanTask getLeanTaskDefinitionByName(String taskName) throws WSHTException {
		Session session  = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(getRepositoryModelClass());
		criteria.add(Restrictions.eq("name", taskName));
		criteria.add(Restrictions.eq("definition", true));
		criteria.add(Restrictions.eq("deleted", false));
		try {
			LeanTask leanTask = (LeanTask) criteria.uniqueResult();
			return leanTask;
		} catch(HibernateException e) {
			throw new WSHTException(e.getMessage(), e);
		} catch(Throwable e) {
			throw new WSHTException(e.getMessage(), e);
		}
		
	}

}
