package wsht.runtime.expressions.sbql.qres.result;


public class IntegerResult extends AbstractQueryResult {

	private Integer value;
	
	public IntegerResult(){}

	public IntegerResult(Integer value) {
		super();
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return ""+ value;
	}
	
	
	
}
