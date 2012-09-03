package wsht.runtime.expressions.sbql.store.object;

import java.util.Date;

public class DateObject extends SimpleObject {

	public Date value;

	@Override
	public String toString() {
		return "DateObject [value=" + value + "]";
	}
}
