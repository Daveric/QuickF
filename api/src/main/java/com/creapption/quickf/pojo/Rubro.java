
package com.creapption.quickf.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rubro", propOrder = {
    "concepto",
    "total"
})
public class Rubro {

    @XmlElement(required = true)
    protected String concepto;
    @XmlElement(required = true)
    protected BigDecimal total;

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String value) {
        this.concepto = value;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal value) {
        this.total = value;
    }

}
