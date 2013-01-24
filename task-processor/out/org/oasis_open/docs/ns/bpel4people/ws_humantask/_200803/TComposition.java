
package org.oasis_open.docs.ns.bpel4people.ws_humantask._200803;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tComposition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tComposition">
 *   &lt;complexContent>
 *     &lt;extension base="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tExtensibleElements">
 *       &lt;sequence>
 *         &lt;element name="subtask" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tSubtask" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tCompositionType" default="sequential" />
 *       &lt;attribute name="instantiationPattern" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tPattern" default="manual" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tComposition", propOrder = {
    "subtask"
})
public class TComposition
    extends TExtensibleElements
{

    @XmlElement(required = true)
    protected List<TSubtask> subtask;
    @XmlAttribute(name = "type")
    protected TCompositionType type;
    @XmlAttribute(name = "instantiationPattern")
    protected TPattern instantiationPattern;

    /**
     * Gets the value of the subtask property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subtask property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubtask().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TSubtask }
     * 
     * 
     */
    public List<TSubtask> getSubtask() {
        if (subtask == null) {
            subtask = new ArrayList<TSubtask>();
        }
        return this.subtask;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link TCompositionType }
     *     
     */
    public TCompositionType getType() {
        if (type == null) {
            return TCompositionType.SEQUENTIAL;
        } else {
            return type;
        }
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link TCompositionType }
     *     
     */
    public void setType(TCompositionType value) {
        this.type = value;
    }

    /**
     * Gets the value of the instantiationPattern property.
     * 
     * @return
     *     possible object is
     *     {@link TPattern }
     *     
     */
    public TPattern getInstantiationPattern() {
        if (instantiationPattern == null) {
            return TPattern.MANUAL;
        } else {
            return instantiationPattern;
        }
    }

    /**
     * Sets the value of the instantiationPattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPattern }
     *     
     */
    public void setInstantiationPattern(TPattern value) {
        this.instantiationPattern = value;
    }

}
