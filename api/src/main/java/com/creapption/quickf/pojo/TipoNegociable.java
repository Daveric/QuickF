
package com.creapption.quickf.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoNegociable", propOrder = {
    "correo"
})
public class TipoNegociable {

    @XmlElement(required = true)
    protected String correo;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String value) {
        this.correo = value;
    }

}
