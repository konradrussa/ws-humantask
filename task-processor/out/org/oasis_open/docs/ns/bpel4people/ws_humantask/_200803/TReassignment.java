
package org.oasis_open.docs.ns.bpel4people.ws_humantask._200803;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tReassignment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tReassignment">
 *   &lt;complexContent>
 *     &lt;extension base="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tExtensibleElements">
 *       &lt;sequence>
 *         &lt;element ref="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}potentialOwners"/>
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
@XmlType(name = "tReassignment", propOrder = {
    "potentialOwners"
})
public class TReassignment
    extends TExtensibleElements
{

    @XmlElement(required = true)
    protected TPotentialOwnerAssignment potentialOwners;

    /**
     * Gets the value of the potentialOwners property.
     * 
     * @return
     *     possible object is
     *     {@link TPotentialOwnerAssignment }
     *     
     */
    public TPotentialOwnerAssignment getPotentialOwners() {
        return potentialOwners;
    }

    /**
     * Sets the value of the potentialOwners property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPotentialOwnerAssignment }
     *     
     */
    public void setPotentialOwners(TPotentialOwnerAssignment value) {
        this.potentialOwners = value;
    }

}
