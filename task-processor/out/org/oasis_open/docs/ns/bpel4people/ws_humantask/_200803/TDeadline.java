
package org.oasis_open.docs.ns.bpel4people.ws_humantask._200803;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for tDeadline complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tDeadline">
 *   &lt;complexContent>
 *     &lt;extension base="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tExtensibleElements">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="for" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tDuration-expr"/>
 *           &lt;element name="until" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tDeadline-expr"/>
 *         &lt;/choice>
 *         &lt;element name="escalation" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tEscalation" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "tDeadline", propOrder = {
    "_for",
    "until",
    "escalation"
})
public class TDeadline
    extends TExtensibleElements
{

    @XmlElement(name = "for")
    protected TDurationExpr _for;
    protected TDeadlineExpr until;
    protected List<TEscalation> escalation;
    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String name;

    /**
     * Gets the value of the for property.
     * 
     * @return
     *     possible object is
     *     {@link TDurationExpr }
     *     
     */
    public TDurationExpr getFor() {
        return _for;
    }

    /**
     * Sets the value of the for property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDurationExpr }
     *     
     */
    public void setFor(TDurationExpr value) {
        this._for = value;
    }

    /**
     * Gets the value of the until property.
     * 
     * @return
     *     possible object is
     *     {@link TDeadlineExpr }
     *     
     */
    public TDeadlineExpr getUntil() {
        return until;
    }

    /**
     * Sets the value of the until property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDeadlineExpr }
     *     
     */
    public void setUntil(TDeadlineExpr value) {
        this.until = value;
    }

    /**
     * Gets the value of the escalation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the escalation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEscalation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TEscalation }
     * 
     * 
     */
    public List<TEscalation> getEscalation() {
        if (escalation == null) {
            escalation = new ArrayList<TEscalation>();
        }
        return this.escalation;
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