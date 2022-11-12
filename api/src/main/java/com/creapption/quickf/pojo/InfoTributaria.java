
package com.creapption.quickf.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "infoTributaria", propOrder = {
    "ambiente",
    "tipoEmision",
    "razonSocial",
    "nombreComercial",
    "ruc",
    "claveAcceso",
    "codDoc",
    "estab",
    "ptoEmi",
    "secuencial",
    "dirMatriz",
    "agenteRetencion",
    "contribuyenteRimpe"
})
public class InfoTributaria {

    @XmlElement(required = true)
    protected String ambiente;
    @XmlElement(required = true)
    protected String tipoEmision;
    @XmlElement(required = true)
    protected String razonSocial;
    protected String nombreComercial;
    @XmlElement(required = true)
    protected String ruc;
    @XmlElement(required = true)
    protected String claveAcceso;
    // Type of receipt
    @XmlElement(required = true)
    protected String codDoc;
    @XmlElement(required = true)
    protected String estab;
    @XmlElement(required = true)
    protected String ptoEmi;
    @XmlElement(required = true)
    protected String secuencial;
    @XmlElement(required = true)
    protected String dirMatriz;
    protected String agenteRetencion;
    protected String contribuyenteRimpe;

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String value) {
        this.ambiente = value;
    }

    public String getTipoEmision() {
        return tipoEmision;
    }

    public void setTipoEmision(String value) {
        this.tipoEmision = value;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String value) {
        this.razonSocial = value;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String value) {
        this.nombreComercial = value;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String value) {
        this.ruc = value;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String value) {
        this.claveAcceso = value;
    }

    public String getCodDoc() {
        return codDoc;
    }

    public void setCodDoc(String value) {
        this.codDoc = value;
    }

    public String getEstab() {
        return estab;
    }

    public void setEstab(String value) {
        this.estab = value;
    }

    public String getPtoEmi() {
        return ptoEmi;
    }

    public void setPtoEmi(String value) {
        this.ptoEmi = value;
    }

    public String getSecuencial() {
        return secuencial;
    }

    public void setSecuencial(String value) {
        this.secuencial = value;
    }

    public String getDirMatriz() {
        return dirMatriz;
    }

    public void setDirMatriz(String value) {
        this.dirMatriz = value;
    }

    public String getAgenteRetencion() {
        return agenteRetencion;
    }

    public void setAgenteRetencion(String value) {
        this.agenteRetencion = value;
    }

    public String getContribuyenteRimpe() {
        return contribuyenteRimpe;
    }

    public void setContribuyenteRimpe(String value) {
        this.contribuyenteRimpe = value;
    }

}
