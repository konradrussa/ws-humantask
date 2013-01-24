package wsht.exception;

public class WSHTException extends Exception {
	private static final long serialVersionUID = -7118379746697005156L;

	
	public WSHTException(String message) {
		super(message);
	}
	
	public WSHTException(Throwable e) {
		super(e);
	}
	
	public WSHTException(String message, Throwable cause) {
		super(message, cause);
	}
}
