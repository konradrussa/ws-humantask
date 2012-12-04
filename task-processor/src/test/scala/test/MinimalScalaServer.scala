package test



import javax.jws.WebService
import javax.jws.soap.SOAPBinding
import javax.jws.soap.SOAPBinding.Style
import javax.xml.ws.Endpoint

@WebService(targetNamespace="test", name="test", portName="test", serviceName="WSTest")
private class MinimalScalaServer {

    @SOAPBinding(style = Style.DOCUMENT)
    def test(value : String) = "Hi " + value

}
object MinimalScalaServer { // defined Companion Object for our class

    def main(args: Array[String]) { // main method to make this a runnable application
        val endpoint = Endpoint.publish("http://localhost:8080/wstest", new MinimalScalaServer())
        System.out.println("Waiting for requests...")
    }
}

