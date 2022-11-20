package com.creapption.quickf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import xades4j.production.BasicSignatureOptions;
import xades4j.production.Enveloped;
import xades4j.production.XadesBesSigningProfile;
import xades4j.production.XadesSigner;
import xades4j.providers.impl.FileSystemKeyStoreKeyingDataProvider;
import xades4j.providers.impl.KeyStoreKeyingDataProvider;
import xades4j.utils.DOMHelper;

import java.io.OutputStream;
import java.nio.file.Paths;

import org.w3c.dom.Node;

@RestController
public class HelloController {
    private static final String password = "Loayzaq2022*";
    private static final String pathToFilePlaceholder = "%ssrc%smain%sresources%s";
    private final static String path = String.format("%s%s", Paths.get("").toAbsolutePath(),
            String.format(pathToFilePlaceholder,
                    File.separator, File.separator,
                    File.separator, File.separator));

    /**
     * @return
     */
    @RequestMapping("/")
    public String hello() throws Exception {     
        signBes();
        return "Hello World!";
    }

    /**
     * @throws Exception
     */
    public static void signBes() throws Exception {
        Document doc = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse(new File(path + "factura_without_signature.xml"));
        Element elem = doc.getDocumentElement();
        DOMHelper.useIdAsXmlId(elem);

        // Document doc = getDocument();
        // Element elem = doc.getDocumentElement();

        FileSystemKeyStoreKeyingDataProvider kp = FileSystemKeyStoreKeyingDataProvider
                .builder("pkcs12", path + "LOAYZA_BRAYAN.p12", KeyStoreKeyingDataProvider.SigningCertificateSelector.single())
                .storePassword(new DirectPasswordProvider(password))
                .entryPassword(new DirectPasswordProvider(password))
                .fullChain(true)
                .build();

        XadesSigner signer = new XadesBesSigningProfile(kp)
                .withBasicSignatureOptions(new BasicSignatureOptions().includePublicKey(true)).newSigner();
        new Enveloped(signer).sign(elem);

        outputDocument(doc, "document.signed.bes.ec.xml");
    }

    protected static void outputDocument(Document doc, String fileName) throws Exception {
        File outDir = ensureOutputDir();
        FileOutputStream out = new FileOutputStream(new File(outDir, fileName));
        try {
            outputDOM(doc, out);
        } finally {
            out.close();
        }
    }

    protected static void outputDOM(Node dom, OutputStream os) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        tf.newTransformer().transform(
                new DOMSource(dom),
                new StreamResult(os));
    }

    private static File ensureOutputDir() {
        File dir = new File(path);
        dir.mkdir();
        return dir;
    }
}
