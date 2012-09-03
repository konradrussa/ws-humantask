package wsht.runtime.exceptions;

public class WSHTSystemStoreException extends RuntimeException {
	private static final long serialVersionUID = -537811982914157125L;

	public WSHTSystemStoreException(String message) {
		super(message);
	}
	
	public WSHTSystemStoreException(Throwable cause) {
		super(cause);
	}
	
	public WSHTSystemStoreException(String message, Throwable cause) {
		super(message, cause);
	}
}