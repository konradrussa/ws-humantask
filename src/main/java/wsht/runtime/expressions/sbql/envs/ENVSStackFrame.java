package wsht.runtime.expressions.sbql.envs;

import java.util.LinkedList;
import java.util.List;

public class ENVSStackFrame {
	
	private List<ENVSBinder> elements = new LinkedList<ENVSBinder>();

	public List<ENVSBinder> getElements() {
		return elements;
	}

	public void setElements(List<ENVSBinder> elements) {
		this.elements = elements;
	}
	
	public void add(ENVSBinder binder) {
		elements.add(binder);
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for(ENVSBinder entry : elements) {
			buffer.append(entry + " ");
		}
		return buffer.toString();
	}

}
