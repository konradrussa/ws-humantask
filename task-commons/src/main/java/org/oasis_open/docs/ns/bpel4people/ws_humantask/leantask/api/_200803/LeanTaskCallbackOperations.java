
package org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2-12/14/2009 02:16 PM(ramkris)-
 * Generated source version: 2.2
 * 
 */
@WebService(name = "leanTaskCallbackOperations", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803")
@XmlSeeAlso({
    org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.ObjectFactory.class,
    org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.ObjectFactory.class,
    org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.ObjectFactory.class
})
//@SOAPBinding(style=SOAPBinding.Style.DOCUMENT, parameterStyle=SOAPBinding.ParameterStyle.BARE) //moje
public interface LeanTaskCallbackOperations {


    /**
     * 
     * @param outputMessage
     */
	//generated causes errors
    //@WebMethod(action = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803/createLeanTaskAsyncCallback")
    //@Oneway
    //@RequestWrapper(localName = "createLeanTaskAsyncCallback", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803", className = "org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskAsyncCallback")
    @WebMethod(operationName= "createLeanTaskAsyncResponse", action = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803/createLeanTaskAsyncCallback")
    @Oneway
    @RequestWrapper(localName = "createLeanTaskAsyncResponse", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803", className = "org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskAsyncCallback")
    public void createLeanTaskAsyncCallback(
        @WebParam(name = "outputMessage", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/leantask/api/200803")
        org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskAsyncCallback.OutputMessage outputMessage);

}
