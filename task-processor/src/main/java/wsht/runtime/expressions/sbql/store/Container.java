package wsht.runtime.expressions.sbql.store;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Container {
	
	private String taskIdentifier;
	
	//must be as first element
	private volatile List<Object> content;
	
	private ActualOwner actualOwner;
	public final static String _F_actualOwnerField = "actualOwner";
	
	private TaskInitiator taskInitiator;
	public final static String _F_taskInitiatorField = "taskInitiator";
	
	private List<PotentialOwner> potentialOwners;
	public final static String _F_potentialOwnersField = "potentialOwners";
	
	private List<ExcludedOwner> excludedOwners;
	public final static String _F_excludedOwnersField = "excludedOwners";
	
	private List<BusinessAdministrator> businessAdministrators;
	public final static String _F_businessAdministratorsField = "businessAdministrators";
	
	private List<TaskStakeholder> taskStakeholders;
	public final static String _F_taskStakeholdersField = "taskStakeholders";
	
	private LogicalPeopleGroup logicalPeopleGroup;
	public final static String _F_logicalPeopleGroupField = "logicalPeopleGroup";
	
	public Map<String, String> contextData = new HashMap<String, String>();
	
	public Container(String taskIdentifier) {
		content = new LinkedList<Object>();
		this.taskIdentifier = taskIdentifier;
		potentialOwners = new LinkedList<Container.PotentialOwner>();
		excludedOwners = new LinkedList<Container.ExcludedOwner>();
		businessAdministrators = new LinkedList<Container.BusinessAdministrator>();
		taskStakeholders = new LinkedList<Container.TaskStakeholder>();
	}
	
	public String getTaskIdentifier() {
		return taskIdentifier;
	}
	public void setTaskIdentifier(String taskIdentifier) {
		this.taskIdentifier = taskIdentifier;
	}
	public List<Object> getContent() {
		synchronized (content) {
			content.notify();
			return content;
		}
		
	}
	
	public ActualOwner getActualOwner() {
		return actualOwner;
	}

	public TaskInitiator getTaskInitiator() {
		return taskInitiator;
	}

	public List<PotentialOwner> getPotentialOwners() {
		return potentialOwners;
	}

	public List<ExcludedOwner> getExcludedOwners() {
		return excludedOwners;
	}

	public List<BusinessAdministrator> getBusinessAdministrators() {
		return businessAdministrators;
	}

	public List<TaskStakeholder> getTaskStakeholders() {
		return taskStakeholders;
	}

	public LogicalPeopleGroup getLogicalPeopleGroup() {
		return logicalPeopleGroup;
	}

	public Object getProperObject(String className) {
		for(Object o : content) {
			if(o.getClass().getSimpleName().equals(className)) {
				return o;
			}
		}
		return null;
	}
	
	public void fillInActualOwner(String id) {
		actualOwner = new ActualOwner(id);
	}
	
	public void fillInPotentialOwner(String id) {
		potentialOwners.add(new PotentialOwner(id));
	}
	
	public void fillInBusinessAdministrator(String id) {
		businessAdministrators.add(new BusinessAdministrator(id));
	}
	
	public void fillInTaskStakeholders(String id) {
		taskStakeholders.add(new TaskStakeholder(id));
	}
	
	public void fillInExcludedOwner(String id) {
		excludedOwners.add(new ExcludedOwner(id));
	}
	
	public void fillInTaskInitiator(String id) {
		taskInitiator = new TaskInitiator(id);
	}
	
	public void fillInLogicalPeopleGroup(String id) {
		logicalPeopleGroup = new LogicalPeopleGroup(id);
	}
	
	//inner classes
	class ActualOwner {
		private String id;
		
		public ActualOwner(String id){this.id = id;}

		public String getId() {
			return id;
		}
	}
	
	class PotentialOwner {
		private String id;
		
		public PotentialOwner(String id){this.id = id;}

		public String getId() {
			return id;
		}
	}
	
	class BusinessAdministrator {
		private String id;
		
		public BusinessAdministrator(String id){this.id = id;}

		public String getId() {
			return id;
		}
	}
	
	class ExcludedOwner {
		private String id;
		
		public ExcludedOwner(String id){this.id = id;}

		public String getId() {
			return id;
		}
	}
	
	class TaskInitiator {
		private String id;
		
		public TaskInitiator(String id){this.id = id;}

		public String getId() {
			return id;
		}
	}
	
	class TaskStakeholder {
		private String id;
		
		public TaskStakeholder(String id){this.id = id;}

		public String getId() {
			return id;
		}
	}
	
	class LogicalPeopleGroup {
		private String id;
		
		public LogicalPeopleGroup(String id){this.id = id;}

		public String getId() {
			return id;
		}
	}
	
}
