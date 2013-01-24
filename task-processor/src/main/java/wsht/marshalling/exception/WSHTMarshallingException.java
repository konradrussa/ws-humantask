package wsht.marshalling.exception;


public class WSHTMarshallingException extends Exception {
	private static final long serialVersionUID = -7118379746697005156L;

	
	public WSHTMarshallingException(String message) {
		super(message);
	}
	
	public WSHTMarshallingException(Throwable e) {
		super(e);
	}
	
	public WSHTMarshallingException(String message, Throwable cause) {
		super(message, cause);
	}



	
}
