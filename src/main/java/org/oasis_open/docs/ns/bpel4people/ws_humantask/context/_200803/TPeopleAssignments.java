//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.07.24 at 11:55:17 PM CEST 
//


package org.oasis_open.docs.ns.bpel4people.ws_humantask.context._200803;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tPeopleAssignments complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tPeopleAssignments">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/context/200803}genericHumanRole" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tPeopleAssignments", propOrder = {
    "genericHumanRole"
})
public class TPeopleAssignments {

    @XmlElementRef(name = "genericHumanRole", namespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/context/200803", type = JAXBElement.class)
    protected List<JAXBElement<TGenericHumanRole>> genericHumanRole;

    /**
     * Gets the value of the genericHumanRole property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericHumanRole property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericHumanRole().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link TGenericHumanRole }{@code >}
     * {@link JAXBElement }{@code <}{@link TGenericHumanRole }{@code >}
     * {@link JAXBElement }{@code <}{@link TGenericHumanRole }{@code >}
     * {@link JAXBElement }{@code <}{@link TGenericHumanRole }{@code >}
     * {@link JAXBElement }{@code <}{@link TGenericHumanRole }{@code >}
     * {@link JAXBElement }{@code <}{@link TGenericHumanRole }{@code >}
     * {@link JAXBElement }{@code <}{@link TGenericHumanRole }{@code >}
     * 
     * 
     */
    public List<JAXBElement<TGenericHumanRole>> getGenericHumanRole() {
        if (genericHumanRole == null) {
            genericHumanRole = new ArrayList<JAXBElement<TGenericHumanRole>>();
        }
        return this.genericHumanRole;
    }

}
