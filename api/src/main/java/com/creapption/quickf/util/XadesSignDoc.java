package com.creapption.quickf.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.InputSource;
import xades4j.production.BasicSignatureOptions;
import xades4j.production.Enveloped;
import xades4j.production.XadesBesSigningProfile;
import xades4j.production.XadesSigner;
import xades4j.providers.impl.FileSystemKeyStoreKeyingDataProvider;
import xades4j.providers.impl.KeyStoreKeyingDataProvider;
import xades4j.utils.DOMHelper;
import java.io.OutputStream;
import java.io.StringReader;

import org.w3c.dom.Node;

public class XadesSignDoc {
    // #region Constants
    private static final String KEYSTORETYPE_STRING = "pkcs12";
    // #endregion

    // #region Properties
    protected static String xmlFile;
    protected static String keyStorePath;
    protected static String password;
    // #endregion

    /**
     * Constructor XadesSignDoc - Signing documents with Xades method.
     * Currently Bes method only supported
     * 
     * @param signaturePath
     * @param signaturePassword
     * @param xmlToSign
     */
    public XadesSignDoc(String signaturePath, String signaturePassword, String xmltoSign) {
        super();
        xmlFile = xmltoSign;
        keyStorePath = signaturePath;
        password = signaturePassword;
    }

    /**
     * Sign xml documents with XadesBes method
     * 
     * @throws Exception
     */
    public void signBes(String outputFile) throws Exception {
        // Transforming the xmlFile string into Element
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xmlFile));
        Document doc = builder.parse(is);
        Element elem = doc.getDocumentElement();
        DOMHelper.useIdAsXmlId(elem);

        // getting the sign for certificate or .p12 file
        FileSystemKeyStoreKeyingDataProvider kp = FileSystemKeyStoreKeyingDataProvider
                .builder(KEYSTORETYPE_STRING, keyStorePath,
                        KeyStoreKeyingDataProvider.SigningCertificateSelector.single())
                .storePassword(new DirectPasswordProvider(password))
                .entryPassword(new DirectPasswordProvider(password))
                .fullChain(true)
                .build();

        // init the signer
        XadesSigner signer = new XadesBesSigningProfile(kp)
                .withBasicSignatureOptions(new BasicSignatureOptions().includePublicKey(true)).newSigner();
        new Enveloped(signer).sign(elem);

        // generates the signed doc
        outputDocument(doc, outputFile);
    }

    /**
     * Generates an output xml file with a specific fileName
     * 
     * @param doc
     * @param fileName
     * @throws Exception
     */
    protected static void outputDocument(Document doc, String fileName) throws Exception {
        File outDir = ensureOutputDir(fileName);
        FileOutputStream out = new FileOutputStream(new File(outDir, fileName));
        try {
            outputDOM(doc, out);
        } finally {
            out.close();
        }
    }

    /**
     * Executes the transformer from doc to OutputStream
     * 
     * @param dom
     * @param os
     * @throws Exception
     */
    protected static void outputDOM(Node dom, OutputStream os) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        tf.newTransformer().transform(
                new DOMSource(dom),
                new StreamResult(os));
    }

    /**
     * Method to ensure that path dir Exists
     * 
     * @return
     */
    private static File ensureOutputDir(String fileName) {
        File dir = new File(fileName);
        dir.mkdir();
        return dir;
    }
}
