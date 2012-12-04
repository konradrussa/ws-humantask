package wsht.runtime.expressions.sbql.qres.result;


public class RealResult extends AbstractQueryResult {
	
	private Double value;
	
	public RealResult(){}

	public RealResult(Double value) {
		super();
		this.value = value;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "" + value;
	}

}
