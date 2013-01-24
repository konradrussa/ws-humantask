package object;

import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

	private final static QName _ClaimApprovalRequest_QNAME = new QName("http://object", "claimApprovalRequest");
	private final static QName _ClaimApprovalResponse_QNAME = new QName("http://object", "claimApprovalResponse");
    private final static QName _Customer_QNAME = new QName("http://object", "customer");
    private final static QName _Location_QNAME = new QName("http://object", "location");
    
    
    public ObjectFactory() {
    }
    
    public Customer createCustomer() {
        return new Customer();
    }
    
    public Location createLocation() {
        return new Location();
    }

    public ClaimApprovalRequest createClaimApprovalRequest() {
        return new ClaimApprovalRequest();
    }
    
    public ClaimApprovalResponse createClaimApprovalResponse() {
    	return new ClaimApprovalResponse();
    }
}
