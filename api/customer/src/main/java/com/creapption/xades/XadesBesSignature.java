package com.creapption.xades;

import es.mityc.firmaJava.libreria.xades.DataToSign;
import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.firmaJava.libreria.xades.elementos.xades.ObjectIdentifier;
import es.mityc.javasign.EnumFormatoFirma;
import es.mityc.javasign.xml.refs.InternObjectToSign;
import es.mityc.javasign.xml.refs.ObjectToSign;
import org.w3c.dom.Document;

import java.net.URI;

public class XadesBesSignature extends GenericXMLSignature {

    private Document documentToSign;

    public XadesBesSignature(Document documentToSign, String key, String password){
        super(key, password);
        this.documentToSign = documentToSign;
    }

    @Override
    protected DataToSign createDataToSign() {
        DataToSign dataToSign = new DataToSign();
        dataToSign.setXadesFormat(EnumFormatoFirma.XAdES_BES);
        dataToSign.setEsquema(XAdESSchemas.XAdES_132);
        dataToSign.setXMLEncoding("UTF-8");
        dataToSign.setEnveloped(true);
        dataToSign.addObject(new ObjectToSign(new InternObjectToSign("comprobante"), "contenido comprobante", (ObjectIdentifier)null, "text/xml", (URI)null));
        dataToSign.setDocument(documentToSign);
        return dataToSign;
    }
}