
package org.oasis_open.docs.ns.bpel4people.ws_humantask.leantask.api._200803;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="leanTaskDefinitions">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="leanTaskDefinition" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tLeanTask" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "leanTaskDefinitions"
})
@XmlRootElement(name = "listLeanTaskDefinitionsResponse")
public class ListLeanTaskDefinitionsResponse {

    @XmlElement(required = true)
    protected ListLeanTaskDefinitionsResponse.LeanTaskDefinitions leanTaskDefinitions;

    /**
     * Gets the value of the leanTaskDefinitions property.
     * 
     * @return
     *     possible object is
     *     {@link ListLeanTaskDefinitionsResponse.LeanTaskDefinitions }
     *     
     */
    public ListLeanTaskDefinitionsResponse.LeanTaskDefinitions getLeanTaskDefinitions() {
        return leanTaskDefinitions;
    }

    /**
     * Sets the value of the leanTaskDefinitions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListLeanTaskDefinitionsResponse.LeanTaskDefinitions }
     *     
     */
    public void setLeanTaskDefinitions(ListLeanTaskDefinitionsResponse.LeanTaskDefinitions value) {
        this.leanTaskDefinitions = value;
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
     *         &lt;element name="leanTaskDefinition" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tLeanTask" maxOccurs="unbounded" minOccurs="0"/>
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
        "leanTaskDefinition"
    })
    public static class LeanTaskDefinitions {

        protected List<TLeanTask> leanTaskDefinition;

        /**
         * Gets the value of the leanTaskDefinition property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the leanTaskDefinition property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLeanTaskDefinition().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TLeanTask }
         * 
         * 
         */
        public List<TLeanTask> getLeanTaskDefinition() {
            if (leanTaskDefinition == null) {
                leanTaskDefinition = new ArrayList<TLeanTask>();
            }
            return this.leanTaskDefinition;
        }

    }

}
