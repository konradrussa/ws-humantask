package wsht.marshalling;

import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.THumanInteractions;
import org.w3c.dom.Document;

import wsht.marshalling.exception.RejectedMessageException;
import wsht.marshalling.exception.UnmarshalException;
import wsht.marshalling.exception.WSHTMarshallingException;

public interface IJAXBUtilBean {

	public THumanInteractions unmarshal(Document xml) throws UnmarshalException, RejectedMessageException;
	public String marshal(Object message) throws WSHTMarshallingException;
	public THumanInteractions parseAndUnmarshal(String str) throws WSHTMarshallingException, RejectedMessageException;
	
	
	
}
