
package com.creapption.pojo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reembolsos", propOrder = {
    "reembolsoDetalle"
})
public class Reembolsos {

    @XmlElement(required = true)
    protected List<ReembolsoDetalle> reembolsoDetalle;

    public List<ReembolsoDetalle> getReembolsoDetalle() {
        if (reembolsoDetalle == null) {
            reembolsoDetalle = new ArrayList<ReembolsoDetalle>();
        }
        return this.reembolsoDetalle;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "tipoIdentificacionProveedorReembolso",
        "identificacionProveedorReembolso",
        "codPaisPagoProveedorReembolso",
        "tipoProveedorReembolso",
        "codDocReembolso",
        "estabDocReembolso",
        "ptoEmiDocReembolso",
        "secuencialDocReembolso",
        "fechaEmisionDocReembolso",
        "numeroautorizacionDocReemb",
        "detalleImpuestos",
        "compensacionesReembolso"
    })
    public static class ReembolsoDetalle {

        @XmlElement(required = true)
        protected String tipoIdentificacionProveedorReembolso;
        @XmlElement(required = true)
        protected String identificacionProveedorReembolso;
        protected String codPaisPagoProveedorReembolso;
        @XmlElement(required = true)
        protected String tipoProveedorReembolso;
        @XmlElement(required = true)
        protected String codDocReembolso;
        @XmlElement(required = true)
        protected String estabDocReembolso;
        @XmlElement(required = true)
        protected String ptoEmiDocReembolso;
        @XmlElement(required = true)
        protected String secuencialDocReembolso;
        @XmlElement(required = true)
        protected String fechaEmisionDocReembolso;
        @XmlElement(required = true)
        protected String numeroautorizacionDocReemb;
        @XmlElement(required = true)
        protected DetalleImpuestos detalleImpuestos;
        protected CompensacionesReembolso compensacionesReembolso;

        public String getTipoIdentificacionProveedorReembolso() {
            return tipoIdentificacionProveedorReembolso;
        }

        public void setTipoIdentificacionProveedorReembolso(String value) {
            this.tipoIdentificacionProveedorReembolso = value;
        }

        public String getIdentificacionProveedorReembolso() {
            return identificacionProveedorReembolso;
        }

        public void setIdentificacionProveedorReembolso(String value) {
            this.identificacionProveedorReembolso = value;
        }

        public String getCodPaisPagoProveedorReembolso() {
            return codPaisPagoProveedorReembolso;
        }

        public void setCodPaisPagoProveedorReembolso(String value) {
            this.codPaisPagoProveedorReembolso = value;
        }

        public String getTipoProveedorReembolso() {
            return tipoProveedorReembolso;
        }

        public void setTipoProveedorReembolso(String value) {
            this.tipoProveedorReembolso = value;
        }

        public String getCodDocReembolso() {
            return codDocReembolso;
        }

        public void setCodDocReembolso(String value) {
            this.codDocReembolso = value;
        }

        public String getEstabDocReembolso() {
            return estabDocReembolso;
        }

        public void setEstabDocReembolso(String value) {
            this.estabDocReembolso = value;
        }

        public String getPtoEmiDocReembolso() {
            return ptoEmiDocReembolso;
        }

        public void setPtoEmiDocReembolso(String value) {
            this.ptoEmiDocReembolso = value;
        }

        public String getSecuencialDocReembolso() {
            return secuencialDocReembolso;
        }

        public void setSecuencialDocReembolso(String value) {
            this.secuencialDocReembolso = value;
        }

        public String getFechaEmisionDocReembolso() {
            return fechaEmisionDocReembolso;
        }

        public void setFechaEmisionDocReembolso(String value) {
            this.fechaEmisionDocReembolso = value;
        }

        public String getNumeroautorizacionDocReemb() {
            return numeroautorizacionDocReemb;
        }

        public void setNumeroautorizacionDocReemb(String value) {
            this.numeroautorizacionDocReemb = value;
        }

        public DetalleImpuestos getDetalleImpuestos() {
            return detalleImpuestos;
        }

        public void setDetalleImpuestos(DetalleImpuestos value) {
            this.detalleImpuestos = value;
        }

        public CompensacionesReembolso getCompensacionesReembolso() {
            return compensacionesReembolso;
        }

        public void setCompensacionesReembolso(CompensacionesReembolso value) {
            this.compensacionesReembolso = value;
        }

    }

}
