package wsht.runtime.expressions.sbql.envs;

import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;

public class ENVSBinder {
	
	private String name;
	private AbstractQueryResult value;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AbstractQueryResult getValue() {
		return value;
	}
	public void setValue(AbstractQueryResult value) {
		this.value = value;
	}

	
	public String toString() {
		return name + "(" + value + ")";
	}

}
