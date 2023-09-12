
package com.creapption.pojo;


import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "obligadoContabilidad")
@XmlEnum
public enum ObligadoContabilidad {

    SI,
    NO;

    public String value() {
        return name();
    }

    public static ObligadoContabilidad fromValue(String v) {
        return valueOf(v);
    }

}
