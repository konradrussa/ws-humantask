//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.07.24 at 11:55:17 PM CEST 
//


package org.oasis_open.docs.ns.bpel4people.ws_humantask.context._200803;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TOrganizationalEntity;


/**
 * <p>Java class for tGenericHumanRole complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tGenericHumanRole">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803}organizationalEntity"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tGenericHumanRole", propOrder = {
    "organizationalEntity"
})
public class TGenericHumanRole {

    @XmlElement(namespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803", required = true)
    protected TOrganizationalEntity organizationalEntity;

    /**
     * Gets the value of the organizationalEntity property.
     * 
     * @return
     *     possible object is
     *     {@link TOrganizationalEntity }
     *     
     */
    public TOrganizationalEntity getOrganizationalEntity() {
        return organizationalEntity;
    }

    /**
     * Sets the value of the organizationalEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link TOrganizationalEntity }
     *     
     */
    public void setOrganizationalEntity(TOrganizationalEntity value) {
        this.organizationalEntity = value;
    }

}