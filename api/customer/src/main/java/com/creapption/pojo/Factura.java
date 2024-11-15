
package com.creapption.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.xml.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "infoTributaria",
    "infoFactura",
    "detalles",
    "reembolsos",
    "retenciones",
    "infoSustitutivaGuiaRemision",
    "otrosRubrosTerceros",
    "tipoNegociable",
    "maquinaFiscal",
    "infoAdicional"
})
@XmlRootElement(name = "factura")
public class Factura {

    @XmlElement(required = true)
    protected InfoTributaria infoTributaria;
    @XmlElement(required = true)
    protected InfoFactura infoFactura;
    @XmlElement(required = true)
    protected Detalles detalles;
    protected Reembolsos reembolsos;
    protected Retenciones retenciones;
    protected InfoSustitutivaGuiaRemision infoSustitutivaGuiaRemision;
    protected OtrosRubrosTerceros otrosRubrosTerceros;
    protected TipoNegociable tipoNegociable;
    protected MaquinaFiscal maquinaFiscal;
    protected InfoAdicional infoAdicional;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "version")
    @XmlSchemaType(name = "anySimpleType")
    protected String version;

    /**
     * Gets the value of the infoTributaria property.
     * 
     * @return
     *     possible object is
     *     {@link InfoTributaria }
     *     
     */
    public InfoTributaria getInfoTributaria() {
        return infoTributaria;
    }

    /**
     * Sets the value of the infoTributaria property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoTributaria }
     *     
     */
    public void setInfoTributaria(InfoTributaria value) {
        this.infoTributaria = value;
    }

    /**
     * Gets the value of the infoFactura property.
     * 
     * @return
     *     possible object is
     *     {@link InfoFactura }
     *     
     */
    public InfoFactura getInfoFactura() {
        return infoFactura;
    }

    /**
     * Sets the value of the infoFactura property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoFactura }
     *     
     */
    public void setInfoFactura(InfoFactura value) {
        this.infoFactura = value;
    }

    /**
     * Gets the value of the detalles property.
     * 
     * @return
     *     possible object is
     *     {@link Detalles }
     *     
     */
    public Detalles getDetalles() {
        return detalles;
    }

    /**
     * Sets the value of the detalles property.
     * 
     * @param value
     *     allowed object is
     *     {@link Detalles }
     *     
     */
    public void setDetalles(Detalles value) {
        this.detalles = value;
    }

    /**
     * Gets the value of the reembolsos property.
     * 
     * @return
     *     possible object is
     *     {@link Reembolsos }
     *     
     */
    public Reembolsos getReembolsos() {
        return reembolsos;
    }

    /**
     * Sets the value of the reembolsos property.
     * 
     * @param value
     *     allowed object is
     *     {@link Reembolsos }
     *     
     */
    public void setReembolsos(Reembolsos value) {
        this.reembolsos = value;
    }

    /**
     * Gets the value of the retenciones property.
     * 
     * @return
     *     possible object is
     *     {@link Retenciones }
     *     
     */
    public Retenciones getRetenciones() {
        return retenciones;
    }

    /**
     * Sets the value of the retenciones property.
     * 
     * @param value
     *     allowed object is
     *     {@link Retenciones }
     *     
     */
    public void setRetenciones(Retenciones value) {
        this.retenciones = value;
    }

    /**
     * Gets the value of the infoSustitutivaGuiaRemision property.
     * 
     * @return
     *     possible object is
     *     {@link InfoSustitutivaGuiaRemision }
     *     
     */
    public InfoSustitutivaGuiaRemision getInfoSustitutivaGuiaRemision() {
        return infoSustitutivaGuiaRemision;
    }

    /**
     * Sets the value of the infoSustitutivaGuiaRemision property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoSustitutivaGuiaRemision }
     *     
     */
    public void setInfoSustitutivaGuiaRemision(InfoSustitutivaGuiaRemision value) {
        this.infoSustitutivaGuiaRemision = value;
    }

    /**
     * Gets the value of the otrosRubrosTerceros property.
     * 
     * @return
     *     possible object is
     *     {@link OtrosRubrosTerceros }
     *     
     */
    public OtrosRubrosTerceros getOtrosRubrosTerceros() {
        return otrosRubrosTerceros;
    }

    /**
     * Sets the value of the otrosRubrosTerceros property.
     * 
     * @param value
     *     allowed object is
     *     {@link OtrosRubrosTerceros }
     *     
     */
    public void setOtrosRubrosTerceros(OtrosRubrosTerceros value) {
        this.otrosRubrosTerceros = value;
    }

    /**
     * Gets the value of the tipoNegociable property.
     * 
     * @return
     *     possible object is
     *     {@link TipoNegociable }
     *     
     */
    public TipoNegociable getTipoNegociable() {
        return tipoNegociable;
    }

    /**
     * Sets the value of the tipoNegociable property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoNegociable }
     *     
     */
    public void setTipoNegociable(TipoNegociable value) {
        this.tipoNegociable = value;
    }

    /**
     * Gets the value of the maquinaFiscal property.
     * 
     * @return
     *     possible object is
     *     {@link MaquinaFiscal }
     *     
     */
    public MaquinaFiscal getMaquinaFiscal() {
        return maquinaFiscal;
    }

    /**
     * Sets the value of the maquinaFiscal property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaquinaFiscal }
     *     
     */
    public void setMaquinaFiscal(MaquinaFiscal value) {
        this.maquinaFiscal = value;
    }

    /**
     * Gets the value of the infoAdicional property.
     * 
     * @return
     *     possible object is
     *     {@link InfoAdicional }
     *     
     */
    public InfoAdicional getInfoAdicional() {
        return infoAdicional;
    }

    /**
     * Sets the value of the infoAdicional property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoAdicional }
     *     
     */
    public void setInfoAdicional(InfoAdicional value) {
        this.infoAdicional = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "detalle"
    })
    public static class Detalles {

        @XmlElement(required = true)
        protected List<Detalle> detalle;

        /**
         * Gets the value of the detalle property.
         * 
         * &lt;p&gt;
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the detalle property.
         * 
         * &lt;p&gt;
         * For example, to add a new item, do as follows:
         * &lt;pre&gt;
         *    getDetalle().add(newItem);
         * &lt;/pre&gt;
         * 
         * 
         * &lt;p&gt;
         * Objects of the following type(s) are allowed in the list
         * {@link Detalle }
         * 
         * 
         */
        public List<Detalle> getDetalle() {
            if (detalle == null) {
                detalle = new ArrayList<Detalle>();
            }
            return this.detalle;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "codigoPrincipal",
            "codigoAuxiliar",
            "descripcion",
            "unidadMedida",
            "cantidad",
            "precioUnitario",
            "precioSinSubsidio",
            "descuento",
            "precioTotalSinImpuesto",
            "detallesAdicionales",
            "impuestos"
        })
        public static class Detalle {

            protected String codigoPrincipal;
            protected String codigoAuxiliar;
            @XmlElement(required = true)
            protected String descripcion;
            protected String unidadMedida;
            @XmlElement(required = true)
            protected BigDecimal cantidad;
            @XmlElement(required = true)
            protected BigDecimal precioUnitario;
            protected BigDecimal precioSinSubsidio;
            @XmlElement(required = true)
            protected BigDecimal descuento;
            @XmlElement(required = true)
            protected BigDecimal precioTotalSinImpuesto;
            protected DetallesAdicionales detallesAdicionales;
            @XmlElement(required = true)
            protected Impuestos impuestos;

            /**
             * Gets the value of the codigoPrincipal property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodigoPrincipal() {
                return codigoPrincipal;
            }

            /**
             * Sets the value of the codigoPrincipal property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodigoPrincipal(String value) {
                this.codigoPrincipal = value;
            }

            /**
             * Gets the value of the codigoAuxiliar property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodigoAuxiliar() {
                return codigoAuxiliar;
            }

            /**
             * Sets the value of the codigoAuxiliar property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodigoAuxiliar(String value) {
                this.codigoAuxiliar = value;
            }

            /**
             * Gets the value of the descripcion property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescripcion() {
                return descripcion;
            }

            /**
             * Sets the value of the descripcion property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescripcion(String value) {
                this.descripcion = value;
            }

            /**
             * Gets the value of the unidadMedida property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUnidadMedida() {
                return unidadMedida;
            }

            /**
             * Sets the value of the unidadMedida property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUnidadMedida(String value) {
                this.unidadMedida = value;
            }

            /**
             * Gets the value of the cantidad property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getCantidad() {
                return cantidad;
            }

            /**
             * Sets the value of the cantidad property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setCantidad(BigDecimal value) {
                this.cantidad = value;
            }

            /**
             * Gets the value of the precioUnitario property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getPrecioUnitario() {
                return precioUnitario;
            }

            /**
             * Sets the value of the precioUnitario property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setPrecioUnitario(BigDecimal value) {
                this.precioUnitario = value;
            }

            /**
             * Gets the value of the precioSinSubsidio property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getPrecioSinSubsidio() {
                return precioSinSubsidio;
            }

            /**
             * Sets the value of the precioSinSubsidio property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setPrecioSinSubsidio(BigDecimal value) {
                this.precioSinSubsidio = value;
            }

            /**
             * Gets the value of the descuento property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getDescuento() {
                return descuento;
            }

            /**
             * Sets the value of the descuento property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setDescuento(BigDecimal value) {
                this.descuento = value;
            }

            /**
             * Gets the value of the precioTotalSinImpuesto property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getPrecioTotalSinImpuesto() {
                return precioTotalSinImpuesto;
            }

            /**
             * Sets the value of the precioTotalSinImpuesto property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setPrecioTotalSinImpuesto(BigDecimal value) {
                this.precioTotalSinImpuesto = value;
            }

            /**
             * Gets the value of the detallesAdicionales property.
             * 
             * @return
             *     possible object is
             *     {@link DetallesAdicionales }
             *     
             */
            public DetallesAdicionales getDetallesAdicionales() {
                return detallesAdicionales;
            }

            /**
             * Sets the value of the detallesAdicionales property.
             * 
             * @param value
             *     allowed object is
             *     {@link DetallesAdicionales }
             *     
             */
            public void setDetallesAdicionales(DetallesAdicionales value) {
                this.detallesAdicionales = value;
            }

            /**
             * Gets the value of the impuestos property.
             * 
             * @return
             *     possible object is
             *     {@link Impuestos }
             *     
             */
            public Impuestos getImpuestos() {
                return impuestos;
            }

            /**
             * Sets the value of the impuestos property.
             * 
             * @param value
             *     allowed object is
             *     {@link Impuestos }
             *     
             */
            public void setImpuestos(Impuestos value) {
                this.impuestos = value;
            }


            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "detAdicional"
            })
            public static class DetallesAdicionales {

                @XmlElement(required = true)
                protected List<DetAdicional> detAdicional;

                /**
                 * Gets the value of the detAdicional property.
                 * 
                 * &lt;p&gt;
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the detAdicional property.
                 * 
                 * &lt;p&gt;
                 * For example, to add a new item, do as follows:
                 * &lt;pre&gt;
                 *    getDetAdicional().add(newItem);
                 * &lt;/pre&gt;
                 * 
                 * 
                 * &lt;p&gt;
                 * Objects of the following type(s) are allowed in the list
                 * {@link DetAdicional }
                 * 
                 * 
                 */
                public List<DetAdicional> getDetAdicional() {
                    if (detAdicional == null) {
                        detAdicional = new ArrayList<DetAdicional>();
                    }
                    return this.detAdicional;
                }


                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class DetAdicional {

                    @XmlAttribute(name = "nombre", required = true)
                    protected String nombre;
                    @XmlAttribute(name = "valor", required = true)
                    protected String valor;

                    /**
                     * Gets the value of the nombre property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getNombre() {
                        return nombre;
                    }

                    /**
                     * Sets the value of the nombre property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setNombre(String value) {
                        this.nombre = value;
                    }

                    /**
                     * Gets the value of the valor property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getValor() {
                        return valor;
                    }

                    /**
                     * Sets the value of the valor property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setValor(String value) {
                        this.valor = value;
                    }

                }

            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "impuesto"
            })
            public static class Impuestos {

                @XmlElement(required = true)
                protected List<Impuesto> impuesto;

                /**
                 * Gets the value of the impuesto property.
                 * 
                 * &lt;p&gt;
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the impuesto property.
                 * 
                 * &lt;p&gt;
                 * For example, to add a new item, do as follows:
                 * &lt;pre&gt;
                 *    getImpuesto().add(newItem);
                 * &lt;/pre&gt;
                 * 
                 * 
                 * &lt;p&gt;
                 * Objects of the following type(s) are allowed in the list
                 * {@link Impuesto }
                 * 
                 * 
                 */
                public List<Impuesto> getImpuesto() {
                    if (impuesto == null) {
                        impuesto = new ArrayList<Impuesto>();
                    }
                    return this.impuesto;
                }

            }

        }

    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "campoAdicional"
    })
    public static class InfoAdicional {

        @XmlElement(required = true)
        protected List<CampoAdicional> campoAdicional;

        /**
         * Gets the value of the campoAdicional property.
         * 
         * &lt;p&gt;
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the campoAdicional property.
         * 
         * &lt;p&gt;
         * For example, to add a new item, do as follows:
         * &lt;pre&gt;
         *    getCampoAdicional().add(newItem);
         * &lt;/pre&gt;
         * 
         * 
         * &lt;p&gt;
         * Objects of the following type(s) are allowed in the list
         * {@link CampoAdicional }
         * 
         * 
         */
        public List<CampoAdicional> getCampoAdicional() {
            if (campoAdicional == null) {
                campoAdicional = new ArrayList<CampoAdicional>();
            }
            return this.campoAdicional;
        }


        /**
         * &lt;p&gt;Java class for anonymous complex type.
         * 
         * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
         * 
         * &lt;pre&gt;
         * &amp;lt;complexType&amp;gt;
         *   &amp;lt;simpleContent&amp;gt;
         *     &amp;lt;extension base="&amp;lt;&amp;gt;campoAdicional"&amp;gt;
         *       &amp;lt;attribute name="nombre" use="required" type="{}nombre" /&amp;gt;
         *     &amp;lt;/extension&amp;gt;
         *   &amp;lt;/simpleContent&amp;gt;
         * &amp;lt;/complexType&amp;gt;
         * &lt;/pre&gt;
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class CampoAdicional {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "nombre", required = true)
            protected String nombre;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the nombre property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNombre() {
                return nombre;
            }

            /**
             * Sets the value of the nombre property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNombre(String value) {
                this.nombre = value;
            }

        }

    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "fechaEmision",
        "dirEstablecimiento",
        "contribuyenteEspecial",
        "obligadoContabilidad",
        "comercioExterior",
        "incoTermFactura",
        "lugarIncoTerm",
        "paisOrigen",
        "puertoEmbarque",
        "puertoDestino",
        "paisDestino",
        "paisAdquisicion",
        "tipoIdentificacionComprador",
        "guiaRemision",
        "razonSocialComprador",
        "identificacionComprador",
        "direccionComprador",
        "totalSinImpuestos",
        "totalSubsidio",
        "incoTermTotalSinImpuestos",
        "totalDescuento",
        "codDocReembolso",
        "totalComprobantesReembolso",
        "totalBaseImponibleReembolso",
        "totalImpuestoReembolso",
        "totalConImpuestos",
        "compensaciones",
        "propina",
        "fleteInternacional",
        "seguroInternacional",
        "gastosAduaneros",
        "gastosTransporteOtros",
        "importeTotal",
        "moneda",
        "placa",
        "pagos",
        "valorRetIva",
        "valorRetRenta"
    })
    public static class InfoFactura {

        @XmlElement(required = true)
        protected String fechaEmision;
        @XmlTransient
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-5")
        protected Date fechaHoraEmision;
        protected String dirEstablecimiento;
        protected String contribuyenteEspecial;
        @XmlSchemaType(name = "string")
        protected ObligadoContabilidad obligadoContabilidad;
        protected String comercioExterior;
        protected String incoTermFactura;
        protected String lugarIncoTerm;
        protected String paisOrigen;
        protected String puertoEmbarque;
        protected String puertoDestino;
        protected String paisDestino;
        protected String paisAdquisicion;
        @XmlElement(required = true)
        protected String tipoIdentificacionComprador;
        protected String guiaRemision;
        @XmlElement(required = true)
        protected String razonSocialComprador;
        @XmlElement(required = true)
        protected String identificacionComprador;
        protected String direccionComprador;
        @XmlElement(required = true)
        protected BigDecimal totalSinImpuestos;
        protected BigDecimal totalSubsidio;
        protected String incoTermTotalSinImpuestos;
        @XmlElement(required = true)
        protected BigDecimal totalDescuento;
        protected String codDocReembolso;
        protected BigDecimal totalComprobantesReembolso;
        protected BigDecimal totalBaseImponibleReembolso;
        protected BigDecimal totalImpuestoReembolso;
        @XmlElement(required = true)
        protected TotalConImpuestos totalConImpuestos;
        protected Compensaciones compensaciones;
        protected BigDecimal propina;
        protected BigDecimal fleteInternacional;
        protected BigDecimal seguroInternacional;
        protected BigDecimal gastosAduaneros;
        protected BigDecimal gastosTransporteOtros;
        @XmlElement(required = true)
        protected BigDecimal importeTotal;
        protected String moneda;
        protected String placa;
        protected Pagos pagos;
        protected BigDecimal valorRetIva;
        protected BigDecimal valorRetRenta;

        /**
         * Gets the value of the fechaEmision property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFechaEmision() {
            return fechaEmision;
        }

        /**
         * Sets the value of the fechaEmision property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFechaEmision(String value) { this.fechaEmision = value; }

        public Date getFechaHoraEmision() {
            return fechaHoraEmision;
        }

        public void setFechaHoraEmision(Date value){ this.fechaHoraEmision = value; }

        /**
         * Gets the value of the dirEstablecimiento property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDirEstablecimiento() {
            return dirEstablecimiento;
        }

        /**
         * Sets the value of the dirEstablecimiento property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDirEstablecimiento(String value) {
            this.dirEstablecimiento = value;
        }

        /**
         * Gets the value of the contribuyenteEspecial property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContribuyenteEspecial() {
            return contribuyenteEspecial;
        }

        /**
         * Sets the value of the contribuyenteEspecial property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContribuyenteEspecial(String value) {
            this.contribuyenteEspecial = value;
        }

        /**
         * Gets the value of the obligadoContabilidad property.
         * 
         * @return
         *     possible object is
         *     {@link ObligadoContabilidad }
         *     
         */
        public ObligadoContabilidad getObligadoContabilidad() {
            return obligadoContabilidad;
        }

        /**
         * Sets the value of the obligadoContabilidad property.
         * 
         * @param value
         *     allowed object is
         *     {@link ObligadoContabilidad }
         *     
         */
        public void setObligadoContabilidad(ObligadoContabilidad value) {
            this.obligadoContabilidad = value;
        }

        /**
         * Gets the value of the comercioExterior property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getComercioExterior() {
            return comercioExterior;
        }

        /**
         * Sets the value of the comercioExterior property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setComercioExterior(String value) {
            this.comercioExterior = value;
        }

        /**
         * Gets the value of the incoTermFactura property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIncoTermFactura() {
            return incoTermFactura;
        }

        /**
         * Sets the value of the incoTermFactura property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIncoTermFactura(String value) {
            this.incoTermFactura = value;
        }

        /**
         * Gets the value of the lugarIncoTerm property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLugarIncoTerm() {
            return lugarIncoTerm;
        }

        /**
         * Sets the value of the lugarIncoTerm property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLugarIncoTerm(String value) {
            this.lugarIncoTerm = value;
        }

        /**
         * Gets the value of the paisOrigen property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaisOrigen() {
            return paisOrigen;
        }

        /**
         * Sets the value of the paisOrigen property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaisOrigen(String value) {
            this.paisOrigen = value;
        }

        /**
         * Gets the value of the puertoEmbarque property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPuertoEmbarque() {
            return puertoEmbarque;
        }

        /**
         * Sets the value of the puertoEmbarque property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPuertoEmbarque(String value) {
            this.puertoEmbarque = value;
        }

        /**
         * Gets the value of the puertoDestino property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPuertoDestino() {
            return puertoDestino;
        }

        /**
         * Sets the value of the puertoDestino property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPuertoDestino(String value) {
            this.puertoDestino = value;
        }

        /**
         * Gets the value of the paisDestino property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaisDestino() {
            return paisDestino;
        }

        /**
         * Sets the value of the paisDestino property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaisDestino(String value) {
            this.paisDestino = value;
        }

        /**
         * Gets the value of the paisAdquisicion property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaisAdquisicion() {
            return paisAdquisicion;
        }

        /**
         * Sets the value of the paisAdquisicion property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaisAdquisicion(String value) {
            this.paisAdquisicion = value;
        }

        /**
         * Gets the value of the tipoIdentificacionComprador property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTipoIdentificacionComprador() {
            return tipoIdentificacionComprador;
        }

        /**
         * Sets the value of the tipoIdentificacionComprador property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTipoIdentificacionComprador(String value) {
            this.tipoIdentificacionComprador = value;
        }

        /**
         * Gets the value of the guiaRemision property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGuiaRemision() {
            return guiaRemision;
        }

        /**
         * Sets the value of the guiaRemision property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGuiaRemision(String value) {
            this.guiaRemision = value;
        }

        /**
         * Gets the value of the razonSocialComprador property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRazonSocialComprador() {
            return razonSocialComprador;
        }

        /**
         * Sets the value of the razonSocialComprador property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRazonSocialComprador(String value) {
            this.razonSocialComprador = value;
        }

        /**
         * Gets the value of the identificacionComprador property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIdentificacionComprador() {
            return identificacionComprador;
        }

        /**
         * Sets the value of the identificacionComprador property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIdentificacionComprador(String value) {
            this.identificacionComprador = value;
        }

        /**
         * Gets the value of the direccionComprador property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDireccionComprador() {
            return direccionComprador;
        }

        /**
         * Sets the value of the direccionComprador property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDireccionComprador(String value) {
            this.direccionComprador = value;
        }

        /**
         * Gets the value of the totalSinImpuestos property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTotalSinImpuestos() {
            return totalSinImpuestos;
        }

        /**
         * Sets the value of the totalSinImpuestos property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTotalSinImpuestos(BigDecimal value) {
            this.totalSinImpuestos = value;
        }

        /**
         * Gets the value of the totalSubsidio property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTotalSubsidio() {
            return totalSubsidio;
        }

        /**
         * Sets the value of the totalSubsidio property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTotalSubsidio(BigDecimal value) {
            this.totalSubsidio = value;
        }

        /**
         * Gets the value of the incoTermTotalSinImpuestos property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIncoTermTotalSinImpuestos() {
            return incoTermTotalSinImpuestos;
        }

        /**
         * Sets the value of the incoTermTotalSinImpuestos property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIncoTermTotalSinImpuestos(String value) {
            this.incoTermTotalSinImpuestos = value;
        }

        /**
         * Gets the value of the totalDescuento property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTotalDescuento() {
            return totalDescuento;
        }

        /**
         * Sets the value of the totalDescuento property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTotalDescuento(BigDecimal value) {
            this.totalDescuento = value;
        }

        /**
         * Gets the value of the codDocReembolso property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCodDocReembolso() {
            return codDocReembolso;
        }

        /**
         * Sets the value of the codDocReembolso property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCodDocReembolso(String value) {
            this.codDocReembolso = value;
        }

        /**
         * Gets the value of the totalComprobantesReembolso property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTotalComprobantesReembolso() {
            return totalComprobantesReembolso;
        }

        /**
         * Sets the value of the totalComprobantesReembolso property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTotalComprobantesReembolso(BigDecimal value) {
            this.totalComprobantesReembolso = value;
        }

        /**
         * Gets the value of the totalBaseImponibleReembolso property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTotalBaseImponibleReembolso() {
            return totalBaseImponibleReembolso;
        }

        /**
         * Sets the value of the totalBaseImponibleReembolso property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTotalBaseImponibleReembolso(BigDecimal value) {
            this.totalBaseImponibleReembolso = value;
        }

        /**
         * Gets the value of the totalImpuestoReembolso property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTotalImpuestoReembolso() {
            return totalImpuestoReembolso;
        }

        /**
         * Sets the value of the totalImpuestoReembolso property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTotalImpuestoReembolso(BigDecimal value) {
            this.totalImpuestoReembolso = value;
        }

        /**
         * Gets the value of the totalConImpuestos property.
         * 
         * @return
         *     possible object is
         *     {@link TotalConImpuestos }
         *     
         */
        public TotalConImpuestos getTotalConImpuestos() {
            return totalConImpuestos;
        }

        /**
         * Sets the value of the totalConImpuestos property.
         * 
         * @param value
         *     allowed object is
         *     {@link TotalConImpuestos }
         *     
         */
        public void setTotalConImpuestos(TotalConImpuestos value) {
            this.totalConImpuestos = value;
        }

        /**
         * Gets the value of the compensaciones property.
         * 
         * @return
         *     possible object is
         *     {@link Compensaciones }
         *     
         */
        public Compensaciones getCompensaciones() {
            return compensaciones;
        }

        /**
         * Sets the value of the compensaciones property.
         * 
         * @param value
         *     allowed object is
         *     {@link Compensaciones }
         *     
         */
        public void setCompensaciones(Compensaciones value) {
            this.compensaciones = value;
        }

        /**
         * Gets the value of the propina property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getPropina() {
            return propina;
        }

        /**
         * Sets the value of the propina property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setPropina(BigDecimal value) {
            this.propina = value;
        }

        /**
         * Gets the value of the fleteInternacional property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFleteInternacional() {
            return fleteInternacional;
        }

        /**
         * Sets the value of the fleteInternacional property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFleteInternacional(BigDecimal value) {
            this.fleteInternacional = value;
        }

        /**
         * Gets the value of the seguroInternacional property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getSeguroInternacional() {
            return seguroInternacional;
        }

        /**
         * Sets the value of the seguroInternacional property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setSeguroInternacional(BigDecimal value) {
            this.seguroInternacional = value;
        }

        /**
         * Gets the value of the gastosAduaneros property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getGastosAduaneros() {
            return gastosAduaneros;
        }

        /**
         * Sets the value of the gastosAduaneros property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setGastosAduaneros(BigDecimal value) {
            this.gastosAduaneros = value;
        }

        /**
         * Gets the value of the gastosTransporteOtros property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getGastosTransporteOtros() {
            return gastosTransporteOtros;
        }

        /**
         * Sets the value of the gastosTransporteOtros property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setGastosTransporteOtros(BigDecimal value) {
            this.gastosTransporteOtros = value;
        }

        /**
         * Gets the value of the importeTotal property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getImporteTotal() {
            return importeTotal;
        }

        /**
         * Sets the value of the importeTotal property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setImporteTotal(BigDecimal value) {
            this.importeTotal = value;
        }

        /**
         * Gets the value of the moneda property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMoneda() {
            return moneda;
        }

        /**
         * Sets the value of the moneda property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMoneda(String value) {
            this.moneda = value;
        }

        /**
         * Gets the value of the placa property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPlaca() {
            return placa;
        }

        /**
         * Sets the value of the placa property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPlaca(String value) {
            this.placa = value;
        }

        /**
         * Gets the value of the pagos property.
         * 
         * @return
         *     possible object is
         *     {@link Pagos }
         *     
         */
        public Pagos getPagos() {
            return pagos;
        }

        /**
         * Sets the value of the pagos property.
         * 
         * @param value
         *     allowed object is
         *     {@link Pagos }
         *     
         */
        public void setPagos(Pagos value) {
            this.pagos = value;
        }

        /**
         * Gets the value of the valorRetIva property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getValorRetIva() {
            return valorRetIva;
        }

        /**
         * Sets the value of the valorRetIva property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setValorRetIva(BigDecimal value) {
            this.valorRetIva = value;
        }

        /**
         * Gets the value of the valorRetRenta property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getValorRetRenta() {
            return valorRetRenta;
        }

        /**
         * Sets the value of the valorRetRenta property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setValorRetRenta(BigDecimal value) {
            this.valorRetRenta = value;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "totalImpuesto"
        })
        public static class TotalConImpuestos {

            @XmlElement(required = true)
            protected List<TotalImpuesto> totalImpuesto;

            /**
             * Gets the value of the totalImpuesto property.
             * 
             * &lt;p&gt;
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the totalImpuesto property.
             * 
             * &lt;p&gt;
             * For example, to add a new item, do as follows:
             * &lt;pre&gt;
             *    getTotalImpuesto().add(newItem);
             * &lt;/pre&gt;
             * 
             * 
             * &lt;p&gt;
             * Objects of the following type(s) are allowed in the list
             * {@link TotalImpuesto }
             * 
             * 
             */
            public List<TotalImpuesto> getTotalImpuesto() {
                if (totalImpuesto == null) {
                    totalImpuesto = new ArrayList<TotalImpuesto>();
                }
                return this.totalImpuesto;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "codigo",
                "codigoPorcentaje",
                "descuentoAdicional",
                "baseImponible",
                "tarifa",
                "valor",
                "valorDevolucionIva"
            })
            public static class TotalImpuesto {

                @XmlElement(required = true)
                protected String codigo;
                @XmlElement(required = true)
                protected String codigoPorcentaje;
                protected BigDecimal descuentoAdicional;
                @XmlElement(required = true)
                protected BigDecimal baseImponible;
                protected BigDecimal tarifa;
                @XmlElement(required = true)
                protected BigDecimal valor;
                protected BigDecimal valorDevolucionIva;

                /**
                 * Gets the value of the codigo property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCodigo() {
                    return codigo;
                }

                /**
                 * Sets the value of the codigo property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCodigo(String value) {
                    this.codigo = value;
                }

                /**
                 * Gets the value of the codigoPorcentaje property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCodigoPorcentaje() {
                    return codigoPorcentaje;
                }

                /**
                 * Sets the value of the codigoPorcentaje property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCodigoPorcentaje(String value) {
                    this.codigoPorcentaje = value;
                }

                /**
                 * Gets the value of the descuentoAdicional property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getDescuentoAdicional() {
                    return descuentoAdicional;
                }

                /**
                 * Sets the value of the descuentoAdicional property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setDescuentoAdicional(BigDecimal value) {
                    this.descuentoAdicional = value;
                }

                /**
                 * Gets the value of the baseImponible property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getBaseImponible() {
                    return baseImponible;
                }

                /**
                 * Sets the value of the baseImponible property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setBaseImponible(BigDecimal value) {
                    this.baseImponible = value;
                }

                /**
                 * Gets the value of the tarifa property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getTarifa() {
                    return tarifa;
                }

                /**
                 * Sets the value of the tarifa property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setTarifa(BigDecimal value) {
                    this.tarifa = value;
                }

                /**
                 * Gets the value of the valor property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getValor() {
                    return valor;
                }

                /**
                 * Sets the value of the valor property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setValor(BigDecimal value) {
                    this.valor = value;
                }

                /**
                 * Gets the value of the valorDevolucionIva property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getValorDevolucionIva() {
                    return valorDevolucionIva;
                }

                /**
                 * Sets the value of the valorDevolucionIva property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setValorDevolucionIva(BigDecimal value) {
                    this.valorDevolucionIva = value;
                }

            }

        }

    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "dirPartida",
        "dirDestinatario",
        "fechaIniTransporte",
        "fechaFinTransporte",
        "razonSocialTransportista",
        "tipoIdentificacionTransportista",
        "rucTransportista",
        "placa",
        "destinos"
    })
    public static class InfoSustitutivaGuiaRemision {

        @XmlElement(required = true)
        protected String dirPartida;
        @XmlElement(required = true)
        protected String dirDestinatario;
        @XmlElement(required = true)
        protected String fechaIniTransporte;
        @XmlElement(required = true)
        protected String fechaFinTransporte;
        @XmlElement(required = true)
        protected String razonSocialTransportista;
        @XmlElement(required = true)
        protected String tipoIdentificacionTransportista;
        @XmlElement(required = true)
        protected String rucTransportista;
        @XmlElement(required = true)
        protected String placa;
        @XmlElement(required = true)
        protected Destinos destinos;

        /**
         * Gets the value of the dirPartida property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDirPartida() {
            return dirPartida;
        }

        /**
         * Sets the value of the dirPartida property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDirPartida(String value) {
            this.dirPartida = value;
        }

        /**
         * Gets the value of the dirDestinatario property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDirDestinatario() {
            return dirDestinatario;
        }

        /**
         * Sets the value of the dirDestinatario property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDirDestinatario(String value) {
            this.dirDestinatario = value;
        }

        /**
         * Gets the value of the fechaIniTransporte property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFechaIniTransporte() {
            return fechaIniTransporte;
        }

        /**
         * Sets the value of the fechaIniTransporte property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFechaIniTransporte(String value) {
            this.fechaIniTransporte = value;
        }

        /**
         * Gets the value of the fechaFinTransporte property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFechaFinTransporte() {
            return fechaFinTransporte;
        }

        /**
         * Sets the value of the fechaFinTransporte property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFechaFinTransporte(String value) {
            this.fechaFinTransporte = value;
        }

        /**
         * Gets the value of the razonSocialTransportista property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRazonSocialTransportista() {
            return razonSocialTransportista;
        }

        /**
         * Sets the value of the razonSocialTransportista property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRazonSocialTransportista(String value) {
            this.razonSocialTransportista = value;
        }

        /**
         * Gets the value of the tipoIdentificacionTransportista property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTipoIdentificacionTransportista() {
            return tipoIdentificacionTransportista;
        }

        /**
         * Sets the value of the tipoIdentificacionTransportista property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTipoIdentificacionTransportista(String value) {
            this.tipoIdentificacionTransportista = value;
        }

        /**
         * Gets the value of the rucTransportista property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRucTransportista() {
            return rucTransportista;
        }

        /**
         * Sets the value of the rucTransportista property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRucTransportista(String value) {
            this.rucTransportista = value;
        }

        /**
         * Gets the value of the placa property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPlaca() {
            return placa;
        }

        /**
         * Sets the value of the placa property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPlaca(String value) {
            this.placa = value;
        }

        /**
         * Gets the value of the destinos property.
         * 
         * @return
         *     possible object is
         *     {@link Destinos }
         *     
         */
        public Destinos getDestinos() {
            return destinos;
        }

        /**
         * Sets the value of the destinos property.
         * 
         * @param value
         *     allowed object is
         *     {@link Destinos }
         *     
         */
        public void setDestinos(Destinos value) {
            this.destinos = value;
        }


        /**
         * &lt;p&gt;Java class for anonymous complex type.
         * 
         * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
         * 
         * &lt;pre&gt;
         * &amp;lt;complexType&amp;gt;
         *   &amp;lt;complexContent&amp;gt;
         *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
         *       &amp;lt;sequence&amp;gt;
         *         &amp;lt;element name="destino" type="{}destino" maxOccurs="unbounded"/&amp;gt;
         *       &amp;lt;/sequence&amp;gt;
         *     &amp;lt;/restriction&amp;gt;
         *   &amp;lt;/complexContent&amp;gt;
         * &amp;lt;/complexType&amp;gt;
         * &lt;/pre&gt;
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "destino"
        })
        public static class Destinos {

            @XmlElement(required = true)
            protected List<Destino> destino;

            /**
             * Gets the value of the destino property.
             * 
             * &lt;p&gt;
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the destino property.
             * 
             * &lt;p&gt;
             * For example, to add a new item, do as follows:
             * &lt;pre&gt;
             *    getDestino().add(newItem);
             * &lt;/pre&gt;
             * 
             * 
             * &lt;p&gt;
             * Objects of the following type(s) are allowed in the list
             * {@link Destino }
             * 
             * 
             */
            public List<Destino> getDestino() {
                if (destino == null) {
                    destino = new ArrayList<Destino>();
                }
                return this.destino;
            }

        }

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "rubro"
    })
    public static class OtrosRubrosTerceros {

        @XmlElement(required = true)
        protected List<Rubro> rubro;

        /**
         * Gets the value of the rubro property.
         * 
         * &lt;p&gt;
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the rubro property.
         * 
         * &lt;p&gt;
         * For example, to add a new item, do as follows:
         * &lt;pre&gt;
         *    getRubro().add(newItem);
         * &lt;/pre&gt;
         * 
         * 
         * &lt;p&gt;
         * Objects of the following type(s) are allowed in the list
         * {@link Rubro }
         * 
         * 
         */
        public List<Rubro> getRubro() {
            if (rubro == null) {
                rubro = new ArrayList<Rubro>();
            }
            return this.rubro;
        }

    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "retencion"
    })
    public static class Retenciones {

        @XmlElement(required = true)
        protected List<Retencion> retencion;

        /**
         * Gets the value of the retencion property.
         * 
         * &lt;p&gt;
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the retencion property.
         * 
         * &lt;p&gt;
         * For example, to add a new item, do as follows:
         * &lt;pre&gt;
         *    getRetencion().add(newItem);
         * &lt;/pre&gt;
         * 
         * 
         * &lt;p&gt;
         * Objects of the following type(s) are allowed in the list
         * {@link Retencion }
         * 
         * 
         */
        public List<Retencion> getRetencion() {
            if (retencion == null) {
                retencion = new ArrayList<Retencion>();
            }
            return this.retencion;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "codigo",
            "codigoPorcentaje",
            "tarifa",
            "valor"
        })
        public static class Retencion {

            @XmlElement(required = true)
            protected String codigo;
            @XmlElement(required = true)
            protected String codigoPorcentaje;
            @XmlElement(required = true)
            protected BigDecimal tarifa;
            @XmlElement(required = true)
            protected BigDecimal valor;

            /**
             * Gets the value of the codigo property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodigo() {
                return codigo;
            }

            /**
             * Sets the value of the codigo property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodigo(String value) {
                this.codigo = value;
            }

            /**
             * Gets the value of the codigoPorcentaje property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodigoPorcentaje() {
                return codigoPorcentaje;
            }

            /**
             * Sets the value of the codigoPorcentaje property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodigoPorcentaje(String value) {
                this.codigoPorcentaje = value;
            }

            /**
             * Gets the value of the tarifa property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getTarifa() {
                return tarifa;
            }

            /**
             * Sets the value of the tarifa property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setTarifa(BigDecimal value) {
                this.tarifa = value;
            }

            /**
             * Gets the value of the valor property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getValor() {
                return valor;
            }

            /**
             * Sets the value of the valor property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setValor(BigDecimal value) {
                this.valor = value;
            }

        }

    }

}
