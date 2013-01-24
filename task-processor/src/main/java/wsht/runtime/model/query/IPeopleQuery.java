package wsht.runtime.model.query;

import java.util.List;
import java.util.Map;

import wsht.exception.WSHTException;
import wsht.infrastructure.domain.entity.LogicalPeopleDefinition;
import wsht.infrastructure.domain.entity.LogicalPeopleGroup;
import wsht.runtime.expressions.sbql.store.TaskInstance;
import wsht.runtime.model.TaskModel;

public interface IPeopleQuery {

	public List<LogicalPeopleDefinition> evaluate(TaskInstance instance, Map<String, TaskModel.Tuple> peopleRolesAssignment) throws WSHTException;
}
