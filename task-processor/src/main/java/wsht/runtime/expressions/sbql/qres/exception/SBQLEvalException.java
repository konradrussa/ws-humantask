package wsht.runtime.expressions.sbql.qres.exception;

public class SBQLEvalException extends RuntimeException {
	public SBQLEvalException(String string) {
		super(string);
	}
	
	public SBQLEvalException(String message, Throwable cause){
		super(message, cause);
	}

	private static final long serialVersionUID = 4307318077749654678L;

}
