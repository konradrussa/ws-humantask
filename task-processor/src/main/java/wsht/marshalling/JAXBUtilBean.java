package wsht.marshalling;

import org.apache.xerces.jaxp.validation.XMLSchemaFactory;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TExtensibleElements;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.THumanInteractions;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import wsht.marshalling.exception.AdapterObjectNotFoundException;
import wsht.marshalling.exception.MarshalException;
import wsht.marshalling.exception.ParseXmlException;
import wsht.marshalling.exception.RejectedMessageException;
import wsht.marshalling.exception.UnmarshalException;
import wsht.marshalling.exception.WSHTMarshallingException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.helpers.DefaultValidationEventHandler;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class JAXBUtilBean implements IJAXBUtilBean {

    private final Validator validator;

    private final String SCHEMA_PATH_WSHT = "oasis/ws-humantask.xsd";
    private final String SCHEMA_PATH_WSHT_TYPES = "oasis/ws-humantask-types.xsd";
    private final String SCHEMA_PATH_WSHT_CONTEXT = "oasis/ws-humantask-context.xsd";
    private final String SCHEMA_PATH_WSHT_POLICY = "oasis/ws-humantask-policy.xsd";
    private final String SCHEMA_PATH_WS_ADDR = "oasis/ws-addr.xsd";
    private final String SCHEMA_PATH_WS_WSCOOR = "oasis/wstx-wscoor-1.1-schema-200701.xsd";
    private final String SCHEMA_PATH_XML = "oasis/xml.xsd";

    public JAXBUtilBean() {
    	String schemaFactoryProperty = "javax.xml.validation.SchemaFactory:" + XMLConstants.W3C_XML_SCHEMA_NS_URI;
    	System.setProperty(schemaFactoryProperty,"org.apache.xerces.jaxp.validation.XMLSchemaFactory");
    	SchemaFactory factory = XMLSchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    	//factory.setResourceResolver(new ResourceResolver());
        List<Source> schemas = new ArrayList<Source>();
        schemas.add(new StreamSource(JAXBUtilBean.class.getClassLoader().getResourceAsStream(SCHEMA_PATH_XML)));
        schemas.add(new StreamSource(JAXBUtilBean.class.getClassLoader().getResourceAsStream(SCHEMA_PATH_WSHT)));
        schemas.add(new StreamSource(JAXBUtilBean.class.getClassLoader().getResourceAsStream(SCHEMA_PATH_WSHT_TYPES)));
        schemas.add(new StreamSource(JAXBUtilBean.class.getClassLoader().getResourceAsStream(SCHEMA_PATH_WSHT_CONTEXT)));
        schemas.add(new StreamSource(JAXBUtilBean.class.getClassLoader().getResourceAsStream(SCHEMA_PATH_WSHT_POLICY)));
        schemas.add(new StreamSource(JAXBUtilBean.class.getClassLoader().getResourceAsStream(SCHEMA_PATH_WS_WSCOOR)));
        schemas.add(new StreamSource(JAXBUtilBean.class.getClassLoader().getResourceAsStream(SCHEMA_PATH_WS_ADDR)));

        try {
            Schema schema = factory.newSchema(schemas.toArray(new Source[schemas.size()]));
            validator = schema.newValidator();
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
    
    public THumanInteractions unmarshal(Document xml) throws UnmarshalException, RejectedMessageException {
        try {
            JAXBContext context = getJAXBContext();
            Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setListener(new WSHTUnmarshalListener());
            unmarshaller.setEventHandler(new DefaultValidationEventHandler());
            JAXBElement<THumanInteractions> root = unmarshaller.unmarshal(xml, THumanInteractions.class);
            THumanInteractions msg = root.getValue();
            return msg;
        } catch (javax.xml.bind.UnmarshalException e) {
            if (e.getLinkedException().getCause() instanceof AdapterObjectNotFoundException) {
                AdapterObjectNotFoundException exc = (AdapterObjectNotFoundException) e.getLinkedException().getCause();
                throw new RejectedMessageException(exc.getRejectionReasonId());
            } else {
                throw new UnmarshalException(e, xml);
            }
        }
        catch (JAXBException e) {
            throw new UnmarshalException(e, xml);
        }
    }
    
    public String marshal(Object message) throws WSHTMarshallingException {
        try {
            StringWriter sw = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(message.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.marshal(message, sw);
            return sw.toString();
        } catch (PropertyException e) {
            throw new WSHTMarshallingException(e);
        } catch (JAXBException e) {
            throw new MarshalException(e, message);
        }
    }
    
    public THumanInteractions parseAndUnmarshal(String str) throws WSHTMarshallingException, RejectedMessageException {
        try {
            Document document = parseString(str);
            boolean valid = isValid(document);
            if(!valid) throw new WSHTMarshallingException("MARSHALLING: Validation error");
            THumanInteractions msg = unmarshal(document);
            return msg;
        } catch (ParseXmlException e) {
            throw new WSHTMarshallingException(e);
        } catch (UnmarshalException e) {
            throw new WSHTMarshallingException(e);
        }
    }

    private Document parseString(String str) throws WSHTMarshallingException {
        try {
            DocumentBuilder domBuilder = getDomBuilder();
            InputSource is = new InputSource(new StringReader(str));
            Document document = domBuilder.parse(is);
            return document;
        } catch (ParserConfigurationException e) {
            throw new WSHTMarshallingException(e);
        } catch (SAXException e) {
            throw new ParseXmlException(str,e);
        } catch (IOException e) {
            throw new WSHTMarshallingException(e);
        }
    }

    private DocumentBuilder getDomBuilder() throws ParserConfigurationException {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);
        DocumentBuilder domBuilder = domFactory.newDocumentBuilder();
        return domBuilder;
    }

    private JAXBContext getJAXBContext() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(TExtensibleElements.class);
        return context;
    }


    private boolean isValid(Document document) throws WSHTMarshallingException {
        try {
            validator.validate(new DOMSource(document));
        } catch (SAXException e) {
            return false;
        } catch (IOException e) {
            throw new WSHTMarshallingException(e);
        }
        return true;

    }

}

