
package org.oasis_open.docs.ns.bpel4people.ws_humantask._200803;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tDefaultCompletion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tDefaultCompletion">
 *   &lt;complexContent>
 *     &lt;extension base="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tExtensibleElements">
 *       &lt;sequence>
 *         &lt;element name="result" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tResult"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tDefaultCompletion", propOrder = {
    "result"
})
public class TDefaultCompletion
    extends TExtensibleElements
{

    @XmlElement(required = true)
    protected TResult result;

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link TResult }
     *     
     */
    public TResult getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link TResult }
     *     
     */
    public void setResult(TResult value) {
        this.result = value;
    }

}
