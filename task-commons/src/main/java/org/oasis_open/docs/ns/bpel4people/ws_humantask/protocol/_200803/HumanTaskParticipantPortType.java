
package org.oasis_open.docs.ns.bpel4people.ws_humantask.protocol._200803;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2-12/14/2009 02:16 PM(ramkris)-
 * Generated source version: 2.2
 * 
 */
@WebService(name = "humanTaskParticipantPortType", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/protocol/200803")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HumanTaskParticipantPortType {


    /**
     * 
     * @param parameters
     */
    @WebMethod(action = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/protocol/200803/exitOperation")
    @Oneway
    public void exitOperation(
        @WebParam(name = "exit", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/protocol/200803", partName = "parameters")
        TProtocolMsgType parameters);

}