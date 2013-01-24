package wsht.infrastructure.webservice.exceptions;

import wsht.exception.WSHTException;

public class WSHTWebServiceException extends WSHTException {
	private static final long serialVersionUID = 6132633511903424106L;

	public WSHTWebServiceException(String message) {
		super(message);
	}
	
	public WSHTWebServiceException(Throwable e) {
		super(e);
	}
	
	public WSHTWebServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
