//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.07.25 at 12:15:02 AM CEST 
//


package org.oasis_open.docs.ns.bpel4people.ws_humantask.policy._200803;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.oasis_open.docs.ns.bpel4people.ws_humantask.policy._200803 package. 
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

    private final static QName _HumanTaskAssertion_QNAME = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/policy/200803", "HumanTaskAssertion");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.oasis_open.docs.ns.bpel4people.ws_humantask.policy._200803
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link THumanTaskAssertion }
     * 
     */
    public THumanTaskAssertion createTHumanTaskAssertion() {
        return new THumanTaskAssertion();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link THumanTaskAssertion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/policy/200803", name = "HumanTaskAssertion")
    public JAXBElement<THumanTaskAssertion> createHumanTaskAssertion(THumanTaskAssertion value) {
        return new JAXBElement<THumanTaskAssertion>(_HumanTaskAssertion_QNAME, THumanTaskAssertion.class, null, value);
    }

}