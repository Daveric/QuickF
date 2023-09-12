
package com.creapption.pojo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "compensacionesReembolso", propOrder = {
    "compensacionReembolso"
})
public class CompensacionesReembolso {

    @XmlElement(required = true)
    protected List<Compensacion> compensacionReembolso;

    public List<Compensacion> getCompensacionReembolso() {
        if (compensacionReembolso == null) {
            compensacionReembolso = new ArrayList<Compensacion>();
        }
        return this.compensacionReembolso;
    }

}
