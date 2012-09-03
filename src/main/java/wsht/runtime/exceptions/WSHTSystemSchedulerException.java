package wsht.runtime.exceptions;


public class WSHTSystemSchedulerException extends RuntimeException {
	private static final long serialVersionUID = -537811982914157125L;

	public WSHTSystemSchedulerException(String message) {
		super(message);
	}
	
	public WSHTSystemSchedulerException(Throwable cause) {
		super(cause);
	}
	
	public WSHTSystemSchedulerException(String message, Throwable cause) {
		super(message, cause);
	}
}
