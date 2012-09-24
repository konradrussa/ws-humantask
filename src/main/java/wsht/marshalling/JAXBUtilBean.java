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
import wsht.marshalling.exception.WSHTException;

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
    private final String SCHEMA_PATH_XML = "oasis/xml.xsd";

    public JAXBUtilBean() {
    	String schemaFactoryProperty = "javax.xml.validation.SchemaFactory:" + XMLConstants.W3C_XML_SCHEMA_NS_URI;
    	System.setProperty(schemaFactoryProperty,"org.apache.xerces.jaxp.validation.XMLSchemaFactory");
    	SchemaFactory factory = XMLSchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    	//factory.setResourceResolver(new ResourceResolver());
        List<Source> schemas = new ArrayList<Source>();
        schemas.add(new StreamSource(JAXBUtilBean.class.getClassLoader().getResourceAsStream(SCHEMA_PATH_XML)));
        schemas.add(new StreamSource(JAXBUtilBean.class.getClassLoader().getResourceAsStream(SCHEMA_PATH_WSHT)));


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
    
    public String marshal(Object message) throws WSHTException {
        try {
            StringWriter sw = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(message.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.marshal(message, sw);
            return sw.toString();
        } catch (PropertyException e) {
            throw new WSHTException(e);
        } catch (JAXBException e) {
            throw new MarshalException(e, message);
        }
    }
    
    public THumanInteractions parseAndUnmarshal(String str) throws WSHTException, RejectedMessageException {
        try {
            Document document = parseString(str);
            boolean valid = isValid(document);
            if(!valid) throw new WSHTException("błąd walidacji");
            THumanInteractions msg = unmarshal(document);
            return msg;
        } catch (ParseXmlException e) {
            throw new WSHTException(e);
        } catch (UnmarshalException e) {
            throw new WSHTException(e);
        }
    }

    private Document parseString(String str) throws WSHTException {
        try {
            DocumentBuilder domBuilder = getDomBuilder();
            InputSource is = new InputSource(new StringReader(str));
            Document document = domBuilder.parse(is);
            return document;
        } catch (ParserConfigurationException e) {
            throw new WSHTException(e);
        } catch (SAXException e) {
            throw new ParseXmlException(str,e);
        } catch (IOException e) {
            throw new WSHTException(e);
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


    private boolean isValid(Document document) throws WSHTException {
        try {
            validator.validate(new DOMSource(document));
        } catch (SAXException e) {
            return false;
        } catch (IOException e) {
            throw new WSHTException(e);
        }
        return true;

    }

}

