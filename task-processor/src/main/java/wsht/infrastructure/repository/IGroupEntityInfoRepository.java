package wsht.infrastructure.repository;

import java.util.List;
import java.util.Set;

import wsht.infrastructure.domain.entity.GroupEntityInfo;

public interface IGroupEntityInfoRepository extends DomainRepository<GroupEntityInfo> {

	public List<GroupEntityInfo> getGroupEntityInfoByGroupCodes(Set<String> groupCodes);
}
