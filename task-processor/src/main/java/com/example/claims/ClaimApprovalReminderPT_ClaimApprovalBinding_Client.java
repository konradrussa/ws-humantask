
package com.example.claims;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.4.2
 * 2011-09-24T22:28:50.294+02:00
 * Generated source version: 2.4.2
 * 
 */
public final class ClaimApprovalReminderPT_ClaimApprovalBinding_Client {

    private static final QName SERVICE_NAME = new QName("http://www.example.com/claims", "Service");

    private ClaimApprovalReminderPT_ClaimApprovalBinding_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = Service.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        Service ss = new Service(wsdlURL, SERVICE_NAME);
        ClaimApprovalReminderPT port = ss.getClaimApprovalBinding();  
        
        {
        System.out.println("Invoking notify...");
        java.lang.String _notify_firstname = "";
        java.lang.String _notify_lastname = "";
        port.notify(_notify_firstname, _notify_lastname);


        }

        System.exit(0);
    }

}
