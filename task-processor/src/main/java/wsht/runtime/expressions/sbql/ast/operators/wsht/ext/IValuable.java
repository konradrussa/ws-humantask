package wsht.runtime.expressions.sbql.ast.operators.wsht.ext;

import wsht.runtime.exceptions.WSHTExpressionException;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;

public interface IValuable {

	public AbstractQueryResult eval(String expression, boolean nullable) throws WSHTExpressionException;
}
