package wsht.runtime.expressions.sbql.store;

import java.util.List;

public class Container {
	
	private String taskIdentifier;
	private List<Object> content;
	
	public Container(String taskIdentifier) {
		this.taskIdentifier = taskIdentifier;
	}
	
	public String getTaskIdentifier() {
		return taskIdentifier;
	}
	public void setTaskIdentifier(String taskIdentifier) {
		this.taskIdentifier = taskIdentifier;
	}
	public List<Object> getContent() {
		return content;
	}
	public void setContent(List<Object> content) {
		this.content = content;
	}
	
	public Object getProperObject(String className) {
		for(Object o : content) {
			if(o.getClass().getSimpleName().equals(className)) {
				return o;
			}
		}
		return null;
	}
	
	
}
