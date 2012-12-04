package wsht.runtime.expressions.sbql.qres.result;

import java.util.LinkedList;
import java.util.List;


public class BagResult extends AbstractQueryResult {
	
	private List<AbstractQueryResult> elements = new LinkedList<AbstractQueryResult>();

	public BagResult(){}
	
	public BagResult(List<AbstractQueryResult> elements) {
		super();
		this.elements = elements;
	}

	public List<AbstractQueryResult> getElements() {
		return elements;
	}

	public void setElements(List<AbstractQueryResult> elements) {
		this.elements = elements;
	}
	
	public void add(AbstractQueryResult r) {
		if(r instanceof BagResult) {
			for( AbstractQueryResult res1 : ((BagResult) r).elements) {
				this.add(res1);
			}
		} else if(r instanceof StructResult) {
			for( AbstractQueryResult res1 : ((StructResult) r).getElements()) {
				this.add(res1);
			}
		} else {
			this.elements.add(r);
		}
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("bag(");
		int i = 0;
		for(AbstractQueryResult result : elements) {
			buffer.append(i + "=" + result.toString() + ",");
			i++;
		}
		if(elements.size() > 0)
			buffer.deleteCharAt(buffer.lastIndexOf(","));
		buffer.append(")");
		return buffer.toString();
		
	}

}
