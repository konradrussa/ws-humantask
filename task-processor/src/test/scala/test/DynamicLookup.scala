package test

class DynamicLookup {}/*

  /**
   * Sets the request parameters using XPath
   */
  private static void setNames(Node node, String forename, String surname) {
    XPath xpath = XPathFactory.newInstance()
        .newXPath();
    xpath.setNamespaceContext(new NamespaceContextMap("ns",
        "http://demo.iae.ws/name"));
    try {
      Node forenameElement =
          (Node) xpath.evaluate("//ns:forename", node, XPathConstants.NODE);
      forenameElement.setTextContent(forename);
      Node surnameElement =
          (Node) xpath.evaluate("//ns:surname", node, XPathConstants.NODE);
      surnameElement.setTextContent(surname);
    } catch (XPathExpressionException e) {
      throw new IllegalStateException(e);
    }
  }

  /**
   * Creates a request from an XML template
   */
  private static SOAPMessage createRequest(String forename, String surname)
      throws SOAPException, IOException {
    InputStream template =
        DynamicLookup.class.getResourceAsStream("/xml/client.xml");
    try {
      MessageFactory mf =
          MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
      SOAPMessage message = mf.createMessage(new MimeHeaders(), template);
      SOAPBody body = message.getSOAPBody();
      setNames(body, forename, surname);
      return message;
    } finally {
      template.close();
    }
  }

  /**
   * Transforms the XML response to HTML
   */
  private static void toHtml(Node node, OutputStream out)
      throws TransformerException, IOException {
    InputStream stylesheet =
        DynamicLookup.class.getResourceAsStream("/xml/tohtml.xslt");
    try {
      Transformer transformer = TransformerFactory.newInstance()
          .newTransformer(new StreamSource(stylesheet));
      transformer.transform(new DOMSource(node), new StreamResult(out));
    } finally {
      stylesheet.close();
    }
  }

  public static void main(String[] args) throws SOAPException, IOException,
      TransformerException {
    String endpoint =
        "http://localhost:8080/wsboundservice-0.0.1-SNAPSHOT/MaintainAddress";
    URL wsdl = DynamicLookup.class.getClassLoader()
        .getResource("wsdl/MaintainAddress.wsdl");
    String namespace = "http://demo.iae.ws/MaintainAddress/";
    Service service =
        Service.create(wsdl, new QName(namespace, "MaintainAddress"));
    QName portName = new QName(namespace, "lookupAddress");
    service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING, endpoint);
    Dispatch<SOAPMessage> dispatch =
        service.createDispatch(portName, SOAPMessage.class,
            Service.Mode.MESSAGE);

    SOAPMessage request = createRequest("Joe", "Blogs");
    try {
      SOAPMessage response = dispatch.invoke(request);
      toHtml(response.getSOAPBody(), System.out);
    } catch (SOAPFaultException e) {
      System.err.println(e);
    } catch (WebServiceException e) {
      System.err.println(e);
    }
  }
}*/
