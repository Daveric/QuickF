
package com.creapption.pojo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.math.BigDecimal;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "compensacion", propOrder = {
    "codigo",
    "tarifa",
    "valor"
})
public class Compensacion {

    @XmlElement(required = true)
    protected String codigo;
    @XmlElement(required = true)
    protected BigDecimal tarifa;
    @XmlElement(required = true)
    protected BigDecimal valor;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String value) {
        this.codigo = value;
    }

    public BigDecimal getTarifa() {
        return tarifa;
    }

    public void setTarifa(BigDecimal value) {
        this.tarifa = value;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal value) {
        this.valor = value;
    }

}
