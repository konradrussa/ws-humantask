package test.webservice;

import java.net.URL;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceException;

import org.apache.cxf.ws.addressing.AddressingBuilder;
import org.apache.cxf.ws.addressing.AddressingProperties;
import org.apache.cxf.ws.addressing.AttributedURIType;
import org.apache.cxf.ws.addressing.JAXWSAConstants;
import org.apache.cxf.ws.addressing.ObjectFactory;
import org.junit.Test;

import wsht.infrastructure.utils.ReflectionUtils;
import wsht.runtime.configuration.PublicProtocolConfiguration;

import com.sun.xml.ws.api.addressing.AddressingVersion;
import com.sun.xml.ws.api.addressing.OneWayFeature;
import com.sun.xml.ws.api.message.Headers;

public class TestParentLeanTaskCallback {

	@Test
	public void testLeanTaskCallback() {
		try {
			Service service = Service.create(new URL("http://localhost:8081/services/leanTaskCallbackOperations" + "?wsdl"),
					new QName(
							"http://leantask.webservice.infrastructure.wsht/",
							"LeanTaskCallbackOperationsImplService"));
			Object callbackPort = service.getPort(new QName(
					"http://leantask.webservice.infrastructure.wsht/",
					"LeanTaskCallbackOperationsImplPort"),
					PublicProtocolConfiguration.getLeanTaskCallbackOperationInterface(),
					new OneWayFeature());


			org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskAsyncCallback.OutputMessage outputMessage = new org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803.CreateLeanTaskAsyncCallback.OutputMessage();
			// callbackPort.createLeanTaskAsyncCallback(outputMessage);
			ReflectionUtils.invokeMethod(callbackPort,PublicProtocolConfiguration.getLeanTaskCallbackOperationInterface().getMethods()[0], outputMessage);
		} catch (Exception e) {
			throw new WebServiceException(e);
		}
	}
}
