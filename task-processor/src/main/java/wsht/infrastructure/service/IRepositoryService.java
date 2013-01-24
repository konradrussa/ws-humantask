package wsht.infrastructure.service;

import java.util.List;
import java.util.Set;

import com.db4o.ObjectSet;

import wsht.infrastructure.domain.entity.Attachment;
import wsht.infrastructure.domain.entity.Comment;
import wsht.infrastructure.domain.entity.Comments;
import wsht.infrastructure.domain.entity.Fault;
import wsht.infrastructure.domain.entity.GroupEntityInfo;
import wsht.infrastructure.domain.entity.HumanInteractions;
import wsht.infrastructure.domain.entity.LeanTask;
import wsht.infrastructure.domain.entity.LogicalPeopleDefinition;
import wsht.infrastructure.domain.entity.TaskInfo;
import wsht.infrastructure.domain.entity.UserEntityInfo;
import wsht.exception.WSHTException;

public interface IRepositoryService {

	public TaskInfo createTaskInfo(TaskInfo task);
	public void updateTaskInfo(TaskInfo taskInfo);
	public List<TaskInfo> getAllTasksInfo();
	public LeanTask getLeanTaskDefinitionByName(String taskName) throws WSHTException;
	public TaskInfo getTaskInfoByTaskIdentifier(String taskIdentifier) throws WSHTException;
	public TaskInfo getLeanTaskTaskInfoByTaskIdentifier(String taskIdentifier) throws WSHTException;
	
	public List<TaskInfo> getTaskInfoByUserAndTaskType(String username, String roleType, boolean isLeanTask)  throws WSHTException;
	
	
	public boolean checkIfLeanTaskDefinitionWithNameExists(String leanTaskName);
	public LeanTask createLeanTaskDefinition(LeanTask leanTask)  throws WSHTException;
	public void deleteLeanTaskDefinition(String taskName) throws WSHTException;
	public List<LeanTask> listLeanTaskDefinitions() throws WSHTException;
	
	public Fault createFault(Fault f);
	public void deleteFault(Long id) throws WSHTException;
	
	public Comment createComment(Comment comment);
	public void deleteComment(Comment comment) throws WSHTException;
	public void mergeComments(Comments comments);
	
	public void deleteAttachment(Attachment attachment) throws WSHTException;

	public HumanInteractions createHumanInteractions(HumanInteractions hi);
	
	public List<UserEntityInfo> getUserEntityInfoByUserNames(Set<String> userNames) throws WSHTException;
	public UserEntityInfo getUserEntity(String username, String password) throws WSHTException;
	public List<UserEntityInfo> getUserEntityInfoByArgument(String logicalPeopleGroup, String param, Object value) throws WSHTException;
	public List<GroupEntityInfo> getGroupEntityInfoByGroupCodes(Set<String> groupCodes) throws WSHTException;
	public List<UserEntityInfo> getUserEntityInfoByGroupNames(Set<String> groupNames) throws WSHTException;
	
	public List<LogicalPeopleDefinition> createLogicalPeopleDefinitions(List<LogicalPeopleDefinition> logicalPeopleDefinitions) throws WSHTException;
}
