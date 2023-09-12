package com.creapption.sri.reception;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.4
 * Generated source version: 3.4.4
 *
 */
@WebService(targetNamespace = "http://ec.gob.sri.ws.recepcion", name = "RecepcionComprobantesOffline")
@XmlSeeAlso({ObjectFactory.class})
public interface RecepcionComprobantesOffline {

    @WebMethod
    @RequestWrapper(localName = "validarComprobante", targetNamespace = "http://ec.gob.sri.ws.recepcion", className = "com.creapption.sri.reception.ValidarComprobante")
    @ResponseWrapper(localName = "validarComprobanteResponse", targetNamespace = "http://ec.gob.sri.ws.recepcion", className = "com.creapption.sri.reception.ValidarComprobanteResponse")
    @WebResult(name = "RespuestaRecepcionComprobante", targetNamespace = "")
    public RespuestaSolicitud validarComprobante(

        @WebParam(name = "xml", targetNamespace = "")
        byte[] xml
    );
}