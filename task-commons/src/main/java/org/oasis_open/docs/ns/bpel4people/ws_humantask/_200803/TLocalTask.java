
package org.oasis_open.docs.ns.bpel4people.ws_humantask._200803;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Java class for tLocalTask complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tLocalTask">
 *   &lt;complexContent>
 *     &lt;extension base="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tExtensibleElements">
 *       &lt;sequence>
 *         &lt;element name="priority" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tPriority-expr" minOccurs="0"/>
 *         &lt;element name="peopleAssignments" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tPeopleAssignments" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="reference" use="required" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tLocalTask", propOrder = {
    "priority",
    "peopleAssignments"
})
public class TLocalTask
    extends TExtensibleElements
{

    protected TPriorityExpr priority;
    protected TPeopleAssignments peopleAssignments;
    @XmlAttribute(name = "reference", required = true)
    protected QName reference;

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link TPriorityExpr }
     *     
     */
    public TPriorityExpr getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPriorityExpr }
     *     
     */
    public void setPriority(TPriorityExpr value) {
        this.priority = value;
    }

    /**
     * Gets the value of the peopleAssignments property.
     * 
     * @return
     *     possible object is
     *     {@link TPeopleAssignments }
     *     
     */
    public TPeopleAssignments getPeopleAssignments() {
        return peopleAssignments;
    }

    /**
     * Sets the value of the peopleAssignments property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPeopleAssignments }
     *     
     */
    public void setPeopleAssignments(TPeopleAssignments value) {
        this.peopleAssignments = value;
    }

    /**
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setReference(QName value) {
        this.reference = value;
    }

}
