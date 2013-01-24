
package org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TLeanTask;
import org.w3c.dom.Element;


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
 *         &lt;element name="inputMessage">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any processContents='lax'/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="taskDefinition" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tLeanTask" minOccurs="0"/>
 *         &lt;element name="taskName" type="{http://www.w3.org/2001/XMLSchema}NCName" minOccurs="0"/>
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
    "inputMessage",
    "taskDefinition",
    "taskName"
})
@XmlRootElement(name = "createLeanTask")
public class CreateLeanTask {

    @XmlElement(required = true)
    protected CreateLeanTask.InputMessage inputMessage;
    protected TLeanTask taskDefinition;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String taskName;

    /**
     * Gets the value of the inputMessage property.
     * 
     * @return
     *     possible object is
     *     {@link CreateLeanTask.InputMessage }
     *     
     */
    public CreateLeanTask.InputMessage getInputMessage() {
        return inputMessage;
    }

    /**
     * Sets the value of the inputMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateLeanTask.InputMessage }
     *     
     */
    public void setInputMessage(CreateLeanTask.InputMessage value) {
        this.inputMessage = value;
    }

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

    /**
     * Gets the value of the taskName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * Sets the value of the taskName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskName(String value) {
        this.taskName = value;
    }


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
     *         &lt;any processContents='lax'/>
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
        "any"
    })
    public static class InputMessage {

        @XmlAnyElement(lax = true)
        protected Object any;

        /**
         * Gets the value of the any property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     {@link Element }
         *     
         */
        public Object getAny() {
            return any;
        }

        /**
         * Sets the value of the any property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     {@link Element }
         *     
         */
        public void setAny(Object value) {
            this.any = value;
        }

    }

}
