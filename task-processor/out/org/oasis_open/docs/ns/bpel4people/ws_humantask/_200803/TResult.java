
package org.oasis_open.docs.ns.bpel4people.ws_humantask._200803;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tExtensibleElements">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="aggregate" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tAggregate"/>
 *         &lt;element name="copy" type="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/200803}tCopy"/>
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
@XmlType(name = "tResult", propOrder = {
    "aggregateOrCopy"
})
public class TResult
    extends TExtensibleElements
{

    @XmlElements({
        @XmlElement(name = "aggregate", type = TAggregate.class),
        @XmlElement(name = "copy", type = TCopy.class)
    })
    protected List<TExtensibleElements> aggregateOrCopy;

    /**
     * Gets the value of the aggregateOrCopy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the aggregateOrCopy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAggregateOrCopy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TAggregate }
     * {@link TCopy }
     * 
     * 
     */
    public List<TExtensibleElements> getAggregateOrCopy() {
        if (aggregateOrCopy == null) {
            aggregateOrCopy = new ArrayList<TExtensibleElements>();
        }
        return this.aggregateOrCopy;
    }

}
