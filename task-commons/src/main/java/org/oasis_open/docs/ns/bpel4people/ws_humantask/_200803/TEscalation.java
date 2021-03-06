
package org.oasis_open.docs.ns.bpel4people.ws_humantask._200803;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for tEscalation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tEscalation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tExtensibleElements">
 *       &lt;sequence>
 *         &lt;element name="condition" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tBoolean-expr" minOccurs="0"/>
 *         &lt;element name="toParts" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tToParts" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="notification" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tNotification"/>
 *           &lt;element name="localNotification" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tLocalNotification"/>
 *           &lt;element name="reassignment" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tReassignment"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tEscalation", propOrder = {
    "condition",
    "toParts",
    "notification",
    "localNotification",
    "reassignment"
})
public class TEscalation
    extends TExtensibleElements
{

    protected TBooleanExpr condition;
    protected TToParts toParts;
    protected TNotification notification;
    protected TLocalNotification localNotification;
    protected TReassignment reassignment;
    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String name;

    /**
     * Gets the value of the condition property.
     * 
     * @return
     *     possible object is
     *     {@link TBooleanExpr }
     *     
     */
    public TBooleanExpr getCondition() {
        return condition;
    }

    /**
     * Sets the value of the condition property.
     * 
     * @param value
     *     allowed object is
     *     {@link TBooleanExpr }
     *     
     */
    public void setCondition(TBooleanExpr value) {
        this.condition = value;
    }

    /**
     * Gets the value of the toParts property.
     * 
     * @return
     *     possible object is
     *     {@link TToParts }
     *     
     */
    public TToParts getToParts() {
        return toParts;
    }

    /**
     * Sets the value of the toParts property.
     * 
     * @param value
     *     allowed object is
     *     {@link TToParts }
     *     
     */
    public void setToParts(TToParts value) {
        this.toParts = value;
    }

    /**
     * Gets the value of the notification property.
     * 
     * @return
     *     possible object is
     *     {@link TNotification }
     *     
     */
    public TNotification getNotification() {
        return notification;
    }

    /**
     * Sets the value of the notification property.
     * 
     * @param value
     *     allowed object is
     *     {@link TNotification }
     *     
     */
    public void setNotification(TNotification value) {
        this.notification = value;
    }

    /**
     * Gets the value of the localNotification property.
     * 
     * @return
     *     possible object is
     *     {@link TLocalNotification }
     *     
     */
    public TLocalNotification getLocalNotification() {
        return localNotification;
    }

    /**
     * Sets the value of the localNotification property.
     * 
     * @param value
     *     allowed object is
     *     {@link TLocalNotification }
     *     
     */
    public void setLocalNotification(TLocalNotification value) {
        this.localNotification = value;
    }

    /**
     * Gets the value of the reassignment property.
     * 
     * @return
     *     possible object is
     *     {@link TReassignment }
     *     
     */
    public TReassignment getReassignment() {
        return reassignment;
    }

    /**
     * Sets the value of the reassignment property.
     * 
     * @param value
     *     allowed object is
     *     {@link TReassignment }
     *     
     */
    public void setReassignment(TReassignment value) {
        this.reassignment = value;
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

}
