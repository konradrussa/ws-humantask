package wsht.runtime.expressions.sbql.qres.result;


public class BooleanResult extends AbstractQueryResult {

	private Boolean value;
	
	public BooleanResult(){}

	public BooleanResult(Boolean value) {
		super();
		this.value = value;
	}

	public Boolean isValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "" + value;
	}
	
}
