
package com.creapption.pojo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pagos", propOrder = {
    "pago"
})
public class Pagos {

    @XmlElement(required = true)
    protected List<Pago> pago;

    public List<Pago> getPago() {
        if (pago == null) {
            pago = new ArrayList<Pago>();
        }
        return this.pago;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "formaPago",
        "total",
        "plazo",
        "unidadTiempo"
    })
    public static class Pago {

        @XmlElement(required = true)
        protected String formaPago;
        @XmlElement(required = true)
        protected BigDecimal total;
        protected BigDecimal plazo;
        protected String unidadTiempo;

        public String getFormaPago() {
            return formaPago;
        }

        public void setFormaPago(String value) {
            this.formaPago = value;
        }

        public BigDecimal getTotal() {
            return total;
        }

        public void setTotal(BigDecimal value) {
            this.total = value;
        }

        public BigDecimal getPlazo() {
            return plazo;
        }

        public void setPlazo(BigDecimal value) {
            this.plazo = value;
        }

        public String getUnidadTiempo() {
            return unidadTiempo;
        }

        public void setUnidadTiempo(String value) {
            this.unidadTiempo = value;
        }

    }

}
