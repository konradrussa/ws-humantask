
package com.example.claims;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ClaimApprovalData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClaimApprovalData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cust">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="firstname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="lastname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="region" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="activateAt" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClaimApprovalData", propOrder = {
    "cust",
    "amount",
    "region",
    "prio",
    "activateAt"
})
public class ClaimApprovalData {

    @XmlElement(required = true)
    protected ClaimApprovalData.Cust cust;
    protected double amount;
    @XmlElement(required = true)
    protected String region;
    protected int prio;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar activateAt;

    /**
     * Gets the value of the cust property.
     * 
     * @return
     *     possible object is
     *     {@link ClaimApprovalData.Cust }
     *     
     */
    public ClaimApprovalData.Cust getCust() {
        return cust;
    }

    /**
     * Sets the value of the cust property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClaimApprovalData.Cust }
     *     
     */
    public void setCust(ClaimApprovalData.Cust value) {
        this.cust = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     */
    public void setAmount(double value) {
        this.amount = value;
    }

    /**
     * Gets the value of the region property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegion(String value) {
        this.region = value;
    }

    /**
     * Gets the value of the prio property.
     * 
     */
    public int getPrio() {
        return prio;
    }

    /**
     * Sets the value of the prio property.
     * 
     */
    public void setPrio(int value) {
        this.prio = value;
    }

    /**
     * Gets the value of the activateAt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActivateAt() {
        return activateAt;
    }

    /**
     * Sets the value of the activateAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActivateAt(XMLGregorianCalendar value) {
        this.activateAt = value;
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
     *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="firstname" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="lastname" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "id",
        "firstname",
        "lastname"
    })
    public static class Cust {

        @XmlElement(required = true)
        protected String id;
        @XmlElement(required = true)
        protected String firstname;
        @XmlElement(required = true)
        protected String lastname;

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }

        /**
         * Gets the value of the firstname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFirstname() {
            return firstname;
        }

        /**
         * Sets the value of the firstname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFirstname(String value) {
            this.firstname = value;
        }

        /**
         * Gets the value of the lastname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLastname() {
            return lastname;
        }

        /**
         * Sets the value of the lastname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLastname(String value) {
            this.lastname = value;
        }

		@Override
		public String toString() {
			return "Cust [id=" + id + ", firstname=" + firstname
					+ ", lastname=" + lastname + "]";
		}
        

    }


	@Override
	public String toString() {
		return "ClaimApprovalData [cust=" + cust + ", amount=" + amount
				+ ", region=" + region + ", prio=" + prio + ", activateAt="
				+ activateAt + "]";
	}
    
    

}
