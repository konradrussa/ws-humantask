
package org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803 package. 
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

    private final static QName _IllegalAccess_QNAME = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803", "illegalAccess");
    private final static QName _IllegalArgument_QNAME = new QName("http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803", "illegalArgument");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateLeanTask }
     * 
     */
    public CreateLeanTask createCreateLeanTask() {
        return new CreateLeanTask();
    }

    /**
     * Create an instance of {@link CreateLeanTaskAsyncCallback }
     * 
     */
    public CreateLeanTaskAsyncCallback createCreateLeanTaskAsyncCallback() {
        return new CreateLeanTaskAsyncCallback();
    }

    /**
     * Create an instance of {@link CreateLeanTaskResponse }
     * 
     */
    public CreateLeanTaskResponse createCreateLeanTaskResponse() {
        return new CreateLeanTaskResponse();
    }

    /**
     * Create an instance of {@link CreateLeanTaskAsync }
     * 
     */
    public CreateLeanTaskAsync createCreateLeanTaskAsync() {
        return new CreateLeanTaskAsync();
    }

    /**
     * Create an instance of {@link ListLeanTaskDefinitionsResponse }
     * 
     */
    public ListLeanTaskDefinitionsResponse createListLeanTaskDefinitionsResponse() {
        return new ListLeanTaskDefinitionsResponse();
    }

    /**
     * Create an instance of {@link RegisterLeanTaskDefinition }
     * 
     */
    public RegisterLeanTaskDefinition createRegisterLeanTaskDefinition() {
        return new RegisterLeanTaskDefinition();
    }

    /**
     * Create an instance of {@link RegisterLeanTaskDefinitionResponse }
     * 
     */
    public RegisterLeanTaskDefinitionResponse createRegisterLeanTaskDefinitionResponse() {
        return new RegisterLeanTaskDefinitionResponse();
    }

    /**
     * Create an instance of {@link IllegalState }
     * 
     */
    public IllegalState createIllegalState() {
        return new IllegalState();
    }

    /**
     * Create an instance of {@link ListLeanTaskDefinitions }
     * 
     */
    public ListLeanTaskDefinitions createListLeanTaskDefinitions() {
        return new ListLeanTaskDefinitions();
    }

    /**
     * Create an instance of {@link UnregisterLeanTaskDefinition }
     * 
     */
    public UnregisterLeanTaskDefinition createUnregisterLeanTaskDefinition() {
        return new UnregisterLeanTaskDefinition();
    }

    /**
     * Create an instance of {@link CreateLeanTask.InputMessage }
     * 
     */
    public CreateLeanTask.InputMessage createCreateLeanTaskInputMessage() {
        return new CreateLeanTask.InputMessage();
    }

    /**
     * Create an instance of {@link CreateLeanTaskAsyncCallback.OutputMessage }
     * 
     */
    public CreateLeanTaskAsyncCallback.OutputMessage createCreateLeanTaskAsyncCallbackOutputMessage() {
        return new CreateLeanTaskAsyncCallback.OutputMessage();
    }

    /**
     * Create an instance of {@link CreateLeanTaskResponse.OutputMessage }
     * 
     */
    public CreateLeanTaskResponse.OutputMessage createCreateLeanTaskResponseOutputMessage() {
        return new CreateLeanTaskResponse.OutputMessage();
    }

    /**
     * Create an instance of {@link UnregisterLeanTaskDefinitionResponse }
     * 
     */
    public UnregisterLeanTaskDefinitionResponse createUnregisterLeanTaskDefinitionResponse() {
        return new UnregisterLeanTaskDefinitionResponse();
    }

    /**
     * Create an instance of {@link CreateLeanTaskAsync.InputMessage }
     * 
     */
    public CreateLeanTaskAsync.InputMessage createCreateLeanTaskAsyncInputMessage() {
        return new CreateLeanTaskAsync.InputMessage();
    }

    /**
     * Create an instance of {@link CreateLeanTaskAsyncResponse }
     * 
     */
    public CreateLeanTaskAsyncResponse createCreateLeanTaskAsyncResponse() {
        return new CreateLeanTaskAsyncResponse();
    }

    /**
     * Create an instance of {@link ListLeanTaskDefinitionsResponse.LeanTaskDefinitions }
     * 
     */
    public ListLeanTaskDefinitionsResponse.LeanTaskDefinitions createListLeanTaskDefinitionsResponseLeanTaskDefinitions() {
        return new ListLeanTaskDefinitionsResponse.LeanTaskDefinitions();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803", name = "illegalAccess")
    public JAXBElement<String> createIllegalAccess(String value) {
        return new JAXBElement<String>(_IllegalAccess_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803", name = "illegalArgument")
    public JAXBElement<String> createIllegalArgument(String value) {
        return new JAXBElement<String>(_IllegalArgument_QNAME, String.class, null, value);
    }

}
