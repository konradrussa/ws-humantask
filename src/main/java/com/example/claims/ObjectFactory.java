
package com.example.claims;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.claims package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ClaimApprovalDataEscalate_QNAME = new QName("http://www.example.com/claims", "ClaimApprovalDataEscalate");
    private final static QName _ClaimApprovalDataApprove_QNAME = new QName("http://www.example.com/claims", "ClaimApprovalDataApprove");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.claims
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClaimApprovalData }
     * 
     */
    public ClaimApprovalData createClaimApprovalData() {
        return new ClaimApprovalData();
    }

    /**
     * Create an instance of {@link ClaimApprovalData.Cust }
     * 
     */
    public ClaimApprovalData.Cust createClaimApprovalDataCust() {
        return new ClaimApprovalData.Cust();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClaimApprovalData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.com/claims", name = "ClaimApprovalDataEscalate")
    public JAXBElement<ClaimApprovalData> createClaimApprovalDataEscalate(ClaimApprovalData value) {
        return new JAXBElement<ClaimApprovalData>(_ClaimApprovalDataEscalate_QNAME, ClaimApprovalData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClaimApprovalData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.com/claims", name = "ClaimApprovalDataApprove")
    public JAXBElement<ClaimApprovalData> createClaimApprovalDataApprove(ClaimApprovalData value) {
        return new JAXBElement<ClaimApprovalData>(_ClaimApprovalDataApprove_QNAME, ClaimApprovalData.class, null, value);
    }

}
