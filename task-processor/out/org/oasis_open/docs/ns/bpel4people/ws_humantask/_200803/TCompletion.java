
package org.oasis_open.docs.ns.bpel4people.ws_humantask._200803;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tCompletion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tCompletion">
 *   &lt;complexContent>
 *     &lt;extension base="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tExtensibleElements">
 *       &lt;sequence>
 *         &lt;element name="condition" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tBoolean-expr"/>
 *         &lt;element name="result" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tResult" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCompletion", propOrder = {
    "condition",
    "result"
})
public class TCompletion
    extends TExtensibleElements
{

    @XmlElement(required = true)
    protected TBooleanExpr condition;
    protected TResult result;

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
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link TResult }
     *     
     */
    public TResult getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link TResult }
     *     
     */
    public void setResult(TResult value) {
        this.result = value;
    }

}
