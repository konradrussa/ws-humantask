package test.infrastructure;

import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import wsht.infrastructure.domain.entity.Query;
import wsht.infrastructure.domain.entity.Task;
import wsht.infrastructure.domain.entity.TaskInfo;
import wsht.infrastructure.domain.enums.BooleanEnum;
import wsht.infrastructure.service.IRepositoryService;
import wsht.runtime.enums.TaskStatesEnum;

public class TestSpringAndDB {

	@org.junit.Test
	public void testObjectDB() {
		// PropertyConfigurator.configure("log4j.properties");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/applicationContext.xml");

		IRepositoryService service = (IRepositoryService) context
				.getBean("repositoryService");
		Task task = new Task();
		task.setName("nazwa");
		Query query = new Query();
		task.setOutcome(query);
		task.setActualOwnerRequired(BooleanEnum.YES);

		TaskInfo taskInfo = new TaskInfo();
		taskInfo.setTaskIdentifier(UUID.randomUUID().toString().substring(0, 10));
		taskInfo.setTask(task);
		taskInfo.setState(TaskStatesEnum.IN_PROGRESS);

		taskInfo = service.prepareTaskInfo(taskInfo);
		List<TaskInfo> tasks = service.getAllTasksInfo();

		Assert.assertNotNull(tasks);
		Assert.assertTrue(tasks.size() > 0);

	}

}
