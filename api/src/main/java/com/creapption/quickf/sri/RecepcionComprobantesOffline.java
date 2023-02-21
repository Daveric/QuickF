package com.creapption.quickf.sri;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.4
 * Generated source version: 3.4.4
 *
 */
@WebService(targetNamespace = "http://ec.gob.sri.ws.recepcion", name = "RecepcionComprobantesOffline")
@XmlSeeAlso({ObjectFactory.class})
public interface RecepcionComprobantesOffline {

    @WebMethod
    @RequestWrapper(localName = "validarComprobante", targetNamespace = "http://ec.gob.sri.ws.recepcion", className = "com.creapption.quickf.sri.ValidarComprobante")
    @ResponseWrapper(localName = "validarComprobanteResponse", targetNamespace = "http://ec.gob.sri.ws.recepcion", className = "com.creapption.quickf.sri.ValidarComprobanteResponse")
    @WebResult(name = "RespuestaRecepcionComprobante", targetNamespace = "")
    public RespuestaSolicitud validarComprobante(

        @WebParam(name = "xml", targetNamespace = "")
        byte[] xml
    );
}