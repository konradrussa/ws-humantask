
package org.oasis_open.docs.ns.bpel4people.ws_humantask._200803;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tCompositionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tCompositionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="sequential"/>
 *     &lt;enumeration value="parallel"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tCompositionType")
@XmlEnum
public enum TCompositionType {

    @XmlEnumValue("sequential")
    SEQUENTIAL("sequential"),
    @XmlEnumValue("parallel")
    PARALLEL("parallel");
    private final String value;

    TCompositionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TCompositionType fromValue(String v) {
        for (TCompositionType c: TCompositionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
