
package org.oasis_open.docs.ns.bpel4people.ws_humantask._200803;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for tSubtask complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tSubtask">
 *   &lt;complexContent>
 *     &lt;extension base="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tExtensibleElements">
 *       &lt;choice>
 *         &lt;element name="task" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tTask"/>
 *         &lt;element name="localTask" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tLocalTask"/>
 *       &lt;/choice>
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
@XmlType(name = "tSubtask", propOrder = {
    "task",
    "localTask"
})
public class TSubtask
    extends TExtensibleElements
{

    protected TTask task;
    protected TLocalTask localTask;
    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String name;

    /**
     * Gets the value of the task property.
     * 
     * @return
     *     possible object is
     *     {@link TTask }
     *     
     */
    public TTask getTask() {
        return task;
    }

    /**
     * Sets the value of the task property.
     * 
     * @param value
     *     allowed object is
     *     {@link TTask }
     *     
     */
    public void setTask(TTask value) {
        this.task = value;
    }

    /**
     * Gets the value of the localTask property.
     * 
     * @return
     *     possible object is
     *     {@link TLocalTask }
     *     
     */
    public TLocalTask getLocalTask() {
        return localTask;
    }

    /**
     * Sets the value of the localTask property.
     * 
     * @param value
     *     allowed object is
     *     {@link TLocalTask }
     *     
     */
    public void setLocalTask(TLocalTask value) {
        this.localTask = value;
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
