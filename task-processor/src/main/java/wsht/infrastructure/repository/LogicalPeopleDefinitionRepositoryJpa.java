package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.LogicalPeopleDefinition;

@Repository("logicalPeopleDefinitionRepository")
public class LogicalPeopleDefinitionRepositoryJpa extends DomainRepositoryJpa<LogicalPeopleDefinition> implements ILogicalPeopleDefinitionRepository {

	public Class<LogicalPeopleDefinition> getRepositoryModelClass() {
		return LogicalPeopleDefinition.class;
	}

}
