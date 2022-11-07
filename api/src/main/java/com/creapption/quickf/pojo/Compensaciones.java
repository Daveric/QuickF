
package com.creapption.quickf.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
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
