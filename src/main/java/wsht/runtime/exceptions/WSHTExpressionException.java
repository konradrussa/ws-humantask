package wsht.runtime.exceptions;

import wsht.runtime.expressions.sbql.qres.exception.SBQLEvalException;

public class WSHTExpressionException extends SBQLEvalException {
	private static final long serialVersionUID = 8352444487529748771L;
	
	public WSHTExpressionException(String message){
		super(message);
	}
	
	public WSHTExpressionException(String message, Throwable cause){
		super(message, cause);
	}
}
