package wsht.infrastructure.repository;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.GroupEntityInfo;

@Repository("groupEntityInfoRepository")
public class GroupEntityInfoRepositoryJpa extends DomainRepositoryJpa<GroupEntityInfo> implements IGroupEntityInfoRepository {

	public Class<GroupEntityInfo> getRepositoryModelClass() {
		return GroupEntityInfo.class;
	}


	public List<GroupEntityInfo> getGroupEntityInfoByGroupCodes(Set<String> groupCodes) {
		Session session = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(getRepositoryModelClass());
		criteria.add(Restrictions.in("groupCode", groupCodes));
		criteria.add(Restrictions.eq("active", true));
		return criteria.list();
	}

}
