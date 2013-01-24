
package org.oasis_open.docs.ns.bpel4people.ws_humantask._200803;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tPeopleAssignments complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tPeopleAssignments">
 *   &lt;complexContent>
 *     &lt;extension base="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tExtensibleElements">
 *       &lt;sequence>
 *         &lt;element ref="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}genericHumanRole" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "tPeopleAssignments", propOrder = {
    "genericHumanRole"
})
public class TPeopleAssignments
    extends TExtensibleElements
{

    @XmlElementRef(name = "genericHumanRole", namespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends TGenericHumanRoleAssignmentBase>> genericHumanRole;

    /**
     * Gets the value of the genericHumanRole property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericHumanRole property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericHumanRole().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link TGenericHumanRoleAssignmentBase }{@code >}
     * {@link JAXBElement }{@code <}{@link TGenericHumanRoleAssignment }{@code >}
     * {@link JAXBElement }{@code <}{@link TGenericHumanRoleAssignment }{@code >}
     * {@link JAXBElement }{@code <}{@link TPotentialOwnerAssignment }{@code >}
     * {@link JAXBElement }{@code <}{@link TGenericHumanRoleAssignment }{@code >}
     * {@link JAXBElement }{@code <}{@link TGenericHumanRoleAssignment }{@code >}
     * {@link JAXBElement }{@code <}{@link TGenericHumanRoleAssignment }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends TGenericHumanRoleAssignmentBase>> getGenericHumanRole() {
        if (genericHumanRole == null) {
            genericHumanRole = new ArrayList<JAXBElement<? extends TGenericHumanRoleAssignmentBase>>();
        }
        return this.genericHumanRole;
    }

}
