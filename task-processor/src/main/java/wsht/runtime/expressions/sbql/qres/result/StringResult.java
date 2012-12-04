package wsht.runtime.expressions.sbql.qres.result;


public class StringResult extends AbstractQueryResult {

	private String value;
	
	public StringResult(){}

	public StringResult(String value) {
		super();
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "\"" + value + "\"";
	}
}
