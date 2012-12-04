package wsht.infrastructure.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.LeanTask;
import wsht.marshalling.exception.WSHTException;

@Repository("leanTaskRepository")
public class LeanTaskRepositoryJpa extends DomainRepositoryJpa<LeanTask> implements ILeanTaskRepository {

	
	public Class<LeanTask> getRepositoryModelClass() {
		return LeanTask.class;
	}

	
	public boolean checkIfLeanTaskWithNameExists(String name) {
		Session session  = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(getRepositoryModelClass());
		criteria.add(Restrictions.eq("name", name));
		criteria.setProjection(Projections.rowCount());
		Integer count = (Integer) criteria.uniqueResult();
		return count > 0;
	}

	
	public void deleteLeanTaskDefinition(String taskName) throws WSHTException {
		
		
	}

	
	public void errorStateForInstances(String taskName) throws WSHTException {
		
		
	}
	
	public LeanTask createLeanTaskDefinition(LeanTask leanTask) throws WSHTException {
		leanTask.setDefinition(true);
		return create(leanTask);
	}
	
	public List<LeanTask> listLeanTaskDefinitions() throws WSHTException {
		Session session  = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(getRepositoryModelClass());
		criteria.add(Restrictions.eq("definition", true));
		List<LeanTask> leanTasksDefinitions = criteria.list();
		return leanTasksDefinitions;
	}

}
