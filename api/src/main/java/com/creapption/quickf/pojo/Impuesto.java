
package com.creapption.quickf.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "impuesto", propOrder = {
    "codigo",
    "codigoPorcentaje",
    "tarifa",
    "baseImponible",
    "valor"
})
public class Impuesto {

    @XmlElement(required = true)
    protected String codigo;
    @XmlElement(required = true)
    protected String codigoPorcentaje;
    @XmlElement(required = true)
    protected BigDecimal tarifa;
    @XmlElement(required = true)
    protected BigDecimal baseImponible;
    @XmlElement(required = true)
    protected BigDecimal valor;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String value) {
        this.codigo = value;
    }

    public String getCodigoPorcentaje() {
        return codigoPorcentaje;
    }

    public void setCodigoPorcentaje(String value) {
        this.codigoPorcentaje = value;
    }

    public BigDecimal getTarifa() {
        return tarifa;
    }

    public void setTarifa(BigDecimal value) {
        this.tarifa = value;
    }

    public BigDecimal getBaseImponible() {
        return baseImponible;
    }

    public void setBaseImponible(BigDecimal value) {
        this.baseImponible = value;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal value) {
        this.valor = value;
    }

}
