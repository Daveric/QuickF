
package com.creapption.quickf.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
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
