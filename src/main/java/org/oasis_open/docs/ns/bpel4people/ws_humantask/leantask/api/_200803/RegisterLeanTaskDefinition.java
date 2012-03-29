
package org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TLeanTask;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="taskDefinition" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tLeanTask"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "taskDefinition"
})
@XmlRootElement(name = "registerLeanTaskDefinition")
public class RegisterLeanTaskDefinition {

    @XmlElement(required = true)
    protected TLeanTask taskDefinition;

    /**
     * Gets the value of the taskDefinition property.
     * 
     * @return
     *     possible object is
     *     {@link TLeanTask }
     *     
     */
    public TLeanTask getTaskDefinition() {
        return taskDefinition;
    }

    /**
     * Sets the value of the taskDefinition property.
     * 
     * @param value
     *     allowed object is
     *     {@link TLeanTask }
     *     
     */
    public void setTaskDefinition(TLeanTask value) {
        this.taskDefinition = value;
    }

}
