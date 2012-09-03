package wsht.infrastructure.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.LeanTask;

@Repository("leanTaskRepository")
public class LeanTaskRepositoryJpa extends DomainRepositoryJpa<LeanTask> implements ILeanTaskRepository {

	@Override
	public Class<LeanTask> getRepositoryModelClass() {
		return LeanTask.class;
	}

	@Override
	public boolean checkIfLeanTaskWithNameExists(String name) {
		Session session  = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(getRepositoryModelClass());
		criteria.add(Restrictions.eq("name", name));
		criteria.setProjection(Projections.rowCount());
		Integer count = (Integer) criteria.uniqueResult();
		return count > 0;
	}

	@Override
	public void deleteLeanTaskDefinition(String taskName) {
		
		
	}

	@Override
	public void errorStateForInstances(String taskName) {
		
		
	}

}
