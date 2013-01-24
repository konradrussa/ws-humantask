package wsht.runtime.expressions.sbql.ast.operators.wsht.ext;

import java.util.Map;
import java.util.Set;

import wsht.runtime.expressions.sbql.qres.exception.SBQLEvalException;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.store.TaskInstance;

public interface IValuable {

	public AbstractQueryResult eval(String expression, boolean nullable) throws SBQLEvalException;
	public AbstractQueryResult evalExternal(String expression, Object instance, boolean nullable) throws SBQLEvalException;
	public Map<String, AbstractQueryResult> evalInputConditions(Set<String> expressions, Object instance, boolean nullable) throws SBQLEvalException;
	public void setUpTaskInstance(TaskInstance taskInstance);
}
