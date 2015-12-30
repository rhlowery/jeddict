//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2014.01.21 at 01:52:19 PM IST
//
package org.netbeans.jpa.modeler.spec.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "jaxb-var")
@XmlEnum
public enum JaxbVariableType {

    @XmlEnumValue("A")
    XML_ATTRIBUTE("A", "Attribute"),
    @XmlEnumValue("V")
    XML_VALUE("V", "Value"),
    @XmlEnumValue("E")
    XML_ELEMENT("E", "Element"),
    @XmlEnumValue("W")
    XML_ELEMENTS("W", "Elements"),
    @XmlEnumValue("T")
    XML_TRANSIENT("T", "Transient"),
    @XmlEnumValue("L_A")
    XML_LIST_ATTRIBUTE("L_A", "Attribute List"),
    @XmlEnumValue("L_V")
    XML_LIST_VALUE("L_V", "Value List"),
    @XmlEnumValue("L_E")
    XML_LIST_ELEMENT("L_E", "Element List");

    private final String type, display;

    JaxbVariableType(String type, String display) {
        this.type = type;
        this.display = display;
    }

    public String value() {
        return name();
    }

    public static JaxbVariableType fromValue(String v) {
        for (JaxbVariableType c : JaxbVariableType.values()) {
            if (c.getType().equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
//    public String value() {
//        return name();
//    }

//    public static FetchType fromValue(String v) {
//        return valueOf(v);
//    }
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the display
     */
    public String getDisplayText() {
        return display;
    }
}