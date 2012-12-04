
package org.oasis_open.docs.ns.bpel4people.ws_humantask.protocol._200803;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.oasis_open.docs.ns.bpel4people.ws_humantask.protocol._200803 package. 
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

    private final static QName _ResponseOperation_QNAME = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/protocol/200803", "responseOperation");
    private final static QName _Exit_QNAME = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/protocol/200803", "exit");
    private final static QName _Fault_QNAME = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/protocol/200803", "fault");
    private final static QName _ResponseAction_QNAME = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/protocol/200803", "responseAction");
    private final static QName _Skipped_QNAME = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/protocol/200803", "skipped");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.oasis_open.docs.ns.bpel4people.ws_humantask.protocol._200803
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TProtocolMsgType }
     * 
     */
    public TProtocolMsgType createTProtocolMsgType() {
        return new TProtocolMsgType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/protocol/200803", name = "responseOperation")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createResponseOperation(String value) {
        return new JAXBElement<String>(_ResponseOperation_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TProtocolMsgType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/protocol/200803", name = "exit")
    public JAXBElement<TProtocolMsgType> createExit(TProtocolMsgType value) {
        return new JAXBElement<TProtocolMsgType>(_Exit_QNAME, TProtocolMsgType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TProtocolMsgType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/protocol/200803", name = "fault")
    public JAXBElement<TProtocolMsgType> createFault(TProtocolMsgType value) {
        return new JAXBElement<TProtocolMsgType>(_Fault_QNAME, TProtocolMsgType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/protocol/200803", name = "responseAction")
    public JAXBElement<String> createResponseAction(String value) {
        return new JAXBElement<String>(_ResponseAction_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TProtocolMsgType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/protocol/200803", name = "skipped")
    public JAXBElement<TProtocolMsgType> createSkipped(TProtocolMsgType value) {
        return new JAXBElement<TProtocolMsgType>(_Skipped_QNAME, TProtocolMsgType.class, null, value);
    }

}
