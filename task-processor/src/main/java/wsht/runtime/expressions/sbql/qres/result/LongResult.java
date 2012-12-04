package wsht.runtime.expressions.sbql.qres.result;

public class LongResult extends AbstractQueryResult {

	private Long value;
	
	public LongResult(){}

	public LongResult(Long value) {
		super();
		this.value = value;
	}

	public Long isValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "" + value;
	}
	
}