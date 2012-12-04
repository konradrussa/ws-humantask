package wsht.runtime.expressions.sbql.qres.result;

import java.util.LinkedList;
import java.util.List;


public class StructResult extends AbstractQueryResult {

	private List<AbstractQueryResult> elements = new LinkedList<AbstractQueryResult>();

	public StructResult(){}
	
	public StructResult(List<AbstractQueryResult> elements) {
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
		if(r instanceof StructResult) {
			for( AbstractQueryResult res1 : ((StructResult) r).elements) {
				this.add(res1);
			}
		} else {
			this.elements.add(r);
		}
	}
	
	public List<AbstractQueryResult> getAtoms() {
		List<AbstractQueryResult> atoms = new LinkedList<AbstractQueryResult>();
		for(AbstractQueryResult result : elements) {
			setStructureAtoms(result, atoms);
		}
		return atoms;
	}
	
	private void setStructureAtoms(AbstractQueryResult result, List<AbstractQueryResult> atoms) {
		if(result instanceof StructResult) {
			for(AbstractQueryResult res : ((StructResult)result).elements) {
				setStructureAtoms(res, atoms);
			}
		} else {
			atoms.add(result);
		}
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("struct(");
		int i = 0;
		for(AbstractQueryResult result : elements) {
			buffer.append(i + "=" + result.toString() + ",");
			i++;
		}
		buffer.deleteCharAt(buffer.lastIndexOf(","));
		buffer.append(")");
		return buffer.toString();
		
	}
	
}
