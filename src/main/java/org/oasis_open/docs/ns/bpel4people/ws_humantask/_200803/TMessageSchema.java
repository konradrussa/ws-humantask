
package org.oasis_open.docs.ns.bpel4people.ws_humantask._200803;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tMessageSchema complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tMessageSchema">
 *   &lt;complexContent>
 *     &lt;extension base="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tExtensibleElements">
 *       &lt;sequence>
 *         &lt;element name="messageField" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tMessageField" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "tMessageSchema", propOrder = {
    "messageField"
})
public class TMessageSchema
    extends TExtensibleElements
{

    protected List<TMessageField> messageField;

    /**
     * Gets the value of the messageField property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messageField property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessageField().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TMessageField }
     * 
     * 
     */
    public List<TMessageField> getMessageField() {
        if (messageField == null) {
            messageField = new ArrayList<TMessageField>();
        }
        return this.messageField;
    }

}
