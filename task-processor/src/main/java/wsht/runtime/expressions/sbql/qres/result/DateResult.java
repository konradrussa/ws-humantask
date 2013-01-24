package wsht.runtime.expressions.sbql.qres.result;

import java.util.Date;

public class DateResult extends AbstractQueryResult {

	private Date value;
	
	public DateResult(){}

	public DateResult(Date value) {
		super();
		this.value = value;
	}

	public Date getValue() {
		return value;
	}

	public void setValue(Date value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "" + value;
	}
	
}
