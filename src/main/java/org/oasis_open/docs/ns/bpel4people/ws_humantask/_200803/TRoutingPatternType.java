
package org.oasis_open.docs.ns.bpel4people.ws_humantask._200803;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tRoutingPatternType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tRoutingPatternType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="all"/>
 *     &lt;enumeration value="single"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tRoutingPatternType")
@XmlEnum
public enum TRoutingPatternType {

    @XmlEnumValue("all")
    ALL("all"),
    @XmlEnumValue("single")
    SINGLE("single");
    private final String value;

    TRoutingPatternType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TRoutingPatternType fromValue(String v) {
        for (TRoutingPatternType c: TRoutingPatternType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
