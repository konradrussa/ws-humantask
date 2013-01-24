
package org.oasis_open.docs.ns.bpel4people.ws_humantask._200803;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tCompletionBehavior complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tCompletionBehavior">
 *   &lt;complexContent>
 *     &lt;extension base="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tExtensibleElements">
 *       &lt;sequence>
 *         &lt;element name="completion" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tCompletion" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="defaultCompletion" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tDefaultCompletion" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="completionAction" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tPattern" default="automatic" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCompletionBehavior", propOrder = {
    "completion",
    "defaultCompletion"
})
public class TCompletionBehavior
    extends TExtensibleElements
{

    protected List<TCompletion> completion;
    protected TDefaultCompletion defaultCompletion;
    @XmlAttribute(name = "completionAction")
    protected TPattern completionAction;

    /**
     * Gets the value of the completion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the completion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCompletion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCompletion }
     * 
     * 
     */
    public List<TCompletion> getCompletion() {
        if (completion == null) {
            completion = new ArrayList<TCompletion>();
        }
        return this.completion;
    }

    /**
     * Gets the value of the defaultCompletion property.
     * 
     * @return
     *     possible object is
     *     {@link TDefaultCompletion }
     *     
     */
    public TDefaultCompletion getDefaultCompletion() {
        return defaultCompletion;
    }

    /**
     * Sets the value of the defaultCompletion property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDefaultCompletion }
     *     
     */
    public void setDefaultCompletion(TDefaultCompletion value) {
        this.defaultCompletion = value;
    }

    /**
     * Gets the value of the completionAction property.
     * 
     * @return
     *     possible object is
     *     {@link TPattern }
     *     
     */
    public TPattern getCompletionAction() {
        if (completionAction == null) {
            return TPattern.AUTOMATIC;
        } else {
            return completionAction;
        }
    }

    /**
     * Sets the value of the completionAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPattern }
     *     
     */
    public void setCompletionAction(TPattern value) {
        this.completionAction = value;
    }

}
