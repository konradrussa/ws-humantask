package wsht.runtime.expressions.sbql.qres.exception;

public class InvalidSourceException extends RuntimeException {
	private static final long serialVersionUID = 2015541693047068933L;

	public InvalidSourceException() {
		super();
	}

	public InvalidSourceException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidSourceException(String message) {
		super(message);
	}

	public InvalidSourceException(Throwable cause) {
		super(cause);
	}

}