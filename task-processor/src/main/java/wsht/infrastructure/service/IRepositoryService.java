package wsht.infrastructure.service;

import java.util.List;

import com.db4o.ObjectSet;

import wsht.infrastructure.domain.entity.Attachment;
import wsht.infrastructure.domain.entity.Comment;
import wsht.infrastructure.domain.entity.Fault;
import wsht.infrastructure.domain.entity.HumanInteractions;
import wsht.infrastructure.domain.entity.LeanTask;
import wsht.infrastructure.domain.entity.TaskInfo;
import wsht.marshalling.exception.WSHTException;

public interface IRepositoryService {

	public TaskInfo createTaskInfo(TaskInfo task);
	public void updateTaskInfo(TaskInfo taskInfo);
	public List<TaskInfo> getAllTasksInfo();
	public TaskInfo getTaskInfoByTaskIdentifier(String taskIdentifier);
	
	public boolean checkIfLeanTaskWithNameExists(String leanTaskName);
	public LeanTask createLeanTaskDefinition(LeanTask leanTask)  throws WSHTException;
	public void deleteLeanTask(String taskName) throws WSHTException;
	public List<LeanTask> listLeanTaskDefinitions() throws WSHTException;
	
	public Fault createFault(Fault f);
	public void deleteFault(Long id) throws WSHTException;
	
	public Comment createComment(Comment comment);
	public void deleteComment(Comment comment);
	
	public void deleteAttachment(Attachment attachment);

	public HumanInteractions createHumanInteractions(HumanInteractions hi);
	
	
}
