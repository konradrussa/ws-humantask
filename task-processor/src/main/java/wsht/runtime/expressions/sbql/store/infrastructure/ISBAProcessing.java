package wsht.runtime.expressions.sbql.store.infrastructure;

import wsht.runtime.exceptions.WSHTExpressionException;
import wsht.runtime.expressions.sbql.store.SBAStore;

public interface ISBAProcessing {

	public void process(SBAStore sbaStore, Object obj) throws WSHTExpressionException;
}
