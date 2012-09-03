package wsht.marshalling.exception;

import org.xml.sax.SAXException;

public class ParseXmlException extends WSHTException {
	private static final long serialVersionUID = -7225812009541701454L;
	
	public ParseXmlException(String message, SAXException e) {
		super(message,e);
	}

}
