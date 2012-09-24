package com.example.claims;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

/**
 * This class was generated by Apache CXF 2.4.2
 * 2011-09-24T22:28:50.418+02:00
 * Generated source version: 2.4.2
 * 
 */
@WebServiceClient(name = "Service", 
                  wsdlLocation = "file:src/main/resources/ws-humantask-example-claim-approval.wsdl",
                  targetNamespace = "http://www.example.com/claims") 
public class Service extends javax.xml.ws.Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.example.com/claims", "Service");
    public final static QName ClaimHandlingCallbackPort = new QName("http://www.example.com/claims", "ClaimHandlingCallbackPort");
    public final static QName ClaimApprovalBinding = new QName("http://www.example.com/claims", "ClaimApprovalBinding");
    public final static QName ClaimHendlingPort = new QName("http://www.example.com/claims", "ClaimHendlingPort");
    static {
        URL url = null;
        try {
            url = new URL("file:src/main/resources/ws-humantask-example-claim-approval.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:src/main/resources/ws-humantask-example-claim-approval.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns ClaimsHandlingCallbackPT
     */
    @WebEndpoint(name = "ClaimHandlingCallbackPort")
    public ClaimsHandlingCallbackPT getClaimHandlingCallbackPort() {
        return super.getPort(ClaimHandlingCallbackPort, ClaimsHandlingCallbackPT.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ClaimsHandlingCallbackPT
     */
    @WebEndpoint(name = "ClaimHandlingCallbackPort")
    public ClaimsHandlingCallbackPT getClaimHandlingCallbackPort(WebServiceFeature... features) {
        return super.getPort(ClaimHandlingCallbackPort, ClaimsHandlingCallbackPT.class, features);
    }
    /**
     *
     * @return
     *     returns ClaimApprovalReminderPT
     */
    @WebEndpoint(name = "ClaimApprovalBinding")
    public ClaimApprovalReminderPT getClaimApprovalBinding() {
        return super.getPort(ClaimApprovalBinding, ClaimApprovalReminderPT.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ClaimApprovalReminderPT
     */
    @WebEndpoint(name = "ClaimApprovalBinding")
    public ClaimApprovalReminderPT getClaimApprovalBinding(WebServiceFeature... features) {
        return super.getPort(ClaimApprovalBinding, ClaimApprovalReminderPT.class, features);
    }
    /**
     *
     * @return
     *     returns ClaimsHandlingPT
     */
    @WebEndpoint(name = "ClaimHendlingPort")
    public ClaimsHandlingPT getClaimHendlingPort() {
        return super.getPort(ClaimHendlingPort, ClaimsHandlingPT.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ClaimsHandlingPT
     */
    @WebEndpoint(name = "ClaimHendlingPort")
    public ClaimsHandlingPT getClaimHendlingPort(WebServiceFeature... features) {
        return super.getPort(ClaimHendlingPort, ClaimsHandlingPT.class, features);
    }

}