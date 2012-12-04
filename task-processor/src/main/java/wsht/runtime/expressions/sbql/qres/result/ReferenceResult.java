package wsht.runtime.expressions.sbql.qres.result;


public class ReferenceResult extends AbstractQueryResult {

	private Long oidValue;
	
	public ReferenceResult(){}

	public ReferenceResult(Long oidValue) {
		super();
		this.oidValue = oidValue;
	}

	public Long getOidValue() {
		return oidValue;
	}

	public void setOidValue(Long oidValue) {
		this.oidValue = oidValue;
	}

	public String toString() {
		return "" + oidValue;
	}
	
}
