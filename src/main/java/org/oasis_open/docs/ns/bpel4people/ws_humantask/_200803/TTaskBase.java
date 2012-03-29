
package org.oasis_open.docs.ns.bpel4people.ws_humantask._200803;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for tTaskBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tTaskBase">
 *   &lt;complexContent>
 *     &lt;extension base="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tExtensibleElements">
 *       &lt;sequence>
 *         &lt;element name="interface" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tTaskInterface" minOccurs="0"/>
 *         &lt;element name="messageSchema" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tMessageSchema" minOccurs="0"/>
 *         &lt;element name="priority" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tPriority-expr" minOccurs="0"/>
 *         &lt;element name="peopleAssignments" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tPeopleAssignments" minOccurs="0"/>
 *         &lt;element name="completionBehavior" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tCompletionBehavior" minOccurs="0"/>
 *         &lt;element name="delegation" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tDelegation" minOccurs="0"/>
 *         &lt;element name="presentationElements" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tPresentationElements" minOccurs="0"/>
 *         &lt;element name="outcome" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tQuery" minOccurs="0"/>
 *         &lt;element name="searchBy" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tExpression" minOccurs="0"/>
 *         &lt;element name="renderings" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tRenderings" minOccurs="0"/>
 *         &lt;element name="deadlines" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tDeadlines" minOccurs="0"/>
 *         &lt;element name="composition" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tComposition" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="actualOwnerRequired" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tBoolean" default="yes" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTaskBase", propOrder = {
    "_interface",
    "messageSchema",
    "priority",
    "peopleAssignments",
    "completionBehavior",
    "delegation",
    "presentationElements",
    "outcome",
    "searchBy",
    "renderings",
    "deadlines",
    "composition"
})
@XmlSeeAlso({
    TLeanTask.class,
    TTask.class
})
public abstract class TTaskBase
    extends TExtensibleElements
{

    @XmlElement(name = "interface")
    protected TTaskInterface _interface;
    protected TMessageSchema messageSchema;
    protected TPriorityExpr priority;
    protected TPeopleAssignments peopleAssignments;
    protected TCompletionBehavior completionBehavior;
    protected TDelegation delegation;
    protected TPresentationElements presentationElements;
    protected TQuery outcome;
    protected TExpression searchBy;
    protected TRenderings renderings;
    protected TDeadlines deadlines;
    protected TComposition composition;
    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String name;
    @XmlAttribute(name = "actualOwnerRequired")
    protected TBoolean actualOwnerRequired;

    /**
     * Gets the value of the interface property.
     * 
     * @return
     *     possible object is
     *     {@link TTaskInterface }
     *     
     */
    public TTaskInterface getInterface() {
        return _interface;
    }

    /**
     * Sets the value of the interface property.
     * 
     * @param value
     *     allowed object is
     *     {@link TTaskInterface }
     *     
     */
    public void setInterface(TTaskInterface value) {
        this._interface = value;
    }

    /**
     * Gets the value of the messageSchema property.
     * 
     * @return
     *     possible object is
     *     {@link TMessageSchema }
     *     
     */
    public TMessageSchema getMessageSchema() {
        return messageSchema;
    }

    /**
     * Sets the value of the messageSchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link TMessageSchema }
     *     
     */
    public void setMessageSchema(TMessageSchema value) {
        this.messageSchema = value;
    }

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
     * Gets the value of the completionBehavior property.
     * 
     * @return
     *     possible object is
     *     {@link TCompletionBehavior }
     *     
     */
    public TCompletionBehavior getCompletionBehavior() {
        return completionBehavior;
    }

    /**
     * Sets the value of the completionBehavior property.
     * 
     * @param value
     *     allowed object is
     *     {@link TCompletionBehavior }
     *     
     */
    public void setCompletionBehavior(TCompletionBehavior value) {
        this.completionBehavior = value;
    }

    /**
     * Gets the value of the delegation property.
     * 
     * @return
     *     possible object is
     *     {@link TDelegation }
     *     
     */
    public TDelegation getDelegation() {
        return delegation;
    }

    /**
     * Sets the value of the delegation property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDelegation }
     *     
     */
    public void setDelegation(TDelegation value) {
        this.delegation = value;
    }

    /**
     * Gets the value of the presentationElements property.
     * 
     * @return
     *     possible object is
     *     {@link TPresentationElements }
     *     
     */
    public TPresentationElements getPresentationElements() {
        return presentationElements;
    }

    /**
     * Sets the value of the presentationElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPresentationElements }
     *     
     */
    public void setPresentationElements(TPresentationElements value) {
        this.presentationElements = value;
    }

    /**
     * Gets the value of the outcome property.
     * 
     * @return
     *     possible object is
     *     {@link TQuery }
     *     
     */
    public TQuery getOutcome() {
        return outcome;
    }

    /**
     * Sets the value of the outcome property.
     * 
     * @param value
     *     allowed object is
     *     {@link TQuery }
     *     
     */
    public void setOutcome(TQuery value) {
        this.outcome = value;
    }

    /**
     * Gets the value of the searchBy property.
     * 
     * @return
     *     possible object is
     *     {@link TExpression }
     *     
     */
    public TExpression getSearchBy() {
        return searchBy;
    }

    /**
     * Sets the value of the searchBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link TExpression }
     *     
     */
    public void setSearchBy(TExpression value) {
        this.searchBy = value;
    }

    /**
     * Gets the value of the renderings property.
     * 
     * @return
     *     possible object is
     *     {@link TRenderings }
     *     
     */
    public TRenderings getRenderings() {
        return renderings;
    }

    /**
     * Sets the value of the renderings property.
     * 
     * @param value
     *     allowed object is
     *     {@link TRenderings }
     *     
     */
    public void setRenderings(TRenderings value) {
        this.renderings = value;
    }

    /**
     * Gets the value of the deadlines property.
     * 
     * @return
     *     possible object is
     *     {@link TDeadlines }
     *     
     */
    public TDeadlines getDeadlines() {
        return deadlines;
    }

    /**
     * Sets the value of the deadlines property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDeadlines }
     *     
     */
    public void setDeadlines(TDeadlines value) {
        this.deadlines = value;
    }

    /**
     * Gets the value of the composition property.
     * 
     * @return
     *     possible object is
     *     {@link TComposition }
     *     
     */
    public TComposition getComposition() {
        return composition;
    }

    /**
     * Sets the value of the composition property.
     * 
     * @param value
     *     allowed object is
     *     {@link TComposition }
     *     
     */
    public void setComposition(TComposition value) {
        this.composition = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the actualOwnerRequired property.
     * 
     * @return
     *     possible object is
     *     {@link TBoolean }
     *     
     */
    public TBoolean getActualOwnerRequired() {
        if (actualOwnerRequired == null) {
            return TBoolean.YES;
        } else {
            return actualOwnerRequired;
        }
    }

    /**
     * Sets the value of the actualOwnerRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link TBoolean }
     *     
     */
    public void setActualOwnerRequired(TBoolean value) {
        this.actualOwnerRequired = value;
    }

}
