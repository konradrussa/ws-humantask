
package org.oasis_open.docs.ns.bpel4people.ws_humantask._200803;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tPotentialOwnerAssignment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tPotentialOwnerAssignment">
 *   &lt;complexContent>
 *     &lt;extension base="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tGenericHumanRoleAssignmentBase">
 *       &lt;choice>
 *         &lt;element name="from" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tFrom"/>
 *         &lt;element name="parallel" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tParallel"/>
 *         &lt;element name="sequence" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tSequence"/>
 *       &lt;/choice>
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tPotentialOwnerAssignment", propOrder = {
    "from",
    "parallel",
    "sequence"
})
public class TPotentialOwnerAssignment
    extends TGenericHumanRoleAssignmentBase
{

    protected TFrom from;
    protected TParallel parallel;
    protected TSequence sequence;

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link TFrom }
     *     
     */
    public TFrom getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link TFrom }
     *     
     */
    public void setFrom(TFrom value) {
        this.from = value;
    }

    /**
     * Gets the value of the parallel property.
     * 
     * @return
     *     possible object is
     *     {@link TParallel }
     *     
     */
    public TParallel getParallel() {
        return parallel;
    }

    /**
     * Sets the value of the parallel property.
     * 
     * @param value
     *     allowed object is
     *     {@link TParallel }
     *     
     */
    public void setParallel(TParallel value) {
        this.parallel = value;
    }

    /**
     * Gets the value of the sequence property.
     * 
     * @return
     *     possible object is
     *     {@link TSequence }
     *     
     */
    public TSequence getSequence() {
        return sequence;
    }

    /**
     * Sets the value of the sequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link TSequence }
     *     
     */
    public void setSequence(TSequence value) {
        this.sequence = value;
    }

}
