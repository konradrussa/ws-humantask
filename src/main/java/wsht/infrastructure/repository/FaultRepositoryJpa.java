package wsht.infrastructure.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.Fault;
import wsht.marshalling.exception.WSHTException;

@Repository("faultRepository")
public class FaultRepositoryJpa extends DomainRepositoryJpa<Fault> implements IFaultRepository {

	@Override
	public Class<Fault> getRepositoryModelClass() {
		return Fault.class;
	}

	@Override
	public Fault getFaultByIdentifier(String identifier) throws WSHTException {
		Session session  = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(getRepositoryModelClass());
		criteria.add(Restrictions.eq("identifier", identifier));
		return (Fault) criteria.uniqueResult();

	}

}
