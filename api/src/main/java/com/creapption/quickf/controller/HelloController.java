package com.creapption.quickf.controller;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creapption.quickf.UniqueAccessKey;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import xades4j.algorithms.EnvelopedSignatureTransform;
import xades4j.production.DataObjectReference;
import xades4j.production.SignedDataObjects;
import xades4j.production.XadesBesSigningProfile;
import xades4j.production.XadesSigner;
import xades4j.properties.DataObjectDesc;
import xades4j.providers.impl.FileSystemKeyStoreKeyingDataProvider;
import xades4j.providers.impl.KeyStoreKeyingDataProvider;
import xades4j.utils.DOMHelper;

@RestController
public class HelloController {
    private static final String password = "Loayzaq2022*";

    /**
     * @return
     */
    @RequestMapping("/")
    public String hello() throws Exception
    {   
        signBes();
        return "Hello World!";
    }    
    
    /**
     * @throws Exception
     */
    public static void signBes() throws Exception{
        Document doc = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse(new File("/Users/brayanloayza/Projects/quickf/api/src/main/resources/factura_without_signature.xml"));
        Element elem = doc.getDocumentElement();
        DOMHelper.useIdAsXmlId(elem);

        FileSystemKeyStoreKeyingDataProvider kp = FileSystemKeyStoreKeyingDataProvider
        .builder("pkcs12", 
        "/Users/brayanloayza/Projects/quickf/api/src/main/resources/LOAYZA_BRAYAN.p12",
        KeyStoreKeyingDataProvider.SigningCertificateSelector.single())
        .storePassword(new DirectPasswordProvider(password))
        .entryPassword(new DirectPasswordProvider(password))
        .fullChain(true)
        .provider(new BouncyCastleProvider())
        .build();

        DataObjectDesc obj = new DataObjectReference("")
                .withTransform(new EnvelopedSignatureTransform());
        SignedDataObjects dataObjs = new SignedDataObjects().withSignedDataObject(obj);

        XadesSigner signer = new XadesBesSigningProfile(kp).newSigner();
        signer.sign(dataObjs, elem);
        
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        DOMSource source = new DOMSource(doc);        
        StreamResult result = new StreamResult(new File("/Users/brayanloayza/Projects/quickf/api/src/main/resources/result.xml"));
        transformer.transform(source, result);
    }
}
