package wsht.runtime.model.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import wsht.exception.WSHTException;
import wsht.infrastructure.domain.entity.LogicalPeopleDefinition;
import wsht.infrastructure.domain.entity.LogicalPeopleGroup;
import wsht.infrastructure.domain.entity.UserEntityInfo;
import wsht.infrastructure.service.IRepositoryService;
import wsht.runtime.expressions.sbql.ast.operators.wsht.ext.IValuable;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.store.TaskInstance;
import wsht.runtime.expressions.sbql.util.SBQLUtil;
import wsht.runtime.model.TaskModel;

@Service("peopleQuery")
public class PeopleQueryImpl implements IPeopleQuery {
	
	@Resource
	private IRepositoryService repositoryService;
	
	@Resource
	private IValuable expressionContextService;
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor={Throwable.class})
	public List<LogicalPeopleDefinition> evaluate(TaskInstance instance, Map<String, TaskModel.Tuple> peopleRolesAssignment) throws WSHTException {
		List<LogicalPeopleDefinition> logicalPeopleDefinitions = new ArrayList<LogicalPeopleDefinition>();
		
		
		for(String roleName : peopleRolesAssignment.keySet()) {
			LogicalPeopleDefinition logicalPeopleDefinition = new LogicalPeopleDefinition();
			
			TaskModel.Tuple tuple = peopleRolesAssignment.get(roleName);
			String logicalPeopleGroup = tuple.getLogicalPeopleGroup();
			String argumentName = tuple.getArgumentName();
			String expression = tuple.getExpression();
			Set<String> groups = tuple.getGroups();
			Set<String> users = tuple.getUsers();
			
			List<UserEntityInfo> usersToAssignment = new ArrayList<UserEntityInfo>();
			
			if(!StringUtils.isBlank(tuple.getArgumentName())) {
				AbstractQueryResult res = expressionContextService.evalExternal(expression, instance, false);
				List<UserEntityInfo> usersInfo = repositoryService.getUserEntityInfoByArgument(logicalPeopleGroup, argumentName, SBQLUtil.getQueryResultValue(res));
				usersToAssignment.addAll(usersInfo);
			}
			if(users != null) {
				List<UserEntityInfo> usersInfo = repositoryService.getUserEntityInfoByUserNames(users);
				usersToAssignment.addAll(usersInfo);
			}
			
			if(groups != null) {
				List<UserEntityInfo> usersInfo = repositoryService.getUserEntityInfoByGroupNames(groups);
				usersToAssignment.addAll(usersInfo);
			}
			
			logicalPeopleDefinition.setRoleName(roleName);
			logicalPeopleDefinition.setLogicalPeopleName(logicalPeopleGroup);
			logicalPeopleDefinition.setUserInfos(usersToAssignment);	
			logicalPeopleDefinitions.add(logicalPeopleDefinition);
		}
		
		return logicalPeopleDefinitions;
	}
	
	
}
