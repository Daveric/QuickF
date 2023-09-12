
package com.creapption.pojo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "compensaciones", propOrder = {
    "compensacion"
})
public class Compensaciones {

    @XmlElement(required = true)
    protected List<Compensacion> compensacion;

    public List<Compensacion> getCompensacion() {
        if (compensacion == null) {
            compensacion = new ArrayList<Compensacion>();
        }
        return this.compensacion;
    }

}
