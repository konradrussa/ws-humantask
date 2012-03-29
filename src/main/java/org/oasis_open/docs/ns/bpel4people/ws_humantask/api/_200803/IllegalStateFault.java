
package org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2-12/14/2009 02:16 PM(ramkris)-
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "illegalState", targetNamespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/api/200803")
public class IllegalStateFault
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private IllegalState faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public IllegalStateFault(String message, IllegalState faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public IllegalStateFault(String message, IllegalState faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.IllegalState
     */
    public IllegalState getFaultInfo() {
        return faultInfo;
    }

}
