package wsht.infrastructure.repository;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import wsht.exception.WSHTException;
import wsht.infrastructure.domain.entity.UserEntityInfo;

@Repository("userEntityInfoRepository")
public class UserEntityInfoRepositoryJpa extends DomainRepositoryJpa<UserEntityInfo> implements IUserEntityInfoRepository {

	public Class<UserEntityInfo> getRepositoryModelClass() {
		return UserEntityInfo.class;
	}

	public List<UserEntityInfo> getUserEntityInfoByUserNames(Set<String> userNames) throws WSHTException {
			Session session = (Session) getEntityManager().getDelegate();
			Criteria criteria = session.createCriteria(getRepositoryModelClass());
			criteria.add(Restrictions.in("userName", userNames));
			criteria.add(Restrictions.eq("active", true));
			List<UserEntityInfo> userInfos = (List<UserEntityInfo>) criteria.list();
			return userInfos;
	}
	public List<UserEntityInfo> getUserEntityInfoByGroupNames(Set<String> groupNames) throws WSHTException {
		Session session = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(getRepositoryModelClass());
		Criteria groupCriteria = criteria.createCriteria("groupInfos");
		groupCriteria.add(Restrictions.in("groupName", groupNames));
		criteria.add(Restrictions.eq("active", true));
		List<UserEntityInfo> userInfos = (List<UserEntityInfo>) criteria.list();
		return userInfos;
	}
	
	public List<UserEntityInfo> getUserEntityInfoByArgument(String logicalPeopleGroup, String param, Object value) throws WSHTException {
		Session session = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(getRepositoryModelClass());
		Criteria groupCriteria = criteria.createCriteria("groupInfos");
		groupCriteria.add(Restrictions.eq("groupCode", logicalPeopleGroup));
		groupCriteria.add(Restrictions.eq(param, value));
		criteria.add(Restrictions.eq("active", true));
		List<UserEntityInfo> userInfos = (List<UserEntityInfo>) criteria.list();
		return userInfos;
	}
	

	public UserEntityInfo getUserEntity(String username, String password) throws WSHTException {
		Session session = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(getRepositoryModelClass());
		criteria.add(Restrictions.eq("userName", username));
		criteria.add(Restrictions.eq("password", password));
		criteria.add(Restrictions.eq("active", true));
		try {
			return (UserEntityInfo) criteria.uniqueResult();
		} catch(Throwable t) {
			throw new WSHTException(t.getMessage());
		}
	}


}
