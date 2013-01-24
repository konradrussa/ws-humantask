package wsht.infrastructure.repository;

import java.util.List;
import java.util.Set;

import wsht.exception.WSHTException;
import wsht.infrastructure.domain.entity.UserEntityInfo;

public interface IUserEntityInfoRepository extends DomainRepository<UserEntityInfo> {
	
	public List<UserEntityInfo> getUserEntityInfoByUserNames(Set<String> userNames) throws WSHTException;
	public UserEntityInfo getUserEntity(String username, String password)  throws WSHTException;
	public List<UserEntityInfo> getUserEntityInfoByArgument(String logicalPeopleGroup, String param, Object value) throws WSHTException;
	public List<UserEntityInfo> getUserEntityInfoByGroupNames(Set<String> groupNames) throws WSHTException;
	
}
