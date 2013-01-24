
package org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TLeanTask;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTask.InputMessage;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2-12/14/2009 02:16 PM(ramkris)-
 * Generated source version: 2.2
 * 
 */
@WebService(name = "leanTaskOperations", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803")
@XmlSeeAlso({
    org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.ObjectFactory.class,
    org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.ObjectFactory.class,
    org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.ObjectFactory.class
})
public interface LeanTaskOperations {


    /**
     * 
     * @param taskDefinition
     * @return
     *     returns java.lang.String
     * @throws IllegalStateFault
     * @throws IllegalAccessFault
     */
    @WebMethod(action = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803/registerLeanTaskDefinition")
    @WebResult(name = "taskName", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803")
    @RequestWrapper(localName = "registerLeanTaskDefinition", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803", className = "org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.RegisterLeanTaskDefinition")
    @ResponseWrapper(localName = "registerLeanTaskDefinitionResponse", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803", className = "org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.RegisterLeanTaskDefinitionResponse")
    public String registerLeanTaskDefinition(
        @WebParam(name = "taskDefinition", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803")
        TLeanTask taskDefinition)
        throws IllegalAccessFault, IllegalStateFault
    ;

    /**
     * 
     * @param taskName
     * @throws IllegalArgumentFault
     * @throws IllegalAccessFault
     */
    @WebMethod(action = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803/unregisterLeanTaskDefinition")
    @RequestWrapper(localName = "unregisterLeanTaskDefinition", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803", className = "org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.UnregisterLeanTaskDefinition")
    @ResponseWrapper(localName = "unregisterLeanTaskDefinitionResponse", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803", className = "org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.UnregisterLeanTaskDefinitionResponse")
    public void unregisterLeanTaskDefinition(
        @WebParam(name = "taskName", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803", mode = WebParam.Mode.INOUT)
        Holder<String> taskName)
        throws IllegalAccessFault, IllegalArgumentFault
    ;

    /**
     * 
     * @return
     *     returns org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.ListLeanTaskDefinitionsResponse.LeanTaskDefinitions
     * @throws IllegalAccessFault
     */
    @WebMethod(action = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803/listLeanTaskDefinitions")
    @WebResult(name = "leanTaskDefinitions", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803")
    @RequestWrapper(localName = "listLeanTaskDefinitions", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803", className = "org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.ListLeanTaskDefinitions")
    @ResponseWrapper(localName = "listLeanTaskDefinitionsResponse", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803", className = "org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.ListLeanTaskDefinitionsResponse")
    public org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.ListLeanTaskDefinitionsResponse.LeanTaskDefinitions listLeanTaskDefinitions()
        throws IllegalAccessFault
    ;

    /**
     * 
     * @param taskDefinition
     * @param inputMessage
     * @param taskName
     * @return
     *     returns org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskResponse.OutputMessage
     * @throws IllegalArgumentFault
     * @throws IllegalAccessFault
     */
    @WebMethod(action = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803/createLeanTask")
    @WebResult(name = "outputMessage", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803")
    @RequestWrapper(localName = "createLeanTask", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803", className = "org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTask")
    @ResponseWrapper(localName = "createLeanTaskResponse", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803", className = "org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskResponse")
    public org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskResponse.OutputMessage createLeanTask(
        @WebParam(name = "inputMessage", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803")
        InputMessage inputMessage,
        @WebParam(name = "taskDefinition", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803")
        TLeanTask taskDefinition,
        @WebParam(name = "taskName", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803")
        String taskName)
        throws IllegalAccessFault, IllegalArgumentFault
    ;

    /**
     * 
     * @param taskDefinition
     * @param inputMessage
     * @param taskName
     * @throws IllegalArgumentFault
     * @throws IllegalAccessFault
     */
    @WebMethod(action = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803/createLeanTaskAsync")
    @RequestWrapper(localName = "createLeanTaskAsync", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803", className = "org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskAsync")
    @ResponseWrapper(localName = "createLeanTaskAsyncResponse", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803", className = "org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskAsyncResponse")
    public void createLeanTaskAsync(
        @WebParam(name = "inputMessage", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803")
        org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskAsync.InputMessage inputMessage,
        @WebParam(name = "taskDefinition", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803")
        TLeanTask taskDefinition,
        @WebParam(name = "taskName", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803")
        String taskName)
        throws IllegalAccessFault, IllegalArgumentFault
    ;

}
