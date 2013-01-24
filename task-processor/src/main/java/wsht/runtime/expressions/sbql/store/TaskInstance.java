package wsht.runtime.expressions.sbql.store;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TaskInstance implements Serializable {
	private static final long serialVersionUID = -1197863679289848316L;
	
	//pola systemowe
	private String taskIdentifier;
	private Integer taskPriority;
	
	private Date startDeadline;
	private Date endDeadline;
	
	
	//must be as first element
	//lista danych zewnetrznych
	private List<Object> content;
	
	private Date created;
	public final static String _F_createdField = "created";
	
	private ActualOwner actualOwner;
	public final static String _F_actualOwnerField = "actualOwner";
	
	private List<Recipient> recipients;
	public final static String _F_recipientsField = "recipients";
	
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
	
	private List<LogicalPeopleGroup> logicalPeopleGroups;
	public final static String _F_logicalPeopleGroupsField = "logicalPeopleGroups";
	
	private Map<String, String> contextData;

	
	public Map<String, String> getContextData() {
		return contextData;
	}

	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}

	public TaskInstance(String taskIdentifier) {
		content = new LinkedList<Object>();
		actualOwner = new ActualOwner("not assigned");
		taskInitiator = new TaskInitiator("not assigned");
		potentialOwners = new LinkedList<TaskInstance.PotentialOwner>();
		excludedOwners = new LinkedList<TaskInstance.ExcludedOwner>();
		businessAdministrators = new LinkedList<TaskInstance.BusinessAdministrator>();
		taskStakeholders = new LinkedList<TaskInstance.TaskStakeholder>();
		logicalPeopleGroups = new LinkedList<TaskInstance.LogicalPeopleGroup>();
		recipients = new LinkedList<TaskInstance.Recipient>();
		this.taskIdentifier = taskIdentifier;
		contextData = new HashMap<String, String>();
		created = new Date();
	}
	
	public String getTaskIdentifier() {
		return taskIdentifier;
	}
	public void setTaskIdentifier(String taskIdentifier) {
		this.taskIdentifier = taskIdentifier;
	}
	
	public Integer getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(Integer taskPriority) {
		this.taskPriority = taskPriority;
	}

	public List<Object> getContent() {
		return content;
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

	public List<LogicalPeopleGroup> getLogicalPeopleGroups() {
		return logicalPeopleGroups;
	}

	public Object getProperObject(String className) {
		for(Object o : getContent()) {
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
		logicalPeopleGroups.add(new LogicalPeopleGroup(id));
	}
	
	public void fillInRecipient(String id) {
		recipients.add(new Recipient(id));
	}
	
	public void removeFromLogicalPeopleGroup(String id) {
		for(Iterator<LogicalPeopleGroup> it = logicalPeopleGroups.iterator(); it.hasNext();) {
			LogicalPeopleGroup lpg = it.next();
			if(lpg.id.equals(id)) {
				it.remove();
			}
		}
	}
	
	//inner classes
	class ActualOwner implements Serializable {
		private static final long serialVersionUID = 8553848771351706224L;
		private String id;
		
		public ActualOwner(String id){this.id = id;}

		public String getId() {
			return id;
		}
	}
	
	class PotentialOwner implements Serializable {
		private static final long serialVersionUID = -6082543335355923138L;
		private String id;
		
		public PotentialOwner(String id){this.id = id;}

		public String getId() {
			return id;
		}
	}
	
	class BusinessAdministrator implements Serializable {
		private static final long serialVersionUID = 8010998619780799581L;
		private String id;
		
		public BusinessAdministrator(String id){this.id = id;}

		public String getId() {
			return id;
		}
	}
	
	class ExcludedOwner implements Serializable {
		private static final long serialVersionUID = -4954747684173261975L;
		private String id;
		
		public ExcludedOwner(String id){this.id = id;}

		public String getId() {
			return id;
		}
	}
	
	class TaskInitiator implements Serializable {
		private static final long serialVersionUID = -709445551320446399L;
		private String id;
		
		public TaskInitiator(String id){this.id = id;}

		public String getId() {
			return id;
		}
	}
	
	class TaskStakeholder implements Serializable {
		private static final long serialVersionUID = -2729911760242330773L;
		private String id;
		
		public TaskStakeholder(String id){this.id = id;}

		public String getId() {
			return id;
		}
	}
	
	class LogicalPeopleGroup implements Serializable {
		private static final long serialVersionUID = 3830895302061413820L;
		private String id;
		
		public LogicalPeopleGroup(String id){this.id = id;}

		public String getId() {
			return id;
		}
	}
	
	class Recipient implements Serializable {
		private static final long serialVersionUID = -3014893896163006268L;
		private String id;
		
		public Recipient(String id){this.id = id;}

		public String getId() {
			return id;
		}
	}
	
	
	
}
