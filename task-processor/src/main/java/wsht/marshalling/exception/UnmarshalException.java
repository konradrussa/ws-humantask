package wsht.marshalling.exception;

import org.w3c.dom.Document;

public class UnmarshalException extends WSHTMarshallingException {
    
	private Document xml;

    public UnmarshalException(Throwable cause, Document xml) {
        super(cause);
        this.xml = xml;
    }

}