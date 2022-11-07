
package com.creapption.quickf.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Contiene la informacion del destinatario
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "destino", propOrder = {
    "motivoTraslado",
    "docAduaneroUnico",
    "codEstabDestino",
    "ruta"
})
public class Destino {

    @XmlElement(required = true)
    protected String motivoTraslado;
    protected String docAduaneroUnico;
    protected String codEstabDestino;
    protected String ruta;

    public String getMotivoTraslado() {
        return motivoTraslado;
    }

    public void setMotivoTraslado(String value) {
        this.motivoTraslado = value;
    }

    public String getDocAduaneroUnico() {
        return docAduaneroUnico;
    }

    public void setDocAduaneroUnico(String value) {
        this.docAduaneroUnico = value;
    }

    public String getCodEstabDestino() {
        return codEstabDestino;
    }

    public void setCodEstabDestino(String value) {
        this.codEstabDestino = value;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String value) {
        this.ruta = value;
    }

}
